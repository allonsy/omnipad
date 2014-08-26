package GeoProject;
/* Alec Snyder
 * basic Rectanlge object
 * version 1.0.0 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Rectangle extends JButton implements Shape, ActionListener, MouseListener, KeyListener
{            
  public int x;
  public int y;
  public int length;
  public int height;
  JPanel panel;
  String name;
  ArrayList<Object> shapes;
  Color color=Color.red;
  public Rectangle(JPanel pn, ArrayList<Object> sh)
  {
    x=0;
    y=0;
    length=100;
    height=100;
    panel=pn;
    shapes=sh;
    name="Rectangle";
    this.addActionListener(this);
    this.addMouseListener(this);
    this.addKeyListener(this);
  }
  public double getArea()
  {
    return length*height;
  }
  public double getPerim()
  {
    return (2*length)+(2*height);
  }
  public double getLength()
  {
    return length;
  }
  public double getRectWidth()
  {
    return height;
  }
  public void paintComponent(Graphics g)
  {
    this.setBounds(x,y,length, height);
    //Graphics2D g2=(Graphics2D) g;
    g.setColor(color);
    g.fillRect(0,0,length,height);
  }
  public void actionPerformed(ActionEvent e)
  {
  }
  public void mousePressed(MouseEvent e)
  {
  }
  public void mouseReleased(MouseEvent e)
  {
  }
  public void mouseExited(MouseEvent e)
  {
    panel.revalidate();
    panel.repaint();
  }
  public void mouseEntered(MouseEvent e)
  {
    panel.revalidate();
    panel.repaint();
  }
  public void mouseClicked(MouseEvent e)
  {
    if(SwingUtilities.isRightMouseButton(e))
    {
      new EditFrame(this,panel);
      panel.revalidate();
      panel.repaint();
    }
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
      new EditFrame(this, panel);
    }
  }
  public void keyReleased(KeyEvent e)
  {
  }
  public void keyTyped(KeyEvent e)
  {
  }
}
/* any math methods for rectangle please see GeoMath class */