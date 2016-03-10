package edu.cis232;

public class Square implements Shape{
	private static final long serialVersionUID = 1L;
	private double area;
	private double length;
	
	public Square(double length){
		if(length>=0){
			this.length = length;
		}else{
			throw new IllegalArgumentException("The number entered must not be negative");
		}		
	}
	
	public double getArea(){
		area = (length*length);
		return area;
	}
	public String toString(){
		return String.format("The area of your Square is %,.2f", getArea());
	}

}
