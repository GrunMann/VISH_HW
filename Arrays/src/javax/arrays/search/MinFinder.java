package javax.arrays.search;

public class MinFinder implements Finder{
    
    
    public int find() {
        return 0;
    }
    
    int[] array;
    public MinFinder(int[] array) {
        this.array=array;
    }
    
    
    public int find(int i){
        int min = i++;
        /*while (i<array.length){
            if (array[min]>array[i]){
                min=i;
            }
        }*/
        for (; i <array.length; i++) {
            if (array[min]>array[i]){
                min=i;
            }
        }
        return min;
    }
    
}
