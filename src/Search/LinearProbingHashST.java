package Search;

/**
 * @author jwang 1/10/21
 */
public class LinearProbingHashST<Key, Value> {
  private int M = 16;
  private Key[] keys;
  private Value[] vals;
  private int N;

  public LinearProbingHashST() {
    keys = (Key[]) new Object[M];
    vals = (Value[]) new Object[M];
  }

  public LinearProbingHashST(int cap) {
    keys = (Key[]) new Object[cap];
    vals = (Value[]) new Object[cap];
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7ffffff) % M;
  }

  private void resize(int cap) {
    LinearProbingHashST<Key, Value> t;
    t = new LinearProbingHashST<Key, Value>(cap);
    for (int i = 0; i < M; i++) {
      if (keys[i] != null) {
        t.put(keys[i], vals[i]);
      }
    }
    keys = t.keys;
    vals = t.vals;
    M = t.M;
  }

  public void put(Key key, Value val) {
    if (N >= M / 2) {
      resize(2 * M);
    }

    int i;
    for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
      if (keys[i].equals(key)) {
        vals[i] = val;
        return;
      }
    }

    keys[i] = key;
    vals[i] = val;
    N++;
  }

  public Value get(Key key) {
    for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
      if (keys[i].equals(key)) {
        return vals[i];
      }
    }
    return null;
  }

  //TODO
  public void delete(Key key) {
    if (N > 0 && N <= M / 8) {
      resize(M / 2);
    }
  }

}
