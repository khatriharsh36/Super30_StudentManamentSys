#include<iostream>
#include<vector>
using namespace std;
int main(){
    vector <int> vec;
    vec.push_back(25);
    vec.push_back(45);
    vec.push_back(35);
    cout<<vec[0]<<endl;
    cout<<vec.size()<<endl;
    vec.pop_back();

    for(int i :vec){
    
        cout<<i<<endl;
}
}






