package other;

/**
 * @author gradyjiang
 * @title: MergeSortList
 * @projectName datastructure-and-algorithm
 * @description: 合并两个升序链表
 * @date 2020/2/27
 */
public class MergeSortList {

    public static class ListNode {
        int num;
        ListNode next;
    }

    // 递归方式
    public ListNode mergeSortList(ListNode firstNode, ListNode secondNode) {
        if (firstNode == null && secondNode == null) {
            return null;
        }
        if (firstNode == null) {
            return secondNode;
        }
        if (secondNode == null) {
            return firstNode;
        }
        return mergeNode(firstNode, secondNode);
    }

    private ListNode mergeNode(ListNode firstNode, ListNode secondNode) {
        if (firstNode == null || secondNode == null) {
            return null;
        }
        if (firstNode.num <= secondNode.num) {
            mergeNode(firstNode.next, secondNode);
            firstNode.next = secondNode;
            return firstNode;
        } else {
            mergeNode(firstNode, secondNode.next);
            secondNode.next = firstNode;
            return secondNode;
        }
    }

    // 非递归方式
    public ListNode mergeSortList2(ListNode firstNode, ListNode secondNode) {
        if (firstNode == null && secondNode == null) {
            return null;
        }
        if (firstNode == null) {
            return secondNode;
        }
        if (secondNode == null) {
            return firstNode;
        }

        if (firstNode.num <= secondNode.num) {
            while (secondNode != null) {
                ListNode tmp = secondNode.next;
                mergeNode2(firstNode, secondNode);
                secondNode = tmp;
            }
            return firstNode;
        } else {
            while(firstNode != null) {
                ListNode tmp = firstNode.next;
                mergeNode2(secondNode, firstNode);
                firstNode = tmp;
            }
            return secondNode;
        }
    }

    private void mergeNode2(ListNode srcNode, ListNode node) {
        while (srcNode.next != null) {
            if (srcNode.next.num >= node.num) {
                ListNode tmp = srcNode.next;
                srcNode.next = node;
                node.next = tmp;
                return;
            }
            srcNode = srcNode.next;
        }
        srcNode.next = node;
    }
}
