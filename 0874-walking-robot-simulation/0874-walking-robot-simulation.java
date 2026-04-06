import java.util.*;

class Solution {
  private static final int[] dx = {0, 1, 0, -1};
  private static final int[] dy = {1, 0, -1, 0};

  public int robotSim(int[] commands, int[][] obstacles) {
    // Encode each obstacle as "x,y" string for O(1) lookup
    Set<String> obs = new HashSet<>();
    for (int[] o : obstacles) {
      obs.add(o[0] + "," + o[1]);
    }

    int dir = 0, x = 0, y = 0, maxDist = 0;

    for (int cmd : commands) {
      if (cmd == -2) {
        dir = (dir + 3) % 4; // turn left
      } else if (cmd == -1) {
        dir = (dir + 1) % 4; // turn right
      } else {
        // Move step by step, stop if blocked
        for (int i = 0; i < cmd; i++) {
          int nx = x + dx[dir];
          int ny = y + dy[dir];
          if (obs.contains(nx + "," + ny)) break; // obstacle ahead
          x = nx;
          y = ny;
          // Squared distance — no sqrt needed, comparison still holds
          maxDist = Math.max(maxDist, x * x + y * y);
        }
      }
    }
    return maxDist;
  }
}