class Solution {

    public List<String> findAllRecipes(
            String[] recipes,
            List<List<String>> ingredients,
            String[] supplies) {

        Map<String, Integer> map = new HashMap<>();

        int n = recipes.length;

        for (int i = 0; i < n; i++) {
            map.put(recipes[i], i);
        }
        Map<String, List<Integer>> adj = new HashMap<>();

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {

            for (String ing : ingredients.get(i)) {

                adj.computeIfAbsent(ing, k -> new ArrayList<>())
                        .add(i);

                indegree[i]++;
            }
        }

        Queue<String> q = new LinkedList<>();

        for (String supply : supplies) {
            q.offer(supply);
        }

        List<String> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            String ingredient = q.poll();

            if (!adj.containsKey(ingredient)) {
                continue;
            }

            for (int recipeIndex : adj.get(ingredient)) {

                indegree[recipeIndex]--;
                if (indegree[recipeIndex] == 0) {

                    String recipe = recipes[recipeIndex];

                    ans.add(recipe);

                    q.offer(recipe);
                }
            }
        }

        return ans;
    }
}