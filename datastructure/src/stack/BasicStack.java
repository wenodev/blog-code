package stack;

import java.util.Stack;

public class BasicStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            System.out.println(stack.peek());
        }

        System.out.println(stack.search(6));

        System.out.println(stack.empty());



    }
}
