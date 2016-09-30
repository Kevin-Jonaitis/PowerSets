import java.util.*;

/**
 * Give a set of numbers, print out all possible set combinations(aka the power set).
 * This program runs in O(2^n) time and O(n) space.
 * The O(n) spaces comes from the fact that we're only keeping track of one "stack" at a time, and adding/popping from
 * the stack as we print out solutions.
 *
 * If we wanted to RETURN all the sets, obviously this would be O(n^2) space.
 *
 * One note that I'll make is that even though the input is a mathematical set, we should pass it in as an arraylist,
 * so we can access specific elements in the arraylist in constant times.
 */
class Solution {
    ArrayList<Integer> inputSet;

    public Solution() {
        setup();
        generateSet(new Stack<Integer>(), 0);
    }

    private void setup() {
        ArrayList<Integer> startingSet = new ArrayList<Integer>();
        startingSet.add(1);
        startingSet.add(2);
        startingSet.add(3);
        this.inputSet = startingSet;
    }

    public void generateSet(Stack<Integer> setToPrint, int index) {
        if (index == inputSet.size()) {
            printSet(setToPrint);
            return;
        }
        // Here we make a choice: either add the current element to the stack and recurse, or just recurse.
        // We do both options to get all possible sets
        generateSet(setToPrint, index + 1);
        setToPrint.add(inputSet.get(index));
        generateSet(setToPrint, index + 1);
        setToPrint.pop(); //Remove the set at the end to get back the element we added in this iteration
    }

    public static void main(String[] args) {
        new Solution();
    }

    private void printSet(Stack<Integer> set) {
        String output = "";
        System.out.print("[");
        for(Integer i : set) {
            output += i + " ";
        }

        // Remove the extra space
        if (set.size() > 0) {
            output = output.substring(0, output.length() - 1);
        }
        output += "]";
        System.out.println(output);
    }
}

