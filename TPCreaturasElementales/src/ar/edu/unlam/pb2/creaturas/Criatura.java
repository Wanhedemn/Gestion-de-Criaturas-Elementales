package ar.edu.unlam.pb2.creaturas;

public abstract class Criatura {
	
	private String nombre;
	private Afinidad afinidad;
	protected Integer energia;
	private Boolean inestable = false;

	public Criatura(String nombre, Afinidad afinidad, Integer energia) {
		this.nombre = nombre;
		this.afinidad = afinidad;
		this.energia = energia;
	}
	
	public void pacificar() { //sirve para que podamos cambiarle el estado
	    if (this.inestable) {
	        this.inestable = false;
	    }
	}

	public String getNombre() {
		return nombre;
	}

	public Afinidad getAfinidad() {
		return afinidad;
	}

	public Integer getEnergia() {
		return energia;
	}
	
	public Boolean isInestable() {
		return inestable;
	}

	public void setInestable(Boolean inestable) {
		this.inestable = inestable;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

}
