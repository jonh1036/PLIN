import java.util.Scanner;
public class Produtor {
	public static void main(String[] args) {
		int leiteFaltante = 0, leiteArmazenado = 0, horasExtras;
		int meses[] = new int[12];
		double valorMinimo[] = new double[12]; 
		final int producaoNormal = 900, custoNormal = 90, custoHoraExtra = 3;
		final double custoArmazenarLeite = 1.5;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== DEMANDAS DO M�S =====");
		for(int i=0; i<12; i++) {
			System.out.println("M�s "+(i+1)+":");
			meses[i] = sc.nextInt();
		}
		
		for(int i=0; i<12; i++) {
			if(meses[i]>900) { //Quando a demanda � maior que a produ��o normal
				if(meses[i]> 1100 + leiteArmazenado) {
					valorMinimo[i] = -1.0;
					continue;
				}
				
				leiteFaltante = meses[i] - (900 + leiteArmazenado);
				if(((leiteArmazenado - (meses[i] - 900))<0)|| leiteFaltante == 0)//Retirando leite do estoque
					leiteArmazenado = 0;
				
				if(leiteFaltante > 100) //Calculando quantas horas extras ser�o necess�rias
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
					valorMinimo[i] += (leiteArmazenado/100.0)*custoArmazenarLeite;
				}
			}
			else if(meses[i] == 900) { //Quando a demanda � igual a produ��o normal
				leiteFaltante = 0;
				valorMinimo[i] = custoNormal + (leiteArmazenado/100.0)*custoArmazenarLeite;
			}
			else { //Quando a demanda � menor que a produ��o normal
				leiteFaltante = 0;
				leiteArmazenado += producaoNormal - meses[i];
				valorMinimo[i] = custoNormal + (leiteArmazenado/100.0)*custoArmazenarLeite;
			}
		}
		
		System.out.println("===== VALOR M�NIMO POR M�S =====");
		for(int i=0; i<12; i++) {
			if(valorMinimo[i]<0)
				System.out.println("M�s "+(i+1)+": INVI�VEL");
			else 
				System.out.println("M�s "+(i+1)+": R$" + valorMinimo[i]);
		}
	}
}