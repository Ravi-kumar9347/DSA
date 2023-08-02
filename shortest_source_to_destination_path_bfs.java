
class Cell {
    int x;
    int y;
    int steps;

    Cell(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}
//O(N * M)
//S(N * M) + S(N * M)
class Solution {
    public int shortestDistance(int N, int M, int[][] A, int X, int Y) {
        if (A[0][0] == 0) {
            return -1;
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean[][] visited = new boolean[N][M];

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.x == X && current.y == Y) {
                return current.steps;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && A[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Cell(nx, ny, current.steps + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}
