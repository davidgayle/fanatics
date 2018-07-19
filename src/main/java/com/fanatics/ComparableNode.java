package com.fanatic;

/**
 * Copyright (c) 2018. All rights reserved. This module contains Time Warner Cable/Charter Communications
 * confidential and proprietary information. The information contained herein is governed by license and shall
 * not be distributed or copied without written permission from Time Warner Cable or Charter Communications.
 * <p>
 * Created by dgayle on 7/19/18.
 */
class ComparableNode<T> {
    ComparableNode next;
    Comparable<T> val;
    ComparableNode(Comparable<T> val) {this.val = val;}
}
