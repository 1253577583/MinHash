import java.lang.reflect.Array;
import java.util.*;

public class MinHash {
    public static void similarity(ArrayList<ArrayList<Integer>> data , int setNum ){
        long sTime = System.currentTimeMillis();
        int count = 0;
        Random random = new Random();
        for(int i = 1; i <= setNum; i++){
            for(int j = i+1; j <= setNum; j++){
                ArrayList<Integer> listI = data.get(i);
                ArrayList<Integer> listJ = data.get(j);
                //
                int sizeI = listI.size();
                int sizeJ = listJ.size();
                //
                int same = 0;
                int different = 0;
                double temp = 0;
                int times = 10;

                if(sizeI > sizeJ){
                    //times = times * sizeI;
                    for(int k = 0; k < times; k++){
                        int index = random.nextInt(sizeI);
                        if(listJ.contains(listI.get(index))){
                            same++;
                        }else{
                            different++;
                        }
                    }
                    temp = same * 1.0 * sizeI / different;
                }else{
                    //times = times * sizeJ;
                    for(int k = 0; k < times; k++){
                        int index = random.nextInt(sizeJ);
                        if(listI.contains(listJ.get(index))){
                            same++;
                        }else{
                            different++;
                        }
                    }
                    temp = same * 1.0 * sizeJ / different;
                }

                double rate = temp / (sizeI + sizeJ - temp);
                //result[i][j] = rate;
                if(rate > Global.c){
                    count++;
                }
                //System.out.println("set " + i +" and set " + j +" has " + rate);
            }
        }
        long eTime = System.currentTimeMillis();
        long time = eTime - sTime;
        System.out.println("MinHash the set similarity > " + Global.c + " = " + count);
        System.out.println("MinHash time = " + time + " ms");
    }

    public static void similarity1(ArrayList<ArrayList<Integer>> data , int setNum){

        long sTime = System.currentTimeMillis();
        int count = 0;
        Random random = new Random();
        for(int i = 1; i <= setNum; i++){
            for(int j = i+1; j <= setNum; j++){
                ArrayList<Integer> listI = data.get(i);
                ArrayList<Integer> listJ = data.get(j);
                //
                Set<Integer> set = new HashSet<>(listI);
                set.addAll(listJ);
                int size = set.size();
                Object[] list = set.toArray();

                int same = 0;
                int different = 0;
                int times = 10;
                int index = 0;
                Integer curNum = 0;
                for(int k = 0; k < size; k++){
                     index = random.nextInt(size);
                     curNum = (Integer) list[index];
                     if(listI.contains(curNum) && listJ.contains(curNum)){
                         same++;
                     }else{
                         different++;
                     }
                }

                double rate = same * 1.0 / (same + different);
                //result[i][j] = rate;
                if(rate > Global.c){
                    count++;
                }
                //System.out.println("set " + i +" and set " + j +" has " + rate);
            }
        }
        long eTime = System.currentTimeMillis();
        long time = eTime - sTime;
        System.out.println("MinHash the set similarity > " + Global.c + " = " + count);
        System.out.println("MinHash time = " + time + " ms");
    }

    public static void similarity2(ArrayList<ArrayList<Integer>> data , int setNum){

        long sTime = System.currentTimeMillis();

        int times = Global.hashNum;
        int[][] firstSeq = new int[setNum+1][times];
        for(int t = 0; t < times; t++){
            Integer[] hashSeq = shuffle(Global.maxNum);

            for(int i = 1; i <= setNum; i++){
                for(int j = 0; j < Global.maxNum; j++){
                    if(data.get(i).contains(hashSeq[j])){
                        firstSeq[i][t] = j;
                        break;
                    }
                }
            }
        }
        int count = 0;
        for(int i = 1; i <= setNum; i++){
            for(int j = i+1; j <= setNum; j++){
                int same = 0;
                int different = 0;
                for(int k = 0; k < times; k++){
                    if(firstSeq[i][k] == firstSeq[j][k]){
                        same++;
                    }else {
                        different++;
                    }
                }
                double rate = same * 1.0 / different;
                if(rate > Global.c){
                    count++;
                }
            }
        }

        long eTime = System.currentTimeMillis();
        long time = eTime - sTime;
        System.out.println("MinHash the set similarity > " + Global.c + " = " + count);
        System.out.println("MinHash time = " + time + " ms");

    }

    private static Integer[] shuffle(int size){
        Integer[] array = new Integer[size];
        for(int i = 0; i < size; i++){
            array[i] = i;
        }
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        //System.out.println(list);
        return array;
    }
}
