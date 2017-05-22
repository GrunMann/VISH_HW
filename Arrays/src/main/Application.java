package main;

import static javax.arrays.Random.randomArray;
import javax.arrays.sort.*;

public class Application {


    
    public static void main(String[] args) {
        int [] a = randomArray(10);
        Sort sort = new SelectionSort(a);
        sort.run();
        Sort shellSort = new ShellSort(a);
        shellSort.run();
        
    }
    
}
