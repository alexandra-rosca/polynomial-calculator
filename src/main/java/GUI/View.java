package GUI;

import BusinessLogic.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JTextField input = new JTextField(20);
    private JTextField input2 = new JTextField(20);
    private JTextField output = new JTextField(20);

    private JButton btn1 = new JButton("+");
    private JButton btn2 = new JButton("-");
    private JButton btn3 = new JButton("*");
   // private JButton btn4 = new JButton("/");
    private JButton btn5 = new JButton("Derivative");
    private JButton btn6 = new JButton("Integration");


    private Model model;

    public View(Model model1) {
        model1 = model;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JLabel l1 = new JLabel("Introduceti primul polinom: ");
        panel.add(l1);
        input.setMaximumSize(new Dimension(1500, 20));
        panel.add(input);

        JLabel l2 = new JLabel("Introduceti al doilea polinom: ");
        panel.add(l2);
        input2.setMaximumSize(new Dimension(1500, 20));
        panel.add(input2);

        JLabel l3 = new JLabel("Rezultat: ");
        panel.add(l3);
        output.setMaximumSize(new Dimension(1500, 20));
        output.setEditable(false);
        panel.add(output);


        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBtn.add(btn1);
        panelBtn.add(btn2);
        panelBtn.add(btn3);
       // panelBtn.add(btn4);
        panelBtn.add(btn5);
        panelBtn.add(btn6);

        panel.add(panelBtn);

        this.setContentPane(panel);

        setSize(450, 300);
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getInput1() {
        return input.getText();
    }

    public String getInput2() {
        return  input2.getText();
    }

    public void setTotal(String total) {
        output.setText(total);
    }

    public void adunareActionListener(ActionListener actionListener) {
        btn1.addActionListener(actionListener);
    }

    public void scadereActionListener(ActionListener actionListener) { btn2.addActionListener(actionListener);}

    public void multiplyActionListener(ActionListener actionListener) { btn3.addActionListener(actionListener);}

    public void integralActionListener(ActionListener actionListener) { btn6.addActionListener(actionListener);}

    public void derivativeActionListener(ActionListener actionListener) { btn5.addActionListener(actionListener);}

}
