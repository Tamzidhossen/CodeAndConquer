#include <iostream>
#include <vector>
using namespace std;

int main() {
    int node = 4;

    vector<vector<int>> edges = {
        {1, 0},
        {2, 0},
        {3, 0}
    };

    vector<vector<int>> adj(node);

    for(auto edge : edges) {
        int u = edge[0];
        int v = edge[1];

        adj[u].push_back(v);
    }

    for(int i=0; i<node; i++) {
        cout << i << " -> ";
        for(int child : adj[i]) {
            cout << child << " ";
        }
        cout << endl;
    }
}