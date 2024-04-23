package userServer;


public class UserServer implements UserServerImplement {
    
    private int usersCount = 0;
    private int usersLimit;

    public UserServer(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    public UserServer() {
        this.usersLimit = 10;
    }

    @Override
    public void addNewUser() {
        usersCount += 1;
    }

    @Override
    public void removeUser() {
        usersCount -= 1;
    }

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    @Override
    public int getUsersCount() {
        return usersCount;
    }
}
