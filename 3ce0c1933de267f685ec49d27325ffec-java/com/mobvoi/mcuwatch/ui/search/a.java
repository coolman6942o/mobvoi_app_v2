package com.mobvoi.mcuwatch.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.i;
import pk.f;
import sh.h;
import sh.k;
/* compiled from: DeviceListAdapter.kt */
/* loaded from: classes2.dex */
public final class a extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19989a;

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f19990b;

    /* compiled from: DeviceListAdapter.kt */
    /* renamed from: com.mobvoi.mcuwatch.ui.search.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0230a {
        private C0230a() {
        }

        public /* synthetic */ C0230a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: DeviceListAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final Context f19991a;

        /* renamed from: b  reason: collision with root package name */
        private final View f19992b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, View containerView) {
            super(containerView);
            i.f(context, "context");
            i.f(containerView, "containerView");
            this.f19991a = context;
            this.f19992b = containerView;
        }

        public final void a(String address) {
            i.f(address, "address");
            String string = this.f19991a.getString(k.f34772a3, address);
            i.e(string, "context.getString(R.string.watch_lite_address_format, address)");
            ((TextView) this.f19992b.findViewById(h.f34694s3)).setText(string);
        }

        public final void b(String name) {
            i.f(name, "name");
            ((TextView) this.f19992b.findViewById(h.O3)).setText(name);
        }
    }

    static {
        new C0230a(null);
    }

    public a(Context context, List<f> dataList) {
        i.f(context, "context");
        i.f(dataList, "dataList");
        this.f19989a = context;
        this.f19990b = dataList;
    }

    public final List<f> c() {
        return this.f19990b;
    }

    public final void d(int i10, f item) {
        i.f(item, "item");
        this.f19990b.add(i10, item);
        notifyItemInserted(this.f19990b.size());
    }

    /* renamed from: e */
    public void onBindViewHolder(b holder, int i10) {
        i.f(holder, "holder");
        f fVar = this.f19990b.get(i10);
        String name = fVar.b();
        i.e(name, "name");
        holder.b(name);
        String address = fVar.a();
        i.e(address, "address");
        holder.a(address);
    }

    /* renamed from: f */
    public b onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        Context context = this.f19989a;
        View inflate = LayoutInflater.from(context).inflate(sh.i.f34753s0, parent, false);
        i.e(inflate, "from(context)\n                .inflate(R.layout.item_ble_device, parent, false)");
        return new b(context, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f19990b.size();
    }
}
