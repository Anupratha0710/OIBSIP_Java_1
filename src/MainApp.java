import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainApp extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public MainApp() {
        setTitle("Online Exam Login");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);
        panel.add(new JLabel(""));
        loginButton = new JButton("Login");
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                int userId = Login.loginUser(username, password);

                if (userId != -1) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    Exam.startExam(userId); // Call your exam logic
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainApp().setVisible(true);
        });
    }
}
