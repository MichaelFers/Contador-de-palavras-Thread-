import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {// par�metro do m�todo main importante para n�s, pois ser� nele que ser�
											// passado os nomes dos arquivos

		for (String g : args) {

			ThreadGeren gg = new ThreadGeren(g);// instanciado um objeto ThreadGeren passando como par�metro o nome do
												// arquivo armazenado em args
			Thread t1 = new Thread(gg); // Thread criada e passada como par�metro a nossa thread
			t1.start();// mandando ele iniciar, chamando o m�todo run()
			try {

				t1.join();// o join faz com que a thread main espera a thread criada terminar para
							// continuar

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("Foram encontradas " + new ThreadGeren(null).getQuantPal() + " palavras nos arquivos.");// criado
																													// uma
																													// inst�ncia
																													// da
																													// classe
																													// ThreadGeren
																													// para
																													// solicitar
																													// o
																													// valor
																													// armazenado
																													// na
																													// vari�vel
																													// quantPalavra,
																													// como
																													// a
																													// vari�vel
																													// foi
																													// declarada
																													// como
																													// static,
																													// o
																													// valor
																													// dela
																													// ser�
																													// compartilhada
																													// com
																													// todas
																													// as
																													// suas
																													// inst�ncias
	}
}
