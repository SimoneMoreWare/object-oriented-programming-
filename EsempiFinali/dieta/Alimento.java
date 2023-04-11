package dieta;
class Alimento implements ElementoNutritivo, Comparable<Alimento> {
	protected String nome;	 		protected double calorie;
	protected double proteine;  	protected double carboidrati;
	protected double grassi; 

	  public int compareTo(Alimento a) {
			if (calorie == a.calorie) return this.nome.compareTo(a.nome);
			return (int) (calorie - a.calorie);
	  }
	  Alimento(String nome, double calorie,
	  double proteine, double carboidrati,
	  double grassi) {
		  this.nome = nome;
		  this.calorie = calorie;
		  this.proteine = proteine;
		  this.carboidrati = carboidrati;
		  this.grassi = grassi;
	  }
	public double getCalorie() {return calorie;}
	public double getCarboidrati() {return carboidrati;}
	public double getGrassi() {return grassi;}
	public String getNome() {return nome;}
	public double getProteine() {return proteine;}
	protected Alimento (String nome) {this.nome = nome;}

}
