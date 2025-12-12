package ar.edu.unlam.pb2.criaturas;

public class Ancestral extends Criatura {

	public Ancestral(String nombre, Afinidad afinidad, Integer energia) {
		super(nombre, afinidad, energia);
	}

	@Override
	public void entrenar() {
		Integer entrenamientoValor = (int) (Math.random() * 41) + 40;
		
		this.setEnergia(this.energia + entrenamientoValor);
		
		if (entrenamientoValor > 39) {
			this.setInestable(true);
		}
	}

	@Override
	public void setEnergia(Integer energia) {		
		 if (energia < 100) {
			 energia = 100;
		 }
		 
		 this.energia = energia;
	}
	
}
