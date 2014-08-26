package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ColorButton extends JRadioButton implements ActionListener
{
  Rectangle rect;
  String color;
  public ColorButton(Rectangle rec, String name)
  {
    super(name);
    color=name;
    rect=rec;
    this.addActionListener(this);
    if(rect.color.equals(GeoMath.getColor(color)))
    {
      this.setSelected(true);
    }
  }
  public void actionPerformed(ActionEvent e)
  {
    rect.color=GeoMath.getColor(color);
  }
}