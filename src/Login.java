import java.sql.*;

public class Login {

    public static int loginUser(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT id FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); // return user_id
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return -1; // login failed
    }
}