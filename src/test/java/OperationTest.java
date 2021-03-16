import BusinessLogic.Model;
import DataModels.Monomial;
import DataModels.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void addTest() {
        Model model = new Model();

        Monomial monom1 = new Monomial(2, 3);
        Monomial monom2 = new Monomial(3, 2);

        Monomial monom3 = new Monomial(5,3);
        Monomial monom4 = new Monomial(2, 1);

        Polynomial p = new Polynomial(); //2X^3 + 3X^2
        Polynomial q = new Polynomial(); //5X^3 + 2X^1

        p.add(monom1);
        p.add(monom2);

        q.add(monom3);
        q.add(monom4);

        assertEquals("+7.0X^3+3.0X^2+2.0X^1", model.addOperation(p, q).toString());
    }

    @Test
    public void subtractTest() {
        Model model = new Model();

        Monomial monom1 = new Monomial(2, 5);
        Monomial monom2 = new Monomial(-10, 3);

        Monomial monom3 = new Monomial(3,5);
        Monomial monom4 = new Monomial(3, 3);

        Polynomial p = new Polynomial(); //2X^5 - 10X^3
        Polynomial q = new Polynomial(); //3X^5 + 3X^3

        p.add(monom1);
        p.add(monom2);

        q.add(monom3);
        q.add(monom4);

        assertEquals("-1.0X^5-13.0X^3", model.subtractOperation(p, q).toString());
    }

    @Test
    public void multiplyTest() {
        Model model = new Model();

        Monomial monom1 = new Monomial(15, 2);
        Monomial monom2 = new Monomial(3, 1);

        Monomial monom3 = new Monomial(2,5);
        Monomial monom4 = new Monomial(3, 3);

        Polynomial p = new Polynomial(); //15X^2 + 3X^1
        Polynomial q = new Polynomial(); //2X^5 + 3X^3

        p.add(monom1);
        p.add(monom2);

        q.add(monom3);
        q.add(monom4);

        assertEquals("+30.0X^7+45.0X^5+6.0X^6+9.0X^4", model.multiplicationOperation(p, q).toString());
    }

    @Test
    public void derivativeTest() {
        Model model = new Model();

        Monomial monomial1 = new Monomial(4,10);
        Monomial monomial2 = new Monomial(7,8);
        Monomial monomial3 = new Monomial(3,4);
        Monomial monomial4 = new Monomial(-2,1);
        Monomial monomial5 = new Monomial(200,0);

        Polynomial p = new Polynomial(); //4X^10 + 7X^8 + 3X^4 - 2X + 200
        p.add(monomial1);
        p.add(monomial2);
        p.add(monomial3);
        p.add(monomial4);
        p.add(monomial5);

        assertEquals("+40.0X^9+56.0X^7+12.0X^3-2.0", model.derivativeOperation(p).toString());
    }

    @Test
    public void integrationTest() {
        Model model = new Model();

        Monomial m1 = new Monomial(10, 7);
        Monomial m2 = new Monomial(15, 5);
        Monomial m3 = new Monomial(2, 1);

        Polynomial p = new Polynomial(); //10X^7 + 15X^5 + 2X
        p.add(m1);
        p.add(m2);
        p.add(m3);

        assertEquals("+1.25X^8+2.5X^6+1.0X^2", model.integralOperation(p).toString());
    }

}
