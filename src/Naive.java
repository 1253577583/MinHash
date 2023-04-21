import java.util.ArrayList;

public class Naive {
    public static void similarity(ArrayList<ArrayList<Integer>> data , int setNum){
        long sTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 1; i <= setNum; i++){
            for(int j = i+1; j <= setNum; j++){
                ArrayList<Integer> listI = data.get(i);
                ArrayList<Integer> listJ = data.get(j);
                int sizeI = listI.size();
                int sizeJ = listJ.size();
                int jiaoji = 0;
                for(int k = 0 ; k < sizeI ; k++){
                    if(listJ.contains(listI.get(k))){
                        jiaoji++;
                    }
                }
                int bingji = sizeI + sizeJ - jiaoji;
                double rate = jiaoji * 1.0 / bingji ;
                //result[i][j] = rate;
                if(rate > Global.c){
                    count++;
                }
                //System.out.println("set " + i +" and set " + j +" has " + rate);
            }
        }
        long eTime = System.currentTimeMillis();
        long time = eTime - sTime;
        System.out.println("Naive the set similarity > " + Global.c + " = " + count);
        System.out.println("Naive time = " + time + " ms");

    }
}
