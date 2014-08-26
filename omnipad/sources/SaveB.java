package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.filechooser.*;
import java.io.File;
public class SaveB extends JButton implements ActionListener
{
  ArrayList<Object> shapes;
  public SaveB(ArrayList<Object> sh)
  {
    super("Save Configuration");
    shapes=sh;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    final JFileChooser fc=new JFileChooser("GeoProject");
    int returnval=fc.showSaveDialog(this);
    if(returnval==JFileChooser.APPROVE_OPTION)
    {
      File file=fc.getSelectedFile();
      EasyWriter writer=new EasyWriter(file.getPath());
      if(shapes.size()==0)
      {
        writer.print("end ");
        writer.close();
        return;
      }
      else
      {
        for(int i=0; i<shapes.size(); i++)
        {
          if(shapes.get(i) instanceof Rectangle)
          {
            Rectangle rect=(Rectangle)(shapes.get(i));
            writer.print("R ");
            writer.print(rect.x+" "+rect.y+" "+rect.length+" "+rect.height+" "+GeoMath.getColString(rect.color)+" ");
          }
          else if(shapes.get(i) instanceof Circle)
          {
            Circle circ=(Circle)(shapes.get(i));
            writer.print("C "+circ.x+" "+circ.y+" "+circ.radius+" "+GeoMath.getColString(circ.color)+" ");
          }
          else
          {
            Triangle tri=(Triangle)(shapes.get(i));
            writer.print("T "+tri.x1+" "+tri.y1+" "+tri.x2+" "+tri.y2+" "+tri.x3+" "+tri.y3+" "+GeoMath.getColString(tri.color)+" ");
          }
        }
        writer.print("end ");
        writer.close();
      }
    }
  }
}
