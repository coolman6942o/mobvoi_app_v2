package jc;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import gc.b;
import gc.d;
import gc.e;
import gc.g;
/* compiled from: MobvoiAlertDialog.java */
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener, NumberPicker.Formatter {

    /* renamed from: a  reason: collision with root package name */
    private TextView f29509a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f29510b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f29511c;

    /* renamed from: d  reason: collision with root package name */
    private Button f29512d;

    /* renamed from: e  reason: collision with root package name */
    private Button f29513e;

    /* renamed from: f  reason: collision with root package name */
    private Button f29514f;

    /* renamed from: g  reason: collision with root package name */
    private Button f29515g;

    /* renamed from: h  reason: collision with root package name */
    private NumberPicker f29516h;

    /* renamed from: i  reason: collision with root package name */
    private FrameLayout f29517i;

    /* renamed from: j  reason: collision with root package name */
    private View f29518j;

    /* renamed from: k  reason: collision with root package name */
    private View f29519k;

    /* renamed from: l  reason: collision with root package name */
    private View f29520l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f29521m;

    /* renamed from: n  reason: collision with root package name */
    private AbstractC0354a f29522n;

    /* compiled from: MobvoiAlertDialog.java */
    /* renamed from: jc.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0354a {
        void a();

        void onCancel();
    }

    public a(Context context) {
        this(context, false);
    }

    private void a() {
        getWindow().requestFeature(1);
        getWindow().getAttributes().windowAnimations = g.f27372a;
        View inflate = getLayoutInflater().inflate(e.f27356c, (ViewGroup) null);
        setCancelable(false);
        setContentView(inflate);
        this.f29518j = findViewById(d.f27349t);
        this.f29517i = (FrameLayout) inflate.findViewById(d.f27336g);
        this.f29519k = findViewById(d.f27333d);
        this.f29520l = findViewById(d.f27338i);
        this.f29509a = (TextView) inflate.findViewById(d.f27348s);
        this.f29510b = (TextView) inflate.findViewById(d.f27342m);
        this.f29511c = (TextView) inflate.findViewById(d.f27340k);
        this.f29512d = (Button) inflate.findViewById(d.f27334e);
        this.f29513e = (Button) inflate.findViewById(d.f27346q);
        this.f29514f = (Button) inflate.findViewById(d.f27347r);
        this.f29515g = (Button) inflate.findViewById(d.f27339j);
        this.f29516h = (NumberPicker) inflate.findViewById(d.f27344o);
        this.f29521m = (ImageView) inflate.findViewById(d.f27335f);
        this.f29512d.setOnClickListener(this);
        this.f29513e.setOnClickListener(this);
        this.f29514f.setOnClickListener(this);
        this.f29515g.setOnClickListener(this);
        this.f29521m.setOnClickListener(this);
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f29509a.getLayoutParams();
            layoutParams.addRule(14);
            this.f29509a.setLayoutParams(layoutParams);
            this.f29510b.setGravity(17);
            this.f29519k.setVisibility(8);
            this.f29514f.setVisibility(0);
            this.f29514f.setText(str);
            return;
        }
        throw new IllegalArgumentException("Must have a button!");
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b(str2);
        } else if (TextUtils.isEmpty(str2)) {
            b(str);
        } else {
            this.f29519k.setVisibility(0);
            this.f29512d.setText(str);
            this.f29513e.setText(str2);
            this.f29514f.setVisibility(8);
        }
    }

    public void d(AbstractC0354a aVar) {
        this.f29522n = aVar;
    }

    public void e(View view) {
        this.f29510b.setVisibility(8);
        this.f29517i.addView(view);
        this.f29518j.setVisibility(8);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(b.f27328a);
        FrameLayout frameLayout = this.f29517i;
        frameLayout.setPadding(frameLayout.getPaddingLeft(), dimensionPixelSize, this.f29517i.getPaddingLeft(), 0);
    }

    public void f(int i10) {
        g(getContext().getString(i10));
    }

    @Override // android.widget.NumberPicker.Formatter
    public String format(int i10) {
        return String.valueOf(i10);
    }

    public void g(CharSequence charSequence) {
        this.f29518j.setVisibility(8);
        this.f29517i.setVisibility(8);
        this.f29516h.setVisibility(8);
        this.f29519k.setVisibility(8);
        this.f29514f.setVisibility(8);
        this.f29520l.setVisibility(0);
        if (TextUtils.isEmpty(charSequence)) {
            this.f29511c.setVisibility(8);
        } else {
            this.f29511c.setText(charSequence);
        }
    }

    public void h(int i10, int i11) {
        j(getContext().getString(i10), getContext().getString(i11));
    }

    public void i(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f29510b.setText(charSequence);
            this.f29518j.setVisibility(8);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(b.f27328a);
            FrameLayout frameLayout = this.f29517i;
            frameLayout.setPadding(frameLayout.getPaddingLeft(), dimensionPixelSize, this.f29517i.getPaddingLeft(), 0);
            return;
        }
        throw new IllegalArgumentException("Must have a message!");
    }

    public void j(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence)) {
            i(charSequence2);
        } else if (TextUtils.isEmpty(charSequence2)) {
            setTitle(charSequence);
        } else {
            this.f29509a.setText(charSequence);
            this.f29510b.setText(charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == d.f27334e) {
            AbstractC0354a aVar = this.f29522n;
            if (aVar != null) {
                aVar.onCancel();
            } else {
                dismiss();
            }
        } else if (id2 == d.f27346q) {
            AbstractC0354a aVar2 = this.f29522n;
            if (aVar2 != null) {
                aVar2.a();
            } else {
                dismiss();
            }
        } else if (id2 == d.f27347r || id2 == d.f27339j) {
            AbstractC0354a aVar3 = this.f29522n;
            if (aVar3 != null) {
                aVar3.a();
            } else {
                dismiss();
            }
        } else if (id2 == d.f27335f) {
            AbstractC0354a aVar4 = this.f29522n;
            if (aVar4 != null) {
                aVar4.onCancel();
            } else {
                dismiss();
            }
        }
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f29509a.setText(charSequence);
            this.f29517i.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f29509a.getLayoutParams();
            layoutParams.addRule(14);
            this.f29509a.setLayoutParams(layoutParams);
            return;
        }
        throw new IllegalArgumentException("Must have a title!");
    }

    public a(Context context, boolean z10) {
        super(context, g.f27373b);
        a();
    }
}
