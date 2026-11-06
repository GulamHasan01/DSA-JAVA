class Solution:
    def countServers(self, n: int, logs: List[List[int]], k: int, queries: List[int]) -> List[int]:
        logs.sort(key=lambda x: x[1])

        sorted_queries = sorted(enumerate(queries), key=lambda x: x[1])

        active_servers = defaultdict(int)
        
        result = [0] * len(queries)
        left = 0
        right = 0
        m = len(logs)
        
        for original_idx, q in sorted_queries:
            while right < m and logs[right][1] <= q:
                server_id = logs[right][0]
                active_servers[server_id] += 1
                right += 1

            while left < m and logs[left][1] < q - k:
                server_id = logs[left][0]
                active_servers[server_id] -= 1
                if active_servers[server_id] == 0:
                    del active_servers[server_id]
                left += 1
                
            result[original_idx] = n - len(active_servers)
            
        return result