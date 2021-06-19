
public class IsAvlTree <E extends Comparable<E>>{
	
	/**The different between left and right branch for each node
	 * Must 1 or 0 other wise.It cannot accept as Avl Tree*/
	public boolean isAVL(BinarySearchTree<E> tree) {
		return isBalanced(tree.root);
	}
	
	/**Is balanced avl tree control function*/
	private boolean isBalanced(BinaryTree.Node<E> node){
		
        if (node == null)
            return true;
        // Between left and right tree the different of high must be 1 or 0 
        // Otherwise the tree is not available for being avl tree
        if (Math.abs(heightOfNode(node.left) - heightOfNode(node.right)) <= 1
            && isBalanced(node.left)
            && isBalanced(node.right)) {
            return true;
		}
        return false;
    }
	
	/**Calculating the height of tree node*/
	private int heightOfNode(BinaryTree.Node<E> node){
        if (node == null)
            return 0;
        return 1 + Math.max(heightOfNode(node.left), heightOfNode(node.right));
    }
	
}
