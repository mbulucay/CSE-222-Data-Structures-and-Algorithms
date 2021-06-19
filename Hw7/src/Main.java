import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random rand = new Random();
		
		System.out.println("========================================");
		System.out.println("=============== Part 1 =================");
		System.out.println("========================================");
		
		
		System.out.println("a) Navigable Set using skip list");
		NavigableSetSkipList<Integer> nssl = new NavigableSetSkipList<>();
		System.out.println("Default size = 2");
		System.out.println(nssl);
		System.out.println("add some random numbers");
		for(int i=0; i<13 ;++i)
			nssl.insert(rand.nextInt(1000));
		System.out.println(nssl);
		
		System.out.println("Iterate on the Navigable set skip list");
		Iterator<Integer> iter = nssl.descendingIterator();
		int a=0;
		Integer first = null,middle = null,last = null;
		while(iter.hasNext()) {
			Integer value = iter.next();
			if(a == 0)
				first = value;
			if(a == 6)
				middle = value;
			if(!iter.hasNext())
				last = value;
			++a;
			System.out.print(value + " => ");
		}
		System.out.println("Null");

		System.out.println("remove " + first);
		System.out.println("remove " + middle);
		System.out.println("remove " + last);
		System.out.println("Using delete");	
		System.out.println("nssl.delete(first);");
		System.out.println("nssl.delete(middle);");
		System.out.println("nssl.delete(last);");
		nssl.delete(first);
		nssl.delete(middle);
		nssl.delete(last);
		System.out.println("Print again using iterator");
		iter = nssl.descendingIterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " -> ");
		}
		System.out.println("Null");
		
		
		System.out.println("\n");
		System.out.println("b) Navigable set using avl tree");
		
		NavigableSetAvlTree<Integer> nsat = new NavigableSetAvlTree<>();
		nsat.inOrder();
		System.out.println("Insert some numbers");
		for(int i=0; i<23 ; ++i)
			nsat.insert(rand.nextInt(1000));
		System.out.println("Inorder print");
		nsat.inOrder();
		System.out.println("Print avl navigable set using iterator as inorder");
		Iterator<Integer> iter2 = nsat.iterator();
		Integer keep = null;
		int c = 0;
		while (iter2.hasNext()) {
			Integer value = iter2.next();
			System.out.println( value );
			if(c == 8)
				keep = value;
			++c;
		}
		System.out.println("\n");
		System.out.println("tail set of number " + keep);
		MyAvlTree<Integer> ts = nsat.tailSet(keep);
		System.out.println("Print tail set as inorder");
		ts.inOrder();
		
		System.out.println("head set of number " + keep);
		MyAvlTree<Integer> hs = nsat.headSet(keep);
		System.out.println("Print head set as inorder");
		hs.inOrder();
		
		System.out.println("\n========================================");
		System.out.println("=============== Part 2 =================");
		System.out.println("========================================");
		
		IsAvlTree<Integer> isAvl = new IsAvlTree<>();
		IsRedBlackTree<Integer> isRbt = new IsRedBlackTree<>();
		System.out.println("Create an binary tree avl tree with following values");
		BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
		System.out.println("Insert 13, 10, 19, 5 ,11 , 16");
		bst1.add(13);
		bst1.add(10);
		bst1.add(19);
		bst1.add(5);
		bst1.add(11);
		bst1.add(16);
		System.out.println("Is avl = " + isAvl.isAVL(bst1));
		System.out.println("Is rbt = " + isRbt.isRedBlackTree(bst1));
		
		System.out.println("\nCreate another bst with following values");
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		System.out.println("Insert 7, 3 , 18, 10, 22, 8, 11, 26");
		bst2.add(7);
		bst2.add(3);
		bst2.add(18);
		bst2.add(10);
		bst2.add(22);
		bst2.add(8);
		bst2.add(11);
		bst2.add(26);
		System.out.println("Is avl = " + isAvl.isAVL(bst2));
		System.out.println("Is rbt = " + isRbt.isRedBlackTree(bst2));
		
		System.out.println("\nCreate another bst with following values");
		BinarySearchTree<Integer> bst3 = new BinarySearchTree<Integer>();
		System.out.println("Insert 5, 6, 7, 8, 9, 10, 11, 12, 13");
		bst3.add(5);
		bst3.add(4);
		bst3.add(6);
		bst3.add(7);
		bst3.add(8);
		bst3.add(9);
		bst3.add(10);
		bst3.add(11);
		bst3.add(12);
		bst3.add(13);
		System.out.println("Is avl = " + isAvl.isAVL(bst3));
		System.out.println("Is rbt = " + isRbt.isRedBlackTree(bst3));
		
		System.out.println("\n========================================");
		System.out.println("=============== Part 3 =================");
		System.out.println("========================================");
		
		CompareDataStructures compareDataStructures = new CompareDataStructures();
		compareDataStructures.add10K();
		compareDataStructures.add20K();
		compareDataStructures.add40K();
		compareDataStructures.add80K();
		
		compareDataStructures.calculateBST10K();
		System.out.println("-----------------------");
		compareDataStructures.calculateBST20K();
		System.out.println("-----------------------");
		compareDataStructures.calculateBST40K();
		System.out.println("-----------------------");
		compareDataStructures.calculateBST80K();
		
		System.out.println("=============================");
		
		compareDataStructures.calculateRBT10K();
		System.out.println("-----------------------");
		compareDataStructures.calculateRBT20K();
		System.out.println("-----------------------");
		compareDataStructures.calculateRBT40K();
		System.out.println("-----------------------");
		compareDataStructures.calculateRBT80K();
		System.out.println("-----------------------");
		
		System.out.println("=============================");
		
		compareDataStructures.calculateB23Tree10K();
		System.out.println("-----------------------");
		compareDataStructures.calculateB23Tree20K();
		System.out.println("-----------------------");
		compareDataStructures.calculateB23Tree40K();
		System.out.println("-----------------------");
		compareDataStructures.calculateB23Tree80K();
		System.out.println("-----------------------");
		
		System.out.println("=============================");
		
		compareDataStructures.calculateBTree10K();
		System.out.println("-----------------------");
		compareDataStructures.calculateBTree20K();
		System.out.println("-----------------------");
		compareDataStructures.calculateBTree40K();
		System.out.println("-----------------------");
		compareDataStructures.calculateBTree80K();
		System.out.println("-----------------------");
			
		System.out.println("=============================");
		
		compareDataStructures.calculateSkipList10K();
		System.out.println("-----------------------");
		compareDataStructures.calculateSkipList20K();
		System.out.println("-----------------------");
		compareDataStructures.calculateSkipList40K();
		System.out.println("-----------------------");
		compareDataStructures.calculateSkipList80K();
		
	}
}
