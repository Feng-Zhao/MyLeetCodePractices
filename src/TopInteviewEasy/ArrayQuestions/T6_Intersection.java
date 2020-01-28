package TopInteviewEasy.ArrayQuestions;

import java.util.*;

public class T6_Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(list1.contains(nums2[i])){
                list1.remove((Integer)nums2[i]);
                list2.add(nums2[i]);
            }
        }
        int[] a = list2.stream().mapToInt(x->x).toArray();
        return a;
    }
}
