package b6;

import android.content.Intent;
import com.google.android.gms.common.api.internal.h;
/* loaded from: classes.dex */
final class m extends e {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Intent f5070a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ h f5071b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f5072c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Intent intent, h hVar, int i10) {
        this.f5070a = intent;
        this.f5071b = hVar;
        this.f5072c = i10;
    }

    @Override // b6.e
    public final void c() {
        Intent intent = this.f5070a;
        if (intent != null) {
            this.f5071b.startActivityForResult(intent, this.f5072c);
        }
    }
}
