#include <stdio.h>

void comExtra(int litros_lic);
void semExtra(int litros_lic);
double arm, custo;
int qnt_arm;

int main(void) {
  int litros_lic, op = 1;

  do{
      printf("\nQuantos litros no %d° mês?\n",op);
      scanf("%d",& litros_lic);

    if(qnt_arm > 0){
      if(qnt_arm < litros_lic){
        litros_lic = litros_lic - qnt_arm;
      }
      else
        litros_lic = qnt_arm - litros_lic; 
    }

    if(litros_lic <= 900){
      semExtra(litros_lic);
      printf("\nO menor valor a ser cobrado sem ter prejuizo no %d° mês é: \nR$ %.2lf\n", op, custo);
    }
    else if(litros_lic > 900 && litros_lic <= 1100){
      comExtra(litros_lic);
      printf("\nO menor valor a ser cobrado sem ter prejuizo no %d° mês é: \nR$ %.2lf\n", op, custo);
    }
    else
      printf("\nA demanda é maior que a produção mensal!\n");

    op++;
    qnt_arm = arm;

  }while(op < 13);

  return 1;
}
void comExtra(int litros_lic){  
  arm = 1100 - litros_lic;
  arm = arm * 0.015;
  custo = 143 + arm;
}
void semExtra(int litros_lic){
  arm = 900 - litros_lic;
  arm = arm * 0.015;
  custo = 90 + arm;
}
