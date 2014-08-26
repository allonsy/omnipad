package GeoProject;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/*
 * Alec Snyder
 * ATCS Geometry project
 * a large pad where you can create and manipulate shapes
 * Main class of GeoProject package
 * version 2.5.0 */
public class OverFrame extends JFrame
{
  
  JFrame frame=new JFrame("OmniPad For Geometry");
  JButton button=new QuitButton(frame,"quit");
  public OverFrame()
  {
    frame.setSize(new Dimension(1000,1000));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true);
    frame.setLayout(new BorderLayout());
    JLabel label1=new JLabel("                                                                Multi Bar: ");
    JLabel label2=new JLabel("                                                                   Answer: ");
    JPanel drawPanel=new JPanel();
    drawPanel.setLayout(null);
    drawPanel.setFocusable(true);
    ArrayList<Object> shapes=new ArrayList<Object>();
    SaveB save=new SaveB(shapes);
    RectButton rectB=new RectButton(frame, drawPanel,shapes);
    JPanel panel=new JPanel();
    JPanel multiBar=new JPanel();
    CircleButton circB=new CircleButton(frame, drawPanel, shapes);
    Border blackline = BorderFactory.createLineBorder(Color.black);
    multiBar.setBorder(blackline);
    JLabel answer=new JLabel("answer field ");
    MultiBar bar=new MultiBar(20, answer);
    ClearButton clear=new ClearButton(drawPanel, shapes);
    TriangleButton triB=new TriangleButton(frame, drawPanel, shapes);
    Restore restore=new Restore(drawPanel, shapes);
    clear.addActionListener(clear);
    bar.addActionListener(bar);
    panel.setBackground(Color.WHITE);
    panel.setLayout(new GridLayout(4,1));
    multiBar.setLayout(new GridLayout(3,3));
    panel.add(rectB);
    panel.add(circB);
    panel.add(triB);
    panel.add(clear);
    multiBar.add(save);
    multiBar.add(restore);
    multiBar.add(button);
    multiBar.add(label1);
    multiBar.add(bar);
    JLabel trash1=new JLabel(); JLabel trash2=new JLabel();
    multiBar.add(trash1);
    multiBar.add(label2);
    multiBar.add(answer);
    multiBar.add(trash2);
    frame.add(multiBar, BorderLayout.NORTH);
    frame.add(panel, BorderLayout.WEST);
    frame.add(drawPanel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
    frame.setSize(new Dimension(1200,760));
  }
  public static void main(String[] args)
  {
    new OverFrame();
  }
}
