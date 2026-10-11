#include <iostream>

using namespace std;

int Recursion(int n) {
    if(n == 1) {
        return 1;
    }

    return n * Recursion(n-1);
    
}

int main() {
    int ans = Recursion(5);
    cout << ans << endl;
}