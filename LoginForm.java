import java.awt.*;
import java.sql.*;
import javax.swing.*;
import com.formdev.flatlaf.FlatDarculaLaf;

public class LoginForm extends JFrame {
    final private Font mainFont = new Font("Baguet script", Font.BOLD, 18);
    static JTextField tfUsername;
    JPasswordField pfPassword;

    public void initialize(){
        /***************** FORM PANEL *****************/
        JLabel lbLoginForm = new JLabel("Login", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);

        JLabel lbUsername = new JLabel("Username");
        lbUsername.setFont(mainFont);

        tfUsername = new JTextField();
        tfUsername.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        //  JLabel lbSignUp = new JLabel ("Sign up", SwingConstants.CENTER);
        //  lbSignUp.setFont(mainFont);
        


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        /*************** Buttons Panel **************/
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(e -> {
            String username = tfUsername.getText();
            String password = String.valueOf(pfPassword.getPassword());

            User user = getAuthenticatedUser(username, password);

            if (user != null) {
                user.username = "Strendey";
                TelaInicial play = new TelaInicial(user);
                play.setVisible(true);
                play.setLocationRelativeTo(null);
                play.pack();
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(LoginForm.this,
                    "Email or Password Invalid",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(mainFont);
        btnRegister.addActionListener(e -> {
            RegisterForm registerForm3 = new RegisterForm();
            registerForm3.pack();
            registerForm3.setVisible(true);
            registerForm3.setLocationRelativeTo(null);
            dispose();
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnRegister);



        /*************** Initialise the frame  **************/
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH); 

        setTitle("Login - PyQuizz");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        //setExtendedState(MAXIMIZED_BOTH);
    }


    private User getAuthenticatedUser(String username, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/bdprojeto";
        final String USERNAME = "root";
        final String PASSWORD = "2603";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfuly...
            
            String sql = "SELECT * FROM register WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }

            preparedStatement.close();
            conn.close();

        }catch (Exception e){
            System.out.println("database connexion failed!");
        }


        return user;
    }

    public LoginForm(){
        initialize();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex) {
            System.err.println( "Failed to initialize LaF" );
        }
        LoginForm  loginForm = new LoginForm();
        
        loginForm.initialize();
    }

}