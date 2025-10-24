import java.util.Arrays;

public class ordenacao {

    static class Resultado {
        long trocas;
        long comparacoes;
        int[] ordenado;

        Resultado(long t, long c, int[] arr) {
            trocas = t;
            comparacoes = c;
            ordenado = arr;
        }
    }

    static int[] copiar(int[] vetor) {
        return Arrays.copyOf(vetor, vetor.length);
    }

    static Resultado bolha(int[] vetor) {
        int[] a = copiar(vetor);
        long trocas = 0, comps = 0;
        for (int i = 0; i < a.length; i++) {
            boolean trocou = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                comps++;
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
        return new Resultado(trocas, comps, a);
    }

    static Resultado selecao(int[] vetor) {
        int[] a = copiar(vetor);
        long trocas = 0, comps = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < a.length; j++) {
                comps++;
                if (a[j] < a[menor]) menor = j;
            }
            if (menor != i) {
                int temp = a[i];
                a[i] = a[menor];
                a[menor] = temp;
                trocas++;
            }
        }
        return new Resultado(trocas, comps, a);
    }

    static Resultado coquetel(int[] vetor) {
        int[] a = copiar(vetor);
        long trocas = 0, comps = 0;
        boolean trocou = true;
        int inicio = 0, fim = a.length - 1;
        while (trocou) {
            trocou = false;
            for (int i = inicio; i < fim; i++) {
                comps++;
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
            trocou = false;
            fim--;
            for (int i = fim - 1; i >= inicio; i--) {
                comps++;
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            inicio++;
        }
        return new Resultado(trocas, comps, a);
    }

    static Resultado pente(int[] vetor) {
        int[] a = copiar(vetor);
        long trocas = 0, comps = 0;
        double fatorReducao = 1.3;
        int intervalo = a.length;
        boolean ordenado = false;

        while (!ordenado) {
            intervalo = (int) (intervalo / fatorReducao);
            if (intervalo <= 1) {
                intervalo = 1;
                ordenado = true;
            }
            for (int i = 0; i + intervalo < a.length; i++) {
                comps++;
                if (a[i] > a[i + intervalo]) {
                    int temp = a[i];
                    a[i] = a[i + intervalo];
                    a[i + intervalo] = temp;
                    trocas++;
                    ordenado = false;
                }
            }
        }
        return new Resultado(trocas, comps, a);
    }

    static Resultado gnomo(int[] vetor) {
        int[] a = copiar(vetor);
        long trocas = 0, comps = 0;
        int i = 0;

        while (i < a.length) {
            if (i == 0) {
                i++;
                continue;
            }
            comps++;
            if (a[i - 1] <= a[i]) {
                i++;
            } else {
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
                trocas++;
                i--;
            }
        }
        return new Resultado(trocas, comps, a);
    }

    static void testar(String nome, int[] dados) {
        Resultado[] resultados = new Resultado[]{
                bolha(dados), selecao(dados), coquetel(dados), pente(dados), gnomo(dados)
        };
        String[] nomes = {"Bolha", "Seleção", "Coquetel", "Pente (1.3)", "Gnomo"};

        System.out.println("\n=== " + nome + " ===");
        System.out.printf("%-12s | %12s | %14s%n", "Algoritmo", "Trocas", "Comparações");
        System.out.println("-------------+--------------+----------------");
        for (int i = 0; i < nomes.length; i++) {
            System.out.printf("%-12s | %12d | %14d%n",
                    nomes[i], resultados[i].trocas, resultados[i].comparacoes);
        }
    }

    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        testar("Vetor 1 (quase aleatório)", vetor1);
        testar("Vetor 2 (ordenado)", vetor2);
        testar("Vetor 3 (reverso)", vetor3);
    }
}
