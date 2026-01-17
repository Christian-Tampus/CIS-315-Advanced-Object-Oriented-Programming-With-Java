/**
 * Assignment: Program 11 | Factory Method
 * Instructions: Write a recursive Java program (Hanoi.java) that solves the Tower of Hanoi problem.
 * Design Notes: Using the given Python Code algorithm rewrite into java code
 * Version: 1.0, 11/26/2025
 * @author: Christian Tampus
 * Class: CIS-315
 * Runtime complexity analysis of the algorithm:
 * According to the wikipedia article on tower of hanoi, the minimum number of moves required to solve a tower of hanoi puzzle is 2^n - 1
 * where 'n' is the number of disks to move. This algorithm perfectly replicates this.
 * For example if you input 1,2,3,4,5,6,7,8,9,10 as the input for the number of disks
 * you get the output of 1,3,7,15,31,63,127,255,511,1023 respectively which matches the formula of 2^n - 1.
 * Therefore the upper bound or worst case scenario for this algorithm is Big O(2^n - 1) which we ignore the constant of  - 1 which is Big O(2^n).
 * Therefore the lower bound or best case scenario is also Big Omega(2^n - 1) which we ignore the constant of - 1 which is Big Omega(2^n).
 * Therefore the tight bound or actual/average case scenario is also Big Theta(2^n - 1) which we ignore the constant of - 1 which is Big Theta(2^n).
 * We can also prove this via recurrence relation as well.
 * 
 * let k = 4 where 'k' is the number of expansions
 * T(1) = 1 is the base case
 * 
 * T(n) = T(n - 1) + 1 + T(n - 1) => 2[T(n - 1)] + 1
 * T(n - 1) = T(n - 2) + 1 + T(n - 2) => 2[T(n - 2)] + 1
 * T(n - 2) = T(n - 3) + 1 + T(n - 3) => 2[T(n - 3)] + 1
 * T(n - 3) = T(n - 4) + 1 + T(n - 4) => 2[T(n - 4)] + 1
 * noticing the pattern we can put T(n - 3) into T(n - 2) and then T(n - 2) into T(n - 1) and finally T(n - 1) into T(n)
 * T(n - 2) = 2[T(n - 3)] + 1 => 2[2[T(n - 4)] + 1] + 1 => 2[2T(n - 4) + 1] + 1 => 4T(n - 4) + 2 + 1 => 4T(n - 4) + 3
 * T(n - 1) = 2[T(n - 2)] + 1 => 2[4T(n - 4) + 3] + 1 => 8T(n - 4) + 6 + 1 => 8T(n - 4) + 7
 * T(n) = 2[T(n - 1)] + 1 => 2[8T(n - 4) + 7] + 1 => 16T(n - 4) + 14 + 1 => 16T(n - 4) + 15
 * now we have the the formula apply 2^k where it matches with the recurrence relation where 'k' is the number of expansions
 * T(n) = 16T(n - 4) + 15
 * T(n) = (2^k)T(n - 4) + (2^k - 1) since 16 = 2^(4) and 15 = (2^(4) - 1)
 * 
 * thus we get T(n) = 2^n - 1 in a closed form solution
 * 
 */
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.lang.Exception;
public class TowerOfHanoi {
	public static int calculateMinimumTowerOfHanoiMoves(int disks, int sourceRod, int destinationRod, int tempRod) {
		int totalMoves = 0;
		if (disks == 1) {
			return 1;
		}
		else {
			totalMoves += TowerOfHanoi.calculateMinimumTowerOfHanoiMoves(disks - 1, sourceRod, tempRod, destinationRod); // T(n - 1)
			totalMoves += TowerOfHanoi.calculateMinimumTowerOfHanoiMoves(1, sourceRod, destinationRod, tempRod); // + 1
			totalMoves += TowerOfHanoi.calculateMinimumTowerOfHanoiMoves(disks - 1, tempRod, destinationRod, sourceRod); // T(n - 1)
		}
		return totalMoves;
	}
	public static void main(String[] args) {
		System.out.println("[SYSTEM MESSAGE] Program Start!");
		Scanner ioScanner = new Scanner(System.in);
		String userInput = "";
		do {
			System.out.println("[SYSTEM MESSAGE] Please Input How Many Disks To Calculate The Minimum Number Of Moves To Solve The Puzzle Or Enter 'q' To Quit:");
			userInput = ioScanner.nextLine();
			try {
				if (!userInput.equals("q")) {
					int disks = Integer.parseInt(userInput);
					System.out.println("[SYSTEM MESSAGE] The Minimum Number Of Moves For " + disks + " Disks Is: " + TowerOfHanoi.calculateMinimumTowerOfHanoiMoves(disks,1,3,2));
				}
			}
			catch(NumberFormatException error) {
				System.out.println("[SYSTEM ERROR] Please Enter A Valid Number Input Or 'q' To Quit, Try Again!");
			}
			catch(Exception error) {
				System.out.println("[SYSTEM ERROR] Please Enter A Valid Number Input Or 'q' To Quit, Try Again!");
			}
		}while (!userInput.equals("q"));
		System.out.println("[SYSTEM MESSAGE] Program Terminated...");
	}
}