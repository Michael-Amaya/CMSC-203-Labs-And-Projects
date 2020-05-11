
public class Function3 extends Function{

	@Override
	public String answerString(double optVal, double x, double y, double z) {
		// TODO Auto-generated method stub
		return String.format("The minimum distance tp (0,1) on parabola x^2 is %.2f units at the points: (%.2f, %.2f), (%.2f, %.2f)", optVal, x, y, -x, y);
	}

	@Override
	public double fnValue(double x) {
		return Math.sqrt(Math.pow(x, 4) - Math.pow(x, 2) + 1);
	}

	@Override
	public double getXVal(double x) {
		return x;
	}

	@Override
	public double getYVal(double x) {
		return Math.pow(x, 2);
	}

	@Override
	public double getZVal(double x) {
		// Unused
		return 0;
	}

	@Override
	public String toString() {
		return "Find the minimum distance between the function f(x) = x^2 and the point (0,1)";
	}
}
