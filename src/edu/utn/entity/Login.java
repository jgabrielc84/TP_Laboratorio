package edu.utn.entity;

public class Login {

    private static int maxAttempts = 3; // Esto tiene que leerse de la base de datos?
    private String user;
    private String password;
    private int attempts;
    private boolean blocked;

    public Login() {

    }

    public Login(String user, String password) { // REVISAR (borrar??)
        this.setUser(user);
        this.setPassword(password);
    }

    public static int getmaxAttempts() {
        return maxAttempts;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    
    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}