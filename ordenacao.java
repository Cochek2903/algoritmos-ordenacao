import java.util.Arrays;

public class SortBench {

    static class Result {
        long swaps;
        long comps;
        int[] sorted;
        Result(long s, long c, int[] arr) { swaps = s; comps = c; sorted = arr; }
    }

    static int[] copy(int[] a){ return Arrays.copyOf(a, a.length); }

    static Result bubble(int[] arr){
        int[] a = copy(arr);
        long swaps = 0, comps = 0;
        for(int i=0;i<a.length;i++){
            boolean swapped=false;
            for(int j=0;j<a.length-1-i;j++){
                comps++;
                if(a[j] > a[j+1]){
                    int t=a[j]; a[j]=a[j+1]; a[j+1]=t;
                    swaps++; swapped=true;
                }
            }
            if(!swapped) break;
        }
        return new Result(swaps, comps, a);
    }

    static Result selection(int[] arr){
        int[] a = copy(arr);
        long swaps = 0, comps = 0;
        for(int i=0;i<a.length-1;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                comps++;
                if(a[j] < a[min]) min=j;
            }
            if(min!=i){
                int t=a[i]; a[i]=a[min]; a[min]=t;
                swaps++;
            }
        }
        return new Result(swaps, comps, a);
    }

    static Result cocktail(int[] arr){
        int[] a = copy(arr);
        long swaps = 0, comps = 0;
        boolean swapped = true;
        int start = 0, end = a.length - 1;
        while(swapped){
            swapped = false;
            for(int i=start;i<end;i++){
                comps++;
                if(a[i] > a[i+1]){
                    int t=a[i]; a[i]=a[i+1]; a[i+1]=t;
                    swaps++; swapped=true;
                }
            }
            if(!swapped) break;
            swapped = false;
            end--;
            for(int i=end-1;i>=start;i--){
                comps++;
                if(a[i] > a[i+1]){
                    int t=a[i]; a[i]=a[i+1]; a[i+1]=t;
                    swaps++; swapped=true;
                }
            }
            start++;
        }
        return new Result(swaps, comps, a);
    }

    static Result comb(int[] arr){
        int[] a = copy(arr);
        long swaps = 0, comps = 0;
        double shrink = 1.3;
        int gap = a.length;
        boolean sorted = false;
        while(!sorted){
            gap = (int)(gap / shrink);
            if(gap <= 1){
                gap = 1;
                sorted = true;
            }
            for(int i=0; i+gap < a.length; i++){
                comps++;
                if(a[i] > a[i+gap]){
                    int t=a[i]; a[i]=a[i+gap]; a[i+gap]=t;
                    swaps++;
                    sorted = false;
                }
            }
        }
        return new Result(swaps, comps, a);
    }

    static Result gnome(int[] arr){
        int[] a = copy(arr);
        long swaps = 0, comps = 0;
        int i = 0;
        while(i < a.length){
            if(i == 0){ i++; continue; }
            comps++;
            if(a[i-1] <= a[i]) i++;
            else {
                int t=a[i]; a[i]=a[i-1]; a[i-1]=t;
                swaps++;
                i--;
            }
        }
        return new Result(swaps, comps, a);
    }

    static void bench(String label, int[] data){
        Result[] rs = new Result[]{
            bubble(data), selection(data), cocktail(data), comb(data), gnome(data)
        };
        String[] names = {"Bubble","Selection","Cocktail","Comb(1.3)","Gnome"};

        System.out.println("\n=== " + label + " ===");
        System.out.printf("%-12s | %12s | %14s%n","Algoritmo","Swaps","Comparacoes");
        System.out.println("-------------+--------------+----------------");
        for(int i=0;i<names.length;i++){
            System.out.printf("%-12s | %12d | %14d%n", names[i], rs[i].swaps, rs[i].comps);
        }
    }

    public static void main(String[] args) {
        int[] vetor1 = {12,18,9,25,17,31,22,27,16,13,19,23,20,30,14,11,15,24,26,28};
        int[] vetor2 = {5,7,9,10,12,14,15,17,19,21,22,23,24,25,27,28,29,30,31,32};
        int[] vetor3 = {99,85,73,60,50,40,35,30,25,20,15,14,13,12,11,10,9,8,7,6};

        bench("vetor1", vetor1);
        bench("vetor2 (ordenado)", vetor2);
        bench("vetor3 (reverso)", vetor3);
    }
}
