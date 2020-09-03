class Solution(object):
    def removeDuplicates(self, S):
        """
        :type S: str
        :rtype: str
        """
        if not S:
            return S
        stack = []
        for i in S:
            if not stack:
                stack.append(i)
                continue
            if stack[-1] == i:
                stack.pop()
            else:
                stack.append(i)
        return ''.join(stack)


# print Solution().removeDuplicates('adcc')
