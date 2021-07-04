import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiceGui{
	private JFrame frame;
	private JLabel result;
	private int diceResult = 1;
	private JPanel drawPanel;
	
	public static void main(String[] args){
		new DiceGui().start();
	}
	
	private void start(){
		initializeGui("My Gui Dice");
		JPanel panel = new JPanel();
		JButton roll = new JButton("Roll Dice");
		roll.addActionListener(new MyRollListener());
		result = new JLabel("");
		panel.add(roll);
		panel.add(result);
		panel.setBackground(Color.white);
		
		/*
		JPanel dicePanel = new JPanel();
		dicePanel.setSize(200,200);
		dicePanel.add(new MyDrawPanel());
		*/
		drawPanel = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
	}
	
	private void initializeGui(String title){
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
		Rectangle rect = new Rectangle(300,300);
		frame.setResizable(false);
		frame.setSize(300,300);
	}
	
	class MyRollListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			diceResult = getRandom(1,6);
			result.setText("" + diceResult);
			drawPanel.repaint();
		}
	}
	
	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			
			//pintamos el fondo para que no se rompa el repaint()
			g.setColor(Color.white);
			g.fillRect(0,0,300,300);
			
			g.setColor(Color.orange);
			//Rectangulo con offset de 100 en x y de tamaño 100px por 100px
			g.fillRect(90,0,100,100);
			g.setColor(Color.black);
			
			switch(diceResult){
				case 1:
					paint1(g);
					break;
				case 2:
					paint2(g);
					break;
				case 3:
					paint3(g);
					break;
				case 4:
					paint4(g);
					break;
				case 5:
					paint5(g);
					break;
				case 6:
					paint6(g);
					break;
			}
			
			
			/*
			g.fillOval(100,10,20,20);	//1 arriba izq
			g.fillOval(160,10,20,20);	//2 arriba der
			g.fillOval(100,40,20,20);	//3 centro izq
			g.fillOval(130,40,20,20); 	//4 centro 
			g.fillOval(160,40,20,20); 	//5 centro der
			g.fillOval(100,70,20,20); 	//6 abajo izq
			g.fillOval(160,70,20,20); 	//7 abajo der
			*/
		}
	}
	
	private void paint1(Graphics g){
		g.fillOval(130,40,20,20); 
	}
	
	private void paint2(Graphics g){
		g.fillOval(160,10,20,20);
		g.fillOval(100,70,20,20); 
	}
	
	private void paint3(Graphics g){
		paint2(g);
		paint1(g);
	}
	
	private void paint4(Graphics g){
		paint2(g);
		g.fillOval(100,10,20,20);
		g.fillOval(160,70,20,20); 
	}
	
	private void paint5(Graphics g){
		paint4(g);
		paint1(g);
	}
	
	private void paint6(Graphics g){
		paint4(g);
		g.fillOval(100,40,20,20);
		g.fillOval(160,40,20,20);
	}
	
	private int getRandom(int min, int cantValores){
		return (int) ((Math.random() * cantValores) + min);
	}
}