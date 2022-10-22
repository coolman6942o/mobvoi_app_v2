package com.mobvoi.companion.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mobvoi.android.common.utils.k;
import io.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ShortLivedReceiver.kt */
/* loaded from: classes2.dex */
public abstract class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17401a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17402b;

    /* renamed from: c  reason: collision with root package name */
    private final d f17403c;

    /* compiled from: ShortLivedReceiver.kt */
    /* renamed from: com.mobvoi.companion.receiver.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0207a {
        private C0207a() {
        }

        public /* synthetic */ C0207a(f fVar) {
            this();
        }
    }

    /* compiled from: ShortLivedReceiver.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<IntentFilter> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final IntentFilter invoke() {
            return a.this.c();
        }
    }

    static {
        new C0207a(null);
    }

    public a() {
        this(false, 1, null);
    }

    public /* synthetic */ a(boolean z10, int i10, f fVar) {
        this((i10 & 1) != 0 ? true : z10);
    }

    private final IntentFilter a() {
        return (IntentFilter) this.f17403c.getValue();
    }

    private final void e(Context context, IntentFilter intentFilter) {
        if (this.f17401a) {
            b1.a.b(context).c(this, intentFilter);
        } else {
            context.registerReceiver(this, intentFilter);
        }
    }

    private final void g(Context context) {
        if (this.f17401a) {
            b1.a.b(context).e(this);
        } else {
            context.unregisterReceiver(this);
        }
    }

    protected abstract void b(String str, Intent intent);

    protected abstract IntentFilter c();

    public final void d(Context context) {
        i.f(context, "context");
        k.a("ShortLivedReceiver", "register(): hasRegistered/" + this.f17402b + ", registerAsLocal/" + this.f17401a);
        if (!this.f17402b) {
            e(context, c());
            this.f17402b = true;
        }
    }

    public final void f(Context context) {
        i.f(context, "context");
        k.a("ShortLivedReceiver", "unRegister(): hasRegistered/" + this.f17402b + ", registerAsLocal/" + this.f17401a);
        if (this.f17402b) {
            g(context);
            this.f17402b = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            if (a().hasAction(action)) {
                b(action, intent);
                f(context);
            }
        }
    }

    public a(boolean z10) {
        d a10;
        this.f17401a = z10;
        a10 = io.f.a(new b());
        this.f17403c = a10;
    }
}
