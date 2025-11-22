package ar.edu.unlam.pb2.maestro;

import java.util.Map;
import java.util.HashMap;

import ar.edu.unlam.pb2.creaturas.Afinidad;
import ar.edu.unlam.pb2.creaturas.Criatura;
import ar.edu.unlam.pb2.exceptions.CriaturaNoRegistradaException;
import ar.edu.unlam.pb2.exceptions.MaestriaInsuficienteException;
import ar.edu.unlam.pb2.transformaciones.*;

public class Maestro {

	private String nombre;
	private Integer nivelDeMaestria;
	private Afinidad afinidad;
	private Map<String, Criatura> criaturasACargo = new HashMap<>(); //el string es para el nombre de la criatura
	
	public Maestro(String nombre, Integer nivel, Afinidad afinidad) {
		this.nombre=nombre;
		this.nivelDeMaestria=nivel;
		this.afinidad=afinidad;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public Integer getNivelDeMaestria() {
		return nivelDeMaestria;
	}

	public Afinidad getAfinidad() {
		return afinidad;
	}

	public Map<String, Criatura> getCriaturasACargo() {
		return criaturasACargo;
	}
	
	public void agregarCriatura(Criatura criatura) {
		this.criaturasACargo.put(criatura.getNombre(), criatura);
	}
	
	private void validarCriaturaRegistradaAMaestro(Criatura criatura) {
		if (!criaturasACargo.containsKey(criatura.getNombre())) {
	        throw new CriaturaNoRegistradaException(
	            "La criatura " + criatura.getNombre() + " no pertenece al maestro " + this.getNombre()
	        );
	    }
	}
	
	private void validarCriaturaRegistradaAMaestro(String nombre) {
		if (criaturasACargo.get(nombre) == null) {
			throw new CriaturaNoRegistradaException(
		            "La criatura " + nombre + " no pertenece al maestro " + this.getNombre()
		    );
		}
	}
	

	public void entrenarCriatura(Criatura criaturaAEntrenar) throws MaestriaInsuficienteException{
		validarCriaturaRegistradaAMaestro(criaturaAEntrenar);
		
		if(this.nivelDeMaestria<20) { // solo puse un numero simbolico, es para probar nada mas
			throw new MaestriaInsuficienteException(
					"El nivel del maestro " + this.nombre + " es insuficiente para realizar el entrenamiento"
			);
		}
		criaturaAEntrenar.entrenar();
	}
	
	public void pacificarCriatura(Criatura criatura) {
		validarCriaturaRegistradaAMaestro(criatura);
		
		criatura.pacificar();
	}
	
	public Criatura ritualBendicionDelRio(Criatura criatura) {
		validarCriaturaRegistradaAMaestro(criatura);
		
		Criatura transformada = new BendicionDelRio(criatura);
		
		criaturasACargo.put(criatura.getNombre(), transformada);
		
		return transformada;	
	}
	
	public Criatura ritualLlamaInterna(Criatura criatura) {
		validarCriaturaRegistradaAMaestro(criatura);
		
		Criatura transformada = new LlamaInterna(criatura);
		
		criaturasACargo.put(criatura.getNombre(), transformada);
		
		return transformada;
	}
	
	public Criatura ritualVinculoTerrestre(Criatura criatura) {
		validarCriaturaRegistradaAMaestro(criatura);
		
		Criatura transformada = new VinculoTerrestre(criatura);
		
		criaturasACargo.put(criatura.getNombre(), transformada);
		
		return transformada;
	}
	
	public Criatura ritualAscensoDelViento(Criatura criatura) {
		validarCriaturaRegistradaAMaestro(criatura);
		
		Criatura transformada = new AscensoDelViento(criatura);
		
		criaturasACargo.put(criatura.getNombre(), transformada);
		
		return transformada;
	}
	
	public Boolean isTransformada(String nombre) {
		validarCriaturaRegistradaAMaestro(nombre);
		return criaturasACargo.get(nombre).isTransformada();
	}
	
	
	public Criatura getCriatura(String nombre) {
		validarCriaturaRegistradaAMaestro(nombre);
		return criaturasACargo.get(nombre);
	}
	
	public boolean hasCriatura(Criatura criatura) {
	    return this.criaturasACargo.containsKey(criatura.getNombre());
	}
}
