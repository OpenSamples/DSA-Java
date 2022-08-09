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
    System.out.println("Original " + list.toString());
    NumbersList evenNumbersList = list.separateEvenNumbers();
    System.out.println("Odd numbers " + list);
    System.out.println("Even numbers " + evenNumbersList);
  }
}

class NumbersList {
  
  class Node {
    int info;
    Node next;
    
    public Node(int num) {
      info = num;
      next = null;
    }
    
    public String toString() {
      return info + "";
    }
  }
  
  Node head;
  
  public NumbersList() {
    head = null;
  }
  
  public void addNode(int n) {
    Node node = new Node(n);
    node.next = head;
    head = node;
  }
  
  public String toString() {
    String res = "list: [ ";
    Node curr = head;
    while (curr != null) {
      res += curr.info + " ";
      curr = curr.next;
    }
    return res + "]";  
  }
  
  public NumbersList separateEvenNumbers() {
    NumbersList evenList = new NumbersList();
    
    Node current = head;
    Node evenTail = null;
    Node oddTail = null;
    Node next;
    
    head = null;
    
    while (current != null) {
      if (current.info % 2 == 0) {
        if (evenTail == null) {
          evenList.head = current;
        } else {
          evenTail.next = current;
        }
        evenTail = current;
        
        next = current.next;
        current.next = null;
        current = next;
        continue;
      }
      if (oddTail == null) {
        head = current;
      } else {
        oddTail.next = current;
      }
      if (current != null) {
        current = current.next;
      }
    }
    if (oddTail != null) {
      oddTail.next = null;
    }
    return evenList;
  }
}