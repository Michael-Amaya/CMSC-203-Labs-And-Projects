
public class Function1 extends Function{

	@Override
	public String answerString(double optVal, double x, double y, double z) {
		return String.format("Minimum cost is $%.2f with height = %.2f cm and radius = %.2fcm", optVal, y, x);
	}

	@Override
	public double fnValue(double x) {
		if (x <= 0) {
			return Double.MAX_VALUE;
		} else {
			return (0.8 * Math.PI * Math.pow(x, 2)) + (800/x);
		}
	}

	@Override
	public double getXVal(double x) {
		return x;
		
	}

	@Override
	public double getYVal(double x) {
		return 2000 / (Math.PI * Math.pow(x, 2));
	}

	@Override
	public double getZVal(double x) {
		// Unused
		return 0;
	}

	@Override
	
	public String toString() {
		return "Minimize the cost of the can that will hold 2 liters of liquid";
	}

}
