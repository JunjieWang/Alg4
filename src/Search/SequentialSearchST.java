package Search;

import edu.princeton.cs.algs4.Queue;

/**
 * @author jwang 1/10/21
 */
public class SequentialSearchST<Key, Value> {
  private Node first;

  public Value get(Key key) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return x.val;
      }
    }
    return null;
  }

  public void put(Key key, Value val) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.val = val;
        return;
      }
    }

    first = new Node(key, val, first);
  }

  private class Node {
    Key key;
    Value val;
    Node next;

    public Node(Key key, Value val, Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<>();
    for (Node x = first; x != null; x = x.next) {
      queue.enqueue(x.key);
    }
    return queue;
  }
}
