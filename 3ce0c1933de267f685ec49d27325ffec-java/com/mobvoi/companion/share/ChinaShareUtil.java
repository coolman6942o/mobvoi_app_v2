package com.mobvoi.companion.share;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class ChinaShareUtil {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f17412a;

    /* loaded from: classes2.dex */
    public static class ShareException extends Exception {
        public ShareException(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public a(ChinaShareUtil chinaShareUtil) {
        }
    }

    public ChinaShareUtil(Activity activity) {
        this.f17412a = activity.getApplicationContext();
        new WeakReference(activity);
        new a(this);
    }
}
