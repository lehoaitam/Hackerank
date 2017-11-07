import java.io.File;
import java.util.*;

public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    String[] noteStrs;

    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<>();
        String[] magazineStrs = magazine.split(" ");
        noteStrs = note.split(" ");
        for(String str : magazineStrs){
            int count = 0;
            if(magazineMap.containsKey(str))
                count = magazineMap.get(str);
            magazineMap.put(str,count+1);
        }

    }

    public boolean solve() {

        for(String str : noteStrs){
            if(!magazineMap.containsKey(str) || magazineMap.get(str) == 0)
                return false;
            magazineMap.put(str,magazineMap.get(str)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./resource/Anagram/test"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        List<Integer> list = new ArrayList<>();
        list.toArray();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
