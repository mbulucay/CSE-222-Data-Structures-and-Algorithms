import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class CompareDataStructures{
	
	/**Random creater*/
	private Random rand = new Random();
	
	/**Random numbers set*/
	private Set<Integer> Numbers_10000 = null;
	private Set<Integer> Numbers_20000 = null;
	private Set<Integer> Numbers_40000 = null;
	private Set<Integer> Numbers_80000 = null;
	
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private BinarySearchTree<Integer> bst10_0 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_1 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_2 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_3 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_4 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_5 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_6 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_7 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_8 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst10_9 = new BinarySearchTree<>();
	
	private BinarySearchTree<Integer> bst20_0 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_1 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_2 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_3 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_4 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_5 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_6 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_7 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_8 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst20_9 = new BinarySearchTree<>();
	
	private BinarySearchTree<Integer> bst40_0 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_1 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_2 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_3 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_4 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_5 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_6 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_7 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_8 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst40_9 = new BinarySearchTree<>();
	
	private BinarySearchTree<Integer> bst80_0 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_1 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_2 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_3 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_4 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_5 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_6 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_7 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_8 = new BinarySearchTree<>();
	private BinarySearchTree<Integer> bst80_9 = new BinarySearchTree<>();

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

	private RedBlackTree<Integer> rbt10_0 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_1 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_2 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_3 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_4 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_5 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_6 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_7 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_8 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt10_9 = new RedBlackTree<>();
	
	private RedBlackTree<Integer> rbt20_0 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_1 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_2 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_3 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_4 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_5 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_6 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_7 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_8 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt20_9 = new RedBlackTree<>();
	
	private RedBlackTree<Integer> rbt40_0 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_1 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_2 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_3 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_4 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_5 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_6 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_7 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_8 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt40_9 = new RedBlackTree<>();
	
	private RedBlackTree<Integer> rbt80_0 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_1 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_2 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_3 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_4 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_5 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_6 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_7 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_8 = new RedBlackTree<>();
	private RedBlackTree<Integer> rbt80_9 = new RedBlackTree<>();
	
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private BTree<Integer> B23Tree10_0 = new BTree<>(3);
	private BTree<Integer> B23Tree10_1 = new BTree<>(3);
	private BTree<Integer> B23Tree10_2 = new BTree<>(3);
	private BTree<Integer> B23Tree10_3 = new BTree<>(3);
	private BTree<Integer> B23Tree10_4 = new BTree<>(3);
	private BTree<Integer> B23Tree10_5 = new BTree<>(3);
	private BTree<Integer> B23Tree10_6 = new BTree<>(3);
	private BTree<Integer> B23Tree10_7 = new BTree<>(3);
	private BTree<Integer> B23Tree10_8 = new BTree<>(3);
	private BTree<Integer> B23Tree10_9 = new BTree<>(3);
	
	private BTree<Integer> B23Tree20_0 = new BTree<>(3);
	private BTree<Integer> B23Tree20_1 = new BTree<>(3);
	private BTree<Integer> B23Tree20_2 = new BTree<>(3);
	private BTree<Integer> B23Tree20_3 = new BTree<>(3);
	private BTree<Integer> B23Tree20_4 = new BTree<>(3);
	private BTree<Integer> B23Tree20_5 = new BTree<>(3);
	private BTree<Integer> B23Tree20_6 = new BTree<>(3);
	private BTree<Integer> B23Tree20_7 = new BTree<>(3);
	private BTree<Integer> B23Tree20_8 = new BTree<>(3);
	private BTree<Integer> B23Tree20_9 = new BTree<>(3);
	
	private BTree<Integer> B23Tree40_0 = new BTree<>(3);
	private BTree<Integer> B23Tree40_1 = new BTree<>(3);
	private BTree<Integer> B23Tree40_2 = new BTree<>(3);
	private BTree<Integer> B23Tree40_3 = new BTree<>(3);
	private BTree<Integer> B23Tree40_4 = new BTree<>(3);
	private BTree<Integer> B23Tree40_5 = new BTree<>(3);
	private BTree<Integer> B23Tree40_6 = new BTree<>(3);
	private BTree<Integer> B23Tree40_7 = new BTree<>(3);
	private BTree<Integer> B23Tree40_8 = new BTree<>(3);
	private BTree<Integer> B23Tree40_9 = new BTree<>(3);
	
	private BTree<Integer> B23Tree80_0 = new BTree<>(3);
	private BTree<Integer> B23Tree80_1 = new BTree<>(3);
	private BTree<Integer> B23Tree80_2 = new BTree<>(3);
	private BTree<Integer> B23Tree80_3 = new BTree<>(3);
	private BTree<Integer> B23Tree80_4 = new BTree<>(3);
	private BTree<Integer> B23Tree80_5 = new BTree<>(3);
	private BTree<Integer> B23Tree80_6 = new BTree<>(3);
	private BTree<Integer> B23Tree80_7 = new BTree<>(3);
	private BTree<Integer> B23Tree80_8 = new BTree<>(3);
	private BTree<Integer> B23Tree80_9 = new BTree<>(3);
	
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private BTree<Integer> BTree10_0 = new BTree<>(111);
	private BTree<Integer> BTree10_1 = new BTree<>(111);
	private BTree<Integer> BTree10_2 = new BTree<>(111);
	private BTree<Integer> BTree10_3 = new BTree<>(111);
	private BTree<Integer> BTree10_4 = new BTree<>(111);
	private BTree<Integer> BTree10_5 = new BTree<>(111);
	private BTree<Integer> BTree10_6 = new BTree<>(111);
	private BTree<Integer> BTree10_7 = new BTree<>(111);
	private BTree<Integer> BTree10_8 = new BTree<>(111);
	private BTree<Integer> BTree10_9 = new BTree<>(111);
	
	private BTree<Integer> BTree20_0 = new BTree<>(111);
	private BTree<Integer> BTree20_1 = new BTree<>(111);
	private BTree<Integer> BTree20_2 = new BTree<>(111);
	private BTree<Integer> BTree20_3 = new BTree<>(111);
	private BTree<Integer> BTree20_4 = new BTree<>(111);
	private BTree<Integer> BTree20_5 = new BTree<>(111);
	private BTree<Integer> BTree20_6 = new BTree<>(111);
	private BTree<Integer> BTree20_7 = new BTree<>(111);
	private BTree<Integer> BTree20_8 = new BTree<>(111);
	private BTree<Integer> BTree20_9 = new BTree<>(111);
	
	private BTree<Integer> BTree40_0 = new BTree<>(111);
	private BTree<Integer> BTree40_1 = new BTree<>(111);
	private BTree<Integer> BTree40_2 = new BTree<>(111);
	private BTree<Integer> BTree40_3 = new BTree<>(111);
	private BTree<Integer> BTree40_4 = new BTree<>(111);
	private BTree<Integer> BTree40_5 = new BTree<>(111);
	private BTree<Integer> BTree40_6 = new BTree<>(111);
	private BTree<Integer> BTree40_7 = new BTree<>(111);
	private BTree<Integer> BTree40_8 = new BTree<>(111);
	private BTree<Integer> BTree40_9 = new BTree<>(111);
	
	private BTree<Integer> BTree80_0 = new BTree<>(111);
	private BTree<Integer> BTree80_1 = new BTree<>(111);
	private BTree<Integer> BTree80_2 = new BTree<>(111);
	private BTree<Integer> BTree80_3 = new BTree<>(111);
	private BTree<Integer> BTree80_4 = new BTree<>(111);
	private BTree<Integer> BTree80_5 = new BTree<>(111);
	private BTree<Integer> BTree80_6 = new BTree<>(111);
	private BTree<Integer> BTree80_7 = new BTree<>(111);
	private BTree<Integer> BTree80_8 = new BTree<>(111);
	private BTree<Integer> BTree80_9 = new BTree<>(111);
	
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private SkipList<Integer> skip10_0 = new SkipList<>();
	private SkipList<Integer> skip10_1 = new SkipList<>();
	private SkipList<Integer> skip10_2 = new SkipList<>();
	private SkipList<Integer> skip10_3 = new SkipList<>();
	private SkipList<Integer> skip10_4 = new SkipList<>();
	private SkipList<Integer> skip10_5 = new SkipList<>();
	private SkipList<Integer> skip10_6 = new SkipList<>();
	private SkipList<Integer> skip10_7 = new SkipList<>();
	private SkipList<Integer> skip10_8 = new SkipList<>();
	private SkipList<Integer> skip10_9 = new SkipList<>();
	
	private SkipList<Integer> skip20_0 = new SkipList<>();
	private SkipList<Integer> skip20_1 = new SkipList<>();
	private SkipList<Integer> skip20_2 = new SkipList<>();
	private SkipList<Integer> skip20_3 = new SkipList<>();
	private SkipList<Integer> skip20_4 = new SkipList<>();
	private SkipList<Integer> skip20_5 = new SkipList<>();
	private SkipList<Integer> skip20_6 = new SkipList<>();
	private SkipList<Integer> skip20_7 = new SkipList<>();
	private SkipList<Integer> skip20_8 = new SkipList<>();
	private SkipList<Integer> skip20_9 = new SkipList<>();
	
	private SkipList<Integer> skip40_0 = new SkipList<>();
	private SkipList<Integer> skip40_1 = new SkipList<>();
	private SkipList<Integer> skip40_2 = new SkipList<>();
	private SkipList<Integer> skip40_3 = new SkipList<>();
	private SkipList<Integer> skip40_4 = new SkipList<>();
	private SkipList<Integer> skip40_5 = new SkipList<>();
	private SkipList<Integer> skip40_6 = new SkipList<>();
	private SkipList<Integer> skip40_7 = new SkipList<>();
	private SkipList<Integer> skip40_8 = new SkipList<>();
	private SkipList<Integer> skip40_9 = new SkipList<>();
	
	private SkipList<Integer> skip80_0 = new SkipList<>();
	private SkipList<Integer> skip80_1 = new SkipList<>();
	private SkipList<Integer> skip80_2 = new SkipList<>();
	private SkipList<Integer> skip80_3 = new SkipList<>();
	private SkipList<Integer> skip80_4 = new SkipList<>();
	private SkipList<Integer> skip80_5 = new SkipList<>();
	private SkipList<Integer> skip80_6 = new SkipList<>();
	private SkipList<Integer> skip80_7 = new SkipList<>();
	private SkipList<Integer> skip80_8 = new SkipList<>();
	private SkipList<Integer> skip80_9 = new SkipList<>();
	
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public CompareDataStructures() {}
	
	public Set<Integer> createRandomSets(int size) {
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		while(set.size() != size)
			set.add(rand.nextInt());
			
		return set;
	}
	
////////////////////////////////////////////////////////////////
	
	private void add10K_0(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_0.add(value);
			rbt10_0.add(value);
			B23Tree10_0.add(value);
			BTree10_0.add(value);
			skip10_0.insert(value);
		}
	}
	
	private void add10K_1(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_1.add(value);
			rbt10_1.add(value);
			B23Tree10_1.add(value);
			BTree10_1.add(value);
			skip10_1.insert(value);
		}
	}
	
	private void add10K_2(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_2.add(value);
			rbt10_2.add(value);
			B23Tree10_2.add(value);
			BTree10_2.add(value);
			skip10_2.insert(value);
		}
	}
	
	private void add10K_3(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_3.add(value);
			rbt10_3.add(value);
			B23Tree10_3.add(value);
			BTree10_3.add(value);
			skip10_3.insert(value);
		}
	}
	
	private void add10K_4(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_4.add(value);
			rbt10_4.add(value);
			B23Tree10_4.add(value);
			BTree10_4.add(value);
			skip10_4.insert(value);
		}
	}
	
	private void add10K_5(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_5.add(value);
			rbt10_5.add(value);
			B23Tree10_5.add(value);
			BTree10_5.add(value);
			skip10_5.insert(value);
		}
	}
	
	private void add10K_6(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_6.add(value);
			rbt10_6.add(value);
			B23Tree10_6.add(value);
			BTree10_6.add(value);
			skip10_6.insert(value);
		}
	}
	
	private void add10K_7(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_7.add(value);
			rbt10_7.add(value);
			B23Tree10_7.add(value);
			BTree10_7.add(value);
			skip10_7.insert(value);
		}
	}
	
	private void add10K_8(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_8.add(value);
			rbt10_8.add(value);
			B23Tree10_8.add(value);
			BTree10_8.add(value);
			skip10_8.insert(value);
		}
	}
	
	private void add10K_9(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst10_9.add(value);
			rbt10_9.add(value);
			B23Tree10_9.add(value);
			BTree10_9.add(value);
			skip10_9.insert(value);
		}
	}
	
////////////////////////////////////////////////////////////////
	
	private void add20K_0(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_0.add(value);
			rbt20_0.add(value);
			B23Tree20_0.add(value);
			BTree20_0.add(value);
			skip20_0.insert(value);
		}
	}
	
	private void add20K_1(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_1.add(value);
			rbt20_1.add(value);
			B23Tree20_1.add(value);
			BTree20_1.add(value);
			skip20_1.insert(value);
		}
	}
	
	private void add20K_2(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_2.add(value);
			rbt20_2.add(value);
			B23Tree20_2.add(value);
			BTree20_2.add(value);
			skip20_2.insert(value);
		}
	}
	
	private void add20K_3(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_3.add(value);
			rbt20_3.add(value);
			B23Tree20_3.add(value);
			BTree20_3.add(value);
			skip20_3.insert(value);
		}
	}
	
	private void add20K_4(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_4.add(value);
			rbt20_4.add(value);
			B23Tree20_4.add(value);
			BTree20_4.add(value);
			skip20_4.insert(value);
		}
	}
	
	private void add20K_5(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_5.add(value);
			rbt20_5.add(value);
			B23Tree20_5.add(value);
			BTree20_5.add(value);
			skip20_5.insert(value);
		}
	}
	
	private void add20K_6(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_6.add(value);
			rbt20_6.add(value);
			B23Tree20_6.add(value);
			BTree20_6.add(value);
			skip20_6.insert(value);
		}
	}
	
	private void add20K_7(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_7.add(value);
			rbt20_7.add(value);
			B23Tree20_7.add(value);
			BTree20_7.add(value);
			skip20_7.insert(value);
		}
	}
	
	private void add20K_8(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_8.add(value);
			rbt20_8.add(value);
			B23Tree20_8.add(value);
			BTree20_8.add(value);
			skip20_8.insert(value);
		}
	}
	
	private void add20K_9(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst20_9.add(value);
			rbt20_9.add(value);
			B23Tree20_9.add(value);
			BTree20_9.add(value);
			skip20_9.insert(value);
		}
	}
		
////////////////////////////////////////////////////////////////
	
	private void add40K_0(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_0.add(value);
			rbt40_0.add(value);
			B23Tree40_0.add(value);
			BTree40_0.add(value);
			skip40_0.insert(value);
		}
	}
	
	private void add40K_1(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_1.add(value);
			rbt40_1.add(value);
			B23Tree40_1.add(value);
			BTree40_1.add(value);
			skip40_1.insert(value);
		}
	}
	
	private void add40K_2(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_2.add(value);
			rbt40_2.add(value);
			B23Tree40_2.add(value);
			BTree40_2.add(value);
			skip40_2.insert(value);
		}
	}
	
	private void add40K_3(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_3.add(value);
			rbt40_3.add(value);
			B23Tree40_3.add(value);
			BTree40_3.add(value);
			skip40_3.insert(value);
		}
	}
	
	private void add40K_4(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_4.add(value);
			rbt40_4.add(value);
			B23Tree40_4.add(value);
			BTree40_4.add(value);
			skip40_4.insert(value);
		}
	}
	
	private void add40K_5(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_5.add(value);
			rbt40_5.add(value);
			B23Tree40_5.add(value);
			BTree40_5.add(value);
			skip40_5.insert(value);
		}
	}
	
	private void add40K_6(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_6.add(value);
			rbt40_6.add(value);
			B23Tree40_6.add(value);
			BTree40_6.add(value);
			skip40_6.insert(value);
		}
	}
	
	private void add40K_7(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_7.add(value);
			rbt40_7.add(value);
			B23Tree40_7.add(value);
			BTree40_7.add(value);
			skip40_7.insert(value);
		}
	}
		
	private void add40K_8(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_8.add(value);
			rbt40_8.add(value);
			B23Tree40_8.add(value);
			BTree40_8.add(value);
			skip40_8.insert(value);
		}
	}
	
	private void add40K_9(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst40_9.add(value);
			rbt40_9.add(value);
			B23Tree40_9.add(value);
			BTree40_9.add(value);
			skip40_9.insert(value);
		}
	}
	
////////////////////////////////////////////////////////////////
	
	private void add80K_0(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_0.add(value);
			rbt80_0.add(value);
			B23Tree80_0.add(value);
			BTree80_0.add(value);
			skip80_0.insert(value);
		}
	}
	
	private void add80K_1(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_1.add(value);
			rbt80_1.add(value);
			B23Tree80_1.add(value);
			BTree80_1.add(value);
			skip80_1.insert(value);
		}
	}
	
	private void add80K_2(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_2.add(value);
			rbt80_2.add(value);
			B23Tree80_2.add(value);
			BTree80_2.add(value);
			skip80_2.insert(value);
		}
	}
	
	private void add80K_3(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_3.add(value);
			rbt80_3.add(value);
			B23Tree80_3.add(value);
			BTree80_3.add(value);
			skip80_3.insert(value);
		}
	}
	
	private void add80K_4(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_4.add(value);
			rbt80_4.add(value);
			B23Tree80_4.add(value);
			BTree80_4.add(value);
			skip80_4.insert(value);
		}
	}
	
	private void add80K_5(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_5.add(value);
			rbt80_5.add(value);
			B23Tree80_5.add(value);
			BTree80_5.add(value);
			skip80_5.insert(value);
		}
	}
	
	private void add80K_6(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_6.add(value);
			rbt80_6.add(value);
			B23Tree80_6.add(value);
			BTree80_6.add(value);
			skip80_6.insert(value);
		}
	}
	
	private void add80K_7(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_7.add(value);
			rbt80_7.add(value);
			B23Tree80_7.add(value);
			BTree80_7.add(value);
			skip80_7.insert(value);
		}
	}
	
	private void add80K_8(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_8.add(value);
			rbt80_8.add(value);
			B23Tree80_8.add(value);
			BTree80_8.add(value);
			skip80_8.insert(value);
		}
	}
	
	private void add80K_9(Set<Integer> set) {
		java.util.Iterator<Integer> iter =  set.iterator();
		while(iter.hasNext()) {
			Integer value = iter.next();
			bst80_9.add(value);
			rbt80_9.add(value);
			B23Tree80_9.add(value);
			BTree80_9.add(value);
			skip80_9.insert(value);
		}
	}
	
////////////////////////////////////////////////////////////////
	
	public void add10K() {
		
		Numbers_10000 = createRandomSets(10000);
		add10K_0(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_1(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_2(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_3(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_4(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_5(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_6(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_7(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_8(Numbers_10000);
		Numbers_10000 = createRandomSets(10000);
		add10K_9(Numbers_10000);
	}
	
	public void add20K() {
		
		Numbers_20000 = createRandomSets(20000);
		add20K_0(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_1(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_2(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_3(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_4(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_5(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_6(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_7(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_8(Numbers_20000);
		Numbers_20000 = createRandomSets(20000);
		add20K_9(Numbers_20000);
	}
	
	public void add40K() {
		Numbers_40000 = createRandomSets(40000);
		add40K_0(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_1(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_2(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_3(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_4(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_5(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_6(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_7(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_8(Numbers_40000);
		Numbers_40000 = createRandomSets(40000);
		add40K_9(Numbers_40000);
	}
	
	public void add80K() {
		Numbers_80000 = createRandomSets(80000);
		add80K_0(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_1(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_2(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_3(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_4(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_5(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_6(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_7(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_8(Numbers_80000);
		Numbers_80000 = createRandomSets(80000);
		add80K_9(Numbers_80000);
	}

////////////////////////////////////////////////////////////////
	
	public Double calculateBST10K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			bst10_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			bst10_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			bst10_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			bst10_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			bst10_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			bst10_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			bst10_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			bst10_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			bst10_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			bst10_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("BST_10K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("Average for BST 10K avg = " + (totalTime / 10.0));
		
		return (totalTime / 10.0);
	}
	
	public Double calculateBST20K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			bst20_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			bst20_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			bst20_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			bst20_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			bst20_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			bst20_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			bst20_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			bst20_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			bst20_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			bst20_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("BST_20K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("Average for BST 20K avg = " + (totalTime / 10.0));
		return (totalTime / 10.0);
	}
	
	public Double calculateBST40K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			bst40_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			bst40_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			bst40_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			bst40_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			bst40_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			bst40_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			bst40_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			bst40_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			bst40_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			bst40_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("BST_40K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("Average for BST 40K avg = " + (totalTime / 10.0));
		
		return  (totalTime / 10.0);
	}
	
	public Double calculateBST80K() {
		
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			bst80_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			bst80_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			bst80_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			bst80_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			bst80_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			bst80_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			bst80_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			bst80_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			bst80_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			bst80_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("BST_80K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("Average for BST 80K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}
	
////////////////////////////////////////////////////////////////
	
	public Double calculateRBT10K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			rbt10_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			rbt10_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			rbt10_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			rbt10_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			rbt10_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			rbt10_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			rbt10_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			rbt10_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			rbt10_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			rbt10_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_10K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("Average for RBT 10K avg = " + (totalTime / 10.0));

		return  (totalTime / 10.0);
	}
	
	public Double calculateRBT20K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			rbt20_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			rbt20_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			rbt20_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			rbt20_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			rbt20_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			rbt20_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			rbt20_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			rbt20_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			rbt20_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			rbt20_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_20K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("Average for RBT 20K avg = " + (totalTime / 10.0));
		
		return  (totalTime / 10.0);
	}
	
	public Double calculateRBT40K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			rbt40_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			rbt40_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			rbt40_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			rbt40_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			rbt40_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			rbt40_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			rbt40_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			rbt40_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			rbt40_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			rbt40_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_40K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("Average for RBT 40K avg = " + (totalTime / 10.0));
		
		return  (totalTime / 10.0);
	}
	
	public Double calculateRBT80K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			rbt80_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			rbt80_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			rbt80_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			rbt80_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			rbt80_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			rbt80_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			rbt80_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			rbt80_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			rbt80_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			rbt80_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("RBT_80K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("Average for RBT 80K avg= " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}
	
////////////////////////////////////////////////////////////////

	public Double calculateB23Tree10K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			B23Tree10_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			B23Tree10_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			B23Tree10_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			B23Tree10_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			B23Tree10_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			B23Tree10_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			B23Tree10_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			B23Tree10_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			B23Tree10_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			B23Tree10_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_10K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("23BTree for 10K avg = " + (totalTime / 10.0));
		
		return  (totalTime / 10.0);
	}
	
	public Double calculateB23Tree20K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			B23Tree20_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			B23Tree20_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			B23Tree20_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			B23Tree20_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			B23Tree20_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			B23Tree20_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			B23Tree20_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			B23Tree20_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			B23Tree20_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			B23Tree20_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_20K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("23BTree for 20K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}
	
	public Double calculateB23Tree40K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			B23Tree40_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			B23Tree40_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			B23Tree40_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			B23Tree40_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			B23Tree40_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			B23Tree40_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			B23Tree40_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			B23Tree40_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			B23Tree40_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			B23Tree40_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_40K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("23BTree for 40K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}
	
	public Double calculateB23Tree80K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			B23Tree80_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			B23Tree80_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			B23Tree80_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			B23Tree80_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			B23Tree80_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			B23Tree80_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			B23Tree80_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			B23Tree80_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			B23Tree80_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			B23Tree80_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("23BTree_80K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("23BTree for 80K avg = " + (totalTime / 10.0));
		
		return  (totalTime / 10.0);
	}

////////////////////////////////////////////////////////////////
	
	public Double calculateBTree10K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			BTree10_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			BTree10_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			BTree10_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			BTree10_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			BTree10_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			BTree10_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			BTree10_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			BTree10_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			BTree10_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			BTree10_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_10K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("BTree for 10K avg = " + (totalTime / 10.0));
		
		return  (totalTime / 10.0);
	}

	public Double calculateBTree20K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			BTree20_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			BTree20_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			BTree20_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			BTree20_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			BTree20_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			BTree20_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			BTree20_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			BTree20_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			BTree20_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			BTree20_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_20K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("BTree for 20K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}

	public Double calculateBTree40K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			BTree40_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			BTree40_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			BTree40_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			BTree40_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			BTree40_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			BTree40_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			BTree40_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			BTree40_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			BTree40_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			BTree40_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_40K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("BTree for 40K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}
	
	public Double calculateBTree80K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			BTree80_0.add(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			BTree80_1.add(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			BTree80_2.add(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			BTree80_3.add(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			BTree80_4.add(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			BTree80_5.add(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			BTree80_6.add(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			BTree80_7.add(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			BTree80_8.add(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			BTree80_9.add(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("BTree_80K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;

		System.out.println("BTree for 80K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}

////////////////////////////////////////////////////////////////
	
	public Double calculateSkipList10K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			skip10_0.insert(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			skip10_1.insert(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			skip10_2.insert(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			skip10_3.insert(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			skip10_4.insert(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			skip10_5.insert(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			skip10_6.insert(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			skip10_7.insert(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			skip10_8.insert(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			skip10_9.insert(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_10K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		System.out.println("Skip List for 10K avg = " + (totalTime / 10.0));
		
		return  (totalTime / 10.0);
	}
	
	public Double calculateSkipList20K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			skip20_0.insert(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			skip20_1.insert(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			skip20_2.insert(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			skip20_3.insert(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			skip20_4.insert(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			skip20_5.insert(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			skip20_6.insert(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			skip20_7.insert(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			skip20_8.insert(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			skip20_9.insert(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_20K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		System.out.println("Skip List for 20K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}
	
	public Double calculateSkipList40K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			skip40_0.insert(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			skip40_1.insert(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			skip40_2.insert(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			skip40_3.insert(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			skip40_4.insert(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			skip40_5.insert(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			skip40_6.insert(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			skip40_7.insert(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			skip40_8.insert(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			skip40_9.insert(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_40K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		System.out.println("Skip List for 40K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}
	
	public Double calculateSkipList80K() {
		
		Double totalTime = 0.0;
		long startTime,endTime;
		
		Set<Integer> set =  createRandomSets(100);
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_0 = set.iterator();
		while(iter_0.hasNext())
			skip80_0.insert(iter_0.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_0 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_1 = set.iterator();
		while(iter_1.hasNext())
			skip80_1.insert(iter_1.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_1 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_2 = set.iterator();
		while(iter_2.hasNext())
			skip80_2.insert(iter_2.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_2 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_3 = set.iterator();
		while(iter_3.hasNext())
			skip80_3.insert(iter_3.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_3 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_4 = set.iterator();
		while(iter_4.hasNext())
			skip80_4.insert(iter_4.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_4 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_5 = set.iterator();
		while(iter_5.hasNext())
			skip80_5.insert(iter_5.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_5 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_6 = set.iterator();
		while(iter_6.hasNext())
			skip80_6.insert(iter_6.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_6 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_7 = set.iterator();
		while(iter_7.hasNext())
			skip80_7.insert(iter_7.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_7 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_8 = set.iterator();
		while(iter_8.hasNext())
			skip80_8.insert(iter_8.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_8 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		startTime = System.nanoTime();
		java.util.Iterator<Integer> iter_9 = set.iterator();
		while(iter_9.hasNext())
			skip80_9.insert(iter_9.next());
		endTime   = System.nanoTime();
		System.out.println("SkipList_80K_9 : " + (endTime - startTime));
		totalTime += endTime - startTime;
		
		System.out.println("Skip List for 80K avg = " + (totalTime / 10.0));
		return  (totalTime / 10.0);
	}
	
////////////////////////////////////////////////////////////////
	
	
	
	
}
