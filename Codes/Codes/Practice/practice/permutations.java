package practice;

import java.util.ArrayList;
import java.util.List;

public class permutations {
    public static void printPerm(String str, String perm) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPerm(newStr, perm + currChar);
        }
    }

    // Leetcode 46 Permutations
    // Given an array nums of distinct integers, return all the possible permutations
    // You can return the answer in any order.
    // Example 1:
    // Input: nums = [1,2,3]
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, ans);
        return ans;
    }

    public void backtrack(List<Integer> temp, int[] nums, List<List<Integer>> ans) {
        if (temp.size() == nums.length)
            ans.add(new ArrayList<>(temp));
        else {
            for (int num : nums) {
                if (temp.contains(num))
                    continue;
                temp.add(num);
                backtrack(temp, nums, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "Rutam";
        printPerm(str, "");
    }
}
