package ar.edu.unlam.pb2.creaturas;

public abstract class TransformacionElemental extends Criatura{
	
	protected Criatura criaturaTransformada;

	public TransformacionElemental(Criatura criatura) {
		super(criatura.getNombre(), criatura.getAfinidad(), criatura.getEnergia());

		this.criaturaTransformada=criatura;
	}

	@Override
	public void pacificar() {
		criaturaTransformada.pacificar();
	}
	
	@Override
	public Integer getEnergia() {
		return this.criaturaTransformada.getEnergia();
	}
	
	@Override
	public Afinidad getAfinidad() {
		return this.criaturaTransformada.getAfinidad();
	}
	
	@Override
	public Boolean isInestable() {
		return this.criaturaTransformada.isInestable();
	}
	
	@Override
	public void setInestable(Boolean inestable) {
		this.criaturaTransformada.setInestable(inestable);
	}
}
