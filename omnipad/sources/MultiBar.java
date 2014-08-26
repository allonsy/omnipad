package GeoProject;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MultiBar extends JTextField implements ActionListener
{
  JLabel result;
  public MultiBar(int i,JLabel res)
  {
    super(i);
    result=res;
  }
  public void actionPerformed(ActionEvent e)
  {
    String expression=this.getText();
    double answer=GeoMath.multiCalc(expression);
    String ans=""+answer;
    result.setText(ans);
  }
}