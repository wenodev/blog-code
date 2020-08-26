package something;

import java.util.*;

public class 아무코드 {
    public static void main(String[] args) {
//        int[] progresses = {93,30,55};
//        int[] speeds = {1,30,5};

//        int[] progresses = {55, 93, 30, 55};
//        int[] speeds = {5, 1, 30, 5};

                int[] progresses = {93,30,55,30};
        int[] speeds = {1,30,5,30};

        Solution(progresses, speeds);

    }

    public static void Solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = progresses.length-1; i >= 0; i--) {
            int temp = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                temp++;
            }
            System.out.println("temp : " + temp);
            stack.push(temp);
        }

        int count=0;
        int temp = stack.peek();
        for(int i=0; i<progresses.length; i++){

            stack.pop();
            count++;

            if(!stack.empty()){
                if (temp < stack.peek()){
                    temp = stack.peek();
                    answerList.add(count);
                    count=0;
                }
            }

        }
        answerList.add(count);

        int[] array = new int[answerList.size()];

        for(int i=0; i<array.length; i++){
            array[i] = answerList.get(i);
        }


        for(int num : array){
            System.out.println(num);
        }






    }
}
