import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void f1(){
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);a1.add(2);a1.add(3);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(3);a2.add(4);a2.add(5);
        a1.addAll(a2);
        System.out.println(a1);
    }
    public static void shuffle(int size){
        Integer[] array = new Integer[size];
        for(int i = 0; i < size; i++){
            array[i] = i;
        }
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        System.out.println(list);
    }

}
