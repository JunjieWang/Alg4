package Search;

/**
 * @author jwang 1/10/21
 */
public class SeparateChainingHashST<Key, Value> {
  private int M; //size;
  private SequentialSearchST<Key, Value>[] st;
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

  private void resize(int chains) {
    SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(chains);
    for (int i = 0; i < M; i++) {
      for (Key key : st[i].keys()) {
        temp.put(key, st[i].get(key));
      }
    }
    this.M = temp.M;
    this.N = temp.N;
    this.st = temp.st;
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

  //TODO
  public void delete(Key key) {
    if (N > 0 && N <= M / 8) {
      resize(M / 2);
    }
  }

}
