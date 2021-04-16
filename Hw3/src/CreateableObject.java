/**<h2>Create object interface</h2>*/
public interface CreateableObject {
	
	/**<p>Creating Admin object and return it</p>*/
	public Admin makeAdmin(DATA d);
	
	/**<p>Creating Employee object and return it</p>*/
	public Employee makeEmployee(DATA d);
	
	/**<p>Creating Customer object and return it</p>*/
	public Customer makeCustomer(DATA d);
	
	/**<p>Creating Branch object and return it</p>*/
	public Branch makeBranch();
	
	/**<p>Creating Furniture object and return it</p>*/
	public Furniture makeProduct();
	public Furniture getProduct(int type);	
	public Furniture createProduct(int maxColor,int maxModel,int type);
	
}
