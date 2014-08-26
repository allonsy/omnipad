package GeoProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ColorSelect extends JPanel
{
  Rectangle rect;
  public ColorSelect(Rectangle rec)
  {
    rect=rec;
    JFrame frame=new JFrame("select a color");
    frame.setLayout(new GridLayout(5,2));
    ColorButton black=new ColorButton(rect, "black");
    ColorButton blue=new ColorButton(rect, "blue");
    ColorButton yellow=new ColorButton(rect, "yellow");
    ColorButton orange=new ColorButton(rect, "orange");
    ColorButton red=new ColorButton(rect, "red");
    ColorButton green=new ColorButton(rect, "green");
    ColorButton gray=new ColorButton(rect, "gray");
    ColorButton pink=new ColorButton(rect, "pink");
    ButtonGroup group=new ButtonGroup();
    group.add(black);
    group.add(blue);
    group.add(yellow);
    group.add(green);
    group.add(red);
    group.add(gray);
    group.add(pink);
    group.add(orange);
    QuitButton quit=new QuitButton(frame, "close");
    frame.getRootPane().setDefaultButton(quit);
    frame.add(black);
    frame.add(blue);
    frame.add(yellow);
    frame.add(green);
    frame.add(red);
    frame.add(gray);
    frame.add(pink);
    frame.add(orange);
    frame.add(quit);
    frame.pack();
    frame.setSize(new Dimension(500, 300));
    frame.setVisible(true);
  }
}
    