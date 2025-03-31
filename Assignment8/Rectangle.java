package Assignment8;
public class Rectangle {

	//Fields for the location and size of the rectangle
	
	//Top-left corner of the rectangle is at (x, y)
	private int x;
	private int y;
	private int width;
	private int height;
	
	//Constructor
	public Rectangle(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
	
	/**
	 * Find the intersection of two Rectangles
	 * 
	 * Returns a new Rectangle, representing the region of intersection
	 * of two Rectangles.  Note that the area of the returned rectangle may be 0
	 * 
	 * @param r1  The first Rectangle
	 * @param r2  The second Rectangle
	 * @return    The region of intersection.  May have an area of zero, but will never by null.
	 */
	public static Rectangle intersect(Rectangle r1, Rectangle r2) {
		// Find the left, right, top, and bottom boundaries of the region of intersection
		int left = Math.max(r1.getLeft(), r2.getLeft());
		int right = Math.min(r1.getRight(), r2.getRight());
		int top = Math.max(r1.getTop(), r2.getTop());
		int bottom = Math.min(r1.getBottom(), r2.getBottom());
	
		// Calculate the width and height of the new Rectangle
		int width = right - left;
		int height = bottom - top;
	
		// Make sure the width and height are not negative (if they are, make them zero)
		if (width < 0 || height < 0) {
			width = 0;
			height = 0;
		}
	
		// Return the new Rectangle representing the intersection
		return new Rectangle(left, top, width, height);
	}
	
	/**
	 * Calculate the area of the Rectangle.
	 * 
	 * This method returns the area of this rectangle object.
	 * 
	 * @return The area of this Rectangle
	 */
	public int area()
	{
		return this.width*this.height;
	}
	


	
	//Get the value of x 
	public int geX()
	{
		return this.x;
	}

	//Get the value of y
	public int getY()
	{
		return this.y;
	}
	
	//Get the width of the rectangle
	public int getWidth()
	{
		return this.width;
	}
	
	//Get the height of the rectangle
	public int getHeight()
	{
		return this.height;
	}

	//Get the x-coordinate of the left side of the rectangle
	public int getLeft()
	{
		return this.x;
	}
	
	//Get the x-coordinate of the right side of the rectangle
	public int getRight()
	{
		return this.x + this.width;
	}
	
	//Get the y-coordinate of the top of the rectangle
	public int getTop()
	{
		return this.y;
	}
	
	//Get the y-coordinate of the bottom of the rectangle
	public int getBottom()
	{
		return this.y + this.height;
	}

}
