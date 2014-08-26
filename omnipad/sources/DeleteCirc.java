package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class DeleteCirc extends JButton implements ActionListener
{
  Circle circ;
  JFrame frame;
  public DeleteCirc(Circle circle, JFrame fr)
  {
    super("Delete Shape");
    frame=fr;
    circ=circle;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    circ.panel.remove(circ);
    circ.shapes.remove(circ);
    circ.panel.revalidate();
    circ.panel.repaint();
    frame.dispose();
  }
}