class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        res = r

        while (l <= r):
            mid = (l+r) // 2
            hour = self.checkHourK(piles, mid)
            if hour <= h:
                res = mid
                r = mid - 1
            else:
                l = mid + 1
        return res

    def checkHourK(self, piles: List[int], h: int) -> int:
        sum = 0
        for i in piles:
            sum = sum + math.ceil(float(i)/h)
        return sum