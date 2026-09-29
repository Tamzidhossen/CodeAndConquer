#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void bfs(vector<vector<int>> &ans, int start) {
    vector<bool> visited(6, false);
    queue <int> q;

    visited[start] = true;
    q.push(start);

    while(!q.empty()) {
        int node = q.front();
        q.pop();
        cout << node << " ";

        for(int neighbor : ans[node]) {
            if(!visited[neighbor]) {
                visited[neighbor] = true;
                q.push(neighbor);
            }
        }
    }
    cout << endl;
}

void dfs(vector<vector<int>> &ans, vector<bool> &visited, int start) {
    visited[start] =  true;
    cout << start << " ";

    for(int neighbor : ans[start]) {
        if(!visited[neighbor]) {
            dfs(ans, visited, neighbor);
        }
    }
}

int main(){
    int n = 6;
    vector<vector<int>> ans(n);

    ans[0].push_back(1);    ans[1].push_back(0);
    ans[0].push_back(2);    ans[2].push_back(0);
    ans[1].push_back(3);    ans[3].push_back(1);
    ans[1].push_back(4);    ans[4].push_back(1);
    ans[2].push_back(5);    ans[5].push_back(2);

    int start = 0;
    /* cout << "BFS Node: ";
    bfs(ans, start); */

    /**For DFS */
    vector<bool> visited(n, false);
    dfs(ans, visited, start);
    cout << endl;
}