public class Sort {

    // Exchange or Bubble sort - the most inefficient way to sort elemens.
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
}