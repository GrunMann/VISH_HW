package templates;
public class AvgFinder <E extends Number>{
    private final E[] array;

    public AvgFinder(E[] array) {
        this.array = array;
    }
    public double find (){
        double sum = 0;
        for (E number : array){
            sum+= number.doubleValue();
        }
        return sum / array.length;
    }
}
