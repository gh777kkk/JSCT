#include <iostream>
#include <algorithm>
using namespace std;

int str_cmp(string A, string B){
    // 1. 크기 비교
    int A_size = A.size();
    int B_size = B.size();
    if(A_size != B_size)
        return A_size < B_size;

    // 2. 합 비교
    int A_sum = 0, B_sum = 0;
    for(int i=0; i<A_size; i++){
        if('0' <= A[i] && A[i] <= '9')
            A_sum += A[i] - '0';
        if('0' <= B[i] && B[i] <= '9')
            B_sum += B[i] - '0';
    }
    if(A_sum != B_sum)
        return A_sum < B_sum;

    // 3. 사전순 비교
    return A < B;
}

int main(){
    int num;
    string arr[51];
    cin >> num;
    for(int i=0; i<num; i++){
        cin >> arr[i];
    }
    sort(arr, arr+num, str_cmp);

    for(int i=0; i<num; i++){
        cout << arr[i] << '\n';
    }

    return 0;
}