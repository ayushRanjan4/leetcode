class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        int[] levels = new int[n];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int h = 0;
        q.offer(id);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int u = q.poll();
                levels[u] = h;
                visited[u] = true;

                for (int v : friends[u]) {
                    if (visited[v] == false) {
                        visited[v]=true;
                        q.offer(v);
                    }
                }
            }
            h++;
        }
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (levels[i] == level) {
                for (String list : watchedVideos.get(i)) {
                    map.put(list, map.getOrDefault(list, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();
            }
            return a.getKey().compareTo(b.getKey()); 
        });
        List<String> ans = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : list) {
            ans.add(entry.getKey());
        }

        return ans;

    }
}