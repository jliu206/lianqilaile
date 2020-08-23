import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class sortedArrayPriorityQueue {
    //given multiple 4*4 array(elements from "1" to "16")
    //each block missing a number substitute by "?"
    //find the missing number
    //and sort the blocks by the number in ascending order

    //Example:
    //1 2 3 4       2 1 3 4
    //5 ? 7 8       8 9 10 11
    //9 10 11 12    12 ? 14 15
    //6 14 15 16    16 5 13 7

    public static int[][] func(String[][] input){
        int[][] arr = new int[input.length][input[0].length];
        int sum = (1 + 16) * 16 / 2;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < arr[0].length; j++){
                String current = input[i][j];
                if(current.equals("?")){
                    arr[i][j] = 0;
                    continue;
                }
                int cur = Integer.parseInt(current);
                arr[i][j] = cur;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] - b[1] != 0){
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        for(int i = 0; i < arr[0].length; i+=4){
            int currentSum = 0;
            int x = 0;
            int y = 0;
            for(int j = 0; j < 4; j++){
                for(int k = i; k < i + 4; k++){
                    currentSum += arr[j][k];
                    if(arr[j][k] == 0){
                        x = j;
                        y = k;
                    }
                }
            }
            int missing = sum - currentSum;
            arr[x][y] = missing;
            int[] ele = {i / 4, missing};
            pq.add(ele);
        }

        List<int[]> sorted = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            sorted.add(cur);
        }

        int curIdx = 0;
        int[][] ret = new int[4][input[0].length];
        for(int i = 0; i < sorted.size(); i++){
            int in = sorted.get(i)[0];
            int[][] current = findSubarray(arr, in);
            for(int j = 0; j < 4; j++){
                for(int k = curIdx * 4; k < curIdx * 4 + 4; k++){
                    ret[j][k] = current[j][k - (curIdx * 4)];
                }
            }
            curIdx++;
        }

        return ret;

    }

    public static int[][] findSubarray(int[][] arr ,int input){
        int[][] cur = new int[4][4];
        for(int i = 0; i < 4; i++){
            for (int j = input * 4; j < input * 4 + 4; j++) {
                cur[i][j - (input * 4)] = arr[i][j];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        String[][] input = {
                {"1", "2", "3", "4", "2", "1", "3", "4"},
                {"5", "?", "7", "8", "8", "9", "10", "11"},
                {"9", "10", "11", "12", "12", "?", "14", "15"},
                {"6", "14", "15", "16", "16", "5", "13", "7"}
        };

        int[][] expectedRes = func(input);

        for(int[] i:expectedRes) {
            for (int s : i) {
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }


}
