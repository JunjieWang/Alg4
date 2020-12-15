package Sort;

/**
 * @author jwang 12/13/20
 */
public class Sort {
  static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }
  static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  static boolean isSorted(Comparable[] a) {
    for(int i = 1; i < a.length; i++) {
      if (less(a[i], a[i-1])) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String a = "SORTEXAMPLE";
    char[] array = a.toCharArray();
    //sort(array);
    //assert isSorted(array);
  }

  //find the k-th smallest element in the array
  // this method uses quick sort idea
  public static Comparable select(Comparable[] a, int k) {
    int lo = 0, hi = a.length - 1;
    while(hi > lo) {
      int j = QuickSort.partition(a, lo, hi);
      if (j == k) return a[k];
      else if (j > k) {
        hi = j - 1;
      }
      else {
        lo = j + 1;
      }
    }
    return a[k];
  }

}
