import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class will be the viewer of ConvertNumbers JPanel.
 * @author Ömer Onat Postacý  @date 14.11.2019
*/
public class ConverNumbersViewer {
  public static void main ( String[] args ) {
   JFrame frame = new JFrame();
   frame.setSize( 400, 400 );
   JPanel panel = new ConvertNumbers();
   frame.add( panel );
   frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   frame.setTitle( "Convert Numbers" );
   frame.setResizable( true );
   frame.setLocation( 50, 50 );
   frame.setVisible( true );
    
  
    
    
  }
}