package GeoProject;
/* Alec Snyder
 * basic circle object
 * version 1.0.0 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class Circle extends JButton implements Shape, ActionListener, KeyListener, MouseListener
{
  int x;
  int y;
  int radius;
  JPanel panel;
  String name;
  Color color=Color.green;
  ArrayList<Object> shapes;
  
  public Circle(JPanel pn, ArrayList<Object> sh)
  {
    x=100;
    y=100;
    radius=100;
    panel=pn;
    name="Circle";
    shapes=sh;
    this.addActionListener(this);
    this.addKeyListener(this);
    this.addMouseListener(this);
  }
  public double getArea()
  {
    return (radius*radius)*Math.PI;
  }
  public double getPerim()
  {
    return 2*Math.PI*radius;
  }
  public void paintComponent(Graphics g)
  {
    this.setBounds(x-radius,y-radius,2*radius,2*radius);
    g.setColor(color);
    g.fillOval(0,0, 2*radius, 2*radius);
    panel.revalidate();
    panel.repaint();
  }
  public void actionPerformed(ActionEvent e)
  {
  }
  public void moveUp()
  {
    y=y-25;
    panel.revalidate();
    panel.repaint();
  }
  public void moveDown()
  {
    y=y+25;
    panel.revalidate();
    panel.repaint();
  }
  public void moveRight()
  {
    x=x+25;
    panel.revalidate();
    panel.repaint();
  }
  public void moveLeft()
  {
    x=x-25;
    panel.revalidate();
    panel.repaint();
  } 
  public void mousePressed(MouseEvent e)
  {
  }
  public void mouseReleased(MouseEvent e)
  {
  }
  public void mouseExited(MouseEvent e)
  {
    //panel.revalidate();
    //panel.repaint();
  }
  public void mouseEntered(MouseEvent e)
  {
    //panel.revalidate();
    //panel.repaint();
  }
  public void mouseClicked(MouseEvent e)
  {
    if(SwingUtilities.isRightMouseButton(e))
    {
      new CircleEditFrame(this,panel);
      //panel.revalidate();
      //panel.repaint();
    }
  }
  public void keyPressed(KeyEvent e)
  {
    int key=e.getKeyCode();
    if(key==KeyEvent.VK_LEFT)
    {
      this.moveLeft();
    }
    else if(key==KeyEvent.VK_RIGHT)
    {
      this.moveRight();
    }
    else if(key==KeyEvent.VK_UP)
    {
      this.moveUp();
    }
    else if(key==KeyEvent.VK_DOWN)
    {
      this.moveDown();
    }
    else if(key==KeyEvent.VK_BACK_SPACE)
    {
      panel.remove(this);
      shapes.remove(this);
      panel.revalidate();
      panel.repaint();
    }
    else if(key==KeyEvent.VK_SPACE)
    {
      new CircleEditFrame(this, panel);
    }
  }
  public void keyReleased(KeyEvent e)
  {
  }
  public void keyTyped(KeyEvent e)
  {
  }
}
/* any needed calc methods can be found in GeoMath class */