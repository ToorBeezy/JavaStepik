package userServer;

@SuppressWarnings("UnusedDeclaration")
public interface UserServerControllerMBean {

    public int getUsers();

    public int getUsersLimit();

    public void setUsersLimit(int usersLimit);
    
}