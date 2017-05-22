package puzzle.fifteen.ui;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Dashboard extends JFrame implements ActionListener{

    private final Collection<JButton> buttons;
    
    public Dashboard() {
        super("Fifteens");
        buttons=new LinkedList<>();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        initComponents();
    }
    
    protected final void initComponents(){
        setLayout(null);
        setResizable(false);
        getContentPane().setPreferredSize(new Dimension(400, 400));
        createButtons();
        pack();
    }
    private void createButtons(){
        final int width = 100;
        JButtonBuilder builder = new JButtonBuilder();
            builder .setSize(new Dimension(width,width))
            .setActionCommand("move")
            .setActionListener(this);
        
        for (int i=0; i<15; i++){
            JButton button = builder
                    .setTitle(Integer.toString(i))
                    .setLocation(new Point(i%4*width, i/4*width))
                    .build();
            
            add(button);
            buttons.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command != null){
            switch (command){
                case "move":
                    onMove((JButton)e.getSource());
                    break;
                default:
                    throw new UnsupportedOperationException(command);
            }
        }
    }

    private void onMove(JButton button) {
        HOMEWORK!
    }
    
}
