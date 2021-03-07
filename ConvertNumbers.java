import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * This class will extend JPanel class.
 * Arranges the properties of GUI of the program.
 * @author Ömer Onat Postacý  @date 14.11.2019
*/
public class ConvertNumbers extends JPanel {
  
  
  //properties
  
  //labels
  private JLabel decimal;
  private JLabel binary;
  private JLabel hex;
  
  //textFields
  private JTextField numField;
  private JTextField binField;
  private JTextField hexField;
  
  //panels
  private JPanel stringPanel;
  private JPanel intPanel;
  
  //int value
  private int num;
  
  //constructor
  
   /**
    * constructor
   * Initilializes the JTextFields.
   * Initilializes the JPanels.
   * Arranges the layouts.
   * Initilializes count propertie.
   */
  public ConvertNumbers(){
    
    //panel initilisation
    stringPanel = new JPanel( new GridLayout( 3,1 ) );
    intPanel = new JPanel( new GridLayout( 3, 1 ) );
    
    //adding panels
    add( stringPanel, BorderLayout.WEST);
    add( intPanel, BorderLayout.CENTER);
    
    //textField initilisation
    numField = new JTextField( 15 );
    binField = new JTextField( 15 );
    hexField = new JTextField( 15 );
    
    //label initilisation
    decimal = new JLabel( "Decimal: " );
    hex = new JLabel( "Hex: " );
    binary = new JLabel( "Binary: " );
    
    //adding 
    stringPanel.add( decimal );
    stringPanel.add( numField );
    
    stringPanel.add( hex );
    stringPanel.add( hexField );
    
    stringPanel.add( binary );
    stringPanel.add( binField );
    
    //int init
    num = 0;
    
    //keyListener init
    KeyListener listener = new EnterListener();
    numField.addKeyListener(listener);
    binField.addKeyListener(listener);
    hexField.addKeyListener(listener);
    
    
  }
  
  //methods
  
  /**
   * Returns a binary or hexadecimal conversion of a decimal number.
   * @param  str the string from JTextFields
   * @param  conv The base of the decimals.
   * @return the converged version of binary or hexadecimal number.
   */
  public String fromDecimal( String str , int conv ) {
    String s = "";
    String last = "";
    int num = 0;
    int value = Integer.parseInt( str );
    while( value > 0 ){
      num = value % conv;
      value = value / conv;
      if( num == 10 ){
        s = s + 'A';
      }
      else if( num == 11 ){
        s = s + 'B';
      }
      else if( num == 12 ){
        s = s + 'C';
      }
      else if( num == 13 ){
        s = s + 'D';
      }
      else if( num == 14 ){
        s = s + 'E';
      }
      else if( num == 15 ){
        s = s + 'F';
      }
      else{
        s = s + num;
      }
    }
    for( int i = s.length() - 1 ; i >= 0; i-- ){
      last = last + s.charAt( i );  
    } 
    
    return last;
  }
  
  
   /**
   * Returns a decimal representation of binary or hexadecimal number.
   * @param  str the string from JTextFields
   * @param  base The base of the decimals.
   * @return the converged version of decimal number.
   */
  public String toDecimal( String str, int base ) {
    int value = 0;
    String test = "0123456789ABCDEF";
    
    for (int i = 0; i < str.length(); i++) {
      
     
      value = value + (int) Math.pow( base , i ) * test.indexOf(str.charAt(str.length() -i -1));
    }
    
    return value + "";
    
    
  }
  
  
  /**
   * This class will implement KeyListener interface.
   */
  class EnterListener implements KeyListener{
    
    //interface must methods
    
    /**
    * Implements the action according to the source.
    * @param  event the KeyEvent object.
    */
    public void keyPressed( KeyEvent event ){
      if( event.getSource() == numField && event.getKeyCode() == event.VK_ENTER ){
         num = Integer.parseInt( numField.getText() );
         hexField.setText( fromDecimal( numField.getText(), 16 ) );
         binField.setText( fromDecimal( numField.getText(), 2 ) );                 
      }
      else if( event.getSource() == binField && event.getKeyCode() == event.VK_ENTER ){
         num = Integer.parseInt( binField.getText() );
         hexField.setText( fromDecimal(toDecimal( binField.getText(), 2 ), 16 ) );
         numField.setText( toDecimal( binField.getText(), 2 ) );
         
      }
      else if( event.getSource() == hexField && event.getKeyCode() == event.VK_ENTER ){
         numField.setText( toDecimal( hexField.getText(), 16 ) );
         binField.setText( fromDecimal( toDecimal( hexField.getText() , 16 ), 2 ) );                 
      }
    
    }
    
    //must methods.
    public void keyReleased( KeyEvent event ){}
    public void keyTyped( KeyEvent event ){}
    
    
  }
  
  
  
  
}