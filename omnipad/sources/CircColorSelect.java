package GeoProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CircColorSelect extends JPanel
{
  Circle circ;
  public CircColorSelect(Circle cir)
  {
    circ=cir;
    JFrame frame=new JFrame("select a color");
    frame.setLayout(new GridLayout(5,2));
    CircColorButton black=new CircColorButton(circ, "black");
    CircColorButton blue=new CircColorButton(circ, "blue");
    CircColorButton yellow=new CircColorButton(circ, "yellow");
    CircColorButton orange=new CircColorButton(circ, "orange");
    CircColorButton red=new CircColorButton(circ, "red");
    CircColorButton green=new CircColorButton(circ, "green");
    CircColorButton gray=new CircColorButton(circ, "gray");
    CircColorButton pink=new CircColorButton(circ, "pink");
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