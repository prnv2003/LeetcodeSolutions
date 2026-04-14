/*
 * 1823. Find the Winner of the Circular Game
 */

import java.util.*;

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> circularGame = new LinkedList<>();

        for (int i = 1; i <= n; ++i) {
            circularGame.add(i); // firstly add total no of playrs
        }

        while (circularGame.size() > 1) {
            int count = k;

            while (count > 1) {
                int current = circularGame.poll(); // declares/retrives current = head element of the queue
                circularGame.add(current); // add current ele in queue

                --count; // decrease the count
            }
            circularGame.poll(); // here remove the head elem of the queue
        }
        return circularGame.peek();
    }
}