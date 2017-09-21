import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ThreadGeren implements Runnable {

	private static int quantPalavra = 0;
	private String nomeArquivo;// nome do arquivo a ser passado que será ultilizado na classe GerenteDeArquivos
	GerenteDeArquivos gerente; // gerente, do tipo GerenteDeArquivos, no qual irá criar os arquuivos na pasta
								// raiz do projeto, no qual será lido e contado as palavras pela thread

	public ThreadGeren(String nome) {
		nomeArquivo = nome;
		gerente = new GerenteDeArquivos();
	}

	@Override
	public void run() {// Método run, no qual iniciará ao ser chamado o métoro stard da thread
						// instanciada

		List<String> palavrasEnc = gerente.recuperaArquivos(nomeArquivo);// métoro usado para receber um arraylist com
																			// armazenamento do tipo string do métoro
																			// recuperaArquivos que no qual será
																			// ultilizado Buff para a leitura dos
																			// arquivos

		String le;
		for (int x = 0; x < palavrasEnc.size() - 1; x++) {// for ultilizado para varrer o array list palavrasEnc

			le = palavrasEnc.get(x);// a variável le rebece um elemento da posição do array
			if (le.contains("=")) {// verificação para saber se a string le contém "=" e se conter, não nos
									// interesa e podemos mandar o for passar para a próxima varredura com o comando
									// continue

				continue;
			} else {// mas caso não contenha a string "=", pq é uma ou mais palavra/as, e podemos
					// ultilizar do método split da string para que a string le seja dividida entre
					// os espaços e armazedadas em um array de strings, como a string foi dividida e
					// armazenada em um array de string,
					// agora é só perguntar o tamanho dela e armazenar a variável quantPalavra, o
					// operador += diz que a variável vai ter o valor dela mais a quantidade do
					// tamanho do array

				String[] t = le.split(" ");
				synchronized (this) {// o synchronized (this) informa que apenas 1 thread por vez poderá alterar o
										// valor que está dentro das chaves { }
										// a palavra reservada this, informa o próprio tipo da classe, ou seja apenas 1
										// thread poderá entrar aqui por vez
					quantPalavra += t.length;
				}

			}
		}

	}

	public int getQuantPal() {
		return this.quantPalavra;
	}
}
