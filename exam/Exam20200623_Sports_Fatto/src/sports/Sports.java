package sports;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

 
/**
 * Facade class for the research evaluation system
 *
 */
public class Sports {

	private Map<String,Activity> activities = new HashMap<>();
	private Map<String,Category> categories = new HashMap<>();
	private Map<String,Product> products = new HashMap<>();
	private int idRating = 0;
	private Map<Integer,Rating> ratings = new HashMap<>();
	
    //R1
    /**
     * Define the activities types treated in the portal.
     * The method can be invoked multiple times to add different activities.
     * 
     * @param actvities names of the activities
     * @throws SportsException thrown if no activity is provided
     */
    public void defineActivities (String... activities) throws SportsException {
    	
    	if(activities.length==0) throw new SportsException("no activity is provided");
    	
    	for(String nameActivity: activities) {
    		Activity activity = new Activity(nameActivity);
    		this.activities.put(nameActivity,activity);
    	}
    	
    	
    	
    }

    /**
     * Retrieves the names of the defined activities.
     * 
     * @return activities names sorted alphabetically
     */
    public List<String> getActivities() {
        return activities.values().stream().sorted(Comparator.comparing(Activity::getName)).map(Activity::getName).collect(Collectors.toList());
    }


    /**
     * Add a new category of sport products and the linked activities
     * 
     * @param name name of the new category
     * @param activities reference activities for the category
     * @throws SportsException thrown if any of the specified activity does not exist
     */
    public void addCategory(String name, String... linkedActivities) throws SportsException {
    	
    	for(String linkedActivity: linkedActivities) if(this.activities.get(linkedActivity)==null) throw new SportsException("activity has not been previously defined");
    		
    	Category category = new Category(name);
    	
    	for(String linkedActivity: linkedActivities) {
    		
    		category.newActivity(activities.get(linkedActivity));
    		activities.get(linkedActivity).newCategory(category);
    		
    	}
    	
    	
    	categories.put(name,category);
    	
    }

    /**
     * Retrieves number of categories.
     * 
     * @return categories count
     */
    public int countCategories() {
        return categories.size();
    }

    /**
     * Retrieves all the categories linked to a given activity.
     * 
     * @param activity the activity of interest
     * @return list of categories (sorted alphabetically)
     */
    public List<String> getCategoriesForActivity(String activity) {
        return activities.values().stream().filter(a->a.getName().equals(activity)).flatMap(a->a.getCategories().stream()).sorted(Comparator.comparing(Category::getName)).map(Category::getName).collect(Collectors.toList());
    }

    //R2
    /**
     * Add a research group and the relative disciplines.
     * 
     * @param name name of the research group
     * @param disciplines list of disciplines
     * @throws SportsException thrown in case of duplicate name
     */
    public void addProduct(String name, String activityName, String categoryName) throws SportsException {
    	
    	if(products.get(name)!=null) throw new SportsException("product with the same name already exists");
    	
    	Product product = new Product(name, activities.get(activityName), categories.get(categoryName));
    	
    	activities.get(activityName).newProduct(product);
    	categories.get(categoryName).newProduct(product);
    	
    	products.put(name,product);
    	
    }

    /**
     * Retrieves the list of products for a given category.
     * The list is sorted alphabetically.
     * 
     * @param categoryName name of the category
     * @return list of products
     */
    public List<String> getProductsForCategory(String categoryName){
        return categories.values().stream().filter(c->c.getName().equals(categoryName)).flatMap(c->c.getProducts().stream()).sorted(Comparator.comparing(Product::getName)).map(Product::getName).collect(Collectors.toList());
    }

    /**
     * Retrieves the list of products for a given activity.
     * The list is sorted alphabetically.
     * 
     * @param activityName name of the activity
     * @return list of products
     */
    public List<String> getProductsForActivity(String activityName){
        return activities.values().stream().filter(a->a.getName().equals(activityName)).flatMap(a->a.getProducts().stream()).sorted(Comparator.comparing(Product::getName)).map(Product::getName).collect(Collectors.toList());
    }

    /**
     * Retrieves the list of products for a given activity and a set of categories
     * The list is sorted alphabetically.
     * 
     * @param activityName name of the activity
     * @param categoryNames names of the categories
     * @return list of products
     */
    public List<String> getProducts(String activityName, String... categoryNames){
    	
    	List<String> categoriesName = new LinkedList<>();
    	
    	for(String cn: categoryNames) categoriesName.add(cn);
    	
        return products.values().stream().filter(p->p.getActivity().getName().equals(activityName)).filter(p->categoriesName.contains(p.getCategory().getName())).sorted(Comparator.comparing(Product::getName)).map(Product::getName).collect(Collectors.toList());
    }

    //    //R3
    /**
     * Add a new product rating
     * 
     * @param productName name of the product
     * @param userName name of the user submitting the rating
     * @param numStars score of the rating in stars
     * @param comment comment for the rating
     * @throws SportsException thrown numStars is not correct
     */
    public void addRating(String productName, String userName, int numStars, String comment) throws SportsException {
    	
    	if(numStars<0 || numStars>5) throw new SportsException("number of stars is not between 0 and 5 (included)");
    	
    	Rating rating = new Rating(products.get(productName), userName, numStars, comment, idRating);
    	
    	ratings.put(idRating++, rating);
    	products.get(productName).newRating(rating);
    	
    }



    /**
     * Retrieves the ratings for the given product.
     * The ratings are sorted by descending number of stars.
     * 
     * @param productName name of the product
     * @return list of ratings sorted by stars
     */
    public List<String> getRatingsForProduct(String productName) {
        return products.values().stream().filter(p->p.getName().equals(productName)).
        		flatMap(p->p.getRatings().stream()).
        		map(Rating::toString).
        		collect(Collectors.toList()).
                stream(). 
                sorted((str1, str2) -> {
                    String[] parts1 = str1.split(" : ");
                    String[] parts2 = str2.split(" : ");
                    
                    int value1 = Integer.parseInt(parts1[0]);
                    int value2 = Integer.parseInt(parts2[0]);

                    if (value1 != value2) {
                        return Integer.compare(value2, value1); // Sort by value in decreasing order
                    }
                    return parts1[1].compareTo(parts2[1]); // If values are equal, sort by name in alphabetical order
                }). 
                collect(Collectors.toList());
        		
    }


    //R4
    /**
     * Returns the average number of stars of the rating for the given product.
     * 
     * 
     * @param productName name of the product
     * @return average rating
     */
    public double getStarsOfProduct (String productName) {
        return products.get(productName).getRatings().stream().mapToDouble(Rating::getNumStars).average().orElse(0.0);
    }

    /**
     * Computes the overall average stars of all ratings
     *  
     * @return average stars
     */
    public double averageStars() {
        return ratings.values().stream().mapToDouble(Rating::getNumStars).average().orElse(0.0);

    }

    //R5 Statistiche
    /**
     * For each activity return the average stars of the entered ratings.
     * 
     * Activity names are sorted alphabetically.
     * 
     * @return the map associating activity name to average stars
     */
    public SortedMap<String, Double> starsPerActivity() {
        return activities.values().stream().
        		filter(a->a.isAvailable()).
        		collect(Collectors.toMap(Activity::getName, Activity::getAvgStarsProducts, (a1,a2)->a1, TreeMap::new));
    }

    /**
     * For each average star rating returns a list of
     * the products that have such score.
     * 
     * Ratings are sorted in descending order.
     * 
     * @return the map linking the average stars to the list of products
     */
    public SortedMap<Double, List<String>> getProductsPerStars () {
        return products.values().stream().
        		filter(p->p.getNumRatings()>0).
        		collect(Collectors.toMap(Product::getName,Product::getAvgNumStars,(p1,p2)->p1,HashMap::new)).
        		entrySet().stream().
        		collect(Collectors.groupingBy(
        										Map.Entry::getValue, 
        										()->new TreeMap<Double,List<String>>(Collections.reverseOrder()), 
     					 					    Collectors.mapping(
     					 					    					entry->entry.getKey(), 
     					 					    					Collectors.collectingAndThen(
     					 					    													Collectors.toList(),
     					 					    													list -> list.stream().sorted().collect(Collectors.toList())
     					 					    							                    )
     					 					    		          )
        									 )
        				)
        		;
    }

}