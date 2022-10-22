package ik;

import ak.d;
import ak.e;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.g;
import com.google.android.material.button.MaterialButton;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: TicICareAdapter.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    private List<TicCareDeviceInfo> f28302a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private AbstractC0317b f28303b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TicICareAdapter.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TicCareDeviceInfo f28304a;

        a(TicCareDeviceInfo ticCareDeviceInfo) {
            this.f28304a = ticCareDeviceInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f28303b.b(this.f28304a);
        }
    }

    /* compiled from: TicICareAdapter.java */
    /* renamed from: ik.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0317b {
        void a();

        void b(TicCareDeviceInfo ticCareDeviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TicICareAdapter.java */
    /* loaded from: classes2.dex */
    public static class c extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        ImageView f28306a;

        /* renamed from: b  reason: collision with root package name */
        TextView f28307b;

        /* renamed from: c  reason: collision with root package name */
        MaterialButton f28308c;

        /* renamed from: d  reason: collision with root package name */
        View f28309d;

        public c(View view) {
            super(view);
            this.f28306a = (ImageView) view.findViewById(d.S_res_0x7f0b0887);
            this.f28307b = (TextView) view.findViewById(d.T_res_0x7f0b0889);
            this.f28308c = (MaterialButton) view.findViewById(d.R_res_0x7f0b0868);
            this.f28309d = view.findViewById(d.c_res_0x7f0b0113);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void d(String str) {
        Iterator<TicCareDeviceInfo> it = this.f28302a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TicCareDeviceInfo next = it.next();
            if (next.wwid.equals(str)) {
                this.f28302a.remove(next);
                break;
            }
        }
        notifyDataSetChanged();
        if (this.f28302a.size() == 0) {
            this.f28303b.a();
        }
    }

    /* renamed from: e */
    public void onBindViewHolder(c cVar, int i10) {
        TicCareDeviceInfo ticCareDeviceInfo = this.f28302a.get(i10);
        g<Drawable> k02 = com.bumptech.glide.c.u(cVar.itemView.getContext()).r(ticCareDeviceInfo.headImgUrl).a(j5.c.j0(new a5.g()));
        int i11 = ak.c.f221b;
        k02.U(i11).j(i11).u0(cVar.f28306a);
        if (!TextUtils.isEmpty(ticCareDeviceInfo.remarkName)) {
            cVar.f28307b.setText(ticCareDeviceInfo.remarkName);
        } else {
            cVar.f28307b.setText(ticCareDeviceInfo.nickName);
        }
        cVar.f28308c.setOnClickListener(new a(ticCareDeviceInfo));
        cVar.f28309d.setVisibility(i10 == getItemCount() + (-1) ? 8 : 0);
    }

    /* renamed from: f */
    public c onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(e.f_res_0x7f0e0143, viewGroup, false));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void g(List<TicCareDeviceInfo> list) {
        this.f28302a.clear();
        this.f28302a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f28302a.size();
    }

    public void h(AbstractC0317b bVar) {
        this.f28303b = bVar;
    }
}
