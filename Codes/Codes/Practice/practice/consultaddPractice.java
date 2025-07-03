package practice;
// package Codes;

// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.function.Function;

// public class consultaddPractice {
//     // Problem Statement : 1
//     // The number of goals achieved by two football teams in matches in a league is
//     // given in the form of two lists. For each match of team B. Compute the total
//     // number of matches of team A where team A has scored less than or equal to the
//     // number of goals scored by team B in that match.

//     // Example :
//     // team A =[ 1,2,3]
//     // team B =[ 2,4]
//     // Team A has played three matches and has scored team A =[1,2,3] goals in each
//     // match respectively. Team B has played two matches and has scored team B =
//     // [2,4] goals in each match respectively. For 2 goals scored by team B in its
//     // first match, team A has 2 matches with scores 1,2 and 3 hence , the answer is
//     // [2,3].

//     // Function Description :

//     // Complete the function counts in the editor below.

//     // Counts has the following parameters:
//     // int teamA(n): First array of positive integers
//     // int teamB(m): Second array of positive integers

//     // Return :
//     // int(m): an array of m positive integers, one for each teamB[i] representing
//     // the total number of elements from teamA[j] satisfying teamA[j]<_ teamB[i]
//     // where 0<_j<n and 0<_i< m, in the given order.

//     // Constraints :
//     // 2<_n, m<_10^5
//     // 1<_ teamA[j]<_10^9,where 0<_j<n.
//     // 1<_ teamB[i]<_10^9,where 0<_j<m

//     // Input format for custom Testing :
//     // Input from stdin will be processed as follows and passed to the functions.

//     // The first line contains an integer n, the number of elements in teamA.
//     // The next n lines each contain an integer describing teamA[j] where 0<_j<n.
//     // The next line contains an integer m, the number of elements in teamB.
//     // The next m lines each contain an integer describing teamB[i]where 0<_i<m.

//     // Sample input 0 :
//     // 4 -> teamA[] size n = 4
//     // 1 -> teamA = [1,4,2,4]
//     // 4
//     // 2
//     // 4
//     // 2-> teamB [] size m = 2
//     // 3-> teamB = [3,5]
//     // 5

//     // Sample ōutput 0 :
//     // 2
//     // 4

//     // Explanation 0 :
//     // Given values are n =4, team A = [1,4,2,4], m= 2, and teamB = [3,5].
//     // For teamB[0] = 3, we have 2 elements in teamA(teamA[0] = 1 and teamA[2] = 2)
//     // that are <_ teamB[0].
//     // For teamB[1] = 5, we have 4 elements in teamA(teamA[0] = 1, teams[1] =4,
//     // teamA[2] = 2, and teamA[3] =4) that are <_teamB[1].
//     // Thus , the function returns the array [2,4] as the answer.

//     // public static void main(String[] args) {
//     // Scanner sc = new Scanner(System.in);
//     // int n = sc.nextInt();
//     // int[] teamA = new int[n];
//     // for(int i = 0 ; i < n ; i++){
//     // teamA[i] = sc.nextInt();
//     // }
//     // int m = sc.nextInt();
//     // int[] teamB = new int[m];
//     // for(int i = 0 ; i < m ; i++){
//     // teamB[i] = sc.nextInt();
//     // }

//     // Arrays.sort(teamA);
//     // int[] ans = new int[m];
//     // int index = 0;
//     // for(int numB : teamB){
//     // int count = 0;

//     // for (int numA : teamA) {
//     // if(numA > numB) break;
//     // else count++;
//     // }
//     // ans[index++] = count;
//     // }
//     // for (int i : ans) {
//     // System.out.print(i);
//     // }
//     // }

//     // Question 2 : Share Holder (R -> Hard)

//     // Problem statement :

//     // Ratan is a crazy rich person. And he is blessed with luck, so he always made
//     // the best profit possible with the shares he bought. That means he bought a
//     // share at a low price and sold it at a high price to maximize his profit. Now
//     // you are an income tax officer and you need to calculate the profit he made
//     // with the given values of stock prices each day. You have to calculate only
//     // the maximum profit Ratan earned.
//     // Note that:
//     // Ratan never goes into loss.

//     // Example 1 :

//     // Price=[1,6,2]
//     // Ratan buys it on the first day and sells it on the second.

//     // Example 2 :

//     // Price=[9,8,6]

//     // The Price always went down, Ratan never bought it.

//     // Input Format:
//     // First line with an integer n, denoting the number days with the value of the
//     // stack
//     // Next n days, telling the price of the stock on that very day.

//     // Output Format:
//     // Maximum profit done by Ratan in a single line.
//     // Constraints:
//     // Number of days <=10^8

//     // Sample Input for Custom Testing

//     // STDIN
//     // ———–
//     // 7
//     // 1
//     // 9
//     // 2
//     // 11
//     // 1
//     // 9
//     // 2

//     // Sample Output

//     // 10

//     // Explanation

//     // The maximum profit possible is when Ratan buys it in 1 rupees and sells it in
//     // 11.

//     // public static void main(String[] args) {
//     // Scanner sc = new Scanner(System.in);
//     // int n = sc.nextInt();
//     // int[] days = new int[n];
//     // for (int i = 0; i < n; i++) {
//     // days[i] = sc.nextInt();
//     // }

//     // int left = 0;
//     // int right = 1;
//     // int maxProfit = 0;
//     // for (int i = 0; i < days.length; i++) {
//     // if(days[i] < days[left]){
//     // left = i;
//     // continue;
//     // }
//     // int currProf = days[i] - days[left];
//     // maxProfit = Math.max(maxProfit,currProf);
//     // }
//     // System.out.println(maxProfit);
//     // }

//     // Question 2: Stepping Numbers

//     // Problem Description :

//     // Stepping Numbers are numbers in which the adjacent digits differ by 1. For
//     // example, 123, 545, and 98 are stepping numbers, while 321, 444, and 75 are
//     // not. The task is to find all stepping numbers in a given range [n, m].

//     // For example
//     // Range: [100, 500]
//     // Stepping Numbers: 101, 121, 123, 210, 212, 232, 234, 321, 323, 343, 345
//     // Explanation: The stepping numbers between 100 and 500 are 101, 121, 123, 210,
//     // 212, 232, 234, 321, 323, 343, and 345. These numbers have adjacent digits
//     // that differ by 1.
//     // Write code to find out all the stepping numbers in the given range.

//     // Input Format: First line contains two numbers N,M

//     // Output Format: Print all the stepping numbers present in the range.

//     // Constraints: 0 <= N < M <= 1,000,000,000

//     // DFS
//     public static void backtrack(int num, int n, int m) {
//         if (num > m)
//             return;
//         if (num >= n)
//             System.out.println(num);

//         int lastDigit = num % 10;

//         if (lastDigit > 0)
//             backtrack(num * 10 + (lastDigit - 1), n, m);
//         if (lastDigit < 9)
//             backtrack(num * 10 + (lastDigit + 1), n, m);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         if (n == 0)
//             System.out.println(0);

//         for (int i = 1; i < 10; i++) {
//             backtrack(i, n, m);
//         }
//     }

//     // BFS

//     public class SteppingNumbersBFS {
//         public static void printSteppingNumbers(int n, int m) {
//             if (n == 0)
//                 System.out.println(0);

//             for (int i = 1; i <= 9; i++) {
//                 bfs(n, m, i);
//             }
//         }

//         private static void bfs(int n, int m, int num) {
//             Queue<Integer> queue = new LinkedList<>();
//             queue.add(num);

//             while (!queue.isEmpty()) {
//                 int stepNum = queue.poll();

//                 if (stepNum > m)
//                     continue;
//                 if (stepNum >= n)
//                     System.out.println(stepNum);

//                 int lastDigit = stepNum % 10;

//                 // Build next stepping numbers
//                 if (lastDigit > 0) {
//                     int next = stepNum * 10 + (lastDigit - 1);
//                     if (next <= m)
//                         queue.add(next);
//                 }

//                 if (lastDigit < 9) {
//                     int next = stepNum * 10 + (lastDigit + 1);
//                     if (next <= m)
//                         queue.add(next);
//                 }
//             }
//         }

//         public static void main(String[] args) {
//             int n = 100, m = 500;
//             printSteppingNumbers(n, m);
//         }
//     }

// }
