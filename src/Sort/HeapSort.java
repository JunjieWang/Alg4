package Sort;

/**
 * @author jwang 12/14/20
 */
public class HeapSort {
  public static void sort(Comparable[] a) {
    int N  = a.length;
    //nodes after N/2 are already at bottom level, so no need to max_heapfy it.
    for (int k = N/2; k>= 1; k--) {
      sink(a, k, N);
    }


    while (N > 1) {
      Sort.exch(a, 1, N--);
      sink(a, 1, N);
    }
  }

  private static void sink(Comparable[] pq, int k, int N) {
    while (2 * k <= N) {
      int j = 2 * k;
      // check both of the child nodes, if j+1 is larger, use j+1.
      if (j < N && Sort.less(j, j+1)) j++;
      // break, if the large child node is smaller the parent node.
      if (!Sort.less(pq[k], pq[j])) break;
      Sort.exch(pq, j, k);
      k = j;
    }
  }
}
