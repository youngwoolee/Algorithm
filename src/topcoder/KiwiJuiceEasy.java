package topcoder;

public class KiwiJuiceEasy {


    public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {

        for(int i=0; i< fromId.length; i++) {

            int from = fromId[i];
            int to = toId[i];
            //빈공간
            int space = capacities[to] - bottles[to];

            //쥬스 넘치지 않음
            if(bottles[from] <= space) {
                bottles[to] += bottles[from];
                bottles[from] = 0;
            }
            //쥬스 넘침
            else {
                bottles[to] = capacities[to];
                bottles[from] -= space;
            }
        }

        return bottles;
    }

    public static int[] thePouring2(int[] capacities, int[] bottles, int[] fromId, int[] toId) {

        for(int i=0; i< fromId.length; i++) {

            int from = fromId[i];
            int to = toId[i];

            int moveAmount = Math.min(bottles[from], capacities[to] - bottles[to]);

            bottles[from] -= moveAmount;
            bottles[to] += moveAmount;
        }

        return bottles;
    }

    public static void main(String[] args) {
        int[] capacities = {14, 35, 86, 58, 25, 62};
        int[] bottles = {6, 34, 27, 38, 9, 60};
        int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
        int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};

        int[] answer = thePouring2(capacities,bottles,fromId,toId);

        System.out.print("Returns:");
        for(int i=0; i< answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
    }
}
