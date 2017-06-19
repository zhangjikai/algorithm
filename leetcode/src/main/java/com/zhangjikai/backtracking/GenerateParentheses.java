package com.zhangjikai.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jikai Zhang on 2017/6/19.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if(n ==0) {
            return results;
        }
        rec(n, n, "", results);
        return results;
    }

    public void rec(int left, int right, String res, List<String> results) {
        if(left < 0 || right < 0 || left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            results.add(res.toString());
        }

        rec(left-1, right, res + "(", results);
        rec(left, right -1, res + ")", results);

    }
}
