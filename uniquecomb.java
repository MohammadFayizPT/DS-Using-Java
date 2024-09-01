// class uniquecomb {
//     static int res = 0;
//     public static void main(String args[]) {
//         int n = 7;
//         int k = 8;
//         int a[] = {10, 1, 2, 7, 6, 1, 5};

//         for (int i = 0; i < n; i++)
//             findcombinations(a, k, a[i]);

//         System.out.println(res);
//     }

//     public static void findcombinations(int[] a, int k, int sum) {
//         if (sum > k) return;
//         if (sum == k) {
//             res++;
//             return;
//         }

//         for (int i = 0; i < a.length; i++) {
//             findcombinations(a, k, sum + a[i]);
//         }
//     }
// }

import java.util.*;

public class uniquecomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(arr); // Sorting for potential optimization (not strictly necessary)
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(arr, new ArrayList<>(), k, combinations, 0);
        System.out.println(combinations.size());
    }

    private static void backtrack(int[] arr, List<Integer> current, int target, List<List<Integer>> combinations, int start) {
        if (target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (arr[i] > target) {
                break;
            }
            current.add(arr[i]);
            backtrack(arr, current, target - arr[i], combinations, i + 1);
            current.remove(current.size() - 1);
        }
    }
}