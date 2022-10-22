package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f6839a;

    public c(b bVar) {
        this.f6839a = bVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x000e */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        try {
            Process.setThreadPriority(0);
            while (!linkedList.isEmpty()) {
                linkedList2 = this.f6839a.f6838c;
                Runnable runnable = (Runnable) linkedList2.get(0);
                linkedList3 = this.f6839a.f6838c;
                linkedList3.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th2) {
            this.f6839a.f6837b = null;
            throw th2;
        }
        this.f6839a.f6837b = null;
    }
}
