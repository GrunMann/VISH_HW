package cycles;
public class Stars {
    
    static void line(char c, int len){
        while (len --> 0){
            System.out.print(c+" ");
        }
        
//            for (int j = 0; j < len; j++) {
//                System.out.print(c + " ");
//            }
    }
    
    public static void main(String[] args) {
        final int size=5;
        final char c='*';
        
        for(int i=1; i<=size; i++){
            line(' ', size-i);
            line(c, i*2-1);
            System.out.println();
            
        }
        
    }
    
}
