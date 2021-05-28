
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DataBase {

    public static HashMap<Integer,Customer> systemCustomers = new HashMap<>();
    public static HashMap<Integer,Trader> systemTraders = new HashMap<>();

    private static File customerFile = new File("customers.csv");
    private static File traderFile = new File("traders.csv");

    
    /** 
     * @throws FileNotFoundException
     * Loading Users data in the csv files
     */
    public static void loadUserData() throws FileNotFoundException{
        loadCustomers();
        loadTraders();
    }

    
    /** 
     * @throws FileNotFoundException
     * Loading traders data
     */
    private static void loadTraders() throws FileNotFoundException {
        
        Scanner fscan = new Scanner(traderFile);
        fscan.nextLine();

        while(fscan.hasNextLine()){
            String[] userData = fscan.nextLine().split(",");
            addUser(new Trader(userData[2],Integer.parseInt(userData[0]),userData[1]));
        }
        fscan.close();
    }

    
    /** 
     * @throws FileNotFoundException
     * Loading customer data
     */
    private static void loadCustomers() throws FileNotFoundException{

        Scanner fscan = new Scanner(customerFile);
        fscan.nextLine();

        while(fscan.hasNextLine()){
            String[] userData = fscan.nextLine().split(",");
            addUser(new Customer(userData[2],userData[3],Integer.parseInt(userData[0]),userData[1]));
        }
        fscan.close();
    }

    
    /** 
     * @param u
     * @return boolean
     * Adding user in to memory
     */
    public static boolean addUser(User u){

        if(u instanceof Customer){  
            addCustomer((Customer) u);
            return true;
        }
        if(u instanceof Trader) {   
            addTrader((Trader) u);
            return true;
        }
        return false;
    }

    
    /** 
     * @param trader
     * @return Trader
     * Adding trader in to the memory
     */
    private static Trader addTrader(Trader trader){
        return systemTraders.put(trader.getId(),trader);
    }

    
    /** 
     * @param user
     * @return Customer
     * Adding Customer in to the memory
     */
    private static Customer addCustomer(Customer user){
        return systemCustomers.put(user.getId(),user);
    }


    
    /** 
     * @param u
     * @return User
     * Checking user account
     */
    public static User checkUser(User u){

        if(u instanceof Customer)  
            return checkCustomer((Customer) u);
        if(u instanceof Trader)    
            return checkTrader((Trader) u);
        return null;
    }

    
    /** 
     * @param id
     * @return User
     * Returning user according to the id
     */
    public static User getUser(Integer id){
        
        User u = getCustomer(id);
        if(u == null)
            u = getTrader(id);
        
        return u;
    }


    
    /** 
     * @param customer
     * @return Customer
     * Check the customer account for validness
     */
    private static Customer checkCustomer(Customer customer){
        return systemCustomers.get(customer.getId());
    }

    
    /** 
     * @param id
     * @return Customer
     * Returning customer matching id
     */
    private static Customer getCustomer(Integer id){
        for (Customer obj : systemCustomers.values()) {
            if (id.equals(obj.getId()))
                return obj;
        } 
        return null;
    }

    
    /** 
     * @param trader
     * @return Trader
     * Check the trader account for validness
     */
    private static Trader checkTrader(Trader trader){
        return systemTraders.get(trader.getId()); 
    }

    
    /** 
     * @param id
     * @return Trader
     * Returning trader matching id
     */
    private static Trader getTrader(Integer id){
        for (Trader obj : systemTraders.values()) {
            if (id.equals(obj.getId()))
                return obj;
        } 
        return null;
    }

    
    /** 
     * @param name
     * @return Trader
     * Returning trader using the name of company
     */
    public static Trader getTrader(String name) {
        
        for(Trader trader : systemTraders.values()){
            if(trader.getName().equals(name))
                return (Trader) trader;
        }
        return null;
    }


    
    /** 
     * @param id
     * @return boolean
     * Is the customer have an account in the system
     */
    public static boolean containsCustomer(Integer id){
        return systemCustomers.containsKey(id);
    }

    
    /** 
     * @param id
     * @return boolean
     * Is the trader have an account in the system
     */
    public static boolean containsTrader(Integer id){
        return systemTraders.containsKey(id);
    }

}
