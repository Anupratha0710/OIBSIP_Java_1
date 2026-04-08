import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        int userId = Login.loginUser(username, password);

        if (userId != -1) {
            System.out.println("✅ Login Successful!");
            Exam.startExam(userId);
        } else {
            System.out.println("❌ Invalid Username or Password");
        }
    }
}
