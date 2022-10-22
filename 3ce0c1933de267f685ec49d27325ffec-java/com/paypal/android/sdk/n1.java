package com.paypal.android.sdk;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class n1 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final s1 f21463a;

    /* renamed from: b  reason: collision with root package name */
    private final List f21464b = Collections.synchronizedList(new LinkedList());

    /* renamed from: c  reason: collision with root package name */
    private boolean f21465c;

    /* renamed from: d  reason: collision with root package name */
    private final o1 f21466d;

    public n1(s1 s1Var, o1 o1Var) {
        this.f21463a = s1Var;
        this.f21466d = o1Var;
        start();
    }

    public final void a() {
        if (!this.f21465c) {
            this.f21466d.a();
            this.f21465c = true;
            synchronized (this.f21464b) {
                this.f21464b.notifyAll();
            }
            interrupt();
            while (isAlive()) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public final void b(r1 r1Var) {
        synchronized (this.f21464b) {
            this.f21464b.add(r1Var);
            r1Var.v();
            this.f21464b.notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0002 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        x0 x0Var;
        while (!this.f21465c) {
            r1 r1Var = null;
            synchronized (this.f21464b) {
                if (this.f21464b.isEmpty()) {
                    try {
                        this.f21464b.wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    r1Var = (r1) this.f21464b.remove(0);
                }
            }
            if (r1Var != null) {
                try {
                    r1Var.d(r1Var.h());
                } catch (UnsupportedEncodingException e10) {
                    Log.e("paypal.sdk", "Exception computing request", e10);
                    x0Var = new x0(by.PARSE_RESPONSE_ERROR.toString(), "Unsupported encoding", e10.getMessage());
                    r1Var.b(x0Var);
                    if (!this.f21466d.a(r1Var)) {
                    }
                } catch (JSONException e11) {
                    Log.e("paypal.sdk", "Exception computing request", e11);
                    x0Var = new x0(by.PARSE_RESPONSE_ERROR.toString(), "JSON Exception in computeRequest", e11.getMessage());
                    r1Var.b(x0Var);
                    if (!this.f21466d.a(r1Var)) {
                    }
                }
                if (!this.f21466d.a(r1Var)) {
                    this.f21463a.a(r1Var);
                }
            }
        }
    }
}
