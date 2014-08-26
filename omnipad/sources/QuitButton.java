package GeoProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuitButton extends JButton implements ActionListener
{
  public JFrame frame;
  public QuitButton(JFrame fr, String name)
  {
    super(name);
    frame=fr;
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    frame.dispose();
  }
}