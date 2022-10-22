package qj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import java.util.List;
/* compiled from: KeywordAdapter.java */
/* loaded from: classes2.dex */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f33221a;

    /* compiled from: KeywordAdapter.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f33222a;

        a(int i10) {
            this.f33222a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f33221a.remove(this.f33222a);
            c.this.notifyDataSetChanged();
        }
    }

    /* compiled from: KeywordAdapter.java */
    /* loaded from: classes2.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f33224a;

        /* renamed from: b  reason: collision with root package name */
        ImageButton f33225b;

        b() {
        }
    }

    public c(List<String> list) {
        this.f33221a = list;
    }

    public List<String> b() {
        return this.f33221a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f33221a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f33221a.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(i.f20637d, viewGroup, false);
            bVar.f33224a = (TextView) view2.findViewById(h.K);
            bVar.f33225b = (ImageButton) view2.findViewById(h.f20610o);
            view2.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
            view2 = view;
        }
        bVar.f33224a.setText(this.f33221a.get(i10));
        bVar.f33225b.setOnClickListener(new a(i10));
        return view2;
    }
}
