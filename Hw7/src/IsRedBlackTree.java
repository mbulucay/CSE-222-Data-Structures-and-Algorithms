
public class IsRedBlackTree<E extends Comparable<E>> {
	
	/**Wrapper method for 
	 * isBalancedRedBlack(BinaryTree.Node<E> ,Integer)*/
	public boolean isRedBlackTree(BinarySearchTree<E> tree) {
		return isBalancedRedBlack(tree.root,0,0);
	}
	
	/**
	* Equation must be maxH <= min*2 if this equation is not true
	* Then this tree cannot be red-black tree
	* If the equation is provided that means the tree balance enough for red black tree*/
	private boolean isBalancedRedBlack(BinaryTree.Node<E> node,Integer maxH,Integer minH) {
		
		if(node == null) { 
			maxH = minH = 0;
			return true;
		}
		Integer leftMaxH = 0, leftMinH = 0;
		Integer rightMaxH =0, rightMinH =0;
		
		if(isBalancedRedBlack(node.left, leftMaxH, leftMinH) == false)	
			return false;
		if(!isBalancedRedBlack(node.right, rightMaxH , rightMinH) == false)	
			return false;
		
		if(maxH <= minH*2)
			return true;
		
		return false;
	}
	
}
