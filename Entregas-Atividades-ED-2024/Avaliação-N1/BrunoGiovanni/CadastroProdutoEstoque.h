#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Funcionario {
int id;
char nome [ 30];
double salario;
struct Funcionario *prox;

};

void inserirFuncionario(struct Funcionario ** inicio, 
  int id, 
  char nome[], 
  double salario
){  
  struct Funcionario *novoFuncionario = (struct Funcionario*)malloc(sizeof(struct   Funcionario));
  
if (novoFuncionario == NULL) {
  printf ("Erro ao alocar memória!\n");
return;
}

  novoFuncionario->id = id;
  strcpy (novoFuncionario->nome, nome);
  novoFuncionario->salario = salario;
  novoFuncionario->prox = *inicio;
  *inicio = novoFuncionario;
}

void pesquisarPorID(struct Funcionario *inicio, int id) {
    struct Funcionario *ptr = inicio;
    while (ptr != NULL) {
      if (ptr->id == id) {
        //COLOCAR OS PRINTS NECESSARIOS AQUI. EXEMPLO: printf("ID: %d\n", ptr->id);
        return;
      }
      ptr = ptr->prox;
    }
    printf ( "Funcionario com ID %d nao encontrado. \n", id);
}