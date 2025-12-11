package ar.edu.unlam.pb2.reportes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.criaturas.Afinidad;
import ar.edu.unlam.pb2.criaturas.Ancestral;
import ar.edu.unlam.pb2.criaturas.Criatura;
import ar.edu.unlam.pb2.criaturas.Domesticada;
import ar.edu.unlam.pb2.criaturas.Salvaje;
import ar.edu.unlam.pb2.maestro.Maestro;

public class ReporteTest {
	
	private Maestro gary;
	private Maestro pablo;
	private Maestro roger;
	private Criatura onix;
	private Criatura blastoise;
	private Criatura agumon;

	@Before
	public void SetUp() {
		gary = new Maestro("Gary", 5, Afinidad.TIERRA);
		pablo = new Maestro("Pablo", 20, Afinidad.FUEGO);
		roger = new Maestro("Roger", 20, Afinidad.FUEGO);
	    onix = new Ancestral("Onix", Afinidad.TIERRA, 10);
	    blastoise = new Domesticada("Blastoise",Afinidad.AGUA, 100);
	    agumon = new Salvaje("Agumon",Afinidad.FUEGO, 120);
	}
	
	@Test
	public void queListeTodasLasCriaturasRegistradasPorTodosLosMaestros() {
		gary.agregarCriatura(onix);
		pablo.agregarCriatura(blastoise);
		pablo.agregarCriatura(agumon);
		
		Reporte reporte = new Reporte(Arrays.asList(gary, pablo));
		
		List<Criatura> criaturas = reporte.listarTodasLasCriaturas();
		
		assertEquals(3, criaturas.size());
	}
	
	@Test
	public void queObtengaLaCriaturaConMayorEnergiaTotal() {
		gary.agregarCriatura(onix);
		gary.agregarCriatura(blastoise);
		gary.agregarCriatura(agumon);
		
		Reporte reporte = new Reporte(List.of(gary));
		Criatura criaturaMaxNRG = reporte.getCriaturaConMayorEnergia();
		
		assertEquals(criaturaMaxNRG, gary.getCriatura("Agumon"));
	}
	
	@Test
	public void queDevuelvaNuloSiLaListaSeEncuentraVaciaAlConsultarCriaturaMayorEnergia() {
		Reporte reporte = new Reporte(List.of(gary));
		Criatura criaturaMaxNRG = reporte.getCriaturaConMayorEnergia();
		
		assertNull(criaturaMaxNRG);
	}
	
	@Test
	public void queDetermineQueMaestroTieneMasCriaturasTransformadas() {
		gary.agregarCriatura(onix);
		roger.agregarCriatura(blastoise);
		
		pablo.agregarCriatura(agumon);
		pablo.ritualAscensoDelViento(agumon);
		
		Reporte reporte = new Reporte(Arrays.asList(gary, pablo, roger));
		
		assertEquals("Pablo", reporte.getMaestroConMasCriaturasTransformadas().getNombre());
	}
	
	@Test
	public void queSeObtengaUnMapaConLaCantidadDeCriaturasPorAfinidad() {
		Criatura criatura1 = new Domesticada("Cria1", Afinidad.FUEGO, 110);
		Criatura criatura2 = new Domesticada("Cria2", Afinidad.FUEGO, 110);
		Criatura criatura3 = new Domesticada("Cria3", Afinidad.AGUA, 110);
		
		gary.agregarCriatura(onix);
		roger.agregarCriatura(blastoise);
		pablo.agregarCriatura(agumon);
		gary.agregarCriatura(criatura1);
		gary.agregarCriatura(criatura2);
		gary.agregarCriatura(criatura3);

		Reporte reporte = new Reporte(List.of(gary, roger, pablo));
		
		Map<Afinidad, Integer> map = reporte.getCantidadPorAfinidad();
		
		assertEquals(3, map.get(Afinidad.FUEGO).intValue());
		assertEquals(2, map.get(Afinidad.AGUA).intValue());
		assertEquals(1, map.get(Afinidad.TIERRA).intValue());
	}
}
