package ar.edu.unlam.pb2.transformaciones;

import ar.edu.unlam.pb2.criaturas.Criatura;

public class VinculoTerrestre extends TransformacionElemental {

	public VinculoTerrestre(Criatura criatura) {
		super(criatura);
	}

	@Override
	public Integer getEnergia() {
		Integer energiaActualizada = criaturaTransformada.getEnergia();

		if (energiaActualizada < 50) {
			criaturaTransformada.setEnergia(50);
			return 50;
		}
		return energiaActualizada;
	}

}
