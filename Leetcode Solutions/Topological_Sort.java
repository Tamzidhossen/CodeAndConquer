/**DFS Solutions */
//**   https://www.geeksforgeeks.org/problems/topological-sort/1

class Solution {
  public:
  
    void dfs(int node, vector<int>& vis, vector<vector<int>> &adj, stack<int>& st) {
        vis[node] = 1;
        
        for(int child : adj[node]) {
            if(!vis[child]) {
                dfs(child, vis, adj, st);
            }
        }
        
        st.push(node);
    }
  
    vector<int> topoSort(vector<vector<int>>& adj) {
        // code here
        int V = adj.size();
        stack<int> st;
        vector<int> vis(V, 0);
        
        // vector<vector<int>> adj(V);
        
        // for(int i=0; i<edges.size(); i++) {
        //     int u = edges[i][0];
        //     int v = edges[i][1];
            
        //     adj[u].push_back(v);
        // }
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) dfs(i, vis, adj, st);
        }
        
        vector<int> ans;
        while(!st.empty()) {
            auto it = st.top();
            st.pop();
            
            ans.push_back(it);
        }
        
        return ans;
        
    }
};