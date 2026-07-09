class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top_row = 0
        m = len(matrix)
        n = len(matrix[0])
        bot_row = m - 1
        while top_row <= bot_row:
            mid = (top_row + bot_row) // 2
            if matrix[mid][0] > target:
                bot_row = mid - 1
            elif matrix[mid][-1] < target:
                top_row = mid + 1
            else: 
                break
        if not (top_row <= bot_row):
            return False
        row = (top_row + bot_row) // 2
        l, r = 0, n-1
        while l <= r:
            mid = (l+r) // 2
            if matrix[row][mid] < target:
                l = mid + 1
            elif matrix[row][mid] > target:
                r = mid - 1
            else:
                return True
        return False