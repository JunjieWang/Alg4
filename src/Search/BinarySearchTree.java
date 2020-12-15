package Search;

import javax.print.attribute.standard.Compression;

/**
 * @author jwang 12/14/20
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value>{
  private Node root;
  private class Node {
    private Key key;
    private Value val;
    private Node left, right;
    private int N; // total nodes of its subtree

    public Node(Key key, Value val, int N) {
      this.key = key;
      this.val = val;
      this.N = N;
    }
  }
  public int size() {
    return size(root);
  }
  private int size(Node x) {
    if (x == null) return 0;
    else return x.N;
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
    if (x == null || x.left == null) return x;
    else return min(x.left);
  }
  public Key floor(Key key) {
    Node floorNode = floor(root, key);
    if (floorNode == null) return null;
    return floorNode.key;
  }
  //find the node from that largest smaller node.
  private Node floor(Node x, Key key) {
    if (x == null) return x;
    int cmp = key.compareTo(x.key);
    if (cmp == 0) return x;
    if (cmp < 0) return floor(x.left, key);
    Node t = floor(x.right, key);
    if (t != null) return t;
    else return x;
  }
}
