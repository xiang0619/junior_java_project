class Customer {
	//data properties
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private String gender;
    private String phoneNumber;
    
    //methods
    public Customer(String username, String password, String securityQuestion, String securityAnswer, String gender, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods for gender and phone number and others
    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
