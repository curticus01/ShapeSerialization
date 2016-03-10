package edu.cis232;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class SecondaryApplication {

	public static void main(String[] args) throws IOException{
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		FileInputStream fis = new FileInputStream("shapes.dat");
		RandomAccessFile file = new RandomAccessFile("shapes.dat","r");
		int intCount=0;
		try {
			file.seek(0);
			intCount = file.readInt();
			fis.skip(4);
			for(int i=0; i<intCount; i++){
				ObjectInputStream input = new ObjectInputStream(fis);
				shapes.add((Shape) input.readObject());	
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Shape shape : shapes){
			System.out.println(shape);
		}
		System.out.printf("\nThere are %d Shapes in this file.", intCount);
		
		fis.close();
		file.close();
	}

}
