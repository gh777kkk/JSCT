#include <iostream>
using namespace std;

int main(){
    int jimin, hansoo, people;
    int result = 0;
    cin >> people >> jimin >> hansoo;

    while(jimin != hansoo){
        jimin -= jimin / 2;
        hansoo -= hansoo / 2;
        result++;
    }

    if(result != 0)
        cout << result;
    else
        cout << "-1";
}