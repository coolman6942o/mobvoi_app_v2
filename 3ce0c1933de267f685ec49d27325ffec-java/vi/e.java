package vi;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity;
import sh.h;
import sh.i;
import sh.k;
/* compiled from: ArtyAuthorizationDialog.java */
/* loaded from: classes2.dex */
public class e extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    TextView f35785a;

    /* renamed from: b  reason: collision with root package name */
    TextView f35786b;

    /* renamed from: c  reason: collision with root package name */
    TextView f35787c;

    /* renamed from: d  reason: collision with root package name */
    TextView f35788d;

    /* renamed from: e  reason: collision with root package name */
    View f35789e;

    /* renamed from: f  reason: collision with root package name */
    TextView f35790f;

    /* renamed from: g  reason: collision with root package name */
    private Context f35791g;

    /* renamed from: h  reason: collision with root package name */
    private a f35792h;

    /* compiled from: ArtyAuthorizationDialog.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public e(Context context) {
        super(context);
        this.f35791g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        this.f35792h.a();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        dismiss();
    }

    private void i(String str) {
        OverseaBrowserActivity.J(this.f35791g, str);
    }

    private void j() {
        this.f35785a.setText(this.f35791g.getResources().getString(k.w_res_0x7f1400e0));
        this.f35786b.setVisibility(8);
        this.f35789e.setVisibility(8);
        this.f35787c.setVisibility(8);
        this.f35788d.setVisibility(8);
        this.f35790f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(View view) {
        i("https://cardiex.com/privacy-policy/");
    }

    public void e() {
        this.f35785a.setText(this.f35791g.getResources().getString(k.f34889x));
        this.f35786b.setVisibility(0);
        this.f35789e.setVisibility(0);
        this.f35787c.setVisibility(0);
        this.f35788d.setVisibility(0);
        this.f35790f.setVisibility(8);
    }

    public void k(a aVar) {
        this.f35792h = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        setCancelable(false);
        setContentView(i.R);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(h.f34646h3);
        this.f35785a = (TextView) findViewById(h.f34653j2);
        this.f35786b = (TextView) findViewById(h.g_res_0x7f0b0088);
        this.f35787c = (TextView) findViewById(h.P0);
        this.f35788d = (TextView) findViewById(h.f_res_0x7f0b0087);
        this.f35789e = findViewById(h.Y1);
        this.f35790f = (TextView) findViewById(h.C1);
        this.f35786b.setOnClickListener(new View.OnClickListener() { // from class: vi.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.l(view);
            }
        });
        this.f35787c.setOnClickListener(new View.OnClickListener() { // from class: vi.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.f(view);
            }
        });
        this.f35788d.setOnClickListener(new View.OnClickListener() { // from class: vi.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.g(view);
            }
        });
        this.f35790f.setOnClickListener(new View.OnClickListener() { // from class: vi.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.h(view);
            }
        });
    }
}
