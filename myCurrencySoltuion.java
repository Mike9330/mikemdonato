import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'countCounterfeit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY serialNumber as parameter.
     */

    public static int countCounterfeit(List<String> serialNumber) {
        // System.out.println(serialNumber);
        List<String> allDenominations = Arrays.asList("10", "20","50","100","200","500","1000");
        int totalValue = 0;
        for (int i = 0; i < serialNumber.size(); i++) {
            if (serialNumber.get(i).length() <= 12 && serialNumber.get(i).length() >= 10) {
                String firstThree = serialNumber.get(i).substring(0,3);
                if ((firstThree.equals(firstThree.toUpperCase())) && (firstThree.matches("[a-zA-Z]+"))) {
                    if (uniqueChar(firstThree)){
                        String nextFour = serialNumber.get(i).substring(3,7);
                        if (nextFour.matches("^[0-9]*$")) {
                            System.out.println("nextFour --->"+nextFour);
                            if ( 1900 <= Integer.valueOf(nextFour) && Integer.valueOf(nextFour) <= 2019 ){
                                String toTheEnd = serialNumber.get(i).substring(7,serialNumber.get(i).length());
                                String[] temp = toTheEnd.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                                String denomination = temp[0];
                                String finalChar = temp[1];
                                if (allDenominations.contains(denomination)) {
                                    if (finalChar.matches("[A-Z]")){
                                        System.out.println("firstThree --->"+firstThree);
                                        System.out.println("nextFour --->"+nextFour);
                                        System.out.println("denomination --->"+denomination);
                                        System.out.println("finalChar --->"+finalChar);
                                        totalValue += Integer.valueOf(denomination);
                            }
                        }
                    }
                }
                    }
            }
            }
        }
        return totalValue;

    }
    
    public static boolean uniqueChar(String firstThree) {
        for (int j = 1; j < firstThree.length(); j++){
            if (firstThree.charAt(j) == firstThree.charAt(j-1)) {
                return false;
            }
        }
        return true;
    }

}