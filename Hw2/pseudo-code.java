
pseudo-code

min_function( arrList )
	
	int min = arrList[0]
	
	for ( element : arrList )
		if min < element
			min = element 		// If there is smaller than current number 
								// take it as a new smallest number
	return min	

////////////////////////////////////////////////
////////////////////////////////////////////////
////////////////////////////////////////////////

median_function( arrList )
	
	if arrList.length % 2 == 0 :
		boolean r1 = r2 = false
		int sum = 0
		for i = 0 ; i< arrList.length; ++i :

			int smallCounter = bigCounter = 0
			for j = 0; j<arrList.length; ++j

				if arrList[j] > arrList[i] : 
					bigCounter++

				else if arrList[j] < arrList[i] : 
					smallCounter++

			if bigCounter - smallCounter == 1
				r1 = true
				sum += arrList[i]
			if smallCounter - bigCounter == 1
				r2 = true	
				sum += arrList[i]

			if r1 && r2
				int median = sum / 2
				return median


	if arrList.length % 2 != 0 :

		for i=0 ; i<arrList.length; ++i :
			
			int smallCounter = bigCounter = 0
			for j=0; j<arrList.length; ++j

				if arrList[j] > arrList[i]
					bigCounter++

				else if arrList[j] < arrList[i]
					smallCounter++

			if smallCounter == bigCounter
				int median = arrList[i]
				return median 

////////////////////////////////////////////////
////////////////////////////////////////////////
////////////////////////////////////////////////

sum_function(  arrList , value):

	map<Integer,Integer> myMap

	int result[] = new int [2]	
	for i = 0 ; i< arrList.length ; ++i:
		
		if(myMap.containsKey(value - arrList[i])
			// Look for the need number to reach target 
			// is in the list or not if it in list take it using get
			return {myMap.get(value - arrList[i]) , i}

		myMap.put(arrList[i], i) //storeing data to reach if need

	return result


////////////////////////////////////////////////
////////////////////////////////////////////////
////////////////////////////////////////////////


LinkedList merge_two_sortedArr_getLinkedList( arrL_1, arrL_2 )

	LinkedList<type> ll = new LinkedList<>()

	for i = 0, j = 0 ; i < arrL_1.size() && j < arrL_2.size(); :
	    // Getting number respectively dont mess up sorted
	    // until one of reach of the array size
	    if arrL_1.get(i) < arrL_2.get(j) : 
	        ll.add(arrL_1.get(i))	
	        i++
	    else :
	        ll.add(arrL_2.get(j))
	        j++


	// One of the while is gonna work because 
	// one of the counter reach the array size in for loop
	while(i < arrL_1.size()) 
		ll.add(arrL_1.get(i++))

	while(j < arrL_2.size()) 
		ll.add(arrL_2.get(j++))

	return ll


a)
int p_1 (int array[]):{
	return array[0] * array[2]
}


b)
int p_2 (int array[], int n):{
	
	Int sum = 0
	for (int i = 0; i < n; i=i+5)
		sum += array[i] * array[i]
	return sum
}


c)
void p_3 (int array[], int n):{
	
	for (int i = 0; i < n; i++)	
		for (int j = 1; j < i; j=j*2)
			printf(“%d”, array[i] * array[j])
}


d)
void p_4 (int array[], int n):{

	if (p_2(array, n)) > 1000)
		p_3(array, n)
	else
		printf(“%d”, p_1(array) * p_2(array, n))
}