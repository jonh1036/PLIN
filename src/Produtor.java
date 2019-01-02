import java.util.Scanner;
public class Produtor {
	public static void main(String[] args) {
		int meses[] = new int[12];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====DEMANDAS DO MÊS=====");
		for(int i=0; i<12; i++) {
			System.out.println("Mês "+(i+1)+":");
			meses[i] = sc.nextInt();
		}
		
	}
}