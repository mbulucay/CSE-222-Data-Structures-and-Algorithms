
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application implements ApplicationInterface{

    Scanner scan = new Scanner(System.in);
    Integer operation = null;

    /**Loading Data And Running The Interacttive Menu */
    public void Runner(){
        try {
            DataBase.loadUserData();
            mainMenu();
        } catch (FileNotFoundException e) {
            System.out.println("Users Data cant load");
            System.out.println("Check traders.csv and customers.csv file");
            e.printStackTrace();
        }
    }


    public void mainMenu(){
        try{
            while(true){
                System.out.println("1-> Trader Menu");
                System.out.println("2-> Customer Menu");
                System.out.println("0-> Close The Program");
                System.out.println("Enter the operation :");
                operation = Integer.parseInt(scan.nextLine());
            
                switch (operation){

                    case 1: traderMenu();
                        break;
                    case 2: customerMenu();
                        break;
                    case 0: System.out.println("Come Again");
                        System.exit(1);
                    default:
                        System.out.println("Undefined Command");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    private void traderMenu(){
        try{
            while(true){
            
                System.out.println("1->Login The System");
                System.out.println("0-Move Main Menu>");
                System.out.println("Enter the operation :");
                operation = Integer.parseInt(scan.nextLine());
                
                switch(operation){
                    case 1: traderLogin();
                        break;

                    case 0: System.out.println("Going Main Menu");
                        return;
                    default:
                        System.out.println("Undefined Command");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void traderLogin(){

        System.out.println("Enter the id: ");
        Integer id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the password: ");        
        String password = scan.nextLine();

        Trader trader = (Trader) DataBase.checkUser(new Trader(null,id,password));
        if(trader != null)
            traderAuthority(trader);
        else 
            System.out.println("Could not find Trader user");    
        
    }
    
    /** 
     * @param trader
     * Menu for trader properties can make 
     */
    private void traderAuthority(Trader trader){

        while(true){
        
            System.out.println("================================");
            System.out.println("Welcome " + trader.getName() + " store");
            System.out.println("1->See current orders");
            System.out.println("2->Manage Orders");
            System.out.println("3->Add Product"); 
            System.out.println("4->Remove Product");
            System.out.println("5->Edit Product");
            System.out.println("0->Log Out");
            System.out.println("Enter the operation :");
            operation = Integer.parseInt(scan.nextLine());

            switch(operation){

                case 1: trader.displayOrders();
                    break;
                case 2: trader.manageOrders();
                    break;
                case 3: trader.addProduct();
                    break;
                case 4: trader.removeProduct();
                    break;
                case 5: trader.editProduct();
                    break;
                case 0: System.out.println("Going Main Menu");
                    return;
                default:
                    System.out.println("Undefined Command");
            }
        }
    }

    
    private void customerMenu(){
        try{
            while(true){
                System.out.println("1->Sign Up");
                System.out.println("2->Log in");
                System.out.println("0-Move Main Menu");
                System.out.println("Enter the operation :");
                operation = Integer.parseInt(scan.nextLine());

                switch(operation){

                    case 1: customerSignUp();
                        break;
                    case 2: customerLogin();
                        break;
                    case 0: System.out.println("Going Main Menu");
                        System.exit(1);
                    default:
                        System.out.println("Undefined Command");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**To save itself to database */
    private void customerSignUp() {
        try{
            Customer c = ObjectCreator.createCustomer();
            
            if(DataBase.containsCustomer(c.getId())){
                System.out.println("This id already taken from somebody else");
                return;
            }

            DataBase.addUser(c);
            c.saveFile();
            System.out.println("Customer saved the data base");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void customerLogin() {

        try{
            System.out.println("Enter the id: ");
            Integer id = Integer.parseInt(scan.nextLine());
            System.out.println("Enter the password: ");
            String password = scan.nextLine();

            Customer customer = (Customer) DataBase.checkUser(new Customer(null,null,id,password));
            if(customer != null)
                customerAuthority(customer);
            else 
                System.out.println("Could not find Customer user");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    /** 
     * @param customer
     * Menu for customer properties can make
     */
    private void customerAuthority(Customer customer) {
        try{
            while(true){

                System.out.println("================================");
                System.out.println("Welcome " + customer.getName() + " " + customer.getSurname());
                System.out.println("1->See orders");
                System.out.println("2->Order a product");
                System.out.println("3->Search product");
                System.out.println("4->See all product of a Trader");
                System.out.println("5->Query a product");
                System.out.println("0->Log Out");
                System.out.println("Enter the operation :");
                operation = Integer.parseInt(scan.nextLine());

                switch(operation){
                    case 1: customer.displayOrders();
                        break;
                    case 2: customer.orderAProduct();
                        break;
                    case 3: customer.searchProduct(); 
                        break;
                    case 4: customer.seeAllProductOfTrader();  
                        break;  
                    case 5: customer.queryProduct();
                        break;

                    case 0: return;
                    default:
                        System.out.println("Undefined operation");

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
