/*
 * Dec 2020
 * Project Chunin Exams:
 * A fight match generator for fight club!
 * Incentivises people to train instead of sitting around!
 * Coded using what I've learned from CNT 4714 on Java Swing UI
 * Intended to help sharpen my Java and OOP skills
 * 
 * ALL NARUTO RELATED CONTENT BELONGS TO THE CREATOR AND OWNERS!
 * 
 * 
 * Original code by Noah Law
 */

package chunin;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChuninMain {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan  = new Scanner(new File("fighters.txt"));
		int numFighters = 0;
		
		numFighters = scan.nextInt();
		String [] names = new String [numFighters];
		int i = 0;
		
		// TODO FIGURE OUT WHY THERE IS A BLANK VALUE IN MY TEXT FILE STORE THE BLANK VALUE IN HERE FOR NOW!
		String dummyVal = scan.nextLine();
		
		while (scan.hasNext())
		{	
			names[i] = scan.nextLine();
			System.out.println(names[i]);
			i++;
		}
		
		// Used to check if the first fighter is a blank string
		//System.out.println("The first fighter: " + names[0]);
		
		ChuninUI newMenu = new ChuninUI(names, numFighters);
		newMenu.createWindow();
	}

}
