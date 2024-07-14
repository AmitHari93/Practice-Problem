package SingletoneExample;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1,2,3,4,4,5,5,6,1};
        List<Integer> arr1 = Arrays.asList(1,1,2,2,4,5,6,6);
        Set<Integer> s = new HashSet<>();
        //Set<Integer> result = Arrays.stream(arr).filter(n->!s.add(n)).collect(Collectors.toSet());
        List<Integer> result = arr1.stream().filter(n->!s.add(n)).collect(Collectors.toList());
        System.out.println(result);
//        Singleton x = Singleton.getInstance();
//        Singleton y = Singleton.getInstance();
//        System.out.println(x.hashCode());
//        System.out.println(y.hashCode());
    }
}
