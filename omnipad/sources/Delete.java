package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Delete extends JButton implements ActionListener
{
  Rectangle rect;
  JFrame frame;
  public Delete(Rectangle rec, JFrame fr)
  {
    super("Delete Shape");
    frame=fr;
    rect=rec;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    rect.panel.remove(rect);
    rect.shapes.remove(rect);
    rect.panel.revalidate();
    rect.panel.repaint();
    frame.dispose();
  }
}