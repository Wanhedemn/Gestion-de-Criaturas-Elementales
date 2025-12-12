package ar.edu.unlam.pb2.criaturas;

public class Domesticada extends Criatura {

	public Domesticada(String nombre, Afinidad afinidad, Integer energia) {
		super(nombre, afinidad, energia);
		this.inestable = false;
	}

	@Override
	public void entrenar() {
		this.energia += (int) (Math.random() * 21) + 30;
	}
	
	@Override
	public void setInestable(Boolean Inestable) {
		
	}
}
