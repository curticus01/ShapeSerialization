package edu.cis232;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		String input;
		System.out.println("Enter a shape (Square, Circle, Rectangle)");
		input = keyboard.nextLine();
		Shape shape = null;
		
		//Generate output for shape objects
		FileOutputStream fos = new FileOutputStream("shapes.dat",true);
		DataOutputStream dos = new DataOutputStream(fos);
		
		RandomAccessFile raf = new RandomAccessFile("shapes.dat","rw");
		if(raf.length()==0){
			dos.writeInt(0);
		}
		ObjectOutputStream output = new ObjectOutputStream(fos);
		
		
		switch(input.toLowerCase()){
			//Circle
			case "circle":{
				System.out.println("Enter the radius of your circle");
				double radius = keyboard.nextDouble();
				shape = new Circle(radius);
				break;
			}
				
			//Square
			case "square":{
				System.out.println("Enter the Length of your Square");
				double length = keyboard.nextDouble();
				shape = new Square(length);
								
				break;
			}			
			
			//Rectangle
			case "rectangle":{
				System.out.println("Enter the Length of your Rectangle");
				double length = keyboard.nextDouble();
				System.out.println("Enter the Width of your Rectangle");
				double width = keyboard.nextDouble();
				shape = new Rectangle(width,length);
								
				break;
			}
			
		}
		

		System.out.println(shape);
		//writing object
		output.writeObject(shape);
		output.close();
		raf.seek(0);
		int intCount = raf.readInt();		
		raf.seek(0);
		raf.writeInt(intCount+1);
		raf.close();
		keyboard.close();
	}

}
