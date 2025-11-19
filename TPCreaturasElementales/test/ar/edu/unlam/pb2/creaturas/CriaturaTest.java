package ar.edu.unlam.pb2.creaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriaturaTest {
 
	@Test 
	public void queSePuedaCrearUnaCriaturaDomesticada() {
		Criatura cria = new Domesticada("Michi", Afinidad.AGUA, 100);
		
		assertNotNull(cria);
	}
	
	@Test
	public void queSePuedaCrearUnaCriaturaYConsultarSusAtributos() {
		Criatura cria = new Domesticada("Michi", Afinidad.AGUA, 100);
		
		assertEquals("Michi", cria.getNombre());
		assertEquals(Afinidad.AGUA, cria.getAfinidad());
		assertEquals(Integer.valueOf(100), cria.getEnergia());
		assertFalse(cria.isInestable());
	}
	
	@Test
	public void queSePuedaCrearUnMaestro() {
		
	}
	
	@Test
	public void queSePuedaCrearUnMaestroYRegistrarUnaCriaturaASuCargo() {
		
	}
	
	
	
	
	//reservado para copy paste

	@Test
	public void x() {
		
	}
}
