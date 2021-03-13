
public interface BranchFunctions {
	
	public int getFurnitureIndex(Furniture product);
	
	public boolean addEmployee(Employee employee);
	
	public boolean removeEmployee(Employee employee);
	
	public Employee checkEmployeeAccount(Employee employee);
	
	public boolean addProduct(Furniture newProduct);
	
	public boolean removeProduct(Furniture f);
	
	public boolean sellProduct(Furniture obj,Customer customer);
	
	public boolean queryProduct(Furniture obj);
	
	public void displayProducts();
	
	public void displayEmployees();
	
}
