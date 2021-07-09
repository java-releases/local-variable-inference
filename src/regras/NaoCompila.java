package regras;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class NaoCompila {

	class Animal {
	}

	class Cachorro extends Animal {
	}

	/**
	 * NAO COMPILA, pois n�o � um scopo local.
	 */
	var nome = "Luciano";

	/**
	 * NAO COMPILA, pois todo var DEVE ser inicializado.
	 */
	void teste_01() {
		var nome = null;
		var animal;
		animal = "coelho";
	}

	/**
	 * NAO COMPILA, pois n�o podemos fazer CAST de 32bits para 64bits.
	 */
	void teste_02() {
		var numero = (int) 439;
		numero = (long) 439;
	}

	/**
	 * NAO COMPILA, pois devemos realizar inicializacao composta
	 */
	void teste_03() {
		var a, b, c = 1;
	}

	/**
	 * NAO COMPILA, pois NAO devemos reatribuir tipo DIFERENTE do que j� foi
	 * inferido.
	 */
	void teste_04() {
		var qualquer = 0;
		qualquer = "cachorro";
	}

	/**
	 * NAO COMPILA, pois um tipo primitivo NAO pode receber null;
	 */
	void teste_05() {
		var numero = 1;
		numero = null;
	}

	/**
	 * NAO COMPILA, pois um 'cachorro' NAO pode instanciar um Animal (pois �
	 * subclasse de Animal)
	 */
	void teste_06() {
		Animal animal = new Animal();
		Cachorro cachorro = new Cachorro();
		var var_animal = cachorro;
		var_animal = animal;
	}

	/**
	 * NAO COMPILA, pois esta pegando um OBJECT da lista inferida, e NAO um int
	 */
	void teste_07() {
		var list = new ArrayList<>();// ATEN��O: INFERINDO LISTA DE OBJECTS
		list.add(10);
		int numero = list.get(0);
	}

	/**
	 * NAO COMPILA """[]""" - 'var' n�o � permitido como um tipo de elemento de um
	 * array
	 * 
	 */
	void teste_08() {
		var numbers[] = new int[] { 2, 4, 6 };
		var numbers2[] = { 2, 4, 6 };
	}

	/**
	 * NAO COMPILA var na clausula catch
	 */
	void teste_09() {
		try {
			Files.readAllBytes(Paths.get("c:\temp\temp.txt"));
		} catch (var e) {
		}
	}

	/**
	 * LAMBDA - "express�o lambda precisa de um tipo expl�cito".
	 */
	void exemplo_10() {
		var runnable = () -> {

		};
	}

	/**
	 * LAMBDA - "Nenhum inicializador de refer�ncia de m�todo, semelhante �s
	 * express�es lambda e operador diamante"
	 */
	void exemplo_11() {
		var abs = BigDecimal::abs;
	}

	/**
	 * NAO COMPILA. Regras lambda:
	 */
	void exemplo_12() {
		// Por exemplo, n�o podemos usar var para alguns par�metros e ignorar para
		// outros:
		// (var s1, s2) -> s1 + s2 N�O COMPILA

		// Da mesma forma, n�o podemos misturar var com tipos expl�citos:
		// (var s1, String s2) -> s1 + s2V //NAO COMPILA

		// Finalmente, embora possamos pular os par�nteses no �nico par�metro lambda:
		// s1 -> s1.toUpperCase()

		// n�o podemos ignor�-los ao usar var :
		// var s1 -> s1.toUpperCase()
	}

}