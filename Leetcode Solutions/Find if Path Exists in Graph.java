/** Usin BFS */

class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<vector<int>> graph(n);

        for(int i=0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].push_back(v);
            graph[v].push_back(u);
        }

        vector<int> vis(n, 0);
        queue<int> q;
        q.push(source);
        vis[source] = 1;

        while(!q.empty()) {
            int parent = q.front();
            q.pop();

            if(parent == destination) return true;

            for(auto child : graph[parent]) {
                if(vis[child] == 0) {
                    q.push(child);
                    vis[child] = 1;
                }
            }
        }
        return false;
    }
};



/** Same Problem DFS Solutions */
class Solution {
public:
    bool dfs(int source, int distination, vector<vector<int>> &graph, vector<int> &vis) {
        if(source == distination) {
            return true;
        }
        vis[source] = 1;

        for(auto neighbor : graph[source]){
            if(vis[neighbor] == 0){
                if(dfs(neighbor, distination, graph, vis) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<vector<int>> graph(n);

        for(int i=0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].push_back(v);
            graph[v].push_back(u);
        }

        vector<int> vis(n, 0);
        return dfs(source, destination, graph, vis);
    }
};