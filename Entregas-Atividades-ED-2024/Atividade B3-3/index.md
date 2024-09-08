# Análise Assintótica dos algorimos

##### Giovanni de Pita Cicero - 1ºADS  
-----

## 1º e 2º Requisito: Análise considerando sempre o pior caso e demonstre a análise de tempo

O pior caso sempre será quando o elemento não é encontrado no array

#### - Busca Linear
  
| Linha | Código         | Tempo  |
|-------|----------------|--------|
| 1     | i = 1          | -      |
| 2     | while i <= n   | tn     |
| 3     | if A[i] == x   | 2tn    |
| 4     | return i       | 0      |
| 5     | i = i + 1      | 2tn    |
| 6     | return -1      | t      |
|       | Resultado      | 5tn + t |

#### - Busca Linear Ordenada

| Linha | Código                | Tempo |
|-------|-----------------------|-------|
| 1     | i = 1                 | -     |
| 2     | while i <= n and x ≥ A[i] | 3tn  |
| 3     | if A[i] == x          | 2tn   |
| 4     | return i              | 0     |
| 5     | i = i + 1             | 2tn   |
| 6     | return -1             | t     |
|       |Resultado              | 7tn + t |

#### - Busca Binária

| Linha | Código                         | Tempo          |
|-------|--------------------------------|----------------|
| 1     | esq = 1                         | -              |
| 2     | dir = n                         | -              |
| 3     | while esq <= dir                | t(log(n))      |
| 4     | meio = floor((esq + dir) / 2)   | 3t(log(n))     |
| 5     | if A[meio] == x                 | 2t(log(n))     |
| 6     | return meio                     | 0              |
| 7     | elif x > A[meio]                | 2t(log(n))     |
| 8     | esq = meio + 1                  | 2t(log(n))     |
| 9     | else: dir = meio - 1            | 2t(log(n))     |
| 10    | return -1                       | t              |
|       |Resultado                        | 3t(4log(n) + 1) |

## 3º Requisito: Faça a simplificação para a notação Big O

##### Busca Linear

5tn + t = O(n^t)

##### Busca Linear Ordenada

5tn + t = O(n^t)

##### Busca Binária

3t x 4log(n) + 3t x 1 = 12tlog(n) + 3t = O(tlog(n))

## 4º Requisito: Demonstre todos os resultado (Big O) de modo gráfico

![Logo do GitHub](https://github.com/Walrus01/FATEC-AMS-ED2024-1-1681432412019-GIOVANNI/blob/main/Entregas-Atividades-ED-2024/Atividade%20B3-3/grafico.png)
