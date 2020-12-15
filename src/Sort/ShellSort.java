package Sort;

import java.util.stream.Stream;

/**
 * @author jwang 12/13/20
 */
public class ShellSort {

  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;
    while (h < N/3) h = 3*h + 1;
    while(h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >=h && Sort.less(a[j], a[j-h]); j -= h) {
          Sort.exch(a, j, j-h);
        }
      }
      h /= 3;
    }
  }

  public static void main(String[] args) {
    String a = "SORTEXAMPLE";
    char[] array = a.toCharArray();
    String[] strArray = Stream.of(array).map(String::valueOf).toArray(String[]::new);
    sort(strArray);
    assert Sort.isSorted(strArray);
  }
}
