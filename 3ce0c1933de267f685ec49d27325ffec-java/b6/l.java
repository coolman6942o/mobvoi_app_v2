package b6;

import android.app.Activity;
import android.content.Intent;
/* loaded from: classes.dex */
final class l extends e {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Intent f5067a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Activity f5068b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f5069c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Intent intent, Activity activity, int i10) {
        this.f5067a = intent;
        this.f5068b = activity;
        this.f5069c = i10;
    }

    @Override // b6.e
    public final void c() {
        Intent intent = this.f5067a;
        if (intent != null) {
            this.f5068b.startActivityForResult(intent, this.f5069c);
        }
    }
}
