package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TriColorButton extends JRadioButton implements ActionListener
{
  Triangle tri;
  String color;
  public TriColorButton(Triangle triangle, String col)
  {
    super(col);
    tri=triangle;
    color=col;
    this.addActionListener(this);
    if(tri.color.equals(GeoMath.getColor(color)))
    {
      this.setSelected(true);
    }
  }
  public void actionPerformed(ActionEvent e)
  {
    tri.color=GeoMath.getColor(color);
  }
}