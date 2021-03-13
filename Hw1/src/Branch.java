/**<p>It branch class it keep Employee array for worker 
 * and Furniture array to store furnitures and some needed data</p>*/
public class Branch implements BranchFunctions{

	private final int EmployeeCapacity = 1001;
	private int ProductsCapacity = 100001; 
	private static int nextId = 0;
	
	private int branchId;
	private String name;
	private int productNumber = 0;
	private int currentEmployeeNumber = 0;
	
	private Employee[] employees = null;
	private Furniture[] products = null;
	
	Branch(String _name){
		products = new Furniture[ProductsCapacity];
		employees = new Employee[EmployeeCapacity];
		setName(_name);
		setBranchId(nextId++);
	}
	
	public void setName(String _name) {
		name = _name;
	}
	public String getName() {
		return name;
	}
	
	public int getId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getProductNumber() {
		return productNumber;
	}
 
	public int getCurrentEmployeeNumber() {
		return currentEmployeeNumber;
	}
	
	public Employee getEmployee(int index) {
		if(index < currentEmployeeNumber)
			return employees[index];
		return null;
	}
	public Furniture getFurniture(int index) {
		if(index < productNumber)
			return products[index];
		return null;
	}
	public Furniture[] getFurniture() {
		return products;
	}
	/**<p>indexOf Funiture ayni furniturein indexi donuyor</p>*/
	public int getFurnitureIndex(Furniture product) {
		
		for(int i=0; i<productNumber; ++i) {
			if(products[i].equals(product))
				return i;
		}
		return -1;
	}
	/**<p>adding employee next free space in empArr</p>*/
	public boolean addEmployee(Employee employee) {
		
		if(currentEmployeeNumber >= EmployeeCapacity) 
			enlargeEmployee();

		employees[currentEmployeeNumber++] = employee;
		return true;
	}
	/**<p>Dubling Employee array when it full</p>*/
	public void enlargeEmployee() {
		
		Employee[] tmpE = new Employee[currentEmployeeNumber*2];
		
		for(int i=0; i<currentEmployeeNumber; ++i)
			tmpE[i] = employees[i];
		
		employees = tmpE;
		currentEmployeeNumber *= 2;
	}
	/**<p>Removing employee using array shifting method</p>*/
	public boolean deleteEmployee(int index) {
		
		if(index >= currentEmployeeNumber)
			return false;
		
		while(index < currentEmployeeNumber)
			employees[index] = employees[++index];
		currentEmployeeNumber--;
		return true;
	}
	/**<p>Removing employee when it find same employee id</p>*/
	public boolean removeEmployee(Employee employee) {
		
		for (int i=0; i< currentEmployeeNumber; ++i) {
			if(employees[i].equals(employee)) 
				return deleteEmployee(i);
		}
		return false;
	}
	/**<p>Checking employye account is in customer array datas</p>*/
	public Employee checkEmployeeAccount(Employee employee) {
		
		for(int i=0; i<getCurrentEmployeeNumber(); ++i) {
			if(employees[i].getEmail().equals(employee.getEmail()) && employees[i].getPassword().equals(employee.getPassword()))
				return employees[i];
		}
		return null;
	}
	/**<p>adding Product next free space in products array</p>*/
	public boolean addProduct(Furniture newProduct) {
		
		if(productNumber >= ProductsCapacity) 
			enlargeProduct();
		
		products[productNumber++] = newProduct;
		return true;
	}
	/**<p>Dubling Product array when it full</p>*/
	public void enlargeProduct() {
		
		Furniture[] tmpF = new Furniture[ProductsCapacity*2];
		
		for(int i=0; i<productNumber; ++i)
			tmpF[i] = products[i];
		
		products = tmpF;
		ProductsCapacity *= 2;
	}
	/**<p>Removing product using array shifting method</p>*/
	public boolean removeProduct(int index) {
		
		if(index >= productNumber)
			return false;
			
		while(index < productNumber)
			products[index] = products[++index];
		productNumber--;
		return true;
	}
	/**<p>Removing product when it find same product color and modelid</p>*/
	public boolean removeProduct(Furniture f) {
		
		for(int i=0; i<productNumber; ++i) { 
			if(f.equals(products[i])) {
				removeProduct(i);
				return true;
			}	
		}
		return false;
	}
	/**<p>Selling a product to customer and remove it in branch product array</p>*/
	public boolean sellProduct(Furniture obj,Customer customer) {
		
		for (int i=0; i<productNumber; ++i) {
			 if(products[i].equals(obj)){
				 customer.buyProduct(products[i]);
				 return true;
			 }
		}
		return false;
	}
	/**<p>Query furniture is in branch or not using linear search</p>*/
	public boolean queryProduct(Furniture obj){
		
		if(obj == null)
			return false;
		for(int i=0; i<productNumber; ++i) 
			if(products[i].equals(obj))
				return true;
		return false;
	}
	/**<p>Display all products in store</p>*/
	public void displayProducts() {
		
		System.out.println("Branch" + getId() + " has " + productNumber + " products :");
		for(int i= 0; i<productNumber; ++i) 
			System.out.println(i + ". "+ products[i]);
	}
	
	public void displayEmployees() {
		/**<p>Display all working employe in this store</p>*/
		for(int i=0; i <currentEmployeeNumber; ++i){
			System.out.println("      "+ i + ". " +employees[i]);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		
		strBuild.append("Branch" + Integer.toString(getId()) + " employess : \n" );
		for(int i=0; i<currentEmployeeNumber; ++i) 
			strBuild.append(employees[i] + "\n");
		
		return strBuild.toString();
	}

}
