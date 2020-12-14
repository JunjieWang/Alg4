package UnionFind;

import kotlin.contracts.ReturnsNotNull;

/**
 * Find in O(N), union also in O(N).
 * @author jwang 12/13/20
 */
public class QuickUnion extends UF {
  public QuickUnion(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    while(p != id[p]) p = id[p];
    return p;
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if(pRoot == qRoot) return;
    id[pRoot] = qRoot;
    count--;
  }
}
