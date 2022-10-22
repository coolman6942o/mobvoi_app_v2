package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.c;
/* loaded from: classes.dex */
abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f12462a;

    /* renamed from: b  reason: collision with root package name */
    final c<T> f12463b = new c<>();

    /* renamed from: c  reason: collision with root package name */
    final int f12464c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f12465d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i10, int i11, Bundle bundle) {
        this.f12462a = i10;
        this.f12464c = i11;
        this.f12465d = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(T t10) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 16 + valueOf2.length());
            sb2.append("Finishing ");
            sb2.append(valueOf);
            sb2.append(" with ");
            sb2.append(valueOf2);
            Log.d("MessengerIpcClient", sb2.toString());
        }
        this.f12463b.c(t10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzac zzacVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzacVar);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb2.append("Failing ");
            sb2.append(valueOf);
            sb2.append(" with ");
            sb2.append(valueOf2);
            Log.d("MessengerIpcClient", sb2.toString());
        }
        this.f12463b.b(zzacVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean d();

    public String toString() {
        int i10 = this.f12464c;
        int i11 = this.f12462a;
        boolean d10 = d();
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Request { what=");
        sb2.append(i10);
        sb2.append(" id=");
        sb2.append(i11);
        sb2.append(" oneWay=");
        sb2.append(d10);
        sb2.append("}");
        return sb2.toString();
    }
}
