package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: AbstractIterator.java */
/* loaded from: classes.dex */
abstract class b<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private EnumC0137b f11695a = EnumC0137b.NOT_READY;

    /* renamed from: b  reason: collision with root package name */
    private T f11696b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractIterator.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11697a;

        static {
            int[] iArr = new int[EnumC0137b.values().length];
            f11697a = iArr;
            try {
                iArr[EnumC0137b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11697a[EnumC0137b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractIterator.java */
    /* renamed from: com.google.common.base.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0137b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f11695a = EnumC0137b.FAILED;
        this.f11696b = a();
        if (this.f11695a == EnumC0137b.DONE) {
            return false;
        }
        this.f11695a = EnumC0137b.READY;
        return true;
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final T b() {
        this.f11695a = EnumC0137b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        p.u(this.f11695a != EnumC0137b.FAILED);
        int i10 = a.f11697a[this.f11695a.ordinal()];
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
            this.f11695a = EnumC0137b.NOT_READY;
            T t10 = this.f11696b;
            this.f11696b = null;
            return t10;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
