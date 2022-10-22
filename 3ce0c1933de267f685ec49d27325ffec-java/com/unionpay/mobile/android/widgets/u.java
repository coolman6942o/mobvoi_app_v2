package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.utils.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class u extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f24448a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f24449b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f24450c;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f24455h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f24456i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f24457j;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24451d = true;

    /* renamed from: e  reason: collision with root package name */
    private b f24452e = null;

    /* renamed from: f  reason: collision with root package name */
    private a f24453f = null;

    /* renamed from: k  reason: collision with root package name */
    private View.OnClickListener f24458k = new v(this);

    /* renamed from: l  reason: collision with root package name */
    private TextWatcher f24459l = new w(this);

    /* renamed from: m  reason: collision with root package name */
    private View.OnFocusChangeListener f24460m = new x(this);

    /* renamed from: g  reason: collision with root package name */
    private int f24454g = com.unionpay.mobile.android.global.a.f23323n;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z10);
    }

    /* loaded from: classes2.dex */
    public interface b extends a {
        void a_();

        void e();
    }

    public u(Context context) {
        super(context);
        this.f24448a = null;
        this.f24449b = null;
        this.f24450c = null;
        this.f24456i = null;
        this.f24448a = context;
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setFocusable(true);
        TextView textView = new TextView(this.f24448a);
        textView.setPadding(g.a(this.f24448a, 10.0f), 0, 0, 0);
        textView.setEms(4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 19;
        addView(textView, layoutParams);
        textView.setGravity(19);
        textView.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
        textView.setTextColor(-13421773);
        this.f24456i = textView;
        textView.setVisibility(8);
        RelativeLayout relativeLayout = new RelativeLayout(this.f24448a);
        relativeLayout.setGravity(21);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 19;
        addView(relativeLayout, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.f24448a);
        linearLayout.setGravity(21);
        linearLayout.setId(linearLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.rightMargin = g.a(this.f24448a, 10.0f);
        linearLayout.setVisibility(8);
        relativeLayout.addView(linearLayout, layoutParams3);
        this.f24457j = linearLayout;
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f24448a);
        relativeLayout2.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(9, -1);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(0, linearLayout.getId());
        layoutParams4.rightMargin = g.a(this.f24448a, 10.0f);
        relativeLayout.addView(relativeLayout2, layoutParams4);
        ImageView imageView = new ImageView(this.f24448a);
        this.f24450c = imageView;
        imageView.setId(imageView.hashCode());
        this.f24450c.setBackgroundDrawable(this.f24455h);
        this.f24450c.setOnClickListener(this.f24458k);
        this.f24450c.setVisibility(8);
        ImageView imageView2 = this.f24450c;
        imageView2.setId(imageView2.hashCode());
        this.f24450c.setAdjustViewBounds(true);
        int a10 = g.a(this.f24448a, 30.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(a10, a10);
        layoutParams5.addRule(11, -1);
        layoutParams5.addRule(15, -1);
        relativeLayout2.addView(this.f24450c, layoutParams5);
        EditText editText = new EditText(this.f24448a);
        this.f24449b = editText;
        editText.setSingleLine();
        this.f24449b.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
        this.f24449b.setTextColor(-10066330);
        this.f24449b.setHintTextColor(-6710887);
        this.f24449b.setBackgroundDrawable(null);
        this.f24449b.setGravity(16);
        this.f24449b.setPadding(g.a(this.f24448a, 10.0f), 0, 0, 0);
        this.f24449b.addTextChangedListener(this.f24459l);
        if (this.f24451d) {
            this.f24449b.setOnFocusChangeListener(this.f24460m);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(0, this.f24450c.getId());
        layoutParams6.addRule(15, -1);
        layoutParams6.addRule(9, -1);
        relativeLayout2.addView(this.f24449b, layoutParams6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b(u uVar) {
        return (uVar.f24449b == null || uVar.b().length() == 0 || !uVar.f24451d) ? false : true;
    }

    public final TextView a(String str) {
        if (this.f24456i != null && !TextUtils.isEmpty(str)) {
            this.f24456i.setVisibility(0);
            this.f24456i.setText(str);
        }
        return this.f24456i;
    }

    public final u a(Drawable drawable) {
        if (drawable != null) {
            this.f24450c.setBackgroundDrawable(drawable);
        }
        return this;
    }

    public final void a() {
        this.f24451d = false;
        EditText editText = this.f24449b;
        if (editText != null) {
            editText.setKeyListener(null);
            this.f24449b.setFocusable(false);
            ImageView imageView = this.f24450c;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.f24450c.setVisibility(8);
            }
        }
    }

    public final void a(int i10) {
        EditText editText = this.f24449b;
        if (editText != null) {
            editText.setInputType(i10);
        }
    }

    public final void a(InputFilter inputFilter) {
        InputFilter[] inputFilterArr = {inputFilter};
        EditText editText = this.f24449b;
        if (editText != null) {
            InputFilter[] filters = editText.getFilters();
            if (filters == null) {
                this.f24449b.setFilters(inputFilterArr);
                return;
            }
            InputFilter[] inputFilterArr2 = new InputFilter[filters.length + 1];
            System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, filters.length, 1);
            this.f24449b.setFilters(inputFilterArr2);
        }
    }

    public final void a(TextWatcher textWatcher) {
        EditText editText = this.f24449b;
        if (editText != null && textWatcher != null) {
            editText.addTextChangedListener(textWatcher);
        }
    }

    public final void a(View view, LinearLayout.LayoutParams layoutParams) {
        LinearLayout linearLayout;
        if (view != null && (linearLayout = this.f24457j) != null) {
            linearLayout.addView(view, layoutParams);
            this.f24457j.setVisibility(0);
        }
    }

    public final void a(TextView.OnEditorActionListener onEditorActionListener) {
        EditText editText = this.f24449b;
        if (editText != null && this.f24451d) {
            editText.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public final void a(a aVar) {
        this.f24453f = aVar;
    }

    public final void a(b bVar) {
        this.f24452e = bVar;
        EditText editText = this.f24449b;
        if (editText != null) {
            editText.setOnClickListener(this);
        }
    }

    public final String b() {
        EditText editText = this.f24449b;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public final void b(int i10) {
        EditText editText = this.f24449b;
        if (editText != null) {
            editText.setSelection(i10);
        }
    }

    public final void b(String str) {
        EditText editText = this.f24449b;
        if (editText != null && str != null) {
            editText.setHint(str);
        }
    }

    public final Editable c() {
        EditText editText = this.f24449b;
        if (editText != null) {
            return editText.getText();
        }
        return null;
    }

    public final void c(String str) {
        EditText editText = this.f24449b;
        if (editText != null && str != null) {
            editText.setText(str);
        }
    }

    public final void d() {
        EditText editText = this.f24449b;
        if (editText != null) {
            editText.setLongClickable(false);
        }
    }

    public final void e() {
        EditText editText = this.f24449b;
        if (editText != null) {
            editText.setText("");
            b bVar = this.f24452e;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public final void f() {
        ((Activity) this.f24448a).getWindow().setSoftInputMode(3);
        int i10 = Build.VERSION.SDK_INT;
        String str = i10 >= 16 ? "setShowSoftInputOnFocus" : i10 >= 14 ? "setSoftInputShownOnFocus" : null;
        if (str == null) {
            this.f24449b.setInputType(0);
            return;
        }
        try {
            Method method = EditText.class.getMethod(str, Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(this.f24449b, Boolean.FALSE);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (IllegalArgumentException e11) {
            e11.printStackTrace();
        } catch (NoSuchMethodException e12) {
            this.f24449b.setInputType(0);
            e12.printStackTrace();
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar = this.f24452e;
        if (bVar != null) {
            bVar.a_();
        }
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        EditText editText = this.f24449b;
        if (editText != null) {
            editText.setOnTouchListener(onTouchListener);
        }
    }
}
