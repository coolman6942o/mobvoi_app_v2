package com.mobvoi.companion.aw;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.viewpager.widget.ViewPager;
import com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity;
import com.mobvoi.companion.aw.StartEntry;
import com.mobvoi.companion.aw.ui.main.HomeActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kc.f;
import rx.c;
import tb.g;
/* loaded from: classes2.dex */
public class StartEntry extends d {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f16153f = {R.drawable.pic_watch_1, R.drawable.pic_watch_2, R.drawable.pic_watch_3, R.drawable.pic_watch_4};

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f16154a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f16155b;

    /* renamed from: c  reason: collision with root package name */
    private List<ImageView> f16156c;

    /* renamed from: d  reason: collision with root package name */
    private final dq.b f16157d = new dq.b();

    /* renamed from: e  reason: collision with root package name */
    private boolean f16158e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            StartEntry.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends androidx.viewpager.widget.a {

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageView> f16160c;

        b(List<ImageView> list) {
            this.f16160c = list;
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(this.f16160c.get(i10));
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return this.f16160c.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            ImageView imageView = this.f16160c.get(i10);
            viewGroup.addView(imageView);
            return imageView;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(long j10) {
        int size = (int) (j10 % this.f16156c.size());
        this.f16154a.R(size, false);
        yd.a.b(this.f16156c.get(size));
        this.f16155b.setImageResource(R.drawable.pic_ticwatch_logo);
    }

    private ClickableSpan L() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(Long l10) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        sb.a.d(this, "splashStore");
        OverseaBrowserActivity.J(this, "https://www.mobvoi.com");
    }

    private void Q() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    private void S() {
        int[] iArr;
        if (this.f16158e) {
            setContentView(R.layout.activity_welcome_page);
            this.f16154a = (ViewPager) findViewById(R.id.pager_background);
            TextView textView = (TextView) findViewById(R.id.text_buy);
            this.f16155b = (ImageView) findViewById(R.id.image_ticwatch_logo);
            ((Button) findViewById(R.id.btn_start)).setOnClickListener(new View.OnClickListener() { // from class: tb.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StartEntry.this.onStartClicked(view);
                }
            });
            String string = getString(R.string.ticwatch_store);
            String format = String.format(getString(R.string.welcome_buy_ticwatch), string);
            int indexOf = format.indexOf(string);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(L(), indexOf, string.length() + indexOf, 17);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableStringBuilder);
            this.f16156c = new ArrayList();
            for (int i10 : f16153f) {
                ImageView imageView = new ImageView(this);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(i10);
                this.f16156c.add(imageView);
            }
            this.f16154a.setAdapter(new b(this.f16156c));
            this.f16157d.a(c.y(0L, 5000L, TimeUnit.MILLISECONDS).K().H(xp.a.b()).Y(new yp.b() { // from class: tb.f
                @Override // yp.b
                public final void call(Object obj) {
                    StartEntry.this.K(((Long) obj).longValue());
                }
            }, g.f35111a));
            return;
        }
        yd.d.c(this, true);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        setContentView(R.layout.activity_welcome_flash);
        this.f16157d.a(c.e0(100L, TimeUnit.MILLISECONDS).H(xp.a.b()).p(new yp.b() { // from class: tb.e
            @Override // yp.b
            public final void call(Object obj) {
                StartEntry.this.N((Long) obj);
            }
        }).T());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean b10 = xb.a.b();
        this.f16158e = b10;
        if (b10) {
            setTheme(R.style.LaunchTheme);
        }
        super.onCreate(bundle);
        f.c(this);
        S();
        getWindow().getDecorView().setSystemUiVisibility(1280);
        if (TextUtils.isEmpty(ta.a.v())) {
            ta.a.b0(Locale.getDefault().getDisplayCountry(Locale.ENGLISH));
            this.f16157d.a(lb.c.u());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        this.f16157d.b();
        super.onDestroy();
    }

    public void onStartClicked(View view) {
        xb.a.d(false);
        Q();
    }
}
