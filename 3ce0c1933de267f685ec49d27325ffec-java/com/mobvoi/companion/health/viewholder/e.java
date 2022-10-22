package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.bumptech.glide.c;
import com.bumptech.glide.g;
import java.util.List;
import kotlin.jvm.internal.i;
import tc.n;
/* compiled from: HealthCardReportViewHolder.kt */
/* loaded from: classes2.dex */
public final class e extends a {

    /* renamed from: c  reason: collision with root package name */
    private final Context f17101c;

    /* renamed from: d  reason: collision with root package name */
    private final List<n> f17102d;

    public e(Context context, List<n> data) {
        i.f(context, "context");
        i.f(data, "data");
        this.f17101c = context;
        this.f17102d = data;
    }

    private final int u(int i10) {
        if (d() == 1) {
            return 0;
        }
        if (i10 == 0) {
            i10 = d() - 2;
        } else if (i10 == d() - 1) {
            return 0;
        }
        return i10 - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(n bannerResult, e this$0, View view) {
        i.f(bannerResult, "$bannerResult");
        i.f(this$0, "this$0");
        String c10 = bannerResult.c();
        if (c10 != null) {
            sb.a.e(this$0.f17101c, "healthReport", c10);
            g.a(this$0.f17101c, c10);
        }
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup container, int i10, Object obj) {
        i.f(container, "container");
        i.f(obj, "obj");
        View view = (View) obj;
        c.u(this.f17101c).l(view);
        container.removeView(view);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        int size = this.f17102d.size();
        if (size == 0) {
            return 0;
        }
        if (size != 1) {
            return this.f17102d.size() + 2;
        }
        return 1;
    }

    @Override // androidx.viewpager.widget.a
    public int e(Object obj) {
        i.f(obj, "obj");
        return -2;
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup container, int i10) {
        String str;
        i.f(container, "container");
        final n nVar = this.f17102d.get(u(i10));
        ImageView imageView = new ImageView(this.f17101c);
        imageView.setLayoutParams(new ViewPager.g());
        imageView.getLayoutParams().width = -1;
        imageView.getLayoutParams().height = -1;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (TextUtils.isEmpty(nVar.a())) {
            str = !TextUtils.isEmpty(nVar.b()) ? nVar.b() : null;
        } else {
            str = nVar.a();
        }
        g<Bitmap> j10 = c.u(this.f17101c).j();
        if (str == null) {
            str = "";
        }
        j10.z0(str).f(t4.a.f35051c).g().u0(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.viewholder.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.v(n.this, this, view);
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        i.f(view, "view");
        i.f(obj, "obj");
        return i.b(view, obj);
    }

    public final void w(List<n> data) {
        i.f(data, "data");
        this.f17102d.clear();
        this.f17102d.addAll(data);
    }
}
