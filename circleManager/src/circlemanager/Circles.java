package circlemanager;
import java.util.Random;

public class Circles {
    
    int circlesCount;
    public double midVal;
    public Circle [] circles = null;
    public Circle middleCircle= null;

    public Circles(int circlesCount) {
        this.circlesCount = circlesCount;
        this.circles = new Circle[circlesCount];
        double summ =0.;
        for (int i = 0; i < circlesCount; i++) {
            Random randRad = new Random();
            circles[i]= new Circle(randRad.nextInt(10), i);
            summ+=circles[i].length1;
        }
        this.midVal = summ/circlesCount;
        middleCircle= CloseToMid(circles);
    }
    

    private Circle CloseToMid(Circle[] circles){
        double diff;
        double dd=0;
        Circle resCircle = null;
        for(Circle circle: this.circles){
            if (dd == 0){
                dd=circle.length1;
            }
            if(circle.length1-midVal>0){
                diff=circle.length1-midVal;
            } else {
                diff=midVal-circle.length1;
            }
            if (diff<dd){
                dd=diff;
                resCircle=circle;
            }
        }
        
        return resCircle;
    }
    
    
}
