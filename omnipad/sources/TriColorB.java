package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TriColorB extends JButton implements ActionListener
{
  Triangle tri;
  public TriColorB(Triangle triangle)
  {
    super("Change Color");
    tri=triangle;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    new TriColorSelect(tri);
  }
}