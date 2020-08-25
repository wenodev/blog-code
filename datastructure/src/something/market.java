package something;

import java.util.Stack;

public class market {


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 2, 3};
        Solution(array);

    }

    public static void Solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i = 0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i = 1; i < prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }


        for(int count=0; count<terms.length; count++){
            System.out.println("terms" + count + " : " + terms[count]);
        }

    }
}



