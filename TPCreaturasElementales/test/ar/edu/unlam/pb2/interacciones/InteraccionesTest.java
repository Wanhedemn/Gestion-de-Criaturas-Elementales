package ar.edu.unlam.pb2.interacciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.creaturas.*;
import ar.edu.unlam.pb2.transformaciones.*;

public class InteraccionesTest {
	
	private Interacciones inter;
	
	@Before
	public void setUp() {
		inter= new Interacciones();
	}

    @Test
    public void queSiCompartenAfinidadGanen10DeEnergiaAmbas() {
        Criatura c1 = new Domesticada("Aqua", Afinidad.AGUA, 50);
        Criatura c2 = new Domesticada("Rain", Afinidad.AGUA, 80);

        inter.interactuar(c1, c2);

        assertEquals((Integer)60, c1.getEnergia());
        assertEquals((Integer)90, c2.getEnergia());
    }

    @Test
    public void queSiSonOpuestasAmbasQuedenInestables() {
        Criatura fuego = new Salvaje("Charmander", Afinidad.FUEGO, 100);
        Criatura agua = new Salvaje("Squirtle", Afinidad.AGUA, 100);

        inter.interactuar(fuego, agua);

        assertTrue(fuego.isInestable());
        assertTrue(agua.isInestable());
    }

    @Test
    public void queAncestralDomineLaInteraccion() {
        Criatura ancestral = new Ancestral("Groudon", Afinidad.TIERRA, 120);
        Criatura comun = new Domesticada("Pidgey", Afinidad.AIRE, 40);

        inter.interactuar(ancestral, comun);

        assertEquals((Integer)140, ancestral.getEnergia());

        assertEquals((Integer)25, comun.getEnergia());
    }

    @Test
    public void queLaCriaturaNoAncestralNoBajeDeCero() {
        Criatura ancestral = new Ancestral("Lugia", Afinidad.AIRE, 150);
        Criatura debil = new Domesticada("Wurmple", Afinidad.TIERRA, 5);

        inter.interactuar(ancestral, debil);

        assertEquals((Integer)170, ancestral.getEnergia());
        assertEquals((Integer)0, debil.getEnergia()); // no baja de 0
    }

    @Test
    public void queLasInteraccionesFuncionenConTransformacionesDecorator() {
        Criatura base = new Salvaje("Torchic", Afinidad.FUEGO, 70);

        Criatura transformada = new LlamaInterna(base); 

        Criatura agua = new Salvaje("Mudkip", Afinidad.AGUA, 60);

        inter.interactuar(transformada, agua);

        assertTrue(transformada.isInestable());
        assertTrue(agua.isInestable());
    }

    @Test
    public void queDecoratorNoAfecteDominioAncestral() {
        Criatura ancestral = new Ancestral("Rayquaza", Afinidad.AIRE, 100);

        // Criatura común, pero transformada con AscensoDelViento (Decorator)
        Criatura decorada = new AscensoDelViento(new Domesticada("Eevee", Afinidad.TIERRA, 50));

        inter.interactuar(ancestral, decorada);

        assertEquals((Integer)120, ancestral.getEnergia());
        assertEquals((Integer)35, decorada.getEnergia());
    }
}