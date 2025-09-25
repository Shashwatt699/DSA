package Problems;

import java.util.HashMap;
import java.util.Map;

class Fraction_to_reccurringDecimal{

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder res = new StringBuilder();

        //Handling Negative Sign -- This is XOR Operator which works on same then false , diff then true
        if ((numerator < 0) ^ (denominator < 0))
            res.append("-");

        //Convert to long to avoid overflow
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);

        //Integer part
        res.append(num / den);
        long rem = num % den;
        if (rem == 0)
            return res.toString();

        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(rem != 0) {
            if(map.containsKey(rem)) {
                res.insert(map.get(rem), "(");
                res.append(")");
                break;
            }
            map.put(rem, res.length());
            rem *= 10;
            res.append(rem / den);
            rem %= den;
        } 
        return res.toString();
    }

    public static void main(String[] args) {
        
    }
}