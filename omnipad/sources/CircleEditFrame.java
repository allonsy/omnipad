package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CircleEditFrame extends JFrame
{
  JFrame frame;
  public CircleEditFrame(Circle circ, JPanel panel)
  {
    frame=new JFrame("Edit "+circ.name);
    frame.setMinimumSize(new Dimension(300,300));
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    QuitButton cancel=new QuitButton(frame, "Cancel");
    JTextField xpos=new JTextField(20);
    xpos.setText(""+circ.x);
    JTextField ypos=new JTextField(20);
    ypos.setText(""+circ.y);
    JTextField rad=new JTextField(20);
    rad.setText(""+circ.radius);
    JTextField name=new JTextField(20);
    name.setText(circ.name);
    JLabel label=new JLabel("TestEditFrame");
    JLabel newx=new JLabel("new center (x):");
    JLabel newy=new JLabel("New center (y):");
    JLabel newRad=new JLabel("New radius (px):");
    JLabel area=new JLabel("Area (px): ");
    JLabel areaAns=new JLabel(""+circ.getArea());
    JLabel perim=new JLabel("Circumference (px): ");
    JLabel perimAns=new JLabel(""+circ.getPerim());
    JLabel nameAns=new JLabel("New name: ");
    CircColorB circColorB=new CircColorB(circ);
    SaveCircButton save=new SaveCircButton(xpos, ypos, rad, name, circ, frame, panel);
    frame.getRootPane().setDefaultButton(save);
    DeleteCirc delete=new DeleteCirc(circ, frame);
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(8,2));
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
    frame.add(newRad);
    frame.add(rad);
    frame.add(save);
    frame.add(circColorB);
    frame.add(delete);
    frame.add(cancel);
    frame.pack();
    frame.setSize(new Dimension(300,300));
    frame.setVisible(true);
  }
}