package javax.arrays.sort;

public abstract class Sort {
    
    final int[] array;
    public Sort(int[] array){
        this.array = array;
    }
    
    void swap (int i, int j){
        int t = array[i];
        array[i]= array[j];
        array[j]=t;
    }
    
    abstract boolean needSwap(int i, int j);
    
    public abstract void run();
    
}
    
