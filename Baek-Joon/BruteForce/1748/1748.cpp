#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;
    int ans=0;
    for (int i=1; i<=N; i++) {
        if (i<10) ans += 1;
        else if (i<100) ans += 2;
        else if (i<1000) ans += 3;
        else if (i<10000) ans += 4;
        else if (i<100000) ans += 5;
        else if (i<1000000) ans += 6;
        else if (i<10000000) ans += 7;
        else if (i<100000000) ans += 8;
        else if (i<1000000000) ans += 9;
        else if (i==1000000000) ans += 10;
    }

    cout << ans << endl;
    return 0;
}