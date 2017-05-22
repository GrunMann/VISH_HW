package goods;

public class Goods {

    public static void main(String[] args) {
        
        Product[] products = new Product[]{
            new Product("Milk",   52),
            new Product("Bread",  46),
            new Product("Pork",   150),
            new Product("Ham",    200),
            new Product("Shugar", 40),
            new Product("Olives", 60),
        };
        
        for(Product product : products){
            try{
                product.reducePrice(100);
            } catch (PriceReduceException e){
                System.out.println("Wrong reducing amount for "+product.getName());
            }
        }
        
        Product max = null;
        for (Product product : products) {
            if (max == null || product.getPrice()>max.getPrice()){
                max=product;
            }       
        }
        System.out.println(max.getName()+" is most expensive product.");
    }
}
