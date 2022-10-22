package lf;

import android.content.res.Resources;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.wear.util.UnitsUtility;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import ue.b;
/* compiled from: UnitsUtil.java */
/* loaded from: classes2.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnitsUtil.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30467a;

        static {
            int[] iArr = new int[SportDataType.values().length];
            f30467a = iArr;
            try {
                iArr[SportDataType.Duration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30467a[SportDataType.Distance.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30467a[SportDataType.HeartRate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30467a[SportDataType.MaxHeartRate.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30467a[SportDataType.Calorie.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30467a[SportDataType.Speed.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30467a[SportDataType.MaxSpeed.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30467a[SportDataType.Pace.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30467a[SportDataType.MaxPace.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f30467a[SportDataType.Steps.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f30467a[SportDataType.Group.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f30467a[SportDataType.SwimTrips.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f30467a[SportDataType.StrideFreq.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f30467a[SportDataType.MaxStrideFreq.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f30467a[SportDataType.SwimDistance.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f30467a[SportDataType.SwimTypeDistance.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f30467a[SportDataType.SwimPoolLength.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f30467a[SportDataType.SwimStroke.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f30467a[SportDataType.Elevation.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f30467a[SportDataType.MinElevation.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f30467a[SportDataType.MaxElevation.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f30467a[SportDataType.CumulativeDown.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f30467a[SportDataType.CumulativeUp.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f30467a[SportDataType.Vo2Max.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f30467a[SportDataType.SportActionTimes.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f30467a[SportDataType.HiitTypeTimes.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f30467a[SportDataType.AiScore.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f30467a[SportDataType.SwimPace.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f30467a[SportDataType.Stride.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f30467a[SportDataType.Unknown.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
        }
    }

    public static String a(Resources resources, boolean z10, SportDataType sportDataType) {
        String string;
        if (sportDataType == null) {
            return "";
        }
        switch (a.f30467a[sportDataType.ordinal()]) {
            case 1:
                return resources.getString(b.f35405v);
            case 2:
                if (!z10) {
                    string = resources.getString(b.f35390g);
                    break;
                } else {
                    string = resources.getString(b.f35391h);
                    break;
                }
            case 3:
            case 4:
                return resources.getString(b.f35395l);
            case 5:
                return resources.getString(b.f35389f);
            case 6:
            case 7:
                if (!z10) {
                    string = resources.getString(b.f35398o);
                    break;
                } else {
                    string = resources.getString(b.f35399p);
                    break;
                }
            case 8:
            case 9:
                if (!z10) {
                    string = resources.getString(b.f35396m);
                    break;
                } else {
                    string = resources.getString(b.f35397n);
                    break;
                }
            case 10:
                return resources.getString(b.f35400q);
            case 11:
                return resources.getString(b.f35394k);
            case 12:
                return resources.getString(b.f35404u);
            case 13:
            case 14:
                return resources.getString(b.f35401r);
            case 15:
            case 16:
            case 17:
                return resources.getString(b.f35402s);
            case 18:
                return resources.getString(b.f35403t);
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                if (!z10) {
                    string = resources.getString(b.f35392i);
                    break;
                } else {
                    string = resources.getString(b.f35393j);
                    break;
                }
            case 24:
                return resources.getString(b.f35407x);
            case 25:
            case 26:
                return resources.getString(b.f35406w);
            default:
                return "";
        }
        return string;
    }

    private static boolean b(SportDataType sportDataType, float f10) {
        if (sportDataType == null) {
            return false;
        }
        return (sportDataType == SportDataType.Elevation || sportDataType == SportDataType.MinElevation || sportDataType == SportDataType.MaxElevation || sportDataType == SportDataType.CumulativeDown || sportDataType == SportDataType.CumulativeUp) && (f10 > 1.07374182E9f || f10 < -1.07374182E9f);
    }

    public static long c(long j10) {
        long j11 = j10 / 1000;
        if (j11 <= 0) {
            return 0L;
        }
        if (j11 < 60) {
            return 1L;
        }
        return (j11 + 30) / 60;
    }

    public static String d(SportDataType sportDataType, float f10, boolean z10) {
        if (b(sportDataType, f10)) {
            return "-";
        }
        float f11 = f(sportDataType, f10, z10);
        if (sportDataType == null) {
            return "-";
        }
        if (sportDataType != SportDataType.Elevation && f11 < 0.0f) {
            return "-";
        }
        int i10 = a.f30467a[sportDataType.ordinal()];
        if (i10 == 1) {
            return String.format(Locale.US, "%.0f", Double.valueOf(Math.ceil(f11 / 60.0f)));
        }
        String str = "%.2f";
        if (i10 == 2 || i10 == 6) {
            Locale locale = Locale.US;
            if (f11 > 10.0f) {
                str = "%.1f";
            }
            return String.format(locale, str, Float.valueOf(f11));
        }
        if (i10 != 8) {
            if (i10 == 15 || i10 == 16) {
                return String.format(Locale.US, "%d", Integer.valueOf((int) f11));
            }
            switch (i10) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    return (f11 == 2.14748365E9f || f11 == -2.14748365E9f) ? "-" : String.valueOf(Math.round(f11));
                default:
                    switch (i10) {
                        case 27:
                            return String.format(Locale.US, "%.1f", Float.valueOf(f11));
                        case 28:
                            break;
                        case 29:
                            return String.format(Locale.US, str, Float.valueOf(f11));
                        case 30:
                            return "-";
                        default:
                            return String.valueOf(Math.round(f11));
                    }
            }
        }
        if (f11 >= 6000.0f) {
            return "-";
        }
        int i11 = (int) (f11 / 60.0f);
        return String.format(Locale.US, "%d'%d''", Integer.valueOf(i11), Integer.valueOf(Math.round(f11 - (i11 * 60))));
    }

    public static String e(long j10, boolean z10) {
        if (j10 <= 0) {
            return z10 ? "00:00" : "0:00:00";
        }
        int s2h = (int) UnitsUtility.Time.s2h((float) (j10 / 1000));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(z10 ? s2h > 0 ? "HH:mm" : "mm:ss" : "H:mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String format = simpleDateFormat.format(Long.valueOf(j10));
        if (s2h <= 24) {
            return format;
        }
        return s2h + format.substring(2);
    }

    public static float f(SportDataType sportDataType, float f10, boolean z10) {
        if (sportDataType == null) {
            return f10;
        }
        if (sportDataType != SportDataType.Elevation && f10 < 0.0f) {
            return f10;
        }
        int i10 = a.f30467a[sportDataType.ordinal()];
        if (i10 == 1) {
            return f10 / 1000.0f;
        }
        if (i10 == 2) {
            return z10 ? UnitsUtility.Length.m2mile(f10) : UnitsUtility.Length.m2km(f10);
        }
        if (i10 == 6) {
            return z10 ? UnitsUtility.Speed.mPs2milePh(f10) : UnitsUtility.Speed.mPs2kmPh(f10);
        }
        if (i10 != 8) {
            switch (i10) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    return z10 ? UnitsUtility.Length.m2ft(f10) : f10;
                default:
                    return f10;
            }
        } else {
            if (1.0f / f10 < 0.42f) {
                f10 = 0.0f;
            }
            return z10 ? UnitsUtility.Pace.sPm2sPmile(f10) : UnitsUtility.Pace.sPm2sPkm(f10);
        }
    }
}
