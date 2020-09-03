
# 看了别人的代码仿照写的
# 时间复杂度  O(logN)
# 利用位运算做除2和奇偶判断
# 空间复杂度  O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        isNegitive=False
        if n==0:
            return 1.0
        if n==1:
            return x
        if n<0:
            isNegitive=True
            n=0-n
        res,p=1,x
        while n!=0:
            if n&1==1:
                res*=p
            p*=p
            n>>=1
        if isNegitive:
            res=1.0/res
        return res