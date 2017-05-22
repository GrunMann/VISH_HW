package templates;
public class Price implements Comparable<Price>{
    private final double self, added, total;

    public Price( double self, double added) {
        this.self = self;
        this.added = added;
        total = self + added;
    }

    public double getSelf() {
        return self;
    }

    public double getAdded() {
        return added;
    }
    
    @Override
    public int hashCode() {
        return Double.hashCode(total);
    }

    @Override
    public boolean equals(Object obj) {
    /*  if (obj instanceof Price) {
            return hashCode() == obj.hashCode();
        }
        return false;*/
        return obj instanceof Price ? hashCode() == obj.hashCode() : false;
    }
    
    @Override
    public int compareTo(Price price) {
        if( !price.equals(this)){
            return total > price.total ? 1 :-1;
        }
        return 0;
    }
    
}
