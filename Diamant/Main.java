import java.util.Scanner;

public class Main{
    public static void drawDiamond(int height) {
        if (height < 1 || height % 2 == 0) {
            System.out.println("Hiba: A magassagnak pozitiv paratlan szamnak kell lennie!");
            return;
        }
        int middle = height / 2;
        for (int i = 0; i <= middle; i++) {
            printLine(middle - i, 2 * i + 1);
        }
        for (int i = middle - 1; i >= 0; i--) {
            printLine(middle - i, 2 * i + 1);
        }
    }
    private static void printLine(int spaces, int stars) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adj egy szamot:");
        int i = sc.nextInt();
        sc.close();
        drawDiamond(i);
    }
}
