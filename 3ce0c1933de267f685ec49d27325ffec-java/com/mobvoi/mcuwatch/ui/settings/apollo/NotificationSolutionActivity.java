package com.mobvoi.mcuwatch.ui.settings.apollo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.mobvoi.companion.base.m3.d;
import kotlin.jvm.internal.f;
import sh.i;
import sh.k;
/* compiled from: NotificationSolutionActivity.kt */
/* loaded from: classes2.dex */
public final class NotificationSolutionActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final b f20084a = new b(null);

    /* compiled from: NotificationSolutionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Fragment {
        public a() {
            super(i.W);
        }
    }

    /* compiled from: NotificationSolutionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.i.f(context, "context");
            Intent intent = new Intent(context, NotificationSolutionActivity.class);
            intent.putExtra("page", 1);
            context.startActivity(intent);
        }

        public final void b(Context context) {
            kotlin.jvm.internal.i.f(context, "context");
            Intent intent = new Intent(context, NotificationSolutionActivity.class);
            intent.putExtra("page", 2);
            context.startActivity(intent);
        }
    }

    /* compiled from: NotificationSolutionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Fragment {
        public c() {
            super(i.f34736e0);
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        Fragment fragment;
        super.onCreate(bundle);
        setTitle(k.P1);
        if (getIntent().getIntExtra("page", 1) == 1) {
            fragment = new c();
        } else {
            fragment = new a();
        }
        getSupportFragmentManager().l().b(getContentView().getId(), fragment).l();
    }
}
