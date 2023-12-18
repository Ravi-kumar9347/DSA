class Solution {
    class Pair{
        int first,second,third;
        Pair(int first,int second,int third)
        {
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int swimInWater(int[][] grid) {
        //O(N*NlogN)
        //S(N*N)
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.first-y.first);
        pq.add(new Pair(grid[0][0],0,0));
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int dx[]={1,0,-1,0};
        int dy[]={0,-1,0,1};
        while(!pq.isEmpty())
        {
            int time=pq.peek().first;
            int x=pq.peek().second;
            int y=pq.peek().third;
            pq.remove();
            if(x==n-1 && y==m-1)
            {
                return time;
            }
            for(int i=0;i<4;i++)
            {
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==0)
                {
                    vis[nx][ny]=1;
                    if(grid[nx][ny]<=time)
                    {
                        pq.add(new Pair(time,nx,ny));
                    }
                    else
                    {
                    pq.add(new Pair(grid[nx][ny],nx,ny));
                    }
                }
            }
        }
        return 0;
    }
}