package sort;

/**
 * @author jwang 12/13/20
 */
public class QuickSort {
  public static void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    Comparable v = a[lo];
    while(true) {
      while(Sort.less(a[i], v)) {
        i++;
      }
      if (i == hi) break;
      while(Sort.less(v, a[j])) {
        j--;
      }
      if (j == lo) break;
      if (i >= j) break;
      Sort.exch(a, i, j);
    }
    Sort.exch(a, lo, j);
    return j;
  }

  public static void quick3way(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int lt = lo, i = lo+1, gt = hi;
    Comparable v = a[lo];
    while (i <= gt) {
      int cmp = a[i].compareTo(v);
      if (cmp < 0) Sort.exch(a, lt++, i++);
      else if (cmp > 0) Sort.exch(a, i, gt--);
      else i++;
    }
    sort(a, lo, lt-1);
    sort(a, gt+1, hi);
  }
}
