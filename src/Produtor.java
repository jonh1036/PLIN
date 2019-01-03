import java.util.Scanner;
public class Produtor {
	public static void main(String[] args) {
		int leiteFaltante = 0, leiteArmazenado = 0, horasExtras;
		int meses[] = new int[12];
		double valorMinimo[] = new double[12]; 
		final int producaoNormal = 900, custoNormal = 90, custoHoraExtra = 3;
		final double custoArmazenarLeite = 1.5;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== DEMANDAS DO MÊS =====");
		for(int i=0; i<12; i++) {
			System.out.println("Mês "+(i+1)+":");
			meses[i] = sc.nextInt();
		}
		
		for(int i=0; i<12; i++) {
			if(meses[i]>900) {
				
				leiteFaltante = meses[i] - (900 + leiteArmazenado);
				if(((leiteArmazenado - (meses[i] - 900))<0)|| leiteFaltante == 0)//Retirando leite do estoque
					leiteArmazenado = 0;
				
				if(leiteFaltante > 100) //Calculando quantas horas extras serão necessárias
					horasExtras = 2;
				else if(leiteFaltante > 0 && leiteFaltante < 101)
					horasExtras = 1;
				else {
					horasExtras = 0;
					leiteArmazenado = -leiteFaltante;
				}
				
				valorMinimo[i] = custoNormal + horasExtras*custoHoraExtra;
				
				if(producaoNormal + horasExtras*100 > meses[i]) { //Armazenando leite
					leiteArmazenado = producaoNormal + horasExtras*100 - meses[i];
					valorMinimo[i] += (leiteArmazenado/100)*custoArmazenarLeite;
				}
			}
			else if(meses[i] == 900) {
				leiteFaltante = 0;
				valorMinimo[i] = custoNormal + (leiteArmazenado/100)*custoArmazenarLeite;
			}
			else {
				
			}
		}
		
		System.out.println("===== VALOR MÍNIMO POR MÊS =====");
		for(int i=0; i<12; i++) {
			System.out.println("Mês "+(i+1)+": R$" + valorMinimo[i]);
		}
	}
}