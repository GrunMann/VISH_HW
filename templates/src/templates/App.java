package templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.List;


public class App {
        
        static <E extends Comparable<E>> void sort(E[] array){
            new Sort<E>(array).sort();
        }
        
        static class PriceComparator implements Comparator<Price>{

            @Override
            public int compare(Price a, Price b) {
                return a.compareTo(b);
            }

        }
    
        public static void main(String[] args) {
           Integer[] a = new Integer[10];
           Random random = new Random();
           for (int i=0 ; i<a.length; i++) {
               a[i] = random.nextInt(100);
           }
           AvgFinder<Integer> finder = new AvgFinder<>(a);
           double avg = finder.find();

           //Sort<Integer> sorter = new Sort<>(a);
           //sorter.sort();
           
           Price[] prices = new Price[]{
               new Price (126, 7 ),
               new Price (43,  34),
               new Price (12,  6 ),
               new Price (183, 23),
               new Price (623, 3 ),
               new Price (126, 2 )
           };
           //Sort<Price> priceSort = new Sort<>(prices);
           //priceSort.sort();
           //sort(prices);
           Arrays.sort(prices, new PriceComparator());
           
           List<Integer> numbers = new ArrayList<>(20);
            for (int i = 0; i < 10; i++) {
                numbers.add(random.nextInt(100));
            }

           
    }
    
}
