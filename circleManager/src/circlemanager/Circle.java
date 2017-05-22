package circlemanager;
public class Circle {
    double radius;
    int ID;
    double length1;

    public Circle(double radius, int ID) {
        this.radius = radius;
        this.ID=ID;
        this.length1=2.*Math.PI*this.radius;
        
    }
    
}
