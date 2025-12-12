package ar.edu.unlam.pb2.maestro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.exceptions.MaestriaInsuficienteException;
import ar.edu.unlam.pb2.criaturas.*;
import ar.edu.unlam.pb2.exceptions.CriaturaNoRegistradaException;

public class MaestroElementalTest {

	private Maestro pablo;
	private Maestro gary;
	private Maestro alberto;
	private Criatura blastoise;

	@Before
	public void setUp() {
		pablo = new Maestro("Pablo", 15, Afinidad.FUEGO);
		gary = new Maestro("Gary", 5, Afinidad.TIERRA);
		alberto = new Maestro("Alberto", 20, Afinidad.AGUA);
		blastoise = new Domesticada("Blastoise", Afinidad.AGUA, 110);
	}

	@Test
	public void queSePuedaCrearUnMaestroConSusAtributos() {
		assertNotNull(pablo);
		assertEquals("Pablo", pablo.getNombre());
		assertEquals(15, pablo.getNivelDeMaestria(), 0.01);
		assertEquals(Afinidad.FUEGO, pablo.getAfinidad());
	}

	@Test
	public void queSePuedaAgregarUnaCriaturaAlMaestro() {

		pablo.agregarCriatura(blastoise);

		assertNotNull(pablo);
		assertEquals(1, pablo.getCriaturasACargo().size());
	}

	@Test
	public void queSePuedaAgregarUnaCriaturaASuRespectivoMaestroYVerificarQueSeHanSidoAsignadasCorrectamente() {

		Criatura patamon = new Domesticada("Patamon", Afinidad.AIRE, 120);

		pablo.agregarCriatura(blastoise);
		alberto.agregarCriatura(patamon);

		assertNotEquals(2, pablo.getCriaturasACargo().size());
		assertTrue(pablo.getCriaturasACargo().containsKey(blastoise.getNombre()));

		assertEquals(1, alberto.getCriaturasACargo().size());
		assertTrue(alberto.getCriaturasACargo().containsValue(patamon));
	}

	@Test
	public void queMaestroEntreneAUnaCriaturaAncestralCorrectamente() 
			throws MaestriaInsuficienteException {
		
		Criatura onix = new Ancestral("Onix", Afinidad.TIERRA, 120);
		
		pablo.agregarCriatura(onix);
		pablo.entrenarCriatura(onix);
		assertTrue(onix.getEnergia() > 110);
	}
	
	@Test
	public void queSiSeDaEntrenamientoExtremoACriaturaAncestralSeVuelvaInestable() 
			throws MaestriaInsuficienteException {
		
		Criatura onix = new Ancestral("Onix", Afinidad.TIERRA, 120);
		
		pablo.agregarCriatura(onix);
		pablo.entrenarCriatura(onix);
		assertTrue(onix.isInestable());
	}
	
	@Test
	public void queMaestroEntreneUnaCriaturaYSusValoresDeEnergiaCambienCorrectamente()
			throws MaestriaInsuficienteException {

		alberto.agregarCriatura(blastoise);
		alberto.entrenarCriatura(blastoise);

		assertTrue(blastoise.getEnergia() > 110);
	}
	
	@Test(expected = CriaturaNoRegistradaException.class)
	public void queUnMaestroNoPuedaTransformarLaCriaturaDeOtroMaestro() {

	    Maestro pablo = new Maestro("Pablo", 50, Afinidad.AGUA);
	    Maestro gary  = new Maestro("Gary", 50, Afinidad.TIERRA);

	    Criatura agumon = new Domesticada("Agumon", Afinidad.TIERRA, 100);

	    gary.agregarCriatura(agumon);

	    pablo.ritualAscensoDelViento(agumon);
	}
	
	@Test(expected = CriaturaNoRegistradaException.class)
	public void queLanceUncheckedExceptionSiMaestroTrataInteractuarConCriaturaQueNoExisteONoTiene() {
	    Criatura onix = new Domesticada("Onix", Afinidad.TIERRA, 120);
	    pablo.isTransformada(onix.getNombre());
	}

	@Test(expected = MaestriaInsuficienteException.class)
	public void queLanceCheckedExceptionSiMaestroNoCumpleConElMinimoNivelDeMaestriaAlEntrenar()
			throws MaestriaInsuficienteException {
		Criatura onix = new Domesticada("Onix", Afinidad.TIERRA, 120);

		gary.agregarCriatura(onix);
		gary.entrenarCriatura(onix);
	}

	@Test
	public void queMaestroPuedaPacificarUnaCriaturaQueSeHaVueltoInestable() {
		Criatura criatura = new Ancestral("Onix", Afinidad.TIERRA, 120);
		
		gary.agregarCriatura(criatura);

		gary.ritualLlamaInterna(criatura);
		assertTrue(criatura.isInestable());

		gary.pacificarCriatura(criatura);
		assertFalse(criatura.isInestable());
	}

	@Test
	public void queMaestroPuedaEncadenarTransformacionesDeUnaCriatura() {
		Criatura criatura = new Ancestral("Onix", Afinidad.TIERRA, 10);
		
		gary.agregarCriatura(criatura);

		criatura = gary.ritualAscensoDelViento(criatura);
		criatura = gary.ritualLlamaInterna(criatura);
		criatura = gary.ritualBendicionDelRio(criatura);

		assertEquals(Afinidad.AIRE, criatura.getAfinidad());
		assertTrue(criatura.isInestable());
		assertEquals(Integer.valueOf(20), criatura.getEnergia());

		criatura = gary.ritualVinculoTerrestre(criatura);

		assertEquals(Integer.valueOf(50), gary.getCriatura(criatura.getNombre()).getEnergia());
	}
	
	@Test
	public void queCuandoUnMaestroTransformeUnaCriaturaSeVerifiqueQueFueTransformada() {
		Maestro pablo = new Maestro("Pablo", 20, Afinidad.FUEGO);
		Criatura agumon = new Salvaje("Agumon",Afinidad.FUEGO, 120);
		
		pablo.agregarCriatura(agumon);
		pablo.ritualAscensoDelViento(agumon);
		
		assertTrue(pablo.isTransformada(agumon.getNombre()));
	}
	
	@Test
	public void queUnMaestroTengaCriaturaRegistradaCorrectamente() {
		Criatura agumon = new Salvaje("Agumon",Afinidad.FUEGO, 120);
		Criatura onix = new Ancestral("Onix", Afinidad.TIERRA, 120);
		
		gary.agregarCriatura(onix);
		pablo.agregarCriatura(agumon);
		
		assertTrue(pablo.hasCriatura(agumon));
		assertFalse(pablo.hasCriatura(onix));
	}
}
