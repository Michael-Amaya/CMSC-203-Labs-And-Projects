
public class Function2 extends Function{

	@Override
	public String answerString(double optVal, double x, double y, double z) {
		return String.format("The minimum time is %.2f seconds to jump into the ocean %.2fmeters from the starting point", optVal, x);
	}

	@Override
	public double fnValue(double x) {
		return (x/3) + (2 *  Math.sqrt(Math.pow(x,2)- 8 * x + 25));
	}

	@Override
	public double getXVal(double x) {
		return x;
	}

	@Override
	public double getYVal(double x) {
		// Unused
		return 0;
	}

	@Override
	public double getZVal(double x) {
		// Unused
		return 0;
	}
	
	@Override
	public String toString() {
		return "Minimize the distance a dog will run and swim to retrieve a ball in the ocean";
	}
}
