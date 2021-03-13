import java.util.NoSuchElementException;
import java.util.Scanner;
/**<p>Company adminstiration class</p>*/
public class Admin extends Person implements AdminAuthority{
	
	Scanner ascan = new Scanner(System.in);
	private static String mailBox = new String();
	
	private CompanyDatasLevel1 DataSetForAdmin;
	
	Admin(CompanyDatasLevel1 datas,String _name, String _surname, String _email, String _password) {
		super(_name, _surname, _email, _password);
		DataSetForAdmin = datas;
	}

	public boolean addBranch(Branch newBranch){
		return DataSetForAdmin.addBranch(newBranch);
	}
	/**<p>Removing Branch in Level 1 using index number of branch and shifting array </p>*/
	public boolean removeBranch(int index) {
		
		return DataSetForAdmin.removeBranch(index);
	}
	/**<p>Removing Branch in Level 1 using default branch adress</p>*/
	public boolean removeBranch(Branch branch) {
		return DataSetForAdmin.removeBranch(branch);
	}
	/**<p>It return branch in array wanted index</p>*/
	public Branch getBranch(int index) {
		return DataSetForAdmin.getBranch(index);
	}
	/**<p>Returning created branch number</p>*/
	public int getBranchNumber() {
		return DataSetForAdmin.getBranchNumber();
	}
	/**<p>Adding taken employee adding taking branch</p>*/
	public void addEmployee(Branch branch,Employee employee) {
		DataSetForAdmin.addEmployee(branch,employee);
	}
	/**<p>Removing taken employee adding taking branch</p>*/
	public void removeEmployee(Branch branch,Employee employee) {
		DataSetForAdmin.removeEmployee(branch,employee);
	}
	/**<p>Query taken product in all branch using linear search</p>*/
	public boolean queryProduct(Furniture furniture) {
		
		for(int i=0; i<getBranchNumber(); ++i) {
			if(getBranch(i).queryProduct(furniture))
				return true;
		}
		return false;
	}
	
	public void displayBranchs() {
		DataSetForAdmin.displayBranchs();
	}
	
	public static void getMessageFromEmployee(String str) {
		mailBox += str;
	}
	/**<p>Printing out of stock message getting from employee</p>*/
	public static void displayMessages() {
		
		if(mailBox.length() == 0)
			System.out.println("There is no messeage\n");
		else
			System.out.println(mailBox);
	}
	/**<p>Clearing mailbox</p>*/
	public static void clearMessages() {
		
		mailBox = new String();
	}
	/**<p>Make Branch and returning it</p>*/
	public Branch makeBranch() {
		
		try {
			String branchName;
			System.out.println("Enter the branch name :");
			branchName = ascan.nextLine();
			return new Branch(branchName);
		}catch(NoSuchElementException e) {
			System.out.println("You didnot enter a name for bracnh");
		}
		return null;
	}
	/**<p>Make Employee and return it</p>*/
	public Employee makeEmployee(Branch branch) {
		
		String name,surname,email,password;
		
		System.out.println("Enter employee name :");
		name = ascan.nextLine();
		System.out.println("Enter employee surname :");
		surname = ascan.nextLine();
		System.out.println("Enter employee mail :");
		email = ascan.nextLine();
		System.out.println("Enter employee password :");
		password = ascan.nextLine();
		Employee tmpEmployee = new Employee(DataSetForAdmin,branch,name,surname,email,password);
		
		return tmpEmployee;
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

