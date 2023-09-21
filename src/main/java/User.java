public class User {
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;

    public User(String username, String password, String securityQuestion, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }
    
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public boolean verifySecurityAnswer(String providedAnswer) {
        return securityAnswer.equals(providedAnswer);
    }
    
    public String getUsername() {
        return username;
    }
    
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}