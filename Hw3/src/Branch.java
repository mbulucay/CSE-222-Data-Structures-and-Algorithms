/**<h2>Branch Class For Company</h2>*/
public class Branch implements BranchFunctions{

	ArrayList<Employee> emps;
	HybridList<Furniture> furnitures;
	
	private static int nextId = 0;
	private int branchId;
	
	Branch(){
		emps = new ArrayList<Employee>();
		furnitures = new HybridList<Furniture>();
		setId(nextId++);
	}
	
	public int getId() {
		return branchId;
	}
	
	private void setId(int i) {
		branchId = i;
	}
	
	public int getProductNumber() {
		return furnitures.getElementNumber();
	}
	
	public Employee getEmployee(int index) {
		return emps.get(index);
	}
	
	public int getEmployeeNumber() {
		return emps.getSize();
	}
	
	public Furniture getProduct(int index) {
		if(index > getProductNumber())
			throw new IndexOutOfBoundsException(Integer.toString(index));
		
		HIterator<Furniture> HIter = furnitures.iterator();
			
		for(int i=0; i<index / furnitures.getMaxNumber(); ++i) 
			HIter.next();
		
		Iterator<Furniture> AIter = HIter.next().iterator();
		
		
		int nth = index - ((index / furnitures.getMaxNumber()) * 10);
		for(int i=0;i<nth; ++i) 
			AIter.next();
			
		return AIter.next();
	}
	
	public int indexOfFurniture(Furniture f) {
		return furnitures.indexOf(f);
	}
	
	public boolean addProduct(Furniture f) {
		return furnitures.add(f);
	}
	
	/**<p>Selling a product to the parameter customer using branch function</p>*/
	public boolean sellProduct(Furniture furniture, Customer customer) {

		if(queryProduct(furniture)) {
			removeProduct(indexOfFurniture(furniture));
			customer.buyProduct(furniture);
			return true;
		}
		return false;
	}
	
	/**<p>Removing product in specific index</p>*/
	public Furniture removeProduct(int index) {
		return furnitures.remove(index);
	}
	
	/**<p>Adding employee next free space in empArr</p>*/
	public boolean addEmployee(Employee employee) {
		return emps.add(employee);
	}
	
	/**<p>Removing employee using array shifting method</p>*/
	public Employee removeEmployee(int index) {
		return emps.remove(index);
	}
	
	public int getEmployeeIndex(Employee e) {
		
		Iterator<Employee> iter = emps.iterator();
		int counter = 0;
		
		while(iter.hasNext()) {
			Employee emp = iter.next();
			if(emp.equals(e))
				return counter;
			counter++;
		}
		return -1;
	}
	
	public void displayEmployees() {
		System.out.println(emps);
	}
	
	/**<p>Checking employee account is in customer array data</p>*/
	public Employee checkEmployeeAccount(Employee employee) {
		
		for(int i=0; i<emps.getSize(); ++i) {
			if(emps.get(i).getEmail().equals(employee.getEmail()) && emps.get(i).getPassword().equals(employee.getPassword()))
				return emps.get(i);
		}
		return null;
	}
	
	/**<p>Display all furniture in this store</p>*/
	public void displayProducts() {
		System.out.println(furnitures);
	}
	
	/**<p>Display all working employee in this store</p>*/
	public void displayEmployess() {
		System.out.println(emps);
	}
	
	/**<p>Query furniture is in branch or not using linear search</p>*/
	public boolean queryProduct(Furniture f) {
		return furnitures.indexOf(f) != -1;
	}
	
	public HybridList<Furniture> getFurnitures() {
		return furnitures;
	}
	
	public String toString() {
		return "Branch : " + Integer.toString(getId());
	}

}
