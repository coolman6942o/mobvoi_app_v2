package androidx.work;

import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    private UUID f4687a;

    /* renamed from: b  reason: collision with root package name */
    private d f4688b;

    /* renamed from: c  reason: collision with root package name */
    private Executor f4689c;

    /* renamed from: d  reason: collision with root package name */
    private a2.a f4690d;

    /* renamed from: e  reason: collision with root package name */
    private t f4691e;

    /* renamed from: f  reason: collision with root package name */
    private f f4692f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f4693a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f4694b = Collections.emptyList();
    }

    public WorkerParameters(UUID uuid, d dVar, Collection<String> collection, a aVar, int i10, Executor executor, a2.a aVar2, t tVar, n nVar, f fVar) {
        this.f4687a = uuid;
        this.f4688b = dVar;
        new HashSet(collection);
        this.f4689c = executor;
        this.f4690d = aVar2;
        this.f4691e = tVar;
        this.f4692f = fVar;
    }

    public Executor a() {
        return this.f4689c;
    }

    public f b() {
        return this.f4692f;
    }

    public UUID c() {
        return this.f4687a;
    }

    public d d() {
        return this.f4688b;
    }

    public a2.a e() {
        return this.f4690d;
    }

    public t f() {
        return this.f4691e;
    }
}
