Aluno: João Pedro Cochek Giovannoni
Disciplina: Ciencia Da Computação
Instituição: PUC-PR


# 🧮 Comparativo de Algoritmos de Ordenação

Este projeto compara o desempenho de **cinco algoritmos de ordenação clássicos** em diferentes cenários, avaliando **eficiência em trocas (swaps)** e **interações (comparações)**.

---

## 📋 Algoritmos testados

- **Bubble Sort** (com otimização *early exit*)  
- **Selection Sort**  
- **Cocktail Sort** (*shaker sort*)  
- **Comb Sort** (*shrink factor = 1.3*)  
- **Gnome Sort**

---

## 🎯 Objetivo

Avaliar e comparar o comportamento dos algoritmos em três tipos de vetores:
1. Vetor **quase aleatório**  
2. Vetor **já ordenado**  
3. Vetor **em ordem reversa**

Cada algoritmo foi implementado manualmente em Java, sem uso de bibliotecas prontas de ordenação, para medir:

- Número total de **comparações** realizadas;  
- Número total de **trocas (swaps)** entre elementos.

---

## 💻 Estrutura do código

O projeto consiste em um único arquivo:

ordenacao.java


 
 Vetores utilizados

int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};

int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};

int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};



📊 Resultados Detalhados


🔸 Vetor 1 (quase aleatório)
Algoritmo	Trocas (swaps)	Interações (comparações)
Bubble	           78               	180
Selection	       18	                190
Cocktail	       78               	154
Comb (1.3)	       22               	129
Gnome	           78               	174

Menos trocas: Selection
Menos comparações: Comb (1.3)


🔸 Vetor 2 (ordenado)
Algoritmo	Trocas (swaps)	Interações (comparações)
Bubble	         0	                    19
Selection	     0	                    190
Cocktail	     0                  	19
Comb (1.3)	     0                  	110
Gnome	         0                  	19

Menos trocas: Todos empatados
Menos comparações: Bubble, Cocktail e Gnome


🔸 Vetor 3 (invertido)
Algoritmo	Trocas (swaps)	Interações (comparações)
Bubble	            190             	190
Selection	        10              	190
Cocktail	        190	                190
Comb (1.3)	        18	                129
Gnome	            190             	380

Menos trocas: Selection
Menos comparações: Comb (1.3)


📈 Conclusões
Bubble Sort: Excelente em casos já ordenados (detecta ordenação e finaliza cedo).

Selection Sort: Realiza pouquíssimas trocas, mantendo consistência mesmo em casos reversos.

Comb Sort: Reduz comparações graças ao uso de gaps progressivamente menores.

Cocktail Sort: Leve melhoria sobre o Bubble, mas ainda limitado em grandes volumes.

Gnome Sort: Simples, mas pouco eficiente em cenários desordenados.
