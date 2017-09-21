import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {// parâmetro do método main importante para nós, pois será nele que será
											// passado os nomes dos arquivos

		for (String g : args) {

			ThreadGeren gg = new ThreadGeren(g);// instanciado um objeto ThreadGeren passando como parâmetro o nome do
												// arquivo armazenado em args
			Thread t1 = new Thread(gg); // Thread criada e passada como parâmetro a nossa thread
			t1.start();// mandando ele iniciar, chamando o método run()
			try {

				t1.join();// o join faz com que a thread main espera a thread criada terminar para
							// continuar

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("Foram encontradas " + new ThreadGeren(null).getQuantPal() + " palavras nos arquivos.");// criado
																													// uma
																													// instância
																													// da
																													// classe
																													// ThreadGeren
																													// para
																													// solicitar
																													// o
																													// valor
																													// armazenado
																													// na
																													// variável
																													// quantPalavra,
																													// como
																													// a
																													// variável
																													// foi
																													// declarada
																													// como
																													// static,
																													// o
																													// valor
																													// dela
																													// será
																													// compartilhada
																													// com
																													// todas
																													// as
																													// suas
																													// instâncias
	}
}
