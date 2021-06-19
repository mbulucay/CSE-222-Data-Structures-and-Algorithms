import java.util.LinkedList;
import java.util.Queue;

public class MyAvlTree<E extends Comparable<E>> implements Iterable<E>{
	
	private boolean increase;
	private AVLNode<E> root;
	
	private int nodeCount = 0;
	
	private AVLNode<E> TOKEN = new AVLNode<E>(null);
	
	protected boolean addReturn;
	
	protected E deleteReturn;
	
	public MyAvlTree() {
		
	}
	
	private static class AVLNode<E extends Comparable<E>>{
		
		E data;
		AVLNode<E> left;
		AVLNode<E> right;
		public int height;
		private int balance;
		
		AVLNode<E> parent;
		
		public AVLNode(E data) {
			this.data = data;
			left = right = parent = null;
			balance = 0;
		}
		
		@Override 
		public String toString() {
			return "(" + data + "," + balance + ")";
		}
		
	}
	
	  private boolean contains(AVLNode<E> node, E value) {
		    if (node == null) return false;

		    int cmp = value.compareTo(node.data);

		    if (cmp < 0) return contains(node.left, value);

		    if (cmp > 0) return contains(node.right, value);

		    return true;
		  }
	
	  public boolean insert(E e) {
		  
		  if (e == null) return false;
		  
		  if (!contains(root, e)) {
			  root = insert(root, e);
	      	  nodeCount++;
	      	  return true;
	      }
	      
		  return false;
	  }

	  private AVLNode<E> insert(AVLNode<E> local, E item){
		
		if (local == null) return new AVLNode<E>(item);

	    int cmp = item.compareTo(local.data);

	    // Insert node in left subtree.
	    if (cmp < 0) {
	    	local.left = insert(local.left, item);

	      // Insert node in right subtree.
	    } else {
	    	local.right = insert(local.right, item);
	    }

	    // Update balance factor and height values.
	    update(local);

	    // Re-balance tree.
	    return balance(local);
	}

	  private void update(AVLNode<E> node) {
		    int leftNodeHeight = (node.left == null) 
		    		? -1 : node.left.height;
		    int rightNodeHeight = (node.right == null) 
		    		? -1 : node.right.height;
	
		    node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
	
		    node.balance = rightNodeHeight - leftNodeHeight;
	  }
	  
	  private AVLNode<E> balance(AVLNode<E> node) {
		    
		  if (node.balance == -2) {
	
		     if (node.left.balance <= 0) 
		    	  return leftLeftCase(node);
		      
		      return leftRightCase(node);
		  }
		  else if (node.balance == +2) {
	
		      if (node.right.balance >= 0) 
		    	  return rightRightCase(node);
	
		      return rightLeftCase(node);
		  }
		  return node;
	  }
	  
	  private AVLNode<E> leftLeftCase(AVLNode<E> node) {
	    return rightRotation(node);
	  }
	
	  private AVLNode<E> leftRightCase(AVLNode<E> node) {
	    node.left = leftRotation(node.left);
	    return leftLeftCase(node);
	  }
	
	  private AVLNode<E> rightRightCase(AVLNode<E> node) {
	    return leftRotation(node);
	  }
	
	  private AVLNode<E> rightLeftCase(AVLNode<E> node) {
	    node.right = rightRotation(node.right);
	    return rightRightCase(node);
	  }
	
	  private AVLNode<E> leftRotation(AVLNode<E> node) {
		  AVLNode<E> newParent = node.right;
	    node.right = newParent.left;
	    newParent.left = node;
	    update(node);
	    update(newParent);
	    return newParent;
	  }
	
	  private AVLNode<E> rightRotation(AVLNode<E> node) {
		  AVLNode<E> newParent = node.left;
		  node.left = newParent.right;
		  newParent.right = node;
		  update(node);
		  update(newParent);
		  return newParent;
	  }
	  
	  @SuppressWarnings("hiding")
	  private class Iter<E extends Comparable<E>> implements Iterator<E>{
		  
			Queue<E> queue = new LinkedList<E>(); 
			E lastReturned = null;
			
			@SuppressWarnings("unchecked")
			public Iter() {
				loadData((AVLNode<E>) root);
			} 
			
			private void loadData(AVLNode<E> local) {
				if(local == null)
					return;
				loadData(local.left);
				queue.add(local.data);
				loadData(local.right);
			}
			
			@Override
			public E remove() {
				return null;
			}
	
			@Override
			public boolean hasNext() {
				return !queue.isEmpty();
			}
	
			@Override
			public E next() {
				return queue.poll();
			}
		  
	  }
	
	  public MyAvlTree<E> headSet(E e) {
		
		  MyAvlTree<E> headSet = new MyAvlTree<E>();
		  headSet(root,e,headSet);
		  return headSet;
	  }

	  private MyAvlTree<E> headSet(AVLNode<E> local,E item,MyAvlTree<E> headSet){
		  if(local == null)
			  return headSet;
			
		  headSet(local.left,item,headSet);
		  if(item.compareTo(local.data) > 0)
			  headSet.insert(local.data);
		  headSet(local.right,item,headSet);
		
		  return headSet;
	  }
	
	
	  public MyAvlTree<E> tailSet(E e) {
		MyAvlTree<E> tailSet = new MyAvlTree<E>();
		tailSet(root,e,tailSet);
		return tailSet;
	  }
	
	  private MyAvlTree<E> tailSet(AVLNode<E> local,E item,MyAvlTree<E> tailSet){
		if(local == null)
			return tailSet;
			
		tailSet(local.left,item,tailSet);
		if(item.compareTo(local.data) < 0)
			tailSet.insert(local.data);
		tailSet(local.right,item,tailSet);
		
		return tailSet;
	  }
	
	  public void inOrder() {
		inOrder(root,"h");
	  }
	
	  private void inOrder(AVLNode<E> local,String dir) {
		
		  if(local == null)
				return;
		
			inOrder(local.left,dir+"l");
			if(local.parent != null)
				System.out.println(dir + local + " parent : "+ local.parent.data);
			else
				System.out.println(dir + local);
			inOrder(local.right,dir+"r");
	  }

		@Override
		public Iterator<E> descendingIterator() {
			return null;
		}
	
		@Override
		public Iterator<E> iterator() {
			return new Iter<E>();
		}

	
}
