package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class EditFrame extends JFrame
{
  JFrame frame;
  public EditFrame(Rectangle obj, JPanel panel)
  {
    super("Rectangle Edit Frame");
    frame=new JFrame("Edit "+obj.name);
    frame.setMinimumSize(new Dimension(300,300));
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    QuitButton cancel=new QuitButton(frame, "Cancel");
    JTextField xpos=new JTextField(20);
    xpos.setText(""+obj.x);
    JTextField ypos=new JTextField(20);
    ypos.setText(""+obj.y);
    JTextField len=new JTextField(20);
    len.setText(""+obj.length);
    JTextField name=new JTextField(20);
    name.setText(obj.name);
    JTextField height= new JTextField(20);
    height.setText(""+obj.height);
    ColorB colorB=new ColorB(obj);
    JLabel label=new JLabel("TestEditFrame");
    JLabel newx=new JLabel("New x-pos: ");
    JLabel newy=new JLabel("New y-pos: ");
    JLabel newLen=new JLabel("New Length (px):");
    JLabel newHeight=new JLabel("New Height (px): ");
    JLabel area=new JLabel("Area (px): ");
    JLabel areaAns=new JLabel(""+obj.getArea());
    JLabel perim=new JLabel("Perimeter (px): ");
    JLabel perimAns=new JLabel(""+obj.getPerim());
    JLabel nameAns=new JLabel("New Name: ");
    SaveButton save=new SaveButton(xpos, ypos, len, height, name, obj, frame, panel);
    frame.getRootPane().setDefaultButton(save);
    Delete delete=new Delete(obj, frame);
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(9,2));
    //frame.add(label);
    frame.add(area);
    frame.add(areaAns);
    frame.add(perim);
    frame.add(perimAns);
    frame.add(nameAns);
    frame.add(name);
    frame.add(newx);
    frame.add(xpos);
    frame.add(newy);
    frame.add(ypos);
    frame.add(newLen);
    frame.add(len);
    frame.add(newHeight);
    frame.add(height);
    frame.add(save);
    frame.add(colorB);
    frame.add(delete);
    frame.add(cancel);
    frame.pack();
    frame.setSize(new Dimension(300,300));
    frame.setVisible(true);
  }
}