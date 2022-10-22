package qj;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.n0;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.g;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import com.mobvoi.record.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: ConvertDataAdapter.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<e> {

    /* renamed from: a  reason: collision with root package name */
    private final List<SoundProto.ConvertData> f33189a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f33190b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33191c;

    /* renamed from: d  reason: collision with root package name */
    private List<Integer> f33192d;

    /* renamed from: e  reason: collision with root package name */
    private final int f33193e;

    /* renamed from: g  reason: collision with root package name */
    private f f33195g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f33196h;

    /* renamed from: f  reason: collision with root package name */
    private int f33194f = -1;

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f33197i = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConvertDataAdapter.java */
    /* renamed from: qj.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0455a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SoundProto.ConvertData f33198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f33199b;

        View$OnClickListenerC0455a(SoundProto.ConvertData convertData, e eVar) {
            this.f33198a = convertData;
            this.f33199b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f33195g != null) {
                a.this.f33195g.c(this.f33198a.getId(), this.f33199b.f33207a.getText().toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConvertDataAdapter.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SoundProto.ConvertData f33201a;

        b(SoundProto.ConvertData convertData) {
            this.f33201a = convertData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f33195g != null) {
                a.this.f33195g.b(this.f33201a.getId(), this.f33201a.getOffset(), TextUtils.isEmpty(this.f33201a.getModifiedText()) ? this.f33201a.getText() : this.f33201a.getModifiedText());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConvertDataAdapter.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SoundProto.ConvertData f33203a;

        c(SoundProto.ConvertData convertData) {
            this.f33203a = convertData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f33195g != null) {
                a.this.f33195g.b(this.f33203a.getId(), this.f33203a.getOffset(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConvertDataAdapter.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SoundProto.ConvertData f33205a;

        d(SoundProto.ConvertData convertData) {
            this.f33205a = convertData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f33195g != null) {
                a.this.f33195g.a(this.f33205a.getOffset());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConvertDataAdapter.java */
    /* loaded from: classes2.dex */
    public static class e extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private TextView f33207a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f33208b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f33209c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f33210d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f33211e;

        /* renamed from: f  reason: collision with root package name */
        private ImageView f33212f;

        /* renamed from: g  reason: collision with root package name */
        private LinearLayout f33213g;

        public e(View view) {
            super(view);
            this.f33210d = (ImageView) view.findViewById(h.D);
            this.f33209c = (TextView) view.findViewById(h.f20633z0);
            this.f33207a = (TextView) view.findViewById(h.f20582c1);
            this.f33211e = (ImageView) view.findViewById(h.f20622u);
            this.f33212f = (ImageView) view.findViewById(h.f20593g0);
            this.f33208b = (TextView) view.findViewById(h.f20588e1);
            this.f33213g = (LinearLayout) view.findViewById(h.f20581c0);
        }
    }

    /* compiled from: ConvertDataAdapter.java */
    /* loaded from: classes2.dex */
    public interface f {
        void a(int i10);

        void b(int i10, int i11, String str);

        void c(int i10, String str);
    }

    public a(Context context, List<SoundProto.ConvertData> list, List<Integer> list2, boolean z10) {
        ArrayList arrayList = new ArrayList();
        this.f33189a = arrayList;
        this.f33190b = context;
        if (list != null) {
            arrayList.addAll(list);
        }
        HashSet hashSet = new HashSet();
        for (SoundProto.ConvertData convertData : list) {
            hashSet.add(convertData.getSpeaker());
        }
        this.f33193e = hashSet.size();
        this.f33191c = z10;
        ArrayList arrayList2 = new ArrayList();
        this.f33192d = arrayList2;
        arrayList2.addAll(list2);
    }

    private void d(Context context, n0 n0Var, LinearLayout linearLayout) {
        int b10 = aa.d.b(8.0f, context);
        int b11 = aa.d.b(2.0f, context);
        for (int i10 = 0; i10 < n0Var.size(); i10++) {
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i10 > 0) {
                layoutParams.setMargins(b10, 0, 0, 0);
            }
            textView.setText(n0Var.get(i10));
            textView.setTextSize(2, 12.0f);
            textView.setTextColor(androidx.core.content.b.c(context, com.mobvoi.record.e.f20406c));
            textView.setBackgroundResource(g.f20568e);
            textView.setPadding(b10, b11, b10, b11);
            textView.setLayoutParams(layoutParams);
            linearLayout.addView(textView);
        }
    }

    public void e(int i10, String str) {
        for (int i11 = 0; i11 < this.f33189a.size(); i11++) {
            if (this.f33189a.get(i11).getOffset() == i10) {
                SoundProto.ConvertData convertData = this.f33189a.get(i11);
                this.f33189a.set(i11, SoundProto.ConvertData.newBuilder().setId(convertData.getId()).setOffset(i10).setText(convertData.getText()).setDuration(convertData.getDuration()).setModifiedText(str).setSummary(convertData.getSummary()).setSpeaker(convertData.getSpeaker()).setSpeakerName(convertData.getSpeakerName()).setChannel(convertData.getChannel()).addAllParagraphKeywords(convertData.getParagraphKeywordsList()).build());
                notifyItemChanged(i11);
                return;
            }
        }
    }

    public void f(String str, String str2) {
        Pattern compile = Pattern.compile("\\d+$");
        for (int i10 = 0; i10 < this.f33189a.size(); i10++) {
            SoundProto.ConvertData convertData = this.f33189a.get(i10);
            String speakerName = convertData.getSpeakerName();
            if (TextUtils.isEmpty(speakerName)) {
                Matcher matcher = compile.matcher(convertData.getSpeaker());
                if (matcher.find()) {
                    speakerName = String.format("speaker%s", matcher.group());
                }
            }
            if (str.equals(speakerName)) {
                this.f33189a.set(i10, SoundProto.ConvertData.newBuilder().setId(convertData.getId()).setOffset(convertData.getOffset()).setText(convertData.getText()).setDuration(convertData.getDuration()).setModifiedText(convertData.getModifiedText()).setSummary(convertData.getSummary()).setSpeaker(convertData.getSpeaker()).setSpeakerName(str2).setChannel(convertData.getChannel()).addAllParagraphKeywords(convertData.getParagraphKeywordsList()).build());
                notifyItemChanged(i10);
            }
        }
    }

    public void g(int i10) {
        this.f33194f = i10;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33189a.size();
    }

    /* renamed from: h */
    public void onBindViewHolder(e eVar, int i10) {
        int indexOf;
        SoundProto.ConvertData convertData = this.f33189a.get(i10);
        if (this.f33191c) {
            eVar.f33207a.setVisibility(0);
            String text = TextUtils.isEmpty(convertData.getModifiedText()) ? convertData.getText() : convertData.getModifiedText();
            SpannableString spannableString = new SpannableString(text);
            if (this.f33196h != null) {
                for (int i11 = 0; i11 < this.f33197i.size(); i11++) {
                    String str = this.f33197i.get(i11);
                    int i12 = 0;
                    while (i12 != -1 && (indexOf = text.indexOf(str, i12)) != -1) {
                        spannableString.setSpan(new ForegroundColorSpan(this.f33196h[i11]), indexOf, Math.min(text.length(), str.length() + indexOf), 33);
                        i12 = str.length() + indexOf >= text.length() ? -1 : indexOf + str.length();
                    }
                }
            }
            eVar.f33208b.setText(spannableString);
            if (convertData.getChannel() == SoundProto.Channel.LEFT || convertData.getChannel() == SoundProto.Channel.UNRECOGNIZED) {
                eVar.f33207a.setCompoundDrawablesWithIntrinsicBounds(androidx.core.content.b.e(this.f33190b, j.f20656e), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (convertData.getChannel() == SoundProto.Channel.RIGHT) {
                eVar.f33207a.setCompoundDrawablesWithIntrinsicBounds(androidx.core.content.b.e(this.f33190b, j.f20653b), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!this.f33190b.getPackageName().equals("com.mobvoi.companion.aw")) {
                eVar.f33207a.setText(convertData.getSpeaker());
            }
            Pattern compile = Pattern.compile("\\d+$");
            if (this.f33193e > 1) {
                eVar.f33207a.setVisibility(0);
                String speakerName = convertData.getSpeakerName();
                if (!TextUtils.isEmpty(speakerName)) {
                    eVar.f33207a.setText(speakerName);
                } else {
                    Matcher matcher = compile.matcher(convertData.getSpeaker());
                    if (matcher.find()) {
                        eVar.f33207a.setText(String.format("speaker%s", matcher.group()));
                    }
                }
            } else {
                eVar.f33207a.setVisibility(8);
            }
            eVar.f33207a.setOnClickListener(new View$OnClickListenerC0455a(convertData, eVar));
            eVar.f33211e.setOnClickListener(new b(convertData));
            eVar.f33212f.setOnClickListener(new c(convertData));
            eVar.f33208b.setOnClickListener(new d(convertData));
            if (!TextUtils.isEmpty(convertData.getModifiedText())) {
                eVar.f33212f.setVisibility(0);
            } else {
                eVar.f33212f.setVisibility(8);
            }
            eVar.f33209c.setText(com.mobvoi.record.utils.d.b(convertData.getOffset()));
            eVar.f33213g.setVisibility(8);
        } else if (!TextUtils.isEmpty(convertData.getSummary()) || convertData.getParagraphKeywordsList().size() != 0) {
            eVar.f33207a.setVisibility(8);
            eVar.f33208b.setText(convertData.getSummary());
            eVar.f33209c.setText(com.mobvoi.record.utils.d.b(convertData.getOffset()));
            eVar.f33213g.setVisibility(0);
            d(this.f33190b, convertData.getParagraphKeywordsList(), eVar.f33213g);
            eVar.f33211e.setVisibility(8);
        } else {
            eVar.itemView.setVisibility(8);
        }
        if (this.f33192d.size() > 0) {
            Iterator<Integer> it = this.f33192d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().intValue() == convertData.getOffset()) {
                    eVar.f33210d.setVisibility(0);
                    break;
                } else {
                    eVar.f33210d.setVisibility(8);
                }
            }
        } else {
            eVar.f33210d.setVisibility(8);
        }
        if (this.f33194f == i10) {
            eVar.f33208b.setSelected(true);
        } else {
            eVar.f33208b.setSelected(false);
        }
    }

    /* renamed from: i */
    public e onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new e(LayoutInflater.from(this.f33190b).inflate(i.f20648o, viewGroup, false));
    }

    public void j(List<Integer> list) {
        this.f33192d = list;
        Collections.sort(list);
        notifyDataSetChanged();
    }

    public void k(f fVar) {
        this.f33195g = fVar;
    }

    public void l(int[] iArr, List<String> list) {
        this.f33196h = iArr;
        this.f33197i.clear();
        if (list != null) {
            this.f33197i.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void m(int i10) {
        if (!this.f33192d.contains(Integer.valueOf(i10))) {
            this.f33192d.add(Integer.valueOf(i10));
            Collections.sort(this.f33192d);
            notifyDataSetChanged();
        }
    }
}
