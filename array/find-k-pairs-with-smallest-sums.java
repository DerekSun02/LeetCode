class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>(); 
        // 3元组(nums1[i], nums2[j], j) 按照sum升序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]+a[1]) - (b[0]+b[1]));
        for(int i = 0; i < nums1.length; i++){
            pq.offer(new int[]{nums1[i], nums2[0], 0}); 
        }

        while (!pq.isEmpty() && k > 0){
            int[] cur = pq.poll();
            k--;
            int nextIndex = cur[2]+1; 
            if (nextIndex < nums2.length){
                pq.offer(new int[]{cur[0], nums2[nextIndex], nextIndex}); 
            }
            List<Integer> smallPair = new ArrayList<>(); 
            smallPair.add(cur[0]);
            smallPair.add(cur[1]); 
            res.add(smallPair); 
        }

        return res; 
        
    }
}