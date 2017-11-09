import java.io.File;
import java.util.Scanner;

public class Median {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/Median/test"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        java.util.PriorityQueue<Integer> minQueue = new java.util.PriorityQueue<>();
        java.util.PriorityQueue<Integer> maxQueue = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            if(maxQueue.size() > minQueue.size()){
                maxQueue.offer(a[i]);
                minQueue.add(maxQueue.poll());
            }else{
                minQueue.add(a[i]);
                maxQueue.add(minQueue.poll());
            }
            //add number into queue
            double median;
            if(maxQueue.size() < minQueue.size())
                median = minQueue.peek();
            else if(minQueue.size() < maxQueue.size())
                median = maxQueue.peek();
            else
                median = (minQueue.peek() + maxQueue.peek()) / 2.0;
            System.out.printf("%.1f", median);
            System.out.println();
        }
    }
}
