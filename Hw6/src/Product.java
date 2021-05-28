
import java.util.Comparator;

public class Product implements Comparable<Product>,ProductInterface{

    private String productId;
    private String productName;
    private String productCategoryTree;
    private Double price;
    private Double discountedPrice;
    private String description;
    private Trader trader;

    public Product(String productId,String productName,String productCategoryTree,
                    Double price,Double discountedPrice,String description,Trader trader){
        this.productId = productId;
        this.productName = productName;
        this.productCategoryTree = productCategoryTree;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.description = description;
        this.trader = trader;
    }

    
    /** 
     * @return String
     */
    public String getProductId(){return productId;}

    
    /** 
     * @return String
     */
    public String getProductName(){return productName;}

    
    /** 
     * @return String
     */
    public String getProductCategoryTree(){return productCategoryTree;}

    
    /** 
     * @return Double
     */
    public Double getPrice(){return price;}

    
    /** 
     * @return Double
     */
    public Double getDiscountedPrice(){return discountedPrice;}

    
    /** 
     * @return String
     */
    public String getDescription(){return description;}

    
    /** 
     * @return Trader
     */
    public Trader getTrader(){return trader;}

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Product o) {
        return 0;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getProductName() + ":\n");
        sb.append(this.getDescription() + "\n");
        sb.append("Price : " + this.getPrice() + "\n");
        sb.append("Discounted Price :" + this.getDiscountedPrice() + "\n");
        return sb.toString(); 
    }

    /**DiscountedPrice Increasing comparator */
    public static Comparator<Product> DiscountedPriceComparatorIncreasing = new Comparator<Product>() {
	
		@ Override
		public int compare(Product o1,Product o2) {
			return (int) (o1.getDiscountedPrice() - o2.getDiscountedPrice());
		}
	};

    /**DiscountedPrice Decreasing comparator */
    public static Comparator<Product> DiscountedPriceComparatorDecreasing = new Comparator<Product>() {

        @ Override
		public int compare(Product o1,Product o2) {
			return (int) (o2.getDiscountedPrice() - o1.getDiscountedPrice());
		}
	};

    /**Price Increasing comparator */
    public static Comparator<Product> PriceComparatorIncreasing = new Comparator<Product>() {

        @Override
		public int compare(Product o1,Product o2) {
			return (int) (o1.getPrice() - o2.getPrice());
		}
	};
	
    /**Price Decreasing comparator */
	public static Comparator<Product> PriceComparatorDecreasing = new Comparator<Product>() {

        @Override
		public int compare(Product o1,Product o2) {
			return (int) (o2.getPrice() - o1.getPrice());
		}
	};

    /**Name Comparator Decreasing */
	public static Comparator<Product> NameComparator = new Comparator<Product>() {

		@Override
		public int compare(Product o1, Product o2) {
			if(o1.getProductName().compareTo(o2.getProductName()) > 0)
				return -1;
			if(o1.getProductName().compareTo(o2.getProductName()) < 0)
				return 1;
			return 0;
		}
	};
    

}
