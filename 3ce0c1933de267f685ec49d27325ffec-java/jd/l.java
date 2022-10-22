package jd;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import ce.e;
import ce.f;
import com.google.android.material.textfield.TextInputLayout;
import com.mobvoi.companion.profile.h;
import ta.a;
/* compiled from: NickNameChanger.java */
/* loaded from: classes2.dex */
public class l extends k<String> implements h.c {

    /* renamed from: f  reason: collision with root package name */
    private TextInputLayout f29544f;

    /* renamed from: g  reason: collision with root package name */
    private final String f29545g;

    public l(h hVar, String str) {
        super(hVar, str);
        this.f29545g = str;
    }

    @Override // com.mobvoi.companion.profile.h.c
    public void a() {
        String str = a.e().nickName;
        a.T(str);
        this.f29543e.k(0, str);
    }

    @Override // jd.k
    protected int d() {
        return f.f5816j;
    }

    @Override // jd.k
    protected int e() {
        return ce.h.S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View view) {
        super.g(view);
        this.f29544f = (TextInputLayout) view.findViewById(e.f5789n);
    }

    @Override // jd.k
    protected void j(View view) {
        this.f29542d.dismiss();
        EditText editText = this.f29544f.getEditText();
        if (editText != null) {
            String obj = editText.getText().toString();
            if (!TextUtils.isEmpty(obj) && !obj.equals(this.f29545g)) {
                sa.a e10 = a.e();
                e10.nickName = obj;
                this.f29540b.g(this);
                this.f29540b.h(e10);
            }
        }
    }
}
