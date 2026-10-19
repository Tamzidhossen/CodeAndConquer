/**DFS Solution */

class Solution {
  public:
    
    bool dfs(int node, int parent, vector<vector<int>> &graph, vector<int> &vis) {
        vis[node] = 1;
        
        for(int neighbor : graph[node]) {
            if(vis[neighbor] == 0) {
                if(dfs(neighbor, node, graph, vis)) {
                    return true;
                }
            }
            else if(neighbor != parent) {
                return true;
            }
        }
        return false;
    }
    
    bool isCycle(int V, vector<vector<int>>& edges) {
        // Code here
        vector<vector<int>> graph(V);
        
        for(int i=0; i<edges.size(); i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            
            graph[v].push_back(u);
            graph[u].push_back(v);
        }
        
        vector<int> vis(V, 0);
        
        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                if( dfs(i, -1,graph, vis )) {
                    return true;
                }
            } 
        }
        
        return false;
    }
};

/**BFS Solutions */
class Solution {
  public:
    
    bool isCycle(int V, vector<vector<int>>& edges) {
        // Code here
        vector<vector<int>> graph(V);
        
        for(int i=0; i<edges.size(); i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            
            graph[v].push_back(u);
            graph[u].push_back(v);
        }
        
        vector<int> vis(V, 0);
        
        for(int i=0; i<V; i++) {
            if(vis[i] == 1) continue;
            queue<pair<int, int>> q;
            q.push({i, -1});
            
            vis[i] = 1;
            
            while(!q.empty()) {
                auto [node, parent] = q.front();
                q.pop();
                
                for(auto child : graph[node]) {
                    if(vis[child] == 0) {
                        q.push({child, node});
                        vis[child]++;
                    }
                    else if(child != parent) return true;
                }
            }
        }
        return false;
    }
};