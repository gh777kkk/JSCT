#include <iostream>
#include <queue>
using namespace std;

int main(){
    int N, K;
    queue <int> q;
    cin >> N >> K;

    for(int i=1; i<=N; i++){
        q.push(i);
    }

    cout << "<";

    for(int i=0; i<N-1; i++){
        for(int j=0; j<K-1; j++){
            int temp = q.front();
            q.push(temp);
            q.pop();
        }

        cout << q.front() << ", ";
        q.pop();
    }

    cout << q.front();

    cout << ">";
}