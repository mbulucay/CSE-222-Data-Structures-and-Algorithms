/**<p>Company adminstiration class</p>*/
public class Admin extends Person implements AdminAuthority{

	private DATA companyData;
	private static String mailBox;
	
	
	Admin(DATA d,String _name, String _surname, String _email, String _password) {
		super(_name, _surname, _email, _password);
		companyData = d;
		mailBox = new String();
	}
	
	/**<p>Adding new Branch to company </p>*/
	public boolean addBranch(Branch newBranch){
		return companyData.addBranch(newBranch);
	}
	
	/**<p>Removing Branch from company</p>*/
	public Branch removeBranch(int index) {
		return companyData.removeBranch(index);
	}
	
	/**<p>Removing Branch in Level 1 using default branch address</p>*/
	public Branch removeBranch(Branch branch) {
		return companyData.removeBranch(branch);
	}
	
	/**<p>It return branch in array wanted index</p>*/
	public Branch getBranch(int index) {
		return companyData.getBranch(index);
	}
	
	/**<p>Returning created branch number</p>*/
	public int getBranchNumber() {
		return companyData.getBranchNumber();
	}
	
	/**<p>Adding taken employee adding taking branch</p>*/
	public void addEmployee(Branch branch,Employee employee) {
		companyData.addEmployee(branch,employee);
	}
	
	/**<p>Removing taken employee adding taking branch</p>*/
	public Employee removeEmployee(Branch branch,Employee employee) {
		return companyData.removeEmployee(branch,employee);
	}
	
	/**<p>Query taken product in all branch using linear search</p>*/
	public boolean queryProduct(Furniture furniture) {
		Iterator<Branch> br = companyData.getBranchs().iterator();
		while(br.hasNext()) {
			if(br.next().queryProduct(furniture))
				return true;
		}
		return false;
	}
	
	public void displayBranchs() {
		companyData.displayBranchs();
	}
	
	public void displayEmployee() {
		
		Iterator<Branch> branchs = companyData.getBranchs().iterator();
		
		while(branchs.hasNext()) {
			Branch br = branchs.next();
			System.out.println(br);
			br.displayEmployees();
		}
	}
	
	/**<p>Make Branch and returning it</p>*/
	public Branch makeBranch() {
		return companyData.makeBranch();
	}
	
	/**<p>Make Employee and return it</p>*/
	public Employee makeEmployee() {
		return companyData.makeEmployee();
	}
	
	public static void getMessage(String message) {
		mailBox = mailBox + "\n" + message;
	}
	
	public static void displayMessages() {
		System.out.println(mailBox);
		
	}
	public static void clearMessages() {
		mailBox = "";
	}
	
	@Override
	/**<p>Comparing admin</p>*/
	public boolean equals(Object o) {
		
		if(!(o instanceof Admin ))
			return false;
		
		Admin obj = (Admin) o;
		return getName().equals(obj.getName()) && getSurname().equals(obj.getSurname()) 
				&& getEmail().equals(obj.getEmail()) && getPassword().equals(obj.getPassword());
	}

	@Override 
	public String toString() {
		return "Name : " + getName() + " Surname : "+ getSurname() ;
	}

}
