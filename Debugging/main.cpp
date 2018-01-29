#include <iostream>

using namespace std;

int main()
{
    int a;
    cin>>a;

    for(int i=0;i<10;i++){
        double ans;
        ans=100/(a-i);
        cout<<"Answer Is "<<ans<<" "<<endl;

    }

    return 0;
}
