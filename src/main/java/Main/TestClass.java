package Main;

import BusinessLogic.Controller;
import BusinessLogic.Model;
import GUI.View;

public class TestClass {

    public static void main(String[] args) {

        Model      model      = new Model();
        View view       = new View(model);
        Controller controller = new Controller(model, view);

        view.setVisible(true);
    }
}
