package Model;

public class User {

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    int userID;

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    String userName;

}
