/**<p>It is worker class for company each employee has unique id 
 * and working branch reference and its authority</p>*/
public class Employee extends Person implements EmployeeAuthority{

	private int EmployeeId; 
	private static int nextId = 0;
	
	private CompanyDatasLevel2 DataSetForEmployee;
	
	private Branch workBranch;
	
	Employee(CompanyDatasLevel2 datas,Branch workBranch,String _name,String _surname,String _email, String _password){
		super(_name,_surname,_email,_password);
		DataSetForEmployee = datas;
		setBranch(workBranch);
		setId(nextId++);
	}

	public Furniture makeProduct(int maxColor,int maxModel,int type) {
		return DataSetForEmployee.makeProduct(maxColor,maxModel,type);
	}
	
	public Branch getBranch() {
		return workBranch;
	}
	
	public void setBranch(Branch branch) {
		workBranch = branch;
	}
	
	public int getBranchId() {
		return workBranch.getId();
	}
	
	public void setId(int id) {
		EmployeeId = id;
	}
	
	public int getId() {
		return EmployeeId;
	}
	
	public int getWorkedBranchId() {
		return workBranch.getId();
	}

	public void displayProducts() {
		workBranch.displayProducts();
	}

	public void displayCustomers(){
		DataSetForEmployee.displayCustomers();
	}
	
	public void displayCustomerList(int customerId){
		DataSetForEmployee.displayCustomerList(customerId);
	}
	
	public Furniture getFurniture(int index) {
		return workBranch.getFurniture(index);
	}
	
	public Customer getCustomer(int id) {
		return DataSetForEmployee.getCustomer(id);
	}
	/**<p>Adding new customer to the system using dataLevel2 function</p>*/
 	public boolean addCustomer(Customer customer) {
 		return DataSetForEmployee.addCustomer(customer);
 	}
 	/**<p>Adding new product to the system using branch function</p>*/
	public boolean addProduct(Furniture newFurniture) {
		return workBranch.addProduct(newFurniture);
	}
	/**<p>Selling a product to the parameter customer using branch function</p>*/
	public boolean sellProduct(Furniture furniture,Customer customer) {
		workBranch.sellProduct(furniture, customer);
		return true;
	}
	/**<p>It is returning wanted customer index</p>*/
	public int findCustomerIndex(Customer customer) {
		for(int i=0; i<DataSetForEmployee.getCustomerCounter(); ++i) {
			if(customer.equals(customer))
				return i;
		}
		return -1;
	}
	/**<p>Query a product in working branch function</p>*/
	public boolean queryProduct(Furniture obj){
		return	workBranch.queryProduct(obj);
	}
	/**<p>Sending message to admin about a product out of stock</p>*/
	public void sendMessageToAdmin(String str){
		Admin.getMessageFromEmployee(str);
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
