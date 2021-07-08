import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @apiNote Local Variable Type Inference
 * 
 * @since Java 10
 *
 */
public class Main {

	// var nome = "Luciano"; //Nao compila

	static {
		var nome = "Luciano";
	}

	public Main() {
		var animal = "coelho";
	}

	private void exemplo_00() {
		var nome = "Luciano";
	}

	/**
	 * Nao compila se reatribuir um outro tipo, diferente do inferido.
	 */
	private void exemplo_01() {
		var nome = "Luciano";
		// nome = 777; // DOES NOT COMPILE
	}

	/**
	 * Nao compila quando o primitivo atribuido for maior que o inferido no 'cast'.
	 */
	private void exemplo_02() {
		var numero = (int) 777;
		// numero = (long) 777; //DOES NOT COMPILE
	}

	/**
	 * Nao compila pois precisamos inicializar.
	 */
	private void exemplo_03() {
		String nome;
		nome = "Luciano";
		// var nome; // DOES NOT COMPILE
		// nome = "Luciano";
	}

	/**
	 * Compila porque recebeu um CAST.
	 */
	private void exemplo_04() {
		var nome = (String) null; // DOES COMPILE
	}

	/**
	 * Nao compila, pois todas as variaveis precisam ser inicializadas.
	 */
	private void exemplo_05() {
		int x, y, z = 0;
		// var a, b, c = 19; // DOES NOT COMPILE
	}

	/**
	 * Nao compila pois um primitivo nao pode receber NULL.
	 */
	private void exemplo_06() {
		var numero = 1;
		// numero = null;
	}

	/**
	 * Compila pois var é um tipo reservado, e nao uma palavra reservada.
	 */
	private void exemplo_08() {
		Integer Integer = 0;
		var var = "var";
	}

	/**
	 * CUIDADO, compila, porem o tipo esperado pode ser que seja outro. Nesse
	 * exemplo o tipo ser List de Objects
	 */
	private void exemplo_09() {
		// DANGEROUS: infers as List<Object>
		List<String> nomes = new ArrayList<>();
		nomes.add("Luciano");
		nomes.add("Carolina");
		var list = List.of(nomes);
		System.out.println(list);
	}

	/**
	 * Exemplos com lambda
	 */
	private void exemplo_10() {
		// Por exemplo, não podemos usar var para alguns parâmetros e ignorar para
		// outros:
		// (var s1, s2) -> s1 + s2 NÃO COMPILA

		// Da mesma forma, não podemos misturar var com tipos explícitos:
		// (var s1, String s2) -> s1 + s2V //NAO COMPILA

		// Finalmente, embora possamos pular os parênteses no único parâmetro lambda:
		// s1 -> s1.toUpperCase()
		// não podemos ignorá-los ao usar var :
		// var s1 -> s1.toUpperCase()
	}
	/**
	 * Nao compila pois usamos o tipo reservado var para nomear uma class
	 */
	 //class var {}

}