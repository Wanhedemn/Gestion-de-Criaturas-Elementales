package ar.edu.unlam.pb2.creaturas;

public class AscensoDelViento extends TransformacionElemental{

	public AscensoDelViento(Criatura criatura) {
		super(criatura);
	}

	@Override
	public Afinidad getAfinidad() {
		return Afinidad.AIRE;
	}
	
}
