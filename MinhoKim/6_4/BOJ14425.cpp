#include <iostream>
#include <map>
using namespace std;
int N, M;

int main(){
    int result = 0;
    map<string, bool> S;
    cin >> N >> M;
    for(int i=0; i<N; i++){
        string temp;
        cin >> temp;
        S.insert({temp, true});
    }

    for(int i=0; i<M; i++){
        string temp;
        cin >> temp;
        if(S[temp] == true){
            result++;
        }
    }

    cout << result;
}
    
