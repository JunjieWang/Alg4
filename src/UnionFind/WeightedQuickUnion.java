package UnionFind;

import java.util.Arrays;

/**
 * @author jwang 12/13/20
 */
public class WeightedQuickUnion extends UF {
  int[] size;

  public WeightedQuickUnion(int N) {
    super(N);
    this.size = new int[N];
    Arrays.fill(size, 1);
  }

  @Override
  public int find(int p) {
    while (p != id[p]) p = id[p];
    return p;
  }

  @Override
  public void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) return;
    if (size[i] < size[j]) {
      id[i] = j;
      size[j] += size[i];
    }
    else {
      id[j] = i;
      size[i] += size[j];
    }
    count--;
  }

}
