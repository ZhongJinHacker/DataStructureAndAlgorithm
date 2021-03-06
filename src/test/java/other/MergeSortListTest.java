package other;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortListTest {

    MergeSortList.ListNode firstNode;

    MergeSortList.ListNode secondNode;

    @Before
    public void setUp() throws Exception {
        firstNode = new MergeSortList.ListNode();
        firstNode.num = 1;

        MergeSortList.ListNode tmp3 = new MergeSortList.ListNode();
        tmp3.num = 3;
        MergeSortList.ListNode tmp5 = new MergeSortList.ListNode();
        tmp5.num = 5;
        MergeSortList.ListNode tmp7 = new MergeSortList.ListNode();
        tmp7.num = 7;
        firstNode.next = tmp3;
        firstNode.next.next = tmp5;
        firstNode.next.next.next = tmp7;
        // ---
        secondNode = new MergeSortList.ListNode();
        secondNode.num = 2;

        MergeSortList.ListNode tmp4 = new MergeSortList.ListNode();
        tmp4.num = 4;
        MergeSortList.ListNode tmp6 = new MergeSortList.ListNode();
        tmp6.num = 6;
        MergeSortList.ListNode tmp8 = new MergeSortList.ListNode();
        tmp8.num = 8;
        secondNode.next = tmp4;
        secondNode.next.next = tmp6;
        secondNode.next.next.next = tmp8;
    }

    @After
    public void tearDown() throws Exception {
        firstNode = null;
        secondNode = null;
    }

    @Test
    public void mergeSortList() {
        MergeSortList mergeSortList = new MergeSortList();
        MergeSortList.ListNode node = mergeSortList.mergeSortList(firstNode, secondNode);
        int result = 1;
        while (node != null) {
            System.out.println(node.num);
            assertEquals(result, node.num);
            node = node.next;
            result++;
        }
    }

    @Test
    public void mergeSortList2() {
        MergeSortList mergeSortList = new MergeSortList();
        MergeSortList.ListNode node = mergeSortList.mergeSortList2(firstNode, secondNode);
        int result = 1;
        while (node != null) {
            System.out.println(node.num);
            assertEquals(result, node.num);
            node = node.next;
            result++;
        }
    }
}