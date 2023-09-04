package discounts;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Discounts {

	private HashMap<Integer,Card> cards = new HashMap<>();
	private int idCard = 1;
	private HashMap<String,Product> products = new HashMap<>();
	private HashMap<String,Category> categories = new HashMap<>();
	private List<Discount> discounts = new LinkedList<>();
	private HashMap<Integer,Purchase> purchases = new HashMap<>();
	private int idPurchase = 1;
	//R1
	public int issueCard(String name) {
	    
		Card card = new Card(name,idCard);
		
		cards.put(idCard,card);
		
		return idCard++;
	}
	
    public String cardHolder(int cardN) {
        return cards.get(cardN).getName();
    }
    

	public int nOfCards() {
	       return cards.size();

	}
	
	//R2
	public void addProduct(String categoryId, String productId, double price) 
			throws DiscountsException {
		
		if(products.get(productId)!=null) throw new DiscountsException();
		
		if(categories.get(categoryId)==null) {
			Category category = new Category(categoryId);
			categories.put(categoryId, category);
			Product product = new Product(category, productId, price);
			products.put(productId, product);
			categories.get(categoryId).newProduct(product);
		}else {
			Product product = new Product(categories.get(categoryId), productId, price);
			products.put(productId, product);
			categories.get(categoryId).newProduct(product);
		}
				
	}
	
	public double getPrice(String productId) 
			throws DiscountsException {
		
		if(products.get(productId)==null) throw new DiscountsException();
		
        return products.get(productId).getPrice();
	}

	public int getAveragePrice(String categoryId) throws DiscountsException {
		
		if(categories.get(categoryId)==null) throw new DiscountsException();

		return categories.get(categoryId).getAvgPrice();
	}
	
	//R3
	public void setDiscount(String categoryId, int percentage) throws DiscountsException {
		
		if(categories.get(categoryId)==null) throw new DiscountsException();
		if(percentage<0 || percentage>50) throw new DiscountsException();
		
		Discount discount = new Discount(categories.get(categoryId), percentage);
		
		categories.get(categoryId).setDiscount(discount);
		
		for(Product product: categories.get(categoryId).getProducts()) {
			product.setDiscount(discount);
		}
		
		discounts.add(discount);
		
	}

	public int getDiscount(String categoryId) {
		if(categories.get(categoryId).getDiscount()==null) return 0;
        return categories.get(categoryId).getDiscount().getPercentage();

	}

	//R4
	public int addPurchase(int cardId, String... items) throws DiscountsException {
		
		List<Item> itms = new LinkedList<>();
		
		for(String item: items) {
			String splitItem[] = item.split(":");
			String productId = splitItem[0];
			int n = Integer.parseInt(splitItem[1]);
			
			if(products.get(productId)==null) throw new DiscountsException();
			
			Item i = new Item(products.get(productId), n);
			
			itms.add(i);
			
		}
		
		Purchase purchase = new Purchase(cards.get(cardId), itms, idPurchase);
		
		purchases.put(idPurchase, purchase);
		
        return idPurchase++;
	}

	public int addPurchase(String... items) throws DiscountsException {
		
		List<Item> itms = new LinkedList<>();
		
		for(String item: items) {
			String splitItem[] = item.split(":");
			String productId = splitItem[0];
			int n = Integer.parseInt(splitItem[1]);
			
			if(products.get(productId)==null) throw new DiscountsException();
			
			Item i = new Item(products.get(productId), n);
			
			itms.add(i);
			
		}
		
		Purchase purchase = new Purchase(itms, idPurchase);
		
		purchases.put(idPurchase, purchase);
		
        return idPurchase++;
        
	}
	
	public double getAmount(int purchaseCode) {
        return purchases.get(purchaseCode).getAmount();
	}
	
	public double getDiscount(int purchaseCode)  {
        return purchases.get(purchaseCode).getDiscount();
	}
	
	public int getNofUnits(int purchaseCode) {
        return purchases.get(purchaseCode).getItems().stream().mapToInt(Item::getN).sum();
	}
	
	//R5
	public SortedMap<Integer, List<String>> productIdsPerNofUnits() {
        return purchases.values().stream()
        		.flatMap( p -> p.getItems().stream())
        		.collect(Collectors.groupingBy(i->i.getProduct().getId(), HashMap::new, Collectors.summingInt(Item::getN)))
        		.entrySet().stream().
        		collect(Collectors.groupingBy(Map.Entry::getValue, TreeMap::new, Collectors.collectingAndThen(Collectors.mapping(Map.Entry::getKey, Collectors.toList()), list->list.stream().sorted().collect(Collectors.toList()))))
				;
	}
	
	public SortedMap<Integer, Integer> totalPurchasePerCard() {
        return purchases.values().stream()
        		.filter( p -> p.getCard()!=null)
        		.collect(Collectors.groupingBy(
        										p -> p.getCard().getId(),
        										TreeMap::new,
        										Collectors.summingInt(purchase -> (int) purchase.getAmount())
        									  )
        				);
	}
	
	public int totalPurchaseWithoutCard() {
        return purchases.values().stream().
        		filter(p->p.getCard()==null).
        		mapToInt(purchase -> (int) Math.ceil(purchase.getAmount()-0.5)).sum();
	}
	
	public SortedMap<Integer, Integer> totalDiscountPerCard() {
        return purchases.values().stream()
        		.filter(p->p.getCard()!=null)
        		.collect(Collectors.groupingBy(p->p.getCard().getId(), TreeMap::new, Collectors.summingInt(p->(int) Math.floor(p.getDiscount()+0.5))))
        		;
	}


}
