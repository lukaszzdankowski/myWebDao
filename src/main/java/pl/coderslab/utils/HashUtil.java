package pl.coderslab.utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }
}
