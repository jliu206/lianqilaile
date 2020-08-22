public class findMinimumInArray {
    //The array is defined as this
    //array[i][j] = (i + 1) * (j + 1)
    //Several methods:
    //[0] : find the minimum in array
    //[1, x] : delete the xst column in array
    //[2, x] : delete the xst row in array

    public static int[] func(int[][] array ,int[][] input){
        return null;
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
    }
}
