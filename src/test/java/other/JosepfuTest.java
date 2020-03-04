package other;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JosepfuTest {

    @Test
    public void handleJosepfuQuestion() {
        Josepfu josepfu = new Josepfu();
        List<Integer> list = josepfu.handleJosepfuQuestion(6, 4);
        assertEquals(3, (int)list.get(0));
        assertEquals(1, (int)list.get(1));
        assertEquals(0, (int)list.get(2));
        assertEquals(2, (int)list.get(3));
        assertEquals(5, (int)list.get(4));
        assertEquals(4, (int)list.get(5));
        System.out.println(list);

    }

    private Josepfu.CircleLinkList prepareData() {
        Josepfu.CircleLinkList linkList = new Josepfu.CircleLinkList();
        Josepfu.ListNode node1 = new Josepfu.ListNode(1, null);
        Josepfu.ListNode node2 = new Josepfu.ListNode(2, null);
        Josepfu.ListNode node3 = new Josepfu.ListNode(3, null);
        Josepfu.ListNode node4 = new Josepfu.ListNode(4, null);
        Josepfu.ListNode node5 = new Josepfu.ListNode(5, null);

        linkList.add(node1);
        linkList.add(node2);
        linkList.add(node3);
        linkList.add(node4);
        linkList.add(node5);
        return linkList;
    }

    @Test
    public void testCircleLinkList() {
        Josepfu.CircleLinkList linkList = prepareData();
        linkList.printList();
    }
}