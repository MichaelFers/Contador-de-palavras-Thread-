import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ThreadGeren implements Runnable {

	private static int quantPalavra = 0;
	private String nomeArquivo;// nome do arquivo a ser passado que ser� ultilizado na classe GerenteDeArquivos
	GerenteDeArquivos gerente; // gerente, do tipo GerenteDeArquivos, no qual ir� criar os arquuivos na pasta
								// raiz do projeto, no qual ser� lido e contado as palavras pela thread

	public ThreadGeren(String nome) {
		nomeArquivo = nome;
		gerente = new GerenteDeArquivos();
	}

	@Override
	public void run() {// M�todo run, no qual iniciar� ao ser chamado o m�toro stard da thread
						// instanciada

		List<String> palavrasEnc = gerente.recuperaArquivos(nomeArquivo);// m�toro usado para receber um arraylist com
																			// armazenamento do tipo string do m�toro
																			// recuperaArquivos que no qual ser�
																			// ultilizado Buff para a leitura dos
																			// arquivos

		String le;
		for (int x = 0; x < palavrasEnc.size() - 1; x++) {// for ultilizado para varrer o array list palavrasEnc

			le = palavrasEnc.get(x);// a vari�vel le rebece um elemento da posi��o do array
			if (le.contains("=")) {// verifica��o para saber se a string le cont�m "=" e se conter, n�o nos
									// interesa e podemos mandar o for passar para a pr�xima varredura com o comando
									// continue

				continue;
			} else {// mas caso n�o contenha a string "=", pq � uma ou mais palavra/as, e podemos
					// ultilizar do m�todo split da string para que a string le seja dividida entre
					// os espa�os e armazedadas em um array de strings, como a string foi dividida e
					// armazenada em um array de string,
					// agora � s� perguntar o tamanho dela e armazenar a vari�vel quantPalavra, o
					// operador += diz que a vari�vel vai ter o valor dela mais a quantidade do
					// tamanho do array

				String[] t = le.split(" ");
				synchronized (this) {// o synchronized (this) informa que apenas 1 thread por vez poder� alterar o
										// valor que est� dentro das chaves { }
										// a palavra reservada this, informa o pr�prio tipo da classe, ou seja apenas 1
										// thread poder� entrar aqui por vez
					quantPalavra += t.length;
				}

			}
		}

	}

	public int getQuantPal() {
		return this.quantPalavra;
	}
}
