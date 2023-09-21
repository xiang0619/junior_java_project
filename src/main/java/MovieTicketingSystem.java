    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    import java.util.Random;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    public class MovieTicketingSystem {
        private UserDatabase userDatabase;
        private Customer loggedInCustomer;
        private List<Movie> movies;
        private List<Schedule> schedules;

        public MovieTicketingSystem() {
            userDatabase = new UserDatabase();
            loggedInCustomer = null;
            movies = new ArrayList<Movie>();
            schedules = new ArrayList<Schedule>();
            initializeMovies();
            initializeSchedules();
        }

        private void initializeMovies() {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date releaseDate1 = dateFormat.parse("2023-09-20");
                Date releaseDate2 = dateFormat.parse("2023-10-15");

                Movie movie1 = new Movie("Movie 1", "M001", "Action", releaseDate1, 120);
                Movie movie2 = new Movie("Movie 2", "M002", "Comedy", releaseDate2, 105);

                movies.add(movie1);
                movies.add(movie2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

      private void initializeSchedules() {
        Random random = new Random();
        for (Movie movie : movies) {
            Hall hall1 = new Hall("H001", 100); // Create a Hall object
            for (int i = 1; i <= 5; i++) {
                int hour = random.nextInt(12) + 1; // Random hour (1-12)
                int minute = random.nextInt(4) * 15; // Random minute (0, 15, 30, 45)

                // Create a SimpleDateFormat for date and time
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
                String dateStr = "20/09/2023 " + String.format("%02d:%02d:00 %s", hour, minute, hour < 12 ? "AM" : "PM");
                try {
                    Date scheduleDate = dateFormat.parse(dateStr);
                    Schedule schedule = new Schedule(hall1, movie, scheduleDate); // Use hall1
                    schedules.add(schedule);
                } catch (ParseException e) {
                    // Skip this schedule if date parsing fails
                }
            }
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

                switch (choice) {
                    case 1:
                        displayProfile();
                        break;
                    case 2:
                        changePassword();
                        break;
                    case 3:
                        viewMovies();
                        break;
                    case 4:
                        logout();
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }

        public void displayProfile() {
            if (loggedInCustomer != null) {
                System.out.println("Profile Details:");
                System.out.println("Username: " + loggedInCustomer.getUsername());
                System.out.println("Gender: " + loggedInCustomer.getGender());
                System.out.println("Phone Number: " + loggedInCustomer.getPhoneNumber());
            }
        }

        public void viewMovies() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getMovieName());
        }

        System.out.println("Enter the number of the movie you want to watch, or enter 0 to go back:");
        int movieChoice = scanner.nextInt();

        if (movieChoice == 0) {
            return; // Go back to the main menu
        }

        if (movieChoice < 1 || movieChoice > movies.size()) {
            System.out.println("Invalid movie selection.");
            return;
        }

        Movie selectedMovie = movies.get(movieChoice - 1);

        // Now, pass the selected movie to the viewSchedules method
        viewSchedules(selectedMovie);
    }


        public void viewSchedules(Movie selectedMovie) {
        List<Schedule> movieSchedules = schedules.stream()
                .filter(schedule -> schedule.getMovie().equals(selectedMovie))
                .collect(Collectors.toList());

        if (movieSchedules.isEmpty()) {
            System.out.println("No schedules available for this movie.");
        } else {
            System.out.println("Movie Schedules for " + selectedMovie.getMovieName() + ":");
            for (int i = 0; i < movieSchedules.size(); i++) {
                System.out.println((i + 1) + ". " + movieSchedules.get(i));
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of the schedule you want to choose, or enter 0 to go back:");
            int scheduleChoice = scanner.nextInt();

            if (scheduleChoice == 0) {
                return; // Go back to the main menu
            }

            if (scheduleChoice < 1 || scheduleChoice > movieSchedules.size()) {
                System.out.println("Invalid schedule selection.");
                return;
            }

            Schedule selectedSchedule = movieSchedules.get(scheduleChoice - 1);

            // Now, display the available seats for the selected schedule
            selectedSchedule.displaySeats();

            System.out.println("Enter the seat ID you want to choose, or enter 0 to go back:");
            String seatChoice = scanner.next();

            if (seatChoice.equals("0")) {
                return; // Go back to the main menu
            }

            boolean seatReserved = selectedSchedule.reserveSeat(seatChoice);

            if (seatReserved) {
                System.out.println("Seat " + seatChoice + " has been reserved.");
            } else {
                System.out.println("Failed to reserve seat " + seatChoice + ". Please try again.");
            }
        }
    }



        public void changePassword() {
            Scanner scanner = new Scanner(System.in);
            if (loggedInCustomer != null) {
                System.out.println("Enter your new password: ");
                String newPassword = scanner.nextLine();
                loggedInCustomer.changePassword(newPassword);
                System.out.println("Password changed successfully.");
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