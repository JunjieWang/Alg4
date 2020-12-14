package UnionFind;

/**
 * Quick find, constant find time, O(N^2) union since for each union it will require O(N) to
 * union components.
 *
 * @author jwang 12/13/20
 */
public class QuickFind extends UF {

  public QuickFind(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    return id[p];
  }

  @Override
  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    if (pID == qID) return;
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pID) {
        id[i] = qID;
      }
    }
    count--;
  }
}
