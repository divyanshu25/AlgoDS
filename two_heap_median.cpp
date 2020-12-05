class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        priority_queue<double> mxh;
        priority_queue<double, vector<double>, greater<double>> mnh;
        for(auto it : nums1){
            mxh.push(it);
            mnh.push(mxh.top());
            mxh.pop();
            if(mnh.size()-mxh.size() > 1){
                mxh.push(mnh.top());
                mnh.pop();
            }
        }
        for(auto it : nums2){
            mxh.push(it);
            mnh.push(mxh.top());
            mxh.pop();
            if(mnh.size()-mxh.size() > 1){
                mxh.push(mnh.top());
                mnh.pop();
            }
        }
        if(mxh.size() == mnh.size()){
            return (mxh.top() + mnh.top() )/ 2.0;
        }
        else if(mxh.size() > mnh.size()){
            return mxh.top();
        }else{
            return mnh.top();
        }

    }
};//
// Created by Divyanshu Goyal on 12/23/19.
//

