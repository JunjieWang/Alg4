package Sort;

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

c
}
