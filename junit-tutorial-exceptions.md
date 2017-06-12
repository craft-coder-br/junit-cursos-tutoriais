# JUnit Tutorial - Trabalhando com Exceptions

## Esperando Exceptions de forma Simples com JUnit

```java
public class ExceptionsSimplesTest {

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void deveriaLancarExceptionEsperadaPeloJUnit() throws Exception {
		List<String> tutoriais = Arrays.asList("Java 8", "CDI", "Mockito");

		tutoriais.get(3);
	}

}
```

## Detalhando uma Exception com JUnit

```java
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
```

Código da classe TutotialDao

```java
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
```

Código da Exception Customizada

```java
public class TutorialNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 330927847359157163L;

	private String nomeTutorial;

	private int codigo;

	public TutorialNaoEncontradoException(String message, String nomeTutorial, int codigo) {
		super(message);
		this.nomeTutorial = nomeTutorial;
		this.codigo = codigo;
	}

	public String getNomeTutorial() {
		return nomeTutorial;
	}

	public int getCodigo() {
		return codigo;
	}

}
```
