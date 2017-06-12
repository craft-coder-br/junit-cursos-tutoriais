package com.craftcoder.junit;

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
