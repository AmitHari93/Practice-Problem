package LeetCodeProblems;

import java.security.cert.CollectionCertStoreParameters;
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

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length, prefix=1, suffix=1;
        for(int i=0; i< n; i++){
            if(prefix==0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
    public List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<= numRows; i++){
            ans.add(generateNthRowValues(i));
        }
        return ans;
    }
    public static List<Integer> generateNthRowValues(int row){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long res = 1;
        for(int col = 1; col < row; col++){
            res = res * (row - col);
            res = res/col;
            ans.add((int)res);
        }
        return ans;
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

    // stack and Queue

    public static boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '(' || s.charAt(i)== '{'|| s.charAt(i)== '['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()) return false;
                else if(s.charAt(i)==')' && stack.peek()=='(') stack.pop();
                else if(s.charAt(i)=='}' && stack.peek()=='{') stack.pop();
                else if(s.charAt(i)==']' && stack.peek()=='[') stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        int n = nums2.length;
        for(int i=n-1; i>=0; i--){
            if(s.isEmpty()){
                map.put(nums2[i], -1);
                s.push(nums2[i]);
            }else{
                while(!s.isEmpty() && s.peek() < nums2[i]){
                    s.pop();
                }
                if(s.isEmpty()) map.put(nums2[i], -1);
                else{
                    map.put(nums2[i], s.peek());
                    s.push(nums2[i]);
                }
            }

        }
        int[] ans = new int[nums1.length];
        for(int i=0; i< ans.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=2*n-1; i>=0; i--){
            while(!s.isEmpty() && s.peek() <= nums[i % n]){
                s.pop();
            }
            if(i<n){
                ans[i] = s.isEmpty() ? -1 : s.peek();
            }
            s.push(nums[i%n]);
        }
        return ans;

    }
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && s.peek() >= A[i]){
                s.pop();
            }
            ans[i] = s.isEmpty() ? -1 : s.peek();
            s.push(A[i]);
        }
        return ans;
    }

    public int sumSubarrayMinimum(int[] arr) {
        int n = arr.length;
        int[] left = previousSmallElement(arr);
        int[] right = nextSmallElement(arr);
        long sum = 0;
        //int mod = 1000000007;
        for(int i=0; i<n; i++){
            int l = i- left[i];
            int r = right[i] - i;
            sum += (long) l * r  * arr[i];
        }
        return (int)sum;
    }
    public int[] previousSmallElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s1 = new Stack<>();
        for(int i=0; i<n; i++){
            while(!s1.isEmpty() && arr[s1.peek()] > arr[i]){
                s1.pop();
            }
            ans[i] = s1.isEmpty() ? -1 : s1.peek();
            s1.push(i);
        }
        return ans;
    }
    public int[] nextSmallElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s2 = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!s2.isEmpty() && arr[s2.peek()] >= arr[i]){
                s2.pop();
            }
            ans[i] = s2.isEmpty() ? n : s2.peek();
            s2.push(i);
        }
        return ans;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                s.push(asteroid);
            } else {
                while(!s.isEmpty()){
                    if(s.peek() == Math.abs(asteroid)) s.pop();
                    else if (s.peek() < Math.abs(asteroid)) {
                        s.pop();
                        s.push(asteroid);
                    }
                }
                s.push(asteroid);
            }
        }
        int size = s.size();
        int[] ans = new int[size];
        for(int i=size-1; i>=0; i--){
            ans[i] = s.pop();
        }
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        int minSum = sumSubarrayMinimum(nums);
        int maxSum = sumSubarrayMaximum(nums);
        return maxSum-minSum;
    }
    public int sumSubarrayMaximum(int[] nums){
        int[] nge = nextGreaterElement(nums);
        int[] pge = previousGreaterElement(nums);
        long sum=0;
        for(int i=0; i<nums.length; i++){
            int l = i - pge[i];
            int r = nge[i] -i;
            sum += (long) l * r * nums[i];
        }
        return (int)sum;
    }
    public int[] nextGreaterElement(int[] nums){
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[nums.length];
        for(int i= nums.length-1; i>=0; i--){
            while(!s.isEmpty() && s.peek() <= nums[i]){
                s.pop();
            }
            nge[i] = s.isEmpty() ? nums.length : s.peek();
            s.push(i);
        }
        return nge;
    }
    public int[] previousGreaterElement(int[] nums){
        Stack<Integer> s = new Stack<>();
        int[] pge = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!s.isEmpty() && s.peek() < nums[i]){
                s.pop();
            }
            pge[i] = s.isEmpty() ? nums.length : s.peek();
            s.push(i);
        }
        return pge;
    }

    public String removeKDigits(String num, int k) {
        int removeDigits = k;
        Stack<Character> s = new Stack<>();
        for(int i=0; i<num.length(); i++){
            while(removeDigits > 0 && !s.isEmpty() && s.peek()-'0' > num.charAt(i)-'0'){
                removeDigits--;
                s.pop();
            }
            s.push(num.charAt(i));
        }
        while(removeDigits > 0){
            s.pop();
            removeDigits--;
        }
        if(s.isEmpty()) return "0";
        StringBuilder ans = new StringBuilder();
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        while(!ans.isEmpty() && ans.charAt(ans.length()-1)=='0'){
            ans.setLength(ans.length()-1);
        }
        return ans.reverse().toString();
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] pMax = prefixMax(height);
        int[] sMax = suffixMax(height);
        int sumOfWaterTrapped = 0;
        for(int i=0; i<n; i++){
            if(pMax[i] < height[i] && height[i] < sMax[i]){
                sumOfWaterTrapped += Math.min(pMax[i], sMax[i]) - height[i];
            }
        }
        return sumOfWaterTrapped;
    }
    public int[] prefixMax(int[] nums){
        int[] preMax = new int[nums.length];
        preMax[0] = nums[0];
        for(int i=1; i< nums.length; i++){
            preMax[i] = Math.max(preMax[i-1], nums[i]);
        }
        return preMax;
    }

    public int[] suffixMax(int[] nums){
        int[] sufMax = new int[nums.length];
        sufMax[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--){
            sufMax[i] = Math.max(sufMax[i+1], nums[i]);
        }
        return sufMax;
    }

    // Sliding window and two pointers

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l=0, r=0, max_length=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r < n){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l){
                l = map.get(s.charAt(r)) + 1;
                map.put(s.charAt(r), r);
            }
            max_length = Math.max(max_length, r-l+1);
            map.put(s.charAt(r), r);
            r++;
        }
        return max_length;
    }
    public int longestOnes(int[] nums, int k) {
        int max_consecutive_one =0, l=0,r=0,count_0=0;
        while(r < nums.length){
            if(nums[r] == 0) count_0++;
            while (count_0 > k){
                if(nums[l]==0) count_0--;
                l++;
            }
            max_consecutive_one = Math.max(r - l + 1, max_consecutive_one);
            r++;
        }
        return max_consecutive_one;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] map = new int[26];
        int max_length=0, max_freq=0, l=0,r=0;
        while(r < n){
//            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
//            max_freq = Math.max(max_freq, map.get(s.charAt(r)));
//            if((r-l+1) - max_freq > k){
//                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
//                l++;
//            }
            int ch = s.charAt(r) - 65;
            map[ch]++;
            max_freq = Math.max(max_freq, map[ch]);
            if((r-l+1) - max_freq > k){
                map[s.charAt(l)-65]--;
                l++;
            }
            else{
                max_length = Math.max(max_length, r-l+1);
            }
            r++;
        }
        return max_length;
    }
    public int numSubArraysWithSum(int[] nums, int goal) {
        return numSubArrayWithSumLeseOrEqualK(nums, goal) - numSubArrayWithSumLeseOrEqualK(nums, goal-1);
    }
    public int numSubArrayWithSumLeseOrEqualK(int[] nums, int k){
        int sum=0,l=0,r=0,noOfSubArrays=0;
        while(r < nums.length){
            sum += nums[r];
            if(k < 0) return 0;
            while(sum > k){
                sum -= nums[l];
                l++;
            }
            noOfSubArrays += r-l+1;
            r++;
        }
        return noOfSubArrays;
    }
    public int numberOfSubArrays(int[] nums, int k) {
        return numberOfSubArraysLessOrEqualK(nums, k) - numberOfSubArraysLessOrEqualK(nums, k-1);
    }
    public int numberOfSubArraysLessOrEqualK(int[] nums, int k) {
        int noOfOdd=0, totalSubArrays=0, l=0,r=0;
        if(k < 0) return 0;
        while(r < nums.length){
            noOfOdd += isOddNumber(nums[r]) ? 1 : 0;
            while(noOfOdd > k){
                noOfOdd -= isOddNumber(nums[l]) ? 1 : 0;
                l++;
            }
            totalSubArrays += r-l+1;
            r++;
        }
        return totalSubArrays;
    }
    public boolean isOddNumber(int number){
        return number % 2 == 1;
    }
    public int numberOfSubstrings(String s) {
        int r=0, noOfSubstring=0;
        int[] hash = {-1, -1,-1};
        while(r < s.length()){
            int ch = s.charAt(r) - 'a';
            hash[ch] = r;
            if( hash[0] >= 0 && hash[1] >= 0 && hash[2] >= 0){
                int minIndex = Math.min(Math.min(hash[0], hash[1]), hash[2]);
                noOfSubstring += (minIndex + 1);
            }
            r++;
        }
        return noOfSubstring;
    }
    public int maxScore(int[] cardPoints, int k) {
        int l=0,r=0,sum=0, totalPoints=0, maxSum=Integer.MIN_VALUE, window=0;
        int n = cardPoints.length;
        for(int cardPoint: cardPoints){
            totalPoints += cardPoint;
        }
        if(n==k) return totalPoints;
        while(r < n){
            sum += cardPoints[r];
            window++;
            if(window == n-k) maxSum = Math.max(maxSum, totalPoints-sum);
            else if (window > n-k) {
                sum -= cardPoints[l];
                window--;
                l++;
                maxSum = Math.max(maxSum, totalPoints-sum);
            }
            r++;
        }
        return maxSum;
    }

    // Heap and Priority Queues

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int num: nums){
            pq.add(num);
        }
        int f = k-1;
        while(f > 0){
            pq.remove();
            f--;
        }
        return !pq.isEmpty() ? pq.peek() : -1;
    }
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: arr){
            pq.add(num);
        }
        int f = k-1;
        while(k > 0){
            pq.remove();
            f--;
        }
        return !pq.isEmpty() ? pq.peek() : -1;
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< K; i++){
            for(int j=0; j < K; j++){
                pq.add(arr[i][j]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        return ans;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode node: lists){
            while(node!= null){
                pq.add(node.val);
                node = node.next;
            }
        }
        if(pq.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(pq.remove());
        ListNode tmp = head;
        while (!pq.isEmpty()){
            tmp.next = new ListNode(pq.remove());
            tmp = tmp.next;
        }
        return head;
    }

    // Greedy Algorithm

    public int findContentChildren(int[] g, int[] s) {
        int l=0, r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l < g.length && r < s.length){
            if(g[l] <= s[r]){
                l++;
                r++;
            } else if (g[l] > s[l]) {
                r++;
            }else{
                l++;
            }
        }
        return r;
    }
    public boolean lemonadeChange(int[] bills) {
        int count_5 = 0, count_10=0, r=0;
        while(r < bills.length){
            if(bills[r] == 5) count_5++;
            else{
                 if (bills[r] == 10 && count_5 > 0) {
                        count_5--;
                        count_10++;
                 }
                 else if (bills[r] == 20 && count_5 > 0) {
                     if (count_10 > 0) {
                         count_10--;
                         count_5--;
                     }
                     else if (count_5 >= 3) {
                         count_5 -= 3;
                     }else{
                         return false;
                     }
                 }else{
                     return false;
                 }
            }
            r++;
        }
        return true;
    }
    public int minCoins(int coins[], int sum) {
        // Your code goes here
        Arrays.sort(coins);
        int count_taken=0;
        for(int i= coins.length-1; i >= 0; i--){
            while (coins[i] <= sum){
                count_taken++;
                sum -= coins[i];
            }
        }
        return sum > 0 ? -1 : count_taken;
    }
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        Item[] items = new Item[val.size()];
        for(int i=0; i< val.size(); i++){
            items[i] = new Item(val.get(i), wt.get(i));
        }
        return fractionalKnapsackSolution(items, capacity);
    }
    public double fractionalKnapsackSolution(Item items[], int capacity){
        Arrays.sort(items, new ItemIterator());
        double totalProfit = 0;
        int currWeight = 0;
        for(int i= 0; i < items.length; i++){
            if(currWeight + items[i].weight <= capacity){
                currWeight += items[i].weight;
                totalProfit += items[i].value;
            }else{
                int remWeight = capacity - currWeight;
                totalProfit += ((double) items[i].value / (double) items[i].weight) * (double) remWeight;
                break;
            }
        }
        return totalProfit;
    }
    public static boolean checkValidString(String s) {
//        int left=0, right=0, star=0;
//        for(int i=0; i< s.length(); i++){
//            if(s.charAt(i)=='(') left++;
//            else if (s.charAt(i)==')') {
//                right++;
//            }else{
//                star++;
//            }
//        }
//        System.out.println("left: "+ left + "right: " + right +  "star: "+ star);
//        int diff = left > right ? left-right : right-left;
//        if(left==right) return true;
//        else return diff <= star;
        int min =0, max=0;
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)=='('){
                min += 1;
                max += 1;
            } else if (s.charAt(i)==')') {
                min -= 1;
                max -= 1;
            }else{
                min -= 1;
                max += 1;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min==0;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return true;
        int r = n-2, target = n-1;
        while(r >= 0){
            if(nums[r] >= target-r) target = r;
            r--;
        }
        return target == 0;
    }
    public int jump(int[] nums) {
        int l=0, r=0, countJumps=0, farthest;
        while(r < nums.length-1){
            farthest = 0;
            for(int i=l; i<= r; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r+1;
            r = farthest;
            countJumps++;
        }
        return countJumps;
    }
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        ScheduleTime[] meetings = new ScheduleTime[start.length];
        for(int i=0; i<start.length; i++){
            meetings[i] = new ScheduleTime(start[i], end[i]);
        }
        Arrays.sort(meetings, new ScheduleIterator());
        int noOfMeetings = 0, meetingEndTime = -1;
        for (ScheduleTime meeting : meetings) {
            if (meeting.start > meetingEndTime) {
                noOfMeetings++;
                meetingEndTime = meeting.end;
            }
        }
        return noOfMeetings;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int row = intervals.length;
        int l=0;
        List<int[]> ans = new ArrayList<>();
        while(l < row && intervals[l][1] < newInterval[0]){
            ans.add(intervals[l]);
            l++;
        }
        while(l < row && intervals[l][0] < newInterval[1]){
            newInterval[0] = Math.min(intervals[l][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[l][1], newInterval[1]);
            l++;
        }
        ans.add(newInterval);
        while(l < row){
            ans.add(intervals[l]);
            l++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i=1, min = intervals[0][0], max = intervals[0][1];
        while(i < intervals.length){
            if(max >= intervals[i][0]){
                max = Math.max(max, intervals[i][1]);
            }else{
                ans.add(new int[] {min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
            i++;
        }
        ans.add(new int[] {min, max});
        return ans.toArray(new int[0][]);
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int size = intervals.length;
        return size - findMaximumNonOverLappingIntervals(intervals);
    }
    public int findMaximumNonOverLappingIntervals(int[][] intervals){
        ScheduleTime[] meetings  = new ScheduleTime[intervals.length];
        for(int i=0; i< intervals.length; i++){
            meetings[i] = new ScheduleTime(intervals[i][0], intervals[i][1]);
        }
        //Arrays.sort(meetings, new ScheduleIterator());
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int noOfNonOverlapping  = 1, r=1, endTime = intervals[0][1];
        while(r < intervals.length){
            if(intervals[r][0] > endTime){
                noOfNonOverlapping++;
                endTime = intervals[r][1];
            }
            r++;
        }
        return noOfNonOverlapping;
    }
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0, platformReq=1, ans=1;
        while(i < arr.length && j < dep.length){
            if(arr[i] <= dep[j]){
                platformReq++;
                i++;
            } else if (arr[i] > dep[j]) {
                platformReq--;
                j++;
            }
            if(platformReq > ans) ans = platformReq;
        }
        return ans;

    }
    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
        ArrayList<Integer> ans = new ArrayList<>();
        int maxDeadLine = Integer.MIN_VALUE;
        Job[] jobs = new Job[deadline.length];
        for(int i=0; i< deadline.length; i++){
            jobs[i] = new Job(id[i], profit[i], deadline[i]);
            maxDeadLine = Math.max(maxDeadLine, deadline[i]);
        }
        int[] arr = new int[maxDeadLine + 1];
        Arrays.sort(jobs, new JobsComparator());
        for(int i=0; i< maxDeadLine+1; i++){
            arr[i] = -1;
        }
        int r=0, totalProfit=0, countJobs=0;
        while(r < jobs.length){
            for(int j = jobs[r].deadline; j>=1; j--){
                if(arr[j]==-1){
                    totalProfit += jobs[r].profit;
                    countJobs++;
                    break;
                }
            }
            r++;
        }
        ans.add(countJobs);
        ans.add(totalProfit);
        return ans;
    }

    // Strings Problems

    public String reverseWords(String s) {
        int l=0, r = s.length();
        String ans = "", res = "";
        while( l < r){
            if(s.charAt(l) != ' '){
                res += s.charAt(l);
            } else if (s.charAt(l) == ' ') {
                if(!ans.equals("")){
                    ans = res + " " + ans;
                }else{
                    ans = res;
                }
                res = "";
            }
            l++;
        }
        if(!res.equals("")){
            if(!ans.equals("")){
                ans = res + " " + ans;
            }else{
                ans = res;
            }
        }
        return ans;
    }
    public String largestOddNumber(String num) {
//        int n = num.length();
//        int l=0, r=n-1;
//        while(r >=0){
//            if((int) num.charAt(r) % 2 == 1) break;
//            r--;
//        }
//        String ans = "";
//        while(l <= r){
//            ans += num.charAt(l);
//            l++;
//        }
//        return ans;
        int max = -1;
        max = Math.max(max, num.lastIndexOf('1'));
        max = Math.max(max, num.lastIndexOf('3'));
        max = Math.max(max, num.lastIndexOf('5'));
        max = Math.max(max, num.lastIndexOf('7'));
        max = Math.max(max, num.lastIndexOf('9'));
        if(max==-1) return "";
        return num.substring(0, max+1);
    }
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String toMatch = strs[0];
        for(int m=1; m < n; m++){
            String s = strs[m];
            int l=0, match = 0;
            while(l < s.length() && l < toMatch.length()){
                if(toMatch.charAt(l) == s.charAt(l)){
                    match++;
                }else {
                    break;
                }
                l++;
            }
            if(match > 0) toMatch = toMatch.substring(0, match);
            else{
                return "";
            }
        }
        return toMatch;
    }
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[200];
        int[] map2 = new int[200];
        for(int i=0; i< s.length(); i++){
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            map1[s.charAt(i)] = i+1;
            map2[t.charAt(i)] = i+1;
        }
        return true;
    }
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        s = s+goal;
        int l=0, n = goal.length();
        for(int i=0; i< goal.length(); i++){
            String subString = s.substring(l, n);
            if(subString.equals(goal)) return true;
            l++;
            n++;
        }
        return false;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(int i=0; i< s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0; i< t.length(); i++){
            freq[t.charAt(i) - 'a']--;
        }
        for(int j=0; j< 26; j++){
            if(freq[j] != 0) return false;
        }
        return true;
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
            int l = characterIntegerEntry.getValue();
            Character c = characterIntegerEntry.getKey();
            while (l > 0) {
                ans.append(c);
                l--;
            }
        }
        return ans.toString();
    }
    public int romanToInt(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = map.get(s.charAt(n-1));
        char lastSeen = s.charAt(n-1);
        if(n==1) return sum;
        for(int i = n-2; i>=0; i--){
            if(map.get(s.charAt(i)) >= map.get(lastSeen)){
                sum += map.get(s.charAt(i));
            }else {
                sum -= map.get(s.charAt(i));
            }
            lastSeen = s.charAt(i);
        }
        return sum;
    }
    public int maxDepth(String s) {
        Stack<Character> sk = new Stack<>();
        int max = 0;
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)=='('){
                sk.push(s.charAt(i));
            } else if (s.charAt(i)==')') {
                max = Math.max(max, sk.size());
                sk.pop();
            }
        }
        return max;
    }
    public int minAddToMakeValid(String s) {
        Stack<Character> sk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(sk.isEmpty()) sk.push(s.charAt(i));
             else if (s.charAt(i)== ')' && sk.peek()=='(') {
                sk.pop();
            }
            sk.push(s.charAt(i));
        }
        return sk.size();
    }

    // Recursion Problems

    public double myPow(double x, int n) {
        long k = n;
        double ans = 1.0;
        if(k < 0) k = -1 * k;
        while(k > 0){
            if(k % 2 == 1){
                ans = ans * 2;
                k --;
            }else{
                x = x * x;
                k = k /2;
            }
        }
        if( n < 0) return 1.0 /ans;
        return ans;

    }
    static void reverse(Stack<Integer> s) {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        reverseStack(q, s);
        while(!q.isEmpty()){
            s.push(q.poll());
        }
    }
    public static void reverseStack(Queue<Integer> q, Stack<Integer> s){
        if(s.isEmpty()) return;
        q.add(s.pop());
        reverseStack(q, s);
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        List<Integer> arr = new ArrayList<>();
        getElement(arr, s);
        arr.sort((a,b)->b-a);
        for(int i=arr.size()-1; i >=0; i--){
            s.push(arr.get(i));
        }
        return s;
    }
    public void getElement(List<Integer> ans, Stack<Integer> s){
        if(s.isEmpty()) return;
        ans.add(s.pop());
        getElement(ans, s);
    }
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long even = (n+1) / 2;
        long odd = n / 2;
        long a = powX(5, even, mod);
        long b = powX(4, odd, mod);
        return (int) (a * b % mod);
    }
    public long powX(long x, long n, long M){
        double ans = 1.0;
        while(n > 0){
            if(n%2==1){
                ans = ans * x % M;
                n--;
            }else{
                x = x*x % M;
                n = n/2;
            }
        }
        return (long) ans % M;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans  = new ArrayList<>();
        findCombinations(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    public void findCombinations(int index, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds){
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[index] <= target){
            //pick the index element
            ds.add(arr[index]);
            findCombinations(index, target-arr[index], arr, ans, ds);
            ds.remove(ds.size()-1);
        }
        // not picking the index element
        findCombinations(index + 1, target, arr, ans, ds);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinationsWithoutRepeat(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
    public void findCombinationsWithoutRepeat(int index, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            findCombinationsWithoutRepeat(i+1, target-arr[i], arr, ans, ds);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args){
        System.out.println(generateNthRowValues(1));
//        patternDiamond(3);
//        halfDiamond(5);
//        pattern_8(4);
//        int[] array = {1,0,1,1,0,0,0,1};
//        for (int j : array) {
//            System.out.println(j);
//        }
//        prefix_sum(array);
//        String s ="abc";
//        char[] a = s.toCharArray();
//        char[] b = Arrays.copyOf(a, a.length);
//        Arrays.sort(b);
//        boolean q = Arrays.equals(a, b);
//        System.out.println(findInversionPair(array));
    }
}
