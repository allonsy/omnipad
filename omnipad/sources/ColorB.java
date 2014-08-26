package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ColorB extends JButton implements ActionListener
{
  Rectangle rect;
  public ColorB(Rectangle rec)
  {
    super("Change Color");
    rect=rec;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    new ColorSelect(rect);
  }
}