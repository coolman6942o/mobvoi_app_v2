package com.mobvoi.companion.device;

import android.os.Bundle;
import android.os.Handler;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import ce.e;
import ce.f;
import ce.h;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.m3.d;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes2.dex */
public class PiiAlterActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f16673a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f16674b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f16675a;

        /* renamed from: b  reason: collision with root package name */
        public String f16676b;

        private b() {
        }
    }

    private void initView() {
        this.f16674b = new Handler(getMainLooper());
        String string = getString(h.f5863o0);
        this.f16673a = (LinearLayout) findViewById(e.f5779i);
        List<b> H = H(string);
        for (int i10 = 0; i10 < H.size(); i10++) {
            b bVar = H.get(i10);
            int i11 = 17;
            if (bVar != null) {
                TextView textView = (TextView) LayoutInflater.from(this).inflate(f.f5831y, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                textView.setText(bVar.f16676b);
                int i12 = bVar.f16675a;
                int i13 = 15;
                if (i12 == 3) {
                    i11 = 15;
                }
                if (i12 < 2) {
                    i13 = 22;
                }
                textView.setTextSize(2, i11);
                layoutParams.setMargins(i12 * 80, i13, 40, i13);
                this.f16673a.addView(textView, layoutParams);
            }
        }
    }

    public List<b> H(String str) {
        ArrayList arrayList = new ArrayList();
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new StringReader(str));
            int i10 = 1;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    b bVar = new b();
                    if ("ul".equals(newPullParser.getName())) {
                        i10++;
                    } else {
                        String nextText = newPullParser.nextText();
                        bVar.f16675a = i10;
                        bVar.f16676b = nextText;
                        arrayList.add(bVar);
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("ul".equals(newPullParser.getName())) {
                    i10--;
                }
            }
        } catch (XmlPullParserException e10) {
            k.d("PiiAlterActivity", e10.getMessage());
        } catch (Exception e11) {
            k.d("PiiAlterActivity", e11.getMessage());
        }
        return arrayList;
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return f.f5832z;
    }

    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setTitle(h.f5865p0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f16674b.removeCallbacksAndMessages(null);
    }
}
