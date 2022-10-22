package com.google.common.collect;

import com.google.common.base.p;
import java.util.NoSuchElementException;
/* compiled from: AbstractIterator.java */
/* loaded from: classes.dex */
public abstract class c<T> extends p8<T> {

    /* renamed from: a  reason: collision with root package name */
    private b f11943a = b.NOT_READY;

    /* renamed from: b  reason: collision with root package name */
    private T f11944b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractIterator.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11945a;

        static {
            int[] iArr = new int[b.values().length];
            f11945a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11945a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractIterator.java */
    /* loaded from: classes.dex */
    public enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f11943a = b.FAILED;
        this.f11944b = a();
        if (this.f11943a == b.DONE) {
            return false;
        }
        this.f11943a = b.READY;
        return true;
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final T b() {
        this.f11943a = b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        p.u(this.f11943a != b.FAILED);
        int i10 = a.f11945a[this.f11943a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f11943a = b.NOT_READY;
            T t10 = this.f11944b;
            this.f11944b = null;
            return t10;
        }
        throw new NoSuchElementException();
    }
}
