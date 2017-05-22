package circlemanager;


public class Application {

    public static void main(String[] args) {
        Circles circlesPull = new Circles(10);
        for(Circle circle : circlesPull.circles ){
            System.out.println("Circle Id:"+circle.ID+" Radius:"+circle.radius+" Perimetr:"+circle.length1);
        }
        System.out.println("\nCommon perimeter is:"+ circlesPull.midVal+"\n"+"Close to common is:"+circlesPull.middleCircle.ID +" with Perimeter "+ circlesPull.middleCircle.length1 + " and Radius " + circlesPull.middleCircle.radius);

    }
}
