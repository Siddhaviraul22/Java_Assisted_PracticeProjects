package practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        // Example usage
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();

            System.out.println("Enter the elements:");

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }

            List<Integer> longestIncreasingSubsequence = findLongestIncreasingSubsequence(numbers);

            // Print the result
            System.out.println("Longest Increasing Subsequence: " + longestIncreasingSubsequence);
        } finally {
            // Close the Scanner to prevent resource leak
            scanner.close();
        }
    }
    public static List<Integer> findLongestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(nums[endIndex]);

        for (int i = endIndex - 1; i >= 0; i--) {
            if (nums[i] < nums[endIndex] && dp[i] == dp[endIndex] - 1) {
                result.add(nums[i]);
                endIndex = i;
            }
        }

        // Reverse the list to get the correct order
        List<Integer> reversedResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            reversedResult.add(result.get(i));
        }

        return reversedResult;
    }
}