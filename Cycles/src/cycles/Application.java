/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycles;

/**
 *
 * @author RERIR
 */
public class Application {

    /*
    static int reflect(int a){
        int b=0;
        while (a > 0){
            b*=10;    
            b+=(a%10);
            a/=10;
        }
        return b;
    }
    */
    static int stars(int a, int b){
        int spaces=b-a;
        /*spaces/=2;*/
        /*if(a%2==0) spaces+=b;*/
        while(spaces>0){
                System.out.print(" ");
                spaces--;
            }
        while(a>0){
                System.out.print("*");
                a--;
            }
        
        return 0;
    }
    
    public static void main(String[] args) {
        int x=1;
        int j=10;
        for ( int i=x;i<=j;i++){
            stars(i,j);
            System.out.print("\n");
        }
       
        
        
        
        
        /*
        float f;
        f = 5.0f;/*f - литерал указывающий явно, что это float*/
     /* int a = (int)(f + 2) , b = 2;
        long l = 12123123123L; /*L - литерал для long*/
      /*a++;
        a=1;
        int c = a +++ b;/*-> a++ + b */
        /*
        int a = 12345;
        int b =0;
        while (a > 0){
            b*=10;    
            b+=(a%10);
            a/=10;
        }
        */
        /*
        a = 12345;
        b =0;
        int i=0;
        while (a>0){
            a/=10;
            i++;
        }
        */
        /*int count = 0;
        for (int j=1 ; j <1000; j++){
            if (j==reflect(j)){
                count++;
            }
        }
        */
        /*
        int count=0;
        for (int i =1; i<=1000; i++){
            if( i%3==0 && i%5==0 ) count++;
        }
        
        System.out.println(count);
        */
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
