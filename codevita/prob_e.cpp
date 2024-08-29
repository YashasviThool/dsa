#include <iostream>
#include <cmath>
#include <limits>

using namespace std;

int overhamming(int m, int n, pair<int, int> p1, pair<int, int> d1, pair<int, int> p2, pair<int, int> d2) {
    int steps = 0;

    while (true) {
        pair<int, int> n1 = {p1.first + d1.first, p1.second + d1.second};

        if (n1.first < 0 || n1.first >= m || n1.second < 0 || n1.second >= n) {
            d1 = {-d1.first, -d1.second};
        }

        p1 = n1;

        pair<int, int> n2 = {p2.first + d2.first, p2.second + d2.second};

        if (n2.first < 0 || n2.first >= m || n2.second < 0 || n2.second >= n) {
            d2 = {-d2.first, -d2.second};
        }

        p2 = n2;

        if (p1 == p2) {
            return steps;
        }

        steps++;

        if (steps > 1000000) {
            return numeric_limits<int>::max();
        }
    }
}

int main() {
    int g, h;
    cin >> g>> h;

    pair<int, int> p1, d1, p2, d2;
    cin >> p1.first >> p1.second >> d1.first >> d1.second;
    cin >> p2.first >> p2.second >> d2.first >> d2.second;

    int top =overhamming(g, h, p1, d1, p2, d2);

    if (top == numeric_limits<int>::max()) {
        cout << "No";
    } else {
        cout << top + 1;
    }

    return 0;
}