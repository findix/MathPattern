package com.FindiX.MathPattern;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MathPatternUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ʵ����Window��ܣ�������ʵ����ֱ��newһ��������ҪWindow win=new Window������

		new Window("CASIFENG��ѧ������");
	}

}

class Window extends JFrame implements ActionListener, KeyListener {
	/**
	 * 
	 */
	MPattern mp = new MPattern();// ������һ��class
	private static final long serialVersionUID = 1L;// �Զ����ɣ�ID��

	// ����ʵ����menu�ؼ�
	JMenuBar menubar;
	JMenu menufile, menuedit, menuhelp, menuset;
	JRadioButtonMenuItem RadioItem1;
	JRadioButtonMenuItem RadioItem2;
	JMenuItem itemsave, itemopen, itemexit, itemcopy, itemcut, itempaste,
			itemhelp, itemabout, itemclean;
	JMenuItem itemcopyp, itemcutp, itempastep, itemcleanp;
	JTextArea text1 = null;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, point, PI, E;
	JButton add, min, times, div, percentage, CE;
	JButton sin, cos, tan, abs, mod, sqrt, squal, power, Lbrackets, Rbrackets,
			equals;
	JPopupMenu pop;
	boolean bool;

	// Window class�Ĺ��캯��
	Window(String s) {
		setTitle(s);// ����
		setSize(540, 360);// ���ڴ�С
		setLocation(400, 200);// ����λ��
		setVisible(true);// �ɼ���
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage("LOGO.gif");
		this.setIconImage(image);

		try {
			FileReader io = new FileReader("Settings.ini");
			int a = io.read();
			// System.out.println(a);
			if (a == 1) {
				bool = true;
				io.close();
			} else {
				bool = false;
				io.close();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		menubar = new JMenuBar();

		// ʵ�����˵�
		menufile = new JMenu("�ļ�");
		menuedit = new JMenu("�༭");
		menuhelp = new JMenu("����");
		menuset = new JMenu("����");
		pop = new JPopupMenu();

		// ʵ�����˵���ѡ��
		// �ļ�
		itemsave = new JMenuItem("����");
		itemsave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				KeyEvent.CTRL_MASK));
		itemopen = new JMenuItem("��");
		itemopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				KeyEvent.CTRL_MASK));
		itemexit = new JMenuItem("�˳�");

		// �༭
		itemexit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				KeyEvent.CTRL_MASK));
		itemcut = new JMenuItem("����");
		itemcut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				KeyEvent.CTRL_MASK));
		itemcopy = new JMenuItem("����");
		itemcopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				KeyEvent.CTRL_MASK));
		itempaste = new JMenuItem("ճ��");
		itempaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				KeyEvent.CTRL_MASK));
		itemclean = new JMenuItem("���");
		itemclean.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				KeyEvent.CTRL_MASK));
		// ����
		if (bool) {
			RadioItem1 = new JRadioButtonMenuItem("������", true);
			RadioItem2 = new JRadioButtonMenuItem("�Ƕ���");
		} else {
			RadioItem1 = new JRadioButtonMenuItem("������");
			RadioItem2 = new JRadioButtonMenuItem("�Ƕ���", true);
		}

		ButtonGroup bg = new ButtonGroup();
		bg.add(RadioItem1);
		bg.add(RadioItem2);
		menuset.add(RadioItem1);
		menuset.add(RadioItem2);
		setVisible(true);
		// ����
		itemhelp = new JMenuItem("������");
		itemabout = new JMenuItem("���ڡ�");

		itemcutp = new JMenuItem("����");
		itemcopyp = new JMenuItem("����");
		itempastep = new JMenuItem("ճ��");
		itemcleanp = new JMenuItem("���");

		// ImageIcon buttonIcon = new ImageIcon("button.png",
		// "a background of button");

		text1 = new JTextArea(4, 1);
		text1.setFont(new Font("Arial", getDefaultCloseOperation(), 16));

		// ʵ������ť
		sin = new JButton("sin");
		sin.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		cos = new JButton("cos");
		cos.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		tan = new JButton("tan");
		tan.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		abs = new JButton("abs");
		abs.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		mod = new JButton("mod");
		mod.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		sqrt = new JButton("��");
		sqrt.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		squal = new JButton("^2");
		squal.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		power = new JButton("^");
		power.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		equals = new JButton("=");
		equals.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b0 = new JButton("0");
		b0.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b1 = new JButton("1");
		b1.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b2 = new JButton("2");
		b2.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b3 = new JButton("3");
		b3.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b4 = new JButton("4");
		b4.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b5 = new JButton("5");
		b5.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b6 = new JButton("6");
		b6.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b7 = new JButton("7");
		b7.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b8 = new JButton("8");
		b8.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		b9 = new JButton("9");
		b9.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		point = new JButton(".");
		point.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		add = new JButton("+");
		add.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		min = new JButton("-");
		min.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		times = new JButton("��");
		times.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		div = new JButton("��");
		div.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		percentage = new JButton("%");
		percentage.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		CE = new JButton("CE");
		CE.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		Lbrackets = new JButton("(");
		Lbrackets.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		Rbrackets = new JButton(")");
		Rbrackets.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		PI = new JButton("��");
		PI.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		E = new JButton("e");
		E.setFont(new Font("Arial", getDefaultCloseOperation(), 16));
		// ��Ӳ˵�
		menubar.add(menufile);
		menubar.add(menuedit);
		menubar.add(menuset);
		menubar.add(menuhelp);

		// ��Ӳ˵���
		menufile.add(itemsave);
		menufile.add(itemopen);
		menufile.add(itemexit);
		menuedit.add(itemcut);
		menuedit.add(itemcopy);
		menuedit.add(itempaste);
		menuedit.add(itemclean);
		menuhelp.add(itemhelp);
		menuhelp.add(itemabout);

		pop.add(itemcutp);
		pop.add(itemcopyp);
		pop.add(itempastep);
		pop.add(itemcleanp);

		setJMenuBar(menubar);

		text1.setLineWrap(true);

		// �趨��ť���ֺ���Ӱ�ť
		add(new JScrollPane(text1), BorderLayout.NORTH);
		JPanel panel = new JPanel();
		GridLayout Grid = new GridLayout(5, 1, 8, 8);
		panel.setLayout(Grid);

		panel.add(sin);
		panel.add(sqrt);
		panel.add(CE);
		panel.add(PI);
		panel.add(E);
		panel.add(div);
		panel.add(cos);
		panel.add(squal);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(times);
		panel.add(tan);
		panel.add(power);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(min);
		panel.add(abs);
		panel.add(Lbrackets);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(add);
		panel.add(mod);
		panel.add(Rbrackets);
		panel.add(b0);
		panel.add(percentage);
		panel.add(point);
		panel.add(equals);

		text1.requestFocusInWindow();// ���focus��textarea

		// ��Ӱ�ť������
		sin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("sin(", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		cos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1.insert("cos(", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		tan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1.insert("tan(", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		sqrt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1.insert("��", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		squal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1.insert("^2", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		power.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1.insert("^", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		abs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1.insert("abs(", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		mod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1.insert("mod", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		equals.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (RadioItem2.getSelectedObjects() == null) {
					bool = true;
				} else {
					bool = false;

				}
				String[] lines = text1.getText().split("\n");
				mp.setPattern(lines[lines.length - 1]);
				// System.out.println(mp.fillParenthese());
				int a = mp.fillParenthese();
				for (int i = 1; i <= a; i++) {
					// System.out.println(i);
					text1.append(")");
				}

				double solve = mp.solvePattern(bool);
				Object sol = (int) solve == solve ? (int) solve : solve + "";
				text1.append("=" + sol);
				text1.append("\n");
				text1.setCaretPosition(text1.getText().length());
				text1.requestFocusInWindow();
				FileWriter io = null;
				try {
					io = new FileWriter("Settings.ini");
					if (bool) {
						io.write(1);
						io.close();
					} else
						io.write(0);
					io.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		b0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("0", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("1", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("2", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("3", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("4", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("5", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("6", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("7", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("8", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		b9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("9", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		point.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert(".", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("+", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		min.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("-", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		times.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("��", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		div.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("��", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		percentage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("%", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		Lbrackets.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("(", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		Rbrackets.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert(")", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		CE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.setText("");
				text1.requestFocusInWindow();
			}
		});
		PI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("��", text1.getCaretPosition());
				text1.requestFocusInWindow();
			}
		});
		E.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text1.insert("e", text1.getCaretPosition());
			}
		});

		// ��Ӳ˵��������
		itemsave.addActionListener(this);
		itemopen.addActionListener(this);
		itemexit.addActionListener(this);
		itemcut.addActionListener(this);
		itemcopy.addActionListener(this);
		itempaste.addActionListener(this);
		itemclean.addActionListener(this);
		itemhelp.addActionListener(this);
		itemabout.addActionListener(this);
		itemcutp.addActionListener(this);
		itemcopyp.addActionListener(this);
		itempastep.addActionListener(this);
		itemcleanp.addActionListener(this);
		text1.addKeyListener(this);
		text1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent popevent) {
				// TODO Auto-generated method stub
				if (popevent.isPopupTrigger()) {
					pop.show(popevent.getComponent(), popevent.getX(),
							popevent.getY());
				}
			}

			@Override
			public void mousePressed(MouseEvent popevent) {
				// TODO Auto-generated method stub
				if (popevent.isPopupTrigger()) {
					pop.show(popevent.getComponent(), popevent.getX(),
							popevent.getY());
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}

	// �������س���������
	@Override
	public void keyPressed(KeyEvent e) {
		KeyStroke enter = KeyStroke.getKeyStroke("ENTER ");
		text1.getInputMap().put(enter, "none ");
		KeyStroke star = KeyStroke.getKeyStroke('*');
		text1.getInputMap().put(star, "none ");
		KeyStroke divide = KeyStroke.getKeyStroke('/');
		text1.getInputMap().put(divide, "none ");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (RadioItem2.getSelectedObjects() == null) {
				bool = true;
			} else {
				bool = false;

			}
			String[] lines = text1.getText().split("\n");
			if (lines[lines.length - 1] != "") {
				// System.out.println(lines[lines.length - 1]);
				mp.setPattern(lines[lines.length - 1]);
				int a = mp.fillParenthese();
				for (int i = 1; i <= a; i++) {
					// System.out.println(i);
					text1.append(")");

				}

				double solve = mp.solvePattern(bool);
				// System.out.println(bool);
				Object sol = (int) solve == solve ? (int) solve : solve + "";
				text1.append("=" + sol);
				text1.append("\n");
				text1.setCaretPosition(text1.getText().length());
				text1.requestFocusInWindow();
			}
			FileWriter io = null;
			try {
				io = new FileWriter("Settings.ini");
				if (bool) {
					io.write(1);
					io.close();
				} else {
					io.write(0);
					io.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
			// e.setKeyChar('��');
			text1.append("��");
		} else if (e.getKeyCode() == KeyEvent.VK_ASTERISK) {
			// e.setKeyChar('��');
			// text1.append("��");
		} else if (e.getKeyCode() == KeyEvent.VK_SEPARATOR) {
			// e.setKeyChar('��');
			// text1.append("��");
		} else if (e.getKeyCode() == KeyEvent.VK_SLASH) {
			// e.setKeyChar('��');
			text1.append("��");
		} else if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {
			// e.setKeyChar('��');
			text1.append("��");
		} else if ((e.getKeyCode() == KeyEvent.VK_8
				&& ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) == 0) && ((e
				.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0))) {
			// e.setKeyChar('��');
			text1.append("��");
		}

	}

	// �˵�������
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == itemexit) {
			int a = JOptionPane.showConfirmDialog(null, "ȷ���˳���������", "��ܰ��ʾ",
					JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				System.exit(0);
			}
		} else if (e.getSource() == itemsave) {
			FileWriter io = null;
			try {
				io = new FileWriter("data.db");
				String[] lines;
				lines = text1.getText().split("\n ");
				for (int i = 0; i < lines.length; i++) {
					io.write(lines[i] + "\n ");
					io.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == itemopen) {
			text1.setText("");
			try {
				FileReader io = new FileReader("data.db");
				BufferedReader ios = new BufferedReader(io);
				String s = null;
				while ((s = ios.readLine()) != null) {
					text1.append(s + "\n");
				}

				io.close();
				ios.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == itemcut) {
			text1.cut();
		} else if (e.getSource() == itemcopy) {
			text1.copy();
		} else if (e.getSource() == itempaste) {
			text1.paste();
		} else if (e.getSource() == itemclean) {
			text1.setText("");
		} else if (e.getSource() == itemcutp) {
			text1.cut();
		} else if (e.getSource() == itemcopyp) {
			text1.copy();
		} else if (e.getSource() == itempastep) {
			text1.paste();
		} else if (e.getSource() == itemcleanp) {
			text1.setText("");
		} else if (e.getSource() == itemhelp) {
			JOptionPane
					.showConfirmDialog(
							null,
							"���������ɽ������¼��㣺\n\n�������� �磺��34+67����50%��3.8��\n�˷����������� �磺3^��2+5����2��2\n���Ǻ������� �磺cos(sin(5��+6)) �������Ƕ��ƺͻ����ƣ�\n����ֵ��������� �磺abs(7e-7^2) �� 17mod5\n\n��������������ϵE-Mail��fengxiang220@gmail.com",
							"����", JOptionPane.CLOSED_OPTION);
		} else if (e.getSource() == itemabout) {
			JOptionPane
					.showConfirmDialog(
							null,
							"Coder : mLin Feng Xiang\nDesigned By FindiX in ShangHai\nGUI    Version : 1.4 Final\nCore Version : 2.2 Final",
							"����", JOptionPane.CLOSED_OPTION);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
