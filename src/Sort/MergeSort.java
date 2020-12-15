package Sort;

/**
 * @author jwang 12/13/20
 */
public class MergeSort {
  //private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    sort(a, 0, a.length-1);
  }
  //top down merge
  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid+1, hi);
    merge(a, lo, mid, hi);
  }

  //bottom up merge
  public static void bottomUpMergeSort(Comparable[] a) {
    int N = a.length;
    Comparable[] aux = new Comparable[N];
    for (int sz = 1; sz < N; sz++) {
      for (int lo = 0; lo < N-sz; lo += sz) {
        merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
      }
    }
  }

  public static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo, j = mid+1;
    Comparable[] aux = new Comparable[a.length];
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      }
      else if (j > hi) {
        a[k] = aux[i++];
      }
      else if (Sort.less(aux[j], aux[i])) {
        a[k] = aux[j++];
      }
      else {
        a[k] = aux[i++];
      }
    }
  }
}
