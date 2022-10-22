package sj;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.utils.a;
import com.mobvoi.record.view.audiowave.AudioWaveView;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: ParagraphChangeDialog.java */
/* loaded from: classes2.dex */
public class g extends androidx.fragment.app.c implements a.b, AudioWaveView.a {

    /* renamed from: q  reason: collision with root package name */
    private rj.a f34995q;

    /* renamed from: r  reason: collision with root package name */
    private String f34996r;

    /* renamed from: s  reason: collision with root package name */
    private SoundProto.SoundFile f34997s;

    /* renamed from: u  reason: collision with root package name */
    private int f34999u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f35000v;

    /* renamed from: w  reason: collision with root package name */
    private e f35001w;

    /* renamed from: t  reason: collision with root package name */
    private final ExecutorService f34998t = Executors.newSingleThreadExecutor();

    /* renamed from: x  reason: collision with root package name */
    private final Handler f35002x = new a(Looper.getMainLooper());

    /* compiled from: ParagraphChangeDialog.java */
    /* loaded from: classes2.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    if (com.mobvoi.record.utils.a.b().c().isPlaying()) {
                        int currentPosition = com.mobvoi.record.utils.a.b().c().getCurrentPosition();
                        int duration = com.mobvoi.record.utils.a.b().c().getDuration();
                        if (duration > 0) {
                            g.this.f34995q.f33525b.setProgress((currentPosition * 100) / duration);
                        }
                        sendEmptyMessageDelayed(1, 500L);
                    }
                } catch (Exception unused) {
                    k.a("DialogParagraphChange", "mediaPlayer getDuration in wrong state.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParagraphChangeDialog.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f35000v) {
                com.mobvoi.record.utils.a.b().c().pause();
                g.this.f34995q.f33529f.setImageResource(com.mobvoi.record.g.f20572i);
                g.this.f35000v = false;
                g.this.f35002x.removeCallbacksAndMessages(null);
                return;
            }
            g.this.f35002x.sendEmptyMessageDelayed(1, 500L);
            com.mobvoi.record.utils.a.b().c().start();
            g.this.f34995q.f33529f.setImageResource(com.mobvoi.record.g.f20571h);
            g.this.f35000v = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParagraphChangeDialog.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f35001w != null) {
                g.this.f35001w.a(null);
            }
            g.this.b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParagraphChangeDialog.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f35001w != null) {
                String obj = g.this.f34995q.f33528e.getText().toString();
                if (!obj.equals(g.this.f34996r)) {
                    g.this.f35001w.a(obj);
                }
                g.this.f34995q.f33528e.setText("");
            }
            g.this.b0();
        }
    }

    /* compiled from: ParagraphChangeDialog.java */
    /* loaded from: classes2.dex */
    public interface e {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(byte[] bArr) {
        this.f34995q.f33525b.setRawData(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(String str) {
        SoundProto.SoundFile soundFile;
        final byte[] bArr;
        try {
            byte[] bArr2 = new byte[1024];
            InputStream openStream = new URL(str).openStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openStream);
            if (getContext() != null) {
                File file = new File(com.mobvoi.android.common.utils.b.h(null).getAbsolutePath() + File.separator + "download.mp3");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr2, 0, read);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                openStream.close();
                if (file.exists() && (soundFile = this.f34997s) != null) {
                    byte[] bytes = soundFile.getFileId().getBytes();
                    int length = (int) ((file.length() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / 3);
                    uj.a aVar = new uj.a();
                    byte[] bArr3 = aVar.f35463a;
                    if (length > bArr3.length) {
                        int i10 = 0;
                        while (true) {
                            byte[] bArr4 = aVar.f35463a;
                            if (i10 >= length / bArr4.length) {
                                break;
                            }
                            int length2 = bArr3.length + bArr4.length;
                            byte[] bArr5 = new byte[length2];
                            System.arraycopy(bArr5, 0, bArr5, 0, length2);
                            byte[] bArr6 = aVar.f35463a;
                            System.arraycopy(bArr6, 0, bArr5, length2, bArr6.length);
                            i10++;
                            bArr3 = bArr5;
                        }
                        bArr = Arrays.copyOfRange(bArr3, (int) bytes[1], length + bytes[1]);
                    } else {
                        bArr = Arrays.copyOfRange(bArr3, (int) bytes[1], length + bytes[1]);
                    }
                    if (getActivity() != null) {
                        getActivity().runOnUiThread(new Runnable() { // from class: sj.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                g.this.A0(bArr);
                            }
                        });
                    }
                    if (file.delete()) {
                        k.a("DialogParagraphChange", "删除mp3文件");
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void y0() {
        final String fileUrl = this.f34997s.getFileUrl();
        this.f34998t.submit(new Runnable() { // from class: sj.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.B0(fileUrl);
            }
        });
    }

    public void C0(String str) {
        this.f34996r = str;
    }

    public void D0(int i10, SoundProto.SoundFile soundFile) {
        this.f34999u = i10;
        this.f34997s = soundFile;
        if (com.mobvoi.record.utils.a.b().c().isPlaying()) {
            com.mobvoi.record.utils.a.b().c().pause();
        }
        com.mobvoi.record.utils.a.b().c().seekTo(i10);
    }

    public void E0(e eVar) {
        this.f35001w = eVar;
    }

    @Override // com.mobvoi.record.view.audiowave.AudioWaveView.a
    public void e(int i10) {
        try {
            if (com.mobvoi.record.utils.a.b().c().isPlaying()) {
                com.mobvoi.record.utils.a.b().c().seekTo((com.mobvoi.record.utils.a.b().c().getDuration() * i10) / 100);
            }
        } catch (Exception unused) {
            k.a("DialogParagraphChange", "mediaPlayer getDuration in wrong state.");
        }
    }

    @Override // com.mobvoi.record.utils.a.b
    public void f() {
        com.mobvoi.record.utils.a.b().c().reset();
        com.mobvoi.record.utils.a.b().f(this.f34997s.getFileUrl());
        this.f35000v = false;
        this.f34995q.f33529f.setImageResource(com.mobvoi.record.g.f20572i);
    }

    @Override // androidx.fragment.app.c
    public Dialog h0(Bundle bundle) {
        Dialog h02 = super.h0(bundle);
        Window window = h02.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.addFlags(2);
        window.setGravity(17);
        return h02;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n0(0, 16973831);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f34995q = rj.a.d(getLayoutInflater());
        z0();
        return this.f34995q.a();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.mobvoi.record.utils.a.b().c().pause();
        super.onDestroyView();
    }

    void z0() {
        if (!TextUtils.isEmpty(this.f34996r)) {
            this.f34995q.f33528e.setText(this.f34996r);
            this.f34995q.f33528e.setSelection(this.f34996r.length());
        }
        this.f34995q.f33529f.setOnClickListener(new b());
        this.f34995q.f33525b.setProgress((this.f34999u * 100) / this.f34997s.getDuration());
        this.f34995q.f33526c.setOnClickListener(new c());
        this.f34995q.f33527d.setOnClickListener(new d());
        y0();
    }
}
