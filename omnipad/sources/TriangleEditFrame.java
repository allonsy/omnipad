package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TriangleEditFrame extends JFrame
{
  JFrame frame;
  public TriangleEditFrame(Triangle tri, JPanel panel)
  {
    frame=new JFrame("Edit "+tri.name);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    QuitButton cancel=new QuitButton(frame,"Cancel");
    JTextField x1=new JTextField(20);
    x1.setText(""+tri.x1);
    JTextField x2=new JTextField(20);
    x2.setText(""+tri.x2);
    JTextField x3=new JTextField(20);
    x3.setText(""+tri.x3);
    JTextField y1=new JTextField(20);
    y1.setText(""+tri.y1);
    JTextField y2=new JTextField(20);
    y2.setText(""+tri.y2);
    JTextField y3=new JTextField(20);
    y3.setText(""+tri.y3);
    JTextField name=new JTextField(20);
    name.setText(tri.name);
    TriSaveButton save=new TriSaveButton(x1, x2, x3,y1, y2, y3, name, frame, tri, panel);
    frame.getRootPane().setDefaultButton(save);
    JLabel area=new JLabel("Area (px):");
    JLabel areaAns=new JLabel(""+tri.getArea());
    JLabel perim=new JLabel("Perimeter (px):");
    JLabel perimAns=new JLabel(""+tri.getPerim());
    JLabel x1label=new JLabel("new vertex1 (x): ");
    JLabel y1label=new JLabel("new vertex1 (y): ");
    JLabel x2label=new JLabel("new vertex2 (x): ");
    JLabel y2label=new JLabel("new vertex2 (y): ");
    JLabel x3label=new JLabel("new vertex3 (x): ");
    JLabel y3label=new JLabel("new vertex3 (y): ");
    JLabel nameAns=new JLabel("new name: ");
    TriColorB colorB=new TriColorB(tri);
    DeleteTri delete=new DeleteTri(tri, frame);
    frame.setLayout(new GridLayout(11,2));
    frame.add(area);
    frame.add(areaAns);
    frame.add(perim);
    frame.add(perimAns);
    frame.add(nameAns);
    frame.add(name);
    frame.add(x1label);
    frame.add(x1);
    frame.add(y1label);
    frame.add(y1);
    frame.add(x2label);
    frame.add(x2);
    frame.add(y2label);
    frame.add(y2);
    frame.add(x3label);
    frame.add(x3);
    frame.add(y3label);
    frame.add(y3);
    frame.add(save);
    frame.add(colorB);
    frame.add(delete);
    frame.add(cancel);
    frame.pack();
    frame.setSize(new Dimension(500,500));
    frame.setVisible(true);
  }
}
    
    