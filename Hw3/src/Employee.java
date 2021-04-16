/**<h2>It is worker class for company each employee has unique id 
 * and working branch reference and its authority</h2>*/
public class Employee extends Person implements EmployeeAuthority{

	Branch workBranch;
	DATA empCompanyData;
	private int EmployeeId; 
	private static int nextId = 0;
	
	Employee(DATA d,Branch b,String _name, String _surname, String _email, String _password) {
		super(_name, _surname, _email, _password);
		workBranch = b;
		empCompanyData = d;
		setId(nextId++);
	}

	public void setId(int id) {
		EmployeeId = id;
	}
	
	public int getId() {
		return EmployeeId;
	}
	
	/**<p>Make new product to add store</p>*/
	public Furniture makeProduct() {
		return empCompanyData.makeProduct();
	}
	
	/**<p>getting furniture in working store</p>*/
	public Furniture getProduct(int index) {
		return workBranch.getProduct(index);
	}
	
	/**<p>Display furniture in working store</p>*/
	public void displayProducts() {
		workBranch.displayProducts();
	}
	
 	/**<p>Adding new product to the system using branch function</p>*/
	public boolean addProduct(Furniture newFurniture) {
		return workBranch.addProduct(newFurniture);
	}
	
	/**<p>Remove a furniture in working store</p>*/
	public Furniture removeProduct(int index) {
		return workBranch.removeProduct(index);
	}
	
	/**<p>Selling a product to the parameter customer using branch function</p>*/
	public boolean sellProduct(Furniture furniture,Customer customer) {
		return workBranch.sellProduct(furniture, customer);
	}
	
	/**<p>Query a product in working branch function</p>*/
	public boolean queryProduct(Furniture obj){
		return	workBranch.queryProduct(obj);
	}
	
	/**<p>Getting customer using id from database</p>*/
	public Customer getCustomer(int id) {
		return empCompanyData.getCustomer(id);
	}
	
	/**<p>Display all saved customer in system</p>*/
	public void displayCustomers(){
		empCompanyData.displayCustomers();
	}
	
	/**<p>Display a customer shop list</p>*/
	public void displayCustomerShopList(int customerId){
		empCompanyData.displayCustomerShopList(customerId);
	}
	
	/**<p>Adding new customer to the system using dataLevel2 function</p>*/
 	public boolean addCustomer(Customer customer) {
 		return empCompanyData.addCustomer(customer);
 	}
	
	/**<p>It is returning wanted customer index</p>*/
	public int indexOfCustomer(Customer customer) {
		return empCompanyData.indexOfCustomer(customer);
	}
	
	/**<p>Returning working branch</p>*/
	public Branch getBranch() {
		return workBranch;
	}
	
	/**<p>Returning working branch id</p>*/
	public int getBranchId() {
		return workBranch.getId();
	}
	
	/**<p>Returning funiture in working store using index</p>*/
	public Furniture getFurniture(int index) {
		return workBranch.getProduct(index);
	}
	
	/**<p>Sending message to admin about out of stock</p>*/
	public void sendMessageToAdmin(String message) {
		Admin.getMessage(message);
	}
	
	@Override
	/**<p>It is comparing unique id</p>*/
	public boolean equals(Object o) {
		if(!(o instanceof Employee ))
			return false;
		
		Employee  obj = (Employee) o;
		return obj.getId() == this.getId();
	}
	
	@Override
	public String toString() {
		return "Name : " + getName() + " Surname : "+ getSurname();
	}

}
