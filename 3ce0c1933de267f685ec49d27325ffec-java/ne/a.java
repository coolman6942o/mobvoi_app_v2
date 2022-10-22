package ne;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.i;
/* compiled from: FeedbackCnDeviceListModule.kt */
/* loaded from: classes2.dex */
public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31141a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f31142b;

    /* compiled from: FeedbackCnDeviceListModule.kt */
    /* renamed from: ne.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0412a extends se.a {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f31143a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0412a(pe.a viewBinding) {
            super(viewBinding.a());
            i.f(viewBinding, "viewBinding");
            TextView textView = viewBinding.f32761b;
            i.e(textView, "viewBinding.deviceTitle");
            this.f31143a = textView;
        }

        public final TextView a() {
            return this.f31143a;
        }
    }

    public a(Context context, List<String> list) {
        i.f(context, "context");
        this.f31141a = context;
        this.f31142b = list;
    }

    /* renamed from: a */
    public String getItem(int i10) {
        List<String> list = this.f31142b;
        if (list == null) {
            return null;
        }
        return list.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f31142b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0412a aVar;
        FrameLayout frameLayout;
        if (view == null) {
            pe.a d10 = pe.a.d(LayoutInflater.from(this.f31141a));
            i.e(d10, "inflate(LayoutInflater.from(context))");
            aVar = new C0412a(d10);
            FrameLayout c10 = d10.a();
            c10.setTag(aVar);
            frameLayout = c10;
        } else {
            Object tag = view.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.mobvoi.feedback.DeviceListAdapter.ViewHolder");
            aVar = (C0412a) tag;
            frameLayout = view;
        }
        String a10 = getItem(i10);
        if (!TextUtils.isEmpty(a10)) {
            aVar.a().setText(a10);
        }
        return frameLayout;
    }
}
