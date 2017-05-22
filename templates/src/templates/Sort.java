package templates;
public class Sort <E extends Comparable<E>>{
    private final  E[] array;

    public Sort(E[] array) {
        this.array = array;
    }
    private void swap (int i, int j){
        E t=array[i];
        array[i] = array[i];
        array[j]=t;
    }
    private void sort (int d){
        boolean exit = true;
        for (int i = 0; i < array.length-d; i++) {
            if (array[i].compareTo(array[i+d])>0) {
                swap (i, i+d);
                exit=false;
            }
        }
        if (!exit) sort (d);
    }
    public void sort(){
        int d = array.length;
        while (d>0) sort(d/=2);
    }
}
