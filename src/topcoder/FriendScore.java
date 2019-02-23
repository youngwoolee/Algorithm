package topcoder;

public class FriendScore {
    public static int highestScore(String[] friends) {

        int max =0;
        int friendSize = friends.length;
        
        for(int i=0; i<friendSize; i++) {
            int cnt=0;
            for(int j=0; j< friendSize; j++) {
                if(i ==j) {
                    continue;
                }
                if(friends[i].charAt(j) ==  'Y'){
                    cnt ++;
                }
                else{
                    for(int k=0; k<friendSize; k++) {
                        if(friends[j].charAt(k) == 'Y' && friends[k].charAt(i) =='Y') {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            max = Math.max(max, cnt);
        }


        return max;
    }

    public static void main(String[] args) {

        String[] friends = {"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};


        int answer = highestScore(friends);

        System.out.print("Returns: " + answer);

    }
}
