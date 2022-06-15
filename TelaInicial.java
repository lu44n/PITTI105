import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TelaInicial extends javax.swing.JFrame {
    static User user = new User();
    
    public TelaInicial(User user) {
        System.out.println("UserC: " + user);
        TelaInicial.user = user;
        initComponents();
    }
                        
    private void initComponents() {
        pyPanel = new JPanel();
        lbPyQuizz = new JLabel();
        btnPanel = new JPanel();
        btnRanking = new JButton();
        btnPlay = new JButton();
        btnCredits = new JButton();
        welcomePanel = new JPanel();
        lbWelcome = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("PyQuizz!");
        setPreferredSize(new Dimension(423, 380));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pyPanel.add(lbPyQuizz);
        pyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPyQuizz.setFont(new Font("Eras Demi ITC", 0, 48)); // NOI18N
        lbPyQuizz.setForeground(new Color(255, 255, 255));
        lbPyQuizz.setHorizontalAlignment(SwingConstants.CENTER);
        lbPyQuizz.setText("PyQuizz");
        lbPyQuizz.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 255, 255)));
        pyPanel.add(lbPyQuizz, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, 60));

        getContentPane().add(pyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 80));

        btnPanel.add(btnPlay);
        btnPanel.add(btnRanking);
        btnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRanking.setBackground(new Color(0, 0, 0));
        btnRanking.setFont(new Font("Segoe UI Semibold", 3, 22)); // NOI18N
        btnRanking.setForeground(new Color(255, 255, 255));
        btnRanking.setText("Ranking");
        btnRanking.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 255, 255)));
        btnRanking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });
        btnPanel.add(btnRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 140, 40));

        btnPlay.setBackground(new Color(0, 0, 0));
        btnPlay.setFont(new Font("Segoe UI Semibold", 3, 22)); // NOI18N
        btnPlay.setForeground(new Color(255, 255, 255));
        btnPlay.setText("Play");
        btnPlay.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0, 255, 255)));
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        btnPanel.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 140, 40));

        btnCredits.setBackground(new Color(0, 0, 0));
        btnCredits.setFont(new Font("Segoe UI Semibold", 3, 18)); // NOI18N
        btnCredits.setForeground(new Color(255, 255, 255));
        btnCredits.setText("Credits");
        btnCredits.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0, 255, 255)));
        btnCredits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCreditsActionPerformed(evt);
            }
        });
        btnPanel.add(btnCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 50, 90, 35));

        getContentPane().add(btnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 410, 100));

        welcomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbWelcome.setFont(new Font("Eras Demi ITC", 0, 20));
        lbWelcome.setForeground(new Color(0, 255, 255));
        lbWelcome.setText("Welcome to PyQuizz!");
        welcomePanel.add(lbWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -20, 410, 100));

        getContentPane().add(welcomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 410, 100));

        pack();
    }                       

    private void btnRankingActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        Ranking ranking = new Ranking();
        ranking.pack();
        ranking.setVisible(true);
        ranking.setLocationRelativeTo(null);
    }                                          

    private void btnPlayActionPerformed(ActionEvent evt) {                                        
        // TODO add your handling code here:
        Quiz pyQuizz = new Quiz();
        pyQuizz.pack();
        pyQuizz.setVisible(true);
        pyQuizz.setLocationRelativeTo(null);
        dispose();
    }
    
    private void btnCreditsActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
        Credits credits = new Credits();
        credits.pack();
        credits.setVisible(true);
        credits.setLocationRelativeTo(null);
    }
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        EventQueue.invokeLater(() -> {
            new TelaInicial(user).setVisible(true);
        });
    }
                   
    private JPanel btnPanel;
    private JButton btnPlay;
    private JButton btnRanking;
    private JButton btnCredits;
    private JLabel lbPyQuizz;
    private JLabel lbWelcome;
    private JPanel pyPanel;
    private JPanel welcomePanel;
                  
}