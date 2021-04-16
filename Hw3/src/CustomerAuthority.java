/**<h2>Customer Authority Interface</h2>*/
public interface CustomerAuthority {
    
	/**<p>Customer using linear search in all branch furniture</p>*/
    public Branch queryProduct(Furniture obj);
	
	/**<p>Add product customer shopping list</p>*/
	public boolean buyProduct(Furniture bF);
	
	/**<p>Printing  all buying products</p>*/
	public void displayShoppingList();
	
	/**<p>Display all product in all store</p>*/
	public void displayProducts();
	
	/**<p>Customer make online shop entering address and phone</p>*/
	public void onlineShopping();
}
