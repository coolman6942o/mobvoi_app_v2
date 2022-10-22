package jh;

import android.view.View;
import hg.f;
/* compiled from: BasePageViewHolder.java */
/* loaded from: classes2.dex */
public abstract class a<T extends f> {

    /* renamed from: a  reason: collision with root package name */
    protected View f29586a;

    /* renamed from: b  reason: collision with root package name */
    protected int f29587b;

    public a(View view) {
        this.f29586a = view;
    }

    public View a() {
        return this.f29586a;
    }

    public void b(int i10) {
        this.f29587b = i10;
    }

    public abstract void c(T t10);
}
