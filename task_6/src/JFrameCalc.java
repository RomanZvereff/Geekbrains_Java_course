import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameCalc extends JFrame{

    double num1;
    double num2;
    double result;
    String operation;

    private JButton jButton1;
    private JButton jButton4;
    private JButton jButton7;
    private JButton jButtonPlusMinus;
    private JButton jButton3;
    private JButton jButton2;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButton0;
    private JButton jButtonComma;
    private JButton jButtonClear;
    private JButton jButtonPlus;
    private JButton jButtonMinus;
    private JButton jButtonMultiply;
    private JButton jButtonEqual;
    private JButton jButtonDivide;
    private JTextField jDisplay;
    private JPanel mainPanel;
    private JTextField jTopDisplay;

    public JFrameCalc() {
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton1.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton2.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton3.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton4.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton5.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton6.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton7.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton8.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton9.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNum = jDisplay.getText() + jButton0.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButtonComma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jDisplay.getText();
                if(str.contains(",")) {
                    return;
                };
                String inputNum = jDisplay.getText() + jButtonComma.getText();
                jDisplay.setText(inputNum);
            }
        });
        jButtonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDisplay.setText("");
                jTopDisplay.setText("");
            }
        });
        jButtonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(jDisplay.getText());
                jDisplay.setText("");
                operation = "+";
                jTopDisplay.setText(num1 + operation);
            }
        });
        jButtonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(jDisplay.getText());
                jDisplay.setText("");
                operation = "-";
                jTopDisplay.setText(num1 + operation);
            }
        });
        jButtonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(jDisplay.getText());
                jDisplay.setText("");
                operation = "*";
                jTopDisplay.setText(num1 + operation);
            }
        });
        jButtonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(jDisplay.getText());
                jDisplay.setText("");
                operation = "/";
                jTopDisplay.setText(num1 + operation);
            }
        });
        jButtonPlusMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double plusMinus = Double.parseDouble(String.valueOf(jDisplay.getText()));
                plusMinus = plusMinus * (-1);
                jDisplay.setText(String.valueOf(plusMinus));
            }
        });
        jButtonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(jDisplay.getText());
                if(operation.equals("+")) {
                    result = num1 + num2;
                    jTopDisplay.setText(num1 + operation + num2);
                    jDisplay.setText(String.format("%.2f", result));
                }else if(operation.equals("-")) {
                    result = num1 - num2;
                    jTopDisplay.setText(num1 + operation + num2);
                    jDisplay.setText(String.format("%.2f", result));
                }else if(operation.equals("*")) {
                    result = num1 * num2;
                    jTopDisplay.setText(num1 + operation + num2);
                    jDisplay.setText(String.format("%.2f", result));
                }else if(operation.equals("/")) {
                    if(num2 == 0) {
                        jTopDisplay.setText(num1 + operation + num2);
                        jDisplay.setText("Error");
                    }else {
                        result = num1 / num2;
                        jTopDisplay.setText(num1 + operation + num2);
                        jDisplay.setText(String.format("%.2f", result));
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame= new JFrame("Calculator");
        frame.setContentPane(new JFrameCalc().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
