package module5;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    static String temporalComplexity = "";
    static String memoryComplexity = "";
    static String typeOfUMLDiagram = "";
    private static Map<Integer, Long> memoDP = new HashMap<>();

    public static long iterative(int n) {
        memoDP.clear();
        temporalComplexity = "O(n)";
        memoryComplexity = "O(n)";
        typeOfUMLDiagram = "Activity Diagram";
        for (int i = 0; i <= n; i++ ) {
            if (i <= 1) {
                memoDP.put(i, (long) i);
            } else {
                memoDP.put(i, memoDP.get(i - 2) + memoDP.get(i - 1));
            }
        }
        return memoDP.get(n);
    }
    public static long recursive(int n) {
        temporalComplexity = "O(n)";
        memoryComplexity = "O(n^2)";
        typeOfUMLDiagram = "Activity Diagram";
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    public static long dynamicProgramming(int n) {
        temporalComplexity = "O(n)";
        memoryComplexity = "O(n)";
        typeOfUMLDiagram = "Activity Diagram";
        memoDP.clear();
        if (n <= 1) {
            return n;
        }
        if (memoDP.containsKey(n)) {
            return memoDP.get(n);
        }
        long fib = dynamicProgramming(n - 1) + dynamicProgramming(n - 2);
        memoDP.put(n, fib);
        return fib;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci(" + n + ") = ");
        System.out.println("Iterative method = " + iterative(n));
        System.out.println("Temporal Complexity :" + temporalComplexity);
        System.out.println("Memory Complexity :" + memoryComplexity);
        System.out.println("Type of UML diagram :" + typeOfUMLDiagram + "\n");
        System.out.println("Recursive method = " + recursive(n));
        System.out.println("Temporal Complexity :" + temporalComplexity);
        System.out.println("Memory Complexity :" + memoryComplexity);
        System.out.println("Type of UML diagram :" + typeOfUMLDiagram + "\n");
        System.out.println("Method of dynamic programming = " + dynamicProgramming(n));
        System.out.println("Temporal Complexity :" + temporalComplexity);
        System.out.println("Memory Complexity :" + memoryComplexity);
        System.out.println("Type of UML diagram :" + typeOfUMLDiagram + "\n");
    }
}
