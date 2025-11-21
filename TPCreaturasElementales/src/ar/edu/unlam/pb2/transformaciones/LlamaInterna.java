package ar.edu.unlam.pb2.transformaciones;

import ar.edu.unlam.pb2.creaturas.Afinidad;
import ar.edu.unlam.pb2.creaturas.Criatura;

public class LlamaInterna extends TransformacionElemental {

	public LlamaInterna(Criatura criatura) {
		super(criatura);

		if (criaturaTransformada.getAfinidad() != Afinidad.FUEGO) {
			criaturaTransformada.setInestable(true);
		}
	}

	@Override
	public Integer getEnergia() {
		if (criaturaTransformada.getAfinidad() == Afinidad.FUEGO) {
			return criaturaTransformada.getEnergia() + 30;
		}
		return criaturaTransformada.getEnergia();
	}

}
