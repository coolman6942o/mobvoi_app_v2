package zh;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import p1.a;
import sh.h;
/* compiled from: ActivityApolloNotificationSettingBinding.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final NestedScrollView f37511a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f37512b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f37513c;

    /* renamed from: d  reason: collision with root package name */
    public final SwitchMaterial f37514d;

    private b(NestedScrollView nestedScrollView, TextView textView, ImageView imageView, RecyclerView recyclerView, SwitchMaterial switchMaterial, TextView textView2, TextView textView3) {
        this.f37511a = nestedScrollView;
        this.f37512b = textView;
        this.f37513c = recyclerView;
        this.f37514d = switchMaterial;
    }

    public static b b(View view) {
        TextView textView;
        int i10 = h.N0;
        TextView textView2 = (TextView) p1.b.a(view, i10);
        if (textView2 != null) {
            i10 = h.f34678p1;
            ImageView imageView = (ImageView) p1.b.a(view, i10);
            if (imageView != null) {
                i10 = h.f34720y2;
                RecyclerView recyclerView = (RecyclerView) p1.b.a(view, i10);
                if (recyclerView != null) {
                    i10 = h.f34622c3;
                    SwitchMaterial switchMaterial = (SwitchMaterial) p1.b.a(view, i10);
                    if (switchMaterial != null) {
                        i10 = h.f34685q3;
                        TextView textView3 = (TextView) p1.b.a(view, i10);
                        if (!(textView3 == null || (textView = (TextView) p1.b.a(view, i10)) == null)) {
                            return new b((NestedScrollView) view, textView2, imageView, recyclerView, switchMaterial, textView3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public NestedScrollView a() {
        return this.f37511a;
    }
}
