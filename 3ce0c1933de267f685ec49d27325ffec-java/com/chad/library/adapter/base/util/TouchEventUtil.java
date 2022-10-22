package com.chad.library.adapter.base.util;
/* loaded from: classes.dex */
public class TouchEventUtil {
    public static String getTouchAction(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "Unknow:id=" + i10 : "ACTION_OUTSIDE" : "ACTION_CANCEL" : "ACTION_MOVE" : "ACTION_UP" : "ACTION_DOWN";
    }
}
