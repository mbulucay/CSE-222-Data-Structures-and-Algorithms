
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Customer extends User implements CustomerAuthority{
    
    private String surname;

    private String filename = "customers.csv";
    private File file = new File(filename);
    
    private LinkedList<Product> shopList;
    private Queue<Order> orders;
    private ArrayList<Product> resultProducts;


    public Customer(String name,String surname,Integer id,String password){
        super(name,id, password);
        this.surname = surname;
        shopList = new LinkedList<>();
        orders = new LinkedList<>();
        resultProducts = new ArrayList<>();
    }

    
    /** 
     * @param product
     * @return String
     */
    public String getSurname(){return surname;}

    
    /** 
     * @param product
     * Adding customer shopList
     */
    public void buyProduct(Product product) {
        shopList.add(product);
    }

    /**Customer can see orders himself */
    public void seePreviousOrders(){
        
        try {
            orders = Orders.seeOrders(this);
            for(Order o : orders)
                System.out.println(o);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**Searching product in the product List */
    public void searchProduct(){
        
        Scanner scan = new Scanner(System.in);
        String productName;
        
        
        System.out.println("Enter the name of product");
        productName = scan.nextLine();
        try {
            
            resultProducts = Products.searchInCsv(productName);
            
            if(resultProducts.size() == 0){
                System.out.println("Product has not found in the product list");
                return;
            }
            searchMenu(resultProducts);

        } catch (FileNotFoundException e) {
            System.out.println("File cannot found");
            e.printStackTrace();
        }

    }

    
    /** 
     * @param resultProducts
     * Customer can filter the product List using this menu
     */
    private void searchMenu(ArrayList<Product> resultProducts){
        
        Scanner scan = new Scanner(System.in);
        int operation;
        int a = 0;
            
        try{
            while(true){

                a = 0;
                for(Product p : resultProducts)
                    System.out.println( a++ + " -> " + p);
                
                System.out.println("1-> Sort by Price ");
                System.out.println("2-> Sort by Discount Price ");
                System.out.println("3-> Sort by Name");
                System.out.println("4-> Filter upper bound price");
                System.out.println("5-> Filter lower bound price");
                System.out.println("6-> Filter upper and lower bound price");
                System.out.println("7-> Filter according to the group(low and up)");
                System.out.println("8-> Choose  product to order");
                System.out.println("0-> Customer Menu");
                operation = Integer.parseInt(scan.nextLine());

                switch(operation){

                    case 1: Collections.sort(resultProducts,Product.PriceComparatorDecreasing);
                        break;
                    case 2: Collections.sort(resultProducts,Product.DiscountedPriceComparatorDecreasing);
                        break;
                    case 3: Collections.sort(resultProducts,Product.NameComparator);
                        break;
                    case 4: resultProducts = upperFilter(resultProducts);
                        break;
                    case 5: resultProducts = lowerFilter(resultProducts);
                        break;
                    case 6: resultProducts = upperFilter(resultProducts);
                            resultProducts = lowerFilter(resultProducts);
                        break;
                    case 7: resultProducts = levelFilter(resultProducts);
                        break;
                    case 8: Orders.addOrder(this, chooseProduct(resultProducts));
                        break;

                    case 0: return;
                    default:
                        System.out.println("Undefined operation");
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    
    /** 
     * @param products
     * @return Product
     * Chosee the product to buy 
     */
    private Product chooseProduct(ArrayList<Product> products){

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the index of product");
        int index = Integer.parseInt(scan.nextLine());

        return products.get(index);
    }
    

    
    /** 
     * @param products
     * @return ArrayList<Product>
     * Make arrange over the List according to the group tree
     */
    private ArrayList<Product> levelFilter(ArrayList<Product> products){
        
        Scanner scan = new Scanner(System.in);
        String level;

        System.out.println("Enter the level of product");
        level = scan.nextLine();

        return (ArrayList<Product>) products.stream().
                filter(p -> p.getProductCategoryTree().contains(level)).collect(Collectors.toList());
    }

    
    /** 
     * @param products
     * @return ArrayList<Product>
     * Make arrange over the List according to the upper bound price
     */
    private ArrayList<Product> upperFilter(ArrayList<Product> products){
        Scanner scan = new Scanner(System.in);
        int upper;

        System.out.println("Enter the upper bound :");
        upper = Integer.parseInt(scan.nextLine());
        
        return (ArrayList<Product>) products.stream().
                filter(p -> p.getPrice() < upper).collect(Collectors.toList());
    }

    
    /** 
     * @param products
     * @return ArrayList<Product>
     * Make arrange over the List according to the lower bound price
     */
    private ArrayList<Product> lowerFilter(ArrayList<Product> products){
        Scanner scan = new Scanner(System.in);
        int lower;

        System.out.println("Enter the lower bound :");
        lower = Integer.parseInt(scan.nextLine());

        return (ArrayList<Product>) products.stream().
                filter(p -> p.getPrice() > lower).collect(Collectors.toList());
    }

    /**Display Current orders himself */
    public void displayOrders() {

        try {
            orders = Orders.seeOrders(this);
            for(Order o : orders)
                System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Sending order to trader for buying a product */
    public void orderAProduct() {

        Scanner scan = new Scanner(System.in);
        String pId;
        
        try {
            System.out.println("Enter the product id to order");
            pId = scan.nextLine();
        
            Product product = Products.findProduct(pId);
        
            if(product == null){
                System.out.println("Product cannot found!");
                return;
            }
            Orders.addOrder(this,product);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
   
    }

    /**Quering the product in the product.csv */
    public void queryProduct(){
        Scanner scan = new Scanner(System.in);
        String pName;
        
        try {
            System.out.println("Enter the quering product name");
            pName = scan.nextLine();
            System.out.println(pName + " => " + Products.queryProduct(pName));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**Customer can see all products of a trader */
    public void seeAllProductOfTrader() {

        Scanner scan = new Scanner(System.in);
        String traderName;
        ArrayList<Product> products = null;
        
        try {
            
            System.out.println("Enter the name of trader:");        
            traderName = scan.nextLine();
            products = Products.searchAllProductOfTrader(traderName);
            
            Collections.sort(products,Product.NameComparator);
            for(Product p : products)
                System.out.println(p);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**Saving the data base using database static class */
    public void saveFile(){
        try {

            DataBase.addUser(this);
            
            FileWriter fw = new FileWriter(file,true);
            fw.write(this.getId() + "," + this.getPassword() + "," + this.getName() + "," + this.getSurname() + "\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        return this.getName() + " " + this.getSurname() + " " + this.getId() + " " + this.getPassword();
    }

}
