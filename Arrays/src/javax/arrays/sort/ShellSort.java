package javax.arrays.sort;

import javax.arrays.search.*;


public class ShellSort extends Sort{

    public ShellSort(int[] array) {
        super(array);
    }
    
    @Override
    public void run(){
        final Finder finder = new MaxFinder(array);
        int d = (int)array.length/2;
        while(d>=1){
            for (int i = 0; i < array.length; i=i+d) {
                int max = finder.find(i);
                if (needSwap(i, max)){
                    swap(i,max);
                }
            }
            d--;
        }
    }
    
    public boolean needSwap (int i, int j){
        return i!= j;
    }
    
    
}
