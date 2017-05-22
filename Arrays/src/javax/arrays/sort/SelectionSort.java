package javax.arrays.sort;

import javax.arrays.search.*;


public class SelectionSort extends Sort{

    public SelectionSort(int[] array) {
        super(array);
    }
    
    @Override
    public void run(){
        final Finder finder = new MinFinder(array);
        for (int i = 0; i < array.length-1; i++) {
            int min = finder.find(i);
            if (needSwap(i, min)){
                swap(i,min);
            }
        }
    }
    
    public boolean needSwap (int i, int j){
        return i!= j;
    }
    
    
}
