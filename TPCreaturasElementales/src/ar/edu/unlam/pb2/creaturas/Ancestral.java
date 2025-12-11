package ar.edu.unlam.pb2.creaturas;

public class Ancestral extends Criatura {

	public Ancestral(String nombre, Afinidad afinidad, Integer energia) {
		super(nombre, afinidad, energia);
	}

	@Override
	public void entrenar() {
		this.energia += (int) (Math.random() * 21) + 30;
		
		//Eventualmente con las interacciones habra que testear esta condicion!!!
		if (this.energia < 100) {
			this.energia = 100;
		}
	}

	
}
