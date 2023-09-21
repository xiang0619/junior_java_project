
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Random;


public class MovieTicketingSystem {
    private UserDatabase userDatabase;
    private Customer loggedInCustomer;
    private ArrayList<Movie> movies;
    private ArrayList<Schedule> schedules;
    private ArrayList<Hall> halls;
    private ArrayList<Seat> seats;

    public MovieTicketingSystem() {
        userDatabase = new UserDatabase();
        loggedInCustomer = null;
        movies = new ArrayList<Movie>();
        schedules = new ArrayList<Schedule>();
        initializeMovies();
        initializeHall();
        initializeSeat();
        initializeSchedule();
    }

    private void initializeMovies() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date releaseDate1 = dateFormat.parse("2023-09-20");
            Date releaseDate2 = dateFormat.parse("2023-10-15");

            Movie movie1 = new Movie("Movie 1", "M001", "Action", releaseDate1, 120, 15.00);
            Movie movie2 = new Movie("Movie 2", "M002", "Comedy", releaseDate2, 105, 16.00);

            movies.add(movie1);
            movies.add(movie2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    private void initializeHall(){
        try{
            Hall hall1 = new Hall("H01",120,seats);
            Hall hall2 = new Hall("H02",120,seats);
            
            halls.add(hall1);
            halls.add(hall2);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void initializeSchedule(){
        int i = 0;
        for(Movie movie : movies){
            try{
                schedules.add(new Schedule(halls.get(i),movie,"13:00","14:00"));
                
            }catch(Exception ex){
                ex.printStackTrace();
                break;
            }
            i++;
        }
    }

    private void initializeSeat(){
        try{
            Seat seat = new Seat();
            for (char letter = 'a'; letter <= 'j'; letter++) {
                for (int number = 1; number <= 12; number++) {
                    String id = String.valueOf(letter) + number;
                    Random random = new Random();
                    boolean randomBoolean = random.nextBoolean();
                    
                    seat.setSeatID(id);
                    seat.setSeatStatus(randomBoolean);
                    
                    seats.add(seat);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void registerCustomer(String username, String password, String securityQuestion, String securityAnswer, String gender, String phoneNumber) {
        if (userDatabase.registerUser(username, password, securityQuestion, securityAnswer, gender, phoneNumber)) {
            System.out.println("Registration successful. You can now log in.");
        } else {
            System.out.println("Username is already taken. Please choose a different one.");
        }
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        Customer customer = userDatabase.getUser(username);

        if (customer != null && customer.authenticate(username, password)) {
            loggedInCustomer = customer;
            System.out.println("Login successful. Welcome, " + customer.getUsername() + "!");
            displayLoggedInMenu();
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }

    public void logout() {
        loggedInCustomer = null;
        System.out.println("Logged out successfully.");
    }

    public void displayLoggedInMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Logged-in Menu");
            System.out.println("1. View Profile");
            System.out.println("2. Change Password");
            System.out.println("3. View Movies");
            System.out.println("4. Logout");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            
        }
    }

    public static void main(String[] args) {
        MovieTicketingSystem ticketingSystem = new MovieTicketingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Movie Ticketing System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter your details to register:");
                    System.out.print("Username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Password: ");
                    String regPassword = scanner.nextLine();
                    System.out.print("Security Question: ");
                    String regSecurityQuestion = scanner.nextLine();
                    System.out.print("Security Answer: ");
                    String regSecurityAnswer = scanner.nextLine();
                    System.out.print("Gender: ");
                    String regGender = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String regPhoneNumber = scanner.nextLine();

                    ticketingSystem.registerCustomer(regUsername, regPassword, regSecurityQuestion, regSecurityAnswer, regGender, regPhoneNumber);
                    break;
                case 2:
                    scanner.nextLine(); // Consume the newline character
                    ticketingSystem.login();
                    break;
                case 3:
                    System.out.println("Exiting Movie Ticketing System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
