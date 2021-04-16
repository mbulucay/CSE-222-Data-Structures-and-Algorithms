/**<h2>Branch Functions Interface</h2>*/
public interface BranchFunctions {
	
	public int getProductNumber();
	
	public Employee getEmployee(int index);
	
	public int getEmployeeNumber();
	
	public Furniture getProduct(int index);
	
	public int indexOfFurniture(Furniture f);
	
	public boolean addProduct(Furniture f);
	
	/**<p>Selling a product to the parameter customer using branch function</p>*/
	public boolean sellProduct(Furniture furniture, Customer customer);
	
	/**<p>Removing product in specific index</p>*/
	public Furniture removeProduct(int index);
	
	/**<p>Adding employee next free space in empArr</p>*/
	public boolean addEmployee(Employee employee);
	
	/**<p>Removing employee using array shifting method</p>*/
	public Employee removeEmployee(int index);
	
	/**Returning index of wanted employee*/
	public int getEmployeeIndex(Employee e);
	
	/**<p>Display working employees current branch</p>*/
	public void displayEmployees();
	
	/**<p>Checking employee account is in customer array data</p>*/
	public Employee checkEmployeeAccount(Employee employee);
	
	/**<p>Display all furniture in this store</p>*/
	public void displayProducts();
	
	/**<p>Display all working employee in this store</p>*/
	public void displayEmployess();
	
	/**<p>Query furniture is in branch or not using linear search</p>*/
	public boolean queryProduct(Furniture f);
	
	/**<p>Returning Furniture List in branch</p>*/
	public HybridList<Furniture> getFurnitures();

}
