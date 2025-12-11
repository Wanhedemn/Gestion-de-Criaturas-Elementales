package ar.edu.unlam.pb2.reportes;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import ar.edu.unlam.pb2.creaturas.Afinidad;
import ar.edu.unlam.pb2.creaturas.Criatura;
import ar.edu.unlam.pb2.maestro.Maestro;

public class Reporte {

	private List<Maestro> maestros;
	
	public Reporte(List<Maestro> maestros) {
		this.maestros = maestros;
	}
	
	public List<Criatura> listarTodasLasCriaturas() {
		List<Criatura> lista = new ArrayList<>();
		
		for (Maestro maestro : maestros) {
			lista.addAll(maestro.getCriaturasACargo().values());
		}
		
		return lista;
	}

	public Criatura getCriaturaConMayorEnergia() { 
		List<Criatura> lista = listarTodasLasCriaturas();
		
		if (lista.isEmpty()) {
			return null;
		}
		
		Criatura criaturaMaxNRG = lista.get(0);
		
		for (Criatura cria : lista) {
			if (cria.getEnergia() > criaturaMaxNRG.getEnergia()) {
				criaturaMaxNRG = cria;
			}
		}
		return criaturaMaxNRG;
	}
	
	public Maestro getMaestroConMasCriaturasTransformadas() {
	    Maestro maestroConMasCriasTransformadas = null;
	    int cantidadMax = -1;

	    for (Maestro maestro : maestros) {
	        int criasTransformadas = 0;

	        for (Criatura cria : maestro.getCriaturasACargo().values()) {
	            if (cria.isTransformada()) {
	                criasTransformadas++;
	            }
	        }

	        if (criasTransformadas > cantidadMax) {
	            cantidadMax = criasTransformadas;
	            maestroConMasCriasTransformadas = maestro;
	        }
	    }

	    return maestroConMasCriasTransformadas;
	}

	public Map<Afinidad, Integer> getCantidadPorAfinidad() {
		 Map<Afinidad, Integer> map = new HashMap<>();

		    for (Criatura cria : listarTodasLasCriaturas()) {
		        map.put(cria.getAfinidad(), map.getOrDefault(cria.getAfinidad(), 0) + 1);
		    }

		    return map;
	}

}
