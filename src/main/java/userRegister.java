import java.util.Scanner;
public class userRegister {

    static Register register = new Register() {};

    public static void main( String[] args) {

          try(Scanner scanner = new Scanner(System.in)){  
System.out.print("\n-------------------------------------------------------------\n");
            System.out.print("\nEnter Username => ");
            String userName = scanner.nextLine();
            register.setUserName(userName);
System.out.print("\n-------------------------------------------------------------\n");
            System.out.print("\nEnter Password => ");
            String password = scanner.nextLine();
            register.setPassword(password);
            
            
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("\n These are your personal registration that you have input!");
            System.out.println("\n-------------------------------------------------------------");
            System.out.println(register.toString());
          }
    }
}
