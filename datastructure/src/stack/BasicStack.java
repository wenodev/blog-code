package stack;

import java.util.Stack;

public class BasicStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= 4; i++) {
            stack.push(i);
            System.out.println(stack.peek());
        }

        System.out.println("스택 사이즈 : " + stack.size());

        System.out.println(stack.search(1));

        System.out.println(stack.empty());

    }
}
