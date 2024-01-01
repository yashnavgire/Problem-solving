class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0, max = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for (i = 0; i < s.length; i++) {
            j = 0;
            while (j < g.length) {
                if (s[i] >= g[j] && g[j] != -1) {
                    max++;
                    g[j] = -1;
                    break;
                } else {
                    j++;
                }
            }
        }

        return max;
    }
}
