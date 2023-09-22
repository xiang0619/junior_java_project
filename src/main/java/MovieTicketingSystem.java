import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class MovieTicketingSystem {
    private Customer loggedInCustomer;
    private ArrayList<Movie> movies;
    private ArrayList<Schedule> schedules;
    private ArrayList<Hall> halls;
    private ArrayList<Seat> seats;
    private ArrayList<Customer> customers;

    public MovieTicketingSystem() {
        movies = new ArrayList<Movie>();
        schedules = new ArrayList<Schedule>();
        halls = new ArrayList<Hall>();
        seats = new ArrayList<Seat>();
        customers = new ArrayList<Customer>();
        initializeMovies();
        initializeHalls();
        initializeSeats();
        initializeSchedules();
        initializeCustomers();
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
    
    private void initializeHalls(){
        try{
            Hall hall1 = new Hall("H01",120,seats);
            Hall hall2 = new Hall("H02",120,seats);
            
            halls.add(hall1);
            halls.add(hall2);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void initializeSchedules(){
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

    private void initializeSeats(){
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
    
    private void initializeCustomers(){
        Customer customer1 = new Customer("user1","password",'M',"123-456-7890");
        Customer customer2 = new Customer("user2","password",'F',"987-654-3210");
        Customer customer3 = new Customer("user3","password",'M',"555-123-4567");
        Customer customer4 = new Customer("user4","password",'F',"444-654-3210");
        Customer customer5 = new Customer("user5","password",'M',"333-654-3210");
        
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }

    private boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        
        int i = 0;
        
        for(Customer customer:customers){
            if(customer.getUsername().equals(username) && customer.getPassword().equals(password)){
                loggedInCustomer = customers.get(i);
                return true;
            }
            i++;
        }
        
        return false;
    }
    
    private boolean register(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        System.out.println("Please enter your gender(M/F): ");
        char gender = scanner.nextLine().charAt(0);

        System.out.println("Please enter your phone number: ");
        String phone = scanner.nextLine();
        
        customers.add(new Customer(username,password,gender,phone));
        
        return true;
    }

    public void logout() {
        loggedInCustomer = null;
        System.out.println("Logged out successfully.");
    }

    public void displayLoggedInMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println();
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
            System.out.println("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println();
                    System.out.println();
                    System.out.println("Register : ");
                    
                    if(ticketingSystem.register()){
                        
                    }else{
                        System.out.println("Invalid information, please enter correct account information.");
                    }
                    break;
                case 2:
                    scanner.nextLine(); // Consume the newline character
                    
                    System.out.println();
                    System.out.println();
                    System.out.println("Login : ");
                    
                    if(ticketingSystem.login()){
                        ticketingSystem.displayLoggedInMenu();
                    }else{
                        System.out.println("Invalid information, please enter correct account information.");
                    }
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
