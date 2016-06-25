import java.io.IOException;
import java.util.Scanner;

/**
 * Created by matias on 6/22/16.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        MovieFile file = new MovieFile("MovieFile");
        int choice = 0;
        while (choice != 7) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    file.addMovieRegister(addMovie());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Please enter a valid number");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("Press 1 to add element");
        System.out.println("Press 2 to remove element");
        System.out.println("Press 3 to modify element");
        System.out.println("Press 4 to get element information");
        System.out.println("Press 5 to get element list");
        System.out.println("Press 6 to get element with certain condition");
        System.out.println("Press 7 to exit");
    }

    private static Movie addMovie() {
        String name;
        int year;
        boolean child;
        String genre;
        System.out.println("Enter movie name: ");
        name = scanner.nextLine();
        System.out.println("Enter movie year: ");
        year = scanner.nextInt();
        System.out.println("Is the movie rated E (Y/N): ");
        child = scanner.nextLine().toLowerCase().equals("y");
        System.out.println("Enter movie genre: ");
        genre = scanner.nextLine();
        return new Movie(name,year,genre,child);

    }
}
