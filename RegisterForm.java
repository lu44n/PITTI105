import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

public class RegisterForm extends JFrame{
    final private Font mainFont = new Font("Baguet script", Font.BOLD, 18);
    JTextField tfUsername;
    JPasswordField pfPassword;

    public void initialize(){
        /*************** FORM PANEL ***************/
        JLabel lbRegister = new JLabel ("Register", SwingConstants.CENTER);
        lbRegister.setFont(mainFont);

        JLabel lbUsername = new JLabel ("Username");
        lbUsername.setFont(mainFont);

        tfUsername = new JTextField();
        tfUsername.setFont(mainFont);

        JLabel lbPassword = new JLabel ("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.add(lbRegister);
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        /*************** BUTTONS PANEL ***************/
        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(mainFont);
        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String password = new String(pfPassword.getPassword());

                String msg = "" + username;
                msg += " \n";
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdprojeto", "root", "2603");

                    String query = "INSERT INTO register values('" + username + "','" +
                        password + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnRegister, "This is already exist!");
                    } else {
                        JOptionPane.showMessageDialog(btnRegister,
                            "Welcome, " + msg + "Your account is sucessfully created!");
                    }
                    connection.close();
                    dispose();
                    LoginForm loginForm = new LoginForm();
                    loginForm.pack();
                    loginForm.setVisible(true);
                    loginForm.setLocationRelativeTo(null);
                } catch (Exception exception) {
                    //exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "This username already exists!");
                }
            }
        });
        JButton btnBack = new JButton("Back");
        btnBack.setFont(mainFont);
        btnBack.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm();
                loginForm.pack();
                loginForm.setVisible(true);
                loginForm.setLocationRelativeTo(null);
                dispose();
            }

        });
    
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 2, 10, 10));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        btnPanel.add(btnRegister);
        btnPanel.add(btnBack);


        /************** INITIALISE THE FRAME **************/
        add(formPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);

        setTitle("Register - PyQuizz");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public RegisterForm(){
        initialize();
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel( new FlatDarculaLaf() );
                } catch( Exception ex ) {
                    System.err.println( "Failed to initialize LaF" );
                }
                try {
                    RegisterForm frame = new RegisterForm();
                    frame.initialize();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

