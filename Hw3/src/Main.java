import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		DATA driverData = new DATA();

///////////////////////////////////////////////////////////////////////		
/////////////////////////////////////	LINKED LIST		
///////////////////////////////////////////////////////////////////////
		System.out.println("==================================");
		System.out.println(" ==== Linked List Drive Code ==== ");
		System.out.println("==================================");
		
		Branch br0 = new Branch();
		Branch br1 = new Branch();
		Branch br2 = new Branch();
		Branch br3 = new Branch();
		Branch br4 = new Branch();
		Branch br5 = new Branch();
		
		LinkedList<Branch> lb = new LinkedList<>();
		
		System.out.println("Add some branch to linked list ex: lb.add(br0);");
		
		lb.add(br0);
		lb.add(br1);
		lb.add(br2);
		lb.add(br3);
		lb.add(br4);
		lb.add(br5);
		System.out.println(lb);
		
		System.out.println("Test remove(E e) method ex: lb.remove(br0) remove(br2) remove(br5)");
		lb.remove(br0);
		lb.remove(br2);
		lb.remove(br5);
		System.out.println(lb);
		
		System.out.println("Test remove(int ) method ex: lb.remove(1);");
		lb.remove(1);
		
		System.out.println("Add a few branch");
		lb.add(new Branch());
		lb.add(new Branch());
		lb.add(new Branch());
		System.out.println(lb);
		
		System.out.println("Linked List iterator Test print all branch:");
		Iterator<Branch> itLB = lb.iterator();
		
		while(itLB.hasNext()) {
			System.out.println(itLB.next());
		}
		System.out.println("Use iterator remove on last returned element ");
		itLB.remove();
		
		System.out.println("End of iteration");
		System.out.println(lb);			
		
		System.out.println("IndexOf operator lb.indexOf(br4)");
		System.out.println("index = " + lb.indexOf(br4));
		
		System.out.println("Try to find un existing brach on indexOf");
		System.out.println("index = " + lb.indexOf(br5));
		
		
		System.out.println("\nget metod lb.get(3)");
		System.out.println("get(3) = " + lb.get(3));
		
		System.out.println("Try out of index on get method get(99)");
		try {
			lb.get(99);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nCurrent branch List");
		System.out.println(lb);
		
		System.out.println("set method set(2,br0)");
		lb.set(2, br0);
		System.out.println("After set method");
		System.out.println(lb);
		
		System.out.println("set out of index set(99, new Branch())");
		try {
			lb.set(99, br1);
		}catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nadd(int, E) method : lb.add(2,new Branch()) ");
		lb.add(2,new Branch());
		System.out.println(lb);
		
		System.out.println("out of add(int,E) : lb.add(99, br3)");
		try {
			lb.add(99,br3);
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
///////////////////////////////////////////////////////////////////////		
/////////////////////////////////////	ARRAY LIST
///////////////////////////////////////////////////////////////////////
		System.out.println("==================================");
		System.out.println(" ==== Array List  Drive Code ====");
		System.out.println("==================================");
		
		Employee e0 = new Employee(null, null, "emp0", "e0", "e0", "e0");
		Employee e1 = new Employee(null, null, "emp1", "e1", "e1", "e1");
		Employee e2 = new Employee(null, null, "emp2", "e2", "e2", "e2");
		Employee e3 = new Employee(null, null, "emp3", "e3", "e3", "e3");
		Employee e4 = new Employee(null, null, "emp4", "e4", "e4", "e4");
		
		Admin a0 = new Admin(null,"admn0","a0","a0","a0");
		Admin a1 = new Admin(null,"admn1","a1","a1","a1");
		Admin a2 = new Admin(null,"admn2","a2","a2","a2");
		Admin a3 = new Admin(null,"admn3","a3","a3","a3");
		
		Customer c0 = new Customer(null, "cstmr0","c0", "c0", "c0");
		Customer c1 = new Customer(null, "cstmr1","c1", "c1", "c1");
		Customer c2 = new Customer(null, "cstmr2","c2", "c2", "c2");
		Customer c3 = new Customer(null, "cstmr3","c3", "c3", "c3");
		Customer c4 = new Customer(null, "cstmr4","c4", "c4", "c4");
		Customer c5 = new Customer(null, "cstmr5","c5", "c5", "c5");
		Customer c6 = new Customer(null, "cstmr6","c6", "c6", "c6");
		Customer c7 = new Customer(null, "cstmr7","c7", "c7", "c7");
		
		ArrayList<Person> arL = new ArrayList<>();
		System.out.println("add some user to array list : arL.add(Admin/Employee/Customer);");
		arL.add(e0);	arL.add(e1);	arL.add(e2);	arL.add(e3);
		arL.add(e4);
		
		arL.add(a0);	arL.add(a1);	arL.add(a2);	arL.add(a3);
		
		arL.add(c0);	arL.add(c1);	arL.add(c2);	arL.add(c3);
		arL.add(c4);	arL.add(c5);	arL.add(c6);	arL.add(c7);
		
		System.out.println("Current Array List");
		System.out.println(arL);
		
		System.out.println("Test remove(int) method : remove(0)(6)(10)(16)");
		// after each remove index is decrease 1 numbers arrange according to this rule
		arL.remove(0);
		arL.remove(5);
		arL.remove(8);
		arL.remove(13);

		System.out.println("After Removing");
		System.out.println(arL);

		System.out.println("out of index remove : arL.remove(99)");
		try {
			arL.remove(99);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nget(int) method : arL.get(2)(4)(9)");
		System.out.println("arL.get(2) = " + arL.get(2));
		System.out.println("arL.get(4) = " + arL.get(4));
		System.out.println("arL.get(9) = " + arL.get(9));
		
		System.out.println("\nout of index on get method : get(99)");
		try {
			arL.get(99);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nset(int , E) method : set(5,new Customer(\"setted custmr\")");
		arL.set(5, new Customer(null, "setted", "customer", null, null));
		
		System.out.println("\nCurrent ArrayList");
		System.out.println(arL);
		
		System.out.println("add(int, E) method : add(7,new Employee()");
		arL.add(7, new Employee(null, null, "added ", " employee", null, null));
		
		System.out.println("Curent AList");
		System.out.println(arL);
		
		System.out.println("indexOf(E) method : indexOf(cstmr4)");
		System.out.println("index = " + arL.indexOf(c4));
		
		System.out.println("non existing indexOf : indexOf(new Employee())");
		System.out.println("index "+ arL.indexOf(new Employee(null, null, null, null, null, null)));
		
		System.out.println("\nIter all over Array List using iterator and remove last elemnt");
		Iterator<Person> itA = arL.iterator();
		
		while(itA.hasNext()) {
			System.out.println(itA.next());
		}
		System.out.println("\nremove last element usign iterator");
		itA.remove();
		
		System.out.println("\nCurrent arrayList");
		System.out.println(arL);

///////////////////////////////////////////////////////////////////////
/////////////////////////////////////	HYBRID LIST		
///////////////////////////////////////////////////////////////////////		
		System.out.println("==================================");
		System.out.println(" ==== Hybrid List Drive Code ====");
		System.out.println("==================================");
		HybridList<Furniture> hf = new HybridList<>();
		
		System.out.println("Add some furniture to HybridList");
		for(int i=0; i<6; ++i) 
			hf.add(new OfficeChair(0, 0, 0));
		for(int i=0; i<6; ++i) 
			hf.add(new OfficeChair(1, 0, 0));
		for(int i=0; i<6; ++i) 
			hf.add(new OfficeCabinet(0, 0, 0));
		hf.add(new Bookcases(0, 0, 0));
		for(int i=0; i<6; ++i) 
			hf.add(new OfficeCabinet(1, 0, 0));
		for(int i=0; i<6; ++i) 
			hf.add(new OfficeDesk(0, 0, 0));
		for(int i=0; i<6; ++i) 
			hf.add(new OfficeDesk(1, 0, 0));
		System.out.println("See all product in HList");
		System.out.println(hf);
		System.out.println();
		
		System.out.println("remove method control remove(0) , remove(3),remove(15), remove(36)");
		System.out.println("remove(0) = " + hf.remove(0));
		System.out.println("remove(3) = " + hf.remove(3));
		System.out.println("remove(15) = " + hf.remove(15));
		System.out.println("remove(36) = " + hf.remove(36));
		
		System.out.println("remove index Out remove(99)");
		try {
			hf.remove(99);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("See all product after remove in HList");
		System.out.println(hf);
		
		System.out.println("Index Of control : hf.indexOf(new Bookcases(0, 0, 0))");
		int in = hf.indexOf(new Bookcases(0, 0, 0));
		System.out.println("index = " + in + "\n");
		
		System.out.println("get(int) method control");
		System.out.println("hf.get(2)\n" + hf.get(2));
		System.out.println("hf.get(2).get(2)\n" + hf.get(2).get(2) + "\n");
		
		System.out.println("Out Of get(99)");
		try {
			System.out.println(hf.get(99));
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nHybrid List Iterator test to see all product "
				+ "\nEach ArrayLsit can take max 10 furniture\n");
		HIterator<Furniture> hi = hf.iterator();
		while(hi.hasNext()) {
			
			Iterator<Furniture> ha = hi.next().iterator();
			while(ha.hasNext()) 
				System.out.println(ha.next());
			
			System.out.println();
		}
		
		System.out.println();

///////////////////////////////////////////////////////////////////////		
/////////////////////////////////////	ADMIN
///////////////////////////////////////////////////////////////////////
		System.out.println("==================================");
		System.out.println(" = Driver Code For Admin Class ==");
		System.out.println("==================================");
		System.out.println("Create an admin obj :: a = new Admin(driverData,\"a\",\"a\",\"a\",\"a\");");
		Admin a = new Admin(driverData,"a","a","a","a");
		
		System.out.println("Add 3 branch and add 2 two employee for each:");
		System.out.println("Example : aBr1 = new Branch();");
		System.out.println("new Employee(driverData, aBr1, null, null, null, null);");
		System.out.println("Add Branch : a.addBranch(aBr1);");
		System.out.println("Add Employee : a.addEmployee(aBr1, aEmp1);");
		Branch aBr1 = new Branch();
		Employee aEmp1 = new Employee(driverData, aBr1, "e1", "e1", "e1", "e1");
		Employee aEmp2 = new Employee(driverData, aBr1, null, null, null, null);
		a.addBranch(aBr1);
		a.addEmployee(aBr1, aEmp1);
		a.addEmployee(aBr1, aEmp2);
		
		Branch aBr2 = new Branch();
		Employee aEmp3 = new Employee(driverData, aBr1, null, null, null, null);
		Employee aEmp4 = new Employee(driverData, aBr1, null, null, null, null);
		a.addBranch(aBr2);
		a.addEmployee(aBr2, aEmp3);
		a.addEmployee(aBr2, aEmp4);
		
		Branch aBr3 = new Branch();
		Employee aEmp5 = new Employee(driverData, aBr1, null, null, null, null);
		Employee aEmp6 = new Employee(driverData, aBr1, null, null, null, null);
		a.addBranch(aBr3);
		a.addEmployee(aBr3, aEmp5);
		a.addEmployee(aBr3, aEmp6);
		
		System.out.println("\nDisplay All Added Branch :");
		a.displayBranchs();
		
		System.out.println("Display All Employee in Branchs :");
		a.displayEmployee();
		
		System.out.println("Remove an Employee : ");
		a.removeEmployee(aBr3, aEmp6);
		try {
		System.out.println("Try remove not exist employee : a.removeEmployee(aBr3, new Employee(driverData, null, null, null, null, null));");
		a.removeEmployee(aBr3, new Employee(driverData, null, null, null, null, null));
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		System.out.println("Display All Employee in Branchs :");
		a.displayEmployee();
		
		System.out.println("Remove a Branch remove index 1 branch");
		a.removeBranch(2);
	
		System.out.println("\nDisplay All Branch :");
		a.displayBranchs();
		System.out.println("Display All Employee in Branchs :");
		a.displayEmployee();
		
		System.out.println("Remove out index a.removeBranch(99);");
		try {
			a.removeBranch(99);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nDisplay All Branch :");
		a.displayBranchs();
		System.out.println("Display All Employee in Branchs :");
		a.displayEmployee();
		
		System.out.println("\nQuery a product");
		System.out.println("add a new OfficeChair in aBr1");
		a.getBranch(0).addProduct(new OfficeChair(0, 0, 0));
		a.getBranch(0).displayProducts();
		
		System.out.println("a.queryProduct(new OfficeChair(0,0,0))");
		if(a.queryProduct(new OfficeChair(0,0,0))) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
		
		System.out.println("query not existing furniture");
		System.out.println("a.queryProduct(new Bookcases(0,0,0))");
		if(a.queryProduct(new Bookcases(0,0,0))){
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
		
		aEmp1.sendMessageToAdmin("This message came from employee");		
		System.out.println("Show admin InBox: \n");
		System.out.println("\naEmp1.sendMessageToAdmin(\"This message came from employee\");");
		System.out.println("\nAdmin.displayMessages(); => ");
		Admin.displayMessages();

///////////////////////////////////////////////////////////////////////
/////////////////////////////////////	EMPLOYEE
///////////////////////////////////////////////////////////////////////		
		System.out.println("==================================");
		System.out.println("= Driver Code For Employee Class =");
		System.out.println("==================================");
		System.out.println(aEmp1 + " Branch id : " + aEmp1.getBranchId());
		
		System.out.println("\nAdd some product to branch ");
		System.out.println("Ex : aEmp1.addProduct(new OfficeChair(0,1,aBr1.getId()));");
		aEmp1.addProduct(new OfficeChair(0,1,aBr1.getId()));
		aEmp1.addProduct(new OfficeChair(2,4,aBr1.getId()));

		aEmp1.addProduct(new OfficeDesk(0,1,aBr1.getId()));
		aEmp1.addProduct(new OfficeDesk(2,1,aBr1.getId()));

		aEmp1.addProduct(new MeetingTable(2,6,aBr1.getId()));
		aEmp1.addProduct(new MeetingTable(3,8,aBr1.getId()));
		aEmp1.addProduct(new MeetingTable(1,4,aBr1.getId()));
		
		aEmp1.addProduct(new Bookcases(0,3,aBr1.getId()));
		aEmp1.addProduct(new Bookcases(0,6,aBr1.getId()));
		aEmp1.addProduct(new Bookcases(0,8,aBr1.getId()));

		aEmp1.addProduct(new OfficeCabinet(0,7,aBr1.getId()));
		aEmp1.addProduct(new OfficeCabinet(0,3,aBr1.getId()));
		aEmp1.addProduct(new OfficeCabinet(0,11,aBr1.getId()));
		
		System.out.println("\nDisplay Products");
		aEmp1.displayProducts();
		
		System.out.println("\nRemove Product index 0,2,5,13 as queue with shifting  ex :aEmp1.removeProduct(2);:");
		aEmp1.removeProduct(0);
		aEmp1.removeProduct(2);
		aEmp1.removeProduct(5);
		aEmp1.removeProduct(13);
		
		System.out.println("\nDisplay Products");
		aEmp1.displayProducts();
		
		System.out.println("Try remove out of index aEmp1.removeProduct(99);");
		try {
			aEmp1.removeProduct(99);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	
		Customer c = new Customer(driverData, "c", "c", null, null);
		System.out.println("Add customer to system and sell him a few product:");
		System.out.println("Ex add customer : aEmp1.addCustomer(c)");
		aEmp1.addCustomer(c);
		System.out.println("Ex Sell Product: aEmp1.sellProduct(new MeetingTable(3,8,aBr1.getId()), c);");
		aEmp1.sellProduct(new MeetingTable(3,8,aBr1.getId()), c);
		aEmp1.sellProduct(new OfficeDesk(2,1,aBr1.getId()), c);
		
		System.out.println("Display branch products after sell");
		aEmp1.displayProducts();
		System.out.println("Display Customer ShopList");
		aEmp1.displayCustomerShopList(c.getId());
		
//		aEmp1.sendMessageToAdmin();
//		

///////////////////////////////////////////////////////////////////////
/////////////////////////////////////	CUSTOMER
///////////////////////////////////////////////////////////////////////
		System.out.println("==================================");
		System.out.println("= Driver Code For Customer Class =");
		System.out.println("==================================");
		System.out.println(c);
		
		System.out.println("See shopList :");
		c.displayShoppingList();
		
		System.out.println("See all product in all store");
		aBr2.addProduct(new OfficeChair(2,4,aBr2.getId()));
		aBr2.addProduct(new OfficeCabinet(0,11,aBr2.getId()));
		aBr2.addProduct(new OfficeChair(0,1,aBr2.getId()));
		
		c.displayProducts();
		
		System.out.println("Buy a furniture from Branch 1");
		c.buyProduct(new OfficeChair(0,1,aBr2.getId()));
		aBr2.removeProduct(1);
		c.displayProducts();
		
		System.out.println("See shop List again");
		c.displayShoppingList();
		
		System.out.println("Query a product existing one: Bookcases(0,8,aBr1.getId())");
		if(c.queryProduct(new Bookcases(0,8,aBr1.getId())) != null) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
		
		System.out.println("Query a product not existing one : Bookcases(0,2,aBr1.getId()) ");
		if(c.queryProduct(new Bookcases(0,2,aBr1.getId())) != null) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
	
		
///////////////////////////////////////////////////////////////////////
/////////////////////////////////////	BRANCH	
///////////////////////////////////////////////////////////////////////
		System.out.println("==================================");
		System.out.println(" ==== Branch Class Drive Code ===");
		System.out.println("==================================");
		Branch BR = new Branch();
		
		Furniture ff1 = new OfficeChair(0, 0, 0);
		Furniture ff2 = new OfficeChair(1, 0, 0);
		Furniture ff3 = new OfficeCabinet(0, 0, 0);
		Furniture ff4 = new OfficeCabinet(1, 0, 0);
		
		Employee em0 = new Employee(null, BR, "e0", "e0", "e0", "e0");
		Employee em1 = new Employee(null, BR, "e1", "e1", "e1", "e1");
		Employee em2 = new Employee(null, BR, "e2", "e2", "e2", "e2");
		Employee em3 = new Employee(null, BR, "e3", "e3", "e3", "e3");
		Employee em4 = new Employee(null, BR, "e4", "e4", "e4", "e4");
		
		
		System.out.println("Add some employee and furniture\n");
		BR.addEmployee(em0);
		BR.addEmployee(em1);
		BR.addEmployee(em2);
		BR.addEmployee(em3);
		BR.addEmployee(em4);
		
		for(int i=0; i<7; ++i)
			BR.addProduct(ff1);
		for(int i=0; i<7; ++i)
			BR.addProduct(ff2);
		for(int i=0; i<7; ++i)
			BR.addProduct(ff3);
		for(int i=0; i<7; ++i)
			BR.addProduct(ff4);
		
		System.out.println("Employess:\n");
		BR.displayEmployess();
		
		System.out.println("\nFurnitures:\n");
		BR.displayProducts();
		
		System.out.println("Emp Size BR.getEmployeeNumber(): " + BR.getEmployeeNumber());
		System.out.println("getEmployee(int) : BR.getEmployee(3) :" + BR.getEmployee(3));
		System.out.println("removeEmployee(int) : BR.removeEmployee(2)");
		BR.removeEmployee(2);
		System.out.println("\nAfter remove:");
		BR.displayEmployess();
		
		System.out.println("\nindexOfEmployee =  BR.getEmployeeIndex(em3)");
		System.out.println("index = " + BR.getEmployeeIndex(em3));
		System.out.println("indexOfEmployee not exisintg =  BR.getEmployeeIndex(new Employee())");
		System.out.println("index = " + BR.getEmployeeIndex(new Employee(null, BR, null, null, null, null)));
		
		System.out.println("\ngetEmployee(int) : BR.getEmployee(3);");
		System.out.println(BR.getEmployee(3));
		System.out.println();
		
		System.out.println("Out of getgetEmployee : getEmployee(99)");
		try {
			BR.getEmployee(99);
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}

		System.out.println("\n");
		
		System.out.println("Furnitures:\n");
		BR.displayProducts();		
		
		System.out.println("\nget(int) product: getProduct(13)(14)");
		System.out.println(BR.getProduct(13));
		System.out.println(BR.getProduct(14));
		System.out.println();
		
		System.out.println("IndexOfFurniture(int) : ");
		System.out.println("indexOf(new OfficeChair(0, 0, 0)) = " + BR.indexOfFurniture( new OfficeChair(0, 0, 0)));
		System.out.println("indexOf OfficeCabinet(0, 0, 0) = " + BR.indexOfFurniture(new OfficeCabinet(0, 0, 0)));
		System.out.println("Not exist index OfficeChair(1,1,0)= " + BR.indexOfFurniture(new OfficeChair(1, 1, 0)));
		
		System.out.println("\nremoveProduct(int) : removeProduct(0)(13)(14)(27)");
		//numbers arrange to the shifting each time
		BR.removeProduct(0);
		BR.removeProduct(13);
		BR.removeProduct(14);
		BR.removeProduct(25);
		BR.displayProducts();
		System.out.println("\n");
		
		System.out.println("Query Product : BR.queryProduct(ff4)" );
		if(BR.queryProduct(ff4)) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
		System.out.println("Not exist query : BR.queryProduct(new OfficeChair(1, 1, 0))");
		if(BR.queryProduct(new OfficeChair(1, 1, 0))) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n\n");
		System.out.println("Automation System has started");
		AutomationSystem automation = new AutomationSystem();
		automation.Runner();
	
	}//end of main

}//end of class
