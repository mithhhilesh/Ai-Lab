import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class threeJug{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int maxX = 8;
        int maxY = 5;
        int maxZ = 3;

        System.out.println("enter initial water in x");
        int initialX = in.nextInt();
        System.out.println("enter initial water in y");
        int initialY= in.nextInt();
        System.out.println("enter initial water in z");
        int initialZ = in.nextInt();

        System.out.println("enter goal for x");
        int goalX = in.nextInt();
        System.out.println("enter goal for y");
        int goalY = in.nextInt();
        System.out.println("enter goal for z");
        int goalZ = in.nextInt();

        if(goalX > maxX ||  goalY > maxY || goalZ > maxZ){
            System.out.println("not possible");
        }else if((initialX+initialY+initialZ)!=(goalX+goalY+goalZ)){
            System.out.println("not possible");
        }else{
            Queue<int[]> q = new LinkedList<>();
            boolean[][][] visited = new boolean[maxX + 1][maxY + 1][maxZ + 1];

            // state = {x, y, z, moves}
            q.add(new int[]{initialX, initialY, initialZ, 0});
            visited[initialX][initialY][initialZ] = true;

            boolean found = false;

            while (!q.isEmpty()) {

                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int z = cur[2];
                int moves = cur[3];

                if (x == goalX && y == goalY && z == goalZ) {
                    System.out.println(moves);
                    found = true;
                    break;
                }

                // ---- All possible pours ----

                // X → Y
                int t = Math.min(x, maxY - y);
                if (t > 0 && !visited[x - t][y + t][z]) {
                    visited[x - t][y + t][z] = true;
                    q.add(new int[]{x - t, y + t, z, moves + 1});
                }

                // X → Z
                t = Math.min(x, maxZ - z);
                if (t > 0 && !visited[x - t][y][z + t]) {
                    visited[x - t][y][z + t] = true;
                    q.add(new int[]{x - t, y, z + t, moves + 1});
                }

                // Y → X
                t = Math.min(y, maxX - x);
                if (t > 0 && !visited[x + t][y - t][z]) {
                    visited[x + t][y - t][z] = true;
                    q.add(new int[]{x + t, y - t, z, moves + 1});
                }

                // Y → Z
                t = Math.min(y, maxZ - z);
                if (t > 0 && !visited[x][y - t][z + t]) {
                    visited[x][y - t][z + t] = true;
                    q.add(new int[]{x, y - t, z + t, moves + 1});
                }

                // Z → X
                t = Math.min(z, maxX - x);
                if (t > 0 && !visited[x + t][y][z - t]) {
                    visited[x + t][y][z - t] = true;
                    q.add(new int[]{x + t, y, z - t, moves + 1});
                }

                // Z → Y
                t = Math.min(z, maxY - y);
                if (t > 0 && !visited[x][y + t][z - t]) {
                    visited[x][y + t][z - t] = true;
                    q.add(new int[]{x, y + t, z - t, moves + 1});
                }
            }


        }
    }
}