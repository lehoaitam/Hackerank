package anagram;

import java.io.File;
import java.util.Scanner;

public class NumberOfDeleteToAnagram {
    public static int numberNeeded(String first, String second) {
        int N = 26;
        int[] freq1 = new int[N];
        int[] freq2 = new int[N];
        for(char ch : first.toCharArray())
            freq1[ch-'a']++;
        for(char ch : second.toCharArray())
            freq2[ch-'a']++;
        int count = 0;
        for(int i = 0; i < 26; i++)
            count += Math.abs(freq1[i] - freq2[i]);
        return count;
    }
    public static void main(String[] args) {
        //input
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/Anagram/test"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

