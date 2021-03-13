
public interface CustomerAuthority {

	public boolean buyProduct(Furniture boughtFurniture);
	
	public void onlineShopping(Furniture f);
	
	public Branch queryProduct(Furniture obj);
	
	public void displayShoppingList();
	
}
