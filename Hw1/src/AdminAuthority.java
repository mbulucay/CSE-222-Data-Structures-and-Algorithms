
public interface AdminAuthority {
	
	public int getBranchNumber();

	public boolean addBranch(Branch newBranch) ;
	
	public boolean removeBranch(int index);
	
	public boolean removeBranch(Branch branch) ;

	public Branch getBranch(int index) ;
	
	public void addEmployee(Branch branch,Employee employee);

	public void removeEmployee(Branch branch,Employee employee);

}
