package GeoProject;
/* Alec Snyder
 * basic triangle object
 * version 1.0.0 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Triangle extends JButton implements ActionListener, Shape, KeyListener, MouseListener
{
  JPanel panel;
  Color color=Color.gray;
    int x1, y1;
    int x2, y2;
    int x3, y3;
    int xbound=0;
    int ybound=0;
    int lenBound=1;
    int heightBound=1;
    String name;
    ArrayList<Object> shapes;
  public Triangle(JPanel pn, ArrayList<Object> sh)
  {
   x1=0;
   y1=0;
   x2=0;
   y2=100;
   x3=100;
   y3=100;
   name="Triangle";
   panel=pn;
   shapes=sh;
   this.addActionListener(this);
   this.addKeyListener(this);
   this.addMouseListener(this);
  }
  public double getArea()
  {
    if(x2==x3)
    {
      double d1=1.0*(Math.abs(x1-x2));
      double d2=GeoMath.getDistance(new Point(x2, y2), new Point(x3, y3));
      return d1*d2*0.5;
    }
    else if(y2==y3)
    {
      double d1=1.0*(Math.abs(y1-y2));
      double d2=GeoMath.getDistance(new Point(x2, y2), new Point(x3, y3));
      return 0.5*d1*d2;
    }
    else
    { 
    double m=((1.0)*(y2-y3))/((1.0)*(x2-x3));
    double m2=m*m;
    double x=((1.0)*(x1)+(1.0*(y1*m))+((1.0)*(m2*x2))-((1.0)*(y2*m)))/((m2+1.0));
    double y=(-x)/m+1.0*x1/m+y1;
    double altitude=Math.sqrt(((x-x1)*(x-x1))+((y-y1)*(y-y1)));
    double base=GeoMath.getDistance(new Point(x2, y2), new Point(x3, y3));
    return (0.5)*(altitude)*(base);
    }
  }
  public double getPerim()
  {
    return GeoMath.getTriPerim(new Point(x1, y1), new Point(x2, y2), new Point (x3, y3));
  }
  public void paintComponent(Graphics g)
  {
    this.detBounds();
    this.setBounds(xbound,ybound, lenBound, heightBound);
    g.setColor(color);
    int[] x={x1-xbound, x2-xbound, x3-xbound};
    int[] y={y1-ybound, y2-ybound, y3-ybound};
    g.fillPolygon(x, y, 3);
    panel.revalidate();
    panel.repaint();
  }
  public void actionPerformed(ActionEvent e)
  {
  }
  public void detBounds()
  {
    ArrayList<Integer> list=new ArrayList<Integer>();
    list.add(y1); list.add(y2); list.add(y3);
    int bigY=y1;
    for(int i=0; i<list.size(); i++)
    {
      if (list.get(i)>bigY)
        bigY=list.get(i);
    }
    int smallY=y1;
    for(int i=0; i<list.size(); i++)
    {
      if(list.get(i)<smallY)
        smallY=list.get(i);
    }
    heightBound=bigY-smallY;
    list.clear();
    list.add(x1); list.add(x2); list.add(x3);
    int bigX=x1;
    for(int i=0; i<list.size(); i++)
    {
      if(list.get(i)>bigX)
        bigX=list.get(i);
    }
    int smallX=x1;
    for(int i=0; i<list.size(); i++)
    {
      if(list.get(i)<smallX)
      {
        smallX=list.get(i);
      }
    }
    lenBound=bigX-smallX;
    xbound=smallX;
    ybound=smallY;
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
      new TriangleEditFrame(this, panel);
    }
  }
  public void keyReleased(KeyEvent e)
  {
  }
  public void keyTyped(KeyEvent e)
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
      new TriangleEditFrame(this,panel);
      //panel.revalidate();
      //panel.repaint();
    }
  }
  public void moveRight()
  {
    x1=x1+25;
    x2=x2+25;
    x3=x3+25;
    panel.revalidate();
    panel.repaint();
  }
  public void moveLeft()
  {
    x1=x1-25;
    x2=x2-25;
    x3=x3-25;
    panel.revalidate();
    panel.repaint();
  }
  public void moveUp()
  {
    y1=y1-25;
    y2=y2-25;
    y3=y3-25;
    panel.revalidate();
    panel.repaint();
  }
  public void moveDown()
  {
    y1=y1+25;
    y2=y2+25;
    y3=y3+25;
    panel.revalidate();
    panel.repaint();
  }
}
/* any other math methods please refer to GeoMath */