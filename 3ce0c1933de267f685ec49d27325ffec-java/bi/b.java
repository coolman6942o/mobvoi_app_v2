package bi;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.notify.NotificationService;
import com.mobvoi.wear.common.base.WearPath;
import gn.p;
import java.util.ArrayList;
import java.util.List;
import kc.d;
/* compiled from: MusicControl.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    private static b f5155f;

    /* renamed from: g  reason: collision with root package name */
    private static AudioManager f5156g;

    /* renamed from: h  reason: collision with root package name */
    private static Context f5157h;

    /* renamed from: a  reason: collision with root package name */
    private MediaSessionManager f5158a;

    /* renamed from: b  reason: collision with root package name */
    private int f5159b = 2;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f5160c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public boolean f5161d = false;

    /* renamed from: e  reason: collision with root package name */
    private final MediaController.Callback f5162e = new a();

    /* compiled from: MusicControl.java */
    /* loaded from: classes2.dex */
    class a extends MediaController.Callback {
        a() {
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            super.onPlaybackStateChanged(playbackState);
            if (p.d(b.f5157h, 1) && playbackState != null && b.this.f5159b != playbackState.getState()) {
                if (playbackState.getState() == 2) {
                    f.c(u.f19202a, 2);
                } else if (playbackState.getState() == 3) {
                    f.c(u.f19202a, 1);
                }
                b.this.f5159b = playbackState.getState();
            }
        }
    }

    private void e(int i10) {
        long uptimeMillis = SystemClock.uptimeMillis() - 1;
        f5156g.dispatchMediaKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, i10, 0));
        long j10 = uptimeMillis + 1;
        f5156g.dispatchMediaKeyEvent(new KeyEvent(j10, j10, 1, i10, 0));
        Intent intent = new Intent("com.android.music.musicservicecommand");
        if (i10 == 87) {
            intent.putExtra(WearPath.MediaControls.CONTROLL_COMMAND, WearPath.MediaControls.CONTROLL_COMMAND_NEXT);
        } else if (i10 == 88) {
            intent.putExtra(WearPath.MediaControls.CONTROLL_COMMAND, WearPath.MediaControls.CONTROLL_COMMAND_PREVIOUS);
        } else if (i10 == 126) {
            intent.putExtra(WearPath.MediaControls.CONTROLL_COMMAND, WearPath.MediaControls.CONTROLL_COMMAND_PLAY);
        } else if (i10 == 127) {
            intent.putExtra(WearPath.MediaControls.CONTROLL_COMMAND, WearPath.MediaControls.CONTROLL_COMMAND_PAUSE);
        }
        f5157h.sendBroadcast(intent);
    }

    private void f(int i10) {
        Log.d("MusicControl", "keyValue: " + i10);
        e(i10);
    }

    public static b g() {
        if (f5155f == null) {
            f5155f = new b();
            Application e10 = com.mobvoi.android.common.utils.b.e();
            f5157h = e10;
            f5156g = (AudioManager) e10.getSystemService("audio");
        }
        return f5155f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(List<MediaController> list) {
        if (list.size() != 0) {
            ArrayList<MediaController> arrayList = new ArrayList(list);
            if (arrayList.size() > 0) {
                for (MediaController mediaController : arrayList) {
                    mediaController.registerCallback(this.f5162e, this.f5160c);
                }
            }
        }
    }

    public void h() {
        if (!d.a(f5157h)) {
            this.f5161d = false;
            return;
        }
        try {
            if (this.f5158a == null) {
                MediaSessionManager mediaSessionManager = (MediaSessionManager) f5157h.getSystemService("media_session");
                this.f5158a = mediaSessionManager;
                mediaSessionManager.addOnActiveSessionsChangedListener(new MediaSessionManager.OnActiveSessionsChangedListener() { // from class: bi.a
                    @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
                    public final void onActiveSessionsChanged(List list) {
                        b.this.k(list);
                    }
                }, new ComponentName(f5157h, NotificationService.class));
            }
            k(this.f5158a.getActiveSessions(new ComponentName(f5157h, NotificationService.class)));
            this.f5161d = true;
        } catch (SecurityException unused) {
            k.d("MusicControl", " initMediaSessionManager SecurityException");
        }
    }

    public boolean i() {
        return f5156g.isMusicActive();
    }

    public void j(int i10) {
        switch (i10) {
            case 52:
                int i11 = 126;
                if (i()) {
                    i11 = 127;
                }
                f(i11);
                return;
            case 53:
                f(87);
                return;
            case 54:
                f(88);
                return;
            default:
                return;
        }
    }
}
