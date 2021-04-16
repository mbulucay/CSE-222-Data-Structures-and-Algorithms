import java.util.NoSuchElementException;
import java.util.Scanner;

public class ObjectCreater implements CreateableObject{
	
	/**<p>Make new admin and return it</p>*/
	public Admin makeAdmin(DATA d) {
		
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
			return new Admin(d,name ,surname, email, password);
		}catch(NoSuchElementException e) {
			System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 23");
		}
		
		return null;
	}
	
	/**<p>Making employee and return it</p>*/
	public Employee makeEmployee(DATA d) {
		
		Scanner ascan = new Scanner(System.in);
		String str,name,surname,email,password;
		int index;
		
		d.displayBranchs();
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
		Employee tmpEmployee = new Employee(d,d.getBranch(index),name,surname,email,password);
		
		return tmpEmployee;
	}
	
	/**<p>Making customer and return it</p>*/
	public Customer makeCustomer(DATA d) {
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
		
		customer = new Customer(d,name, surname, email, password);
		
		System.out.println("Your id: " + customer.getId());
		return customer;
	}

	/**<p>Make Branch and returning it</p>*/
	public Branch makeBranch() {
		Scanner ascan = new Scanner(System.in);
		try {
			String branchName;
			System.out.println("Enter the branch name :");
			branchName = ascan.nextLine();
			return new Branch();
		}catch(NoSuchElementException e) {
			System.out.println("You didnot enter a name for bracnh");
		}
		return null;
	}
	
	/**<p>Make Furniture and returning it</p>*/
	public Furniture makeProduct(){
		Scanner scan = new Scanner(System.in);
		int operation = 0;
		
		System.out.println("1-> Office chair");
		System.out.println("2-> Office Desk");
		System.out.println("3-> Meeting Table");
		System.out.println("4-> Bookcases");
		System.out.println("5-> Office Cabinets");
		System.out.println("Enter the value : ");
		operation = Integer.parseInt(scan.nextLine());

		return getProduct(operation);
	}
	
	/**<p>It is returning an product according to the chosen type</p>*/
	public Furniture getProduct(int type) {
		Furniture f = null;
		switch(type) {
			case 1: 	f = createProduct(4,6,1);
				break;
			case 2:		f = createProduct(3,4,2);
				break;
			case 3:		f = createProduct(3,9,3);
				break;
			case 4:		f = createProduct(0,11,4);
				break;
			case 5:		f = createProduct(0,11,5);	
		}
		return f;
	}
	
	/**<p>It make furniture as wanted color and model and return it</p>*/
	public Furniture createProduct(int maxColor,int maxModel,int type) {
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
	
}
