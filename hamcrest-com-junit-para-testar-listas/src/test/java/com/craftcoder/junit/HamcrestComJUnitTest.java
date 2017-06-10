package com.craftcoder.junit;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

public class HamcrestComJUnitTest {

	@Test
	public void deveriaVerificarElementosDeUmaListaUsandoSomenteJUnit() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
		
		assertEquals("JUnit", artigos.get(0));
		assertEquals("CDI", artigos.get(1));
		assertEquals("Java 8", artigos.get(2));
		assertEquals("Spring", artigos.get(3));
	}
	
	@Test
	public void deveriaVerificarElementosUsandoHamcrest() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
	
		MatcherAssert.assertThat(artigos, CoreMatchers.hasItems("JUnit", "CDI", "Java 8", "Spring"));
	}
	
	@Test
	public void deveriaVerificarElementosUsandoHamcrestComStaticImport() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
		
		assertThat(artigos, hasItems("JUnit", "CDI", "Java 8", "Spring"));
	}
	
	@Test
	public void deveriaVerificarElementosUsandoHamcrestComStaticImportNaoImportandoAOrdem() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
		
		assertThat(artigos, hasItems("JUnit", "CDI", "Spring", "Java 8"));
	}
	
	@Test
	public void deveriaVerificarOTamanhoDaLista() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
		
		assertThat(artigos, Matchers.hasSize(4));
	}
	
	@Test
	public void deveriaVerificarOTamanhoDaListaDeOutraForma() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
		
		assertThat(artigos.size(), Matchers.is(4));
	}
	
	@Test
	public void deveriaVerificarSeAListaContemElementosNaOrdemEspecificada() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
		
		assertThat(artigos, Matchers.contains("JUnit", "CDI", "Java 8", "Spring"));
	}
	
	@Test
	public void deveriaVerificarSeAListaContemElementosSemOrderEspecificada() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
		
		assertThat(artigos, containsInAnyOrder("JUnit", "CDI", "Spring", "Java 8"));
	}
	
	@Test
	public void deveriaVerificarSeAListaNaoEstaVazia() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");
		
		assertThat(artigos, Matchers.not(IsEmptyCollection.empty()));
	}
	
	@Test
	public void deveriaVerificarSeAListaNaoEstaVaziaComStaticImport() throws Exception {
		List<String> artigos = Arrays.asList("JUnit", "CDI", "Java 8", "Spring");

		assertThat(artigos, not(empty()));
	}
	
}
