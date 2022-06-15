import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz extends javax.swing.JFrame {

    private int streak = 0;
    int points = 0;
    int questionIndex = 0;
    ArrayList<Question> list = new ArrayList<>();
    // Variables declaration - do not modify
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    JButton jButton1 = new JButton();

    public Quiz() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Quiz().setVisible(true));
    }

    public void initComponents() {
        Scanner scanner = new Scanner(System.in);

        list.add(new Question("Qual a sintaxe correta para a saída “Hello World”?", "A) print”Hello World”", "B) print(“Hello World”)", "C) p(“Hello World”)", "D) p”Hello World”", "B) print(“Hello World”)"));
        list.add(new Question("Quais são estruturas de repetição em python?", "A) print e for", "B) print e while", "C) while e for", "D) for e if", "C) while e for"));
        list.add(new Question("Qual a sintaxe de comentário em python?", "A) //comentário", "B) #comentário", "C) /#comentário#/", "D) */comentário*/", "B) #comentário"));
        list.add(new Question("Como conseguir o tipo da variável x?", "A) print(type(x))", "B) print(type.x)", "C) print((x)type)", "D) print(type=x)", "A) print(type(x))"));
        list.add(new Question("Qual o operador que tem como saída True, False?", "A) string", "B) integer", "C) boolean", "D) double", "C) boolean"));
        list.add(new Question("Qual função conta o número de elementos de um string?", "A) trim()", "B) strip()", "C) ptrim()", "D) len()", "D) len()"));
        list.add(new Question("Qual operador é utilizado para fazer divisões inteiras?", "A) /", "B) *", "C) #", "D) //", "D) //"));
        list.add(new Question("Qual dessas estruturas é de decisão simples?", "A) while", "B) else", "C) if", "D) for", "C) if"));
        list.add(new Question("Qual das opções a seguir não é um operador relacional?", "A) >=", "B) !=", "C) ?=", "D) <=", "C) ?="));
        list.add(new Question("Analise o código python a seguir: x = [2,4,6,8,10] print(x[-1])", "A) 2", "B) 10", "C) 2,10", "D) 10,8,6,4,2", "B) 10"));
        list.add(new Question("Que operador é sobrecarregado por __ifloordiv__()?", "A) //=", "B) _/=", "C) /_=", "D) ///=", "A) //="));

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setTitle("Questions - PyQuizz");

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUESTION");

        jRadioButton1.setText("Alternative 1");
        jRadioButton1.addActionListener(this::jRadioButton1ActionPerformed);

        jRadioButton2.setText("Alternative 2");
        jRadioButton2.addActionListener(this::jRadioButton2ActionPerformed);

        jRadioButton3.setText("Alternative 3");
        jRadioButton3.addActionListener(this::jRadioButton3ActionPerformed);

        jRadioButton4.setText("Alternative 4");
        jRadioButton4.addActionListener(this::jRadioButton4ActionPerformed);

        jButton1.setText("NEXT");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)));
        jButton1.addActionListener(this::jButton1ActionPerformed);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(241, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        Collections.shuffle(list);
        jLabel1.setFont(new Font("Bauhaus 93", 0, 18));
        jLabel1.setText(list.get(questionIndex).question);

        jRadioButton1.setText(list.get(questionIndex).alternativa1);
        jRadioButton2.setText(list.get(questionIndex).alternativa2);
        jRadioButton3.setText(list.get(questionIndex).alternativa3);
        jRadioButton4.setText(list.get(questionIndex).alternativa4);
        questionIndex++;

        scanner.close();
        pack();
    }

    public void getSelectedOption(JRadioButton rbtn) {
        if (list.get(questionIndex - 1).answer.equals(rbtn.getText())) {
            streak++;
            if (streak == 0)
                points++;
            else
                points += streak;
        } else
            streak = 0;
        enableRbuttons(false);
    }

    public void enableRbuttons(boolean canPress) {
        jRadioButton1.setEnabled(canPress);
        jRadioButton2.setEnabled(canPress);
        jRadioButton3.setEnabled(canPress);
        jRadioButton4.setEnabled(canPress);
    }

    private void jRadioButton1ActionPerformed(ActionEvent evt) {
        getSelectedOption(jRadioButton1);
    }

    private void jRadioButton2ActionPerformed(ActionEvent evt) {
        getSelectedOption(jRadioButton2);
    }

    private void jRadioButton3ActionPerformed(ActionEvent evt) {
        getSelectedOption(jRadioButton3);
    }

    private void jRadioButton4ActionPerformed(ActionEvent evt) {
        getSelectedOption(jRadioButton4);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        enableRbuttons(true);

        if (questionIndex < list.size()) {
            jLabel1.setFont(new Font("Bauhaus 93", 0, 18));
            jLabel1.setText(list.get(questionIndex).question);

            jRadioButton1.setText(list.get(questionIndex).alternativa1);
            jRadioButton2.setText(list.get(questionIndex).alternativa2);
            jRadioButton3.setText(list.get(questionIndex).alternativa3);
            jRadioButton4.setText(list.get(questionIndex).alternativa4);
            questionIndex++;

            buttonGroup1.clearSelection();
        } else {
            jButton1.setText("Finish");
            jButton1.addActionListener(e -> {
                TelaInicial telaInicio = new TelaInicial(null);
                telaInicio.pack();
                telaInicio.setVisible(true);
                telaInicio.setLocationRelativeTo(null);
                dispose();
                JOptionPane.showMessageDialog(null, "You got " + points + " points!");
            });
        }
    }
    // End of variables declaration
}