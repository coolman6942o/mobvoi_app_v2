package td;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
/* compiled from: LaserPay.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f35131a;

    /* renamed from: b  reason: collision with root package name */
    private c f35132b;

    /* renamed from: c  reason: collision with root package name */
    private a f35133c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f35134d;

    public b(Activity activity, c cVar) {
        this.f35131a = activity;
        this.f35132b = cVar;
    }

    public void a(int i10, int i11, Intent intent) {
        if (i11 != 0) {
            if (i10 == 1 && i11 == -1) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("payway", -1);
                    c cVar = this.f35132b;
                    if (cVar != null) {
                        cVar.a(intExtra);
                    }
                }
            } else if (i10 == 10) {
                e.a(intent, this.f35132b);
            } else if (i10 == 11) {
                f.a(intent, this.f35132b);
            }
        }
    }

    public void b(int i10, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            k.d("LaserPay", "payInfo is null");
            this.f35132b.b();
        } else if (i10 == 1) {
            if (this.f35133c == null) {
                this.f35133c = new a(this.f35131a, this.f35132b);
            }
            this.f35133c.b(str);
        } else if (i10 == 2) {
        } else {
            if (i10 == 3) {
                Class<?> cls = this.f35134d;
                if (cls == null) {
                    this.f35132b.b();
                } else {
                    f.b(this.f35131a, cls, str);
                }
            } else if (i10 == 4) {
                e.b(this.f35131a, str, str2);
            } else {
                throw new IllegalArgumentException("The Params payWay is not support");
            }
        }
    }
}
