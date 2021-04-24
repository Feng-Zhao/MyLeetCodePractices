package jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;

// mimic a queue use 2 stack
class P09_Dequeby2Stack {
    private final Deque<Integer> left = new LinkedList<>();
    private final Deque<Integer> right = new LinkedList<>();

    private STATE state = STATE.EMPTY;

    private enum STATE{EMPTY,READY_FOR_REVERS,READABLE}

    public P09_Dequeby2Stack() {

    }
    
    public void appendTail(int value) {
        switch(state){
            case EMPTY: state = STATE.READY_FOR_REVERS;break;
            case READY_FOR_REVERS: break;
            case READABLE: break;
        }
        left.push(value);
    }

    public int deleteHead() {
        switch(state){
            case EMPTY: return -1;
            case READABLE: {
                int result = right.pop();
                if(right.isEmpty()){
                    if(left.isEmpty()){
                        state = STATE.EMPTY;
                    }
                    else{
                        state = STATE.READY_FOR_REVERS;
                    }
                }
                return result;
            }
            case READY_FOR_REVERS: {
                while(!left.isEmpty()){
                    right.push(left.pop());
                }
                state = STATE.READABLE;
                return deleteHead();
            }
            default: throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        P09_Dequeby2Stack queue = new P09_Dequeby2Stack();
        // queue.appendTail(1);
        // queue.appendTail(2);

        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
