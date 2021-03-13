import java.util.NoSuchElementException;
import java.util.Scanner;
/**<p>It keeps data and operations just for admin operations and make admin operations 
 * other employee and customer cannot reach these level data 
 * like adding Branch , adding Employee</p>*/
public class CompanyDatasLevel1 extends CompanyDatasLevel2 implements AdminAuthority{

	private int standartBranchNumber = 1001;
	
	private int adminDefaultSize = 101;
	private int adminCounter = 0;
	private Admin[] adminArr;
	
	CompanyDatasLevel1(){
		branchs = new Branch[standartBranchNumber];
		adminArr = new Admin[adminDefaultSize];
	}
	
	public int getBranchNumber(){
		return currentBranchNumber;
	}
	/**<p>Adding new admin in company data adminArr</p>*/
	public boolean addAdmin(Admin admin) {
		
		if(adminCounter >= adminDefaultSize)
			enlargeAdmin();
		
		adminArr[adminCounter++] = admin;
		System.out.println(admin.getName() +" added");
		return true;
	}
	/**<p>If admin array is full multiplay by 2</p>*/
	public void enlargeAdmin() {
		
		Admin[] tmpA = new Admin[adminCounter*2];
		for(int i=0; i<adminCounter; ++i)
			tmpA[i] = adminArr[i];
		
		adminArr = tmpA;
		adminDefaultSize *= 2;
	}
	/**<p>Make new admin and return it</p>*/
	public Admin makeAdmin() {
		
		String name,surname,email,password;
		Scanner ascan = new Scanner(System.in);
		try {
			System.out.println("\nCreating admin account");
			System.out.print("Enter the admin name :");
			name = ascan.nextLine();
			System.out.print("Enter the admin surame :");
			surname = ascan.nextLine();
			System.out.print("Enter thr admin email :");
			email = ascan.nextLine();
			System.out.print("Enter the password :");
			password = ascan.nextLine();
			return new Admin(this,name ,surname, email, password);
		}catch(NoSuchElementException e) {
			System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 193");
		}
		
		return null;
	}
	/**<p>checking admin account using linear search</p>*/
	public Admin checkAdminAccount(Admin admin) {
		
		for(int i=0; i<adminCounter; ++i)
			if(admin.getEmail().equals(adminArr[i].getEmail()) && admin.getPassword().equals(adminArr[i].getPassword()))
				return adminArr[i];
	
		return null;
	}
	/**<p>Making employee and return it</p>*/
	public Employee makeEmployee() {
		
		Scanner ascan = new Scanner(System.in);
		String str,name,surname,email,password;
		int index;
		
		displayBranchs();
		System.out.println("Enter the branch index number for employe is work where :");
		str = ascan.nextLine();
		index = Integer.parseInt(str);
		System.out.println("Enter employee name :");
		name = ascan.nextLine();
		System.out.println("Enter employee surname :");
		surname = ascan.nextLine();
		System.out.println("Enter employee mail :");
		email = ascan.nextLine();
		System.out.println("Enter employee password :");
		password = ascan.nextLine();
		Employee tmpEmployee = new Employee(this,getBranch(index),name,surname,email,password);
		
		return tmpEmployee;
	}
	/**<p>Adding new employee taken branch empArr</p>*/
	public void addEmployee(Branch branch,Employee employee) {
		
		branch.addEmployee(employee);
	}
	
	public void removeEmployee(Branch branch,Employee employee) {
		/*<p>Removing taken employee in branch</p>*/
		branch.removeEmployee(employee);
	}
	/**<p>checking employee account is there or not using linear search</p>*/
	public Employee checkEmployeeAccount(Employee employee) {
		
		for(int i=0; i<getBranchNumber(); ++i) {
			Employee emp = getBranch(i).checkEmployeeAccount(employee);
			if(emp != null)
				return emp;
		}
		return null;
	}
	/**<p>Adding new branch to company</p>*/
	public boolean addBranch(Branch newBranch) {
		
		if(currentBranchNumber >= standartBranchNumber) 
			enlargeBranch();
			
		branchs[currentBranchNumber++] = newBranch;
		
		return true;
	}
	/**<p>If branch arr is full then mutiply by 2 branch arr</p>*/
	public void enlargeBranch() {
		
		Branch[] tmpB = new Branch[standartBranchNumber*2];
		
		for(int i=0; i<currentBranchNumber; ++i)
			tmpB[i] = branchs[i];
		
		branchs = tmpB;
		standartBranchNumber *=2;
	}
	/**<p>Removing branch where index using array shifting</p>*/
	public boolean removeBranch(int index) {
		
		if(index >= currentBranchNumber) {
			System.out.println("Undefined branch index could not removed branch");
			return false;
		}
		while(index < currentBranchNumber)
				branchs[index] = branchs[++index];
		
		currentBranchNumber--;
		
		return true;
	}
	/**<p>Remove taken branch if it is exist using linear search</p>*/
	public boolean removeBranch(Branch branch) {
		
		for(int i=0; i<currentBranchNumber ; ++i) {
			if (branchs[i].equals(branch)) 
				return removeBranch(i);
		}
		return false;
	}
	/**<p>Returning branch in branchArr[index]</p>*/
	public Branch getBranch(int index) {
		
		if(index < currentBranchNumber)
			return branchs[index];
		
		return null;
	}
	/**<p>display existing branchs</p>*/
	public void displayBranchs() {
		
		for(int i=0; i<currentBranchNumber; ++i)
			System.out.println(i + "-> name : "+ branchs[i].getName());
	}
	/**<p>Displaying product in branch</p>*/
	public void displayProductsInBranch(Branch branch) {
		
		branch.displayProducts();
	}
}
