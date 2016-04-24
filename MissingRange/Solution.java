public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<String>();
        // 初始化prev为lower-1，判断是否存在“第一个”区间
        int prev = lower - 1, curr = 0;
        for(int i = 0 ; i <= nums.length; i++){
            // 当遍历到length时，设置curr为upper+1，判断是否存在“最后一个”区间
            curr = i == nums.length ? upper + 1 : nums[i];
            // 如果上一个数和当前数相差大于1，说明之间有区间
            if(curr - prev > 1){
                res.add(getRanges(prev+1, curr-1));
            }
            prev = curr;
        }
        return res;
    }
    
    private String getRanges(int from, int to){
        return from == to ? String.valueOf(from) : from + "->" + to;
    }
}
