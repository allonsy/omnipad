package GeoProject;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Quit extends Frame {
 
     public static void main (String[] args) {
        new Quit();
     }
     
     public Quit() {
        setTitle ("Quit Button");
        // default layout manager for "Frame" is "BorderLayout"
  
        Button q = new Button ("Quit");
  
        class QuitButtonListener implements ActionListener {
           public void actionPerformed (ActionEvent e) { close(); }
        }
        q.addActionListener (new QuitButtonListener ());
        add ("Center", q);
  
        class WindowClosingListener extends WindowAdapter {
           public void windowClosing (WindowEvent evt) { close(); }
        }
        addWindowListener (new WindowClosingListener ());
        setSize (1000, 500);
        setVisible (true);
     }
  
     void close () {
        setVisible (false);
        dispose();
        System.exit(0);
     }
 }