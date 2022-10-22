package pc;

import ae.d;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ce.e;
import ce.f;
import ce.h;
import com.mobvoi.android.common.ui.widget.BatteryIconView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
/* compiled from: BaseWatchOverseaCardFragment.java */
/* loaded from: classes2.dex */
public class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected int f32728a;

    /* renamed from: b  reason: collision with root package name */
    protected String f32729b;

    /* renamed from: d  reason: collision with root package name */
    protected ImageView f32731d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f32732e;

    /* renamed from: f  reason: collision with root package name */
    protected ImageView f32733f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f32734g;

    /* renamed from: h  reason: collision with root package name */
    protected BatteryIconView f32735h;

    /* renamed from: i  reason: collision with root package name */
    protected TextView f32736i;

    /* renamed from: j  reason: collision with root package name */
    protected RecyclerView f32737j;

    /* renamed from: k  reason: collision with root package name */
    protected GridLayoutManager f32738k;

    /* renamed from: l  reason: collision with root package name */
    protected d f32739l;

    /* renamed from: c  reason: collision with root package name */
    protected int f32730c = 3;

    /* renamed from: m  reason: collision with root package name */
    private int f32740m = -7829368;

    /* renamed from: n  reason: collision with root package name */
    protected Handler f32741n = new Handler(Looper.getMainLooper());

    /* renamed from: o  reason: collision with root package name */
    protected Runnable f32742o = new Runnable() { // from class: pc.a
        @Override // java.lang.Runnable
        public final void run() {
            b.this.b0();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseWatchOverseaCardFragment.java */
    /* loaded from: classes2.dex */
    public class a extends GridLayoutManager.c {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            return (b.this.f32739l.getItemCount() <= i10 || !b.this.f32739l.c(i10).isWatchFace) ? 1 : 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        k.a("WatchOverseaCard", "refresh ui view");
        f0();
        c0();
    }

    private void i0() {
        this.f32733f.setImageResource(ce.d.f5758f);
        this.f32734g.setText(h.f5850i);
        this.f32734g.setTextColor(getResources().getColor(ce.b.f5746c));
        this.f32735h.setVisibility(0);
        this.f32736i.setVisibility(0);
    }

    private void j0() {
        this.f32733f.setImageResource(ce.d.f5755c);
        this.f32734g.setText(h.f5850i);
        this.f32734g.setTextColor(getResources().getColor(ce.b.f5746c));
        this.f32735h.setVisibility(0);
        this.f32736i.setVisibility(0);
    }

    private void k0() {
        this.f32733f.setImageResource(ce.d.f5759g);
        this.f32734g.setText(h.f5852j);
        try {
            this.f32734g.setTextColor(this.f32740m);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f32735h.setVisibility(8);
        this.f32736i.setVisibility(8);
    }

    public int Z() {
        return f.f5830x;
    }

    protected void a0(View view) {
        this.f32737j = (RecyclerView) view.findViewById(e.J);
        this.f32731d = (ImageView) view.findViewById(e.f5797r);
        this.f32732e = (TextView) view.findViewById(e.f5787m);
        view.findViewById(e.G);
        this.f32733f = (ImageView) view.findViewById(e.f5805y);
        this.f32734g = (TextView) view.findViewById(e.f5768c0);
        this.f32735h = (BatteryIconView) view.findViewById(e.f5765b);
        this.f32736i = (TextView) view.findViewById(e.f5767c);
        view.findViewById(e.H);
        TextView textView = (TextView) view.findViewById(e.f5792o0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        this.f32738k = gridLayoutManager;
        this.f32737j.setLayoutManager(gridLayoutManager);
        this.f32737j.setAdapter(this.f32739l);
        this.f32738k.e3(new a());
        this.f32741n.post(this.f32742o);
    }

    protected void c0() {
        if (getActivity() != null) {
            if (this.f32728a == -1) {
                TextView textView = this.f32736i;
                textView.setText(getString(h.f5866q) + getString(h.T));
                return;
            }
            TextView textView2 = this.f32736i;
            textView2.setText(this.f32728a + getString(h.T));
            this.f32735h.setBattery(this.f32728a);
        }
    }

    protected void d0() {
        if (!TextUtils.isEmpty(this.f32729b)) {
            this.f32732e.setText(this.f32729b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e0() {
        this.f32741n.post(this.f32742o);
    }

    protected void f0() {
        if (getActivity() != null) {
            k.a("WatchOverseaCard", "the connection state is: " + this.f32730c);
            int i10 = this.f32730c;
            if (i10 == 1) {
                i0();
            } else if (i10 == 2) {
                j0();
            } else if (i10 == 3) {
                k0();
            }
            this.f32732e.setText(this.f32729b);
        }
    }

    protected void g0() {
        MessageProxyClient.getInstance().sendMessage(WearPath.Companion.SYNC_WEAR_BATTERY, new byte[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h0(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f32729b = str;
            d0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f32739l = new d();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(Z(), viewGroup, false);
        this.f32740m = j7.a.b(requireActivity(), 16842806, -7829368);
        a0(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        k.a("WatchOverseaCard", "the card onResume");
        g0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        k.a("WatchOverseaCard", "new card created");
        a0(view);
    }
}
