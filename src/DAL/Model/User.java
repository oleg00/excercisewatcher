package DAL.Model;

public class User {

    private int _id;
    private String _login;
    private String _passwordHash;

    public User(String login, String passwordHash) {
        SetLogin(login);
        SetPasswordHash(passwordHash);
    }

    public User(int id, String login, String passwordHash) {
        this(login, passwordHash);
        SetId(id);
    }
    
    public int GetId() {
        return _id;
    }

    public void SetId(int value) {
        _id = value;
    }

    public String GetLogin() {
        return _login;
    }

    public void SetLogin(String value) {
        _login = value;
    }

    public String GetPasswordHash() {
        return _passwordHash;
    }

    public void SetPasswordHash(String value) {
        _passwordHash = value;
    }

}
