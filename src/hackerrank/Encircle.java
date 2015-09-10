package hackerrank;

import java.util.*;
/**
 * Created by xingyun on 15/8/26.
 */
public class Encircle {

    static class Cell {
        int x;
        int y;
        public Cell(int x, int y) { this.x = x; this.y = y;}
        public boolean equals(Object o) {
            if(!(o instanceof Cell)) return false;
            Cell c = (Cell)o;
            return c.x == this.x && c.y == this.y;
        }
        public int hashCode() {
            return x*37+y;
        }
    }


    static String doesCircleExist(String commands) {
        if(commands == null || commands.length() == 0) return "NO";
        int x = 0, y = 0;
        Set<Cell> stepSet = new HashSet<Cell>();
        Cell start = new Cell(x, y);
        stepSet.add(start);

        int direction = 0;
        for(int k=0; k<4; ++k) {
            for (int i = 0; i < commands.length(); ++i) {
                char c = commands.charAt(i);
                if (c == 'G') {
                    Cell pos = new Cell(x, y);
                    if (direction == 0) {
                        pos.y++;
                    } else if (direction == 1) {
                        pos.x++;
                    } else if (direction == 2) {
                        pos.y--;
                    } else if (direction == 3) {
                        pos.x--;
                    }
                    if (stepSet.contains(pos)) return "YES";
                    stepSet.add(pos);
                    x = pos.x;
                    y = pos.y;
                } else if (c == 'R') {
                    direction = (direction + 1) % 4;
                } else if (c == 'L') {
                    direction = (direction + 3) % 4;
                }
            }
        }
        //if(stepSet.size() == 1) return "YES";
        System.out.println(x+","+y);
        if(x == 0 && y==0) return "YES";
        return "NO";

    }

    public static void main(String[] args) {
        System.out.println(Encircle.doesCircleExist("GLGR"));
//        Cell cell1 = new Cell(1,2);
//        Cell cell2 = new Cell(1,2);
//        Set<Cell> set = new HashSet<Cell>();
//        set.add(cell1);
//        System.out.println(set.contains(cell2));
    }
}


