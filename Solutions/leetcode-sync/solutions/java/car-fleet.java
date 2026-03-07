import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    class Pair{
        int position;
        double time;

        public Pair( int position, double time) {
            this.time = time;
            this.position = position;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int carFleetCount=0;
        double maxTime=0.00d;
        if(position.length==1){
            return 1;
        }
        List<Pair> pairs = new ArrayList<>(position.length);
        for(int i=0; i<position.length; i++){
            pairs.add(new Pair(position[i], calculateTime(position[i], speed[i], target)));
        }

        pairs.sort((p1, p2)-> p2.position-p1.position);

        for(Pair pair : pairs)
        {
            if(pair.time > maxTime){
                maxTime= pair.time;
                carFleetCount++;
            }
        }
        return carFleetCount;
    }

    private double calculateTime(int position, int speed, int target){
        return (double) (target-position)/speed;
    }
}