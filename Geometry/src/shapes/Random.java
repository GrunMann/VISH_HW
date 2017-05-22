package shapes;

import shapes.exceptions.UnsupportedArgumentExceptin;

public class Random extends java.util.Random {

    @Override
    public float nextFloat() {
        float a = nextInt(10);
        float b = nextInt(100);
        return a + b / 100;
    }

    public Point nextPoint() {
        float x = nextFloat();
        float y = nextFloat();
        return new Point(x, y);
    }

    public Circle nextCircle() {
        float radius = nextFloat();
        try {return new Circle(radius);} 
        catch (UnsupportedArgumentExceptin e) 
        {return nextCircle();}
    }
        
    public Triangle nextTriangle () { 
        Point a = nextPoint ();
        Point b = nextPoint ();
        Point c = nextPoint (); 
        try {return new Triangle (a,b,c);} 
        catch (UnsupportedArgumentExceptin e) 
        {return nextTriangle();}
    }
    
    public Shape nextShape () { 
        int basis = nextInt (2); 
        switch (basis) { 
            case 0 : 
                return nextCircle ();
            case 1 : 
                return nextTriangle (); 
            default: 
                throw new UnsupportedOperationException();
    }
    }
    public Shape [] shapes (int n) { 
        Shape [] shapes = new Shape [n]; 
        while (n --> 0) shapes [n] = nextShape (); 
        return shapes; 
    }
}


