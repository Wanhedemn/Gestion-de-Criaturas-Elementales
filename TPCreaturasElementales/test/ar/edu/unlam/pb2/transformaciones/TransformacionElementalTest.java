package ar.edu.unlam.pb2.transformaciones;

import static org.junit.Assert.*;

import org.junit.Test;
import ar.edu.unlam.pb2.creaturas.*;

public class TransformacionElementalTest {

	
	@Test
	public void queElDecoradorNoMantengaEstadoDuplicado() {
	    Criatura criatura = new Domesticada("Onix", Afinidad.TIERRA, 100);

	    Criatura decorador = new BendicionDelRio(criatura);

	    decorador.setEnergia(20);

	    assertEquals(Integer.valueOf(20), criatura.getEnergia());
	    assertEquals(Integer.valueOf(40), decorador.getEnergia());
	}
	
	// Como por la bendicion la energia se multiplica por 2 y entrenamos a domesticado 
	// siempre entre 30-50 puntos, siempre me va a dar arriba de 60 puntos
	@Test
	public void queAlTransformarABendicionDelRioDupliqueEnergiaAlEntrenar() {
	    Criatura criatura = new Domesticada("Blastoise", Afinidad.AGUA, 0);
	    criatura = new BendicionDelRio(criatura);

	    criatura.entrenar();

	    assertTrue(criatura.getEnergia() >= 60);
	}
	
	@Test
	public void queAlTransformarABendicionDelRioLlegueAlTopeYNoLoExceda() {
	    Criatura criatura = new Domesticada("Blastoise", Afinidad.AGUA, 120 );
	    criatura = new BendicionDelRio(criatura);

	    criatura.entrenar();

	    assertEquals(Integer.valueOf(180), criatura.getEnergia());
	}
	
	@Test
	public void queAlTransformarALlamaInternaAumenteLaEnergiaSiSuAfinidadEsFuego() {
		Criatura criatura = new Domesticada("Agumon", Afinidad.FUEGO, 120 );
		Criatura decorador = new LlamaInterna(criatura);
		
		//Volvi a verificar que el decorador no se duplique por curiosidad
		assertEquals(Integer.valueOf(120), criatura.getEnergia());
		assertEquals(Integer.valueOf(150), decorador.getEnergia());
	}

	@Test
	public void queAlTransformarALlamaInternaYSuAfinidadNoEsFuegoSeVuelvaInestableYNoCambieSuEnergia() {
		Criatura criatura = new Ancestral("Onix", Afinidad.TIERRA, 120 );
		criatura = new LlamaInterna(criatura);
		
		assertTrue(criatura.isInestable());
		assertEquals(Integer.valueOf(120), criatura.getEnergia());
	}
	
	@Test
	public void queAlTransformarALlamaInternaPuedaPacificarSuInestabilidad() {
		Criatura criatura = new Ancestral("Onix", Afinidad.TIERRA, 120 );
		criatura = new LlamaInterna(criatura);
		
		criatura.pacificar();
		
		assertFalse(criatura.isInestable());
	}
	
	@Test
	public void queAlTransformarAAscensoDelVientoCambieSuAfinidadTemporalmente() {
		Criatura criatura = new Domesticada("Onix", Afinidad.TIERRA, 120 );
		Criatura decorador = new AscensoDelViento(criatura);
		
		// De fondo la afinidad de la criatura nunca cambio, solo se muestra 
		// la "mascara" que en este ejemplo se ve en le da el decorador
		assertEquals(Afinidad.TIERRA, criatura.getAfinidad()); 
		assertEquals(Afinidad.AIRE, decorador.getAfinidad());
	}
	
	@Test
	public void queAlTransformarAVinculoTerrestreSuEnergiaNoPuedaQuedarEnMenosDe50Puntos() {
		Criatura criatura = new Domesticada("Patamon", Afinidad.AIRE, 30 );
		criatura = new VinculoTerrestre(criatura);
		
		assertEquals(Integer.valueOf(50), criatura.getEnergia());
	}
	
	@Test
	public void queSePuedanEncadenarTransformacionesEnUnaCriatura() {
	    Criatura criatura = new Ancestral("Onix", Afinidad.TIERRA, 120);
	    criatura = new BendicionDelRio(new LlamaInterna(new AscensoDelViento(criatura)));
	    
	    assertEquals(Afinidad.AIRE, criatura.getAfinidad());
	    assertTrue(criatura.isInestable());
	    assertEquals(Integer.valueOf(180) , criatura.getEnergia());
	}
	
	@Test
	public void queAlTransformarUnaCriaturaMuestreQueEstaTransformada() {
		 Criatura criatura = new Ancestral("Onix", Afinidad.TIERRA, 120);
		 criatura = new BendicionDelRio(new LlamaInterna(new AscensoDelViento(criatura)));
		 
		 assertTrue(criatura.isTransformada());
	}
}
