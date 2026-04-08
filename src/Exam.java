import java.sql.*;
import java.util.*;

public class Exam {

    public static void startExam(int userId) {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM questions");

            Scanner sc = new Scanner(System.in);
            int score = 0;

            long startTime = System.currentTimeMillis();

            while (rs.next()) {

                System.out.println("\n" + rs.getString("question_text"));
                System.out.println("A. " + rs.getString("option_a"));
                System.out.println("B. " + rs.getString("option_b"));
                System.out.println("C. " + rs.getString("option_c"));
                System.out.println("D. " + rs.getString("option_d"));

                System.out.print("Enter answer (A/B/C/D): ");
                String answer = sc.next().toUpperCase();

                if (answer.equals(rs.getString("correct_option"))) {
                    score++;
                }
            }

            long endTime = System.currentTimeMillis();

            System.out.println("\n✅ Your Score: " + score);
            System.out.println("⏱ Time Taken: " + (endTime - startTime)/1000 + " seconds");

            saveResult(userId, score);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void saveResult(int userId, int score) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO results(user_id, score) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userId);
            ps.setInt(2, score);

            ps.executeUpdate();

            System.out.println("Result saved successfully!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
