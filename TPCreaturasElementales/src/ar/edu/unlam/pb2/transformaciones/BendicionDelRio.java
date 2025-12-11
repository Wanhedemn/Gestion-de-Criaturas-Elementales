package ar.edu.unlam.pb2.transformaciones;

import ar.edu.unlam.pb2.criaturas.Criatura;

public class BendicionDelRio extends TransformacionElemental{

	public BendicionDelRio(Criatura criatura) {
		super(criatura);
	}

	@Override
	public Integer getEnergia() {
		Integer energiaActualizada= criaturaTransformada.getEnergia() * 2;
		
		if(energiaActualizada>180) {
			energiaActualizada=180; //lo limitamos al maximo de energia
		}
		return energiaActualizada;
	}
}
