package GeoProject;
/* Alec Snyder
 * a list of all the shapes, contains references to all of the shapes in the main content pane
 * version 1.0.0 */
import java.util.ArrayList;
public class ContainerShapes
{
  public ArrayList<Shape> container;
  public ContainerShapes()
  {
    container=new ArrayList<Shape>();
  }
  public ContainerShapes(ArrayList<Shape> shapes)
  {
    container=shapes;
  }
}

  