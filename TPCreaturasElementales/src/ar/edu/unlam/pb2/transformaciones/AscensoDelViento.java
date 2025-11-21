package ar.edu.unlam.pb2.transformaciones;

import ar.edu.unlam.pb2.creaturas.Afinidad;
import ar.edu.unlam.pb2.creaturas.Criatura;

public class AscensoDelViento extends TransformacionElemental {

	public AscensoDelViento(Criatura criatura) {
		super(criatura);
	}

	@Override
	public Afinidad getAfinidad() { 
		return Afinidad.AIRE;
	}

	// cuando se quiera obtener la afinidad va a ser siempre aire aunque en realidad
	// es temporal porque no le establecemos esa afinidad, simplemente lo forzamos a
	// que sea esa
}
