/**BFS Solutions */

class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> vis(n, -1);

        for(int i=0; i<n; i++) {
            if(vis[i] != -1)continue;

            queue<int> q;
            q.push(i);
            
            while(!q.empty()) {
                int node = q.front();
                q.pop();

                for(int child : graph[node]) {
                    if(vis[child] == -1) {
                        q.push(child);
                        vis[child] = 1-vis[node];
                    }
                    else if(vis[child] == vis[node]) return false;
                }
            }
        }
        return true;
    }
};