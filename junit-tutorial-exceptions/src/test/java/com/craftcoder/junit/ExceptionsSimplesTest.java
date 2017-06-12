package com.craftcoder.junit;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ExceptionsSimplesTest {

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void deveriaLancarExceptionEsperadaPeloJUnit() throws Exception {
		List<String> tutoriais = Arrays.asList("Java 8", "CDI", "Mockito");

		tutoriais.get(3);
	}

}


