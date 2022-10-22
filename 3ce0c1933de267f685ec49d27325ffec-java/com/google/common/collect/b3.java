package com.google.common.collect;

import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Count.java */
/* loaded from: classes.dex */
public final class b3 implements Serializable {
    private int value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b3(int i10) {
        this.value = i10;
    }

    public void a(int i10) {
        this.value += i10;
    }

    public int b(int i10) {
        int i11 = this.value + i10;
        this.value = i11;
        return i11;
    }

    public int c() {
        return this.value;
    }

    public int d(int i10) {
        int i11 = this.value;
        this.value = i10;
        return i11;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b3) && ((b3) obj).value == this.value;
    }

    public void g(int i10) {
        this.value = i10;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
