
Answers
/** 
* Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
* For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 
* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3) 
*/ 
public int depthSum (List<NestedInteger> input) 
{ // ur implementation here} 
    return depthSumhHelper(input, 1);
}

private int depthSumhHelper(List<NestedInteger> input, int level) {
    int sum = 0;
    for (NestedInteger nestInt : input) {
        if (nestInt.isInteger())
            sum += nestInt.getInteger() * level;
        else {
            int s = helper(nestInt.getList(), level + 1);
            sum += s;
        }
    }
    return sum;
}

public int reverseDepthSum (List<NestedInteger> input) 
{
    // ur implementation here} 
    List<NestedInteger> list = new ArrayList<NestedInteger>();
    list.addAll(input);
    int sumAll = 0;
    int sumCurr = 0;
    while(!list.isEmpty()) {
        List<NestedInteger> temp = new ArrayList<NestedInteger>();
        for (NestedInteger nestInt : list) {
            if (nestInt.isInteger())
                sumCurr += nestInt.getInteger();
            else
                temp.addAll(nestInt.getList());
        }
        sumAll += sumCurr;
        list = temp;
    }
    return sumAll;
}


/** 
* This is the interface that represents nested lists. 
* You should not implement it, or speculate about its implementation. 
*/ 
public interface NestedInteger 
{ 
/** @return true if this NestedInteger holds a single integer, rather than a nested list */ 
boolean isInteger(); 

/** @return the single integer that this NestedInteger holds, if it holds a single integer 
* Return null if this NestedInteger holds a nested list */ 
Integer getInteger(); 

/** @return the nested list that this NestedInteger holds, if it holds a nested list 
* Return null if this NestedInteger holds a single integer */ 
List<NestedInteger> getList(); 
}

