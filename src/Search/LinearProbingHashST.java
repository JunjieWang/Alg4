package Search;

/**
 * @author jwang 1/10/21
 */
public class LinearProbingHashST<Key, Value> {
  private final int M = 16;
  private final Key[] keys;
  private final Value[] vals;
  private int N;

  public LinearProbingHashST() {
    keys = (Key[]) new Object[M];
    vals = (Value[]) new Object[M];
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7ffffff) % M;
  }

  private void resize(int M) {

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


}
