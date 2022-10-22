package com.mobvoi.feedback;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.g;
import com.google.android.material.datepicker.h;
import com.google.android.material.timepicker.b;
import com.mobvoi.android.common.utils.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.feedback.FeedbackActivity;
import com.mobvoi.feedback.a;
import com.mobvoi.feedback.bean.FeedBackImageEntity;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.TelephonyUtil;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import ne.o;
import ne.s;
import ne.u;
import ne.w;
import ne.x;
import ne.y;
import oe.b;
import yp.g;
import z9.c;
/* loaded from: classes2.dex */
public class FeedbackActivity extends d implements View.OnClickListener, View.OnFocusChangeListener, a.AbstractC0212a {

    /* renamed from: w  reason: collision with root package name */
    private static final String[] f17863w = {"android.permission.READ_EXTERNAL_STORAGE"};

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<FeedBackImageEntity> f17864a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f17865b = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    private com.mobvoi.feedback.a f17866c;

    /* renamed from: d  reason: collision with root package name */
    private String f17867d;

    /* renamed from: e  reason: collision with root package name */
    private String f17868e;

    /* renamed from: f  reason: collision with root package name */
    private Dialog f17869f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f17870g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f17871h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f17872i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f17873j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f17874k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f17875l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f17876m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f17877n;

    /* renamed from: o  reason: collision with root package name */
    private EditText f17878o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f17879p;

    /* renamed from: q  reason: collision with root package name */
    private String f17880q;

    /* renamed from: r  reason: collision with root package name */
    private String f17881r;

    /* renamed from: s  reason: collision with root package name */
    private String f17882s;

    /* renamed from: t  reason: collision with root package name */
    private String f17883t;

    /* renamed from: u  reason: collision with root package name */
    private dq.b f17884u;

    /* renamed from: v  reason: collision with root package name */
    private c f17885v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements FileFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17886a;

        a(FeedbackActivity feedbackActivity, String str) {
            this.f17886a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file.isFile()) {
                if (!TextUtils.equals("crash_log_" + this.f17886a + ".log", file.getName())) {
                    if (TextUtils.equals(s.a().d() + this.f17886a + ".txt", file.getName())) {
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {
        private b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                FeedbackActivity.this.w0();
            }
            return true;
        }

        /* synthetic */ b(FeedbackActivity feedbackActivity, a aVar) {
            this();
        }
    }

    private void A0() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setTypeAndNormalize("image/*");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("android.provider.extra.INITIAL_URI", Uri.fromFile(getExternalFilesDir(Environment.DIRECTORY_SCREENSHOTS)));
        }
        startActivityForResult(intent, 0);
    }

    private void S(Map<String, byte[]> map) {
        File[] listFiles;
        File c10 = s.a().c(this);
        if (c10.exists() && (listFiles = c10.listFiles(new a(this, new SimpleDateFormat("yyMMdd", Locale.getDefault()).format(new Date())))) != null && listFiles.length > 0) {
            long j10 = 0;
            for (File file : listFiles) {
                j10 += file.length();
            }
            if (j10 < 5242880 || m.c(this)) {
                for (File file2 : listFiles) {
                    String Z = Z(map, file2.getName(), true);
                    byte[] V = V(file2);
                    if (V != null && V.length > 0) {
                        map.put(Z, V);
                    }
                }
            }
        }
    }

    private void T(Map<String, String> map) {
        Bundle extras;
        if (getIntent() != null && (extras = getIntent().getExtras()) != null && extras.containsKey("message_id")) {
            String string = extras.getString("message_id");
            String string2 = extras.getString("query");
            long j10 = extras.getLong("query_time", 0L);
            map.put("录音", "http://king-speech.mobvoi.com/api/speech.wav?msgid=" + string);
            map.put("asr结果", string2);
            map.put("onebox结果", "https://query-comment-server.mobvoi.com/api/get_message?msg_id=" + string);
            map.put("历史查询", "https://query-comment-server.mobvoi.com/api/get_context?user_id=" + this.f17880q + "&query_time=" + j10);
        }
    }

    private void U() {
        String trim = this.f17870g.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            Toast.makeText(this, y.f31214c, 0).show();
            return;
        }
        String trim2 = this.f17873j.getText().toString().trim();
        if (TextUtils.isEmpty(trim2) || o.a(trim2)) {
            String trim3 = this.f17874k.getText().toString().trim();
            if (TextUtils.isEmpty(trim3) || o.b(trim3)) {
                v0(trim, trim2, trim3, this.f17876m.getText().toString().trim(), this.f17875l.getText().toString().trim(), c0(), b0(), this.f17864a);
                return;
            }
            Toast.makeText(this, y.f31217f, 0).show();
            return;
        }
        Toast.makeText(this, y.f31216e, 0).show();
    }

    private byte[] V(File file) {
        try {
            File file2 = new File(file.getAbsolutePath() + ".gz");
            te.c.h(file, file2);
            byte[] g10 = te.c.g(file2);
            file2.delete();
            return g10;
        } catch (IOException e10) {
            k.e("FeedbackActivity", "Error compress file.", e10);
            return te.c.g(file);
        }
    }

    private Map<String, byte[]> W(ArrayList<FeedBackImageEntity> arrayList) {
        HashMap hashMap = new HashMap();
        Iterator<FeedBackImageEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            FeedBackImageEntity next = it.next();
            hashMap.put(Z(hashMap, next.f17896a, false), te.c.f(getContentResolver(), next));
        }
        S(hashMap);
        return hashMap;
    }

    private Map<String, String> X(String str, String str2, String str3, String str4, String str5, String str6) {
        Bundle bundleExtra;
        HashMap hashMap = new HashMap();
        hashMap.put(SharedWearInfoHelper.PhoneInfo.KEY_PHONE_MODEL, Build.MODEL);
        hashMap.put("fingerprint", Build.FINGERPRINT);
        hashMap.put("app_version", com.mobvoi.android.common.utils.b.c());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SharedWearInfoHelper.PhoneInfo.TABLE, str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("qq", str3);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(TelephonyUtil.KEY_SIM_ACTIVITIED_CHANNLE, str5);
        }
        if (!TextUtils.isEmpty(this.f17882s)) {
            hashMap.put("device_id", this.f17882s);
        }
        if (!TextUtils.isEmpty(this.f17883t)) {
            hashMap.put("device_version", this.f17883t);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("failure_time", str6);
        }
        if (!(getIntent() == null || (bundleExtra = getIntent().getBundleExtra("query_param")) == null || bundleExtra.size() <= 0)) {
            for (String str7 : bundleExtra.keySet()) {
                String valueOf = String.valueOf(bundleExtra.get(str7));
                if (!TextUtils.isEmpty(valueOf)) {
                    hashMap.put(str7, valueOf);
                }
            }
        }
        T(hashMap);
        return hashMap;
    }

    private z9.d Y(String[] strArr, int i10) {
        z9.d dVar = new z9.d();
        dVar.f37315a = i10;
        dVar.f37316b = strArr;
        return dVar;
    }

    private String Z(Map<String, byte[]> map, String str, boolean z10) {
        if (map.containsKey(str)) {
            str = str + System.currentTimeMillis();
        }
        if (!z10) {
            return str;
        }
        return str + ".zip";
    }

    private oe.b a0(Context context, String str) {
        return new oe.b(context.getPackageName(), com.mobvoi.android.common.utils.b.j().getAbsolutePath(), "ticwatch_log_", str, null);
    }

    private String b0() {
        return "";
    }

    private String c0() {
        return "其他";
    }

    private String d0() {
        if (s.a().f()) {
            return null;
        }
        return com.mobvoi.android.common.utils.a.a(com.mobvoi.android.common.utils.b.e().getSharedPreferences("account_info", 0).getString("key_phone", null), "mobvoi");
    }

    private void e0() {
        if (this.f17864a.size() > 0) {
            this.f17866c.f(this.f17864a);
            this.f17872i.setVisibility(0);
            this.f17871h.setVisibility(8);
            return;
        }
        this.f17872i.setVisibility(8);
        this.f17871h.setVisibility(0);
    }

    private void f0(Uri uri) {
        if (uri != null) {
            ArrayList<FeedBackImageEntity> arrayList = this.f17864a;
            arrayList.add(new FeedBackImageEntity(uri.getLastPathSegment() + ".jpg", uri));
        }
    }

    private void g0() {
        hideLoading();
        Toast.makeText(this, y.f31220i, 0).show();
        this.f17877n.setEnabled(true);
        s0();
    }

    private void h0(int i10) {
        hideLoading();
        Toast.makeText(this, y.f31221j, 0).show();
        t0(i10);
    }

    private void i0() {
        this.f17872i.setLayoutManager(new GridLayoutManager(this, 5));
        this.f17866c = new com.mobvoi.feedback.a(this, this.f17864a);
        this.f17872i.h(new se.b(getResources().getDimensionPixelSize(u.f31181c)));
        this.f17866c.e(this);
        this.f17872i.setAdapter(this.f17866c);
        e0();
    }

    private void initView() {
        this.f17870g = (EditText) findViewById(w.f31194i);
        LinearLayout linearLayout = (LinearLayout) findViewById(w.f31187b);
        this.f17871h = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f17872i = (RecyclerView) findViewById(w.f31186a);
        this.f17873j = (TextView) findViewById(w.f31196k);
        this.f17874k = (TextView) findViewById(w.f31197l);
        this.f17875l = (TextView) findViewById(w.f31203r);
        this.f17876m = (TextView) findViewById(w.f31198m);
        TextView textView = (TextView) findViewById(w.f31201p);
        this.f17877n = textView;
        textView.setOnClickListener(this);
        this.f17879p = (TextView) findViewById(w.f31195j);
        this.f17878o = (EditText) findViewById(w.f31202q);
        if (s.a().f()) {
            findViewById(w.f31204s).setVisibility(8);
            findViewById(w.f31192g).setVisibility(8);
            findViewById(w.f31199n).setVisibility(8);
            findViewById(w.f31191f).setVisibility(8);
        }
        i0();
        String d02 = d0();
        if (!TextUtils.isEmpty(d02) && o.b(d02)) {
            this.f17874k.setText(d02);
        }
        this.f17878o.setOnTouchListener(new b(this, null));
    }

    private void j0() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                this.f17865b.putAll(extras);
            }
            Bundle bundleExtra = intent.getBundleExtra("query_param");
            if (bundleExtra != null) {
                this.f17865b.putAll(bundleExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer k0(String str, String str2, String str3, String str4, String str5, String str6, String str7, ArrayList arrayList, ArrayList arrayList2) {
        return Integer.valueOf(te.a.d(this.f17880q, e.e(com.mobvoi.android.common.utils.b.e()), this.f17881r, str, str2, X(str3, str4, str5, str6, str7, this.f17878o.getText().toString()), W(arrayList)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Integer num) {
        k.c("FeedbackActivity", "onNext id = %s", num);
        if (num.intValue() == -1) {
            g0();
        } else {
            h0(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Throwable th2) {
        k.e("FeedbackActivity", "error post feed back.", th2);
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(Long l10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l10.longValue());
        z0(calendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(DialogInterface dialogInterface, int i10) {
        z9.e.e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(Calendar calendar, com.google.android.material.timepicker.b bVar, View view) {
        calendar.set(11, bVar.z0());
        calendar.set(12, bVar.A0());
        this.f17878o.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault()).format(new Date(calendar.getTimeInMillis())));
    }

    private void u0() {
        String[] strArr = f17863w;
        boolean d10 = z9.e.d(this, strArr);
        k.c("FeedbackActivity", "hasReadPermission : %s", Boolean.valueOf(d10));
        if (d10) {
            A0();
        } else if (z9.e.g(this, strArr[0])) {
            z9.e.f(this, Y(strArr, 162));
        } else {
            z9.e.f(this, Y(strArr, 161));
        }
    }

    private void v0(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final ArrayList<FeedBackImageEntity> arrayList) {
        this.f17877n.setEnabled(false);
        showLoading(getString(y.f31222k));
        this.f17884u.a(rx.c.A(arrayList).D(new g() { // from class: ne.j
            @Override // yp.g
            public final Object call(Object obj) {
                Integer k02;
                k02 = FeedbackActivity.this.k0(str6, str, str2, str3, str4, str5, str7, arrayList, (ArrayList) obj);
                return k02;
            }
        }).Z(re.a.a().b()).H(re.a.a().c()).Y(new yp.b() { // from class: ne.h
            @Override // yp.b
            public final void call(Object obj) {
                FeedbackActivity.this.l0((Integer) obj);
            }
        }, new yp.b() { // from class: ne.i
            @Override // yp.b
            public final void call(Object obj) {
                FeedbackActivity.this.m0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        com.google.android.material.datepicker.g<Long> a10 = g.e.c().g(y.f31218g).f(Long.valueOf(com.google.android.material.datepicker.g.L0())).e(new CalendarConstraints.b().b(Calendar.getInstance().getTimeInMillis()).a()).a();
        a10.y0(new h() { // from class: ne.g
            @Override // com.google.android.material.datepicker.h
            public final void a(Object obj) {
                FeedbackActivity.this.n0((Long) obj);
            }
        });
        a10.p0(getSupportFragmentManager(), "frag_date");
    }

    private void x0() {
        if (this.f17885v == null) {
            this.f17885v = new k7.b(this).D(getString(y.f31223l, new Object[]{9})).d(false).m(y.f31212a, ne.e.f31151a).a();
        }
        this.f17885v.show();
    }

    private void y0() {
        if (this.f17869f == null) {
            this.f17869f = new c.a(this).i(y.f31226o).f(getString(y.f31225n, new Object[]{getString(y.f31227p)})).g(new DialogInterface.OnClickListener() { // from class: ne.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    FeedbackActivity.this.p0(dialogInterface, i10);
                }
            }).h(new DialogInterface.OnClickListener() { // from class: ne.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    FeedbackActivity.this.q0(dialogInterface, i10);
                }
            }).c();
        }
        this.f17869f.show();
    }

    private void z0(final Calendar calendar) {
        final com.google.android.material.timepicker.b j10 = new b.d().m(1).k(calendar.get(11)).l(calendar.get(12)).n(y.f31218g).j();
        j10.x0(new View.OnClickListener() { // from class: ne.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackActivity.this.r0(calendar, j10, view);
            }
        });
        j10.p0(getSupportFragmentManager(), "frag_time");
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return x.f31207a;
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        k.c("FeedbackActivity", "onReceived Activity result = %d resultCode = %d", Integer.valueOf(i10), Integer.valueOf(i11));
        if (i10 == 0 && i11 == -1 && intent != null) {
            ClipData clipData = intent.getClipData();
            if (clipData == null || clipData.getItemCount() <= 0) {
                if (intent.getData() != null) {
                    f0(intent.getData());
                }
            } else if (clipData.getItemCount() + this.f17864a.size() > 9) {
                x0();
                return;
            } else {
                for (int i12 = 0; i12 < clipData.getItemCount(); i12++) {
                    Uri uri = clipData.getItemAt(i12).getUri();
                    if (uri != null) {
                        f0(uri);
                    }
                }
            }
            e0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == w.f31187b) {
            u0();
        } else if (id2 == w.f31201p) {
            U();
        }
    }

    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("type");
            this.f17881r = string;
            if (!TextUtils.isEmpty(string)) {
                s.a().e(a0(this, this.f17881r));
                this.f17867d = extras.getString("title");
                this.f17880q = extras.getString("wwid");
                this.f17868e = extras.getString("category");
                this.f17883t = extras.getString("feedback_device_version");
                this.f17882s = extras.getString("feedback_device_id");
                if (!TextUtils.isEmpty(this.f17867d)) {
                    setTitle(this.f17867d);
                } else if (!TextUtils.isEmpty(this.f17868e)) {
                    setTitle(this.f17868e);
                } else {
                    setTitle(y.f31213b);
                }
                j0();
            } else {
                throw new IllegalArgumentException("the source can not be null");
            }
        } else {
            setTitle(y.f31213b);
        }
        initView();
        k.a("FeedbackActivity", "onCreate");
        this.f17884u = new dq.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        k.a("FeedbackActivity", "onDestroy");
        super.onDestroy();
        dq.b bVar = this.f17884u;
        if (bVar != null) {
            bVar.unsubscribe();
        }
        androidx.appcompat.app.c cVar = this.f17885v;
        if (cVar != null && cVar.isShowing()) {
            this.f17885v.dismiss();
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        TextView textView;
        if (view.getId() == w.f31194i && (textView = this.f17879p) != null) {
            if (z10) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        }
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (iArr.length > 0 && iArr[0] == 0) {
            A0();
        } else if (i10 == 161 && !z9.e.g(this, f17863w[0])) {
            y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        Dialog dialog;
        super.onResume();
        if (z9.e.d(this, f17863w) && (dialog = this.f17869f) != null && dialog.isShowing()) {
            this.f17869f.dismiss();
        }
    }

    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d
    public boolean onSupportNavigateUp() {
        androidx.core.app.a.p(this);
        return true;
    }

    @Override // com.mobvoi.feedback.a.AbstractC0212a
    public void s(int i10) {
        this.f17864a.remove(i10);
        e0();
    }

    protected void s0() {
        b.a b10 = s.a().b();
        if (b10 != null) {
            b10.a(this.f17865b);
        }
    }

    @Override // com.mobvoi.feedback.a.AbstractC0212a
    public void t() {
        A0();
    }

    protected void t0(int i10) {
        b.a b10 = s.a().b();
        if (b10 != null) {
            this.f17865b.putString("jira_id", String.valueOf(i10));
            b10.b(this.f17865b);
        }
        androidx.core.app.a.p(this);
    }
}
