package nj;

import android.content.Context;
import android.content.Intent;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.ui.customview.McuDialogActivity;
import com.mobvoi.mcuwatch.ui.settings.ota.f;
import com.mobvoi.mcuwatch.ui.settings.ota.g;
/* compiled from: GthDevicePageUiHelper.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    private static i f31273c = new i();

    /* renamed from: a  reason: collision with root package name */
    private boolean f31274a = false;

    /* renamed from: b  reason: collision with root package name */
    private f f31275b = new g();

    private i() {
    }

    public static i a() {
        return f31273c;
    }

    private void c(Context context) {
        e(context, 1);
    }

    private void d(Context context) {
        e(context, 2);
    }

    private void e(Context context, int i10) {
        Intent intent = new Intent(context, McuDialogActivity.class);
        intent.putExtra("extra_dialog_type", i10);
        context.startActivity(intent);
    }

    public void b(Context context) {
        if (!this.f31274a && this.f31275b.d()) {
            if (n.f19178a.e() < this.f31275b.c()) {
                c(context);
            } else {
                d(context);
            }
            this.f31274a = true;
        }
    }
}
