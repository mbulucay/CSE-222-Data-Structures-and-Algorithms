import java.util.Arrays;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
	
		Random rand = new Random();
		
		System.out.println("\n\n===========PART1==============\n\n");
		final int heapSize = 31;
	
		Heap<Integer> h = new Heap<>(heapSize);
		Integer[] harr = new Integer[heapSize];
		
		for(int i=0; i<heapSize; ++i) {
			Integer randomNum = rand.nextInt(100);
			h.insert(randomNum);
			harr[i] = randomNum;
		}
		
		System.out.println("Created heap");
		System.out.println(h);
			
		System.out.println("\nSearch " + harr[10] +" in heap: " + h.search(harr[10]));
		System.out.println("Search " + 201 +" in heap: " + h.search(201) + "\n");

		System.out.println("remove 6th largest :" + h.removeNthMax(6));
		System.out.println(h);
		
		System.out.println("Merge two list");
		
		Heap<Integer> h2 = new Heap<>(heapSize*3);
		for(int i=0; i<heapSize; ++i) 
			h2.insert(rand.nextInt(100));
		
		System.out.println("List1 :" + h);
		System.out.println("List2 :" + h2 + "\n");
		
		System.out.println("Merged List :");
		h2.merge(h);
		System.out.println(h2);
		
		Iterator<Integer> itt = h2.itreator();
		
		System.out.println("We use iter all list and print it 10 and 15 th element are setting with random value\n"
				+ " in iteration and list print again and of the iteratiron");

		System.out.println("Before iteration\n" + h2);
		int c = 0;
		while(itt.hasNext()) {
			int next = itt.next();
			System.out.println(next);
			if(c == 10) {
				int num = rand.nextInt(100);
				System.out.println(next + " 10th are setting random number : " + num);
				itt.set(num);
			}
			if(c == 15) {
				int num = rand.nextInt(100);
				System.out.println(next + " 15th are setting random number : " + num);
				itt.set(num);
			}
			c++;
		}
		System.out.println("After iteration rearranged heap");
		System.out.println(h2);
		
		
		
		System.out.println("\n\n===========PART2==============\n\n");
		
		final int SIZE = 3000;
		final int Bound = 5001;
		
		Integer[] intArr = new Integer[SIZE];
		BSTHeapTree bsth = new BSTHeapTree();
		
		for(int i=0; i<SIZE;++i) {
			Integer randNumber = rand.nextInt(Bound);
			intArr[i] = randNumber;
			bsth.add(randNumber);
		}
		
		Arrays.sort(intArr);
//		bsth.preOrder();
		
		System.out.println("\n\n==================OCCURANCE==================\n\n");
		
		for(int i=0; i<SIZE; ++i)
			System.out.println(intArr[i] + " occurance = " + bsth.find(intArr[i]));
		
		System.out.println("\n\n=====================SEARCH===================\n\n");
		
		for(int i=0; i<100;++i) 
			System.out.println(intArr[i+58] + " search = " + bsth.search(intArr[i+58]));
		
		int[] notInList = {-1,-2,5001,5050,-58,-190,9999,6542,-654,-6156};
		for(int i=0; i<10; ++i) 
			System.out.println(notInList[i] + " search = " + bsth.search(notInList[i]));
		
		System.out.println("\n====================MODE===================\n\n");
		
		System.out.println("find_mode() = " + bsth.find_mode());
		System.out.println("find(find_mode()) = " + bsth.find(bsth.find_mode()));
		
		System.out.println("\n\n================REMOVE================\n\n");
		System.out.println("in List remove ");
		for(int i=0,index = 10; i<100;++i,index +=15) 
			System.out.println(intArr[index] + " = " + bsth.remove(intArr[index]));
		System.out.println("not in List remove ");
		for(int i=0; i<10;++i)
			System.out.println(notInList[i] + " = " + bsth.remove(notInList[i]));

	}

}
