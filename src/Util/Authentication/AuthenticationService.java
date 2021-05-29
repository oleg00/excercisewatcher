package Util.Authentication;

import DAL.Model.User;
import DAL.Repository.UserRepository;
import Util.Exception.DbException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Authentication Helper Class.
 */
public class AuthenticationService {

    private final UserRepository _userRepository;

    public AuthenticationService() throws DbException {
        _userRepository = new UserRepository();
    }

    /**
     * Checks whether user exists and registers it if user does not exist.
     * @param login - user login
     * @param password - password hash
     * @return - whether user exists
     */
    public boolean UserExists(String login, String password) {
        var user = _userRepository.Get(login);
        var checkResult = false;
        if (user != null) {
            checkResult = user.GetLogin() == login && user.GetPasswordHash() == password;
        }
        else {
            RegisterUser(login, password);
        }
        return checkResult;
    }

    /**
     * Adds user to the UserRepository.
     * @param login - user login
     * @param password - plain password which is being hashed using Apache DigestUtils MD5 Hashing
     */
    private void RegisterUser(String login, String password) {
        String passwordHash = DigestUtils.md5Hex(password).toUpperCase();
        _userRepository.Add(new User(login, passwordHash));
    }
}
