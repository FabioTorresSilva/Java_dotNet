
import java.util.Scanner;

public class Vizinho {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = new int[10];
        int n;

        n = ler(arr);
        verResultados(arr, n);
    }

    public static int ler(int[] arr) {
        int num, n = 0;

        System.out.println("Introduza um número inteiro");
        num=ler.nextInt();
        while (num > 0 && n< arr.length) {
            arr[n] = num;
            n++;
            System.out.println("Introduza um número");
            num=ler.nextInt();
        }
        return n;
    }

    public static void verResultados(int[] arr, int n) {
        boolean existe=false;
        System.out.println("Resultado:");
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.println(arr[i]);
                existe=true;
            }
        }
        if (existe ==false)
        System.out.printf("Nenhum número introduzido é maior que os seus vizinhos");
    }
}
