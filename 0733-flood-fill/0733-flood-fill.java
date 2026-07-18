class Solution {
    public int[][]coordinate={{-1,0},{+1,0},{0,-1},{0,+1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
         if (originalColor == color) {
            return image;
        }
        int row=image.length;
        int col=image[0].length;
        Queue<int []> q=new LinkedList<>();
        q.offer(new int[]{sr,sc});
        image[sr][sc]=color;
        System.out.println(image[sr][sc]);
        while (!q.isEmpty()){
            int[] curr=q.poll();
            int cx=curr[0];
            int cy=curr[1];
            for(int[] co:coordinate){

                int nx=cx+co[0];
                int ny=cy+co[1];
                if (nx < row && nx >= 0 && ny < col && ny >= 0 && image[nx][ny] == originalColor) {
                    image[nx][ny] = color;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return image;
      
    }
}