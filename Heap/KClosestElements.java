// https://leetcode.com/problems/find-k-closest-elements/description/

// Time Complexity: O(n log k)
// Space Complexity: O(k)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[1] == b[1]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });

        for(int i = 0; i < arr.length; i++) {
            int[] arrzz = new int[2];
            arrzz[0] = arr[i];
            arrzz[1] = Math.abs(arr[i] - x);
            pq.add(arrzz);
            while(pq.size() > k) {
                pq.poll();
            }
        }

        while(!pq.isEmpty()) {
            int[] arrx = pq.poll();
            result.add(arrx[0]);
        }

        result.sort(null);

        return result;
    }
}