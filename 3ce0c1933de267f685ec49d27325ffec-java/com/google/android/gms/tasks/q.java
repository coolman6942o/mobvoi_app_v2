package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f10178a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Queue<p<TResult>> f10179b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10180c;

    public final void a(b<TResult> bVar) {
        p<TResult> poll;
        synchronized (this.f10178a) {
            if (this.f10179b != null && !this.f10180c) {
                this.f10180c = true;
                while (true) {
                    synchronized (this.f10178a) {
                        poll = this.f10179b.poll();
                        if (poll == null) {
                            this.f10180c = false;
                            return;
                        }
                    }
                    poll.a(bVar);
                }
            }
        }
    }

    public final void b(p<TResult> pVar) {
        synchronized (this.f10178a) {
            if (this.f10179b == null) {
                this.f10179b = new ArrayDeque();
            }
            this.f10179b.add(pVar);
        }
    }
}
