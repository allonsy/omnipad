package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class SaveCircButton extends JButton implements ActionListener
{
  JTextField xpos;
  JTextField ypos;
  JTextField radius;
  Circle circ;
  JFrame frame;
  JPanel panel;
  JTextField name;
  public SaveCircButton(JTextField x, JTextField y, JTextField rad, JTextField nam, Circle circle, JFrame fr, JPanel pn)
  {
    super("Save");
    xpos=x;
    ypos=y;
    radius=rad;
    circ=circle;
    frame=fr;
    panel=pn;
    name=nam;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    circ.x=Integer.parseInt(xpos.getText());
    circ.y=Integer.parseInt(ypos.getText());
    circ.radius=Integer.parseInt(radius.getText());
    circ.name=name.getText();
    panel.revalidate();
    panel.repaint();
    frame.dispose();
  }
}