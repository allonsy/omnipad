package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TriSaveButton extends JButton implements ActionListener
{
  JTextField x1, x2, x3, y1, y2, y3;
  JFrame frame;
  Triangle tri;
  JPanel panel;
  JTextField name;
  public TriSaveButton(JTextField x1f, JTextField x2f, JTextField x3f, JTextField y1f, JTextField y2f, JTextField y3f, JTextField nam, JFrame fr, Triangle triangle, JPanel pn)
  {
    super("save");
    x1=x1f;
    x2=x2f;
    x3=x3f;
    y1=y1f;
    y2=y2f;
    y3=y3f;
    name=nam;
    frame=fr;
    tri=triangle;
    panel=pn;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    tri.x1=Integer.parseInt(x1.getText());
    tri.x2=Integer.parseInt(x2.getText());
    tri.x3=Integer.parseInt(x3.getText());
    tri.y1=Integer.parseInt(y1.getText());
    tri.y2=Integer.parseInt(y2.getText());
    tri.y3=Integer.parseInt(y3.getText());
    tri.name=name.getText();
    panel.repaint();
    panel.validate();
    frame.dispose();
  }
}