package ae;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.ui.e;
import java.util.ArrayList;
import java.util.List;
/* compiled from: WatchCommonItemViewAdapter.java */
/* loaded from: classes2.dex */
public class d extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f186a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WatchCommonItemViewAdapter.java */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        c f187a;

        /* renamed from: b  reason: collision with root package name */
        e f188b;

        public a(d dVar, View view, int i10) {
            super(view);
            if (i10 == 1) {
                this.f188b = (e) view;
            } else {
                this.f187a = (c) view;
            }
        }
    }

    public e c(int i10) {
        return this.f186a.get(i10);
    }

    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i10) {
        e eVar = this.f186a.get(i10);
        if (getItemViewType(i10) == 1) {
            aVar.f188b.a(eVar);
        } else {
            aVar.f187a.a(eVar);
        }
    }

    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View view;
        if (i10 == 1) {
            view = new e(viewGroup.getContext());
        } else {
            view = new c(viewGroup.getContext());
        }
        return new a(this, view, i10);
    }

    public void f(List<e> list) {
        this.f186a.clear();
        this.f186a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f186a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return this.f186a.get(i10).isWatchFace ? 1 : 2;
    }
}
