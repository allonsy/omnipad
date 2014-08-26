package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class CircleButton extends JButton implements ActionListener
{
  JFrame frame;
  JPanel panel;
  ArrayList<Object> shapes;
  public CircleButton(JFrame fr, JPanel pn, ArrayList<Object> sh)
  {
    super("Draw Circle");
    frame=fr;
    panel=pn;
    shapes=sh;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    Circle circ=new Circle(panel, shapes);
    circ.setBounds(circ.x-circ.radius,circ.y-circ.radius,2*circ.radius,2*circ.radius);
    panel.add(circ);
    shapes.add(circ);
    panel.revalidate();
    panel.repaint();
    //frame.setSize(new Dimension(1000,1000));
  }
}