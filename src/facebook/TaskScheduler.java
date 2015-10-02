package facebook;

import com.sun.javafx.tk.Toolkit;
import java.util.*;


/**
 * Created by xingyun on 9/28/15.
 */
public class TaskScheduler {

    /*
     * 这种算法遇到 AABABCD 会出错，因为A和B单独计算惩罚时间，但其实ABAB只需惩罚一个时间即可：AB_AB
    public int scheduleTime(String tasks, int coolTime) {
        int res = tasks.length();
        // task -> latest idx
        Map<Character, Integer> taskIdx = new HashMap<Character, Integer>();
        for(int i=0; i<tasks.length(); ++i) {
            char c = tasks.charAt(i);
            if(taskIdx.containsKey(c)) {
                int lastIdx = taskIdx.get(c);
                // if the interval of two same tasks is less than coolTime
                // then punished the total time
                if((i-lastIdx) < coolTime+1) {
                    res += coolTime+1-i+lastIdx;
                }
            }
            taskIdx.put(c, i);
        }
        return res;
    }
    */

    public int scheduleTime(String tasks, int coolTime) {
        int scheduleTime = -1;
        Map<Character, Integer> lastTime = new HashMap<Character, Integer>();
        for(int i =0; i<tasks.length(); ++i) {
            char c = tasks.charAt(i);
            if(lastTime.containsKey(c)) {
                int last = lastTime.get(c);
                if (last + coolTime > scheduleTime) {
                    scheduleTime = last + coolTime;
                }
            }
            scheduleTime++;
            lastTime.put(c, scheduleTime);
        }
        return scheduleTime+1;
    }

    public static void main(String[] args) {
        String tasks = "AABABCD";
        TaskScheduler inst = new TaskScheduler();
        System.out.println(inst.scheduleTime(tasks, 2));
    }
}
