package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TriColorSelect extends JPanel
{
  Triangle tri;
  public TriColorSelect(Triangle triangle)
  {
    tri=triangle;
    JFrame frame=new JFrame("Select a Color");
    frame.setLayout(new GridLayout(5,2));
    TriColorButton black=new TriColorButton(tri, "black");
    TriColorButton blue=new TriColorButton(tri, "blue");
    TriColorButton yellow=new TriColorButton(tri, "yellow");
    TriColorButton orange=new TriColorButton(tri, "orange");
    TriColorButton red=new TriColorButton(tri, "red");
    TriColorButton green=new TriColorButton(tri, "green");
    TriColorButton gray=new TriColorButton(tri, "gray");
    TriColorButton pink=new TriColorButton(tri, "pink");
    ButtonGroup group=new ButtonGroup();
    group.add(black);
    group.add(blue);
    group.add(yellow);
    group.add(orange);
    group.add(green);
    group.add(red);
    group.add(green);
    group.add(gray);
    group.add(pink);
    QuitButton close=new QuitButton(frame, "Close");
    frame.getRootPane().setDefaultButton(close);
    frame.add(black);
    frame.add(blue);
    frame.add(yellow);
    frame.add(pink);
    frame.add(gray);
    frame.add(green);
    frame.add(red);
    frame.add(orange);
    frame.add(close);
    frame.pack();
    frame.setSize(new Dimension(500,300));
    frame.setVisible(true);
  }
}