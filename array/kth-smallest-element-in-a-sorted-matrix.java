class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        // minHeap存(matrix[i][j], i, j) 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            // 按照元素大小升序
            return a[0] - b[0]; 
        });
        int count = 0; 
        for(int i = 0; i < m; i++){
            minHeap.offer(new int[]{matrix[i][0], i, 0});  
        }
        while(!minHeap.isEmpty()){
            // poll最小元素
            int[] polled = minHeap.poll(); 
            int number = polled[0], i = polled[1], j = polled[2];
            count++; 
            // 判断是否是第k个最小元素 
            if (count == k){
                return number; 
            }
            // 将下一个元素matrix[i][j+1]加入队列
            if (matrix[i].length > j+1){
                minHeap.offer(new int[]{matrix[i][j+1], i, j+1}); 
            }
        }
        return 0; 
    }
}