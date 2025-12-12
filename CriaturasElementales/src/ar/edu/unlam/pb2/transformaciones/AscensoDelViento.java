package ar.edu.unlam.pb2.transformaciones;

import ar.edu.unlam.pb2.criaturas.Afinidad;
import ar.edu.unlam.pb2.criaturas.Criatura;

public class AscensoDelViento extends TransformacionElemental {

	public AscensoDelViento(Criatura criatura) {
		super(criatura);
	}

	@Override
	public Afinidad getAfinidad() { 
		return Afinidad.AIRE;
	}
}
