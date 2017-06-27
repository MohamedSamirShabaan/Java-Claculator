package eg.edu.alexu.csd.oop.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Gui extends JFrame {
	private JTextField answerFiled;
	private JButton one , two , three , four, five , six , seven , eight , nine , zero , add ,
	 sub , multi , div, equal , prev , next , current , save , load ;
	private JPanel contPanel;
	private String temp = "" , temp2 = "" ;
	private static final int WIDTH1 = 75 , HEG1 = 25;  
	private static final int WIDTH2 = 225 , HEG2 = 25;
	private static final int WIDTH3 = 113 , HEG3 = 25;  
	private MyClaculator calc;
	private boolean check = false;
	 
	 
	 public Gui(){
		 super("Calculator");
		 answerFiled = new JTextField(null , 20);
		 answerFiled.setEditable(false);
		 
		 zero = new JButton("0");
		 one = new JButton("1");
		 two = new JButton("2");
		 three = new JButton("3");
		 four = new JButton("4");
		 five = new JButton("5");
		 six = new JButton("6");
		 seven = new JButton("7");
		 eight = new JButton("8");
		 nine = new JButton("9");
		 add = new JButton("+");
		 sub = new JButton("-");
		 multi = new JButton("*");
		 div = new JButton("/");
		 equal = new JButton("=");
		 prev = new JButton("<<");
		 next = new JButton(">>");
		 current = new JButton("Current");
		 save = new JButton("Save");
		 load = new JButton("Load");
		 
		 Dimension dim = new Dimension(WIDTH1 , HEG1);
		 one.setPreferredSize(dim);
		 two.setPreferredSize(dim);
		 three.setPreferredSize(dim);
		 four.setPreferredSize(dim);
		 five.setPreferredSize(dim);
		 six.setPreferredSize(dim);
		 seven.setPreferredSize(dim);
		 eight.setPreferredSize(dim);
		 nine.setPreferredSize(dim);
		 zero.setPreferredSize(new Dimension(WIDTH2 , HEG2));
		 add.setPreferredSize(new Dimension(WIDTH3 , HEG3));
		 sub.setPreferredSize(new Dimension(WIDTH3 , HEG3));
		 multi.setPreferredSize(new Dimension(WIDTH3 , HEG3));
		 div.setPreferredSize(new Dimension(WIDTH3 , HEG3));
		 equal.setPreferredSize(new Dimension(WIDTH2 , HEG2));
		 prev.setPreferredSize(new Dimension(WIDTH3 , HEG3));
		 next.setPreferredSize(new Dimension(WIDTH3 , HEG3));
		 current.setPreferredSize(new Dimension(WIDTH2 , HEG2));
		 save.setPreferredSize(new Dimension(WIDTH3 , HEG3));
		 load.setPreferredSize(new Dimension(WIDTH3 , HEG3));
		 
		 Number n = new Number();
		
		 calc = MyClaculator.getInstance();
		 
		 one.addActionListener(n);
		 two.addActionListener(n);
		 three.addActionListener(n);
		 four.addActionListener(n);
		 five.addActionListener(n);
		 six.addActionListener(n);
		 seven.addActionListener(n);
		 eight.addActionListener(n);
		 nine.addActionListener(n);
		 zero.addActionListener(n);
		 add.addActionListener(n);
		 sub.addActionListener(n);
		 div.addActionListener(n);
		 multi.addActionListener(n);
		 equal.addActionListener(n);
		 current.addActionListener(n);
		 next.addActionListener(n);
		 prev.addActionListener(n);
		 save.addActionListener(n);
		 load.addActionListener(n);
		 
		 contPanel = new JPanel();
		 contPanel.setBackground(Color.cyan);
		 contPanel.setLayout(new FlowLayout());
		 contPanel.add(answerFiled , BorderLayout.NORTH);
		 contPanel.add(one);
		 contPanel.add(two);
		 contPanel.add(three);
		 contPanel.add(four);
		 contPanel.add(five);
		 contPanel.add(six);
		 contPanel.add(seven);
		 contPanel.add(eight);
		 contPanel.add(nine);
		 contPanel.add(zero);
		 contPanel.add(add);
		 contPanel.add(sub);
		 contPanel.add(multi);
		 contPanel.add(div);
		 contPanel.add(equal);
		 contPanel.add(prev);
		 contPanel.add(next);
		 contPanel.add(current);
		 contPanel.add(save);
		 contPanel.add(load);
		 this.setContentPane(contPanel); 
	 }
	 private class Number implements ActionListener{
		 public void actionPerformed(ActionEvent event){
			 JButton src = (JButton) event.getSource();
			 
			 if (src.equals(one)){
				 temp += "1";
				 check = false;
			 }
			 else if (src.equals(two)){
				 temp += "2";check = false;
			 }
			 else if (src.equals(three)){
				 temp += "3";check = false;
			 }
			 else if (src.equals(four)){
				 temp += "4";check = false;
			 }
			 else if (src.equals(five)){
				 temp += "5";check = false;
			 }
			 else if (src.equals(six)){
				 temp += "6";check = false;
			 }
			 else if (src.equals(seven)){
				 temp += "7";check = false;
			 }
			 else if (src.equals(eight)){
				 temp += "8";check = false;
			 }
			 else if (src.equals(nine)){
				 temp += "9";check = false;
			 }
			 else if (src.equals(zero)){
				 temp += "0";check = false;
			 }
			 else if (src.equals(add)){
				if (check){temp = temp2;}
				temp += "+";
			 }
			 else if (src.equals(sub)){
				 if (check){temp = temp2;}
				 temp += "-";
			 }
			 else if (src.equals(multi)){
				 if (check){temp = temp2;}
				 temp += "*";
			 }
			 else if (src.equals(div)){
				 if (check){temp = temp2;}
				 temp += "/";
			 }
			 answerFiled.setText(temp);
			  if (src.equals(equal)){
				  if (temp != "")calc.input(temp);
					try {
						String s = calc.getResult();
						 answerFiled.setText(temp + "=" + s);
						 temp2 = s;
						 check = true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						 answerFiled.setText("MATH ERROR");
					}
			        temp = "";	  
			 }
			 if(src.equals(current)){
				 String s = calc.current();
				 if (s == null){answerFiled.setText("null");}
				 else answerFiled.setText(s);
			 }
			 if (src.equals(prev)){
				 String s = calc.prev();
				 if (s == null){answerFiled.setText("null");}
				 else answerFiled.setText(s);
                check = false; 
			 }
			 if (src.equals(next)){
				String s = calc.next();
				 if (s == null){answerFiled.setText("null");}
				 else answerFiled.setText(s);
	             check = false; 
			 }
			 if(src.equals(save)){
				 calc.save();
			 }
			 if (src.equals(load)){
				 try{
					 calc.load();
				 }catch(Exception e){
					 answerFiled.setText("ErrorLoadFile");
				 }
			 }
			 
		 }
	 }
}

 