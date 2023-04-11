package competenze;
class Competenza {
	private String nome;
	private int nA = 0; private int nU = 0;
	Competenza(String nome) {this.nome = nome;} 
	public String toString(){return nome + ":" + " nA=" + nA + " nU=" + nU;}
	void incrNA() {nA++;}
	void incrNU() {nU++;}
	String getNome() {return nome;}
	int getNA() {return nA;}
	int getNU() {return nU;}
}
