package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    int f4087b;

    /* renamed from: c  reason: collision with root package name */
    int f4088c;

    /* renamed from: d  reason: collision with root package name */
    int f4089d;

    /* renamed from: e  reason: collision with root package name */
    int f4090e;

    /* renamed from: h  reason: collision with root package name */
    boolean f4093h;

    /* renamed from: i  reason: collision with root package name */
    boolean f4094i;

    /* renamed from: a  reason: collision with root package name */
    boolean f4086a = true;

    /* renamed from: f  reason: collision with root package name */
    int f4091f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f4092g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.y yVar) {
        int i10 = this.f4088c;
        return i10 >= 0 && i10 < yVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.u uVar) {
        View o10 = uVar.o(this.f4088c);
        this.f4088c += this.f4089d;
        return o10;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f4087b + ", mCurrentPosition=" + this.f4088c + ", mItemDirection=" + this.f4089d + ", mLayoutDirection=" + this.f4090e + ", mStartLine=" + this.f4091f + ", mEndLine=" + this.f4092g + '}';
    }
}
