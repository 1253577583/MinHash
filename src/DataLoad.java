import java.io.*;
import java.util.ArrayList;

public class DataLoad {
    public static ArrayList<ArrayList<Integer>> dataLoad1(int index,int dataNum) throws IOException {
        String fileName = switch (index) {
            case 1 -> "D:/UniversityThirdYear/大三下/高级算法/高级算法实验/Lab1/E1_AOL-out.txt";
            case 2 -> "D:/UniversityThirdYear/大三下/高级算法/高级算法实验/Lab1/E1_kosarak_100k.txt";
            case 3 -> "D:/UniversityThirdYear/大三下/高级算法/高级算法实验/Lab1/E1_Booking-out.txt";
            default -> null;
        };

        assert fileName != null;
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        // 初始化数组
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        for(int i = 1; i <= dataNum; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            data.add(temp);
        }
        // 读取数据，保存在数组里
        int count = 0;
        int max = 0;
        while((line = br.readLine()) != null && count < dataNum){
            // 一行一行地处理...
            count++;
            String[] s = line.split("[ \t]+");

            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);

            ArrayList<Integer> temp = data.get(i);
            //temp.set(0,temp.get(0)+1);
            if(!temp.contains(j)){
                temp.add(j);
            }
            if(j > max){
                max = j;
            }
        }
        Global.maxNum = max;

        int setNum = 0;
        for(int i = 1; i< dataNum; i++){
            if(data.get(i).size()>0){
                //System.out.println("set" + i + " " + data.get(i));
            }else{
                setNum = i - 1;
                break;
            }
        }
        Global.setNum = setNum;
        System.out.println("setNum = " + setNum);

        return data;
    }
}
