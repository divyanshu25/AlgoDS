class MedianFinder {
public:
    priority_queue<int> pqmx;
    priority_queue<int, vector<int>, greater<int>> pqmn;
    MedianFinder() {

    }
    void addNum(int num) {
        pqmn.push(num);
        pqmx.push(pqmn.top());
        pqmn.pop();
        if(pqmn.size() < pqmx.size()){
            pqmn.push(pqmx.top());
            pqmx.pop();
        }
    }
    double findMedian() {
        int n = pqmx.size() + pqmn.size();
        // cout << pqmx.size() << " : " << pqmn.size() << endl;
        if(n % 2 == 0){
            return (pqmx.top() + pqmn.top())/2.0;
        }else{
            if(pqmn.size() > pqmx.size())
                return pqmn.top();
            else
                return pqmx.top();
        }
    }
};