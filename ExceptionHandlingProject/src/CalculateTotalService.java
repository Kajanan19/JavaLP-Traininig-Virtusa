import java.io.IOException;
import java.util.InputMismatchException;

public class CalculateTotalService  {
	double total;
	//Calcualte the total
	public double calculateTotal(double total, double discount) throws ItemsNotFoundException {
		return total=total-discount;
	}
}
