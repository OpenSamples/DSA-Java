import java.util.Scanner;

public class AddNode {
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
        System.out.println(list.toString());
    }
}

class NumbersList {
    class Node {
        int number;
        Node next;

        public Node(int n) {
            number = n; 
            Node next = null;
        }

        public String toString() {
            return number + "";
        }
    }
    // Points to the first node.
    Node first;

    public NumbersList() {
        first = null;
    }

    public void addNode(int n) {
        Node node = new Node(n);
        node.next = first;
        first = node;
    }

    public String toString() {
        String result = "List: [ ";
        Node current = first;
        while (current != null) {
            result += current.number + " ";
            current = current.next;
        }
        return result + "]";
    }
}