public class ListOfLists {
  
  public static void main(String[] args) {
    ListOfClubs clubsList = new ListOfClubs();
    System.out.println("Starting with an empty list: \n" + clubsList);
    
    clubsList.addMember("ClubX", "Remove Me");
    clubsList.addClub("ClubX");
    clubsList.addMember("Club0", "Some Name");
    clubsList.addClub("ClubY");
    
    clubsList.addMember("ClubX", "Member A");
    clubsList.addMember("ClubX", "Member B");
    clubsList.addMember("ClubX", "Member B");
    clubsList.addMember("ClubX", "Member B");
    clubsList.addMember("ClubX", "Member W");
    
    clubsList.addMember("ClubY", "Remove Me");
    
    clubsList.addMember("ClubZ", "Member 1");
    clubsList.addMember("ClubZ", "Member 2");
    clubsList.addMember("ClubZ", "Member 3");
    clubsList.addMember("ClubZ", "Remove Me");
    clubsList.addMember("ClubZ", "Member W");
    System.out.println("The list after adding some clubs: \n" + clubsList);
    
    clubsList.removeMember("ClubZ", "Member 1");
    System.out.println("The list after removing Member 1 from ClubZ: \n" + clubsList);
    
    clubsList.removeMember("Remove Me");
    clubsList.removeMember("Remove Me");
    clubsList.removeMember("Remove Me");
    System.out.println("The list after removing Remove Me member from any club: \n" + clubsList);
    
    clubsList.removeAllClubsContainMember("Member W");
    System.out.println("The list after removing clubs that contain Member W: \n" + clubsList);
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
  
  public boolean removeMember(String clubName, String memberName) {
    Club club = findClub(clubName);
    return removeMember(club, memberName);
  }
  
  private boolean removeMember(Club club, String memberName) {
    boolean found = false;
    if (club != null) {
      if (club.memberHead != null && club.memberHead.fullName.equals(memberName)) {
        club.memberHead = club.memberHead.next;
        found = true;
      } else {
        Member prev = club.memberHead;
        while (prev.next != null && !prev.next.fullName.equals(memberName)) {
          prev = prev.next;
        }
        if (prev.next != null) {
          prev.next = prev.next.next;
          found = true;
        }
      }
    }
    if (found) {
      if (club.memberHead == null) {
        removeClub(club.name);
      }
    }
    return found;
  }
  
  public boolean removeMember(String memberName) {
    Club curr = clubHead;
    while (curr != null && !removeMember(curr, memberName)) {
      curr = curr.next;
    } 
    return curr != null;
  }
  
  public boolean removeClub(String clubName) {
    if (clubHead == null) {
      return false;
    }
    if (clubHead.name.equals(clubName)) {
      clubHead = clubHead.next;
      return true;
    }
    Club prev = clubHead;
    while (prev.next != null) {
      if (prev.next.name.equals(clubName)) {
        prev.next = prev.next.next;
        return true;
      }
      prev = prev.next;
    }
    return false;
  }
  
  public void removeAllClubsContainMember(String memberName) {
    Club curr = clubHead;
    while (curr != null) {
      Member currMem = curr.memberHead;
      while (currMem != null) {
        if (currMem.fullName.equals(memberName)) {
          removeClub(curr.name);
        }
        currMem = currMem.next;
      }
      curr = curr.next;
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