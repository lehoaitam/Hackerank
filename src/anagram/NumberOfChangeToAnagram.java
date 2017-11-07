package anagram;

import java.io.File;
import java.util.Scanner;

public class NumberOfChangeToAnagram {
    public static int anagram(String s){
        if(s.length() %2 == 1)
            return -1;
        String s1 = s.substring(0, s.length()/2);
        String s2 = s.substring(s.length()/2, s.length());
        int result = minManipulateToAnagram(s1, s2);
        // Complete this function
        return result;
    }
    public static int minManipulateToAnagram(String s1, String s2){
        int N = 26;
        int[] freq = new int[N];
        //count frequency in s1
        for(char ch : s1.toCharArray()){
            freq[ch - 'a']++;
        }
        //check exist of charactor of s2 in freq
        int count = 0;
        for(char ch : s2.toCharArray()){
            freq[ch - 'a']--;
            if(freq[ch - 'a'] < 0 )
                count++;
        }
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
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
    }
}
