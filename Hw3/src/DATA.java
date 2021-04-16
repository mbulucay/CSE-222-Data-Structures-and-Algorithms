/**<h2>We are use this class as data base to store data
 * in company like users,branch etc...
 * </h2>*/
/**<p>Each method calling from accessible users</p>*/
public class DATA {

	ArrayList<Admin> adminList;
	ArrayList<Employee> employeeList;
	ArrayList<Customer> customerList;
	
	LinkedList<Branch> branchList;
	
	ObjectCreater objectCreator;
	
	public DATA(){
		adminList = new ArrayList<Admin>();
		employeeList = new ArrayList<Employee>();
		customerList = new ArrayList<Customer>();
		
		branchList = new LinkedList<Branch>();
		
		objectCreator = new ObjectCreater();
	}
	
	public boolean addBranch(Branch newBranch) {
		return  branchList.add(newBranch);
	}

	public Branch removeBranch(int index) {
		return branchList.remove(index);
	}

	public Branch removeBranch(Branch branch) {
		return branchList.remove(branch);
	}

	public Branch getBranch(int index) {
		return branchList.get(index);
	}

	public int getBranchNumber() {
		return branchList.getSize();
	}

	
	public boolean addAdmin(Admin admin) {
		return adminList.add(admin);
	}
	
	
	public Admin makeAdmin(){
		return objectCreator.makeAdmin(this);
	}
	
	/**<p>Making employee and return it</p>*/
	public Employee makeEmployee(){
		return objectCreator.makeEmployee(this);
	}
	
	public Customer makeCustomer() {
		return objectCreator.makeCustomer(this);
	}

	public Branch makeBranch() {
		return objectCreator.makeBranch();
	}
	
	public Furniture makeProduct() {
		return objectCreator.makeProduct();
	}
	
	public LinkedList<Branch> getBranchs(){
		return branchList;
	}
	
	public void addEmployee(Branch branch, Employee employee) {
		employeeList.add(employee);
		branch.addEmployee(employee);
	}

	public Employee removeEmployee(Branch branch, Employee employee) {
		return branch.removeEmployee(branch.getEmployeeIndex(employee));		
	}

	public void displayBranchs() {
		System.out.println(branchList);
	}

	public void displayCustomers() {
		System.out.println(customerList);
	}

	public void displayCustomerShopList(int customerId) {
		Iterator<Customer> iter = customerList.iterator();
		
		while(iter.hasNext()) {
			Customer c = iter.next();
			if(c.getId() == customerId) {
				c.displayShoppingList();
				return;
			}
		}
		System.out.println("Customer id is not defined");
	}

	
	public Customer getCustomer(int id) {
		return customerList.get(id);
	}

	public boolean addCustomer(Customer customer) {
		return customerList.add(customer);
	}

	public int indexOfCustomer(Customer c) {
		return customerList.indexOf(c);
	}

	
	public Branch queryProduct(Furniture obj) {
		
		Iterator<Branch> iter = branchList.iterator();
		
		while(iter.hasNext()) {
			
			Branch br = iter.next();
			if(br.queryProduct(obj))
				return br;
		}
		return null;
	}
	
	public void displayProducts() {
		Iterator<Branch> iter = branchList.iterator();
		
		while(iter.hasNext()) {
			Branch br = iter.next();
			
			System.out.println("Branch " + br.getId());
			br.displayProducts();
		}
	}

	
	public Admin checkAdminAccount(Admin admin) {
		Iterator<Admin> iter = adminList.iterator();
		
		while(iter.hasNext()) {
			
			Admin ad = iter.next();
			if(ad.getEmail().equals(admin.getEmail()) && ad.getPassword().equals(admin.getPassword()))	
				return ad;
		}
		return null;
	}
	
	public Employee checkEmployeeAccount(Employee employee) {
		Iterator<Employee> iter = employeeList.iterator();
		
		while(iter.hasNext()) {
			
			Employee emp = iter.next();
			if(emp.getEmail().equals(employee.getEmail()) && emp.getPassword().equals(employee.getPassword()))	
				return emp;
		}
		return null;
	}

	public Customer checkCustomerAccount(Customer customer) {
		Iterator<Customer> iter = customerList.iterator();
		
		while(iter.hasNext()) {
			
			Customer cu = iter.next();
			if(cu.getEmail().equals(customer.getEmail()) && cu.getPassword().equals(customer.getPassword()))	
				return cu;
		}
		return null;
	}

}
