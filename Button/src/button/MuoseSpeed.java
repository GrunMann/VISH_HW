package button;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MuoseSpeed implements Runnable{
    
    public double speed;
    private Point coordinate = new Point(0, 0);
    private Point coordinate2 = new Point(0, 0);
    private long timeGap=100;//milliseconds
    
    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void run(){
        try{
            while(FunWindow.getFrames().length>0) {
                coordinate2=coordinate;
                Thread.sleep(timeGap);
            }
        }catch (InterruptedException e){
                e.printStackTrace();
        }

            
        
    }

    public double length(Point a, Point b){
        return Math.hypot((Math.max(a.x, b.x)-Math.min(a.x,b.x)),(Math.max(a.y, b.y)-Math.min(a.y,b.y)));
    }
    public double getSpeed(){
        if (length(coordinate, coordinate2) >0 ){
            return length(coordinate, coordinate2);
        }
        return 0;
    }
    
}
