import java.util.Scanner;

public class EvenNumbers {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    NumbersList list = new NumbersList();
    System.out.println("How many numbers do you want in the list?");
    int n = in.nextInt();
    System.out.println("Input numbers:");
    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      list.addNode(num);
    }

    NumbersList list = ListHelper.userAddsNumbers();

    System.out.println("Original " + list.toString());
    NumbersList evenNumbersList = list.separateEvenNumbers();
    System.out.println("Odd numbers " + list);
    System.out.println("Even numbers " + evenNumbersList);
  }
}

