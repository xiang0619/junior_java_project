public abstract class Register {
    protected String userName;
    protected String password;
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString() {
        return ("\nUserName : " + userName + "\nPassword : " + password);
    }
}