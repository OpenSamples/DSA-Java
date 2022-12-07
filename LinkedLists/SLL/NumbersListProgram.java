import java.util.Scanner;

public class EvenNumbers {
  public static void main(String[] args) {

    NumbersList list = ListHelper.userAddsNumbers();

    System.out.println("Original " + list.toString());
    NumbersList evenNumbersList = list.separateEvenNumbers();
    
    System.out.println("Odd numbers " + list);
    System.out.println("Even numbers " + evenNumbersList);
  }
}

