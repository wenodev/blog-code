package stack.user;

public class UserStackTest {
    public static void main(String[] args) {
        UserStack userStack = new UserStack();

        for (int i = 1; i <= 4; i++) {
            userStack.push(i);
            System.out.println(userStack.peek());
        }


        System.out.println(userStack.peek());


    }
}
