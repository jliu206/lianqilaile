import java.util.PriorityQueue;

public  class sortedArrayPriorityQueue {
    static String[][]sortByMissingNum(String[][]mat){
        int sum=17*8;
        int cur=sum;
        int[]ans=new int[mat[0].length/4];
        int idx=0;
        int[]save=new int[2];
        for(int i=0;i<mat[0].length;i++){
            if(i%4==0)cur=sum;
            for(int j=0;j<mat.length;j++){
                if(mat[j][i].equals("?")) {
                    save[0]=j;
                    save[1]=i;
                    continue;
                }
                int temp=Integer.parseInt(mat[j][i]);
                cur-=temp;
            }
            if((i+1) % 4==0){
                mat[save[0]][save[1]]=Integer.toString(cur);
                ans[idx++]=cur;
                save=new int[2];
            }
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->{
            if(a[1]!=b[1])return a[1] - b[1];
            return a[0] - b[0];
        });
        idx=0;
        for(int i:ans){
            pq.add(new int[]{idx++,i});
        }
        String[][]result=new String[mat.length][mat[0].length];
        idx=0;
        while(!pq.isEmpty()){
            int a=pq.poll()[0];
            for(int i=0;i<4;i++){
                for(int j=idx;j<idx+4;j++){
                    result[i][j]=mat[i][a*4+j-idx];
                }
            }
            idx += 4;
        }
        return result;
    }

    public static void main(String[] args) {

        String[][] str1 =  {
                {"1", "2", "3", "4", "2", "1", "3", "4"},
                {"5", "?", "7", "8", "8", "9", "10", "11"},
                {"9", "10", "11", "12", "12", "?", "14", "15"},
                {"6", "14", "15", "16", "16", "5", "13", "7"}
        };
        String[][] str = sortByMissingNum(str1);
        for(String[] i:str) {
            for (String s : i) {
                System.out.print(s);
                for(int y = 2; y >= s.length(); y--)
                    System.out.print(" ");
            }
            System.out.println(" ");
        }

    }
}
