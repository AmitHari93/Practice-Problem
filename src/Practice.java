import java.net.SocketTimeoutException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Practice {

    public static void patternDiamond(Integer n){

        for(int i = 1; i <=n; i++){
            for(int s = n-i; s > 0; s--){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*i -1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int k=n; k>=1;k--){
            for(int s = 0; s < n -k; s++){
                System.out.print(" ");
            }
            for(int j = (2* k -1); j>=1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void halfDiamond(int n){
        for(int i=1; i<=2*n-1; i++){
            if(i<=n) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
            } else{
                for(int k = 1; k<= 2*n-i; k++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_1(int n){
        for(int i=1; i<=n; i++){
            if(i%2==1){
                for(int j=1; j<=i; j++){
                    System.out.print(j%2);
                    System.out.print(" ");
                }
            } else{
                for(int j=0; j<=i-1; j++){
                    System.out.print(j%2);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_2(int n){
        int count = 0;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                count++;
                System.out.print(count);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern_3(int n){
        for(int i=1; i<=n; i++){
            for(int j=1;j<=i; j++){
                System.out.print(j);
            }
            for(int s=0; s<2*(n-i); s++){
                System.out.print(" ");

            }
            for(int k=i; k>0; k--){
                System.out.print(k);

            }
            System.out.println();

        }
    }

    public static void pattern_4(int n){
        for(int i=0; i<n; i++){
            for(char c='A'; c <='A'+i; c++){
                System.out.print(c);
            }
            System.out.println();
        }


    }

    public static void pattern_5(int n){
        for(int i=n; i > 0; i--){
            for(char c = 'A'; c <'A'+i; c++){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void pattern_6(int n){
        char c = 'A';
        for(int i=1; i<= n; i++){
            for(int j=0; j<i; j++){
                System.out.print(c);
            }
            c++;
            System.out.println();
        }
    }

    public static void pattern_7(int n){
        for(int i=0; i<n; i++){
            for(int s=n-i; s > 0; s--){
                System.out.print(" ");
            }
            char c = 'A';
            for(int j=0; j<=i; j++){
                System.out.print(c);
                c++;
            }
            c--;
            for(char k=0; k<i; k++){
                c--;
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void pattern_8(int n){
//        char c = 'A';
//        for(int i=0; i<n; i++){
//            c++;
//        }
//        c--;
//        for(int j =0; j<n; j++){
//            char p = c;
//            for(char k = 0; k<=j ; k++){
//                System.out.print(p);
//                p++;
//            }
//            c--;
//            System.out.println();
//        }
        for(int i=0; i<n; i++){
            for(char c = (char)('A'+ n-1-i); c <= (char)(int)'A'+n-1; c++){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void prefix_sum(int[] array){
        int sum = 0;
        int ans = -1;
        int prefix_sum = 0;
        for (int k : array) {
            sum += k;
        }
        for (int j=0; j< array.length; j++) {
            sum  = sum - array[j];
            if(sum == prefix_sum) ans = j;
            prefix_sum += array[j];
        }
        if(ans != -1) System.out.println(ans);
        else System.out.println("No");
    }

    public static int findInversionPair(int[] arr){
        int count_0 = 0 , count_1 = 0;
        int inversion_pair = 0;
        for (int j : arr) {
            if (j == 1) count_1 ++;
            else {
                count_0 ++;
                inversion_pair += count_1;
            }
        }
        System.out.println("count_0: "+count_0 + " count_1: " +count_1 + " total inversion: "+ inversion_pair);
        return getMaxInversion(arr, inversion_pair, count_0);
    }

    private static int getMaxInversion(int[] arr, int inversion_pair, int count_0) {
        int max_inversion = inversion_pair;
        int one = 0;
        int zero = 0;

        for(int i : arr){
            int new_inversion_pair;
            if(i==1){
                new_inversion_pair = inversion_pair + one - (count_0 - zero) ;
                one ++;
            }
            else{
                zero ++;
                new_inversion_pair = inversion_pair + (count_0 - zero) - one;
            }
            if(new_inversion_pair > max_inversion) max_inversion = new_inversion_pair;
        }
        return max_inversion;
    }

    // Binary search problem

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for(int num: nums){
            if(num > 0){
                positive.add(num);
            }else{
                negative.add(num);
            }
        }
        for(int i=0; i<n; i += 2){
            nums[i] = positive.get(i/2);
            nums[i+1] = negative.get(i/2);
        }
        return nums;
    }
    public int lenOfLongestSubArray(int[] arr, int k) {
        int n = arr.length;
        int max_len =0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i< n; i++){
            sum += arr[i];
            if(sum == k){
                max_len = Math.max(max_len, i+1);
            }
            if(!map.containsKey(sum-k)){
                map.put(sum, i);
            }else{
                int len = i - map.get(sum-k);
                max_len = Math.max(max_len, len);
            }
        }
        return max_len;
    }

    public int longestConsecutive(int[] nums) {
        int max_length = 0, count_length=1;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=1; i<n; i++){
            if(nums[i] - nums[i-1] == 1) count_length++;
            else if (nums[i]-nums[i-1] > 1) {
                max_length = Math.max(max_length, count_length);
                count_length = 1;
            }
        }
        max_length = Math.max(max_length, count_length);
        return max_length;
    }

    public List<Integer> majorityElement(int[] nums) {
        int count_1=0, count_2=0, el_1=Integer.MIN_VALUE,el_2=0;
        List<Integer> ans = new ArrayList<>();
        for(int num: nums){
            if(count_1 == 0 && num != el_2){
                count_1++;
                el_1 = num;
            } else if (count_2 == 0 && num != el_1) {
                count_2++;
                el_2 = num;
            }
            else {
                count_1--;
                count_2--;
            }
        }
        count_1 = 0;
        count_2=0;
        int res = Math.floorDiv(nums.length, 3);
        for(int num: nums){
            if(num == el_1) count_1++;
            if(num == el_2) count_2++;
        }
        if(count_1 > res) ans.add(el_1);
        if(count_2 > res) ans.add(el_2);
        return ans;
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        if(nums[0] > nums[1]) return 0;
        if (nums[n-1] > nums[n-2]) return n-1;
        int low=1, high=n-2;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if (nums[mid] > nums[mid-1]) {
                low=mid+1;
            } else if (nums[mid] > nums[mid+1]) {
                high = mid-1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<n-1; i++){
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]) ans.add(i);
        }
        return ans;
    }

    public int countHillValley(int[] nums) {
        int n = nums.length;
        int hill=0, valley=0;
        for(int i=1; i<n-1; i++){
            if(nums[i]==nums[i+1]){
                int rep = 0, c=i;
                while(nums[c]==nums[c+1]){
                    rep++;
                    c++;
                }
                if(nums[i] > nums[i-1] && nums[i] > nums[c+1]){
                    hill++;
                    i++;
                } else if (nums[i] < nums[i-1] && nums[i] < nums[c+1]) {
                    valley++;
                    i++;
                }
                else {
                    i+=c;
                }

            }else{
                if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) hill++;
                if(nums[i] < nums[i-1] && nums[i] < nums[i+1]) valley++;
            }
        }
        return hill+valley;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int totalFlowers = m*k;
        int size = bloomDay.length;
        if(totalFlowers > size) return -1;
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: bloomDay){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int low = min, high=max;
        while(low <= high){
            int days = (low+high)/2;
            int bouquets = getBouguets(days, bloomDay, k);
            if(bouquets <= m) low = bouquets+1;
            else{
                high = bouquets-1;
            }
        }
        return low;
    }
    public int getBouguets(int day, int[] bloomDays, int pair){
        int count=0, bouguets=0;
        for(int bloomDay: bloomDays){
            if(bloomDay <= day) count++;
            else{
                bouguets += (count/pair);
                count=0;
            }
        }
        bouguets += (count/pair);
        return bouguets;
    }

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int l = 0, h=n-1;
        while(l <= h){
            int mid = (l+h)/2;
            int missing = arr[mid] -(mid+1);
            if(missing < k){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return l+k;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i< row; i++){
            int l=0, h = col-1;
            while(l <= h){
                int mid = (l+h)/2;
                if(matrix[i][mid]==target) return true;
                else if (matrix[i][mid] < target) {
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
        }
        return false;
    }

    int floorSqrt(int n) {
        // Your code here
        int l=1, h = n/2;
        while(l<=h){
            int mid = (l+h)/2;
            if(mid * mid == n)  return mid;
            else if (mid*mid < n) {
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return h;
    }
    public int nthRoot(int n, int m) {
        // code here
        int l = 1, h = m/n+1;
        while(l<=h){
            int mid = (l+h)/2;
            double val=Math.pow(mid, n);
//            while(n>0){
//                val *= mid;
//                n--;
//            }

            if(val == m) return mid;
            else if (val<m) {
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return -1;
    }

    // Hashing problem
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int i=1; i<=n; i++){
            ans.add(map.getOrDefault(i, 0));
        }
        return ans;
    }

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int max_rep=0,l=0,r=0, total=0;
        while(r < n){
            total += nums[r];
            while(nums[r]*(r-l+1) > total+k){
                total -= nums[l];
                l++;
            }
            max_rep = Math.max(max_rep, (r-l+1));
            r++;
        }
        return max_rep;
    }

    // Link list Problems

    public int countNodesInLoop(ListNode head) {
        // Add your code here.
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                int count = 1;
                fast = fast.next;
                while (slow != fast){
                    count++;
                    fast=fast.next;
                }
                return count;
            }
        }
        return 0;
    }


    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode left = head, right = middle.next;
        middle.next=null;
        left = sortList(left);
        right = sortList(right);
        return mergeLL(left, right);

    }
    public ListNode findMiddle(ListNode head){
        if(head==null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeLL(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode tmp = dummyNode;
        while(list1!=null && list2 !=null){
            if(list1.val <= list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }else{
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        if(list1!=null){
            tmp.next=list1;
        }
        if(list2!=null){
            tmp.next = list2;
        }
        return dummyNode.next;
    }

    public static void main(String[] args){
//        patternDiamond(3);
//        halfDiamond(5);
//        pattern_8(4);
        int[] array = {1,0,1,1,0,0,0,1};
//        for (int j : array) {
//            System.out.println(j);
//        }
//        prefix_sum(array);
        String s ="abc";
        char[] a = s.toCharArray();
        char[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        boolean q = Arrays.equals(a, b);
        System.out.println(findInversionPair(array));
    }
}
