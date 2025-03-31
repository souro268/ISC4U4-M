package Assignment8;
public class Assignment8_Main {

	public static void main(String[] args) {
		//Create two rectangles
		//These should intersect, with an area of 6
		Rectangle rect1 = new Rectangle(1,4,3,3);
		Rectangle rect2 = new Rectangle(0,5,4,3);
		
		//These do not intersect
		Rectangle rect3 = new Rectangle(0,0,3,5);
		Rectangle rect4 = new Rectangle(4,0,5,5);

		//Here, one rectangle is completely inside the other.
		//Area of intersection is 8
		Rectangle rect5 = new Rectangle(1,1,10,10);
		Rectangle rect6 = new Rectangle(2,2,4,2);

		//Case 1
		System.out.println("Area 1: " + rect1.area());
		System.out.println("Area 2: " + rect2.area());
		
		//Now, find the intersection of the two Rectangles
		Rectangle inter = Rectangle.intersect(rect1, rect2);
		
		//Show the area of the intersecting region
		System.out.println("Intersection (should be 6): " + inter.area());
		inter = Rectangle.intersect(rect2, rect1);
		System.out.println("Intersection (should be 6): " + inter.area());
		

		//Case 2
		System.out.println("Area 3: " + rect3.area());
		System.out.println("Area 4: " + rect4.area());
		inter = Rectangle.intersect(rect3, rect4);		
		System.out.println("Intersection (should be 0): " + inter.area());
		inter = Rectangle.intersect(rect4, rect3);		
		System.out.println("Intersection (should be 0): " + inter.area());
		
		//Case 3
		System.out.println("Area 5: " + rect5.area());
		System.out.println("Area 6: " + rect6.area());
		inter = Rectangle.intersect(rect5, rect6);		
		System.out.println("Intersection (should be 8): " + inter.area());
		inter = Rectangle.intersect(rect6, rect5);		
		System.out.println("Intersection (should be 8): " + inter.area());
		

	}

}
