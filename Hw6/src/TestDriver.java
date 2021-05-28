import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class TestDriver {


    public static void Runner() throws InterruptedException {


        System.out.println("Edit Product is taking dinamically value you can test it\n" 
                            + "to do uncomment line 94 to 97" );

        //Loading User Data From Files
        try {
            DataBase.loadUserData();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        //Creating Customer
        Customer c1 = new Customer("c1","c1",20000001,"asdfgh");
        Customer c2 = new Customer("c2","c2",20000002,"asdfgh");
        Customer c3 = new Customer("c3","c3",20000003,"asdfgh");
        Customer c4 = new Customer("c4","c4",20000004,"asdfgh");
        Customer c5 = new Customer("c5","c5",20000005,"asdfgh");

        //Adding to csv file
        if(DataBase.containsCustomer(c1.getId()) == false)
            c1.saveFile();
        Thread.sleep(500);
        if(DataBase.containsCustomer(c2.getId()) == false)
            c2.saveFile();
        Thread.sleep(500);
        if(DataBase.containsCustomer(c3.getId()) == false)
            c3.saveFile();
        Thread.sleep(500);
        if(DataBase.containsCustomer(c4.getId()) == false)
            c4.saveFile();
        Thread.sleep(500);
        if(DataBase.containsCustomer(c5.getId()) == false)
            c5.saveFile();


        //Added trader file to test
        Trader t = new Trader("t1", 30000000, "asdfgh");

        //Creating Products
        Product p1 = new Product("P1IDIDIDIDID", "pppp1", "ppppp >> 1", 101.0, 45.0, "1111111111", t );
        Product p2 = new Product("P2IDIDIDIDID", "pppp2", "ppppp >> 2", 112.0, 50.0, "2222222222", t );
        Product p3 = new Product("P3IDIDIDIDID", "pppp3", "ppppp >> 3", 123.0, 70.0, "3333333333", t );
        Product p4 = new Product("P4IDIDIDIDID", "pppp4", "ppppp >> 4", 134.0, 82.0, "4444444444", t );
        Product p5 = new Product("P5IDIDIDIDID", "pppp5", "ppppp >> 5", 145.0, 95.0, "5555555555", t );
        

        //Adding Products
        try {
            System.out.println("Adding products");
            Products.addProduct(p1);
            Products.addProduct(p2);
            Products.addProduct(p3);
            Products.addProduct(p4);
            Products.addProduct(p5);

            System.out.println("\nAfter Adding products:");
            for(Product p :Products.searchAllProductOfTrader(t.getName()))
                System.out.println(p);

            }catch (Exception e) {
            e.printStackTrace();
        }
      
        System.out.println("\n==========================\n");

        // Removing p5 
        try {
            System.out.println("Removing");
            Products.removeProduct(p5);
           
            System.out.println("\nAfter removing");
            for(Product p : Products.searchAllProductOfTrader(t.getName()))
                System.out.println(p);
        
        } catch (Exception e1) {
            e1.printStackTrace();
        }       

        System.out.println("\n==========================\n");

        try{
            
            // Products.editProduct(p4);
            // System.out.println("\nAfter Editing P4");
            // for(Product p : Products.searchAllProductOfTrader(t.getName()))
            //     System.out.println(p);

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\n==========================\n");
        System.out.println("\n==========================\n");

        //Ordering products to customer
         try {
            System.out.println("Adding orders ");
            Orders.addOrder(c1, p2);
            Orders.addOrder(c3, p3);
            Orders.addOrder(c4, p4);

            for(Order o : Orders.seeOrders(t))
                System.out.println(o); 

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        System.out.println("\n==========================\n");

        try {
            System.out.println("Cancel p2 order");
            Orders.deleteOrder(new Order(p2, c1, t));

            t.displayOrders();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n==========================\n");

        try{
            System.out.println("Accept order");
            Order o = new Order(p2, c1, t);
            
            System.out.println("Process 3 operation");
            System.out.println("-> o.makeSell()     Sending object ot customer shop list");
            System.out.println("-> Orders.deleteOrder(new Order(p2, c1, t))     Deleting orders file");
            System.out.println("-> Products.removeProduct(p2)       Removing products file");
            o.makeSell();
            Orders.deleteOrder(new Order(p2, c1, t));
            Products.removeProduct(p2);

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\n==========================\n");

        try{
            
            System.out.println("See all current product of Trader");
            for(Product p : Products.searchAllProductOfTrader(t.getName()))
                System.out.println(p);

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\n==========================\n");
        
        
        try{

            System.out.println("Search Products with \"ppp\"");
            ArrayList<Product> pL = Products.searchInCsv("ppp");

            for(Product p : pL)
                System.out.println(p);

            System.out.println("\n==========================\n");
            System.out.println("Sort Price");
            Collections.sort(pL,Product.PriceComparatorIncreasing);

            for(Product p : pL)
                System.out.println(p);

            System.out.println("\n==========================\n");
            System.out.println("Discounted Price");
            Collections.sort(pL,Product.DiscountedPriceComparatorIncreasing);

            for(Product p : pL)
                System.out.println(p);
                            
            System.out.println("\n==========================\n");
            System.out.println("Filter group tree with \"pppp\"");
            pL = (ArrayList<Product>)pL.stream()
                                    .filter(p -> p.getProductCategoryTree().contains("pppp"))
                                    .collect(Collectors.toList());
            for(Product p : pL)
                System.out.println(p);

            System.out.println("\n==========================\n");
            System.out.println("Filter upper = 130 and lower 110");
            
            pL = (ArrayList<Product>) pL.stream().
                filter(p -> p.getPrice() < 130 && p.getPrice() > 110).collect(Collectors.toList());
            
            for(Product p : pL)
                System.out.println(p);
        
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\n==========================\n");

    }
}
