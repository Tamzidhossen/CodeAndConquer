class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        int n = nums.size();
        
        /* for(int i=0; i<n; i++) {         //T.C - O(n^2) S.C - O(1)
            for(int j=i+1; j<n; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false; */   //Brute Force Approce

        sort(nums.begin(), nums.end());

        for(int i=1; i<n; i++) {
            if(nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
};