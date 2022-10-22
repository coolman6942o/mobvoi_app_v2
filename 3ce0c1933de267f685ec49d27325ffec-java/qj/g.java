package qj;

import aa.d;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.protobuf.n0;
import com.mobvoi.companion.proto.ConstantProto;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.e;
import com.mobvoi.record.i;
import com.mobvoi.record.j;
import com.mobvoi.record.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import rj.h;
/* compiled from: RecordsAdapter.java */
/* loaded from: classes2.dex */
public class g extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    private List<SoundProto.SoundFile> f33232a;

    /* renamed from: b  reason: collision with root package name */
    private b f33233b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordsAdapter.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33234a;

        static {
            int[] iArr = new int[SoundProto.FileStatus.values().length];
            f33234a = iArr;
            try {
                iArr[SoundProto.FileStatus.CONVERTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33234a[SoundProto.FileStatus.CONVERTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33234a[SoundProto.FileStatus.CONVERT_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33234a[SoundProto.FileStatus.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: RecordsAdapter.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(SoundProto.SoundFile soundFile);

        void b(SoundProto.SoundFile soundFile);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordsAdapter.java */
    /* loaded from: classes2.dex */
    public static class c extends BaseViewHolder {

        /* renamed from: a  reason: collision with root package name */
        h f33235a;

        public c(View view) {
            super(view);
            this.f33235a = h.b(view);
        }
    }

    private void g(Context context, n0 n0Var, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int b10 = d.b(8.0f, context);
        int b11 = d.b(2.0f, context);
        for (int i10 = 0; i10 < n0Var.size(); i10++) {
            TextView textView = new TextView(context);
            if (i10 > 0) {
                layoutParams.setMargins(0, 0, b10, 0);
            }
            textView.setText(n0Var.get(i10));
            textView.setTextSize(2, 12.0f);
            textView.setTextColor(context.getResources().getColor(e.f20406c));
            textView.setBackgroundResource(com.mobvoi.record.g.f20568e);
            textView.setPadding(b10, b11, b10, b11);
            textView.setLayoutParams(layoutParams);
            linearLayout.addView(textView);
        }
    }

    private String h(int i10) {
        int i11 = i10 / 1000;
        int i12 = i11 % 60;
        int i13 = (i11 / 60) % 60;
        int i14 = i11 / 3600;
        return i14 > 0 ? String.format("%02dh%02dm%02ds", Integer.valueOf(i14), Integer.valueOf(i13), Integer.valueOf(i12)) : i13 > 0 ? String.format("%02dm%02ds", Integer.valueOf(i13), Integer.valueOf(i12)) : String.format("%02ds", Integer.valueOf(i12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(SoundProto.SoundFile soundFile, View view) {
        b bVar = this.f33233b;
        if (bVar != null) {
            bVar.a(soundFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(SoundProto.SoundFile soundFile, View view) {
        b bVar = this.f33233b;
        if (bVar != null) {
            bVar.b(soundFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(SoundProto.SoundFile soundFile, View view) {
        b bVar = this.f33233b;
        if (bVar != null) {
            bVar.b(soundFile);
        }
    }

    private String s(long j10) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(j10));
    }

    public void f(List<SoundProto.SoundFile> list) {
        this.f33232a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SoundProto.SoundFile> list = this.f33232a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public SoundProto.SoundFile i(int i10) {
        return this.f33232a.get(i10);
    }

    public void m(String str) {
        for (int i10 = 0; i10 < this.f33232a.size(); i10++) {
            if (this.f33232a.get(i10).getFileId().equals(str)) {
                this.f33232a.remove(i10);
                notifyItemRemoved(i10);
                return;
            }
        }
    }

    public void n(String str, String str2) {
        for (int i10 = 0; i10 < getItemCount(); i10++) {
            if (this.f33232a.get(i10).getFileId().equals(str)) {
                SoundProto.SoundFile build = SoundProto.SoundFile.newBuilder().setDeviceId(this.f33232a.get(i10).getDeviceId()).setFileId(this.f33232a.get(i10).getFileId()).setFileName(str2).addAllFlags(this.f33232a.get(i10).getFlagsList()).setFileUrl(this.f33232a.get(i10).getFileUrl()).setFileSize(this.f33232a.get(i10).getFileSize()).setDuration(this.f33232a.get(i10).getDuration()).setTimestamp(this.f33232a.get(i10).getTimestamp()).setSpeakerNum(this.f33232a.get(i10).getSpeakerNum()).setFileStatus(this.f33232a.get(i10).getFileStatus()).setDeviceType(this.f33232a.get(i10).getDeviceType()).setPercentage(this.f33232a.get(i10).getPercentage()).setFirstParagraph(this.f33232a.get(i10).getFirstParagraph()).addAllKeywords(this.f33232a.get(i10).getKeywordsList()).build();
                this.f33232a.set(i10, build);
                notifyItemChanged(i10, build);
                return;
            }
        }
    }

    /* renamed from: o */
    public void onBindViewHolder(c cVar, int i10) {
        Context context = cVar.itemView.getContext();
        final SoundProto.SoundFile soundFile = this.f33232a.get(i10);
        cVar.f33235a.f33594f.setText(soundFile.getFileName());
        cVar.f33235a.f33599k.setText(s(soundFile.getTimestamp()));
        cVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: qj.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.this.j(soundFile, view);
            }
        });
        if (soundFile.getDeviceType() == ConstantProto.DeviceType.TIC_MEET) {
            cVar.f33235a.f33598j.setText(context.getString(k.N, context.getString(k.O)));
        } else if (soundFile.getDeviceType() == ConstantProto.DeviceType.TIC_WATCH) {
            cVar.f33235a.f33598j.setText(context.getString(k.N, context.getString(k.P)));
        }
        cVar.f33235a.f33593e.setText(h(soundFile.getDuration()));
        int i11 = a.f33234a[soundFile.getFileStatus().ordinal()];
        if (i11 == 1) {
            cVar.f33235a.f33590b.setVisibility(8);
            cVar.f33235a.f33597i.setVisibility(0);
            cVar.f33235a.f33597i.setText(context.getResources().getString(k.f20677u));
            cVar.f33235a.f33596h.setVisibility(8);
            cVar.f33235a.f33591c.setVisibility(8);
            cVar.f33235a.f33595g.setVisibility(0);
            cVar.f33235a.f33592d.setVisibility(0);
            cVar.f33235a.f33595g.setText(soundFile.getFirstParagraph());
            g(context, soundFile.getKeywordsList(), cVar.f33235a.f33592d);
            cVar.f33235a.f33595g.setText(soundFile.getFirstParagraph());
        } else if (i11 == 2) {
            cVar.f33235a.f33590b.setVisibility(0);
            cVar.f33235a.f33590b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            cVar.f33235a.f33590b.setText(context.getString(k.R));
            cVar.f33235a.f33596h.setVisibility(0);
            cVar.f33235a.f33597i.setVisibility(8);
            cVar.f33235a.f33591c.setVisibility(0);
            cVar.f33235a.f33595g.setVisibility(8);
            cVar.f33235a.f33592d.setVisibility(8);
            TextView textView = cVar.f33235a.f33596h;
            String string = context.getResources().getString(k.f20674r);
            textView.setText(String.format(string, soundFile.getPercentage() + "%"));
        } else if (i11 == 3) {
            cVar.f33235a.f33590b.setVisibility(0);
            cVar.f33235a.f33590b.setBackground(androidx.core.content.b.e(context, com.mobvoi.record.g.f20567d));
            cVar.f33235a.f33590b.setText(context.getString(k.f20660d));
            cVar.f33235a.f33596h.setVisibility(8);
            cVar.f33235a.f33597i.setVisibility(0);
            cVar.f33235a.f33597i.setTextColor(androidx.core.content.b.c(context, e.f20409f));
            cVar.f33235a.f33597i.setText(context.getResources().getString(k.f20678v));
            cVar.f33235a.f33595g.setVisibility(8);
            cVar.f33235a.f33591c.setVisibility(0);
            cVar.f33235a.f33592d.setVisibility(8);
            cVar.f33235a.f33590b.setCompoundDrawablesWithIntrinsicBounds(androidx.core.content.b.e(context, j.f20655d), (Drawable) null, (Drawable) null, (Drawable) null);
            cVar.f33235a.f33590b.setOnClickListener(new View.OnClickListener() { // from class: qj.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.this.k(soundFile, view);
                }
            });
        } else if (i11 == 4) {
            cVar.f33235a.f33590b.setVisibility(0);
            cVar.f33235a.f33590b.setBackground(androidx.core.content.b.e(context, com.mobvoi.record.g.f20567d));
            cVar.f33235a.f33590b.setText(context.getString(k.f20676t));
            cVar.f33235a.f33596h.setVisibility(8);
            cVar.f33235a.f33597i.setVisibility(8);
            cVar.f33235a.f33595g.setVisibility(8);
            cVar.f33235a.f33591c.setVisibility(0);
            cVar.f33235a.f33592d.setVisibility(8);
            cVar.f33235a.f33590b.setCompoundDrawablesWithIntrinsicBounds(androidx.core.content.b.e(context, j.f20654c), (Drawable) null, (Drawable) null, (Drawable) null);
            cVar.f33235a.f33590b.setOnClickListener(new View.OnClickListener() { // from class: qj.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.this.l(soundFile, view);
                }
            });
        }
    }

    /* renamed from: p */
    public c onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(i.f20651r, viewGroup, false));
    }

    public void q(List<SoundProto.SoundFile> list) {
        this.f33232a = list;
        notifyDataSetChanged();
    }

    public void r(b bVar) {
        this.f33233b = bVar;
    }
}
