package edu.cis232;

public class Rectangle  implements Shape{
	
	private static final long serialVersionUID = 1L;
	private double area;
	private double length;
	private double width;
	
	public Rectangle(double width, double length){
		if(width >=0 && length>=0){
			this.width = width;
			this.length = length;
		}else{
			throw new IllegalArgumentException("The number entered must not be negative");
		}		
	}
	
	public double getArea(){
		area = (width*length);
		return area;
	}
	public String toString(){
		return String.format("The area of your Rectangle is %,.2f", getArea());
	}
}

