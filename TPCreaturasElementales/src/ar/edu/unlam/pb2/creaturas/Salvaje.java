package ar.edu.unlam.pb2.creaturas;

import ar.edu.unlam.pb2.exceptions.ExcesoDeEnergiaRuntimeException;

public class Salvaje extends Criatura {

	public Salvaje(String nombre, Afinidad afinidad, Integer energia) {
		super(nombre, afinidad, energia);
	}

	@Override
	public void entrenar() {
		Integer dado = (int) (Math.random() * 6) + 1;
		Integer entrenamientoEstable = (int) (Math.random() * 21) + 15;
		Integer entrenamientoInestable = (int) (Math.random() * 11) + 35;
//		
//		Lo impredecible de la criatura de tipo salvaje lo tomo como que tiene chances de 
//		realizar un entrenamiento que puede ser mas beneficioso o peor que el de los otros tipos
//		
//		Especificamente como el enunciado dice que "puede", dando a entender que no ocurre siempre,
//		por eso hago un "dado de 6 caras" que si da mas de 4 entonces le de el entrenamiento inestable exclusivo del salvaje
//		
		if (dado > 4) {
			this.energia += entrenamientoInestable;
		} 
		else {
			this.energia += entrenamientoEstable;
		}
		
		if (this.energia > 200) {
			throw new ExcesoDeEnergiaRuntimeException(this.getNombre() + " ha excedido los 200 puntos de energia");
		}
	}
	
}
