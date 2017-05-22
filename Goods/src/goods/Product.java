package goods;
public class Product {
    
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name =  name;
        this.price = price;
        
    }
    
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    
    public void addPrice(double added){
        price+=added;
    }
    
    public void reducePrice(double amount) throws PriceReduceException{
        if (amount<0){
            throw new WrongArgumentException();
        }
        if(price-amount>0){
            price-=amount;
        } else {
            throw new PriceReduceException();
        }
    }
    

}
