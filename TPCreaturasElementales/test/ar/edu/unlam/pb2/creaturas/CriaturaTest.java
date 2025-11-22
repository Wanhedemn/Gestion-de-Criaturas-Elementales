package ar.edu.unlam.pb2.creaturas;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.exceptions.ExcesoDeEnergiaRuntimeException;
import ar.edu.unlam.pb2.exceptions.MaestriaInsuficienteException;

public class CriaturaTest {
 
	@Test 
	public void queSePuedaCrearUnaCriaturaDomesticada() {
		Criatura cria = new Domesticada("Blastoise", Afinidad.AGUA, 100);
		
		assertNotNull(cria);
	}
	
	@Test
	public void queSePuedaCrearUnaCriaturaYConsultarSusAtributos() {
		Criatura cria = new Domesticada("Blastoise", Afinidad.AGUA, 100);
		
		assertEquals("Blastoise", cria.getNombre());
		assertEquals(Afinidad.AGUA, cria.getAfinidad());
		assertEquals(Integer.valueOf(100), cria.getEnergia());
		assertFalse(cria.isInestable());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void queNoSePuedaCrearUnaCriaturaConMenosDe0PuntosDeEnergia() {
		@SuppressWarnings("unused")
		Criatura cria = new Salvaje("Agumon", Afinidad.FUEGO, -10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void queNoSePuedaCrearUnaCriaturaConMasDe200PuntosDeEnergia() {
		@SuppressWarnings("unused")
		Criatura cria = new Salvaje("Agumon", Afinidad.FUEGO, 310);
	}
	
	@Test(expected = ExcesoDeEnergiaRuntimeException.class)
	public void queLanceUncheckedExceptionAlEntrenarUnaCriaturaSalvajeYSupereLos200PuntosDeEnergia() throws MaestriaInsuficienteException {
        Criatura cria = new Salvaje("Agumon", Afinidad.FUEGO, 190);
        
        cria.entrenar();
	}
	
	@Test
	public void queUnaCriaturaDomesticadaNuncaSeaInestable() {
		Criatura cria = new Domesticada("Blastoise", Afinidad.AGUA, 100);
		cria.setInestable(true);
		
		assertFalse(cria.isInestable());
	}
	
	@Test
	public void queUnaCriaturaComienceSinIndicarQueHaSidoTransformada() {
		Criatura cria = new Domesticada("Blastoise", Afinidad.AGUA, 100);
		assertFalse(cria.isInestable());
	}
	
}
