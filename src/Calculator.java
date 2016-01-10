
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
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
  
  private JTextArea display;
  
  private JButton seven;
  private JButton eight;
  private JButton nine;
  
  private JButton four;
  private JButton five;
  private JButton six;
  
  private JButton one;
  private JButton two;
  private JButton three;
  
  

  
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
    sendButtons();
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
        String tempDisplay = display.getText();
        StringSelection string = new StringSelection(tempDisplay);
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
    display = new JTextArea("0");
    display.setBounds(10, 10, 324, 50);
    display.setEditable(false);
    //display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    //display.setText("0");
    display.setFont(new Font("Arial", Font.PLAIN, 35));
    add(display);
    
  }
  private void sendButtons() {
    seven = new JButton("7");
    seven.setBounds(10, 70, 65, 65);
    seven.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("7");
          return;
        }
        display.setText(display.getText() + "7");
        
      }
      
      
    });
    add(seven);
    
    
    
    eight = new JButton("8");
    eight.setBounds(82, 70, 65, 65);
    eight.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("8");
          return;
        }
        display.setText(display.getText() + "8");
        
      }
      
      
    });
    add(eight);
    
    nine = new JButton("9");
    nine.setBounds(154, 70, 65, 65);
    nine.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("9");
          return;
        }
        display.setText(display.getText() + "9");
        
      }
      
      
    });
    add(nine);
    
    nine = new JButton("9");
    nine.setBounds(154, 70, 65, 65);
    nine.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("9");
          return;
        }
        display.setText(display.getText() + "9");
        
      }
      
      
    });
    add(nine);
    
    four = new JButton("4");
    four.setBounds(10, 140, 65, 65);
    four.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("4");
          return;
        }
        display.setText(display.getText() + "4");
        
      }
      
      
    });
    add(four);
    
    five = new JButton("5");
    five.setBounds(82, 140, 65, 65);
    five.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("5");
          return;
        }
        display.setText(display.getText() + "5");
        
      }
      
      
    });
    add(five);
    
    six = new JButton("6");
    six.setBounds(154, 140, 65, 65);
    six.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("6");
          return;
        }
        display.setText(display.getText() + "6");
        
      }
      
      
    });
    add(six);
    
    one = new JButton("1");
    one.setBounds(10, 210, 65, 65);
    one.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("1");
          return;
        }
        display.setText(display.getText() + "1");
        
      }
      
      
    });
    add(one);
    
    two = new JButton("2");
    two.setBounds(82, 210, 65, 65);
    two.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("2");
          return;
        }
        display.setText(display.getText() + "2");
        
      }
      
      
    });
    add(two);
    
    three = new JButton("3");
    three.setBounds(154, 210, 65, 65);
    three.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().length() > 15)
          return;
        if (display.getText().equalsIgnoreCase("0")) {
          display.setText("3");
          return;
        }
        display.setText(display.getText() + "3");
        
      }
      
      
    });
    add(three);
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
