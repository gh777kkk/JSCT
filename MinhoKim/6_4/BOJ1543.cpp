#include <iostream>
using namespace std;

int main(){
    string str1, str2;
    int result = 0;
    int i = 0;
    getline(cin, str1);
    getline(cin, str2);

    while(i < str1.length()){
        string temp = str1.substr(i, str2.length());
        if(temp.compare(str2) == 0){
            result++;
            i += str2.length();
        }
        else{
            i++;
        }
    }

    cout << result;
}