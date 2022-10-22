package com.cardiex.arty.lite.networking;

import android.content.Context;
import com.cardiex.arty.lite.exceptions.APIConnectionException;
import com.cardiex.arty.lite.exceptions.APIException;
import com.cardiex.arty.lite.exceptions.AuthenticationException;
import com.cardiex.arty.lite.models.Pageable;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.ArtyLatest;
import com.cardiex.arty.lite.models.coach.ArtyTrend;
import com.cardiex.arty.lite.models.coach.ArtyType;
import com.cardiex.arty.lite.models.coach.Insight;
import com.cardiex.arty.lite.models.coach.SeenStatus;
import com.cardiex.arty.lite.models.dashboard.Dashboard;
import com.cardiex.arty.lite.models.event.Event;
import com.cardiex.arty.lite.models.profile.Profile;
import com.cardiex.arty.lite.models.push.AddPushRegistration;
import com.cardiex.arty.lite.models.push.PushRegistration;
import com.cardiex.arty.lite.models.social.Badge;
import com.cardiex.arty.lite.models.social.Friend;
import com.cardiex.arty.lite.models.social.Message;
import com.cardiex.arty.lite.utils.ArtyAuthenticationHeaderProvider;
import com.cardiex.arty.lite.utils.ExtensionsKt;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.providers.OtaColumn;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.a0;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.u;
import okhttp3.y;
import okhttp3.z;
import software.tingle.api.a;
import software.tingle.api.d;
/* compiled from: ArtyApiClient.kt */
/* loaded from: classes.dex */
public final class ArtyApiClient extends a {
    private final String baseUrl;
    private final boolean enableLogging;
    private final UserAgentInterceptor userAgentInterceptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtyApiClient(Context context, String accessToken, String baseUrl, boolean z10) {
        super(new ArtyAuthenticationHeaderProvider(context, baseUrl, accessToken, z10));
        i.f(context, "context");
        i.f(accessToken, "accessToken");
        i.f(baseUrl, "baseUrl");
        this.baseUrl = baseUrl;
        this.enableLogging = z10;
        this.userAgentInterceptor = new UserAgentInterceptor(context);
    }

    public static /* synthetic */ Object getInsights$default(ArtyApiClient artyApiClient, Pageable pageable, Date date, c cVar, int i10, Object obj) throws AuthenticationException, APIConnectionException, APIException {
        if ((i10 & 2) != 0) {
            date = null;
        }
        return artyApiClient.getInsights(pageable, date, cVar);
    }

    public final d<Object> addEventRecord(Event event) throws AuthenticationException, APIConnectionException, APIException {
        i.f(event, "event");
        return execute(new z.a().p(i.n(this.baseUrl, "/events")).l(a0.Companion.b(makeJson(event), a.Companion.a())), Object.class);
    }

    public final d<Object> addFriend(Message message) throws AuthenticationException, APIConnectionException, APIException {
        i.f(message, "message");
        return execute(new z.a().p(i.n(this.baseUrl, "/friends")).l(a0.Companion.b(makeJson(message), a.Companion.a())), Object.class);
    }

    public final d<PushRegistration> addPushDevice(AddPushRegistration registration) throws AuthenticationException, APIConnectionException, APIException {
        i.f(registration, "registration");
        return execute(new z.a().p(i.n(this.baseUrl, WearPath.Push.PUSH)).l(a0.Companion.b(makeJson(registration), a.Companion.a())), PushRegistration.class);
    }

    public final Object addUserProfile(Profile profile, c<? super d<Object>> cVar) throws AuthenticationException, APIConnectionException, APIException {
        return executeAsync(new z.a().p(i.n(this.baseUrl, "/profiles")).k(a0.Companion.b(makeJson(profile), a.Companion.a())), Object.class, cVar);
    }

    @Override // software.tingle.api.a
    protected y buildBackChannel(y.a builder) {
        i.f(builder, "builder");
        y.a g10 = builder.a(this.userAgentInterceptor).g(false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        g10.e(30L, timeUnit).M(30L, timeUnit).O(30L, timeUnit);
        if (this.enableLogging) {
            builder.a(new HttpLoggingInterceptor(null, 1, null).d(HttpLoggingInterceptor.Level.BODY));
        }
        return super.buildBackChannel(builder);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAdvice(Pageable pageable, c<? super d<Advice[]>> cVar) throws AuthenticationException, APIConnectionException, APIException {
        boolean z10;
        boolean s10;
        u.a a10 = u.f32275l.d(i.n(this.baseUrl, "/advice")).j().a("page", String.valueOf(pageable.getPage())).a(OtaColumn.COLUMN_SIZE, String.valueOf(pageable.getSize()));
        String sort = pageable.getSort();
        if (sort != null) {
            s10 = t.s(sort);
            if (!s10) {
                z10 = false;
                if (!z10) {
                    a10.a("sort", pageable.getSort());
                }
                return executeAsync(new z.a().q(a10.e()).g(), Advice[].class, cVar);
            }
        }
        z10 = true;
        if (!z10) {
        }
        return executeAsync(new z.a().q(a10.e()).g(), Advice[].class, cVar);
    }

    public final Object getArtyLatest(ArtyType artyType, c<? super d<ArtyLatest>> cVar) throws AuthenticationException, APIConnectionException, APIException {
        z.a aVar = new z.a();
        return executeAsync(aVar.p(this.baseUrl + "/components/" + artyType.name()).g(), ArtyLatest.class, cVar);
    }

    public final Object getArtyTrends(ArtyType artyType, c<? super d<ArtyTrend>> cVar) throws AuthenticationException, APIConnectionException, APIException {
        z.a aVar = new z.a();
        return executeAsync(aVar.p(this.baseUrl + "/components/" + artyType.name() + "/trends").g(), ArtyTrend.class, cVar);
    }

    public final Object getBadges(c<? super d<Badge[]>> cVar) throws AuthenticationException, APIConnectionException, APIException {
        return executeAsync(new z.a().p(i.n(this.baseUrl, "/badges")).g(), Badge[].class, cVar);
    }

    public final Object getDashboard(c<? super d<Dashboard>> cVar) throws AuthenticationException, APIConnectionException, APIException {
        return executeAsync(new z.a().p(i.n(this.baseUrl, "/dashboard")).g(), Dashboard.class, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d<Friend[]> getFriends(Pageable pageable) throws AuthenticationException, APIConnectionException, APIException {
        boolean z10;
        boolean s10;
        i.f(pageable, "pageable");
        u.a a10 = u.f32275l.d(i.n(this.baseUrl, "/friends")).j().a("page", String.valueOf(pageable.getPage())).a(OtaColumn.COLUMN_SIZE, String.valueOf(pageable.getSize()));
        String sort = pageable.getSort();
        if (sort != null) {
            s10 = t.s(sort);
            if (!s10) {
                z10 = false;
                if (!z10) {
                    a10.a("sort", pageable.getSort());
                }
                return execute(new z.a().q(a10.e()).g(), Friend[].class);
            }
        }
        z10 = true;
        if (!z10) {
        }
        return execute(new z.a().q(a10.e()).g(), Friend[].class);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getInsights(Pageable pageable, Date date, c<? super d<Insight[]>> cVar) throws AuthenticationException, APIConnectionException, APIException {
        boolean z10;
        boolean s10;
        u.a a10 = u.f32275l.d(i.n(this.baseUrl, "/insights")).j().a("page", String.valueOf(pageable.getPage())).a(OtaColumn.COLUMN_SIZE, String.valueOf(pageable.getSize()));
        String sort = pageable.getSort();
        if (sort != null) {
            s10 = t.s(sort);
            if (!s10) {
                z10 = false;
                if (!z10) {
                    a10.a("sort", pageable.getSort());
                }
                if (date != null) {
                    a10.a(ContactConstant.CallsRecordKeys.DATE, ExtensionsKt.toFormat$default(date, null, 1, null));
                }
                return executeAsync(new z.a().q(a10.e()).g(), Insight[].class, cVar);
            }
        }
        z10 = true;
        if (!z10) {
        }
        if (date != null) {
        }
        return executeAsync(new z.a().q(a10.e()).g(), Insight[].class, cVar);
    }

    public final d<Object> markAdviceSeen(String adviceId, SeenStatus seenStatus) throws AuthenticationException, APIConnectionException, APIException {
        i.f(adviceId, "adviceId");
        i.f(seenStatus, "seenStatus");
        z.a aVar = new z.a();
        return execute(aVar.p(this.baseUrl + "/advice/" + adviceId).k(a0.Companion.b(makeJson(seenStatus), a.Companion.a())), Object.class);
    }

    public final d<Object> markArticleSeen(String articleId, SeenStatus seenStatus) throws AuthenticationException, APIConnectionException, APIException {
        i.f(articleId, "articleId");
        i.f(seenStatus, "seenStatus");
        z.a aVar = new z.a();
        return execute(aVar.p(this.baseUrl + "/articles/" + articleId).k(a0.Companion.b(makeJson(seenStatus), a.Companion.a())), Object.class);
    }

    public final d<Object> markBadgeSeen(String badgeId, SeenStatus seenStatus) throws AuthenticationException, APIConnectionException, APIException {
        i.f(badgeId, "badgeId");
        i.f(seenStatus, "seenStatus");
        z.a aVar = new z.a();
        return execute(aVar.p(this.baseUrl + "/badges/" + badgeId).k(a0.Companion.b(makeJson(seenStatus), a.Companion.a())), Object.class);
    }

    public final d<Object> markFriendSeen(String friendId, SeenStatus seenStatus) throws AuthenticationException, APIConnectionException, APIException {
        i.f(friendId, "friendId");
        i.f(seenStatus, "seenStatus");
        z.a aVar = new z.a();
        return execute(aVar.p(this.baseUrl + "/friends/" + friendId).k(a0.Companion.b(makeJson(seenStatus), a.Companion.a())), Object.class);
    }

    public final d<Object> removeFriend(Message message) throws AuthenticationException, APIConnectionException, APIException {
        i.f(message, "message");
        return execute(new z.a().p(i.n(this.baseUrl, "/friends/remove")).l(a0.Companion.b(makeJson(message), a.Companion.a())), Object.class);
    }

    public final d<Object> sendApplause(Message message) throws AuthenticationException, APIConnectionException, APIException {
        i.f(message, "message");
        return execute(new z.a().p(i.n(this.baseUrl, "/applause")).l(a0.Companion.b(makeJson(message), a.Companion.a())), Object.class);
    }

    public final d<Object> sendHearts(Message message) throws AuthenticationException, APIConnectionException, APIException {
        i.f(message, "message");
        return execute(new z.a().p(i.n(this.baseUrl, "/hearts")).l(a0.Companion.b(makeJson(message), a.Companion.a())), Object.class);
    }

    public final d<Object> sendMessage(Message message) throws AuthenticationException, APIConnectionException, APIException {
        i.f(message, "message");
        return execute(new z.a().p(i.n(this.baseUrl, "/messages")).l(a0.Companion.b(makeJson(message), a.Companion.a())), Object.class);
    }

    public final d<Object> sendThumbsUp(Message request) throws AuthenticationException, APIConnectionException, APIException {
        i.f(request, "request");
        return execute(new z.a().p(i.n(this.baseUrl, "/thumbsups")).l(a0.Companion.b(makeJson(request), a.Companion.a())), Object.class);
    }

    public final d<Advice[]> markAdviceSeen(SeenStatus[] status) throws AuthenticationException, APIConnectionException, APIException {
        i.f(status, "status");
        return execute(new z.a().p(i.n(this.baseUrl, "/advice/update/bulk")).k(a0.Companion.b(makeJson(status), a.Companion.a())), Advice[].class);
    }

    public final d<Advice[]> markAdviceSeen(Date dateToConsider) throws AuthenticationException, APIConnectionException, APIException {
        i.f(dateToConsider, "dateToConsider");
        return execute(new z.a().q(u.f32275l.d(i.n(this.baseUrl, "/advice")).j().a("timeToConsider", ExtensionsKt.toFormat$default(dateToConsider, null, 1, null)).e()).k(a0.Companion.b(makeJson(null), a.Companion.a())), Advice[].class);
    }
}
