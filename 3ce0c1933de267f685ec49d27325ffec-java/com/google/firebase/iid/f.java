package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import androidx.collection.a;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.e;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Pair<String, String>, c<String>> f12477a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(c<String> cVar) throws IOException {
        try {
            return (String) e.a(cVar.a());
        } catch (InterruptedException e10) {
            throw new IOException(e10);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(cause);
            }
        }
    }

    private static String b(i iVar, c<String> cVar) throws IOException {
        try {
            String a10 = iVar.a();
            cVar.c(a10);
            return a10;
        } catch (IOException | RuntimeException e10) {
            cVar.b(e10);
            throw e10;
        }
    }

    private final synchronized i e(String str, String str2, final i iVar) {
        final Pair<String, String> pair = new Pair<>(str, str2);
        final c<String> cVar = this.f12477a.get(pair);
        if (cVar != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 29);
                sb2.append("Joining ongoing request for: ");
                sb2.append(valueOf);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
            return new i(cVar) { // from class: com.google.firebase.iid.g

                /* renamed from: a  reason: collision with root package name */
                private final c f12480a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12480a = cVar;
                }

                @Override // com.google.firebase.iid.i
                public final String a() {
                    String a10;
                    a10 = f.a(this.f12480a);
                    return a10;
                }
            };
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 24);
            sb3.append("Making new request for: ");
            sb3.append(valueOf2);
            Log.d("FirebaseInstanceId", sb3.toString());
        }
        final c<String> cVar2 = new c<>();
        this.f12477a.put(pair, cVar2);
        return new i(this, iVar, cVar2, pair) { // from class: com.google.firebase.iid.h

            /* renamed from: a  reason: collision with root package name */
            private final f f12483a;

            /* renamed from: b  reason: collision with root package name */
            private final i f12484b;

            /* renamed from: c  reason: collision with root package name */
            private final c f12485c;

            /* renamed from: d  reason: collision with root package name */
            private final Pair f12486d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12483a = this;
                this.f12484b = iVar;
                this.f12485c = cVar2;
                this.f12486d = pair;
            }

            @Override // com.google.firebase.iid.i
            public final String a() {
                return this.f12483a.c(this.f12484b, this.f12485c, this.f12486d);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String c(i iVar, c cVar, Pair pair) throws IOException {
        try {
            String b10 = b(iVar, cVar);
            synchronized (this) {
                this.f12477a.remove(pair);
            }
            return b10;
        } catch (Throwable th2) {
            synchronized (this) {
                this.f12477a.remove(pair);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d(String str, String str2, i iVar) throws IOException {
        return e(str, str2, iVar).a();
    }
}
