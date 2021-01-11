package Search;

/**
 * @author jwang 1/10/21
 */
public class SeparateChainingHashST<Key, Value> {
  private final int M; //size;
  private final SequentialSearchST<Key, Value>[] st;
  private int N; // count of keys

  public SeparateChainingHashST() {
    this(997);
  }

  public SeparateChainingHashST(int M) {
    this.M = M;
    st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
    for (int i = 0; i < M; i++) {
      st[i] = new SequentialSearchST();
    }
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % M;
  }

  public Value get(Key key) {
    return st[hash(key)].get(key);
  }

  public void put(Key key, Value val) {
    st[hash(key)].put(key, val);
  }

}
