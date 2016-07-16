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
        while (choice != 8) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    file.write(addMovie());
                    break;
                case 2:
                    file.delete(deleteMovie());
                    break;
                case 3:
                    file.modify(modifyMovie());
                    break;
                case 4:
                    file.search(searchByTitle());
                    break;
                case 5:
                    file.listAll();
                    break;
                case 6:
                    file.listAllYear(filterByYear());
                    break;
                case 7:

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
        System.out.println("Press 4 to search by title");
        System.out.println("Press 5 to get element list");
        System.out.println("Press 6 to filter by year");
        System.out.println("Press 7 to generate index file");
        System.out.println("Press 8 to exit");
    }

    private static Movie addMovie() {
        String name;
        int year;
        String genre;
        System.out.print("Enter movie name: ");
        name = scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Enter movie year: ");
        year = scanner.nextInt();
        System.out.print("Enter movie genre: ");
        genre = scanner.nextLine();
        genre = scanner.nextLine();
        return new Movie(name,year,genre,true);

    }

    private static String deleteMovie() {
        System.out.print("Enter the name you would like to delete: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    private static String searchByTitle() {
        System.out.println("Enter movie title: ");
        return scanner.nextLine();

    }

    private static int filterByYear() {
        System.out.println("Enter desired year: ");
        return scanner.nextInt();
    }

    private static Movie modifyMovie() {
        String name;
        String genre;
        int year;
        System.out.println("Enter the movie you want to modify: ");
        name = scanner.nextLine();
        name = scanner.nextLine();
        System.out.println("Enter new movie genre: ");
        genre = scanner.nextLine();
        System.out.println("Enter new movie year: ");
        year = scanner.nextInt();
        return new Movie(name, year, genre, true);
    }

    private static void generateIndex() {

    }
}
