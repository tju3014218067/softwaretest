package triangle;

public class judgetriangle {
	public boolean equilateral(int a, int b, int c){
		if(a == b && a == c){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isosceles(int a, int b, int c){
		if(a == b || a == c || b == c){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean scalene(int a, int b, int c){
		if(a != b && a != c){
			return true;
		}
		else {
			return false;
		}
	}
	
}
