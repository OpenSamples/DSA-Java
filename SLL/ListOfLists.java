public class SLLListOfLists {
  
  public static void main(String[] args) {
    ListOfClubs clubsList = new ListOfClubs();
    System.out.println("Starting with an empty list: \n" + clubsList);
    
    clubsList.addClub("ClubX");
    clubsList.addClub("ClubY");
    clubsList.addClub("ClubZ");
    clubsList.addClub("ClubX");
    clubsList.addClub("ClubY");
    
    clubsList.addMember("Club0", "Some Name");
    
    clubsList.addMember("ClubX", "Member A");
    clubsList.addMember("ClubX", "Member B");
    clubsList.addMember("ClubX", "Member B");
    clubsList.addMember("ClubX", "Member B");
    
    clubsList.addMember("ClubZ", "Member 1");
    clubsList.addMember("ClubZ", "Member 2");
    clubsList.addMember("ClubZ", "Member 3");
    
    System.out.println("The list after adding some clubs: \n" + clubsList);
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
  
  public void addClub(String clubName) {
    if (!clubExists(clubName)) {
      Club club = new Club(clubName);
      club.next = clubHead;
      clubHead = club;
    }
  }
  
  private boolean clubExists(String clubName) {
    Club curr = clubHead;
    while (curr != null) {
      if (curr.name.equals(clubName)) {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }
  
  private Club findClub(String club) {
    Club curr = clubHead;
    while (curr != null) {
      if (curr.name.equals(club)) {
        return curr;
      }
      curr = curr.next;
    }
    return null;
  }
  
  public void addMember(String clubName, String memberName) {
    Club club = findClub(clubName);
    if (club == null) {
      addClub(clubName);
      club = findClub(clubName);
    }
    if (!memberExists(clubName, memberName)) {
      Member member = new Member(memberName);
      member.next = club.memberHead;
      club.memberHead = member;
    }
  }
  
  public boolean memberExists(String clubName, String memberName) {
    Club club = findClub(clubName);
    Member curr = club.memberHead;
    while (curr != null) {
      if (curr.fullName.equals(memberName)) {
        return true;
      }
      curr = curr.next;
    }
    return false;
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