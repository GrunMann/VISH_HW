
package javax.arrays;

public class Random extends java.util.Random{
    
    private void randomize(int[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = nextInt(100);
        }
    }
    
    public int[] intArray(int len){
        int[] a= new int[len];
        randomize(a);
        return a;
    }
    
    public static int[] randomArray(int len){
        //Random r= new Random();
        //return r.intArray(len);
        return new Random().intArray(len);
    }
}
