package com.fanatic;

/**
 *   You are given a circular list of numbers which is constantly increasing but
 *   you don't know where the list begins (ie: 42, 49, 86, 143, 234, 334, 401,
 *   435, 2, 14, 21).
 *
 *  - Write a program to find the smallest number in the list. Make your program
 *    as readable as possible.
 *  - Write a program to find the smallest number in the list. Make your program
 *    as efficient and fast as possible.
 *  - Write a program to find the smallest number in the list. Make your program
 *    as extensible and flexible as possible.
 *
 *    NOTES:
 *    For my solution, I will be defining two classes that represent the nodes in
 *    the circular linked list. They are:\
 *
 *    class IntegerNode {
 *          IntegerNode next;
 *          int val;
 *     }
 *
 *    class ComparableNode {
 *          ComparableNode next;
 *          Comparable val;
 *     }
 *
 *     I also wrote helper methods to convert the array provided into the linked
 *     lists. Please note, an actual production version of these solutions would
 *     include null list checks and most likely throw a method specific exception
 *     so it would be easier to track down why the method failed.
 *
 * Created by dgayle on 7/19/18.
 */
public class CircularList {
    public static void main(String[] args) {
        int[] listSrc = {42, 49, 86, 143, 234, 334, 401, 435, 2, 14, 21};

        IntegerNode intList = ListBuilders.buildCircularIntList(listSrc);
        ComparableNode<Integer> compList = ListBuilders.buildCircularCompList(listSrc);

        int readable = smallestValueReadable(intList);
        System.out.printf("Value: %d\n", readable);

        int efficient = smallestValueEfficient(intList);
        System.out.printf("Value: %d\n", efficient);

        Comparable<Integer> extensible = smallestValueExtensible(compList);
        System.out.printf("Value: %s\n", extensible);
    }

    private static int smallestValueReadable(IntegerNode head) {
        int minValue = head.val;

        IntegerNode currentNode = head.next;
        while (currentNode != head) {
            if (minValue > currentNode.val) {
                return currentNode.val;
            }
            currentNode = currentNode.next;
        }

        return minValue;
    }

    // This while loop was used for readability and can be replaced w/ a one line for loop.
    private static int smallestValueEfficient(IntegerNode head) {
        IntegerNode current = head;

        while (current.next != head && current.val <= current.next.val) {
            current = current.next;
        }
        return current.next.val;
    }

    @SuppressWarnings("unchecked")
    private static <T> Comparable<T> smallestValueExtensible(ComparableNode<T> head) {
        ComparableNode<T> current = head;
        while(current.next != head && current.val.compareTo((T) current.next.val) <= 0) {
            current = current.next;
        }
        return current.next.val;
    }
}
