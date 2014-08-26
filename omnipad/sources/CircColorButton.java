package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CircColorButton extends JRadioButton implements ActionListener
{
  Circle circ;
  String color;
  public CircColorButton(Circle cir, String name)
  {
    super(name);
    color=name;
    circ=cir;
    this.addActionListener(this);
    if(circ.color.equals(GeoMath.getColor(color)))
    {
      this.setSelected(true);
    }
  }
  public void actionPerformed(ActionEvent e)
  {
    circ.color=GeoMath.getColor(color);
  }
}