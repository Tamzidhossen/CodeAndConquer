/**DFS Solutions */

class Solution {
public:
    void dfs(int node, vector<int> &vis, vector<vector<int>> &isConnected) {
        vis[node] = 1;
        int n = isConnected.size();
        int parent = node;
        for(int child=0; child<n; child++) {
            if(vis[child] == 0 && isConnected[parent][child] == 1) {
                dfs(child, vis, isConnected);
            }
        }
    }

    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<int> vis(n, 0);
        int cnt=0;
        for(int i=0; i<n; i++){
            if(vis[i] == 0) {
                dfs(i, vis, isConnected);
                cnt++;
            }
        }
        return cnt;
    }
};