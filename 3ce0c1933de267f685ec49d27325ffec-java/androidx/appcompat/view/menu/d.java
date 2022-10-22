package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;
/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    e f692a;

    /* renamed from: b  reason: collision with root package name */
    private int f693b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f694c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f695d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f696e;

    /* renamed from: f  reason: collision with root package name */
    private final int f697f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f695d = z10;
        this.f696e = layoutInflater;
        this.f692a = eVar;
        this.f697f = i10;
        a();
    }

    void a() {
        g x10 = this.f692a.x();
        if (x10 != null) {
            ArrayList<g> B = this.f692a.B();
            int size = B.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (B.get(i10) == x10) {
                    this.f693b = i10;
                    return;
                }
            }
        }
        this.f693b = -1;
    }

    public e b() {
        return this.f692a;
    }

    /* renamed from: c */
    public g getItem(int i10) {
        ArrayList<g> B = this.f695d ? this.f692a.B() : this.f692a.G();
        int i11 = this.f693b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return B.get(i10);
    }

    public void d(boolean z10) {
        this.f694c = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<g> B = this.f695d ? this.f692a.B() : this.f692a.G();
        if (this.f693b < 0) {
            return B.size();
        }
        return B.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f696e.inflate(this.f697f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i11 = i10 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f692a.H() && groupId != (i11 >= 0 ? getItem(i11).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f694c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i10), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
