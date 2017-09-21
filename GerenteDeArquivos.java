import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenteDeArquivos {

	private BufferedReader leitorB;
	private BufferedWriter escritorB;
	private final static String nomePasta = "AindaPraDefinir";// tem que mudar esse nome, o prof j� conhece

	public GerenteDeArquivos() {
		new File(nomePasta).mkdirs();// o m�todo .mkdirs da classe File, cria uma pasta com o nome definido no
										// atributo nomePasta
		escritorDeArquivo();// aqui � chamado o m�todo escritorDeArquivo para criar os arquivos na pasta
							// criada.
	}

	public void escritorDeArquivo() {

		try {// entre o bloco try por causa da cria��o do arquivo, caso n�o consiga criar ou
				// escrever em um arquivo, ser� disparada uma exce��o
			escritorB = new BufferedWriter(new FileWriter(nomePasta + "/arquivo_a.txt"));// cria o arquivo arquivo_a.txt

			escritorB.write("=== arquivo_a.txt ===");// o comando write manda o BufferedWriter escrever algo no arquivo
														// criado
			escritorB.newLine();// o newLine, manda pular a linha
			escritorB.write("ola mundo,");// aqui, ele escreve na linha que pulou
			escritorB.newLine();
			escritorB.write("este � o primeiro arquivo!");
			escritorB.newLine();
			escritorB.write("==================");
			escritorB.close();// fechar o fluxo de buff, escrever no arquivo n�o ser� mais necess�rio e o
								// BufferedWriter pode finalizar, se ele m�todo .close n�o for chamado, nenhum
								// dado ser� escrito

			escritorB = new BufferedWriter(new FileWriter(nomePasta + "/arquivo_b.txt"));// cria o arquivo arquivo_b.txt

			escritorB.write("=== arquivo_b.txt ===");
			escritorB.newLine();
			escritorB.write("ola novamente, mundo!");
			escritorB.newLine();
			escritorB.write("este � mais um arquivo de teste!");
			escritorB.newLine();
			escritorB.write("==================");
			escritorB.close();

			escritorB = new BufferedWriter(new FileWriter(nomePasta + "/arquivo_c.txt"));// cria o arquivo arquivo_c.txt

			escritorB.write("=== arquivo_c.txt ===");
			escritorB.newLine();
			escritorB.write("este � o �ltimo.");
			escritorB.newLine();
			escritorB.write("==================");
			escritorB.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<String> recuperaArquivos(String nome) {

		List<String> textoLido = new ArrayList();

		try {
			leitorB = new BufferedReader(new FileReader(nomePasta + "/" + nome));// aqui e criado um BufferedReader para
																					// a leitura do arquivo, no
																					// par�metro � passado o diret�rio
																					// do arquivo

			String texto = null;

			do {
				texto = leitorB.readLine();// aqui l� uma linha do arquivo criado e adiciona ao arrayList textoLido para
											// ser retornado ao final do m�todo
				textoLido.add(texto);

			} while (texto != null);// condi��o no qual se n�o existir mais nada a ser lido no arquivo, a itera��o
									// morre

		} catch (IOException e) {
			e.printStackTrace();
		}

		return textoLido;// retorna o arraylist com o que foi lido pelo BufferedReader
	}
}
