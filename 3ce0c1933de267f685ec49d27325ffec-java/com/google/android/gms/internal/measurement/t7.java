package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
final class t7 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f9682a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f9683b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ zzyw f9684c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t7(zzyw zzywVar) {
        this.f9684c = zzywVar;
        this.f9683b = zzywVar.size();
    }

    private final byte a() {
        try {
            zzyw zzywVar = this.f9684c;
            int i10 = this.f9682a;
            this.f9682a = i10 + 1;
            return zzywVar.zzae(i10);
        } catch (IndexOutOfBoundsException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9682a < this.f9683b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
