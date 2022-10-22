package ch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import fg.s;
import fg.t;
import java.util.List;
import lf.c;
/* compiled from: HealthSwimSegmentAdapter.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<gh.a> f5890a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5891b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HealthSwimSegmentAdapter.java */
    /* renamed from: ch.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0083a {

        /* renamed from: a  reason: collision with root package name */
        TextView f5892a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5893b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5894c;

        /* renamed from: d  reason: collision with root package name */
        TextView f5895d;

        /* renamed from: e  reason: collision with root package name */
        TextView f5896e;

        C0083a(View view) {
            this.f5892a = (TextView) view.findViewById(s.f26825z4);
            this.f5893b = (TextView) view.findViewById(s.f26818y4);
            this.f5894c = (TextView) view.findViewById(s.B4);
            this.f5895d = (TextView) view.findViewById(s.D4);
            this.f5896e = (TextView) view.findViewById(s.C4);
        }
    }

    public a(Context context, List<gh.a> list) {
        this.f5891b = context;
        this.f5890a = list;
        notifyDataSetChanged();
    }

    @SuppressLint({"DefaultLocale"})
    private void a(C0083a aVar, int i10) {
        aVar.f5892a.setText(String.format("%d", Integer.valueOf(this.f5890a.get(i10).f27475a)));
        aVar.f5893b.setText(String.format("%d", Integer.valueOf(this.f5890a.get(i10).f27476b)));
        aVar.f5894c.setText(c.d(SportDataType.SwimPace, this.f5890a.get(i10).f27477c, !com.mobvoi.companion.base.settings.a.isUnitMetric(this.f5891b)));
        aVar.f5895d.setText(String.format("%d", Integer.valueOf(this.f5890a.get(i10).f27478d)));
        aVar.f5896e.setText(String.format("%d", Integer.valueOf(this.f5890a.get(i10).f27479e)));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5890a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return Integer.valueOf(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0083a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f5891b).inflate(t.I, (ViewGroup) null);
            aVar = new C0083a(view);
            view.setTag(aVar);
        } else {
            aVar = (C0083a) view.getTag();
        }
        a(aVar, i10);
        return view;
    }
}
