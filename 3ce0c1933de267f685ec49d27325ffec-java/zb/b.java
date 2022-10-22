package zb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.mobvoi.companion.aw.watchfacecenter.n;
import com.mobvoi.companion.aw.watchfacecenter.p;
import com.mobvoi.companion.aw.watchfacecenter.q;
import com.mobvoi.companion.aw.watchfacecenter.widget.SquareImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
/* compiled from: PreviewImagesAdapter.kt */
/* loaded from: classes2.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f37327a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f37328b = new ArrayList<>();

    /* compiled from: PreviewImagesAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final SquareImageView f37329a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.f(view, "view");
            this.f37329a = (SquareImageView) view.findViewById(p.d_res_0x7f0b036a);
        }

        public final SquareImageView a() {
            return this.f37329a;
        }
    }

    public b(Context context) {
        i.f(context, "context");
        this.f37327a = context;
    }

    /* renamed from: c */
    public void onBindViewHolder(a holder, int i10) {
        i.f(holder, "holder");
        c.u(this.f37327a).j().z0(this.f37328b.get(i10)).U(n.f16463g).u0(holder.a());
    }

    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View inflateView = LayoutInflater.from(this.f37327a).inflate(q.m_res_0x7f0e0183, parent, false);
        i.e(inflateView, "inflateView");
        return new a(inflateView);
    }

    /* renamed from: e */
    public void onViewRecycled(a holder) {
        i.f(holder, "holder");
        super.onViewRecycled(holder);
        c.u(this.f37327a).l(holder.a());
    }

    public final void f(List<String> list) {
        i.f(list, "list");
        ArrayList<String> arrayList = this.f37328b;
        arrayList.clear();
        arrayList.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f37328b.size();
    }
}
