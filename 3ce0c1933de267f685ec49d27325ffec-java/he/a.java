package he;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.device.DeviceProvider;
import ge.k;
import ge.l;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DevicePairAdapter.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<C0301a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<DeviceProvider.DeviceData> f27815a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<View.OnClickListener> f27816b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DevicePairAdapter.java */
    /* renamed from: he.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0301a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        ImageView f27817a;

        /* renamed from: b  reason: collision with root package name */
        TextView f27818b;

        /* renamed from: c  reason: collision with root package name */
        Button f27819c;

        public C0301a(View view, int i10) {
            super(view);
            this.f27817a = (ImageView) view.findViewById(k.e_res_0x7f0b0383);
            this.f27818b = (TextView) view.findViewById(k.i_res_0x7f0b07ec);
            if (i10 == 1) {
                this.f27819c = (Button) view.findViewById(k.a_res_0x7f0b0122);
            }
        }
    }

    /* renamed from: c */
    public void onBindViewHolder(C0301a aVar, int i10) {
        DeviceProvider.DeviceData deviceData = this.f27815a.get(i10);
        aVar.f27817a.setImageResource(deviceData.f17848b);
        aVar.f27818b.setText(deviceData.f17849c);
        if (getItemViewType(i10) == 1) {
            aVar.f27819c.setOnClickListener(this.f27816b.get(deviceData.f17847a));
        } else {
            aVar.itemView.setOnClickListener(this.f27816b.get(deviceData.f17847a));
        }
    }

    /* renamed from: d */
    public C0301a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new C0301a(i10 == 0 ? LayoutInflater.from(viewGroup.getContext()).inflate(l.h_res_0x7f0e0132, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(l.g_res_0x7f0e0128, viewGroup, false), i10);
    }

    public void e(SparseArray<View.OnClickListener> sparseArray) {
        this.f27816b = sparseArray;
    }

    public void f(List<DeviceProvider.DeviceData> list) {
        this.f27815a.clear();
        this.f27815a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f27815a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return this.f27815a.get(i10).f17850d;
    }
}
