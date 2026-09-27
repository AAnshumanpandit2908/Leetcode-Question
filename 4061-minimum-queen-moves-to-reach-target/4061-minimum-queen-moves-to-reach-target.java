class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int sr = source[0]-1;
        int sc = source[1]-1;

        int tr = target[0]-1;
        int tc = target[1]-1;

        if(sr == tr && sc == tc){
            return 0;
        }
        int[][] dir = {
           {-1, 0},   // up
            {1, 0},    // down
            {0, -1},   // left
            {0, 1},    // right
            {-1, -1},  // upper-left
            {-1, 1},   // upper-right
            {1, -1},   // lower-left
            {1, 1}     // lower-right
        };
        for(int[] d : dir){
            int r = sr + d[0];
            int c = sc + d[1];

            while(r >=  0 && r < 8 && c >= 0 && c <8){
                if(r == tr && c == tc){
                    return 1;
                }
                r += d[0];
                c += d[1];
            }
        }
        return 2;
    }
}