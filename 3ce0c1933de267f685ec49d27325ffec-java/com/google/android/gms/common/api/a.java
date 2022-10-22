package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import b6.i;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0105a<?, O> f8452a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f8453b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8454c;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0105a<T extends f, O> extends e<T, O> {
        public abstract T c(Context context, Looper looper, b6.c cVar, O o10, d.b bVar, d.c cVar2);
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static class c<C extends b> {
    }

    /* loaded from: classes.dex */
    public interface d {

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface AbstractC0106a extends c, d {
            Account o();
        }

        /* loaded from: classes.dex */
        public interface b extends c {
            GoogleSignInAccount W();
        }

        /* loaded from: classes.dex */
        public interface c extends d {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<T extends b, O> {
        public List<Scope> a(O o10) {
            return Collections.emptyList();
        }

        public int b() {
            return Integer.MAX_VALUE;
        }
    }

    /* loaded from: classes.dex */
    public interface f extends b {
        void a();

        void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean f();

        void g(com.google.android.gms.common.internal.f fVar, Set<Scope> set);

        boolean h();

        String i();

        boolean isConnected();

        void j(b.c cVar);

        void l(b.e eVar);

        boolean o();

        int p();

        Feature[] r();

        Intent s();

        boolean t();

        IBinder u();
    }

    /* loaded from: classes.dex */
    public static final class g<C extends f> extends c<C> {
    }

    /* loaded from: classes.dex */
    public interface h<T extends IInterface> extends b {
        void k(int i10, T t10);

        String m();

        T n(IBinder iBinder);

        String v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0105a<C, O> aVar, g<C> gVar) {
        i.l(aVar, "Cannot construct an Api with a null ClientBuilder");
        i.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f8454c = str;
        this.f8452a = aVar;
        this.f8453b = gVar;
    }

    public final c<?> a() {
        g<?> gVar = this.f8453b;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String b() {
        return this.f8454c;
    }

    public final e<?, O> c() {
        return this.f8452a;
    }

    public final AbstractC0105a<?, O> d() {
        i.o(this.f8452a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f8452a;
    }
}
