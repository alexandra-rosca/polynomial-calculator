package BusinessLogic;

import BusinessLogic.Model;
import BusinessLogic.Parsing;
import DataModels.Polynomial;
import GUI.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {

    private View view;
    private Model model;

    private Polynomial res = new Polynomial();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.adunareActionListener(new adunareListener());
        view.scadereActionListener(new scadereListener());
        view.multiplyActionListener(new multiplyListener());
        view.derivativeActionListener(new derivativeListener());
        view.integralActionListener(new integralListener());
    }

    class adunareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial p = Parsing.parse(view.getInput1());
            Polynomial q = Parsing.parse(view.getInput2());

            Polynomial rez = model.addOperation(p, q);
            view.setTotal(rez.toString());
        }
    }

    class scadereListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial p = Parsing.parse(view.getInput1());
            Polynomial q = Parsing.parse(view.getInput2());

            Polynomial rez = model.subtractOperation(p, q);
            view.setTotal(rez.toString());

        }
    }

    class multiplyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial p = Parsing.parse(view.getInput1());
            Polynomial q = Parsing.parse(view.getInput2());

            Polynomial rez = model.multiplicationOperation(p, q);
            view.setTotal(rez.toString());
        }
    }

    class derivativeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial p = Parsing.parse(view.getInput1());

            Polynomial rez = model.derivativeOperation(p);
            view.setTotal(rez.toString());
        }
    }

    class integralListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial p = Parsing.parse(view.getInput1());

            Polynomial rez = model.integralOperation(p);
            view.setTotal(rez.toString());
        }
    }
}
