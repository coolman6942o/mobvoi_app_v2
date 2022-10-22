package com.mobvoi.companion.health;

import android.content.Context;
import androidx.core.content.b;
import kotlin.jvm.internal.i;
/* compiled from: HomeMedalView.kt */
/* loaded from: classes2.dex */
public final class b4 {

    /* renamed from: a  reason: collision with root package name */
    private final int f16824a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16825b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16826c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16827d;

    public b4(int i10, int i11, int i12, int i13) {
        this.f16824a = i10;
        this.f16825b = i11;
        this.f16826c = i12;
        this.f16827d = i13;
    }

    public final int a() {
        return this.f16825b;
    }

    public final int b() {
        return this.f16827d;
    }

    public final int c(Context context) {
        i.f(context, "context");
        return b.c(context, this.f16827d);
    }

    public final int d() {
        return this.f16826c;
    }

    public final int e(Context context) {
        i.f(context, "context");
        return b.c(context, this.f16826c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b4)) {
            return false;
        }
        b4 b4Var = (b4) obj;
        return this.f16824a == b4Var.f16824a && this.f16825b == b4Var.f16825b && this.f16826c == b4Var.f16826c && this.f16827d == b4Var.f16827d;
    }

    public final int f() {
        return this.f16824a;
    }

    public int hashCode() {
        return (((((this.f16824a * 31) + this.f16825b) * 31) + this.f16826c) * 31) + this.f16827d;
    }

    public String toString() {
        return "WeeklyTheme(uncompletedMedalIconResId=" + this.f16824a + ", completedMedalIconResId=" + this.f16825b + ", startColor=" + this.f16826c + ", endColor=" + this.f16827d + ')';
    }
}
