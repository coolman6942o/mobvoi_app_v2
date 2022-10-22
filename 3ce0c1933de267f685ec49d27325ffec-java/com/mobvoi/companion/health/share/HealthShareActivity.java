package com.mobvoi.companion.health.share;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.mobvoi.companion.R;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.model.ShareExerciseBean;
import fg.k;
import io.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: HealthShareActivity.kt */
/* loaded from: classes2.dex */
public final class HealthShareActivity extends com.mobvoi.companion.base.m3.d {

    /* renamed from: a  reason: collision with root package name */
    private final io.d f16958a;

    /* renamed from: b  reason: collision with root package name */
    private final io.d f16959b;

    /* renamed from: c  reason: collision with root package name */
    private final io.d f16960c;

    /* renamed from: d  reason: collision with root package name */
    private final io.d f16961d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16962e;

    /* renamed from: f  reason: collision with root package name */
    private String f16963f;

    /* renamed from: g  reason: collision with root package name */
    private SportType f16964g;

    /* renamed from: h  reason: collision with root package name */
    private ShareExerciseBean f16965h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f16966i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f16967j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f16968k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f16969l;

    /* compiled from: HealthShareActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: HealthShareActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<g> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final g invoke() {
            return new g();
        }
    }

    /* compiled from: HealthShareActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<k> {
        public static final c INSTANCE = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final k invoke() {
            return new k();
        }
    }

    /* compiled from: HealthShareActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements qo.a<Fragment> {
        d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // qo.a
        public final Fragment invoke() {
            return HealthShareActivity.this.M();
        }
    }

    /* compiled from: HealthShareActivity.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements qo.a<s> {
        public static final e INSTANCE = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final s invoke() {
            return new s();
        }
    }

    static {
        new a(null);
    }

    public HealthShareActivity() {
        io.d a10;
        io.d a11;
        io.d a12;
        io.d a13;
        a10 = io.f.a(e.INSTANCE);
        this.f16958a = a10;
        a11 = io.f.a(c.INSTANCE);
        this.f16959b = a11;
        a12 = io.f.a(b.INSTANCE);
        this.f16960c = a12;
        a13 = io.f.a(new d());
        this.f16961d = a13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment M() {
        return this.f16962e ? N() : O();
    }

    private final Fragment N() {
        return (Fragment) this.f16960c.getValue();
    }

    private final Fragment O() {
        return (Fragment) this.f16959b.getValue();
    }

    private final Fragment Q() {
        return (Fragment) this.f16961d.getValue();
    }

    private final Fragment S() {
        return (Fragment) this.f16958a.getValue();
    }

    private final Fragment T() {
        TextView textView = this.f16967j;
        if (textView == null) {
            i.u("tvChart");
            throw null;
        } else if (textView.isSelected()) {
            return Q();
        } else {
            return S();
        }
    }

    private final void U(Fragment fragment) {
        Bundle bundle = new Bundle();
        if (this.f16962e) {
            bundle.putSerializable("share_info", this.f16965h);
        } else {
            bundle.putString("sportId", this.f16963f);
            bundle.putSerializable("type", this.f16964g);
        }
        m mVar = m.f28349a;
        fragment.setArguments(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(HealthShareActivity this$0, View view) {
        i.f(this$0, "this$0");
        TextView textView = this$0.f16966i;
        if (textView == null) {
            i.u("tvWaterMark");
            throw null;
        } else if (!textView.isSelected()) {
            TextView textView2 = this$0.f16966i;
            if (textView2 != null) {
                textView2.setSelected(true);
                TextView textView3 = this$0.f16967j;
                if (textView3 != null) {
                    textView3.setSelected(false);
                    sb.a.d(this$0, "clickShareWaterMark");
                    this$0.getSupportFragmentManager().l().q(this$0.Q()).z(this$0.S()).j();
                    return;
                }
                i.u("tvChart");
                throw null;
            }
            i.u("tvWaterMark");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(HealthShareActivity this$0, View view) {
        i.f(this$0, "this$0");
        TextView textView = this$0.f16967j;
        if (textView == null) {
            i.u("tvChart");
            throw null;
        } else if (!textView.isSelected()) {
            TextView textView2 = this$0.f16966i;
            if (textView2 != null) {
                textView2.setSelected(false);
                TextView textView3 = this$0.f16967j;
                if (textView3 != null) {
                    textView3.setSelected(true);
                    sb.a.d(this$0, "clickShareChart");
                    this$0.getSupportFragmentManager().l().q(this$0.S()).z(this$0.Q()).j();
                    return;
                }
                i.u("tvChart");
                throw null;
            }
            i.u("tvWaterMark");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(HealthShareActivity this$0, View view) {
        Bitmap L;
        i.f(this$0, "this$0");
        sb.a.d(this$0, "shareSaveImg");
        Fragment T = this$0.T();
        if ((T instanceof com.mobvoi.companion.health.share.a) && (L = ((com.mobvoi.companion.health.share.a) T).L()) != null) {
            this$0.Z(L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(HealthShareActivity this$0, View view) {
        Bitmap L;
        i.f(this$0, "this$0");
        sb.a.d(this$0, "shareMore");
        Fragment T = this$0.T();
        if ((T instanceof com.mobvoi.companion.health.share.a) && (L = ((com.mobvoi.companion.health.share.a) T).L()) != null) {
            new k(this$0).execute(L);
        }
    }

    private final void Z(Bitmap bitmap) {
        OutputStream openOutputStream;
        String str = "IMG_" + System.currentTimeMillis() + ".jpg";
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", "image/jpg");
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
            contentValues.put("is_pending", (Integer) 1);
            Uri insert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (insert != null && (openOutputStream = getContentResolver().openOutputStream(insert)) != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, openOutputStream);
                openOutputStream.flush();
                openOutputStream.close();
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                getContentResolver().update(insert, contentValues, null, null);
                Toast.makeText(this, R.string.common_success, 0).show();
            }
        } else if (hc.e.j(this)) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            MediaScannerConnection.scanFile(getApplicationContext(), new String[]{file.getAbsolutePath()}, new String[]{"image/jpg"}, null);
            Toast.makeText(this, R.string.common_success, 0).show();
        } else {
            androidx.core.app.a.s(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 10);
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return R.layout.activity_health_share_layout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_health_share_layout);
        View findViewById = findViewById(R.id.tvWaterMark);
        i.e(findViewById, "findViewById(R.id.tvWaterMark)");
        this.f16966i = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tvChart);
        i.e(findViewById2, "findViewById(R.id.tvChart)");
        this.f16967j = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tvSavePicLocal);
        i.e(findViewById3, "findViewById(R.id.tvSavePicLocal)");
        this.f16968k = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.tvMore);
        i.e(findViewById4, "findViewById(R.id.tvMore)");
        this.f16969l = (TextView) findViewById4;
        ShareExerciseBean shareExerciseBean = (ShareExerciseBean) getIntent().getSerializableExtra("share_info");
        this.f16965h = shareExerciseBean;
        this.f16962e = shareExerciseBean != null;
        String stringExtra = getIntent().getStringExtra("sportId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f16963f = stringExtra;
        this.f16964g = (SportType) getIntent().getSerializableExtra("type");
        setTitle(R.string.common_share);
        TextView textView = this.f16966i;
        if (textView != null) {
            textView.setSelected(true);
            TextView textView2 = this.f16967j;
            if (textView2 != null) {
                textView2.setSelected(false);
                U(S());
                U(Q());
                w l10 = getSupportFragmentManager().l();
                int i10 = R.id.fragment;
                l10.c(i10, S(), "FRG_WATER_MARK_TAG").c(i10, Q(), "FRG_WATER_MARK_TAG").q(Q()).j();
                TextView textView3 = this.f16966i;
                if (textView3 != null) {
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.share.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HealthShareActivity.V(HealthShareActivity.this, view);
                        }
                    });
                    TextView textView4 = this.f16967j;
                    if (textView4 != null) {
                        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.share.f
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                HealthShareActivity.W(HealthShareActivity.this, view);
                            }
                        });
                        TextView textView5 = this.f16968k;
                        if (textView5 != null) {
                            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.share.c
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    HealthShareActivity.X(HealthShareActivity.this, view);
                                }
                            });
                            TextView textView6 = this.f16969l;
                            if (textView6 != null) {
                                textView6.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.share.d
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        HealthShareActivity.Y(HealthShareActivity.this, view);
                                    }
                                });
                            } else {
                                i.u("tvMore");
                                throw null;
                            }
                        } else {
                            i.u("tvSavePicLocal");
                            throw null;
                        }
                    } else {
                        i.u("tvChart");
                        throw null;
                    }
                } else {
                    i.u("tvWaterMark");
                    throw null;
                }
            } else {
                i.u("tvChart");
                throw null;
            }
        } else {
            i.u("tvWaterMark");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "healthShare");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "healthShare");
    }
}
