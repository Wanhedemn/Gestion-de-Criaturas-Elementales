package ar.edu.unlam.pb2.interacciones;

import ar.edu.unlam.pb2.creaturas.Afinidad;
import ar.edu.unlam.pb2.creaturas.Ancestral;
import ar.edu.unlam.pb2.creaturas.Criatura;
import ar.edu.unlam.pb2.creaturas.Domesticada;

public class Interacciones {

	public void interactuar(Criatura a, Criatura b) {

		if (a instanceof Ancestral || b instanceof Ancestral) {
			interaccionConAncestral(a, b);
			return;
		}
		
		if (a.getAfinidad() == b.getAfinidad()) {
			a.setEnergia(a.getEnergia() + 10);
			b.setEnergia(b.getEnergia() + 10);
			return;
		}

		if (sonOpuestas(a.getAfinidad(), b.getAfinidad())) {
			if (!(a instanceof Domesticada)) {
		        a.setInestable(true);
		    }

		    if (!(b instanceof Domesticada)) {
		        b.setInestable(true);
		    }
		}

	}

	private boolean sonOpuestas(Afinidad a, Afinidad b) {
		if ((a == Afinidad.AGUA && b == Afinidad.FUEGO) || (a == Afinidad.FUEGO && b == Afinidad.AGUA)) {
			return true;
		} else if ((a == Afinidad.AIRE && b == Afinidad.TIERRA) || (a == Afinidad.TIERRA && b == Afinidad.AIRE)) {
			return true;
		}
		return false;
	}

	private void interaccionConAncestral(Criatura a, Criatura b) {
		Criatura ancestral;
		Criatura otra;

		if (a instanceof Ancestral) { // definimos cual va a ser la ancestral
			ancestral = a;
			otra = b;
		} else {
			ancestral = b;
			otra = a;
		}

		ancestral.setEnergia(ancestral.getEnergia() + 20);

		Integer energiaRestante = otra.getEnergia() - 15;
		if (energiaRestante < 0)
			energiaRestante = 0;

		otra.setEnergia(energiaRestante);
	}
}
