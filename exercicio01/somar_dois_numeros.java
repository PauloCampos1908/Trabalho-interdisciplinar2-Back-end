package exercicio01;
import java.util.Scanner;

public class somar_dois_numeros {
	public static void main(String[] args) {
	Scanner ler = new Scanner(System.in);
	
	int n1 = ler.nextInt();
	int n2 = ler.nextInt();
	
	System.out.printf("%d + %d = %d",n1,n2,n1+n2);
	
	ler.close();
	}
}
