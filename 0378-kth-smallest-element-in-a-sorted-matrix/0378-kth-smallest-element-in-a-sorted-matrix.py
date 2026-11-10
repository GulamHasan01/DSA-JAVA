class Solution:
    def kthSmallest(self, matrix: list[list[int]], k: int) -> int:
        min_heap = []

        for x in matrix:
            for i in x:
                heapq.heappush(min_heap, i)
        for _ in range(k - 1):
            heapq.heappop(min_heap) 
        return heapq.heappop(min_heap)