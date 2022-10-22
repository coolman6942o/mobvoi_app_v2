package tg;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.health.companion.HealthSleepSharesActivity;
import com.mobvoi.health.companion.sleep.SleepDetailAdapter;
import com.mobvoi.health.companion.system.c;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import fg.s;
import fg.t;
import fg.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kh.z;
import nf.e;
import nf.f;
import nf.g;
import nf.h;
import nf.j;
import nf.k;
import nf.m;
import zj.b;
/* compiled from: HealthSleepDetailFragment.java */
/* loaded from: classes2.dex */
public class d extends e implements f<z>, View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private String f35152d;

    /* renamed from: f  reason: collision with root package name */
    private Dialog f35154f;

    /* renamed from: g  reason: collision with root package name */
    private z f35155g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f35156h;

    /* renamed from: i  reason: collision with root package name */
    private SleepDetailAdapter f35157i;

    /* renamed from: k  reason: collision with root package name */
    TextView f35159k;

    /* renamed from: l  reason: collision with root package name */
    private View f35160l;

    /* renamed from: m  reason: collision with root package name */
    private View f35161m;

    /* renamed from: e  reason: collision with root package name */
    private m f35153e = new m();

    /* renamed from: j  reason: collision with root package name */
    private List<sg.d> f35158j = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(h hVar, SleepRecord sleepRecord) {
        List<sg.d> list = this.f35158j;
        if (list == null) {
            this.f35158j = new ArrayList();
        } else {
            list.clear();
        }
        this.f35158j.add(new sg.d(0, sleepRecord));
        this.f35158j.add(new sg.d(1, sleepRecord));
        List<xf.h> a10 = b.a(sleepRecord);
        if (a10 != null && a10.size() > 0) {
            this.f35158j.add(new sg.d(2, sleepRecord));
        }
        if (!(sleepRecord == null || sleepRecord.f() == null || sleepRecord.f().oxygen == null || sleepRecord.f().oxygen.size() <= 0)) {
            this.f35158j.add(new sg.d(4, sleepRecord));
        }
        this.f35157i.setNewData(this.f35158j);
        Date date = new Date(sleepRecord.f20741e);
        this.f35159k.setText(new SimpleDateFormat(SettingConstants.DATE_FORMAT_DEFAULT, Locale.getDefault()).format(date));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(DialogInterface dialogInterface, int i10) {
        this.f35155g.g();
        dialogInterface.dismiss();
        getActivity().setResult(-1);
        getActivity().finish();
    }

    private void i0() {
        if (this.f35154f == null) {
            this.f35154f = new k7.b(requireActivity()).d(true).D(getString(u.f26913j4)).j(u.f26938o, b.f35150a).m(u.f26944p, new DialogInterface.OnClickListener() { // from class: tg.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    d.this.g0(dialogInterface, i10);
                }
            }).a();
        }
        if (!this.f35154f.isShowing()) {
            this.f35154f.show();
        }
    }

    @Override // nf.e
    protected f Z() {
        return this;
    }

    @Override // nf.e
    protected g a0() {
        String string = getArguments().getString("sportId");
        this.f35152d = string;
        z zVar = new z(string);
        this.f35155g = zVar;
        return zVar;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: h0 */
    public void setViewModel(z zVar) {
        this.f35153e.clear();
        if (zVar != null) {
            this.f35153e.a(j.c(zVar.h(), new k() { // from class: tg.c
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    d.this.e0(hVar, (SleepRecord) obj);
                }
            }));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == s.f26768r3) {
            getActivity().finish();
        } else if (id2 == s.f26727l3) {
            Intent intent = new Intent(getActivity(), HealthSleepSharesActivity.class);
            intent.putExtra("sleepId", this.f35152d);
            startActivity(intent);
        } else if (id2 == s.U2) {
            i0();
        }
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.f26847u, viewGroup, false);
        this.f35159k = (TextView) inflate.findViewById(s.f26694g5);
        this.f35156h = (RecyclerView) inflate.findViewById(s.W2);
        inflate.findViewById(s.f26768r3).setOnClickListener(this);
        this.f35161m = inflate.findViewById(s.U2);
        this.f35160l = inflate.findViewById(s.f26727l3);
        this.f35161m.setOnClickListener(this);
        this.f35160l.setOnClickListener(this);
        if (c.a().p()) {
            this.f35161m.setVisibility(8);
            this.f35160l.setVisibility(8);
        }
        this.f35157i = new SleepDetailAdapter(getActivity(), null);
        this.f35156h.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f35157i.bindToRecyclerView(this.f35156h);
        return inflate;
    }
}
