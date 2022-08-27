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
    head = null;
    
    while (current != null) {
      if (current.info % 2 == 0) {
        if (evenTail == null) {
          evenList.head = current;
        } else {
          evenTail.next = current;
        }
        evenTail = current;
        current = current.next;
        evenTail.next = null;
        continue;
      }
      if (oddTail == null) {
        head = current;
      } else {
        oddTail.next = current;
      }
      oddTail = current;
      current = current.next;
      oddTail.next = null;
    }
    return evenList;
  }
}