package stack;

import java.util.Stack;
/*
    使用O(1)的时间复杂度实现输出栈的最小元素
    思路：空间换时间，使用两个栈，一个栈用来存数据，一个栈用来维护当前的最小值
 */
public class MinStack {
    //数据栈
    private final Stack<Integer> dataStack = new Stack<>();
    //当前的最小值栈
    private final Stack<Integer> minStack = new Stack<>();
    //栈底存一个2的32次方，避免栈空
    MinStack(){
        minStack.push(Integer.MAX_VALUE);
    }
    //关键：每次push数据的时候，将当前的最小值和要存的数进行比较，较小的数存入最小值栈
    //数据栈正常入栈和出栈
    public void push(Integer x){
        minStack.push(Math.min(minStack.peek(),x));
        dataStack.push(x);
    }
    public void pop(){
        minStack.pop();
        dataStack.pop();
    }
    public Integer top(){
        return dataStack.peek();
    }
    //返回的栈顶的元素即为当前数据栈的最小值
    public Integer getMin(){
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack min = new MinStack();
        int[] arr = {3,5,4,6,8,2,1,4};
        for (int i : arr) {
            min.push(i);
        }
        min.pop();
        min.pop();
        int ans = min.getMin();
        System.out.println(ans);
    }
}
