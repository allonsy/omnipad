package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class TriangleButton extends JButton implements ActionListener
{
  JFrame frame;
  ArrayList<Object> shapes;
  JPanel panel;
  public TriangleButton(JFrame fr, JPanel pn, ArrayList<Object> sh)
  {
    super("Draw Triangle");
    frame=fr;
    shapes=sh;
    panel=pn;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    Triangle tri=new Triangle(panel, shapes);
    tri.detBounds();
    tri.setBounds(tri.xbound, tri.ybound, tri.lenBound, tri.heightBound);
    panel.add(tri);
    shapes.add(tri);
    panel.revalidate();
    panel.repaint();
    //frame.setSize(new Dimension(1000,1000));
  }
}
  
    