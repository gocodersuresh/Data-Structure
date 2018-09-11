//http://www.shivapreals.tech/wp-admin/post.php?post=538&action=edit
package com.company;

import java.util.ArrayList;
import java.util.List;

class Stack{
    List<Integer> stackList=new ArrayList<>();
    int top=0;

}
public class StackUtil {
    Stack stack=new Stack();

    public int pop()
    {int item = 0;
        if(stack.top!=-1){
    System.out.println(stack.top);
    if(stack.top==0)
    item=stack.stackList.get(stack.top);
    else
        item=stack.stackList.get(stack.top-1);

    stack.top=stack.top-1;
        }else{System.out.println("EMPTY");}
    return item;
    }
    public void push(int data){
    System.out.println(stack.top);

        stack.stackList.add(data);
        stack.top+=1;

    }
    public static void main(String[] args){
        StackUtil util=new StackUtil();
        util.push(45);
        //util.push(55);
        //util.push(70);
        int stackItem=util.pop();
        System.out.println(stackItem);
        System.out.println(util.pop());
        System.out.println(util.pop());
        System.out.println(util.pop());
        System.out.println(util.pop());
    }
}
