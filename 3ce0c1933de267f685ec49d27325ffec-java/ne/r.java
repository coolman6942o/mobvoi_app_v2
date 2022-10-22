package ne;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.i;
import pe.b;
/* compiled from: FeedbackCnDeviceListModule.kt */
/* loaded from: classes2.dex */
public final class r extends RecyclerView.b0 {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f31172a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f31173b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f31174c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(b viewBinding) {
        super(viewBinding.a());
        i.f(viewBinding, "viewBinding");
        TextView textView = viewBinding.f32765d;
        i.e(textView, "viewBinding.title");
        this.f31172a = textView;
        ImageView imageView = viewBinding.f32764c;
        i.e(imageView, "viewBinding.icon");
        this.f31173b = imageView;
        TextView textView2 = viewBinding.f32763b;
        i.e(textView2, "viewBinding.count");
        this.f31174c = textView2;
    }

    public final ImageView a() {
        return this.f31173b;
    }

    public final TextView b() {
        return this.f31174c;
    }

    public final TextView c() {
        return this.f31172a;
    }
}
