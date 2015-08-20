package math;

/**
 * Created by xingyun on 15/6/29.
 */
public class LC_135_Candy {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;

        // note that each min point should be set 1
        int[] candies = new int[ratings.length];
        for(int i=0; i<candies.length; ++i) candies[i] = 1;

        for(int i=1; i<ratings.length; ++i) {
            if(ratings[i] > ratings[i-1]) candies[i] = candies[i-1]+1;
        }

        for(int i=ratings.length-1; i>0; --i) {
            if(ratings[i] < ratings[i-1]) candies[i-1] = Math.max(candies[i]+1, candies[i-1]);
        }

        int res = 0;
        for(int i=0; i<candies.length; ++i) {
            res += candies[i];
        }

        return res;
    }


    public static void main(String[] args) {
        int[] ratings = new int[]{ 4,2,3,4,1}; // 2,1,2,3,1//
        LC_135_Candy inst = new LC_135_Candy();
        System.out.println(inst.candy(ratings));
    }
}
