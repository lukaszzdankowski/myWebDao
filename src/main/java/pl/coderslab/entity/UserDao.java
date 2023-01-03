package pl.coderslab.entity;

import pl.coderslab.utils.DbUtil;
import pl.coderslab.utils.HashUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String READ_USER_QUERY =
            "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USER_QUERY =
            "SELECT * FROM users";

    public static User create(User user) {
        try (Connection conn = DbUtil.connection()) {

            PreparedStatement prepStat = conn.prepareStatement(CREATE_USER_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            prepStat.setString(1, user.getUserName());
            prepStat.setString(2, user.getEmail());
            prepStat.setString(3, HashUtil.hashPassword(user.getPassword()));
            prepStat.executeUpdate();
            ResultSet rs = prepStat.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            return user;

        } catch (SQLException e) {
            System.out.println("ERROR in UserDao.create");
            e.printStackTrace();
            return null;
        }
    }

    public static User read(int userId) {
        try (Connection conn = DbUtil.connection()) {

            PreparedStatement prepStat = conn.prepareStatement(READ_USER_QUERY);
            prepStat.setInt(1, userId);
            ResultSet rs = prepStat.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("ERROR in UserDao.read");
            e.printStackTrace();
            return null;
        }
    }

    public static void update(User user) {
        try (Connection conn = DbUtil.connection()) {

            PreparedStatement prepStat = conn.prepareStatement(UPDATE_USER_QUERY);
            prepStat.setString(1, user.getUserName());
            prepStat.setString(2, user.getEmail());
            prepStat.setString(3, HashUtil.hashPassword(user.getPassword()));
            prepStat.setInt(4, user.getId());
            prepStat.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR in UserDao.update");
            e.printStackTrace();
        }
    }

    public static void delete(int userId) {
        try (Connection conn = DbUtil.connection()) {

            PreparedStatement prepStat = conn.prepareStatement(DELETE_USER_QUERY);
            prepStat.setInt(1, userId);
            prepStat.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR in UserDao.delete");
            e.printStackTrace();
        }
    }

    public static User[] findAll() {
        try (Connection conn = DbUtil.connection()) {

            User[] users = new User[0];
            PreparedStatement prepStat = conn.prepareStatement(FIND_ALL_USER_QUERY);
            ResultSet rs = prepStat.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("username"),
                        rs.getString("email"), rs.getString("password"));
                users = addToUsers(users, user);
            }
            return users;

        } catch (SQLException e) {
            System.out.println("ERROR in UserDao.findAll");
            e.printStackTrace();
            return null;
        }
    }

    private static User[] addToUsers(User[] users, User user) {
        User[] newTab = Arrays.copyOf(users, users.length + 1);
        newTab[newTab.length - 1] = user;
        return newTab;
    }
}