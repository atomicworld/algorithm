package org.atomic.algorithm.HDAcm;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }

}
public class ListAdd {
    public static ListNode addTwoNumber(ListNode node1, ListNode node2) {
        ListNode initNode=new ListNode(0);  //初始化
        ListNode res=initNode;              //返回结果
        int sum=0;
        do {
            sum/=10;
            if(node1!=null){
                sum+=node1.val;
                node1=node1.next;
            }
            if(node2!=null){
                sum+=node2.val;
                node2=node2.next;
            }
            initNode.next=new ListNode(sum%10);
            initNode=initNode.next;

        }while(node1!=null || node2!=null);
        //处理最高位是否超过10
        if(sum / 10 == 1) {
            initNode.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(8);
        node11.next=node12;
        node12.next=node13;

        ListNode node21=new ListNode(6);
        ListNode node22=new ListNode(5);
        ListNode node23=new ListNode(6);
        node21.next=node22;
        node22.next=node23;

        ListNode res = addTwoNumber(node11, node21);
        while (res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
