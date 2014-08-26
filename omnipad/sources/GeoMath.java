package GeoProject;
/* Alec Snyder
 * ATCS GeoProject
 * This is the math engine of the program, given any shape and its "primary points, the area for certain shapes can be calcultated
 * this version also includes the method for the multiBar at the top of the screen.
 * version 1.0.0 */
import java.awt.*;
import java.util.ArrayList;
public class GeoMath
{
  public static double getTriArea(Point a, Point b, Point c, String type) //type can be either right or equilateral
  {
    if(type.equals("equilateral"))
    {
      return ((GeoMath.getDistance(a, b)*GeoMath.getDistance(a,b))*(Math.sqrt(3)))/4.0;
    }
    else
    {
      double d1=GeoMath.getDistance(a,b);
      double d2=GeoMath.getDistance(b,c);
      double d3=GeoMath.getDistance(c,a);
      if(d1>d2&&d1>d3)
      {
        return 0.5*d2*d3;
      }
      else if(d2>d1&&d2>d3)
      {
        return 0.5*d1*d3;
      }
      else
      {
        return 0.5*d1*d2;
      }
    }   
  } 
  public static double getTriPerim(Point a, Point b, Point c)
  {
    double d1=GeoMath.getDistance(a,b);
    double d2=GeoMath.getDistance(b,c);
    double d3=GeoMath.getDistance(c,a);
    return d1+d2+d3;
  }
  
  
  public static double getRectArea(Point a, Point b, Point c) //any three vertices of the rectangle
  {
    return GeoMath.getDistance(a,b)*GeoMath.getDistance(b,c);
  }
  public static double getRectPerim(Point a, Point b, Point c, Point d)
  {
    double d1=GeoMath.getDistance(a,b);
    double d2=GeoMath.getDistance(b,c);
    double d3=GeoMath.getDistance(c,d);
    double d4=GeoMath.getDistance(d,a);
    return d1+d2+d3+d4;
  }
  public static double getCircleArea(Point a, Point b) //a is center, b is on the circle
  {
    double radius=GeoMath.getDistance(a,b);
    return Math.PI*radius*radius;
  }
  public static double getCircleCircum(Point a, Point b)
  {
    double radius=GeoMath.getDistance(a,b);
    return 2.0*radius*Math.PI;
  }
    
  public static double calc(String message) //translates multiBar into expression and then decodes it. ex. 1+2 or 1 + 2.
  {
    ArrayList<Character> listMessage=new ArrayList<Character>();
    for(int i=0; i<message.length(); i++)
    {
      listMessage.add(message.charAt(i));
    }
    int i=0;
    while(i<listMessage.size())
    {
      if(listMessage.get(i).equals(new Character(' ')))
      {
        listMessage.remove(i);
      }
      else i++;
    }
    //System.out.println(listMessage);
    char operator='+';
    int operPos=0;
    for(i=0; i<listMessage.size(); i++)
    {
      if((listMessage.get(i).equals('+')||listMessage.get(i).equals('-')||listMessage.get(i).equals('*')||listMessage.get(i).equals('/'))&&i!=0)
      {
        operator=listMessage.get(i).charValue();
        operPos=i;
        break;
      }
    }
    //System.out.println(""+operator+operPos);
    String part1="";
    for(i=0; i<operPos; i++)
    {
      part1=""+part1+listMessage.get(i);
    }
    //System.out.println(part1);
    String part2="";
    for(i=operPos+1; i<listMessage.size(); i++)
    {
      part2=""+part2+listMessage.get(i);
    }
    //System.out.println(part2);
    double d1=Double.parseDouble(part1);
    double d2=Double.parseDouble(part2);
    if(operator=='+')
      return d1+d2+0.0;
    else if(operator=='-')
      return (d1-d2)+0.0;
    else if(operator=='*')
      return (d1*d2)+0.0;
    else
      return (d1/d2)+0.0;
  }
  public static double getDistance(Point a, Point b)
  {
    return Math.sqrt(((a.getX()-b.getX())*(a.getX()-b.getX()))+((a.getY()-b.getY())*(a.getY()-b.getY())));
  }
  public static Color getColor(String col)
  {
    Color color;
    if(col.equals("red"))
      color=Color.red;
    else if(col.equals("green"))
      color=Color.green;
    else if(col.equals("black"))
      color=Color.black;
    else if(col.equals("blue"))
      color=Color.blue;
    else if(col.equals("gray"))
      color=Color.gray;
    else if(col.equals("orange"))
      color=Color.orange;
    else if(col.equals("pink"))
      color=Color.pink;
    else
      color=Color.yellow;
    return color;
  }
  public static String getColString(Color color)
  {
    if(color.equals(Color.red))
      return "red";
    else if(color.equals(Color.gray))
      return "gray";
    else if(color.equals(Color.black))
      return "black";
    else if(color.equals(Color.pink))
      return "pink";
    else if(color.equals(Color.green))
      return "green";
    else if(color.equals(Color.blue))
      return "blue";
    else if(color.equals(Color.orange))
      return "orange";
    else
      return "yellow";
  }
    
  public static double multiCalc(String message)
  {
    int operCount=0;
    int i;
    ArrayList<Integer> operPos=new ArrayList<Integer>();
    for(i=0; i<message.length(); i++)
    {
      if(message.charAt(i)=='+'||message.charAt(i)=='-'||message.charAt(i)=='*'||message.charAt(i)=='/')
      {
        if(i!=0){
        operCount++;
        operPos.add(i);}
      }
    }
    if(operCount==1)
    {
      return GeoMath.calc(message);
    }
    double ans=GeoMath.calc(message.substring(0,operPos.get(1)));
    String mes=""+ans;
    boolean last=false;
    for(i=1; i<operPos.size(); i++)
    {
      if(i==operPos.size()-1)
      {
        operPos.add(message.length());
        last=true;
      }
      mes=""+ans;
      ans=GeoMath.calc(""+mes+""+message.substring(operPos.get(i), operPos.get(i+1)));
      if(last)
        break;
    }
    return ans;
  }
}