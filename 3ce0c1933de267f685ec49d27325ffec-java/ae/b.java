package ae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.c;
import com.mobvoi.companion.R;
import yd.a;
/* compiled from: MobvoiLoadingDialog.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private c f179a;

    public c a(Context context) {
        c cVar = this.f179a;
        if (cVar != null && cVar.isShowing()) {
            this.f179a.dismiss();
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_loading, (ViewGroup) null, false);
        a.a((ImageView) inflate.findViewById(R.id.iv_loading));
        c a10 = new c.a(context, R.style.WrapperDialogStyle).s(inflate).a();
        this.f179a = a10;
        return a10;
    }
}
