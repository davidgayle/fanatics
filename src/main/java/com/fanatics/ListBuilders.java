package com.fanatic;

/**
 * Copyright (c) 2018. All rights reserved. This module contains Time Warner Cable/Charter Communications
 * confidential and proprietary information. The information contained herein is governed by license and shall
 * not be distributed or copied without written permission from Time Warner Cable or Charter Communications.
 * <p>
 * Created by dgayle on 7/19/18.
 */
public class ListBuilders {
    static IntegerNode buildCircularIntList(int[] values) {
        if (values == null || values.length == 0) return null;

        IntegerNode head = null, cur = null;
        for (int value : values) {
            if (head == null) {
                head = cur = new IntegerNode(value);
            } else {
                cur.next = new IntegerNode(value);
                cur = cur.next;
            }
        }
        cur.next = head;
        return head;
    }

    static ComparableNode<Integer> buildCircularCompList(int[] values) {
        if (values == null || values.length == 0) return null;

        ComparableNode<Integer> head = null, cur = null;
        for (int value : values) {
            if (head == null) {
                head = cur = new ComparableNode<>(value);
            } else {
                cur.next = new ComparableNode<Integer>(value);
                cur = cur.next;
            }
        }
        cur.next = head;
        return head;
    }
}
