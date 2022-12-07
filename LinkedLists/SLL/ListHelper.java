import java.util.Scanner;

public static class ListHelper {
    public static NumbersList userAddsNumbers() {
        Scanner in = new Scanner(System.in);
        NumbersList list = new NumbersList();
        System.out.println("How many numbers do you want in the list?");
        int n = in.nextInt();
        System.out.println("Input numbers:");
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            list.addNode(num);
        }
        return list;
    }

    public static String printList(head, curr) {
        String res = "list: [ ";
        Node curr = head;
        while (curr != null) {
            res += curr.info + " ";
            curr = curr.next;
        }
        return res + "]"; 
    }
}
