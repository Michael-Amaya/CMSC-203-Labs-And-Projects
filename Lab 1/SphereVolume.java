import java.util.Scanner;

public class SphereVolume{
	public static void main(String[] args){
		double diam;
		double radius;
		double volume;
		Scanner input = new Scanner(System.in);
		
		System.out.println("The purpose of this program is to "+
		"calculate the volume of a sphere");
		
		System.out.print("Please input the diameter of a sphere: ");
		diam = input.nextDouble();
		
		radius = diam / 2.0;
		
		volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		
		System.out.printf("The volume is %.2f%s", volume, ".");
	}
}