package something;

import java.util.*;

public class 아무코드 {
    public static void main(String[] args) {

        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(Solution(scoville, K));

    }

    public static int Solution(int[] scoville, int K) {

        int answer = 0;
        int temp = 0;

        List<Integer> scovilleList = new ArrayList<>();
        for (int num : scoville) {
            scovilleList.add(num);
        }


        do {

            if (scovilleList.get(0) >= K) {
                break;
            }

            temp = scovilleList.remove(0) + (scovilleList.remove(0) * 2);
            for (int j = 0; j < scovilleList.size(); j++) {
                if (temp < scovilleList.get(j)) {
                    scovilleList.add(j, temp);
                    break;
                }
                if (temp > scovilleList.get(scovilleList.size() - 1)) {
                    scovilleList.add(temp);
                    break;
                }
            }
            answer++;
        }while (scovilleList.size() != 2);

        return answer;
    }


}
