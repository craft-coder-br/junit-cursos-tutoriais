package com.craftcoder.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionCustomizadaTest {

	@Rule
	public ExpectedException exceptionEsperada = ExpectedException.none();

	@Test(expected = TutorialNaoEncontradoException.class)
	public void deveriaLancarExcecaoDeTutorialNaoEncontrado() throws Exception {

		TutorialDao dao = new TutorialDao();

		dao.findByName("Hibernate");
	}

	@Test
	public void deveriaLancarExceptionComMaisAlgumasInfosInteressantes() throws Exception {
		exceptionEsperada.expect(TutorialNaoEncontradoException.class);

		exceptionEsperada.expectMessage("Tutorial nao encontrado");

		exceptionEsperada.expect(hasProperty("codigo"));

		exceptionEsperada.expect(hasProperty("codigo", CoreMatchers.is(123)));

		exceptionEsperada.expect(hasProperty("nomeTutorial", is("Hibernate")));

		TutorialDao dao = new TutorialDao();

		dao.findByName("Hibernate");
	}

}

class TutorialDao {

	private List<String> tutoriais = Arrays.asList("Java 8", "CDI", "Spring");

	public String findByName(String tutorialDesejado) {
		String tutorialEncontrado = tutoriais
			.stream()
			.filter(tutorial -> tutorial.equals(tutorialDesejado))
			.findFirst()
			.orElseThrow(() -> new TutorialNaoEncontradoException("Tutorial nao encontrado", tutorialDesejado, 123));

		return tutorialEncontrado;
	}

}

