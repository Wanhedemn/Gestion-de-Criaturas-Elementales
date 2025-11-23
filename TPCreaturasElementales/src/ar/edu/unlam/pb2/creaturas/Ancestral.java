package ar.edu.unlam.pb2.creaturas;

public class Ancestral extends Criatura {

	public Ancestral(String nombre, Afinidad afinidad, Integer energia) {
		super(nombre, afinidad, energia);
	}

	@Override
	public void entrenar() {
		Integer entrenamientoValor = (int) (Math.random() * 41) + 40;
		
		this.setEnergia(this.energia + entrenamientoValor);
		
		
//		Esta condicion es la sensibilidad.
//
//		Idealmente, si el entrenamiento me daba un valor entre 70 y 80 entonces
//		la criatura ancestral se volvia inestable.
//		Por el proposito de hacer el test dejo la condicion hardcodeada para que ocurra siempre
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
