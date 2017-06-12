package com.craftcoder.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class IgnorandoTestes {

	@Test
	public void deveriaRodarEsteTeste() throws Exception {
		List<String> tutoriais = Arrays.asList("Java 8", "CDI", "Spring");

		String tutorial = tutoriais.get(0);

		assertEquals("Java 8", tutorial);
	}

	@Ignore
	@Test
	public void naoDeveriaRodarEsteTeste() throws Exception {
		List<String> tutoriais = Arrays.asList("Java 8", "CDI", "Spring");

		String tutorial = tutoriais.get(0);

		assertEquals("CDI", tutorial);
	}

	@Ignore("Ignorado por problemas de ambiente")
	@Test
	public void naoDeveriaRodarEsteTesteEDeveriaTerOMotivo() throws Exception {
		List<String> tutoriais = Arrays.asList("Java 8", "CDI", "Spring");

		String tutorial = tutoriais.get(0);

		assertEquals("CDI", tutorial);
	}

}
