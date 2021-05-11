
public class Main {

	public static void main(String[] args) {
		
		System.out.println("==============================================");
		System.out.println("============= HASH MAP CLASS TEST ============");
		System.out.println("==============================================");
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		for(int i=0; i<10;++i)
			hm.put(i, i*i);
		
		System.out.println("Our hash map");
		System.out.println(hm);
		
		System.out.println("\nNo parameter Constructor");
		MapIterator <Integer,Integer> it = hm.MapIterator();
		
		System.out.println("\nhasNext() = " + it.hasNext() + "\n");
		System.out.println("Move forward");
		while(it.hasNext()) 
			System.out.println(it.next());
		System.out.println("\nhasNext() = " + it.hasNext() + "\n");
		
		System.out.println("\nhasPrev() = " + it.hasPrev() + "\n");
		System.out.println("Move backward");
		while(it.hasPrev()) 
			System.out.println(it.prev());
		System.out.println("\nhasPrev() = " + it.hasPrev());
		
		System.out.println("\nParameter Constructor key = 5");
		MapIterator <Integer,Integer> it2 = hm.MapIterator(5);
		
		System.out.println("\nhasNext() = " + it2.hasNext() + "\n");
		System.out.println("Move forward");
		while(it2.hasNext()) 
			System.out.println(it2.next());
		System.out.println("\nhasNext() = " + it2.hasNext());
		
		System.out.println("\nhasPrev() = " + it2.hasPrev() + "\n");
		System.out.println("Move backward");
		while(it2.hasPrev()) 
			System.out.println(it2.prev());
		System.out.println("\nhasPrev() = " + it2.hasPrev());
		
		System.out.println("\nTry a key not in hash map key = 58");
		MapIterator <Integer,Integer> it3 = hm.MapIterator(58);
		System.out.println(it3.next());
		System.out.println(it3.next());
		System.out.println(it3.next());
		System.out.println("...");
		
		MapIterator <Integer,Integer> it4 = hm.MapIterator(5);
		System.out.println("\nMove forward and bacward using next() and prev() method" );
		System.out.println(it4.next());
		System.out.println(it4.next());
		System.out.println(it4.next());
		System.out.println(it4.prev());
		System.out.println(it4.prev());
		System.out.println(it4.prev());
		System.out.println(it4.next());
		System.out.println(it4.next());
		System.out.println(it4.next());
		System.out.println(it4.next());
		System.out.println(it4.next());
		System.out.println(it4.prev());
		System.out.println(it4.prev());
		System.out.println(it4.prev());
		
////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n\n");

		System.out.println("==============================================");
		System.out.println("===== Hash Chain Linked List Class Test ======");
		System.out.println("==============================================");

		
		HashtableLinkedListChain<Integer, Integer> hlc = new HashtableLinkedListChain<>();
		System.out.println("Size = " + hlc.size());
		System.out.println("Is Empty = " + hlc.isEmpty() + "\n");
		System.out.println("Put 150 element");
		for(int i=0; i<150; ++i)
			hlc.put(i,i*i);
		
		System.out.println(hlc);
		
		System.out.println();
		System.out.println("get(100) = " + hlc.get(100));
		System.out.println("get(16) = " + hlc.get(16));
		System.out.println("get(200) = " + hlc.get(200));
		System.out.println("get(-13) = " + hlc.get(-13));
		System.out.println();
		
		System.out.println("put 50 more element");
		for(int i=150; i<200; ++i)
			hlc.put(i,i*i);
		
		System.out.println(hlc);
		
		System.out.println("remove some values\n");
		
		System.out.println( "hlc.remove(111) = "+ hlc.remove(111));
		System.out.println( "hlc.remove(112) = "+ hlc.remove(112));
		System.out.println( "hlc.remove(113) = "+ hlc.remove(113));
		System.out.println( "hlc.remove(114) = "+ hlc.remove(114));
		
		System.out.println( "hlc.remove(51) = "+ hlc.remove(51));
		System.out.println( "hlc.remove(52) = "+ hlc.remove(52));
		System.out.println( "hlc.remove(53) = "+ hlc.remove(53));
		System.out.println( "hlc.remove(54) = "+ hlc.remove(54));
		
		System.out.println( "hlc.remove(41) = "+ hlc.remove(41));
		System.out.println( "hlc.remove(61) = "+ hlc.remove(61));
		System.out.println( "hlc.remove(71) = "+ hlc.remove(71));
		System.out.println( "hlc.remove(81) = "+ hlc.remove(81));
		System.out.println( "hlc.remove(91) = "+ hlc.remove(91));
		
		System.out.println( "hlc.remove(28) = "+ hlc.remove(28));
		System.out.println( "hlc.remove(38) = "+ hlc.remove(38));
		System.out.println( "hlc.remove(48) = "+ hlc.remove(48));
		System.out.println( "hlc.remove(58) = "+ hlc.remove(58));
		System.out.println( "hlc.remove(68) = "+ hlc.remove(68));
		
		System.out.println( "hlc.remove(99) = "+ hlc.remove(99));
		System.out.println( "hlc.remove(100) = "+ hlc.remove(100));
		
		System.out.println("\nAfter removing");
		System.out.println(hlc);
		
		System.out.println("Remove non existing key");
		System.out.println("hlc.remove(-150) = " + hlc.remove(-150));
		System.out.println("hlc.remove(350) = " + hlc.remove(-150));
		System.out.println("hlc.remove(-1500) = " + hlc.remove(-1500));
		System.out.println("hlc.remove(666) = " + hlc.remove(666));
		
		System.out.println("\nAdd more number to rehash\n");
		
		for(int i=200; i<400; ++i)
			hlc.put(i, i*i);
		System.out.println("After rehash\n");
		System.out.println(hlc);
		
		System.out.println("Size = " + hlc.size());
		System.out.println("Is Empty = " + hlc.isEmpty());
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		System.out.println("\n\n");
		
		HashtableTreeSetChain<Integer, Integer> htc = new HashtableTreeSetChain<>();
		
		System.out.println("==============================================");
		System.out.println("======= Hash Chain Tree Set Class Test =======");
		System.out.println("==============================================");
		
		System.out.println("Size = " + htc.size());
		System.out.println("Is Empty = " + htc.isEmpty());
		
		System.out.println("\nPut 50 value");
		for(int i=0,j = 0; i<50; ++i, j+=3) 
			htc.put( j*i , i*i);
		System.out.println();
		System.out.println(htc);
		
//		[(0, 0)(1452, 484)(5808, 1936)]
//		[(243, 81)(507, 169)(2883, 961)(3675, 1225)]
//		[(3, 1)(1323, 441)(1587, 529)(5547, 1849)(6075, 2025)]
//		[(48, 16)(972, 324)(2028, 676)(4800, 1600)(6912, 2304)]
//		[(27, 9)(1083, 361)(1875, 625)(5043, 1681)(6627, 2209)]
//		[(75, 25)(867, 289)(2187, 729)(4563, 1521)(7203, 2401)]
//		[(363, 121)(3267, 1089)]
//		[(12, 4)(1200, 400)(1728, 576)(5292, 1764)(6348, 2116)]
//		[(300, 100)(432, 144)(3072, 1024)(3468, 1156)]
//		[(147, 49)(675, 225)(2523, 841)(4107, 1369)]
//		[(192, 64)(588, 196)(2700, 900)(3888, 1296)]
//		[(108, 36)(768, 256)(2352, 784)(4332, 1444)]
		
		System.out.println("Get function");
		System.out.println("htc.get(12) = " + htc.get(12));
		System.out.println("htc.get(1587) = " + htc.get(1587));
		System.out.println("htc.get(675) = " + htc.get(675));
		System.out.println("htc.get(1452) = " + htc.get(1452));
		System.out.println("htc.get(1323) = " + htc.get(1323));
		System.out.println("htc.get(3072) = " + htc.get(3072));
		System.out.println("htc.get(432) = " + htc.get(432));
		
		
		System.out.println("\nNot in get key ");
		System.out.println("htc.get(99999) = " + htc.get(99999));
		System.out.println("htc.get(-152) = " + htc.get(-152));
		System.out.println("htc.get(3333) = " + htc.get(3333));
		
		
		System.out.println("\nRemove Operation");
		System.out.println("htc.remove(0) = " + htc.remove(0));
		System.out.println("htc.remove(2187) = " + htc.remove(2187));
		System.out.println("htc.remove(588) = " + htc.remove(588));
		System.out.println("htc.remove(2028) = " + htc.remove(2028));
		System.out.println("htc.remove(4800) = " + htc.remove(4800));
		System.out.println("htc.remove(972) = " + htc.remove(972));
		System.out.println("htc.remove(3072) = " + htc.remove(3072));
		
		System.out.println("\nNot in remove");
		System.out.println("htc.remove(1111) = " + htc.remove(1111));
		System.out.println("htc.remove(2222) = " + htc.remove(2222));
		System.out.println("htc.remove(3333) = " + htc.remove(3333));
		System.out.println("htc.remove(4444) = " + htc.remove(4444));
		
		System.out.println("\nAfter Removing");
		System.out.println("\n"+htc);
		
		
		System.out.println("\nAdd more value to rehash\n");
		for(int i=50,j = 7; i<701; ++i, j+=3) 
			htc.put( j*i , i*i);
		
		System.out.println("\n"+htc);
		
		System.out.println("Size = " + htc.size());
		System.out.println("Is Empty = " + htc.isEmpty());
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		System.out.println("\n\n");
		
		CoalescedHashMap<MyInteger,Integer> chm = new CoalescedHashMap<>();
		System.out.println(chm);
		int[] aa = {3, 12, 13, 25, 23, 51, 42};
		
		System.out.println("==============================================");
		System.out.println("======= Hash Chain Tree Set Class Test =======");
		System.out.println("==============================================");
		
		System.out.println("Size = " + chm.size());
		System.out.println("Is Empty = " + chm.isEmpty() + "\n");
		
		System.out.print("add :");
		for(int a:aa) {
			System.out.print( a+ ", ");
			chm.put(new MyInteger(a),a*a);
		}
		System.out.println("\n\n"+chm + "\n " );
		
		System.out.println("remove 13 = " + chm.remove(new MyInteger(13)));
		System.out.println("remove 666 = " + chm.remove(new MyInteger(666)));
	
		System.out.println("\n" + chm + "\n " );		
	
		System.out.println("get 25 = " + chm.get(new MyInteger(25)));
		System.out.println("get 123 = " + chm.get(new MyInteger(123)));
		
		System.out.println("\nSize = " + chm.size());
		System.out.println("Is Empty = " + chm.isEmpty() + "\n");
		
		
		System.out.println("========================");
		System.out.println("========================");
		System.out.println("\n\nUse Next 2 and prev\n");

		CoalescedHashMap<MyInteger,Integer> chm2 = new CoalescedHashMap<>();
		System.out.println("add 3,13,23");
		chm2.put(new MyInteger(3),3*3);
		chm2.put(new MyInteger(13),13*13);
		chm2.put(new MyInteger(23),23*23);
		System.out.println(chm2);	
		System.out.println("add 4,14,24");
		chm2.put(new MyInteger(4),4*4);
		chm2.put(new MyInteger(14),14*14);
		chm2.put(new MyInteger(24),24*24);
		System.out.println(chm2);	
		System.out.println("add 10,20");
		chm2.put(new MyInteger(10),10*10);
		chm2.put(new MyInteger(20),20*20);
		System.out.println(chm2);	
		System.out.println("add 11");
		chm2.put(new MyInteger(11),11*11);
		System.out.println(chm2);
		System.out.println("add 30");
		chm2.put(new MyInteger(30),30*30);
		System.out.println(chm2);	
		
		System.out.println("get 20 = " + chm2.get(new MyInteger(20)));
		System.out.println("get 14 = " + chm2.get(new MyInteger(14)) + "\n");
		System.out.println("remove 13 = " + chm2.remove(new MyInteger(13)));
		System.out.println(chm2);	
		System.out.println("Add again 13");
		chm2.put(new MyInteger(13), 13*13);
		System.out.println(chm2);
		
	}
	
	
	
}
