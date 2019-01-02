import java.util.Scanner;
public class Produtor {
	public static void main(String[] args) {
		int meses[] = new int[12];
		int valorMinimo[] = new int[12]; 
		int leiteFaltante, leiteArmazenado;
		final int producaoNormal = 900, custoNormal = 10;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== DEMANDAS DO MÊS =====");
		for(int i=0; i<12; i++) {
			System.out.println("Mês "+(i+1)+":");
			meses[i] = sc.nextInt();
		}
		
		for(int i=0; i<12; i++) {
			if(meses[i]>900) {
				
			}
			else if(meses[i] == 900) {
				
			}
			else {
				
			}
		}
		
		System.out.println("===== VALOR MÍNIMO POR MÊS =====");
		for(int i=0; i<12; i++) {
			System.out.println("Mês "+(i+1)+": " + valorMinimo[i]);
		}
	}
}