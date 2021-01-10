package Search;

/**
 * @author jwang 12/17/20
 */
public class BlackRedTree<Key extends Comparable<Key>, Value> {
  private Node root;

  private boolean isRed(Node x) {
    if (x == null) {
      return false;
    }
    return x.color == COLOR.RED;
  }

  Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.color = h.color;
    h.color = COLOR.RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    return x;
  }

  Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = COLOR.RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    return x;
  }

  private int size(Node x) {
    if (x == null) {
      return 0;
    }
    return x.N;
  }

  private void flipColors(Node h) {
    h.color = COLOR.RED;
    h.left.color = COLOR.BLACK;
    h.right.color = COLOR.BLACK;
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
    root.color = COLOR.BLACK;
  }

  private Node put(Node h, Key key, Value val) {
    if (h == null) {
      return new Node(key, val, 1, COLOR.RED);
    }

    int cmp = key.compareTo(h.key);
    if (cmp < 0) {
      h.left = put(h.left, key, val);
    }
    else if (cmp > 0) {
      h.right = put(h.right, key, val);
    }
    else {
      h.val = val;
    }

    if (isRed(h.right) && !isRed(h.left)) {
      h = rotateLeft(h);
    }
    if (isRed(h.left) && isRed(h.left.left)) {
      h = rotateRight(h);
    }
    if (isRed(h.left) && isRed(h.right)) {
      flipColors(h);
    }
    h.N = size(h.left) + size(h.right) + 1;
    return h;
  }

  enum COLOR {
    RED, BLACK
  }

  private class Node {
    Key key;
    Value val;
    int N;
    Node left;
    Node right;
    COLOR color;

    Node(Key key, Value val, int N, COLOR color) {
      this.key = key;
      this.val = val;
      this.N = N;
      this.color = color;
    }

  }
}
