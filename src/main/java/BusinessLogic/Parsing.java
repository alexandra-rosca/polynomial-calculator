package BusinessLogic;

import DataModels.Monomial;
import DataModels.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing {

    public Parsing() {
    }

    public static Polynomial parse(String str) {

        Polynomial output = new Polynomial();

        Pattern pattern = Pattern.compile("(-?\\d+)[xX]\\^(-?\\d+)");
        Matcher matcher = pattern.matcher(str);

        while(matcher.find()) {
            Monomial monomial = new Monomial(0, 0);
            monomial = new Monomial(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            output.add(monomial);
        }

        return output;
    }
}
