package com.User;

public class UserDetails {
	private int id;
    private String nameString;
    private String emailString;
    private String password;

    public UserDetails() {
        super();
    }

    public UserDetails(String nameString, String emailString, String password) {
        this.nameString = nameString;
        this.emailString = emailString;
        this.password = password;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getEmailString() {
        return emailString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
