package com.mobvoi.companion.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.d;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.R;
import com.mobvoi.companion.view.StarRatingView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: ScoringDialogActivity.kt */
/* loaded from: classes2.dex */
public final class ScoringDialogActivity extends d implements View.OnClickListener, StarRatingView.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f17627b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final io.d f17628a = com.mobvoi.android.common.ui.viewbinding.a.a(this, b.INSTANCE);

    /* compiled from: ScoringDialogActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Context context, boolean z10) {
            i.f(context, "context");
            Intent intent = new Intent(context, ScoringDialogActivity.class);
            intent.putExtra("extra_ratable", z10);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* compiled from: ScoringDialogActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements l<LayoutInflater, oc.f> {
        public static final b INSTANCE = new b();

        b() {
            super(1, oc.f.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/companion/databinding/DialogAppScoringBinding;", 0);
        }

        /* renamed from: g */
        public final oc.f invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return oc.f.d(p02);
        }
    }

    private final oc.f G() {
        return (oc.f) this.f17628a.getValue();
    }

    private final void initView() {
        getIntent().getBooleanExtra("extra_ratable", false);
        setFinishOnTouchOutside(false);
        G().f31521c.setVisibility(8);
        G().f31520b.setOnClickListener(this);
        G().f31522d.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        i.f(v10, "v");
        int id2 = v10.getId();
        if (id2 == R.id.cancel_btn) {
            Object c10 = yd.i.a().c("launcher_times", 1);
            Objects.requireNonNull(c10, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) c10).intValue() + 1;
            k.a("AlarmReceiver", i.n("click cancel button, times = ", Integer.valueOf(intValue)));
            if (intValue > 6) {
                yd.i.a().d("need_show", Boolean.FALSE);
            }
            yd.i.a().d("launcher_times", Integer.valueOf(intValue));
            finish();
        } else if (id2 == R.id.submit_btn) {
            String packageName = com.mobvoi.android.common.utils.b.e().getPackageName();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(i.n("market://details?id=", packageName)));
            List<ResolveInfo> queryIntentActivities = com.mobvoi.android.common.utils.b.e().getPackageManager().queryIntentActivities(intent, WXMediaMessage.THUMB_LENGTH_LIMIT);
            i.e(queryIntentActivities, "getApplication().packageManager.queryIntentActivities(\n                intent,\n                PackageManager.MATCH_DEFAULT_ONLY\n            )");
            if (queryIntentActivities.size() != 0) {
                intent.addFlags(268435456);
                com.mobvoi.android.common.utils.b.e().startActivity(intent);
            } else {
                Intent intent2 = new Intent("com.mobvoi.action.OPEN_BROWSER");
                intent2.putExtra("url", i.n("http://m.wandoujia.com/apps/", packageName));
                startActivity(intent2);
            }
            yd.i.a().d("need_show", Boolean.FALSE);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(G().a());
        getWindow().setLayout(-2, -2);
        initView();
    }

    @Override // com.mobvoi.companion.view.StarRatingView.a
    public void x(int i10) {
    }
}
