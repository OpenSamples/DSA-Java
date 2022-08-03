public class SLLListOfLists {

  public static void main(String[] args) {
  
  }
}

class ListOfClubs {

  private Club clubHead;
  
  class Club {
    String name;
    Club next;
    Member memberHead;
    
    public Club(String name) {
      this.name = name;
      next = null;
    }
    
    public String toString() {
      String res = "[ " + name + ":";
      Member curr = memberHead;
      if (curr != null) {
        res += " " + curr;
        curr = curr.next;
        while (curr != null) {
          res += ", " + curr;
          curr = curr.next;
        }
      }
      return res += " ]";
    }
  }
  
  class Member {
    String fullName;
    Member next;
    
    public Member(String fullName) {
      this.fullName = fullName;
      next = null;
    }
    
    public String toString() {
      return fullName;
    }
  }
  public String toString() {
      String res = "Clubs:";
      Club curr = clubHead;
      while (curr != null) {
        res += " " + curr;
        curr = curr.next;
      }
      return res += "\n";
    }
}
