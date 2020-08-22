import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findMinimumInArray {
    //The array is defined as this
    //array[i][j] = (i + 1) * (j + 1)
    //Several methods:
    //[0] : find the minimum in array
    //[1, x] : delete the xst column in array
    //[2, x] : delete the xst row in array
    public static class ListNode {
        ListNode next;
        int val;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static int[] func(int[][] array ,int[][] input){
        List<ListNode> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
            for(int j = 0; j < array[i].length; j++){
                current.next = new ListNode(array[i][j]);
                current = current.next;
            }
            list.add(dummy);
        }

        int len = 0;
        for(int[] arr : input){
            int[] zero = {0};
            if(Arrays.equals(arr, zero)){
                len++;
            }
        }
        int[] res = new int[len];
        int idx = 0;
        for(int[] arr : input){
            if(arr.length == 2){
                if(arr[0] == 1){
                    deleteColumn(list, arr[1]);
                } else {
                    deleteRow(list, arr[1]);
                }
            } else {
                res[idx++] = returnMinimum(list);
            }
        }

        return res;
    }

    public static void deleteRow(List<ListNode> list, int x){
        list.remove(x);
        return;
    }

    public static void deleteColumn(List<ListNode> list, int x){
        for(int i = 0; i < list.size(); i++){
            ListNode current = list.get(i);
            for(int j = 0; j < x; j++){
                current = current.next;
            }
            current.next = current.next.next;
        }
        return;
    }

    public static int returnMinimum(List<ListNode> list){
        return list.get(0).next.val;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {2, 4, 6, 8},
                {3, 6, 9, 12}
        };
        int[][] input = {
                {1,1},
                {0},
                {2,2},
                {0}
        };

        int[] expectedRes = func(array, input);

        for(int i : expectedRes){
            System.out.println(i);
        }
    }
}
