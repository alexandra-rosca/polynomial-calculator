package BusinessLogic;

import DataModels.Monomial;
import DataModels.Polynomial;

public class Model {

    public Polynomial addOperation(Polynomial p, Polynomial q) {
        Monomial rez1; //rezultat monom
        Polynomial rez2 = new Polynomial();

        for (Monomial i: p.getP()) {
            for(Monomial j: q.getP()) {
                if(i.getPower() == j.getPower()) {
                    //daca avem grade la fel, adunam

                    i.setFound(true);
                    j.setFound(true);
                    rez1 = new Monomial(i.getCoef() + j.getCoef(), i.getPower());
                    rez2.add(rez1);

                }
            }
        }

        for(Monomial m1 : p.getP()) {
            if (!m1.isFound())                      //daca nu gasim polinoame de ac grad adaugam monomul la rezultat
                rez2.add(m1);
        }

        for(Monomial m2 : q.getP()) {
            if(!m2.isFound())
                rez2.add(m2);
        }
            return rez2;

    }


    public Polynomial subtractOperation(Polynomial p, Polynomial q) {
        Monomial rez1;
        Polynomial rez2 = new Polynomial();

        for(Monomial i : p.getP()) {
            for(Monomial j : q.getP()) {
                if(i.getPower() == j.getPower()) {

                    i.setFound(true);
                    j.setFound(true);
                    rez1 = new Monomial(i.getCoef() - j.getCoef(), i.getPower());
                    rez2.add(rez1);
                }
            }
        }

        for(Monomial m1 : p.getP()) {
            if(!m1.isFound())
                rez2.add(m1);
        }

        for(Monomial m2 : q.getP()) {
            if(!m2.isFound()) {
                m2.setCoef(-m2.getCoef());
                rez2.add(m2);
            }
        }

        return rez2;
    }


    public Polynomial multiplicationOperation(Polynomial p, Polynomial q) {
        Monomial rez1;
        Polynomial rez2 = new Polynomial();

        for(Monomial i : p.getP()) {
            for(Monomial j : q.getP()) {
                rez1 = new Monomial(i.getCoef() * j.getCoef(), i.getPower() + j.getPower());
                rez2.add(rez1);
            }
        }

        return rez2;
    }

    public Polynomial derivativeOperation(Polynomial p) {

        Monomial rez1;
        Polynomial rez = new Polynomial();

        for(Monomial m : p.getP()) {
            rez1 = new Monomial(m.getPower() * m.getCoef(), m.getPower() - 1);
            rez.add(rez1);
        }
        return rez;
    }

    public Polynomial integralOperation(Polynomial p) {

        Monomial rez1;
        Polynomial rez2 = new Polynomial();

        for(Monomial m : p.getP()) {
            rez1 = new Monomial(m.getCoef()/(m.getPower() + 1), m.getPower() + 1);
            rez2.add(rez1);
        }
        return rez2;
    }

}
