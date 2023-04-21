import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        // 载入数据
        while (true){
            Scanner scan = new Scanner(System.in);
            String str =scan.nextLine();
            String[] s = str.split(" +");

            ArrayList<ArrayList<Integer>> data = DataLoad.dataLoad1(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

            Naive.similarity(data, Global.setNum);
            System.out.println();
            MinHash.similarity2(data, Global.setNum);

        }

    }
}