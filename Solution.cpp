#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin >> t;
    int count = 1;
    while (t--)
    {
        map<string, int> my;
        int n, m;
        cin >> n >> m;

        while (n--)
        {

            string s;
            cin >> s;
            int l = s.size();
            for (int i = 1; i < l; i++)
            {
                if (s[i] == '/')
                {

                    string tmp(s.begin(), s.begin() + i);
                    my[tmp] = 1;
                }
            }
            string tmp(s.begin(), s.end());
            my[tmp] = 1;
        }
        int ans = 0;
        while (m--)
        {
            string s;
            cin >> s;
            int l = s.size();
            int flag = 0;
            for (int i = 1; i < l; i++)
            {
                if (s[i] == '/')
                { // cout<<"here"<<endl;
                    string tmp(s.begin(), s.begin() + i);
                    if (flag == 1)
                    {

                        // cout<<tmp<<endl;
                        ans++;
                        my[tmp] = 1;
                        continue;
                    }
                    if (my[tmp] == 1)
                        continue;
                    else
                    {
                        flag = 1;
                        //    cout<<tmp<<endl;
                        ans++;
                        my[tmp] = 1;
                    }
                }
            }
            string tmp(s.begin(), s.end());
            if (my[tmp] != 1)
            {
                ans++; // cout<<tmp<<endl;
                my[tmp] = 1;
            }
        }
        cout << "Case #" << count << ": " << ans << endl;
        count++;
    }
    return 0;
}