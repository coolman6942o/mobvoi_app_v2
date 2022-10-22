package io.reactivex.internal.util;

import java.util.concurrent.CountDownLatch;
import zn.a;
import zn.g;
/* compiled from: BlockingIgnoringReceiver.java */
/* loaded from: classes3.dex */
public final class d extends CountDownLatch implements g<Throwable>, a {

    /* renamed from: a  reason: collision with root package name */
    public Throwable f29255a;

    public d() {
        super(1);
    }

    /* renamed from: a */
    public void accept(Throwable th2) {
        this.f29255a = th2;
        countDown();
    }

    @Override // zn.a
    public void run() {
        countDown();
    }
}
