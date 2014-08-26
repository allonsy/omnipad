package GeoProject;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.filechooser.*;
import java.io.File;
public class Restore extends JButton implements ActionListener
{
  JPanel panel;
  ArrayList<Object> shapes;
  public Restore(JPanel pn, ArrayList<Object> sh)
  {
    super("Open Configuration");
    panel=pn;
    shapes=sh;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    final JFileChooser fc=new JFileChooser("GeoProject");
    int returnval=fc.showOpenDialog(panel);
    if(returnval==JFileChooser.APPROVE_OPTION)
    {
      File file=fc.getSelectedFile();
      EasyReader reader=new EasyReader(file.getPath());
      panel.removeAll();
      shapes.clear();
      for(String word=reader.readWord(); !(word.equals("end")); word=reader.readWord())
      {
        if(word.equals("R"))
        {
          int x=Integer.parseInt(reader.readWord());
          int y=Integer.parseInt(reader.readWord());
          int len=Integer.parseInt(reader.readWord());
          int height=Integer.parseInt(reader.readWord());
          Color color=GeoMath.getColor(reader.readWord());
          Rectangle rect=new Rectangle(panel, shapes);
          rect.x=x;
          rect.y=y;
          rect.length=len;
          rect.height=height;
          rect.color=color;
          rect.setBounds(rect.x, rect.y, rect.length, rect.height);
          panel.add(rect);
          shapes.add(rect);
        }
        else if(word.equals("C"))
        {
          int x=Integer.parseInt(reader.readWord());
          int y=Integer.parseInt(reader.readWord());
          int rad=Integer.parseInt(reader.readWord());
          Color color=GeoMath.getColor(reader.readWord());
          Circle circ=new Circle(panel, shapes);
          circ.x=x;
          circ.y=y;
          circ.radius=rad;
          circ.color=color;
          circ.setBounds(circ.x-circ.radius,circ.y-circ.radius,2*circ.radius,2*circ.radius);
          panel.add(circ);
          shapes.add(circ);
        }
        else
        {
          int x1=Integer.parseInt(reader.readWord());
          int y1=Integer.parseInt(reader.readWord());
          int x2=Integer.parseInt(reader.readWord());
          int y2=Integer.parseInt(reader.readWord());
          int x3=Integer.parseInt(reader.readWord());
          int y3=Integer.parseInt(reader.readWord());
          Color color=GeoMath.getColor(reader.readWord());
          Triangle tri=new Triangle(panel, shapes);
          tri.x1=x1;
          tri.x2=x2;
          tri.x3=x3;
          tri.y1=y1;
          tri.y2=y2;
          tri.y3=y3;
          tri.color=color;
          tri.detBounds();
          tri.setBounds(tri.xbound, tri.ybound, tri.lenBound, tri.heightBound);
          panel.add(tri);
          shapes.add(tri);
        }
      }
      reader.close();
      panel.revalidate();
      panel.repaint();
    }
  }
}

