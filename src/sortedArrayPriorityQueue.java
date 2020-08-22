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

        return null;
    }

    public static void main(String[] args) {
        String[][] input = {
                {"1", "2", "3", "4", "2", "1", "3", "4"},
                {"5", "?", "7", "8", "8", "9", "10", "11"},
                {"9", "10", "11", "12", "12", "?", "14", "15"},
                {"6", "14", "15", "16", "16", "5", "13", "7"}
        };

        int[][] expectedRes = func(input);
    }


}
