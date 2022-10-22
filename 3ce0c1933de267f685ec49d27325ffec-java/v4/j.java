package v4;

import j0.e;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import n5.g;
import n5.k;
import o5.a;
import o5.c;
/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final g<q4.b, String> f35616a = new g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final e<b> f35617b = o5.a.d(10, new a(this));

    /* compiled from: SafeKeyGenerator.java */
    /* loaded from: classes.dex */
    class a implements a.d<b> {
        a(j jVar) {
        }

        /* renamed from: b */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeKeyGenerator.java */
    /* loaded from: classes.dex */
    public static final class b implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f35618a;

        /* renamed from: b  reason: collision with root package name */
        private final c f35619b = c.a();

        b(MessageDigest messageDigest) {
            this.f35618a = messageDigest;
        }

        @Override // o5.a.f
        public c f() {
            return this.f35619b;
        }
    }

    private String a(q4.b bVar) {
        b bVar2 = (b) n5.j.d(this.f35617b.b());
        try {
            bVar.b(bVar2.f35618a);
            return k.t(bVar2.f35618a.digest());
        } finally {
            this.f35617b.a(bVar2);
        }
    }

    public String b(q4.b bVar) {
        String g10;
        synchronized (this.f35616a) {
            g10 = this.f35616a.g(bVar);
        }
        if (g10 == null) {
            g10 = a(bVar);
        }
        synchronized (this.f35616a) {
            this.f35616a.k(bVar, g10);
        }
        return g10;
    }
}
