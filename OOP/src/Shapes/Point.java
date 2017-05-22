package Shapes;

public class Point {
    private float x, y;
    public  Point(float x, float y){                                                                    //Constructor
        this.x=x;
        this.y=y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public float distanceTo(Point pt){
        float dx=x -pt.x;
        float dy=y -pt.y;
        double dx2 = Math.pow(dx, 2);
        double dy2 = Math.pow(dy, 2);
        return (float) Math.sqrt(dx2 + dy2);
    }
}
