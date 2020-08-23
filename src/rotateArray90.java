public class rotateArray90 {
    //given an array
    //rotated it by 90 degree clockwise for k times
    //without modify its diagonal elements

    //Example:
    //1 2 3             1 4 3
    //4 5 6 -> k = 1 -> 8 5 2
    //7 8 9             7 6 9

    //if(i == j || (i + j) == n - 1)
    // 1, 2, 3, 4           (0, 1) -> (1, 3) -> (3, 2)
    // 5, 6, 7, 8           (0, 2) -> (2, 3)
    // 9, 10, 11, 12
    // 13, 14, 15, 16
    public static int[][] func(int[][] input, int k){
        if(input == null || input.length == 0)  //check the input array.
            return input;

        int n = input.length, m = input[0].length;  //initialize the width and length of the array.
        int change_time = k % 4;    //if change time mod 4 equals 0, which means we do not need to rotate.
        if(change_time == 0)
            return input;

        for(int i = 0; i < change_time; i++){
            for(int j = 0; j < n / 2; j++){
                for(int z = j; z < n - j - 1; z++){
                    if(j == z || (j + z) ==  n - 1)
                        continue;
                    else{
                        int temp = input[j][z];
                        input[j][z] = input[n - 1 - z][j];
                        input[n - 1 - z][j] = input[n - 1 - j][n - 1 - z];
                        input[n - 1 - j][n - 1 - z] = input[z][n - 1 - j];
                        input[z][n - 1 - j] = temp;
                    }
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int k = 6;

        int[][] expectedRes = func(input, k);
        for(int i = 0; i < expectedRes.length; i++){
            for(int j = 0; j < expectedRes[0].length; j++) {
                System.out.print(expectedRes[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
