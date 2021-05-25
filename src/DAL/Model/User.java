package DAL.Model;

public class User {

    private int _id;
    private String _login;
    private String _passwordHash;

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
