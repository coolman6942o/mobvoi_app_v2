package dj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.mobvoi.mcuwatch.ui.onlinedial.CustomDialGridView;
import sh.d;
import sh.f;
import sh.h;
import sh.i;
/* compiled from: FontColorGirdAdapter.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f25657a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f25658b;

    /* renamed from: c  reason: collision with root package name */
    private int f25659c = 0;

    /* compiled from: FontColorGirdAdapter.java */
    /* renamed from: dj.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0275a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f25660a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f25661b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f25662c;

        C0275a() {
        }
    }

    public a(Context context, int[] iArr) {
        this.f25657a = context;
        this.f25658b = iArr;
    }

    public void a(int i10) {
        this.f25659c = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f25658b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return Integer.valueOf(this.f25658b[i10]);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0275a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f25657a).inflate(i.P, (ViewGroup) null);
            aVar = new C0275a();
            aVar.f25660a = (ImageView) view.findViewById(h.Y0);
            aVar.f25662c = (ImageView) view.findViewById(h.Z0);
            aVar.f25661b = (ImageView) view.findViewById(h.A4);
            view.setTag(aVar);
        } else {
            aVar = (C0275a) view.getTag();
        }
        if (((CustomDialGridView) viewGroup).f19868a) {
            return view;
        }
        aVar.f25660a.setImageResource(this.f25658b[i10]);
        if (i10 == 0) {
            aVar.f25661b.setImageResource(f.f34538d);
        } else {
            aVar.f25661b.setImageResource(d.f34442a0);
        }
        if (this.f25659c == i10) {
            aVar.f25662c.setImageResource(f.f34535c);
        } else {
            aVar.f25662c.setImageResource(d.f34442a0);
        }
        return view;
    }
}
