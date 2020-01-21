import java.util.ArrayList;
import java.util.List;

public class p4_Median_of_Two_Sorted_Arrays {

    // merge sorted
    // T = O(m+n), S = O(m+n)
    public double sol_1(int[] nums1, int[] nums2) {
        List<Integer> all = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        while(p1 != nums1.length || p2 != nums2.length){
            if(p1 == nums1.length){
               for(;p2 != nums2.length;p2++){
                   all.add(nums2[p2]);
               }

            }
            if(p2 == nums2.length){
                for(;p1 != nums1.length;p1++){
                    all.add(nums1[p1]);
                }
            }
            else if(nums1[p1] < nums2[p2]){
                all.add(nums1[p1]);
                p1++;
            }
            else{
                all.add(nums2[p2]);
                p2++;
            }
        }
        System.out.println(all.toString());

        int len = all.size();
        boolean isEven = len % 2 == 0?true:false;
        double result = 0;
        if(isEven){
            double a = all.get(len/2);
            double b = all.get(len/2 - 1);
            System.out.println(a+";"+b);
            result = (a+b)/2;
        }
        else{
            result = all.get(len/2);
        }
        return result;
    }

    // drop off the min and max
    // T = O(m+n) S = O(C)
    public double sol_2(int[] nums1, int[] nums2) {

        if(nums1==null || nums2 == null)
            return 0.0;

        int n1 = nums1.length;
        int n2 = nums2.length;

        // s1 is start of nums1
        //e1 is end of nums1
        int s1 = 0;
        int e1 = n1-1;
        int s2 = 0;
        int e2 = n2-1;
        // terminate untill both arrays have one lement each left   OR
        // if one of these arrays has s>e
        while( ( s1<=e1 && s2<=e2) && !(s1==e1 && s2==e2) )
        {
            // Increment index which is smaller value in comparison to other
            // for left  end of arrays
            if(nums1[s1] < nums2[s2]){
                s1++;
            }
            else{
                s2++;
            }

            // Decrement index which is larger value in comparison to other
            // for right  end of arrays
            if(nums1[e1] > nums2[e2]){
                e1--;
            }
            else{
                e2--;
            }

        }
        // when both arrays are left with one number each
        if(s1==e1 && s2==e2){
            return (nums1[e1] + nums2[e2]) / 2.00;
        }

        // when second array has numbers left and first array is finished up
        if(s1>e1){
            int len = e2-s2+1;
            return (nums2[s2 + len/2] + nums2[s2 + (len-1)/2]) / 2.00;

        }
        // when first array has numbers left and second array is finished up
        if(s2>e2){
            int len = e1-s1+1;
            return (nums1[s1 + len/2] + nums1[s1 + (len-1)/2]) / 2.00;

        }
        return 0.0;
    }


    // find the (m+n)/2 th number when m+n is odd
    // find the a = (m+n)/2 th and b = (m+n)/2 + 1 th number, result = (a+b)/2
    // T = O(log(m+n)), S = O(C)
    public double sol_3(int[] nums1, int[] nums2) {
        if(nums1==null || nums2 == null)
            return 0.0;

        int n1 = nums1.length;
        int n2 = nums2.length;
        int tot = n1+n2;

        if((tot)%2 == 0)
        {
            return (findkth(0,nums1,0,nums2,(tot+1)/2) + findkth(0,nums1,0,nums2,(tot+2)/2) )/2.0 ;
        }
        else{
            return (findkth(0,nums1,0,nums2, tot / 2 + 1))/1.0;
        }
    }

    public int findkth(int sa, int[] a, int sb, int[] b, int k){
        // System.out.println(sa + ", " + sb + " , " + k);
        if(sa >= a.length)
            return b[sb+k-1];

        if(sb >= b.length)
            return a[sa+k-1];

        if(k==1)
            return Math.min(a[sa],b[sb]);

        int newa = Integer.MAX_VALUE;
        int newb = Integer.MAX_VALUE;
        int khalfthina = sa + k/2 - 1;

        if(khalfthina < a.length)
            newa = a[khalfthina];

        int khalfthinb = sb + k/2 -1;

        if(khalfthinb < b.length)
            newb = b[khalfthinb];

        if(newa > newb){
            return findkth(sa, a, sb + k / 2, b, k - k / 2);
        }
        else{
            return findkth(sa + k / 2 ,a,sb,b, k - k / 2);
        }

    }



    static public void main(String arg[]){
        p4_Median_of_Two_Sorted_Arrays sol =
                new p4_Median_of_Two_Sorted_Arrays();
        int a[] ={1,3,3,5,6,7,8,9,556,777,997,55234,523556,54444225,222345567};
        int b[] ={2,4,12,23,45,56,77,82,94,103,442,523,4562,5678,425768};
        double re = sol.sol_1(a,b);
        System.out.println(re);
    }
}
