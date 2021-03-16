package DataModels;

import DataModels.Monomial;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {

    public List<Monomial> P;

    public Polynomial() {

        P = new ArrayList<Monomial>();
    }

    public List<Monomial> getP() {
        return P;
    }

    public void add(Monomial rezultat) {
        P.add(rezultat);
    }

    public String toString() {
        String str1 = "";
        for(Monomial m : this.getP()) {
            String str2 = m.toString();
            str1 += str2;
        }
        return str1;
    }
}
