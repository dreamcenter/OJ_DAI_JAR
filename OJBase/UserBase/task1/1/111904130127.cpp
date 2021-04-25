#include<iostream>
using namespace std;

int main(){
    int temp;
    cin>>temp;
    for(int i = 1;i<=temp;i++){
        for(int j=1;j<=i;j++) {
            cout<<"*";
        }
        cout<<endl;
    }
    return 0;
}
