
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
  
  private JButton zero;
  private JButton decimal;
  private JButton posneg;
  
  private JButton divide;
  private JButton multiply;
  private JButton subtract;
  private JButton add;
  
  private JButton clear;
  private JButton equals;
  
  private String first;
  private Character operation;
  private String second;
  
  

  
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
    display.setBounds(10, 10, 351, 50);
    display.setEditable(false);
    //display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    //display.setText("0");
    display.setFont(new Font("Arial", Font.PLAIN, 35));
    add(display);
    
  }
  
  private void assignOperation(Character s){
    if (operation == null){
      operation = s;
      display.append(s.toString());
    } else{
      display.setText(display.getText().replace(operation, s));
      operation = s;
    }
    
  }
    
  private void sendButtons() {
    seven = new JButton("7");
    seven.setBounds(10, 70, 65, 65);
    seven.addActionListener(numberClickAction("7"));
    add(seven);
    
    
    
    eight = new JButton("8");
    eight.setBounds(82, 70, 65, 65);
    eight.addActionListener(numberClickAction("8"));
    add(eight);
    
    nine = new JButton("9");
    nine.setBounds(154, 70, 65, 65);
    nine.addActionListener(numberClickAction("9"));
    add(nine);
    
    
    four = new JButton("4");
    four.setBounds(10, 140, 65, 65);
    four.addActionListener(numberClickAction("4"));
    add(four);
    
    five = new JButton("5");
    five.setBounds(82, 140, 65, 65);
    five.addActionListener(numberClickAction("5"));
    add(five);
    
    six = new JButton("6");
    six.setBounds(154, 140, 65, 65);
    six.addActionListener(numberClickAction("6"));
    add(six);
    
    one = new JButton("1");
    one.setBounds(10, 210, 65, 65);
    one.addActionListener(numberClickAction("1"));
    add(one);
    
    two = new JButton("2");
    two.setBounds(82, 210, 65, 65);
    two.addActionListener(numberClickAction("2"));
    add(two);
    
    three = new JButton("3");
    three.setBounds(154, 210, 65, 65);
    three.addActionListener(numberClickAction("3"));
    add(three);
    
    zero = new JButton("0");
    zero.setBounds(10, 280, 65, 65);
    zero.addActionListener(numberClickAction("0"));
    add(zero);
    
    decimal = new JButton(".");
    decimal.setBounds(82, 280, 65, 65);
    decimal.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().contains(".")) 
          return;
        display.append(".");
        if (second == null){
          if (first == null){
            first = "0.";
          } else {
            first = first + ".";
          }
        } else{
          second = second + ".";
        }
      }
      
      
      
    });
    add(decimal);
    
    posneg = new JButton("+/-");
    posneg.setBounds(154, 280, 65, 65);
    posneg.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (display.getText().equalsIgnoreCase("0")) 
          return;
        
        display.setText(Double.toString
            (Double.parseDouble(display.getText()) * (-1)));
        //replaces the new double number with its int
        if (display.getText().endsWith(".0")){
          display.setText(display.getText().replace(".0", ""));
        }
        
      }
      
      
    });
    add(posneg);
    
    divide = new JButton("/");
    divide.setBounds(226, 70, 65, 65);
    divide.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        assignOperation('/');
        
      }
      
      
    });
    add(divide);
    
    multiply = new JButton("*");
    multiply.setBounds(226, 140, 65, 65);
    multiply.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        assignOperation('*');
        
        }
        
      
      
    });
    add(multiply);
    
    subtract = new JButton("-");
    subtract.setBounds(226, 210, 65, 65);
    subtract.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        assignOperation('-');
        
      }
      
      
    });
    add(subtract);
    
    add = new JButton("+");
    add.setBounds(226, 280, 65, 65);
    add.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        assignOperation('+');
        
      }
      
      
    });
    add(this.add);
    
    clear = new JButton("C");
    clear.setBounds(298, 70, 65, 135);
    clear.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        first = null;
        operation = null;
        second = null;
        display.setText("0");
        
      }
        
    });
    add(clear);
    
    equals = new JButton("=");
    equals.setBounds(298, 210, 65, 135);
    equals.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (operation == null){
          return;
        }else if (second == null){
          //if there's no second argument in the equation
          //then it will take the first argument as the second
          
          calculate(first, first, operation);
        }else{
          calculate(first, second, operation);
        }
        
        if (display.getText().endsWith(".0")){
          display.setText(display.getText().replace(".0", ""));
        }

        System.out.println(first);
        System.out.println(operation);
        System.out.println(second);
      }
      
      
    });
    add(equals);
  }
  
  private void calculate(String fir, String sec, Character op){
    if (op == '+'){
      display.setText(Double.toString
          (Double.parseDouble(fir) + Double.parseDouble(sec)));
    } else if (op == '-'){
        display.setText(Double.toString
            (Double.parseDouble(fir) - Double.parseDouble(sec)));
    }else if (op == '*'){
        display.setText(Double.toString
            (Double.parseDouble(fir) * Double.parseDouble(sec)));
    }else if (op == '/'){
        display.setText(Double.toString
            (Double.parseDouble(fir) / Double.parseDouble(sec)));
      }
    first = null;
    operation = null;
    second = null;
  }
  
  private ActionListener numberClickAction(String pressedNum) {
    ActionListener action = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        
        if (display.getText().length() > 17)
          return;
        if (display.getText().equalsIgnoreCase("0") ||
            first == null) {
          display.setText(pressedNum);
        }else{
        display.append(pressedNum);
        }
        if (operation == null){
          if (first == null){
            first = pressedNum;
          }else{
            first = first + pressedNum;
          }
        }else if (second == null) {
          second = pressedNum;
        }else{
          second = second + pressedNum;
        }

        
        System.out.println(first);
        System.out.println(operation);
        System.out.println(second);
        
      }
    }; 
    return action;
  }
  
  private void sendUI(Calculator app) {
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setResizable(false);
    app.setSize(380, 400);
    app.setLayout(null);
    app.setLocationRelativeTo(null);
    app.setVisible(true);
  }
}
