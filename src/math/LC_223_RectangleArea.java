package math;

/**
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

 Rectangle Area
 Assume that the total area is never beyond the maximum possible value of int.


 * Created by xingyun on 15/8/20.
 */
public class LC_223_RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int xlen = 0;
        int ylen = 0;
        if(A<=E && E<=C && C<=G) {
            xlen = C-E;
        } else
        if(A<=E && G<=C) {
            xlen = G-E;
        } else
        if(E<=A && A<=G && G<=C) {
            xlen = G-A;
        } else
        if(E<=A && C<=G) {
            xlen = C-A;
        }

        if(D>=H && H>=B && B>=F) {
            ylen = H-B;
        } else
        if(H>=D && D>=F && F>=B ) {
            ylen = D-F;
        } else
        if(H>=D && B>=F) {
            ylen = D-B;
        } else
        if(D>=H && F>= B) {
            ylen = H-F;
        }
        return (C-A)*(D-B) + (G-E)*(H-F) - xlen*ylen;
    }

}
