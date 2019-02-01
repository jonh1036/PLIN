//Produdor de Leite
#include <stdio.h>

int main(void){
  int demanda[12], producaoAtual[12], horaExtra[12], armazenamento[12], d[12], n = 3;
  float custo[12];

  for(int i = 0; i<n; i++){
    printf("\nInsira a demanda de leite do %d° mês:  ", i+1);
    scanf("%d", & demanda[i]);
    d[i] = demanda[i];
  }
  
  for(int i = 0; i<n; i++){

    if(armazenamento[i-1] > 0 & armazenamento[i-1] < 1100){
      demanda[i] = demanda[i] - armazenamento[i-1];
    }

    if(demanda[i] == 1100){
      armazenamento[i] = 0;
      producaoAtual[i] = demanda[i];
      horaExtra[i] = (producaoAtual[i] - 900)/100;
    }
    else if(demanda[i] <= 900){
      if(demanda[i+1] > 1100){
        if( (demanda[i+1] - 1100) <= 200){
          armazenamento[i] = demanda[i+1] - 1100;
          producaoAtual[i] = demanda[i] + armazenamento[i];
          horaExtra[i] = (producaoAtual[i] - 900)/100;
        }
        else{
          armazenamento[i] = 0;
          producaoAtual[i] = demanda[i];
          horaExtra[i] = 0;
        }
      }
      else{
        armazenamento[i] = 0;
        producaoAtual[i] = demanda[i];
        horaExtra[i] = 0;
      }      
    }
    else if(demanda[i] > 900 & demanda[i] < 1100){
      if(demanda[i+1] > 1100){
        if( (demanda[i] + (demanda[i+1] - 1100) <= 1100)){
          armazenamento[i] = demanda[i+1] - 1100;
          producaoAtual[i] = demanda[i] + armazenamento[i];
          horaExtra[i] = (producaoAtual[i] - 900)/100;
        }
        else{
          armazenamento[i] = 0;
          producaoAtual[i] = demanda[i];
          horaExtra[i] = (producaoAtual[i] - 900)/100;          
        }
      }
      else{
        armazenamento[i] = 0;
        producaoAtual[i] = demanda[i];
        horaExtra[i] = (producaoAtual[i] - 900)/100;
      }
    }
    else{
      producaoAtual[i] = armazenamento[i] = horaExtra[i] = 0;
    }

    if(producaoAtual[i] > 900){
      producaoAtual[i] = 900;
    }

    custo[i] = producaoAtual[i] * 0.1 + horaExtra[i] * 13 + armazenamento[i] * 0.015;
  }

  for(int i = 0; i<n; i++){
    if(custo[i]>0){
      printf("\nA demanda do %d° mês de %dL custará: R$ %.2f", i+1, d[i], custo[i]);
    }
    else{
      printf("\nNo mês %d° não será possível produzir %dL de leite!", i+1, d[i]);
    }   
  }

  for(int i = 0; i<n; i++){
    printf("\n %d° \nArmazenamento: %d\nHora Extra: %d\nProdução Sem Extra: %d\n",i+1, armazenamento[i], horaExtra[i], producaoAtual[i]);
  }
}