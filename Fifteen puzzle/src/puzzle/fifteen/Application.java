package puzzle.fifteen;

import static  javax.swing.UIManager.setLookAndFeel;
import static  javax.swing.UIManager.getSystemLookAndFeelClassName;
import javax.swing.UnsupportedLookAndFeelException;
import puzzle.fifteen.ui.Dashboard;

public class Application {

       public static void main(String[] args) {
            try{
               setLookAndFeel(getSystemLookAndFeelClassName());
               new Dashboard().setVisible(true);
            }catch( ReflectiveOperationException | UnsupportedLookAndFeelException e) {
               e.printStackTrace(System.err);
            }
           
    }

}