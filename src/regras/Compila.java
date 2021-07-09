package regras;

import java.util.List;

public class Compila {

	class Animal {
	}

	class Coelho extends Animal {
	}

	static {
		var nome = "Luciano";
	}

	Compila() {
		var animal = "Coelho";
	}

	/**
	 * Inferencia do tipo String
	 */
	void teste_1() {
		var nome = "Luciano";
	}

	/**
	 * Inferencia do tipo String, com CAST explicito
	 */
	void teste_2() {
		var animal = (String) null;
	}

	/**
	 * Reatribuindo um tipo int.Permitido,pois um long tem 64 bits e um int 32 bits
	 */
	void teste_3() {
		var numero = (long) 999;
		numero = 77;
	}

	/**
	 * Compila, pois "var" é um tipo reservado, e NAO uma palavra reservada
	 */
	void teste_4() {
		var var = "var";
	}

	/**
	 * Compila, pois 'animal' pode ter uma instancia de 'Coelho'
	 */
	void teste_5() {
		Animal animal = new Animal();
		Coelho coelho = new Coelho();
		animal = coelho;

		var var_animal = animal;
		var_animal = coelho;
	}

	/**
	 * Generics, Compila automaticamente para uma lista de inteiros
	 */
	void teste_6() {
		var list = List.of(10);
		int numero = list.get(0);
	}

	/**
	 * Compila com Stream
	 */
	void teste_7() {
		var list = List.of(1, 2, 3, 4, 5, 6, 7);
		var stream = list.stream();
		stream.filter(x -> x % 2 == 0).forEach(System.out::println);
	}

}