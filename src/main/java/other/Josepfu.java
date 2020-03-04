package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gradyjiang
 * @title: Josepfu 使用单链表算法
 * @projectName datastructure-and-algorithm
 * @description: 约瑟夫问题算法
 * n 个人围成一圈，从第一个人开始报数,数到 m 的人出列，
 * 再由下一个人重新从 1 开始报数，数到 m 的人再出圈，依次类推，直到所有的人都出圈，请输出依次出圈人的编号。
 * 输入两个整数 n, m。
 * 输出一行 n 个整数，按顺序输出每个出圈人的编号
 * @date 2020/2/27
 */
public class Josepfu {

    public List<Integer> handleJosepfuQuestion(int personCount, int m) {
        if (m <= 0) {
            throw new RuntimeException("不可移动小于等于0步");
        }
        if (personCount <= 0) {
            throw new RuntimeException("不可节点数小于等于0");
        }
        CircleLinkList linkList = makeCircleList(personCount);
        List<Integer> list = new ArrayList<Integer>();
        ListNode node = linkList.head();

        while (node != node.next) {
            ListNode popNode = popNode(node, m);
            list.add(popNode.num);
            node = popNode.next;
        }
        list.add(node.num);
        return list;
    }

    /**
     * 算上自己，移动m步
     * @param node
     * @param m
     * @return
     */
    private ListNode popNode(ListNode node, int m) {
        if (node == node.next) return node;
        //找到node的上一个node
        ListNode helperNode = node;
        while(helperNode.next != node) {
            helperNode = helperNode.next;
        }

        for (int i = 1; i < m; i++) {
            node = node.next;
            helperNode = helperNode.next;
        }
        helperNode.next = node.next;
        return node;
    }

    private CircleLinkList makeCircleList(int personCount) {
        CircleLinkList circleLinkList = new CircleLinkList();
        for (int i = 0; i < personCount; i++) {
            ListNode node = new ListNode(i, null);
            circleLinkList.add(node);
        }
        return circleLinkList;
    }


    static class CircleLinkList {
        private int size;
        private ListNode tail;

        public CircleLinkList() {
            this.tail = null;
            this.size = 0;
        }

        public void add(ListNode node) {
            if (tail == null) {
                tail = node;
                tail.next = node;
                size++;
            } else {
                ListNode temp = tail.next;
                tail.next = node;
                node.next = temp;
                tail = node;
            }
        }

        public ListNode head() {
            if (tail == null) return null;
            return tail.next;
        }

        public void printList() {
            if (tail == null) return;
            ListNode head = tail.next;
            ListNode temp = tail.next;
            while (true) {
                System.out.println(temp.num);
                temp = temp.next;
                if (temp == head) return;
            }
        }

        public int size() {
            return this.size;
        }

    }

    static class ListNode {
        int num;
        ListNode next;

        public ListNode(int num, ListNode next) {
            this.num = num;
            this.next = next;
        }
    }
}
