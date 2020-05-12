
public class Function1 extends Function{

	@Override
	public String answerString(double optVal, double x, double y, double z) {
		return String.format("The minimum amount of time is %.2f hours, when running %.2f miles on shore and swimming %.2f miles.", optVal, x, y);
	}

	@Override
	public double fnValue(double x) {
		if (x <= 0.0)
			return Double.MAX_VALUE;
		else
			return (x / 8) + ((Math.sqrt(Math.pow(6 - x, 2) + 4)) / 3);
	}

	@Override
	public double getXVal(double x) {
		return x;
	}

	@Override
	public double getYVal(double x) {
		return Math.sqrt(Math.pow(6 - x, 2) + 4);
	}

	@Override
	public double getZVal(double x) {
		// Unused
		return 0;
	}

	@Override
	public String toString() {
		return "Minimize the amount of time it will take to get to the island";
	}
}
