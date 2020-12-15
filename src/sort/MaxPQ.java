package sort;

/**
 * @author jwang 12/14/20
 */
public class MaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;
  private int N = 0; //initial size.

  public MaxPQ(int maxN) {
    pq = (Key[]) new Comparable[maxN + 1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(Key v) {
    pq[++N] = v;
    swim(N);
  }

  public Key delMax() {
    Key max = pq[1];
    Sort.exch(pq, 1, N);
    pq[N--] = null;
    sink(1);
    return max;
  }

  private void sink(int k) {
    while (2*k <= N) {
      int j = 2 * k;
      // check both of the child nodes, if j+1 is larger, use j+1.
      if (j < N && Sort.less(j, j+1)) j++;
      // break, if the large child node is smaller the parent node.
      if (!Sort.less(pq[k], pq[j])) break;
      Sort.exch(pq, j, k);
      k = j;
    }
  }

  private void swim(int k) {
    while(k > 1 && Sort.less(pq[k/2], pq[k])) {
      Sort.exch(pq, k, k/2);
      k /= 2;
    }
  }
}
