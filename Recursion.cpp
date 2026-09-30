#include <iostream>

using namespace std;

void Recursion(int n) {
    if(n == 0) {
        return;
    }

    Recursion(n-1);
    cout << n << " ";
}

int main() {
    Recursion(5);
    cout << endl;
}