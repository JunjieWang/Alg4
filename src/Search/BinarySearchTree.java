package Search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jwang 12/14/20
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
  private Node root;

  public Key max() {
    return max(root).key;
  }

  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if (x == null) {
      return 0;
    }
    else {
      return x.N;
    }
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp == 0) return x.val;
    else if (cmp > 0) return get(x.right, key);
    else return get(x.left, key);
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
  }

  private Node put(Node x, Key key, Value val) {
    if (x == null) return new Node(key, val, 1);
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = put(x.left, key, val);
    }
    else if (cmp > 0) {
      x.right = put(x.right, key, val);
    }
    else {
    x.val = val;
    }
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  public Key min() {
    return min(root).key;
  }

  private Node min(Node x) {
    if (x == null || x.left == null) {
      return x;
    }
    else {
      return min(x.left);
    }
  }

  private Node max(Node x) {
    if (x == null || x.right == null) {
      return x;
    }
    else {
      return min(x.right);
    }
  }

  public Key select(int k) {
    return select(root, k).key;
  }

  public Key floor(Key key) {
    Node floorNode = floor(root, key);
    if (floorNode == null) {
      return null;
    }
    return floorNode.key;
  }

  //find the node from that largest smaller node.
  private Node floor(Node x, Key key) {
    if (x == null) {
      return x;
    }
    int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    }
    if (cmp < 0) {
      return floor(x.left, key);
    }
    Node t = floor(x.right, key);
    if (t != null) {
      return t;
    }
    else {
      return x;
    }
  }

  private Node select(Node x, int k) {
    if (x == null) {
      return x;
    }
    int t = size(x.left);
    if (t > k) {
      return select(x.left, k);
    }
    if (t < k) {
      return select(x.right, k);
    }
    return x;
  }

  public int rank(Key key) {
    return rank(root, key);
  }

  private int rank(Node x, Key key) {
    if (x == null) {
      return 0;
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return rank(x.left, key);
    }
    else if (cmp > 0) {
      return 1 + size(x.left) + rank(x.right, key);
    }
    else {
      return size(x.left);
    }
  }

  public void delete(Key key) {
    root = delete(root, key);
  }

  private Node delete(Node x, Key key) {
    if (x == null) {
      return x;
    }
    int cmp = key.compareTo(x.key);
    if (cmp > 0) {
      x.right = delete(x.right, key);
    }
    else if (cmp < 0) {
      x.left = delete(x.left, key);
    }
    else {
      if (x.right == null) {
        return x.left;
      }
      if (x.left == null) {
        return x.right;
      }

      Node t = x;
      x = min(t.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  private Node deleteMin(Node x) {
    if (x.left == null) {
      return x.right;
    }
    x.left = deleteMin(x.left);
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  public Iterable<Key> keys(Key lo, Key hi) {
    Queue<Key> queue = new LinkedList<>();
    keys(root, queue, lo, hi);
    return queue;
  }

  private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
    if (x == null) {
      return;
    }
    int cmplo = lo.compareTo(x.key);
    int cmphi = hi.compareTo(x.key);
    if (cmplo < 0) {
      keys(x.left, queue, lo, hi);
    }
    if (cmplo <= 0 && cmphi >= 0) {
      queue.offer(x.key);
    }
    if (cmphi > 0) {
      keys(x.right, queue, lo, hi);
    }
  }

  private class Node {
    private final Key key;
    private Value val;
    private Node left, right;
    private int N; // total nodes of its subtree

    public Node(Key key, Value val, int N) {
      this.key = key;
      this.val = val;
      this.N = N;
    }
  }
}
