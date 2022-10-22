package ne;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.recyclerview.widget.RecyclerView;
import ba.a;
import com.mobvoi.companion.WearableUiUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
/* compiled from: FeedbackCnDeviceListModule.kt */
/* loaded from: classes2.dex */
public final class k {
    public final List<b> a(Context context) {
        i.f(context, "context");
        ArrayList arrayList = new ArrayList();
        String string = context.getString(y.f31219h);
        i.e(string, "context.getString(R.string.feedback_type_vpa)");
        arrayList.add(new b(string, "vpa", v.f31185d, false, 0));
        if (WearableUiUtils.isWatchConnected()) {
            String string2 = context.getString(y.f31224m);
            i.e(string2, "context.getString(R.string.label_ticwatch)");
            arrayList.add(new b(string2, "Ticwatch-AWLE", v.f31184c, false, 0));
        }
        return arrayList;
    }

    public final q b(Context context, List<b> contentList) {
        i.f(context, "context");
        i.f(contentList, "contentList");
        return new q(context, contentList);
    }

    public final RecyclerView.n c(Context context) {
        i.f(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842906});
        i.e(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attribute)");
        int color = obtainStyledAttributes.getColor(0, -7829368);
        obtainStyledAttributes.recycle();
        return new a(2, color, context.getResources().getDimensionPixelSize(u.f31180b), 0);
    }
}
