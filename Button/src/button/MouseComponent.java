package button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JButton;
import button.MuoseSpeed;
import java.awt.Point;

public class MouseComponent extends JComponent{

    private JLabel text;
    private JButton butt = new JButton("Start!");
    private int buttonX=100;
    private int buttonY=50;
    private int buttonWidth=150;
    private int buttonHeight=50;
    private int gap=20;
    private MuoseSpeed speed = new MuoseSpeed();
    
    
    public MouseComponent() {
        text = new JLabel("");
        text.setBackground(Color.red);
        text.setBounds(0, 0, 400, 20);
        add(text);
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
        
        butt.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        this.add(butt);
        ButtonCatch buttonCatch = new ButtonCatch();
        butt.addActionListener(buttonCatch);
//        speed.run();
        Thread t = new Thread(speed);
        t.start();
    }
    @Override
    public Dimension getPreferredSize(){return new Dimension(1000, 200);}
    
    public void setLabelText(String coordinates){
        this.text.setText(coordinates);
    }
    private class MouseHandler extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            setLabelText("X:"+event.getX()+", Y:"+event.getY()+" Butt at "+buttonX+"x"+buttonY);
        }
    }
    private class MouseMotionHandler implements MouseMotionListener{
        @Override
        public void mouseMoved(MouseEvent event){
            if (    (event.getX()>buttonX-gap)&&
                    (event.getX()<(buttonX+buttonWidth+gap))&&
                    (event.getY()>buttonY-gap)&&
                    (event.getY()<(buttonY+buttonHeight+gap))) {
                
                butt.setLocation(ChaseButton(event.getPoint()));
                butt.repaint();
                if(     
                        (butt.getX()>FunWindow.getFrames()[0].getWidth())||
                        (butt.getY()>FunWindow.getFrames()[0].getHeight())||
                        (butt.getX()<0)||
                        (butt.getY()<0)
                        ){
                    butt.setLocation(MoveButton());
                }
                speed.setCoordinate(event.getPoint());
            }else {
                if(     
                        (butt.getX()>FunWindow.getFrames()[0].getWidth())||
                        (butt.getY()>FunWindow.getFrames()[0].getHeight())||
                        (butt.getX()<0)||
                        (butt.getY()<0)
                        ){
                    butt.setLocation(MoveButton());
                }
                speed.setCoordinate(event.getPoint());
                setLabelText("Movement on:"+event.getX()+"x"+event.getY()+ "Speed is :" + speed.getSpeed()+" Butt at "+buttonX+"x"+buttonY);
                
            }
        }
        @Override
        public void mouseDragged(MouseEvent event) {
            if (    (event.getX()>buttonX-gap)&&
                    (event.getX()<(buttonX+buttonWidth+gap))&&
                    (event.getY()>buttonY-gap)&&
                    (event.getY()<(buttonY+buttonHeight+gap))) {
                butt.setLocation(ChaseButton(event.getPoint()));
                speed.setCoordinate(event.getPoint());
            }else {
                speed.setCoordinate(event.getPoint());
                setLabelText("Mouse drag on:"+event.getX()+"x"+event.getY()+" Button on: "+butt.getX()+"x"+ butt.getY()+ "Speed is :" + speed.getSpeed());
            }
        }
    }
    public Point MoveButton() {
        Random r = new Random();
        int newX;
        int newY;
        do {
            newX = r.nextInt(getWidth()- buttonWidth);
        } while ((newX>buttonX-10)&&(newX<buttonWidth+10));
        do {
            newY = r.nextInt(getHeight() - buttonHeight);
        } while ((newY>buttonY-10)&&(newY<buttonHeight+10));
        buttonX = newX;
        buttonY = newY;
        butt.setText("Moved randomly");
        return(new Point(buttonX , buttonY));
    }
    public Point ChaseButton(Point event){
        int velocity=100;
        if((event.getX()>buttonX)&&(event.getX()<buttonX+buttonWidth)&&(event.getY()<buttonY)){
            //to bottom
            butt.setText("Run bottom");
            buttonX = (buttonX); 
            buttonY = (buttonY+buttonHeight+(int)speed.getSpeed()+velocity);
            return (new Point(buttonX , buttonY));
        }
        else if((event.getX()>buttonX)&&(event.getX()<buttonX+buttonWidth)&&(event.getY()>buttonY+buttonHeight)){
            //to top
            butt.setText("Run top");
            buttonX = (buttonX); 
            buttonY = (buttonY-(int)speed.getSpeed()-velocity);
            return (new Point(buttonX , buttonY));
        }
        else if((event.getY()>buttonY)&&(event.getY()<buttonY+buttonHeight)&&(event.getX()<buttonX)){
            //to right
            butt.setText("Run right");
            buttonX = (buttonX+(int)speed.getSpeed()+velocity);
            buttonY = (buttonY);
            return (new Point(buttonX , buttonY));
        }
        else if((event.getY()>buttonY)&&(event.getY()<buttonY+buttonHeight)&&(event.getX()>buttonX+buttonWidth)){
            //to left
            butt.setText("Run left");
            buttonX = (buttonX-(int)speed.getSpeed()-velocity);
            buttonY = (buttonY);
            return (new Point(buttonX , buttonY));
        }
        else if((event.getX()<buttonX)&&(event.getY()<buttonY)){
            //to right & bottom
            butt.setText("Run right bottom");
            buttonX = (buttonX+(int)speed.getSpeed()+velocity);
            buttonY = (buttonY+(int)speed.getSpeed()+velocity);
            return (new Point(buttonX , buttonY));
        }
        else if((event.getX()>buttonX+buttonWidth)&&(event.getY()<buttonY)){
            //to left & bottom
            butt.setText("Run left bottom");
            buttonX = (buttonX-(int)speed.getSpeed()-velocity); 
            buttonY = (buttonY+(int)speed.getSpeed()+velocity);
            return (new Point(buttonX , buttonY));
        }
        else if((event.getX()<buttonX)&&(event.getY()>buttonY+buttonHeight)){
            //to right & top
            butt.setText("Run right top");
            buttonX = (buttonX+(int)speed.getSpeed()+velocity);
            buttonY = (buttonY-(int)speed.getSpeed()-velocity);
            return (new Point(buttonX , buttonY));
        }
        else if((event.getX()>buttonX+buttonWidth)&&(event.getY()>buttonY+buttonHeight)){
            //to left & top
            butt.setText("Run left top");
            buttonX = (buttonX-(int)speed.getSpeed()-velocity);
            buttonY = (buttonY-(int)speed.getSpeed()-velocity);
            return (new Point(buttonX , buttonY));
        }
        else {
            return (new Point(buttonX , buttonY));
        }
    }
    private class ButtonCatch implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            butt.setText("Oooops!!!");
        }
        
    }
}
