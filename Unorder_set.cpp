#include <bits/stdc++.h>
using namespace std;

int main() {
    unordered_set<int> st;

    st.insert(10);
    st.insert(50);
    st.insert(30);
    st.insert(10);      //Ignore Duplicate

    if(st.find(20) == st.end()) {
        cout << "Not Found" << endl;
    }
}