package k6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b6.d;
import com.google.android.gms.common.b;
import java.util.LinkedList;
import k6.c;
/* loaded from: classes.dex */
public abstract class a<T extends c> {

    /* renamed from: a  reason: collision with root package name */
    private T f29783a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f29784b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<AbstractC0363a> f29785c;

    /* renamed from: d  reason: collision with root package name */
    private final e<T> f29786d = new f(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k6.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0363a {
        void a(c cVar);

        int getState();
    }

    public static void g(FrameLayout frameLayout) {
        b q5 = b.q();
        Context context = frameLayout.getContext();
        int i10 = q5.i(context);
        String d10 = d.d(context, i10);
        String c10 = d.c(context, i10);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(d10);
        linearLayout.addView(textView);
        Intent d11 = q5.d(context, i10, null);
        if (d11 != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(c10);
            linearLayout.addView(button);
            button.setOnClickListener(new h(context, d11));
        }
    }

    private final void k(Bundle bundle, AbstractC0363a aVar) {
        T t10 = this.f29783a;
        if (t10 != null) {
            aVar.a(t10);
            return;
        }
        if (this.f29785c == null) {
            this.f29785c = new LinkedList<>();
        }
        this.f29785c.add(aVar);
        if (bundle != null) {
            Bundle bundle2 = this.f29784b;
            if (bundle2 == null) {
                this.f29784b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f29786d);
    }

    private final void m(int i10) {
        while (!this.f29785c.isEmpty() && this.f29785c.getLast().getState() >= i10) {
            this.f29785c.removeLast();
        }
    }

    protected abstract void a(e<T> eVar);

    public T b() {
        return this.f29783a;
    }

    public void c(Bundle bundle) {
        k(bundle, new g(this, bundle));
    }

    public void d() {
        T t10 = this.f29783a;
        if (t10 != null) {
            t10.onDestroy();
        } else {
            m(1);
        }
    }

    public void e() {
        T t10 = this.f29783a;
        if (t10 != null) {
            t10.onPause();
        } else {
            m(5);
        }
    }

    public void f() {
        k(null, new i(this));
    }
}
