package DataModels;

public class Monomial {

    private double coef;
    private int power; //grad
    private boolean found; //verificam daca s-au gasit polinoame de acelas grad

    public Monomial(double coef, int power) {
        this.coef = coef;
        this.power = power;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String toString() {
        if(coef == 0 && power == 0)
            return "";

        if(coef == 0)
            return "";

        if(coef > 0 && power == 0)
            return "+" + coef;

        if(coef < 0 && power == 0)
            return coef + "";

        if(coef == 1 && power == 1)
            return "X";

        if(coef < 0 && (power > 1 || power < 0))
            return "" + coef + "X^" + power;

        if(coef > 0 && power > 0)
            return "+" + coef + "X^" + power;
        else
            return coef + "X^" + power;


    }

}
