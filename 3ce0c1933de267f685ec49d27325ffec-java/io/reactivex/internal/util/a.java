package io.reactivex.internal.util;

import io.reactivex.r;
import zn.p;
/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f29251a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f29252b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f29253c;

    /* renamed from: d  reason: collision with root package name */
    int f29254d;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: io.reactivex.internal.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface AbstractC0348a<T> extends p<T> {
        @Override // zn.p
        boolean test(T t10);
    }

    public a(int i10) {
        this.f29251a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f29252b = objArr;
        this.f29253c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean a(r<? super U> rVar) {
        Object[] objArr = this.f29252b;
        int i10 = this.f29251a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr2, rVar)) {
                    return true;
                }
            }
            objArr = objArr[i10];
        }
    }

    public void b(T t10) {
        int i10 = this.f29251a;
        int i11 = this.f29254d;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.f29253c[i10] = objArr;
            this.f29253c = objArr;
            i11 = 0;
        }
        this.f29253c[i11] = t10;
        this.f29254d = i11 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0018, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(AbstractC0348a<? super T> aVar) {
        int i10 = this.f29251a;
        for (Object[] objArr = this.f29252b; objArr != null; objArr = objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj == null) {
                    break;
                } else if (aVar.test(obj)) {
                    return;
                }
            }
        }
    }

    public void d(T t10) {
        this.f29252b[0] = t10;
    }
}
