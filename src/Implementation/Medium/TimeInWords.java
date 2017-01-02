package Implementation.Medium;

import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class TimeInWords {
    public static void main(String[] args){
        //Read input from STDIN
        Scanner in = new Scanner(System.in);
        int hour = in.nextInt();
        int minute = in.nextInt();
        //initilize array of string number
        String[] numStr = {"","one","two","three","four","five","six","seven","eight","nine","ten",
                "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
        String result = "";
        //generate string base of hour:minute
        if(minute == 0) result = numStr[hour] + " o' clock";
        if(minute == 1) result = "one minute past " + numStr[hour];
        if(minute == 15) result = "quarter past " + numStr[hour];
        if((1 < minute && minute < 15) || (15 < minute && minute <= 20)) result = numStr[minute] + " minutes past " + numStr[hour];
        if(20 < minute && minute < 30) result = "twenty " + numStr[minute - 20] + " minutes past " + numStr[hour];
        if(minute == 30) result = "half past " + numStr[hour];
        if(30 < minute && minute < 40) result = "twenty " + numStr[60 - minute - 20] + " minutes to " + numStr[hour+1];
        if(minute == 45) result = "quarter to " + numStr[hour+1];
        if((40 <= minute && minute < 45)||(45 < minute && minute < 59) ) result = numStr[60-minute] + " minutes to " + numStr[hour+1];
        if(minute == 59) result = "one minute to " + numStr[hour+1];
        System.out.println(result);
    }
}
