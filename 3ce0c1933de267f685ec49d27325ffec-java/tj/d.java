package tj;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mobvoi.companion.proto.AccountProto;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.RecordViewModel;
import com.mobvoi.record.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qj.a;
import sj.c;
import sj.g;
import sj.j;
/* compiled from: FullTextFragment.java */
/* loaded from: classes2.dex */
public class d extends tj.f implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    private rj.b f35174f;

    /* renamed from: g  reason: collision with root package name */
    RecordViewModel f35175g;

    /* renamed from: h  reason: collision with root package name */
    private qj.a f35176h;

    /* renamed from: i  reason: collision with root package name */
    private SoundProto.SoundFile f35177i;

    /* renamed from: j  reason: collision with root package name */
    private h f35178j;

    /* renamed from: k  reason: collision with root package name */
    private int f35179k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<Integer> f35180l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f35181m;

    /* renamed from: n  reason: collision with root package name */
    private List<String> f35182n;

    /* renamed from: o  reason: collision with root package name */
    private int f35183o = -1;

    /* renamed from: p  reason: collision with root package name */
    private SoundProto.SoundConvertResultResp f35184p;

    /* renamed from: q  reason: collision with root package name */
    private j f35185q;

    /* renamed from: r  reason: collision with root package name */
    private sj.c f35186r;

    /* renamed from: s  reason: collision with root package name */
    private int f35187s;

    /* renamed from: t  reason: collision with root package name */
    private String f35188t;

    /* renamed from: u  reason: collision with root package name */
    private int f35189u;

    /* renamed from: v  reason: collision with root package name */
    private final NavController f35190v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullTextFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("soundFile", d.this.f35177i);
            d.this.f35190v.p(com.mobvoi.record.h.f20580c, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullTextFragment.java */
    /* loaded from: classes2.dex */
    public class b implements x<AccountProto.SoundAccountResp> {
        b() {
        }

        /* renamed from: b */
        public void a(AccountProto.SoundAccountResp soundAccountResp) {
            d.this.f35174f.f33535f.setText(String.format(d.this.getResources().getString(k.M), com.mobvoi.record.utils.d.a(soundAccountResp.getSoundAccount().getPaymentTime())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullTextFragment.java */
    /* loaded from: classes2.dex */
    public class c implements x<SoundProto.SoundConvertResultResp> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FullTextFragment.java */
        /* loaded from: classes2.dex */
        public class a implements a.f {
            a() {
            }

            @Override // qj.a.f
            public void a(int i10) {
                d.this.f35178j.a(i10);
            }

            @Override // qj.a.f
            public void b(int i10, int i11, String str) {
                d.this.f35189u = i11;
                if (TextUtils.isEmpty(str)) {
                    d.this.O0(i11);
                } else {
                    d.this.M0(i11, str);
                }
            }

            @Override // qj.a.f
            public void c(int i10, String str) {
                d.this.f35187s = i10;
                d.this.f35188t = str;
                d.this.N0();
            }
        }

        c() {
        }

        /* renamed from: b */
        public void a(SoundProto.SoundConvertResultResp soundConvertResultResp) {
            com.mobvoi.android.common.utils.k.a("FullTextFragment", soundConvertResultResp.toString());
            d.this.f35184p = soundConvertResultResp;
            d.this.f35174f.f33533d.setVisibility(8);
            if (soundConvertResultResp.getPercentage() == 100.0f) {
                d.this.f35174f.f33532c.f33601b.setEnabled(true);
                d.this.f35174f.f33534e.setVisibility(0);
                d dVar = d.this;
                dVar.f35176h = new qj.a(dVar.requireActivity(), soundConvertResultResp.getDataList(), d.this.f35177i.getFlagsList(), true);
                d.this.f35176h.l(d.this.f35181m, d.this.f35182n);
                d.this.f35176h.k(new a());
                d.this.f35174f.f33534e.setAdapter(d.this.f35176h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullTextFragment.java */
    /* renamed from: tj.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0509d implements x<String> {
        C0509d() {
        }

        /* renamed from: b */
        public void a(String str) {
            com.mobvoi.android.common.utils.k.a("FullTextFragment", "onChanged: " + str);
            qj.a aVar = d.this.f35176h;
            d dVar = d.this;
            aVar.m(dVar.B0(dVar.f35179k));
            if (d.this.f35178j != null) {
                h hVar = d.this.f35178j;
                ArrayList arrayList = d.this.f35180l;
                d dVar2 = d.this;
                hVar.b(arrayList, dVar2.C0(dVar2.f35180l, d.this.f35184p));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullTextFragment.java */
    /* loaded from: classes2.dex */
    public class e implements x<String> {
        e() {
        }

        /* renamed from: b */
        public void a(String str) {
            com.mobvoi.android.common.utils.k.a("FullTextFragment", "onChanged: " + str);
            if (d.this.f35176h != null) {
                d.this.f35176h.e(d.this.f35189u, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullTextFragment.java */
    /* loaded from: classes2.dex */
    public class f implements x<Pair<String, String>> {
        f() {
        }

        /* renamed from: b */
        public void a(Pair<String, String> pair) {
            if (d.this.f35176h != null) {
                d.this.f35176h.f((String) pair.first, (String) pair.second);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullTextFragment.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35198a;

        static {
            int[] iArr = new int[SoundProto.FileStatus.values().length];
            f35198a = iArr;
            try {
                iArr[SoundProto.FileStatus.CONVERT_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35198a[SoundProto.FileStatus.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35198a[SoundProto.FileStatus.CONVERTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: FullTextFragment.java */
    /* loaded from: classes2.dex */
    public interface h {
        void a(int i10);

        void b(List<Integer> list, List<SoundProto.ConvertData> list2);

        void c();
    }

    public d(NavController navController) {
        this.f35190v = navController;
    }

    private void A0() {
        this.f35175g.r().i(requireActivity(), new b());
        this.f35175g.F().i(requireActivity(), new c());
        this.f35175g.s().i(requireActivity(), new C0509d());
        this.f35175g.x().i(requireActivity(), new e());
        this.f35175g.t().i(requireActivity(), new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B0(int i10) {
        if (this.f35184p.getDataList() == null || this.f35184p.getDataList().size() <= 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f35184p.getDataList().size(); i12++) {
            SoundProto.ConvertData convertData = this.f35184p.getDataList().get(i12);
            if (convertData != null) {
                if (i10 > convertData.getOffset() + convertData.getDuration()) {
                    i11 = convertData.getOffset();
                } else if (i10 <= convertData.getOffset() + convertData.getDuration()) {
                    return convertData.getOffset();
                } else {
                    if (i10 == convertData.getOffset()) {
                        return convertData.getOffset();
                    }
                }
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SoundProto.ConvertData> C0(List<Integer> list, SoundProto.SoundConvertResultResp soundConvertResultResp) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i10 < list.size() && i11 < soundConvertResultResp.getDataList().size()) {
            SoundProto.ConvertData convertData = soundConvertResultResp.getDataList().get(i11);
            int intValue = list.get(i10).intValue();
            if (intValue > convertData.getOffset() + convertData.getDuration()) {
                i11++;
            } else if (intValue >= convertData.getOffset()) {
                i10++;
                i11++;
                arrayList.add(convertData);
            } else {
                i10++;
            }
        }
        return arrayList;
    }

    private int D0(int i10) {
        if (this.f35184p.getDataList().size() <= 0) {
            return -1;
        }
        int i11 = 0;
        while (i11 < this.f35184p.getDataList().size()) {
            SoundProto.ConvertData convertData = this.f35184p.getDataList().get(i11);
            if (i10 > convertData.getOffset() + convertData.getDuration()) {
                i11++;
            } else if ((i10 < convertData.getOffset() || i10 >= convertData.getOffset() + convertData.getDuration()) && i10 >= convertData.getOffset()) {
                return -1;
            } else {
                return i11;
            }
        }
        return -1;
    }

    private void E0() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f35180l = arrayList;
        SoundProto.SoundFile soundFile = this.f35177i;
        if (soundFile != null) {
            arrayList.addAll(soundFile.getFlagsList());
        }
        this.f35174f.f33531b.setOnClickListener(new a());
        this.f35174f.f33532c.f33601b.setOnClickListener(this);
        this.f35174f.f33532c.f33602c.setOnClickListener(this);
        int i10 = g.f35198a[this.f35177i.getFileStatus().ordinal()];
        if (i10 == 1 || i10 == 2) {
            this.f35174f.f33533d.setVisibility(0);
            this.f35174f.f33534e.setVisibility(8);
            this.f35174f.f33532c.f33601b.setEnabled(false);
        } else if (i10 != 3) {
            this.f35174f.f33533d.setVisibility(8);
            this.f35174f.f33534e.setVisibility(0);
            this.f35174f.f33532c.f33601b.setEnabled(true);
        } else {
            this.f35174f.f33534e.setVisibility(8);
            this.f35174f.f33533d.setVisibility(8);
            this.f35174f.f33532c.f33601b.setEnabled(false);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        linearLayoutManager.B2(1);
        this.f35174f.f33534e.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(int i10, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f35175g.I(this.f35177i.getFileId(), i10, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(String str) {
        this.f35175g.N(this.f35177i.getFileId(), this.f35187s, this.f35188t, str);
        this.f35185q.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(int i10, View view) {
        this.f35175g.I(this.f35177i.getFileId(), i10, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(final int i10, String str) {
        sj.g gVar = new sj.g();
        gVar.E0(new g.e() { // from class: tj.b
            @Override // sj.g.e
            public final void a(String str2) {
                d.this.F0(i10, str2);
            }
        });
        gVar.D0(i10, this.f35177i);
        gVar.C0(str);
        gVar.p0(getFragmentManager(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        j a10 = new j.b(requireActivity()).f(k.Q).d(this.f35188t).c(k.f20658b).b(k.f20657a).e(new j.c() { // from class: tj.c
            @Override // sj.j.c
            public final void a(String str) {
                d.this.G0(str);
            }
        }).a();
        this.f35185q = a10;
        a10.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(final int i10) {
        sj.c a10 = new c.b(getContext()).f(k.f20670n).d(k.f20671o).c(k.f20658b).b(k.f20657a).e(new View.OnClickListener() { // from class: tj.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.H0(i10, view);
            }
        }).a();
        this.f35186r = a10;
        a10.show();
    }

    public void I0(List<Integer> list) {
        if (this.f35176h != null) {
            this.f35180l.clear();
            this.f35180l.addAll(list);
            this.f35176h.j(list);
        }
    }

    public void J0(int i10) {
        if (this.f35184p != null && this.f35177i.getFileStatus() == SoundProto.FileStatus.CONVERTED && this.f35183o != D0(i10) && this.f35174f.f33534e != null) {
            int D0 = D0(i10);
            this.f35183o = D0;
            this.f35176h.g(D0);
            this.f35174f.f33534e.o1(this.f35183o);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f35174f.f33534e.getLayoutManager();
            if (linearLayoutManager != null) {
                linearLayoutManager.A2(this.f35183o, 0);
            }
        }
    }

    public void K0(h hVar) {
        this.f35178j = hVar;
    }

    public void L0(int[] iArr, List<String> list) {
        this.f35181m = iArr;
        this.f35182n = list;
        qj.a aVar = this.f35176h;
        if (aVar != null) {
            aVar.l(iArr, list);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 301 && i11 == 200) {
            this.f35175g.A(this.f35177i.getFileId());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.mobvoi.record.h.C) {
            int currentPosition = com.mobvoi.record.utils.a.b().c().getCurrentPosition();
            this.f35179k = currentPosition;
            int B0 = B0(currentPosition);
            if (!this.f35180l.contains(Integer.valueOf(B0))) {
                this.f35180l.add(Integer.valueOf(B0));
                Collections.sort(this.f35180l);
                Log.d("FullTextFragment", "onClick: " + this.f35180l.toString());
                this.f35175g.n(SoundProto.SoundFile.newBuilder().setDeviceId(this.f35177i.getDeviceId()).setFileId(this.f35177i.getFileId()).setFileName(this.f35177i.getFileName()).setFileUrl(this.f35177i.getFileUrl()).setFileSize(this.f35177i.getFileSize()).setDuration(this.f35177i.getDuration()).setTimestamp(this.f35177i.getTimestamp()).setSpeakerNum(this.f35177i.getSpeakerNum()).addAllFlags(this.f35180l).setFileStatus(SoundProto.FileStatus.CONVERTED).setDeviceType(this.f35177i.getDeviceType()).setPercentage(this.f35177i.getPercentage()).setFirstParagraph(this.f35177i.getFirstParagraph()).addAllKeywords(this.f35177i.getKeywordsList()).build(), false);
            }
        } else if (view.getId() == com.mobvoi.record.h.I) {
            h hVar = this.f35178j;
            if (hVar != null) {
                hVar.c();
            }
        } else if (view.getId() == com.mobvoi.record.h.f20608n) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("soundFile", this.f35177i);
            this.f35190v.p(com.mobvoi.record.h.f20580c, bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f35174f = rj.b.d(layoutInflater, viewGroup, false);
        this.f35175g = (RecordViewModel) new h0(this).a(RecordViewModel.class);
        if (getArguments() != null) {
            this.f35177i = (SoundProto.SoundFile) getArguments().getSerializable("soundFile");
        }
        E0();
        A0();
        this.f35175g.A(this.f35177i.getFileId());
        this.f35175g.q();
        return this.f35174f.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        j jVar = this.f35185q;
        if (jVar != null && jVar.isShowing()) {
            this.f35185q.dismiss();
        }
        sj.c cVar = this.f35186r;
        if (cVar != null && cVar.isShowing()) {
            this.f35186r.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f35178j = null;
    }
}
