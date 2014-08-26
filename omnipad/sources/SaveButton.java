package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class SaveButton extends JButton implements ActionListener
{
  JTextField xpos;
  JTextField ypos;
  JTextField length;
  JTextField height;
  JTextField name;
  Rectangle rect;
  JPanel panel;
  JFrame frame;
  public SaveButton(JTextField x, JTextField y, JTextField len, JTextField wid, JTextField nam, Rectangle rec, JFrame fr, JPanel pn)
  {
    super("Save");
    xpos=x;
    ypos=y;
    height=wid;
    rect=rec;
    length=len;
    frame=fr;
    panel=pn;
    name=nam;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    rect.x=Integer.parseInt(xpos.getText());
    rect.y=Integer.parseInt(ypos.getText());
    rect.length=Integer.parseInt(length.getText());
    rect.height=Integer.parseInt(height.getText());
    rect.name=name.getText();
    panel.revalidate();
    panel.repaint();
    frame.dispose();
  }
}