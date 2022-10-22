package ik;

import ak.d;
import ak.e;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.bumptech.glide.g;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TicCareMeAdapter.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<C0316a> {

    /* renamed from: a  reason: collision with root package name */
    private List<TicCareDeviceInfo> f28298a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TicCareMeAdapter.java */
    /* renamed from: ik.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0316a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        ImageView f28299a;

        /* renamed from: b  reason: collision with root package name */
        TextView f28300b;

        /* renamed from: c  reason: collision with root package name */
        View f28301c;

        public C0316a(View view) {
            super(view);
            this.f28299a = (ImageView) view.findViewById(d.S_res_0x7f0b0887);
            this.f28300b = (TextView) view.findViewById(d.T_res_0x7f0b0889);
            this.f28301c = view.findViewById(d.c_res_0x7f0b0113);
        }
    }

    /* renamed from: c */
    public void onBindViewHolder(C0316a aVar, int i10) {
        TicCareDeviceInfo ticCareDeviceInfo = this.f28298a.get(i10);
        g<Drawable> k02 = c.u(aVar.itemView.getContext()).r(ticCareDeviceInfo.headImgUrl).a(j5.c.j0(new a5.g()));
        int i11 = ak.c.f221b;
        k02.U(i11).j(i11).u0(aVar.f28299a);
        if (!TextUtils.isEmpty(ticCareDeviceInfo.remarkName)) {
            aVar.f28300b.setText(ticCareDeviceInfo.remarkName);
        } else {
            aVar.f28300b.setText(ticCareDeviceInfo.nickName);
        }
        aVar.f28301c.setVisibility(i10 == getItemCount() + (-1) ? 8 : 0);
    }

    /* renamed from: d */
    public C0316a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new C0316a(LayoutInflater.from(viewGroup.getContext()).inflate(e.g_res_0x7f0e0144, viewGroup, false));
    }

    public void e(List<TicCareDeviceInfo> list) {
        this.f28298a.clear();
        this.f28298a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f28298a.size();
    }
}
