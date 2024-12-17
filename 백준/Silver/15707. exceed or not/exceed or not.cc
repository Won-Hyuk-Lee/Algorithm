#include <iostream>
#include <string>
#include <limits>
using namespace std;

typedef long long ll;

bool compare(const string& s) {
    constexpr const char* MAX_LONG = "9223372036854775807";

    if (s.length() > 19) {
        return true;
    } else if (s.length() < 19) {
        return false;
    } else {
        return s > MAX_LONG;
    }
}

int main() {
    ll r;
    string s1, s2;

    cin >> s1 >> s2 >> r;

    if (s1 == "0" || s2 == "0") {
        cout << "0\n";
        return 0;
    }

    if (compare(s1) || compare(s2)) {
        cout << "overflow\n";
        return 0;
    }

    ll a = stoll(s1);
    ll b = stoll(s2);

    if (a > r / b) {
        cout << "overflow\n";
    } else {
        cout << a * b << "\n";
    }

    return 0;
}