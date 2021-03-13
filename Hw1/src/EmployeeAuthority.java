
public interface EmployeeAuthority {

	public int getWorkedBranchId() ;

	public void displayProducts() ;

	public void displayCustomers();
	
	public void displayCustomerList(int customerId);
	
	public Customer getCustomer(int id) ;
	
 	public boolean addCustomer(Customer customer) ;
 	
	public boolean addProduct(Furniture newFurniture) ;
	
	public boolean sellProduct(Furniture furniture,Customer customer) ;
	
	public int findCustomerIndex(Customer customer) ;
	
	public boolean queryProduct(Furniture obj);
	
	public void sendMessageToAdmin(String str);
	
}
