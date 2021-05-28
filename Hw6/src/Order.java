public class Order implements OrderInterface{

    private Product product;
    private Customer customer;
    private Trader trader;

    public Order(Product product,Customer customer,Trader trader){
        this.product = product;
        this.customer = customer;
        this.trader = trader;
    }
    
    
    /** 
     * @return Product
     * Returning order product
     */
    public Product getProduct(){return product;}

    
    /** 
     * @return Customer
     * Returning order customer
     */
    public Customer getCustomer(){return customer;}

    
    /** 
     * @return Trader
     * Returning order trader
     */
    public Trader getTrader(){return trader;}

    /**Adding customer shop list if the trader accept the order */
    public void makeSell(){
        customer.buyProduct(product);
    }

    
    /** 
     * @return String
     */
    @Override 
    public String toString(){
        return customer.getName()  + " ordered " + product.getProductName() + " from " + trader.getName();
    }


}
