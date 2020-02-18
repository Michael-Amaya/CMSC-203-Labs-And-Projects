import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Movie movie = new Movie();
		boolean keepGoing = true;
		
		do {
			System.out.print("Please enter a movie name: ");
			String movieName = input.nextLine();
			movie.setTitle(movieName);
			
			System.out.print("Please enter the movie's rating: ");
			String movieRating = input.nextLine();
			movie.setRating(movieRating);
			
			System.out.print("Please enter the tickets sold for movie: ");
			int movieTicketsSold = Integer.parseInt(input.nextLine());
			movie.setSoldTickets(movieTicketsSold);
			
			System.out.println(movie.toString());
			
			System.out.print("Do you want to enter another (y or n)?: ");
			char answer = input.nextLine().charAt(0);
			
			switch(answer) {
			case 'y':
			case 'Y':
				keepGoing = true;
				break;
			case 'n':
			case 'N':
				keepGoing = false;
				break;
			default:
				keepGoing = false;	
			}
		} while(keepGoing == true);
		
		input.close();
		System.out.println("Goodbye");
	}

}
