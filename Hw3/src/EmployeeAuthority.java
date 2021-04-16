/**<h2>Employee Authority Interface</h2>*/
public interface EmployeeAuthority {
	
	/**<p>Make new product to add store</p>*/
	public Furniture makeProduct();
	
	/**<p>getting furniture in working store</p>*/
	public Furniture getProduct(int index);
	
	/**<p>Display furniture in working store</p>*/
	public void displayProducts();

 	/**<p>Adding new product to the system using branch function</p>*/
	public boolean addProduct(Furniture newFurniture) ;
	
	/**<p>Remove a furniture in working store</p>*/
	public Furniture removeProduct(int index);
	
	/**<p>Selling a product to the parameter customer using branch function</p>*/
	public boolean sellProduct(Furniture furniture,Customer customer);
	
	/**<p>Query a product in working branch function</p>*/
	public boolean queryProduct(Furniture obj);
	
	/**<p>Getting customer using id from database</p>*/
	public Customer getCustomer(int id) ;
	
	/**<p>Display all saved customer in system</p>*/
	public void displayCustomers();
	
	/**<p>Display a customer shop list</p>*/
	public void displayCustomerShopList(int customerId);
	
	/**<p>Adding new customer to the system using dataLevel2 function</p>*/
 	public boolean addCustomer(Customer customer);
	
	/**<p>It is returning wanted customer index</p>*/
	public int indexOfCustomer(Customer customer);
	
	/**<p>Returning working branch</p>*/
	public Branch getBranch();
	
	/**<p>Returning working branch id</p>*/
	public int getBranchId();
	
	/**<p>Returning funiture in working store using index</p>*/
	public Furniture getFurniture(int index);
	
	/**<p>Sending message to admin about out of stock</p>*/
	public void sendMessageToAdmin(String message);
	
}
