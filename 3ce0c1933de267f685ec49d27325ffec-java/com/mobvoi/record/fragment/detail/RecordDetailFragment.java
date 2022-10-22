package com.mobvoi.record.fragment.detail;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.protobuf.n0;
import com.mobvoi.companion.proto.ConstantProto;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.RecordViewModel;
import com.mobvoi.record.fragment.detail.RecordDetailFragment;
import com.mobvoi.record.utils.a;
import com.mobvoi.record.view.audiowave.AudioWaveView;
import com.mobvoi.wear.contacts.ContactConstant;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import qj.b;
import sj.c;
import sj.d;
import sj.j;
import tj.d;
/* loaded from: classes2.dex */
public class RecordDetailFragment extends com.mobvoi.record.fragment.detail.a implements a.b {
    private sj.c A;

    /* renamed from: f */
    private rj.d f20438f;

    /* renamed from: g */
    private sj.d f20439g;

    /* renamed from: h */
    RecordViewModel f20440h;

    /* renamed from: i */
    ho.a<NavController> f20441i;

    /* renamed from: l */
    private SoundProto.SoundFile f20444l;

    /* renamed from: n */
    private Snackbar f20446n;

    /* renamed from: p */
    private int[] f20448p;

    /* renamed from: q */
    private qj.b f20449q;

    /* renamed from: r */
    private Fragment f20450r;

    /* renamed from: s */
    private tj.d f20451s;

    /* renamed from: t */
    private tj.g f20452t;

    /* renamed from: u */
    private String f20453u;

    /* renamed from: v */
    private SoundProto.FileStatus f20454v;

    /* renamed from: w */
    private String[] f20455w;

    /* renamed from: x */
    private boolean f20456x;

    /* renamed from: y */
    private AlertDialog f20457y;

    /* renamed from: z */
    private sj.j f20458z;

    /* renamed from: j */
    private final List<Integer> f20442j = new ArrayList();

    /* renamed from: k */
    private final List<String> f20443k = new ArrayList();

    /* renamed from: m */
    private ExecutorService f20445m = Executors.newSingleThreadExecutor();

    /* renamed from: o */
    private final StringBuilder f20447o = new StringBuilder();
    private final Runnable B = new j();
    private final Handler C = new l(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public class a implements Toolbar.f {
        a() {
            RecordDetailFragment.this = r1;
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() == com.mobvoi.record.h.f20574a) {
                RecordDetailFragment.this.f20439g.show();
            } else if (menuItem.getItemId() == com.mobvoi.record.h.f20592g) {
                Intent intent = new Intent("com.mobvoi.action.RECORDER_SHARE");
                intent.setPackage(RecordDetailFragment.this.requireActivity().getPackageName());
                intent.putExtra("id", RecordDetailFragment.this.f20444l.getFileId());
                intent.putExtra("text", RecordDetailFragment.this.f20447o.toString());
                intent.putExtra("url", RecordDetailFragment.this.f20444l.getFileUrl());
                intent.putExtra(ContactConstant.CallsRecordKeys.NAME, RecordDetailFragment.this.f20444l.getFileName());
                intent.putExtra("converted", RecordDetailFragment.this.f20454v == SoundProto.FileStatus.CONVERTED);
                RecordDetailFragment.this.startActivity(intent);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.h {
        b() {
            RecordDetailFragment.this = r1;
        }

        public /* synthetic */ void e(int i10) {
            RecordDetailFragment.this.f20438f.f33557c.e(RecordDetailFragment.this.f20438f.f33560f);
            RecordDetailFragment.this.f20451s.J0(i10);
            RecordDetailFragment.this.f20438f.f33556b.setProgress(i10);
            com.mobvoi.record.utils.a.b().c().seekTo(i10);
        }

        @Override // tj.d.h
        public void a(int i10) {
            com.mobvoi.record.utils.a.b().c().seekTo(i10);
            RecordDetailFragment.this.f1();
            if (RecordDetailFragment.this.f20451s != null) {
                RecordDetailFragment.this.f20451s.J0(i10);
            }
        }

        @Override // tj.d.h
        public void b(List<Integer> list, List<SoundProto.ConvertData> list2) {
            RecordDetailFragment.this.f20442j.clear();
            RecordDetailFragment.this.f20442j.addAll(list);
            if (RecordDetailFragment.this.f20449q == null) {
                RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
                recordDetailFragment.f20449q = new qj.b(recordDetailFragment.requireActivity(), list2);
                RecordDetailFragment.this.f20438f.f33562h.setAdapter(RecordDetailFragment.this.f20449q);
                RecordDetailFragment.this.f20449q.h(new b.c() { // from class: com.mobvoi.record.fragment.detail.e
                    @Override // qj.b.c
                    public final void a(int i10) {
                        RecordDetailFragment.b.this.e(i10);
                    }
                });
            } else {
                RecordDetailFragment.this.f20449q.g(list2);
            }
            RecordDetailFragment.this.f20438f.f33567m.setText(RecordDetailFragment.this.getResources().getString(com.mobvoi.record.k.f20673q, Integer.valueOf(RecordDetailFragment.this.f20449q.getItemCount())));
        }

        @Override // tj.d.h
        public void c() {
            if (RecordDetailFragment.this.f20438f.f33557c.B(RecordDetailFragment.this.f20438f.f33560f)) {
                RecordDetailFragment.this.f20438f.f33557c.e(RecordDetailFragment.this.f20438f.f33560f);
            } else {
                RecordDetailFragment.this.f20438f.f33557c.J(RecordDetailFragment.this.f20438f.f33560f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
            RecordDetailFragment.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordDetailFragment.this.f20438f.f33568n.setSelected(true);
            RecordDetailFragment.this.f20438f.f33571q.setSelected(false);
            if (RecordDetailFragment.this.f20451s != null) {
                RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
                recordDetailFragment.e1(recordDetailFragment.f20451s, RecordDetailFragment.this.f20444l);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
            RecordDetailFragment.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordDetailFragment.this.f20438f.f33571q.setSelected(true);
            RecordDetailFragment.this.f20438f.f33568n.setSelected(false);
            if (RecordDetailFragment.this.f20452t != null) {
                RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
                recordDetailFragment.e1(recordDetailFragment.f20452t, RecordDetailFragment.this.f20444l);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements AudioWaveView.a {
        e() {
            RecordDetailFragment.this = r1;
        }

        @Override // com.mobvoi.record.view.audiowave.AudioWaveView.a
        public void e(int i10) {
            if (RecordDetailFragment.this.f20451s != null) {
                try {
                    int duration = (com.mobvoi.record.utils.a.b().c().getDuration() * i10) / 100;
                    com.mobvoi.record.utils.a.b().c().seekTo(duration);
                    RecordDetailFragment.this.f20451s.J0(duration);
                } catch (Exception unused) {
                    com.mobvoi.android.common.utils.k.a("RecordDetailFragment", "mediaPlayer getDuration in wrong state.");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
            RecordDetailFragment.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordDetailFragment.this.f20456x) {
                com.mobvoi.record.utils.a.b().c().pause();
                RecordDetailFragment.this.f20438f.f33559e.setImageResource(com.mobvoi.record.g.f20572i);
                RecordDetailFragment.this.f20456x = false;
                RecordDetailFragment.this.C.removeCallbacksAndMessages(null);
                return;
            }
            RecordDetailFragment.this.C.sendEmptyMessageDelayed(1, 500L);
            com.mobvoi.record.utils.a.b().c().start();
            RecordDetailFragment.this.f20438f.f33559e.setImageResource(com.mobvoi.record.g.f20571h);
            RecordDetailFragment.this.f20456x = true;
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ qj.c f20465a;

        /* renamed from: b */
        final /* synthetic */ EditText f20466b;

        g(qj.c cVar, EditText editText) {
            RecordDetailFragment.this = r1;
            this.f20465a = cVar;
            this.f20466b = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<String> b10 = this.f20465a.b();
            String trim = this.f20466b.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                b10.add(trim);
            }
            if (b10.size() > 10) {
                aa.c.d(RecordDetailFragment.this.getString(com.mobvoi.record.k.S));
            } else {
                RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
                recordDetailFragment.f20440h.L(recordDetailFragment.f20444l.getFileId(), (String[]) b10.toArray(new String[b10.size()]));
            }
            RecordDetailFragment.this.P0();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
            RecordDetailFragment.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordDetailFragment.this.P0();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ TextView f20469a;

        i(TextView textView) {
            RecordDetailFragment.this = r1;
            this.f20469a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String charSequence = this.f20469a.getText().toString();
            if (RecordDetailFragment.this.f20443k.contains(charSequence)) {
                RecordDetailFragment.this.d1(charSequence);
            } else {
                RecordDetailFragment.this.M0(charSequence);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements Runnable {
        j() {
            RecordDetailFragment.this = r1;
        }

        public /* synthetic */ void c(byte[] bArr) {
            RecordDetailFragment.this.f20438f.f33556b.setRawData(bArr);
            RecordDetailFragment.this.f20451s.J0((RecordDetailFragment.this.f20438f.f33556b.getProgress() * com.mobvoi.record.utils.a.b().c().getDuration()) / 100);
            RecordDetailFragment.this.f20438f.f33563i.setRefreshing(false);
        }

        public /* synthetic */ void d() {
            if (RecordDetailFragment.this.f20446n == null) {
                RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
                recordDetailFragment.f20446n = Snackbar.Y(recordDetailFragment.f20438f.f33563i, RecordDetailFragment.this.getString(com.mobvoi.record.k.f20666j), 0).b0(androidx.core.content.b.c(RecordDetailFragment.this.requireContext(), com.mobvoi.record.e.f20410g));
            }
            RecordDetailFragment.this.f20446n.O();
            RecordDetailFragment.this.f20438f.f33563i.setRefreshing(false);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            final byte[] bArr;
            try {
                byte[] bArr2 = new byte[1024];
                InputStream openStream = new URL(RecordDetailFragment.this.f20444l.getFileUrl()).openStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openStream);
                File file = new File(com.mobvoi.android.common.utils.b.h(null).getAbsolutePath() + File.separator + "download.mp3");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    i10 = 0;
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr2, 0, read);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                openStream.close();
                if (file.exists() && RecordDetailFragment.this.f20444l != null) {
                    byte[] bytes = RecordDetailFragment.this.f20444l.getFileId().getBytes();
                    int length = (int) ((file.length() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / 3);
                    uj.a aVar = new uj.a();
                    byte[] bArr3 = aVar.f35463a;
                    if (length > bArr3.length) {
                        while (true) {
                            byte[] bArr4 = aVar.f35463a;
                            if (i10 >= length / bArr4.length) {
                                break;
                            }
                            bArr3 = RecordDetailFragment.O0(bArr3, bArr4);
                            i10++;
                        }
                        bArr = Arrays.copyOfRange(bArr3, (int) bytes[1], length + bytes[1]);
                    } else {
                        bArr = Arrays.copyOfRange(bArr3, (int) bytes[1], length + bytes[1]);
                    }
                    RecordDetailFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.mobvoi.record.fragment.detail.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            RecordDetailFragment.j.this.c(bArr);
                        }
                    });
                    if (file.delete()) {
                        com.mobvoi.android.common.utils.k.a("RecordDetailFragment", "删除mp3文件");
                    }
                }
            } catch (Exception e10) {
                RecordDetailFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.mobvoi.record.fragment.detail.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecordDetailFragment.j.this.d();
                    }
                });
                com.mobvoi.android.common.utils.k.e("RecordDetailFragment", "audio file download error", e10);
                e10.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements x<String> {
        k() {
            RecordDetailFragment.this = r1;
        }

        /* renamed from: b */
        public void a(String str) {
            RecordDetailFragment.this.f20441i.get().u();
        }
    }

    /* loaded from: classes2.dex */
    class l extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Looper looper) {
            super(looper);
            RecordDetailFragment.this = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    if (com.mobvoi.record.utils.a.b().c().isPlaying()) {
                        int currentPosition = com.mobvoi.record.utils.a.b().c().getCurrentPosition();
                        RecordDetailFragment.this.f1();
                        if (RecordDetailFragment.this.f20451s != null) {
                            RecordDetailFragment.this.f20451s.J0(currentPosition);
                        }
                        sendEmptyMessageDelayed(1, 500L);
                    }
                } catch (Exception unused) {
                    com.mobvoi.android.common.utils.k.a("RecordDetailFragment", "mediaPlayer getDuration in wrong state.");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class m {

        /* renamed from: a */
        static final /* synthetic */ int[] f20474a;

        static {
            int[] iArr = new int[SoundProto.FileStatus.values().length];
            f20474a = iArr;
            try {
                iArr[SoundProto.FileStatus.CONVERT_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20474a[SoundProto.FileStatus.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20474a[SoundProto.FileStatus.CONVERTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements x<SoundProto.SoundConvertResultResp> {
        n() {
            RecordDetailFragment.this = r1;
        }

        public /* synthetic */ void c(int i10) {
            RecordDetailFragment.this.f20438f.f33557c.e(RecordDetailFragment.this.f20438f.f33560f);
            RecordDetailFragment.this.f20451s.J0(i10);
            com.mobvoi.record.utils.a.b().c().seekTo(i10);
            RecordDetailFragment.this.f1();
        }

        /* renamed from: d */
        public void a(SoundProto.SoundConvertResultResp soundConvertResultResp) {
            com.mobvoi.android.common.utils.k.c("RecordDetailFragment", "soundConvertResult: %s", soundConvertResultResp.toString());
            RecordDetailFragment.this.f20438f.f33569o.setText(RecordDetailFragment.this.getResources().getString(com.mobvoi.record.k.f20661e, soundConvertResultResp.getPercentage() + "%"));
            if (soundConvertResultResp.getPercentage() == 100.0f) {
                for (int i10 = 0; i10 < soundConvertResultResp.getDataList().size(); i10++) {
                    RecordDetailFragment.this.f20447o.append(soundConvertResultResp.getDataList().get(i10).getText());
                }
                RecordDetailFragment.this.f20438f.f33558d.setVisibility(0);
                RecordDetailFragment.this.f20438f.f33569o.setVisibility(8);
                RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
                androidx.fragment.app.f requireActivity = recordDetailFragment.requireActivity();
                RecordDetailFragment recordDetailFragment2 = RecordDetailFragment.this;
                recordDetailFragment.f20449q = new qj.b(requireActivity, recordDetailFragment2.T0(recordDetailFragment2.f20444l.getFlagsList(), soundConvertResultResp));
                RecordDetailFragment.this.f20449q.h(new b.c() { // from class: com.mobvoi.record.fragment.detail.h
                    @Override // qj.b.c
                    public final void a(int i11) {
                        RecordDetailFragment.n.this.c(i11);
                    }
                });
                RecordDetailFragment.this.f20438f.f33562h.setAdapter(RecordDetailFragment.this.f20449q);
                RecordDetailFragment.this.f20438f.f33567m.setText(RecordDetailFragment.this.getResources().getString(com.mobvoi.record.k.f20673q, Integer.valueOf(RecordDetailFragment.this.f20449q.getItemCount())));
                RecordDetailFragment.this.f20439g.a(true);
                RecordDetailFragment.this.f20454v = SoundProto.FileStatus.CONVERTED;
                return;
            }
            RecordDetailFragment.this.f20438f.f33558d.setVisibility(8);
            RecordDetailFragment.this.f20438f.f33569o.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public class o implements x<String> {
        o() {
            RecordDetailFragment.this = r1;
        }

        /* renamed from: b */
        public void a(String str) {
            RecordDetailFragment.this.f20438f.f33566l.setText(RecordDetailFragment.this.f20453u);
        }
    }

    /* loaded from: classes2.dex */
    public class p implements x<String> {
        p() {
            RecordDetailFragment.this = r1;
        }

        /* renamed from: b */
        public void a(String str) {
            com.mobvoi.android.common.utils.k.a("RecordDetailFragment", "onChanged: " + str);
            RecordDetailFragment.this.b1();
        }
    }

    /* loaded from: classes2.dex */
    public class q implements x<String> {
        q() {
            RecordDetailFragment.this = r1;
        }

        /* renamed from: b */
        public void a(String str) {
            RecordDetailFragment.this.f20451s.I0(RecordDetailFragment.this.f20442j);
            RecordDetailFragment.this.b1();
        }
    }

    /* loaded from: classes2.dex */
    public class r implements x<String[]> {
        r() {
            RecordDetailFragment.this = r1;
        }

        /* renamed from: b */
        public void a(String[] strArr) {
            RecordDetailFragment.this.f20455w = strArr;
            HashSet hashSet = new HashSet(Arrays.asList(strArr));
            for (String str : RecordDetailFragment.this.f20443k) {
                if (!hashSet.contains(str)) {
                    RecordDetailFragment.this.f20443k.remove(str);
                }
            }
            RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
            recordDetailFragment.L0(recordDetailFragment.requireActivity(), strArr, RecordDetailFragment.this.f20438f.f33561g);
        }
    }

    /* loaded from: classes2.dex */
    public class s implements j.c {
        s() {
            RecordDetailFragment.this = r1;
        }

        @Override // sj.j.c
        public void a(String str) {
            RecordDetailFragment.this.f20453u = str;
            RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
            recordDetailFragment.f20440h.M(recordDetailFragment.f20444l.getFileId(), RecordDetailFragment.this.f20453u);
        }
    }

    /* loaded from: classes2.dex */
    public class t implements View.OnClickListener {
        t() {
            RecordDetailFragment.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordDetailFragment recordDetailFragment = RecordDetailFragment.this;
            recordDetailFragment.f20440h.p(recordDetailFragment.f20444l.getFileId());
        }
    }

    /* loaded from: classes2.dex */
    public class u implements d.a {
        u() {
            RecordDetailFragment.this = r1;
        }

        @Override // sj.d.a
        public void a() {
            RecordDetailFragment.this.A.show();
        }

        @Override // sj.d.a
        public void b() {
            ((ClipboardManager) RecordDetailFragment.this.requireActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", RecordDetailFragment.this.f20447o.toString()));
            Toast.makeText(RecordDetailFragment.this.requireActivity(), RecordDetailFragment.this.getString(com.mobvoi.record.k.f20665i), 1).show();
        }

        @Override // sj.d.a
        public void c() {
            RecordDetailFragment.this.f20458z.show();
            RecordDetailFragment.this.f20458z.j(RecordDetailFragment.this.f20453u);
        }

        @Override // sj.d.a
        public void d() {
            Bundle bundle = new Bundle();
            bundle.putSerializable("soundFile", RecordDetailFragment.this.f20444l);
            RecordDetailFragment.this.f20441i.get().p(com.mobvoi.record.h.f20580c, bundle);
        }
    }

    private void J0() {
        this.f20440h.B().i(requireActivity(), new k());
        this.f20440h.F().i(requireActivity(), new n());
        this.f20440h.E().i(requireActivity(), new o());
        this.f20440h.s().i(requireActivity(), new p());
        this.f20440h.v().i(requireActivity(), new q());
        this.f20440h.w().i(requireActivity(), new r());
    }

    private void K0(Context context, n0 n0Var, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        for (int i10 = 0; i10 < n0Var.size(); i10++) {
            linearLayout.addView(V0(context, n0Var.get(i10), i10));
        }
        TextView V0 = V0(context, "+", n0Var.size());
        V0.setOnClickListener(new com.mobvoi.record.fragment.detail.c(this));
        linearLayout.addView(V0);
    }

    public void L0(Context context, String[] strArr, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        for (int i10 = 0; i10 < strArr.length; i10++) {
            linearLayout.addView(V0(context, strArr[i10], i10));
        }
        TextView V0 = V0(context, "+", strArr.length);
        V0.setOnClickListener(new com.mobvoi.record.fragment.detail.c(this));
        linearLayout.addView(V0);
    }

    public void M0(String str) {
        this.f20443k.add(str);
        c1();
    }

    private void N0() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.f20443k.size(); i10++) {
            sb2.append(this.f20443k.get(i10));
            if (i10 < this.f20443k.size() - 1) {
                sb2.append(',');
            }
        }
        String sb3 = sb2.toString();
        com.mobvoi.android.common.utils.k.c("RecordDetailFragment", "changeTags res is %s", sb3);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("tag_preferences", 0);
        if (TextUtils.isEmpty(sb3)) {
            sharedPreferences.edit().remove(this.f20444l.getFileId()).apply();
        } else {
            sharedPreferences.edit().putString(this.f20444l.getFileId(), sb3).apply();
        }
    }

    public static byte[] O0(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public void P0() {
        AlertDialog alertDialog = this.f20457y;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f20457y.dismiss();
        }
    }

    private void Q0() {
        if (this.f20445m.isShutdown()) {
            this.f20445m = Executors.newSingleThreadExecutor();
        }
        this.f20445m.submit(this.B);
    }

    private void R0() {
        String string = requireActivity().getSharedPreferences("tag_preferences", 0).getString(this.f20444l.getFileId(), "");
        com.mobvoi.android.common.utils.k.c("RecordDetailFragment", "fetchTags labels is %s", string);
        if (!TextUtils.isEmpty(string)) {
            this.f20443k.addAll(Arrays.asList(string.split(",")));
        }
    }

    private int S0(String str) {
        if (this.f20443k.contains(str)) {
            return this.f20448p[this.f20443k.indexOf(str)];
        }
        return getResources().getColor(com.mobvoi.record.e.f20405b);
    }

    public List<SoundProto.ConvertData> T0(List<Integer> list, SoundProto.SoundConvertResultResp soundConvertResultResp) {
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

    private List<String> U0() {
        LinkedList linkedList = new LinkedList();
        String[] strArr = this.f20455w;
        if (strArr == null) {
            int keywordsCount = this.f20444l.getKeywordsCount();
            for (int i10 = 0; i10 < keywordsCount; i10++) {
                linkedList.add(this.f20444l.getKeywords(i10));
            }
        } else {
            linkedList.addAll(Arrays.asList(strArr));
        }
        return linkedList;
    }

    private TextView V0(Context context, String str, int i10) {
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int b10 = aa.d.b(8.0f, context);
        int b11 = aa.d.b(2.0f, context);
        if (i10 > 0) {
            layoutParams.setMargins(b10, 0, 0, 0);
        }
        textView.setText(str);
        textView.setTextSize(2, 12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(getResources().getDimension(com.mobvoi.record.f.f20411a));
        gradientDrawable.setColor(S0(str));
        textView.setBackground(gradientDrawable);
        textView.setPadding(b10, b11, b10, b11);
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new i(textView));
        return textView;
    }

    private void W0() {
        j.b f10 = new j.b(requireActivity()).f(com.mobvoi.record.k.f20672p);
        int i10 = com.mobvoi.record.k.f20658b;
        j.b c10 = f10.c(i10);
        int i11 = com.mobvoi.record.k.f20657a;
        this.f20458z = c10.b(i11).e(new s()).a();
        this.A = new c.b(requireActivity()).f(com.mobvoi.record.k.f20669m).d(com.mobvoi.record.k.f20668l).c(i10).b(i11).e(new t()).a();
        this.f20439g = new sj.d(requireActivity(), new u());
    }

    private void X0() {
        this.f20438f.f33572r.setText(com.mobvoi.record.k.f20667k);
        this.f20438f.f33564j.setNavigationIcon(com.mobvoi.record.g.f20564a);
        this.f20438f.f33564j.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.record.fragment.detail.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordDetailFragment.this.Y0(view);
            }
        });
        this.f20438f.f33564j.setOnMenuItemClickListener(new a());
        R0();
        this.f20453u = this.f20444l.getFileName();
        this.f20438f.f33566l.setText(this.f20444l.getFileName());
        this.f20442j.addAll(this.f20444l.getFlagsList());
        if (this.f20444l.getDeviceType() == ConstantProto.DeviceType.TIC_MEET) {
            this.f20438f.f33570p.setText(String.format(getString(com.mobvoi.record.k.N), getString(com.mobvoi.record.k.O)));
        } else if (this.f20444l.getDeviceType() == ConstantProto.DeviceType.TIC_WATCH) {
            this.f20438f.f33570p.setText(String.format(getString(com.mobvoi.record.k.N), getString(com.mobvoi.record.k.P)));
        }
        this.f20438f.f33565k.setText(com.mobvoi.record.utils.d.d(this.f20444l.getTimestamp()));
        K0(requireActivity(), this.f20444l.getKeywordsList(), this.f20438f.f33561g);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.B2(1);
        this.f20438f.f33562h.setLayoutManager(linearLayoutManager);
        com.mobvoi.android.common.utils.k.c("RecordDetailFragment", "fileStatus = %s", this.f20444l.getFileStatus());
        int i10 = m.f20474a[this.f20444l.getFileStatus().ordinal()];
        if (i10 == 1 || i10 == 2) {
            this.f20438f.f33558d.setVisibility(8);
            this.f20438f.f33569o.setVisibility(0);
            this.f20439g.a(false);
        } else if (i10 != 3) {
            this.f20438f.f33558d.setVisibility(0);
            this.f20438f.f33569o.setVisibility(8);
            this.f20440h.A(this.f20444l.getFileId());
            this.f20439g.a(true);
        } else {
            this.f20438f.f33558d.setVisibility(8);
            this.f20438f.f33569o.setVisibility(0);
            this.f20440h.A(this.f20444l.getFileId());
            this.f20439g.a(false);
        }
        tj.d dVar = new tj.d(this.f20441i.get());
        this.f20451s = dVar;
        dVar.K0(new b());
        this.f20452t = new tj.g();
        this.f20438f.f33568n.setSelected(true);
        e1(this.f20451s, this.f20444l);
        this.f20451s.L0(this.f20448p, this.f20443k);
        com.mobvoi.record.utils.a.b().e(this);
        com.mobvoi.record.utils.a.b().f(this.f20444l.getFileUrl());
        this.f20438f.f33568n.setOnClickListener(new c());
        this.f20438f.f33571q.setOnClickListener(new d());
        this.f20438f.f33556b.setCallback(new e());
        this.f20438f.f33559e.setOnClickListener(new f());
        this.f20438f.f33563i.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.mobvoi.record.fragment.detail.d
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void y() {
                RecordDetailFragment.this.Z0();
            }
        });
        this.f20438f.f33563i.setRefreshing(true);
        Q0();
    }

    public /* synthetic */ void Y0(View view) {
        this.f20441i.get().u();
    }

    public /* synthetic */ void Z0() {
        Snackbar snackbar = this.f20446n;
        if (snackbar != null) {
            snackbar.s();
        }
        Q0();
    }

    public void a1(View view) {
        P0();
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View inflate = getLayoutInflater().inflate(com.mobvoi.record.i.f20636c, (ViewGroup) null);
        qj.c cVar = new qj.c(U0());
        ((GridView) inflate.findViewById(com.mobvoi.record.h.M)).setAdapter((ListAdapter) cVar);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.f20457y = create;
        create.show();
        inflate.findViewById(com.mobvoi.record.h.f20604l).setOnClickListener(new g(cVar, (EditText) inflate.findViewById(com.mobvoi.record.h.L)));
        inflate.findViewById(com.mobvoi.record.h.f20602k).setOnClickListener(new h());
    }

    public void b1() {
        this.f20438f.f33567m.setText(getResources().getString(com.mobvoi.record.k.f20673q, Integer.valueOf(this.f20449q.getItemCount())));
    }

    private void c1() {
        tj.d dVar = this.f20451s;
        if (dVar != null) {
            dVar.L0(this.f20448p, this.f20443k);
        }
        if (this.f20455w != null) {
            L0(requireActivity(), this.f20455w, this.f20438f.f33561g);
        } else {
            K0(requireActivity(), this.f20444l.getKeywordsList(), this.f20438f.f33561g);
        }
        N0();
    }

    public void d1(String str) {
        this.f20443k.remove(str);
        c1();
    }

    public void e1(Fragment fragment, SoundProto.SoundFile soundFile) {
        w l10 = getChildFragmentManager().l();
        if (fragment.isAdded()) {
            l10.q(this.f20450r).z(fragment);
        } else if (this.f20450r == null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("soundFile", soundFile);
            fragment.setArguments(bundle);
            l10.b(com.mobvoi.record.h.f20630y, fragment).z(fragment);
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("soundFile", soundFile);
            fragment.setArguments(bundle2);
            l10.b(com.mobvoi.record.h.f20630y, fragment).q(this.f20450r).z(fragment);
        }
        this.f20450r = fragment;
        l10.j();
    }

    public void f1() {
        int currentPosition = com.mobvoi.record.utils.a.b().c().getCurrentPosition();
        int duration = com.mobvoi.record.utils.a.b().c().getDuration();
        if (duration > 0) {
            this.f20438f.f33556b.setProgress((currentPosition * 100) / duration);
        }
    }

    @Override // com.mobvoi.record.utils.a.b
    public void f() {
        com.mobvoi.record.utils.a.b().f(this.f20444l.getFileUrl());
        this.f20456x = false;
        this.f20438f.f33559e.setImageResource(com.mobvoi.record.g.f20572i);
        this.f20438f.f33556b.setProgress(0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20438f = rj.d.d(layoutInflater, viewGroup, false);
        this.f20440h = (RecordViewModel) new h0(this).a(RecordViewModel.class);
        this.f20448p = getResources().getIntArray(com.mobvoi.record.d.f20403a);
        if (getArguments() != null && getArguments().containsKey("soundFile")) {
            this.f20444l = (SoundProto.SoundFile) getArguments().getSerializable("soundFile");
        }
        W0();
        X0();
        J0();
        return this.f20438f.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f20444l = null;
        ExecutorService executorService = this.f20445m;
        if (executorService != null && !executorService.isShutdown()) {
            this.f20445m.shutdown();
        }
        sj.j jVar = this.f20458z;
        if (jVar != null && jVar.isShowing()) {
            this.f20458z.dismiss();
        }
        P0();
        this.C.removeCallbacksAndMessages(null);
        com.mobvoi.record.utils.a.b().e(null);
        com.mobvoi.record.utils.a.b().d();
    }
}
