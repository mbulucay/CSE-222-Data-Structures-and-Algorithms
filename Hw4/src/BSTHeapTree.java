/**Binary Search Heap Tree Class*/
public class BSTHeapTree{
	
	Node root;
	
	/**Default Constructor*/
	public BSTHeapTree() {
		root = null;
	}

	/**Half Wrapper method
	 * Adding new element to tree*/
	public int add(Integer _data) {
		Integer occurance = 0;
		root = add(root,_data,occurance);
		return occurance;
	}
	/**Return the node to add new element*/
	private Node add(Node local,Integer _data, Integer occurance){
		if(local == null) {
			Node newNode = new Node();
			occurance = newNode.add(_data);
			return newNode;
		}
		
		if(!local.h.isFull() || local.h.search(_data)) {
			occurance = local.add(_data);
			return local;
		}
		
		if(local.compareTo(_data) == 0)
			occurance = local.add(_data);
		if(local.compareTo(_data) > 0 ) 
			local.lBranch = add(local.lBranch,_data,occurance );
		if(local.compareTo(_data) < 0 )
			local.rBranch = add(local.rBranch,_data,occurance );
		
		return local;
	}
	
	/**Wrapper Method for remove element*/
	public int remove(Integer _data) {
		return remove(root, _data);
	}
	/**Removing a number in tree and returning the occurance*/
	private int remove(Node local,Integer _data) {
		
		if(local == null)
			return -1;
		
		if(local.h.search(_data)) {
			int result = local.h.removeData(_data);
			if(local.h.getSize() == 0) { 
				local.h.insert(_data);
				root = removeNode(root,local.h);
			}	
			return result;
		}
		if(local.compareTo(_data) > 0 ) 
			return remove(local.lBranch,_data);
		if(local.compareTo(_data) < 0)
			return remove(local.rBranch,_data);
		
		return -1;
	}

	/**If a node is empty then we remove the node*/
	private Node removeNode(Node local,Heap<Integer> data) {
		
		if(local == null) return local;
		
		//Direction flow of control to find data 
        if(data.compareTo(local.h) < 0) 
            local.lBranch = removeNode(local.lBranch, data);
        
        else if(data.compareTo(local.h) > 0) 
            local.rBranch = removeNode(local.rBranch, data);
         
        else {
 
        	if (local.lBranch == null)		return local.rBranch;
			else if (local.rBranch == null)	return local.lBranch;
        	//Remove one by one until reach the leaf
            local.h = minValue(local.rBranch);
            local.rBranch = removeNode(local.rBranch, local.h);
        }
 
		return local;
	}
	
	/**Returning minimum element of tree to remove method*/
    private Heap<Integer> minValue(Node node) {
    	 
        if(node.lBranch != null) 
            return minValue(node.lBranch);
        
        return node.h;
    }
	
    /**Node of Binary Search Heap Tree */
	private static class Node implements Comparable<Integer> {
		private final int maxSize = 7;
		Heap<Integer> h;
		Node lBranch;
		Node rBranch;
		
		/**Default constructor for Node*/
		public Node() {
			h = new Heap<Integer>(maxSize);
		}
		
		/**Adding new element to node*/
		public int add(Integer data) {
			return h.insert(data);
		}
		/**Compare Node*/
		@Override 
		public int compareTo(Integer o) {
			if(h.get(0).compareTo(o) > 0)
				return 1;
			else if (h.get(0).compareTo(o) < 0)
				return -1;
			
			return 0;
		}
	}
	
	/**Wrapper Method for find method
	 * Return the occurrence of getting data*/
	public int find(Integer _data) {
		return find(root, _data);
	}
	/**Return the occurrence of getting data
	 * Using recursive algorithm*/
	private int find(Node local,Integer _data) {
		
		if(local == null)
			return 0;
		
		if(local.h.search(_data))
			return local.h.find(_data);
		
		return  find(local.lBranch,_data) + find(local.rBranch,_data);
	}
	
	/**Search an element in the tree using find method's return*/
	public boolean search(Integer _data) {
		return find(_data) == 0 ? false : true;
	}
	
	/**Wrapper Method for find_mode
	 * Return the most occurrence element in the tree*/
	public Integer find_mode() {
		Integer data = null;
		
		int max = find_mode_max(root,-1,data);
		if(max != -1)
			data = find_mode_num(root,max);
			
		return data; 
	}
	
	/**Return the most occurrence counter in the tree 
	 * Compare max current max occurrence with each node of heap*/
	private Integer find_mode_max(Node local,Integer max,Integer data) {
		
		if(local == null)
			return max;
		if(local.h.maxModNumber() > max) 
			max = local.h.maxModNumber();
		
		Integer right = find_mode_max(local.rBranch,max,data);
		Integer left = find_mode_max(local.lBranch,max,data);
		
		return left > right ? left : right;
	}
	
	/**Return the most occurrence element in the tree */
	private Integer find_mode_num(Node local,Integer max) {
		
		if(local == null)
			return null;
		
		if(local.h.maxModNumber() == max)
			return local.h.mod(max);
		
		Integer num2 = find_mode_num(local.rBranch,max);
		Integer num1 = find_mode_num(local.lBranch,max);
		
		return num1 != null ? num1 : num2;
	}
	
	/**Wrapper method for printing preorder tree*/
	public void preOrder() {
		preOrder(root,"h");
	}
	/**method for printing preorder tree*/
	private void preOrder(Node local,String dir) {
		if(local == null)
			return;
		System.out.print(dir + local.h + "\n");
		
		preOrder(local.lBranch,dir+"- l ");
        preOrder(local.rBranch,dir+"- r ");
	}
	
	/**Wrapper method for printing inorder tree*/
	public void inorder() {
		inOrder(root,"h ");
	}
	/**method for printing inorder tree*/
	private void inOrder(Node local,String dir) {
		if(local == null)
			return;
		
		preOrder(local.lBranch,dir+"- l ");
		System.out.print(dir + local.h + "\n");
        preOrder(local.rBranch,dir+"- r ");
	}
}
