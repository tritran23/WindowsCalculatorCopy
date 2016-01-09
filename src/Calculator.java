
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Calculator extends JFrame {
  
  /**
   * 
   */
  private static final long serialVersionUID = 8127683175984781739L;
  private JMenuBar menuBar;
  private JMenu file;
  private JMenu edit;
  private JMenu help;
  
  private JMenuItem close;
  private JMenuItem copy;
  private JMenuItem view;
  private JMenuItem about;
  
  private JTextField display;
 
  
  public static void main(String[] args){
    try{
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e){
      e.printStackTrace();
    }
    new Calculator();
  }
  
  public Calculator(){
    super("Calculator");
    sendMenuBar();
    sendDisplay();
    sendUI(this);
  }
  
  private void sendMenuBar() {
    menuBar = new JMenuBar();
    file = new JMenu(" File ");
    edit = new JMenu(" Edit ");
    help = new JMenu(" Help ");
    
    close = new JMenuItem("Close");
    copy = new JMenuItem("Copy");
    view = new JMenuItem("View Help");
    about = new JMenuItem("About Calculator");
    
    setJMenuBar(menuBar);
    
    menuBar.add(file);
    menuBar.add(edit);
    menuBar.add(help);
    
    close.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        System.exit(0);
      }
      
    });
    
    copy.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        String temp = "";
        StringSelection string = new StringSelection(temp);
        Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
        system.setContents(string, string);
      }
      
    });
    
    view.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        JOptionPane.showMessageDialog(null, "No Topics At The Moment.", 
            "Calculator", JOptionPane.OK_OPTION);
      }
      
    });
    
    about.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(null, "Tri's Basic Calculator", 
            "Calculator", JOptionPane.OK_OPTION);
      }
      
    });
    
    
    file.add(close);
    edit.add(copy);
    help.add(view);
    help.add(about);
  }
  
  private void sendDisplay() {
    display = new JTextField("0");
    display.setBounds(10, 10, 324, 40);
    display.setEditable(false);
    display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    display.setFont(new Font("Arial", Font.PLAIN, 35));
    add(display);
    
  }
  
  private void sendUI(Calculator app) {
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setResizable(false);
    app.setSize(350, 400);
    app.setLayout(null);
    app.setLocationRelativeTo(null);
    app.setVisible(true);
  }
}
