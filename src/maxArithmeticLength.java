import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class maxArithmeticLength {
    //given two arrays
    //A = {0, 2, 4, 8}
    //B = {-2, -1, 3, 6, 12}
    //Find the maximum number of the elements
    //which elements moved from B to A
    //make A an arithmetic array
    static int ans = 0;
    public static int func(int[] A, int[] B){
        ans = A.length;
        List<Integer> list = new ArrayList<>();
        for(int num : A)
            list.add(num);
        int n = B.length;
        int m = A.length;
        permutation(list, B,  m, 0);

        return ans;
    }

    public static void permutation(List<Integer> list, int[] B, int m, int index){
        Collections.sort(list);
        for(int i = index; i < B.length; i++){
                list.add(B[i]);
                permutation(list, B, m + 1, i + 1);
                list.remove(list.indexOf(B[i]));
        }
        // check the whole array A.
        int sub = -1;
        if(list.size() >= 2)
            sub = list.get(1) - list.get(0);
        else
            sub = 0;

        if(list.size() <= ans)
            return;

        for(int i = 2; i < list.size(); i++){
            if(list.get(i) - list.get((i - 1)) != sub)
                return;
        }
        if(m > ans)
            ans = m;
    }
    public static void main(String[] args) {
        int[] A = { 8};
        int[] B = {6 ,6, 8, 8, 8, 8, 8, 8, 8};

        int expectedRes = func(A, B);
        System.out.println(ans);
    }
}
