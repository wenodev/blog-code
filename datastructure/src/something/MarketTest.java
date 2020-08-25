package something;


public class MarketTest {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 2, 3};
        Solution(array);

    }

    public static void Solution(int[] prices) {

        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){

                if (prices[i] > prices[j]){
                    answer[i] = j-i;
                    break;
                }
            }
            if(answer[i] == 0){
                answer[i] = prices.length - i - 1;
            }
        }

        for(int num : answer){
            System.out.println(num);
        }

    }




}
