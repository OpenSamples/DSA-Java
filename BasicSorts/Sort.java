
public class Sort {
  
  public static void main(String[] args) {
  
    //read

    //sort
    
    //print
  }
  
  // Exchange or Bubble sort - the most inefficient way to sort elements.
  public static <T extends Comparable<T>> void exchangeSort(T[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = arr.length - 1; j > i; j--) {
        if (arr[j].compareTo(arr[j - 1]) < 0) {
          T tmp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = tmp;
        }
      }
    }
  }
  
  // Selection sort - when it's easier to compare elements than to move them
  public static <T extends Comparable<T>> void selectionSort(T[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j].compareTo(arr[minIndex]) < 0) {
          minIndex = j;  
        }
      }
      if (minIndex != i) {
        T tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
      }
    } 
  }
}

class Item implements Comparable<Item> {

  private final String name;
  private final int number;
  
  public Item(String name, int number) {
    this.name = name;
    this.number = number;
  }
  
  public String getName() {
    return name;  
  }
  
  public int getNumber() {
    return number;  
  }
  
  public int compareTo(Item that) {
    return this.number - that.number;  
  }
  
  public String toString() {
    return name + "\n" + number;  
  }
}