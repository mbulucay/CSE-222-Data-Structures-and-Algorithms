import java.util.Scanner;
/**<p>It keep data and operations just for employee
 * and customer cannot reach these level 
 * like add Product or remove Product </p>*/
public class CompanyDatasLevel2 extends CompanyDatasLevel3{
	
	private int defaultCustomerNumber = 10001;
	protected int customerCounter = 0;
	
	protected Customer[] customers;
	
	CompanyDatasLevel2(){
		customers = new Customer[defaultCustomerNumber];
	}
	
	public int getCustomerCounter() {
		return customerCounter;
	}
	
	/**<p>It is returning wanted customer for see the customer shopping list</p>*/
	public Customer getCustomer(int id) {
		Customer customer = null;
		
		for(int i=0; i<customerCounter; ++i) {
			if(customers[i].getId() == id) {
				customer = customers[i];
				break;
			}
		}
		return customer;
	}
	/**<p>If employee sell a product not registered customer 
	 * it need to make account before buying product
	 * This functions help about it </p>*/
	public Customer makeCustomer() {
		Scanner escan = new Scanner(System.in);
		Customer customer = null;
		String name, surname, email, password;
		
		System.out.println("Enter the name :");
		name = escan.nextLine();
		System.out.println("Enter the surname :");
		surname = escan.nextLine();
		System.out.println("Enter the email :");
		email = escan.nextLine();
		System.out.println("Enter the password :");
		password = escan.nextLine();
		
		customer = new Customer(this,name, surname, email, password);
		
		System.out.println("Your id: " + customer.getId());
		return customer;
	}
	/**<p>Display all registered customer</p>*/
	public void displayCustomers() {
		for(int i=0; i<customerCounter; ++i)
			System.out.println(i + ". " + customers[i]);
	}
	/**<p>It is displaying customer shopping list</p>*/
	public void displayCustomerList(int customerId) {
		
		for(int i = 0; i<customerCounter; ++i) {
			if(customers[i].getId() == customerId) {
				customers[i].displayShoppingList();
				return;
			}
		}
		System.out.println("Undefined customer id");
	}
	/**<p>It check the customer registration is it valid check mail and password</p>*/
	public Customer checkCustomerAccount(Customer customer) {
		for(int i=0; i<customerCounter; ++i) {
			if(customer.getEmail().equals(customers[i].getEmail()) && customer.getPassword().equals(customers[i].getPassword()))
				return customers[i];
		}
		return null;
	}
	/**<p>It make furniture and select the which type furniture like OfficeChair or Bookcases</p>*/
	public int chooseTypeProduct(){
		Scanner scan = new Scanner(System.in);
		int operation = 0;
		
		System.out.println("1-> Office chair");
		System.out.println("2-> Office Desk");
		System.out.println("3-> Meeting Table");
		System.out.println("4-> Bookcases");
		System.out.println("5-> Office Cabinets");
		System.out.println("Enter the value : ");
		operation = Integer.parseInt(scan.nextLine());

		return operation;
	}
	/**<p>It is returning an product according to the choossen type</p>*/
	public Furniture getProduct(int type) {
		Furniture f = null;
		switch(type) {
			case 1: 	f = makeProduct(4,6,1);
				break;
			case 2:		f = makeProduct(3,4,2);
				break;
			case 3:		f = makeProduct(3,9,3);
				break;
			case 4:		f = makeProduct(0,11,4);
				break;
			case 5:		f = makeProduct(0,11,5);	
		}
		return f;
	}
	/**<p>It make furniture as wanted color and model and return it</p>*/
	public Furniture makeProduct(int maxColor,int maxModel,int type) {
		Scanner escan = new Scanner(System.in);
		Furniture newFurniture = null;
		String str;
		int model,color;
		
		System.out.println("Enter the model number range [0,"+ maxModel +"] : ");
		str = escan.nextLine();
		model = Integer.parseInt(str);
		System.out.println("Enter the color number range [0,"+ maxColor +"] : ");
		str = escan.nextLine();
		color = Integer.parseInt(str);
		
		if(color >= 0 && color <= maxColor && model>=0 && model <= maxModel) {
			switch(type) {
				case 1:		newFurniture = new OfficeChair(color, model,0);
					break;
				case 2:		newFurniture = new OfficeDesk(color, model, 0);
					break;
				case 3:		newFurniture = new MeetingTable(color, model,0);
					break;
				case 4:		newFurniture = new Bookcases(color, model, 0);
					break;
				case 5:		newFurniture = new OfficeCabinet(color, model,0);
			}
		}else {
			System.out.println("You are not entered valid value for choosen furniture\nPlease, Enter valid value next time");
		}
		
		return newFurniture;
	}
	/**<p>It is adding a new customer to the system</p>*/
	public boolean addCustomer(Customer newCustomer) {
		if(customerCounter >= defaultCustomerNumber) 
			enlargeCustomer();
		
		customers[customerCounter++] = newCustomer;
		return true;
	}
	/**<p>If the customer array is full it is size multiply by 2</p>*/
	public void enlargeCustomer() {
		Customer[] tmpC = new Customer[defaultCustomerNumber*2];
		
		for(int i=0; i<customerCounter; ++i)
			tmpC[i] = customers[i];
	
		customers = tmpC;
		defaultCustomerNumber *= 2;
	}
}
