package chunin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ChuninUI extends JFrame{
	
	private HashMap <Integer, String> fighters = new HashMap<Integer, String>(); 
	private int numFighters;
	
	// Empty constructor
	public ChuninUI()
	{
		
	}
	
	// Constructor class
	public ChuninUI(String [] names, int numFighters)
	{
		this.numFighters = numFighters;
		for (int i = 0; i < numFighters; i++)
		{
			fighters.put(i + 1, names[i]);
		}
	}
	
	public void createWindow()
	{
		
		// Set the window size
		JFrame frame = new JFrame("Chunin Exams Tournament");
		frame.setSize(400,1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creates the Naruto vs Sasuke image
		ImageIcon icon = new ImageIcon("uiimage.jpg");
		JLabel label = new JLabel(icon);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(label, BorderLayout.NORTH);
		
		// Start buttons
		JButton select_fighter = new JButton("Generate a Match!");
		select_fighter.setLayout( null );
		frame.getContentPane().add(select_fighter, BorderLayout.SOUTH);
		
		
		frame.setLocationRelativeTo(null);
		
		
		// Label's that will generate an opponents name
		JLabel fighter1 = new JLabel("Fighter 1");
		fighter1.setSize(1000,100);
		JLabel fighter2 = new JLabel("Fighter 2");
		fighter2.setSize(1000,100);
		fighter1.setOpaque(true);
		fighter1.setBackground(Color.GRAY);
		fighter2.setOpaque(true);
		fighter2.setBackground(Color.GRAY);
		
		frame.add(fighter1, BorderLayout.WEST);
		frame.add(fighter2, BorderLayout.EAST);
		
		// Button is pressed
		select_fighter.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			String prevFighter1 = "";
			@SuppressWarnings("unused")
			String prevFighter2 = "";
			public void actionPerformed(ActionEvent e)
			{
				Random rand = new Random();
				
				
				int rand1 = rand.nextInt(numFighters - 1 + 1) + 1;
				int rand2 = rand.nextInt(numFighters - 1 + 1) + 1;
				
				// Clause 1: We can't have a fighter fight themselves!
				if (rand1 == rand2)
				{
					while(rand1 == rand2)
					{
						rand1 = rand.nextInt(numFighters - 1 + 1) + 1;
					}
				}
				
				// Clause 2: The new fighter can't be the previous fighter!
				if (prevFighter1 == fighters.get(rand1))
				{
					while(prevFighter1 == fighters.get(rand1))
					{
						rand1 = rand.nextInt(numFighters - 1 + 1) + 1;
					}
				}
				
				// Clause 2.5: Same goes for fighter 2!
				if (prevFighter2 == fighters.get(rand2))
				{
					while(prevFighter2 == fighters.get(rand2))
					{
						rand2 = rand.nextInt(numFighters - 1 + 1) + 1;
					}
				}
				
				// Previous fighter 1 can't be the new fighter 2!
				if (prevFighter1.compareTo(fighters.get(rand2)) == 0) // && prevFighter1 != "" && prevFighter2 != "")
				{
					while(prevFighter1.compareTo(fighters.get(rand2)) == 0)
					{
						rand2 = rand.nextInt(numFighters - 1 + 1) + 1;
					}
				}
				
				// Set text of labels and store the previous values for next match
				fighter1.setText(fighters.get(rand1));
				prevFighter1 = fighters.get(rand1);
				System.out.println("Fighter 1 value: " + rand1);
				fighter2.setText(fighters.get(rand2));
				prevFighter2 = fighters.get(rand2);
				System.out.println("Fighter 2 value: " + rand2);
			}
		});
		
		frame.pack();
		frame.setVisible(true);
		}
		
}
