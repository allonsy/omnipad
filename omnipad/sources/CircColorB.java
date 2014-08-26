package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CircColorB extends JButton implements ActionListener
{
  Circle circ;
  public CircColorB(Circle cir)
  {
    super("Change Color");
    circ=cir;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    new CircColorSelect(circ);
  }
}