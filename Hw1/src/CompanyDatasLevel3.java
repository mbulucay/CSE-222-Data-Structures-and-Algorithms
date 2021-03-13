/**<p>It keeps data and operations for customer 
 * like query product or see all product </p>*/
public class CompanyDatasLevel3 {

	protected int currentBranchNumber = 0;
	
	protected Branch[] branchs; 
	
	CompanyDatasLevel3(){	}
	/**<p>It search for the wanted furniture in all branch using linear search</p>*/
	public Branch queryProduct(Furniture obj) {
		for(int i = 0; i<currentBranchNumber; ++i) {
			if(branchs[i].queryProduct(obj))
				return branchs[i];
		}
		return null;
	}
	/**<p>It is display all product in system for customer</p>*/
	public void displayProducts() {
		System.out.println("All Products : ");
		for(int i=0; i<currentBranchNumber; ++i) 
			branchs[i].displayProducts();
	}
	
}
