/**<h2>Admin Authority interface</h2>*/
public interface AdminAuthority {

	public boolean addBranch(Branch newBranch);
	
	/**<p>Removing Branch from company</p>*/
	public Branch removeBranch(int index);
	
	/**<p>Removing Branch in Level 1 using default branch address</p>*/
	public Branch removeBranch(Branch branch);
	/**<p>It return branch in array wanted index</p>*/
	public Branch getBranch(int index);
	
	/**<p>Returning created branch number</p>*/
	public int getBranchNumber();
	
	/**<p>Adding taken employee adding taking branch</p>*/
	public void addEmployee(Branch branch,Employee employee);
	
	/**<p>Removing taken employee adding taking branch</p>*/
	public Employee removeEmployee(Branch branch,Employee employee);
	
	/**<p>Query taken product in all branch using linear search</p>*/
	public boolean queryProduct(Furniture furniture);
	
	/**<p>Display all branches</p>*/
	public void displayBranchs();
	
	/**<p>Display all employees</p>*/
	public void displayEmployee();
	
	/**<p>Make Branch and returning it</p>*/
	public Branch makeBranch();
	
	/**<p>Make Employee and return it</p>*/
	public Employee makeEmployee();
	

}
