package userServer;

public class UserServerController implements UserServerControllerMBean {
    
    private final UserServerImplement accountServer;

    public UserServerController(UserServerImplement accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    public int getUsers() {
        return accountServer.getUsersCount();
    }

    @Override
    public int getUsersLimit() {
        return accountServer.getUsersLimit();
    }

    @Override
    public void setUsersLimit(int lim) {
        accountServer.setUsersLimit(lim);
    }
}
