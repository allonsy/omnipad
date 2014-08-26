package GeoProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class RectButton extends JButton implements ActionListener
{
  public JFrame frame;
  public JPanel panel;
  int xpos;
  int ypos;
  int length;
  int height;
  ArrayList<Object> shapes;
  public RectButton(JFrame fr, JPanel pn, ArrayList<Object> sh)
  {
    super("Draw Rectangle");
    panel=pn;
    shapes=sh;
    frame=fr;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
   Rectangle rect=new Rectangle(panel, shapes);
   rect.setBounds(rect.x,rect.y,rect.length,rect.height);
   panel.add(rect);
   shapes.add(rect);
   panel.revalidate();
   panel.repaint();
   //frame.setSize(new Dimension(1000,1000));
  }
}