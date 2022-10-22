package nd;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ee.d;
import java.util.List;
/* compiled from: ShareIntentListAdapter.java */
/* loaded from: classes2.dex */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<ResolveInfo> f31136a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f31137b;

    /* renamed from: c  reason: collision with root package name */
    private Context f31138c;

    /* compiled from: ShareIntentListAdapter.java */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f31139a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f31140b;

        public a(c cVar) {
        }
    }

    public c(Context context, List<ResolveInfo> list) {
        this.f31136a = list;
        this.f31138c = context;
        this.f31137b = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public ResolveInfo getItem(int i10) {
        List<ResolveInfo> list = this.f31136a;
        if (list == null) {
            return null;
        }
        return list.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ResolveInfo> list = this.f31136a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f31137b.inflate(d.d_res_0x7f0e020f, (ViewGroup) null);
            aVar = new a(this);
            aVar.f31139a = (ImageView) view.findViewById(ee.c.e_res_0x7f0b060b);
            aVar.f31140b = (TextView) view.findViewById(ee.c.f_res_0x7f0b060c);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        ResolveInfo a10 = getItem(i10);
        aVar.f31139a.setImageDrawable(a10.activityInfo.loadIcon(this.f31138c.getPackageManager()));
        aVar.f31140b.setText(a10.activityInfo.loadLabel(this.f31138c.getPackageManager()));
        return view;
    }
}
