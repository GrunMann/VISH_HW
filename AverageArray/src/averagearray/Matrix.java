package averagearray;
import java.util.Random;


public class Matrix {
    public int x;
    public int y;
    int [][] array;
    public Matrix(int x, int y ) {
        this.x = x;
        this.y = y;
        this.array=new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Random random = new Random();
                array[i][j]=random.nextInt(10);
            }
        }
    }
    
    public void Arrange (){
        int average=0;
        int buffAVG=0;
        int []buffer;
        for (int i = 0; i < array.length; i++) {
            buffAVG=Average(array[i]);
            for (int ii = 0; ii<  array.length-1; ii++) {
                average=Average(array[ii]);
                if (buffAVG>average){
                    buffer=array[i];
                    array[i]=array[ii];
                    array[ii]=buffer;
                    buffAVG=average;
                }
            }
        }
    }
    public void PrintMatrix(){
        System.out.println("");
        int counter=0;
        for (int[] array1 : array) {
            for (int j = 0; j < array1.length; j++) {
                System.out.print(array1[j]);
                counter += array1[j];
            }
            System.out.println("  "+ counter);
            counter=0;
        }
    }
    
    int Average(int[] array){
        int average=0;
        for (int j = 0; j < array.length; j++) {
            average+=array[j];
        }
        return average;
    }

    
}
