package edu.cis232;

public class Circle implements Shape{
	private static final long serialVersionUID = 1L;
	private double area;
	private double radius;
	
	public Circle(double radius){
		if(radius >=0){
			this.radius = radius;
		}else{
			throw new IllegalArgumentException("The number entered must not be negative");
		}		
	}
	
	public double getArea(){
		area = (Math.PI)*(radius*radius);
		return area;
	}
	public String toString(){
		return String.format("The area of your Circle is %,.2f", getArea());
	}

}
