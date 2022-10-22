package n0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ResourceCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: i  reason: collision with root package name */
    private int f30858i;

    /* renamed from: j  reason: collision with root package name */
    private int f30859j;

    /* renamed from: k  reason: collision with root package name */
    private LayoutInflater f30860k;

    @Deprecated
    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f30859j = i10;
        this.f30858i = i10;
        this.f30860k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // n0.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f30860k.inflate(this.f30859j, viewGroup, false);
    }

    @Override // n0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f30860k.inflate(this.f30858i, viewGroup, false);
    }
}
