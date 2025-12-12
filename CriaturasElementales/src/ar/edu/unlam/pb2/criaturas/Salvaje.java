package ar.edu.unlam.pb2.criaturas;

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
