/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rangeSumBST(root *TreeNode, L int, R int) int {
	if root == nil {
		return 0
	}
	result := 0
	if root.Val < L {
		result += rangeSumBST(root.Right, L, R)
	} else if root.Val > R {
		result += rangeSumBST(root.Left, L, R)
	} else {
		result += root.Val
		result += rangeSumBST(root.Left, L, R)
		result += rangeSumBST(root.Right, L, R)
	}
	return result
}