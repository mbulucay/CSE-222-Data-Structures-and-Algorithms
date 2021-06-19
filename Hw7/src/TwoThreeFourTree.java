import java.util.*;

/** An implementation of the 2-3-4 tree. A 2-3-4 tree is a
*   search tree in which each node contains either one, two,
*   or three data  items and (other than leaves) two, three
*   or four children.  The tree is always balanced in that all
*   leaves are on the same level, i.e., the length of the path
*   from the root to a leaf is constant.  This data structure
*   is a special case of the B-tree, and is the basis for the
*   Red-Black tree.
*   @author Koffman and Wolfgang
*/

public class TwoThreeFourTree < E
    extends Comparable < E >>
    implements SearchTree < E > {

  // Data Fields
  /** The reference to the root. */
  private Node < E > root = null;

  // Inner Class
  /** A Node represents a node in a 2-3-4 tree. This class
      has no methods; it is merely a container of private data.
   */
  private static class Node < E > {
    // Data Fields
    /** The size of a node */
    private static final int CAP = 3;

    /** The number of data items in this node */
    private int size = 0;

    /** The information */
    private E[] data = (E[])new Comparable[CAP];

    /** The links to the children. child[i] refers to
        the subtree of children < data[i] for i < size
        and to the subtree of children > data[size - 1]
        for i == size. */
    private Node < E > [] child = new Node[CAP + 1];
  }

  /** Insert an object into the tree.
      @param obj The object to be inserted
      @return true if the item was inserted
   */
  public boolean add(E obj) {
    if (root == null) {
      root = new Node < E > ();
      root.data[0] = obj;
      root.size = 1;
      return true;
    }
    if (root.size == Node.CAP) {
      root = splitNode(root);
    }

    return add(root, obj);
  }

  /** Recursive method to insert an object into the tree.
     @param root The local root
     @param obj The item to be inserted
     @return true if the item was inserted,
             false if the item is already in the tree
   */
  private boolean add(Node < E > root, E obj) {
    int index = 0;
    while (index < root.size && obj.compareTo(root.data[index]) > 0) {
      index++;
    }
    // index == root.size or obj <= root.data[index]
    if (index != root.size && obj.compareTo(root.data[index]) == 0) {
      // Item is already in the tree.
      return false;
    }
    if (root.child[index] == null) {
      insertIntoNode(root, index, obj, null);
      return true;
    }
    else if (root.child[index].size < Node.CAP) {
      return add(root.child[index], obj);
    }
    else {
      Node < E > newParent = splitNode(root.child[index]);
      insertIntoNode(root, index,
                     newParent.data[0],
                     newParent.child[1]);

      if (obj.compareTo(root.data[index]) == 0) {
        return false;
      }
      else if (obj.compareTo(root.data[index]) < 0) {
        return add(root.child[index], obj);
      }
      else {
        return add(root.child[index + 1], obj);
      }
    }
  }

  /** Method to split a 2-3-4 node
      @param node - The node to be split
      @return A new parent for this split node
   */
  private Node < E > splitNode(Node < E > node) {
    Node < E > newParent = new Node < E > ();
    Node < E > newChild = new Node < E > ();
    newParent.size = 1;
    newParent.data[0] = node.data[1];
    newParent.child[0] = node;
    newParent.child[1] = newChild;
    newChild.size = 1;
    newChild.data[0] = node.data[2];
    newChild.child[0] = node.child[2];
    newChild.child[1] = node.child[3];
    node.size = 1;
    return newParent;
  }

  /** Method to insert a new value into a node.
      Pre: node.data[index - 1] < o < node.data[index]
      and node.size < Node.CAP
      Post: node.data[index] = o and old values are
      moved right one.
      @param node The node to insert the value
      @param index the index where the inserted item
      is to be placed
      @param obj The value to be inserted
      @param child The right child of the value
   */
  private void insertIntoNode(Node < E > node, int index,
                              E obj, Node < E > child) {
    for (int i = node.size; i > index; i--) {
      node.data[i] = node.data[i - 1];
      node.child[i + 1] = node.child[i];
    }
    node.data[index] = obj;
    node.child[index + 1] = child;
    node.size++;
  }

  /**** BEGIN EXERCISE ****/
  /** Determine if an item is in the tree
      @param target Item being sought in tree
      @return true If the item is in the tree, false otherwise
   */
  public boolean contains(E target) {
    return find(target) != null;
  }

  /** Find an object in the tree
      @param obj The object sought, must be Comparable
      @return The object in the tree, or null
      if the object is not in the tree
   */
  public E find(E obj) {
    return find(root, obj);
  }

  /** Recursive find method. Find the object
      in the node or one of its children
      @param node The node to search
      @param obj The object sought, must be Comparable
      @return The object in the tree, or null
      if the object is not in the tree
   */
  private E find(Node < E > node, E obj) {
    if (node == null) {
      return null;
    }
    int index = 0;
    while (index < node.size
           && obj.compareTo(node.data[index]) > 0) {
      index++;
    }
    if (index == node.size
        || obj.compareTo(node.data[index]) < 0) {
      return find(node.child[index], obj);
    }
    else {
      return node.data[index];
    }
  }

  /** Remove an object from the tree. This is an
      unsupported operation.
      @param obj - The object to be removed
      @return The object removed or null if not in the
      tree
      @throws UnsupportedOperationException if called.
   */
  public boolean remove(E obj) {
    throw new UnsupportedOperationException
        ("Remove from 2-3 trees not implemented");
  }

  /** Remove an object from the tree. This is an
      unsupported operation.
      @param obj - The object to be removed
      @return The object removed or null if not in the
      tree
      @throws UnsupportedOperationException if called.
   */
  public E delete(E obj) {
    throw new UnsupportedOperationException
        ("Remove from 2-3 trees not implemented");
  }

  /** Returns an iterator to the contents of the tree
      @return An iterator to the contents of the tree
   */
  public Iterator < E > iterator() {
    return new Iter();
  }

  /** Returns an iterator to the contents of the tree
      beginning at the specified item.
      @param item The item where the iteration is to start
      @return An iterator to the tree
   */
  public Iterator < E > iterator(E item) {
    return new Iter(item);
  }

  /** Return a pre-order traversal as the string
      representation of the tree
      @return a string representation of the tree
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrderTraverse(root, 0, sb);
    return sb.toString();
  }

  /** Perform a pre-order traversal
      @param node - The local root
      @param d - The depth
      @param sb - The string buffer to put the output
   */
  private void preOrderTraverse(Node < E > node, int d, StringBuilder sb) {
    for (int i = 0; i < d; i++) {
      sb.append("  ");
    }
    if (node == null) {
      sb.append("null");
    }
    else {
      for (int i = 0; i < node.size; i++) {
        sb.append(node.data[i]);
        if (i != node.size - 1) {
          sb.append(", ");
        }
      }
      sb.append("\n");
      for (int i = 0; i < node.size; i++) {
        preOrderTraverse(node.child[i], d + 1, sb);
        sb.append("\n");
      }
      preOrderTraverse(node.child[node.size], d + 1, sb);
      sb.append("\n\n");
    }
  }

  // Inner class that implements the Iterator
  /** The iterator class. This class provides an in-order
      traversal of the 2-3-4 tree.
   */
  private class Iter
      implements Iterator < E > {
    // Data Fields
    /** A reference to the node that contains the value
     *  that will be returned by next
     */
    private Node < E > current;

    /** The index of the item to be returned by next */
    private int index;

    /** The stack that contains the history back to the
        root. s.pop() will return a Pari whose first tiem
        is a reference to the parent, and a second item is
        the index of the parent.
     */
    private Stack < Pair < Node < E > , Integer >> s =
        new Stack < Pair < Node < E > , Integer >> ();

    // Constructor
    /** Construct an Iter that begins with the left-most
        item in the tree
     */
    public Iter() {
      index = 0;
      current = root;
      if (current != null) {
        while (current.child[0] != null) {
          s.push(new Pair < Node < E > , Integer > (current, index));
          current = current.child[0];
        }
      }
    }

    /** Construct an Iter that begins with the sought
        item in the three
        @param item The item where the itertion is to start
     */
    public Iter(E item) {
      s.clear();
      index = 0;
      current = root;
      while (current != null) {
        while (index < current.size
               && item.compareTo(current.data[index]) > 0) {
          index++;
        }
        if (index == current.size
            || item.compareTo(current.data[index]) < 0) {
          s.push(new Pair < Node < E > , Integer > (current, index));
          current = current.child[index];
          index = 0;
        }
        else {
          break;
        }
      }
    }

    /** Return true if next will return a value and not
        throw an exception
        @return true if next will return a value
     */
    public boolean hasNext() {
      return current != null;
    }

    /** Return the next value from the iteration. The iterator
        is then advanced to the next entry.
        @return the next value from the iteration
        @throws NoSuchElementException - iteration has
        no more elements
     */
    public E next() {
      if (current == null) {
        throw new NoSuchElementException();
      }
      E returnValue = current.data[index++];
      if (current.child[index] == null) {
        if (index < current.size) {
          return returnValue;
        }
        else {
          do {
            if (!s.empty()) {
              Pair < Node < E > , Integer > p = s.pop();
              current = p.first;
              index = p.second;
            }
            else {
              current = null;
            }
          }
          while (current != null && index == current.size);
          return returnValue;
        }
      }
      else {
        while (current.child[index] != null) {
          s.push(new Pair < Node < E > , Integer > (current, index));
          current = current.child[index];
          index = 0;
        }
        return returnValue;
      }
    }

    /** Remove is not supported
     * @return 
        @throws UnsupportedOperationException()
     */
    public E remove() {
      throw new UnsupportedOperationException
          ("Remove from two-three trees is not supported");
    }
  }

  /**** END EXERCISE ****/
}
