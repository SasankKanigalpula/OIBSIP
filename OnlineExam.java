import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineExam extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];


	OnlineExam(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 600, 20);
		radioButton[0].setBounds(50, 80, 900, 20);
		radioButton[1].setBounds(50, 110, 900, 20);
		radioButton[2].setBounds(50, 140, 900, 20);
		radioButton[3].setBounds(50, 170, 900, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(900, 500);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (answers())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (answers())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (answers())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Q1)When does method overloading is determined?");
			radioButton[0].setText("At compile Time");
			radioButton[1].setText("At Run Time");
			radioButton[2].setText("At Coding Time");
			radioButton[3].setText("None");
		}
		if (current == 1) {
			label.setText("Q2) Which feature of OOPS described the reusability of code?");
			radioButton[0].setText("Encapsulation");
			radioButton[1].setText("Abstraction");
			radioButton[2].setText("Polymorphism");
			radioButton[3].setText("Inheritance");
		}
		if (current == 2) {
			label.setText("Q3) Select the valid statement.");
			radioButton[0].setText("char[] ch=new char(5)");
			radioButton[1].setText("char[] ch=new char[5]");
			radioButton[2].setText("char[] ch=new char()");
			radioButton[3].setText("char[] ch=new char[]");
		}
		if (current == 3) {
			label.setText("Q4) Select the valid statement to declare and initialize an array");
			radioButton[0].setText("int[] A={}");
			radioButton[1].setText("int[] A={1,2,3}");
			radioButton[2].setText("int[] A=(1,2,3)");
			radioButton[3].setText("int[][] A={1,2,3}");
		}
		if (current == 4) {
			label.setText("Q5)Arrays in java are");
			radioButton[0].setText("Object references");
			radioButton[1].setText("objects");
			radioButton[2].setText("Primitive data type");
			radioButton[3].setText("None");
		}
		if (current == 5) {
			label.setText("Q6)In which of the following is toString() method defined?");
			radioButton[0].setText("java.lang.Object");
			radioButton[1].setText("java.lang.String");
			radioButton[2].setText("java.lang.util");
			radioButton[3].setText("none");
		}
		if (current == 6) {
			label.setText("Q7) When is the object created with new keyword?");
			radioButton[0].setText("At Run time");
			radioButton[1].setText("At Compile time");
			radioButton[2].setText("Depends on the code");
			radioButton[3].setText("None");
		}
		if (current == 7) {
			label.setText("Q8) Which of the following is not a core interface of Hibernate?");
			radioButton[0].setText("Configuration");
			radioButton[1].setText("Criteria");
			radioButton[2].setText("SessionManagement");
			radioButton[3].setText("Session");
		}
		if (current == 8) {
			label.setText("Q9) What is the size of float and double in java?");
			radioButton[0].setText("32 and 64");
			radioButton[1].setText("32 and 32");
			radioButton[2].setText("64 and 32");
			radioButton[3].setText("64 and 64");
		}
		if (current == 9) {
			label.setText("Q10) Automatic type conversion is possible in which of the possible cases?");
			radioButton[0].setText("byte to int");
			radioButton[1].setText("int to long");
			radioButton[2].setText("long to int");
			radioButton[3].setText("short to int");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean answers() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineExam("Online Examination Application");
	}

}