package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class ClearButton extends JButton implements ActionListener
{
  JPanel panel;
  ArrayList<Object> shapes;
  public ClearButton(JPanel pn, ArrayList<Object> sh)
  {
    super("Clear");
    panel=pn;
    shapes=sh;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    panel.removeAll();
    shapes.clear();
    panel.revalidate();
    panel.repaint();
  }
}