package numchallenge;

import java.util.HashMap;

/**
 *
 * @author evoulgaris
 */
public class NumChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("The requested numbers are:" + calculator(53000));
    }

    private static int calculator(int upperLimit) {

        HashMap<Character, Integer> fr = new HashMap<>();
        int sum = 0, i = upperLimit;
        int digits = Integer.toString(i).length();
        String str = "1";
        for (int l = 0; l < digits; l++) {
            str = str.concat("0");
        }
        int add = Integer.parseInt(str);
        do {
            fr.clear();
            str = Long.toString(i);
            if (!(str.contains("8") || str.contains("9"))) {
                for (int j = 0; j < digits; j++) {
                    if (fr.putIfAbsent(str.charAt(j), 1) != null) {
                        break;
                    }
                }
                if (fr.keySet().size() == digits) {
                    sum++;
                }

            } else if (str.startsWith("8", 0)) {
                i += 2 * (add / 10) - 2;
            }
            
            i++;
            if (i + 1 == add) {
                digits = Integer.toString(i + 1).length();
                add *= 10;
            }

        } while (digits <= 8);
        return sum;
    }

}
