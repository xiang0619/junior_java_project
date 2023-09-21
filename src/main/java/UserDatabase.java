import java.util.HashMap;
import java.util.Map;
class UserDatabase {
	//data properties
    private Map<String, Customer> users;

    public UserDatabase() {
        users = new HashMap<>();//stores customer's inputed information 
    }
    //methods
    public boolean registerUser(String username, String password, String securityQuestion, String securityAnswer, String gender, String phoneNumber) {
        if (!users.containsKey(username)) {
            Customer newCustomer = new Customer(username, password, securityQuestion, securityAnswer, gender, phoneNumber);
            users.put(username, newCustomer);
            return true;
        }
        return false;
    }

    public Customer getUser(String username) {
        return users.get(username);
    }
}

