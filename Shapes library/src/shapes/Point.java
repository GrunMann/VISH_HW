package shapes;

import io.exceptions.ParseException;

public class Point {
    private final float x;
    private final float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return (Float.hashCode(x)-3) | (Float.hashCode(y));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point ? hashCode() == obj.hashCode() : false;
    }

    @Override
    public String toString() {
        return x+":"+y;
    }
    
    public static Point valueOf(String string)throws ParseException{
        String[] parts = string.split(":", 2);
        try{
            if (parts.length>1){
                float x=Float.valueOf(parts[0]);
                float y=Float.valueOf(parts[1]);
                return new Point(x, y);
            }
        }catch (NumberFormatException ignore){}
        throw new ParseException();
    }
    
}
