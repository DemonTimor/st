package pkg;

public class Triangle {

	public boolean givable(int x) throws IllegalArgumentException {
		
		if (x <= 0)
			throw new IllegalArgumentException();
		
		else {
			
			if (x >= 50)
				x -= 50;
			
			if (x >= 20)
				x -= 20;
			
			if (x >= 5)
				x -= 5;
			
			if (x >= 5)
				x -= 5;
			
			if (x >= 1)
				x -= 1;
			
			if (x >= 1)
				x -= 1;
			
			if (x >= 1)
				x -= 1;
			
			if (x != 0)
				return false;
			
			return true;
		}
	}
}
