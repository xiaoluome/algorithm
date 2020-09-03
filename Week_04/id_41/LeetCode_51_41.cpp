// T(n) = O(n!) S(n) = O(n)
class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        int row;
        vector<int> col(n, 0);
        vector<int> diag(2 * n - 1);
        vector<int> antiDiag(2 * n - 1);
        // �����1�� ע����back_inserter
        fill_n(back_inserter(curr), n, string(n, '.'));

        numQueen = n;
        dfs(0, col, diag, antiDiag);

        return res;
    }
private:
    vector<vector<string>> res;
    vector<string> curr;
    int numQueen;
    void dfs(int row,
             vector<int>& col,
             vector<int>& diag,
             vector<int>& antiDiag)
    {
        // terminator
        if (row >= numQueen)
        {
            res.push_back(curr);
            return;
        }
        // process current
        for (int i = 0; i < numQueen; i++)
        {
            if (col[i] == 0 &&
                // �����2��row + i���ɣ�����Ҫ��nunQueens - 1����Ϊ����Խ��
                diag[row + i] == 0 &&
                antiDiag[row - i + numQueen - 1] == 0)
            {
                col[i] = 1;
                diag[row + i] = 1;
                antiDiag[row - i + numQueen - 1] = 1;
                curr[row][i] = 'Q';
                // drill down
                dfs(row + 1, col, diag, antiDiag);
                // restore
                col[i] = 0;
                diag[row + i] = 0;
                antiDiag[row - i + numQueen - 1] = 0;
                curr[row][i] = '.';
            }
        }
    }
};
