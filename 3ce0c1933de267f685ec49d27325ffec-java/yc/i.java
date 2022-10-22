package yc;

import android.content.Intent;
import com.cardiex.arty.lite.models.coach.Action;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.ArtyComponent;
import com.cardiex.arty.lite.models.coach.ArtyGraph;
import com.cardiex.arty.lite.models.coach.ArtyScore;
import com.cardiex.arty.lite.models.coach.ArtyType;
import com.cardiex.arty.lite.models.coach.Content;
import com.cardiex.arty.lite.models.coach.ContentType;
import com.cardiex.arty.lite.models.coach.Duration;
import com.cardiex.arty.lite.models.coach.GraphMode;
import com.cardiex.arty.lite.models.coach.ScoreType;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.R;
import com.mobvoi.companion.setting.CompanionSetting;
import gg.c;
import gg.e;
import io.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xc.l;
/* compiled from: ArtyCardRequestData.kt */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f36981a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static n f36982b = new n();

    /* renamed from: c  reason: collision with root package name */
    private static e f36983c = new e();

    /* compiled from: ArtyCardRequestData.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36984a;

        static {
            int[] iArr = new int[ContentType.values().length];
            iArr[ContentType.CHAT.ordinal()] = 1;
            iArr[ContentType.DATA.ordinal()] = 2;
            iArr[ContentType.GRAPH.ordinal()] = 3;
            iArr[ContentType.VIDEO.ordinal()] = 4;
            iArr[ContentType.COMPONENT.ordinal()] = 5;
            iArr[ContentType.ARTY_SCORE.ordinal()] = 6;
            iArr[ContentType.QUESTION.ordinal()] = 7;
            iArr[ContentType.IMAGE.ordinal()] = 8;
            f36984a = iArr;
        }
    }

    private i() {
    }

    private final ArtyComponent b(long j10, ArtyType artyType, ScoreType scoreType) {
        int i10;
        int i11;
        int i12;
        int i13;
        int a10 = com.mobvoi.companion.health.widget.arty.a.f17142a.a(artyType);
        List<c> list = f36982b.a().get(Long.valueOf(j10));
        if (list == null) {
            return new ArtyComponent(0L, artyType, ScoreType.POINT, Duration.DAY, 0.0d, 0.0d);
        }
        c cVar = list.get(a10);
        if (artyType == ArtyType.AGE) {
            gg.a aVar = (gg.a) cVar;
            ScoreType scoreType2 = ScoreType.POINT;
            if (scoreType != scoreType2 || ad.a.f168a.j()) {
                i12 = aVar.f27452h;
                i11 = aVar.f27457a;
            } else {
                i12 = aVar.f27455k;
                i11 = aVar.f27461e;
            }
            int i14 = i12 - i11;
            if (scoreType != scoreType2 || ad.a.f168a.j()) {
                i13 = aVar.f27457a;
            } else {
                i13 = aVar.f27461e;
            }
            return new ArtyComponent(aVar.f27462f, artyType, scoreType2, Duration.DAY, i13 + (i14 / 2.0f), i14);
        }
        ScoreType scoreType3 = ScoreType.POINT;
        if (scoreType == scoreType3) {
            i10 = cVar.f27461e;
        } else {
            i10 = cVar.f27457a;
        }
        return new ArtyComponent(cVar.f27462f, artyType, scoreType3, Duration.DAY, i10, 0.0d);
    }

    private final ArtyGraph c(ArtyType artyType) {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        while (true) {
            int i11 = i10 + 1;
            long c10 = f36982b.c() - (86400000 * i10);
            List<c> list = f36982b.a().get(Long.valueOf(c10));
            ScoreType scoreType = i10 == 1 ? ScoreType.POINT : ScoreType.AVERAGE;
            if (list != null) {
                arrayList.add(b(c10, artyType, scoreType));
            } else {
                arrayList.add(new ArtyComponent(c10, artyType, ScoreType.AVERAGE, Duration.DAY, 0.0d, 0.0d));
            }
            if (i11 > 7) {
                return new ArtyGraph(GraphMode.BAR, artyType, arrayList);
            }
            i10 = i11;
        }
    }

    private final ArtyScore d() {
        long b10 = f36982b.b();
        ArtyType artyType = ArtyType.ARTY;
        ScoreType scoreType = ScoreType.POINT;
        ArtyComponent b11 = b(b10, artyType, scoreType);
        return new ArtyScore(b11.getTimestamp(), b11, b(f36982b.b(), ArtyType.TRU_HR, scoreType), b(f36982b.b(), ArtyType.E_CAP, scoreType), b(f36982b.b(), ArtyType.HSX, scoreType), b(f36982b.b(), ArtyType.AGE, scoreType), 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    private final zc.a e(int i10, String str, Object obj) {
        zc.a aVar = new zc.a();
        aVar.d(i10);
        aVar.e(str);
        aVar.f(obj);
        return aVar;
    }

    private final ArtyComponent f(ArtyComponent artyComponent) {
        ArtyType artyType = artyComponent == null ? null : artyComponent.getArtyType();
        if (artyType == null) {
            return null;
        }
        return b(f36982b.b(), artyType, ScoreType.POINT);
    }

    private final ArtyGraph g(ArtyGraph artyGraph) {
        ArtyType artyType = artyGraph == null ? null : artyGraph.getArtyType();
        if (artyType == null) {
            return null;
        }
        return c(artyType);
    }

    private final void i() {
        f36982b.f(eg.c.b(System.currentTimeMillis()) + 86400000);
        long c10 = f36982b.c() - 604800000;
        n nVar = f36982b;
        Map<Long, List<c>> u10 = f36983c.u(c10, nVar.c());
        kotlin.jvm.internal.i.e(u10, "mArtyDataViewModel.getFewDayArtyData(fromTime, mArtyWeekData.toTime)");
        nVar.d(u10);
        Iterator<T> it = f36982b.a().entrySet().iterator();
        while (it.hasNext()) {
            long longValue = ((Number) ((Map.Entry) it.next()).getKey()).longValue();
            if (f36982b.b() < longValue) {
                f36982b.e(longValue);
            }
        }
    }

    private final void j(Content content, boolean z10, List<zc.a> list) {
        switch (a.f36984a[content.getType().ordinal()]) {
            case 1:
                list.add(e(6, "view_head_image", null));
                if (z10) {
                    list.add(e(2, "view_tips", content.getValue()));
                    return;
                } else {
                    list.add(e(7, "view_tips", content.getValue()));
                    return;
                }
            case 2:
                ArtyComponent f10 = f(content.getArtyComponent());
                if (f10 != null) {
                    list.add(f36981a.e(4, "view_component", f10));
                }
                ArtyGraph g10 = g(content.getArtyGraph());
                if (g10 != null) {
                    list.add(f36981a.e(5, "view_graph", g10));
                    return;
                }
                return;
            case 3:
                list.add(e(6, "view_head_image", null));
                ArtyGraph g11 = g(content.getArtyGraph());
                if (g11 != null) {
                    list.add(f36981a.e(5, "view_graph", g11));
                    return;
                }
                return;
            case 4:
                list.add(e(6, "view_head_image", null));
                list.add(e(1, "view_video", content.getVideo()));
                return;
            case 5:
                list.add(e(6, "view_head_image", null));
                ArtyComponent f11 = f(content.getArtyComponent());
                if (f11 != null) {
                    list.add(f36981a.e(1, "view_component", f11));
                    return;
                }
                return;
            case 6:
                list.add(e(6, "view_head_image", null));
                list.add(e(2, "view_sub_component", d()));
                return;
            case 7:
                list.add(e(6, "view_head_image", null));
                list.add(e(2, "view_tips", content.getQuestion()));
                list.add(e(3, "view_answer", content.getQuestion()));
                return;
            case 8:
                list.add(e(3, "view_bottom_image", content.getImage()));
                return;
            default:
                return;
        }
    }

    private final boolean k(Content content, Content content2) {
        m mVar;
        if (content == null) {
            return false;
        }
        if (content2 == null) {
            mVar = null;
        } else if (content.getType() == ContentType.ARTY_SCORE && content2.getType() == ContentType.DATA) {
            return true;
        } else {
            ContentType type = content.getType();
            ContentType contentType = ContentType.CHAT;
            if (type == contentType && content2.getType() == ContentType.DATA) {
                return true;
            }
            if (content.getType() == contentType && content2.getType() == ContentType.IMAGE) {
                return true;
            }
            mVar = m.f28349a;
        }
        return mVar == null && (content.getType() == ContentType.CHAT || content.getType() == ContentType.COMPONENT);
    }

    public final tc.i a(Advice[] result) {
        kotlin.jvm.internal.i.f(result, "result");
        int length = result.length;
        int i10 = 0;
        int i11 = 0;
        while (i11 < length) {
            Advice advice = result[i11];
            i11++;
            k.h("ArtyCardRequestData", kotlin.jvm.internal.i.n("MINOSTEST onSuccess advice.primary = ", advice.getPrimary()));
            k.h("ArtyCardRequestData", kotlin.jvm.internal.i.n("MINOSTEST onSuccess advice.secondary = ", advice.getSecondary()));
        }
        boolean z10 = true;
        if (!(!(result.length == 0))) {
            return null;
        }
        c cVar = new c();
        cVar.e(new ArrayList());
        Advice advice2 = result[0];
        Content primary = advice2.getPrimary();
        Content secondary = advice2.getSecondary();
        if (!k(primary, secondary)) {
            return null;
        }
        if (primary != null) {
            String bin = primary.getBin();
            if (!(bin == null || bin.length() == 0)) {
                Intent intent = new Intent("com.mobvoi.action.notification.bin");
                intent.putExtra("extra.notification", bin);
                intent.putExtra("extra.notification_id", result[0].getId());
                b1.a.b(b.e()).d(intent);
            }
            cVar.f(primary.getAction());
            cVar.d(advice2);
            List<zc.a> b10 = cVar.b();
            if (b10 != null) {
                if (secondary != null) {
                    f36981a.j(secondary, true, b10);
                } else {
                    z10 = false;
                }
                f36981a.j(primary, z10, b10);
            }
        }
        tc.i iVar = new tc.i(2, "CARD_ARTY_REPORT");
        Integer a10 = iVar.a();
        if (a10 != null) {
            i10 = a10.intValue();
        }
        iVar.f(new l(cVar, i10));
        return iVar;
    }

    public final c h() {
        c cVar = new c();
        cVar.e(new ArrayList());
        if (!CompanionSetting.getArtyGuidePageShowFinished()) {
            List<zc.a> b10 = cVar.b();
            if (b10 != null) {
                b10.add(e(1, "view_guide", null));
            }
            return cVar;
        }
        List<zc.a> b11 = cVar.b();
        if (b11 != null && b11.size() <= 0) {
            i iVar = f36981a;
            iVar.i();
            if (f36982b.a().get(Long.valueOf(f36982b.b())) != null) {
                cVar.f(Action.DASHBOARD);
                ArtyType artyType = ArtyType.ARTY;
                ArtyGraph c10 = iVar.c(artyType);
                ArtyComponent b12 = iVar.b(f36982b.b(), artyType, ScoreType.POINT);
                ArtyScore d10 = iVar.d();
                b11.add(iVar.e(6, "view_head_image", null));
                b11.add(iVar.e(2, "view_sub_component", d10));
                b11.add(iVar.e(4, "view_component", b12));
                b11.add(iVar.e(5, "view_graph", c10));
            } else {
                cVar.f(Action.TAKE_READING);
                String string = b.e().getString(R.string.arty_tips_take_reading);
                kotlin.jvm.internal.i.e(string, "context.getString(R.string.arty_tips_take_reading)");
                b11.add(iVar.e(6, "view_head_image", null));
                b11.add(iVar.e(2, "view_tips", string));
                b11.add(iVar.e(3, "view_take_reading", null));
            }
        }
        return cVar;
    }
}
