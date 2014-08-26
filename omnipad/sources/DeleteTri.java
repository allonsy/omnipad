package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class DeleteTri extends JButton implements ActionListener
{
  Triangle tri;
  JFrame frame;
  public DeleteTri(Triangle triangle, JFrame fr)
  {
    super("Delete Shape");
    tri=triangle;
    frame=fr;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    tri.panel.remove(tri);
    tri.shapes.remove(tri);
    tri.panel.revalidate();
    tri.panel.repaint();
    frame.dispose();
  }
}