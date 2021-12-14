// 2. Написать программу, удаляющую из целочисленного массива А размерности N элементы, равные целому числу Х. В результате должен
//   получиться массив не большей размерности. На экране должны выводиться как оригинальное состояние массива, так и итоговое.

import java.util.Scanner;
import java.util.InputMismatchException;

public class lab4 {
    public static void main(String[] args) {

        int N = 0;
        int[] ogArray = new int[0];
        int X = 0;

        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the number of array's elements:");
            N = s.nextInt();
            ogArray = new int[N];
            System.out.println("Enter array's elements using whitespace:");
            for (int i = 0; i < N; i++) {
                ogArray[i] = s.nextInt();
            }
            System.out.println("Insert an integer number X to remove from array:");
            X = s.nextInt();
            s.close();
        } catch (InputMismatchException var0) {
            System.out.println("Error. Insert an integer number(-s) in the range [-2147483648, 2147483647].");
            System.exit(1);
        }
        System.out.print("Original array:");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + ogArray[i]);
        }
        System.out.println();
        int[] finArray = new int[ogArray.length];
        for (int i = 0, j = 0; i < ogArray.length && j < finArray.length; i++) {
            if (ogArray[i] != X && checkX(ogArray, X)) {
                finArray[j++] = ogArray[i];
            } else {
                System.out.println("No such element in the array.");
                System.exit(1);
            }
        }
        System.out.print("Final array:");
        for (int i = 0; i < N-1; i++) {
            System.out.print(" " + finArray[i]);
        }
    }
    public static boolean checkX(int[] a, int X) {
        int count = 0;
        for (int j : a) {
            if (j == X) {
                count += 1;
            }
        }
        return count == 1;
    }
}
