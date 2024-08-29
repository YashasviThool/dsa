#include <iostream> 
#include <vector> 
#include <algorithm> 

using namespace std; 

int main() { 
    int N, M; 
    cin >> N >> M; 

    vector<int> quantityAvailable(M), quantityNeeded(M), costOfOneUnit(M), sellingPrice(M); 

    for (int i = 0; i < M; ++i) { 
        cin >> quantityAvailable[i]; 
    } 

    for (int i = 0; i < M; ++i) { 
        cin >> quantityNeeded[i]; 
    } 

    for (int i = 0; i < M; ++i) { 
        cin >> costOfOneUnit[i]; 
    } 

    for (int i = 0; i < M; ++i) { 
        cin >> sellingPrice[i]; 
    } 

    vector<pair<double, int>> materialInfo(M); 

    for (int i = 0; i < M; ++i) { 
        if (quantityAvailable[i] >= quantityNeeded[i]) { 
            materialInfo[i] = make_pair(sellingPrice[i] / static_cast<double>(costOfOneUnit[i]), i); 
        } else { 
            materialInfo[i] = make_pair(0, i); 
        } 
    } 

    sort(materialInfo.rbegin(), materialInfo.rend()); 

    int maxAmount = 0; 

    for (const auto& info : materialInfo) { 
        int materialIndex = info.second; 
        int possibleToys = min(N / quantityNeeded[materialIndex], quantityAvailable[materialIndex]); 
        maxAmount += possibleToys * sellingPrice[materialIndex]; 
        N -= possibleToys * quantityNeeded[materialIndex]; 
    } 

    cout << maxAmount << endl; 

    return 0; 
}