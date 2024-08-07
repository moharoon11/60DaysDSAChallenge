package day14;

import java.util.ArrayList;

public class AsteroidsCollision {

    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<asteroids.length; i++) {

            if(asteroids[i] > 0) {
                list.add(asteroids[i]);
            } else {

                while(!list.isEmpty() && list.get(list.size() - 1) > 0
                        && list.get(list.size()-1) < Math.abs(asteroids[i])) {
                    list.remove(list.size()-1);
                }

                if(!list.isEmpty() && list.get(list.size() - 1) == Math.abs(asteroids[i])) {
                    list.remove(list.size() - 1);
                } else if(list.isEmpty() || list.get(list.size() - 1) < 0) {
                    list.add(asteroids[i]);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
