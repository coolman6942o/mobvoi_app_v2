package cn.com.fmsh.tsm.business.exception;

import androidx.recyclerview.widget.g;
import cn.com.fmsh.FM_Exception;
import com.realsil.sdk.dfu.DfuException;
import x2.b;
import x2.c;
import x2.d;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
/* loaded from: classes.dex */
public class BusinessException extends FM_Exception {
    private static final /* synthetic */ long serialVersionUID = 1392832484088949611L;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ErrorMessage f6236a;

    /* JADX WARN: Init of enum OT_AC_REQUEST_NOTICE can be incorrect */
    /* JADX WARN: Init of enum OT_APPLY_SIR_FAIL can be incorrect */
    /* JADX WARN: Init of enum OT_BUSY can be incorrect */
    /* JADX WARN: Init of enum OT_CHECK_FAIL can be incorrect */
    /* JADX WARN: Init of enum OT_STATE_CHANGE_NOTICE can be incorrect */
    /* JADX WARN: Init of enum ack_card_app_order_fail can be incorrect */
    /* JADX WARN: Init of enum ack_card_app_unorder_fail can be incorrect */
    /* JADX WARN: Init of enum ack_card_app_unpersonal can be incorrect */
    /* JADX WARN: Init of enum ack_card_app_unprepare can be incorrect */
    /* JADX WARN: Init of enum app_issuer_fail can be incorrect */
    /* JADX WARN: Init of enum business_1920_unknow can be incorrect */
    /* JADX WARN: Init of enum business_business_no_support can be incorrect */
    /* JADX WARN: Init of enum business_business_stop can be incorrect */
    /* JADX WARN: Init of enum business_business_will_exist can be incorrect */
    /* JADX WARN: Init of enum business_interface_version_error can be incorrect */
    /* JADX WARN: Init of enum business_invalid_message_format can be incorrect */
    /* JADX WARN: Init of enum business_invalid_message_length can be incorrect */
    /* JADX WARN: Init of enum business_invalid_message_type can be incorrect */
    /* JADX WARN: Init of enum business_invalid_terminal can be incorrect */
    /* JADX WARN: Init of enum business_merchants_not_exist can be incorrect */
    /* JADX WARN: Init of enum business_message_check_fail can be incorrect */
    /* JADX WARN: Init of enum business_message_invalid_serial can be incorrect */
    /* JADX WARN: Init of enum business_operate_timeout can be incorrect */
    /* JADX WARN: Init of enum business_order_amount_inconsistent can be incorrect */
    /* JADX WARN: Init of enum business_order_apply_no_pay can be incorrect */
    /* JADX WARN: Init of enum business_order_apply_refund can be incorrect */
    /* JADX WARN: Init of enum business_order_card_no_inconsistent can be incorrect */
    /* JADX WARN: Init of enum business_order_codenot_exist can be incorrect */
    /* JADX WARN: Init of enum business_order_invoice can be incorrect */
    /* JADX WARN: Init of enum business_order_no_invoice can be incorrect */
    /* JADX WARN: Init of enum business_order_no_refund can be incorrect */
    /* JADX WARN: Init of enum business_order_not_exist can be incorrect */
    /* JADX WARN: Init of enum business_order_pay_no_write can be incorrect */
    /* JADX WARN: Init of enum business_order_paying can be incorrect */
    /* JADX WARN: Init of enum business_order_recharge_sucess can be incorrect */
    /* JADX WARN: Init of enum business_order_recharget_fail can be incorrect */
    /* JADX WARN: Init of enum business_order_rechargeting can be incorrect */
    /* JADX WARN: Init of enum business_order_refund can be incorrect */
    /* JADX WARN: Init of enum business_order_unsettled_exist can be incorrect */
    /* JADX WARN: Init of enum business_platform_busy can be incorrect */
    /* JADX WARN: Init of enum business_repeat_message can be incorrect */
    /* JADX WARN: Init of enum business_serial_not_exist can be incorrect */
    /* JADX WARN: Init of enum business_system_error can be incorrect */
    /* JADX WARN: Init of enum business_system_unknow_error can be incorrect */
    /* JADX WARN: Init of enum business_trade_timeout can be incorrect */
    /* JADX WARN: Init of enum business_unsettled_overrun can be incorrect */
    /* JADX WARN: Init of enum card_invaild_check can be incorrect */
    /* JADX WARN: Init of enum card_not_order can be incorrect */
    /* JADX WARN: Init of enum card_order_by_other can be incorrect */
    /* JADX WARN: Init of enum invaild_personalization_info can be incorrect */
    /* JADX WARN: Init of enum local_apdu_reponse_invalid can be incorrect */
    /* JADX WARN: Init of enum local_app_config_invaild_content can be incorrect */
    /* JADX WARN: Init of enum local_app_load_config_fail can be incorrect */
    /* JADX WARN: Init of enum local_app_query_app_no_fail can be incorrect */
    /* JADX WARN: Init of enum local_app_query_server_fail can be incorrect */
    /* JADX WARN: Init of enum local_business_apdu_handler_busying can be incorrect */
    /* JADX WARN: Init of enum local_business_apdu_handler_null can be incorrect */
    /* JADX WARN: Init of enum local_business_cancel can be incorrect */
    /* JADX WARN: Init of enum local_business_execute_fail can be incorrect */
    /* JADX WARN: Init of enum local_business_init_fail can be incorrect */
    /* JADX WARN: Init of enum local_business_local_data_handler_null can be incorrect */
    /* JADX WARN: Init of enum local_business_no_card_app_type can be incorrect */
    /* JADX WARN: Init of enum local_business_para_error can be incorrect */
    /* JADX WARN: Init of enum local_communication_connect_fail can be incorrect */
    /* JADX WARN: Init of enum local_communication_connect_param_error can be incorrect */
    /* JADX WARN: Init of enum local_communication_disconnect_fail can be incorrect */
    /* JADX WARN: Init of enum local_communication_invalid_control can be incorrect */
    /* JADX WARN: Init of enum local_communication_invalid_direction can be incorrect */
    /* JADX WARN: Init of enum local_communication_invalid_format can be incorrect */
    /* JADX WARN: Init of enum local_communication_invalid_response can be incorrect */
    /* JADX WARN: Init of enum local_communication_invalid_session can be incorrect */
    /* JADX WARN: Init of enum local_communication_invalid_session_serial can be incorrect */
    /* JADX WARN: Init of enum local_communication_invalid_verify can be incorrect */
    /* JADX WARN: Init of enum local_communication_invalid_version can be incorrect */
    /* JADX WARN: Init of enum local_communication_no_key can be incorrect */
    /* JADX WARN: Init of enum local_communication_no_response can be incorrect */
    /* JADX WARN: Init of enum local_communication_register_notify_exception can be incorrect */
    /* JADX WARN: Init of enum local_communication_request_param_error can be incorrect */
    /* JADX WARN: Init of enum local_communication_sign_in_fail can be incorrect */
    /* JADX WARN: Init of enum local_communication_sign_out_fail can be incorrect */
    /* JADX WARN: Init of enum local_get_app_info_fail can be incorrect */
    /* JADX WARN: Init of enum local_get_app_info_no_sptcc can be incorrect */
    /* JADX WARN: Init of enum local_message_apdu_execute_exception can be incorrect */
    /* JADX WARN: Init of enum local_message_command_data_invaild can be incorrect */
    /* JADX WARN: Init of enum local_message_load_config_fail can be incorrect */
    /* JADX WARN: Init of enum local_message_message_handle_exception can be incorrect */
    /* JADX WARN: Init of enum local_message_open_mobile_exception can be incorrect */
    /* JADX WARN: Init of enum local_message_platform_business_handle_fail can be incorrect */
    /* JADX WARN: Init of enum no_activity can be incorrect */
    /* JADX WARN: Init of enum no_suppert_in_card can be incorrect */
    /* JADX WARN: Init of enum no_suppert_out_card can be incorrect */
    /* JADX WARN: Init of enum not_support_retrieve_email can be incorrect */
    /* JADX WARN: Init of enum sptc_app_not_issuer can be incorrect */
    /* JADX WARN: Init of enum sptc_close_exception can be incorrect */
    /* JADX WARN: Init of enum sptc_data_not_matching can be incorrect */
    /* JADX WARN: Init of enum sptc_open_exception can be incorrect */
    /* JADX WARN: Init of enum sptc_personalization can be incorrect */
    /* JADX WARN: Init of enum sptc_personalization_fail can be incorrect */
    /* JADX WARN: Init of enum trade_act_check_fail can be incorrect */
    /* JADX WARN: Init of enum trade_act_used can be incorrect */
    /* JADX WARN: Init of enum trade_fail can be incorrect */
    /* JADX WARN: Init of enum trade_handling can be incorrect */
    /* JADX WARN: Init of enum trade_not_exist can be incorrect */
    /* JADX WARN: Init of enum trade_sucess can be incorrect */
    /* JADX WARN: Init of enum user_auth_code_expire can be incorrect */
    /* JADX WARN: Init of enum user_auth_code_invalid can be incorrect */
    /* JADX WARN: Init of enum user_auth_code_mobile_invalid can be incorrect */
    /* JADX WARN: Init of enum user_auth_code_type_invalid can be incorrect */
    /* JADX WARN: Init of enum user_freeze can be incorrect */
    /* JADX WARN: Init of enum user_get_password_count_exceed can be incorrect */
    /* JADX WARN: Init of enum user_id_not_matching can be incorrect */
    /* JADX WARN: Init of enum user_incorrect_password can be incorrect */
    /* JADX WARN: Init of enum user_info_incomplete can be incorrect */
    /* JADX WARN: Init of enum user_locked can be incorrect */
    /* JADX WARN: Init of enum user_logout can be incorrect */
    /* JADX WARN: Init of enum user_not_login can be incorrect */
    /* JADX WARN: Init of enum user_not_sign can be incorrect */
    /* JADX WARN: Init of enum user_order_fail can be incorrect */
    /* JADX WARN: Init of enum user_order_invaild_info can be incorrect */
    /* JADX WARN: Init of enum user_order_no_open can be incorrect */
    /* JADX WARN: Init of enum user_order_open can be incorrect */
    /* JADX WARN: Init of enum user_register can be incorrect */
    /* JADX WARN: Init of enum user_severance can be incorrect */
    /* JADX WARN: Init of enum user_sign_apply can be incorrect */
    /* JADX WARN: Init of enum user_sign_fail can be incorrect */
    /* JADX WARN: Init of enum user_sign_sucess can be incorrect */
    /* JADX WARN: Init of enum user_unregistered can be incorrect */
    /* JADX WARN: Init of enum user_unsubscribe_closed can be incorrect */
    /* JADX WARN: Init of enum user_unsubscribe_fail can be incorrect */
    /* loaded from: classes.dex */
    public enum ErrorMessage {
        local_business_cancel(r3, r13, x2.a.b("么勿奎琐迅稅乷ｊ揷攨刺叀涊捉亾", 2, 108)),
        local_business_apdu_handler_null(e.a(166, "\".16"), r13, g.a(1, 60, "\u0010]\rP捆仹奝琓嘹朧没冉")),
        local_business_execute_fail(FM_Exception.insert(4, 48, "1(x+"), r13, f.a("C\u000f\u0018\f捑亷奔瑋嘢奃瑂\u0000\u000e\u001f\r订氐奾赩", g.f.DEFAULT_SWIPE_ANIMATION_DURATION)),
        local_business_init_fail(h.e("`=q!", 124, 52), r13, x2.a.b("乔勭奎瑎嘮剙妉卖夯费", 94, 126)),
        local_business_no_card_app_type(f.a("3744", 2), r13, h.e("沶朝宨廚籰垃盁匣", 154, 29)),
        local_business_apdu_handler_busying(h.e("f//i", 2, 32), r13, b.b(4, "PLCG挚京套瑘嘡欷徆")),
        local_message_platform_business_handle_fail(f.a("3746", 2), r13, f.a("幾叺夃琂丛勿奪赽", 5)),
        local_business_local_data_handler_null(f.a("#'$)", 306), r13, d.c("杴坹攪挥夘琋噶丵空", 5)),
        local_business_para_error(x2.g.a(308, 21, "=)~z"), r13, FM_Exception.insert(5, 80, "凴攩谊畱斿５压敩弋幡")),
        local_communication_connect_fail(d.c("owiy", 3), r13, f.a("绅童咋幷叱盚钥揽奤起", 5)),
        local_communication_connect_param_error(b.b(118, ":>(5"), r13, f.a("终窲呋帤厤钯揫讼氊斳ｎ使儹盝帥厣钮揨侫怨斤攉", 248)),
        local_communication_disconnect_fail(e.a(6, "bn06"), r13, d.c("纅窱儼閭刡绊竼皀钫揣冭珸弛帲", g.f.DEFAULT_SWIPE_ANIMATION_DURATION)),
        local_communication_sign_in_fail(f.a("4:67", 5), r13, f.a("组竦筸刳失赸", 4)),
        local_communication_request_param_error(x2.a.b("hu(y", 1, 84), r13, x2.a.b("纙窶吐幺叡七加课汓旯ｍ纁窾捞亥斩攙", 1, 8)),
        local_communication_no_response(c.i("c/5~", 3, 69), r13, e.a(2, "纟窵杷收刳幵叹皈庛筆敥捶")),
        local_communication_invalid_version(e.a(60, "($&\""), r13, c.i("纓窶遍侴卖盕爇条斫攁", 4, 126)),
        local_communication_invalid_format(x2.a.b("l6f1", 5, 49), r13, d.c("统竧议氈攫挢校弁旿敘", 164)),
        local_communication_invalid_verify(h.e("~51q", 330, 94), r13, e.a(106, "拺旅梅髄奺赫")),
        local_communication_invalid_control(e.a(132, "`lm3"), r13, FM_Exception.insert(4, 86, "旨攖皐抯旇掱刺嬕")),
        local_communication_invalid_session(x2.a.b("h&)r", 1, 37), r13, x2.g.a(5, 53, "斵敂盛伎讔")),
        local_communication_invalid_session_serial(FM_Exception.insert(1, 113, "<fuk"), r13, c.i("佁试浔氶锖诳", 4, 13)),
        local_communication_invalid_direction(FM_Exception.insert(108, 82, "ir&r"), r13, f.a("伐诚浅氵镇讴", 2)),
        local_communication_invalid_response(b.b(2, "6*7%"), r13, x2.a.b("递诳庄筐攨换无攜", DfuException.ERROR_ENTER_OTA_MODE_FAILED, 84)),
        local_communication_no_key(f.a("2875", 3), r13, FM_Exception.insert(86, 64, "遀俻斬６杰扤乗刪遀俻儶钿")),
        local_communication_sign_out_fail(d.c(",6%0", 194), r13, d.c("笱遀奠赧", 124)),
        local_communication_register_notify_exception(h.e("99!+", 3, 9), r13, x2.g.a(5, 51, "遏俩淓恡奅瑒噯沲冁彂幫")),
        local_message_load_config_fail(e.a(100, "`ljr"), r13, x2.g.a(172, 15, "劼轶W,+47bq酎罼旆亦奮赫")),
        local_message_command_data_invaild(c.i("ad%=", 1, 92), r13, c.i("早敎皇平厭咗廃攤挿", 146, 125)),
        local_message_apdu_execute_exception(c.i("cz/y", 3, 80), r13, e.a(4, "\u0018\f\u001bW挂们扬衂弓帬")),
        local_message_message_handle_exception(b.b(DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, "*.< "), r13, b.b(4, "\\yta|/6奚瑏冮珯弈席")),
        local_message_open_mobile_exception(FM_Exception.insert(192, 45, "}a+~"), r13, e.a(162, "Xjxn#kfnf~p凢玫弜幹")),
        local_get_app_info_fail(x2.g.a(344, 30, "qv<2"), r13, FM_Exception.insert(236, 75, "菧反卧乛庈畯俳怲她贶")),
        local_apdu_reponse_invalid(e.a(4, "`lg3"), r13, e.a(138, ">ra}挌仪皕哙広旺敕")),
        local_get_app_info_no_sptcc(FM_Exception.insert(4, 58, "1rd$"), r13, e.a(5, "乗晲上浴亢逓卭")),
        local_app_load_config_fail(h.e(":-`!", 6, 58), r13, c.i("乂励酅缮旟亦动载天赵", 1, 24)),
        local_app_config_invaild_content(e.a(2, "njj1"), r13, h.e("久勪酚缭斈亭凂宪斿敃", 2, 76)),
        local_app_query_app_no_fail(x2.a.b("my)a", 4, 85), r13, FM_Exception.insert(5, 58, "绁窬菪叁匰皏廑男廖刄厺夶赤")),
        local_app_query_server_fail(x2.a.b("h3b4", 1, 50), r13, d.c("桸捼栺捺丟勷侦怷菾双徎讣闣盚帼厰奠赧", 206)),
        business_order_codenot_exist(r55, r8, d.c("仱晕亴硉且孒圳", 2)),
        business_invalid_message_format(f.a("*'$#", 146), r8, FM_Exception.insert(288, 111, "抡斔栾彞镙讠")),
        business_invalid_message_type(FM_Exception.insert(6, 96, ":zz9"), r8, e.a(5, "斺攕的涋恩籲垇")),
        business_message_check_fail(e.a(38, "+.10"), r8, FM_Exception.insert(DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES, 62, "抵旉棌髆夹赣")),
        business_business_no_support(x2.a.b("bip2", 2, 103), r8, x2.g.a(3, 35, "讶丌劸曞乒攭捄")),
        business_platform_busy(f.a(";854", 3), r8, h.e("糢纖忀e议稄偀冄诌", 316, 48)),
        business_invalid_terminal(b.b(60, "ydo}"), r8, x2.a.b("戝杸细竵叱斲攖", 102, 108)),
        business_operate_timeout(x2.g.a(2, 33, "b#$m"), r8, h.e("撒伝趆斳＋设釆旽癴弄", 2, 66)),
        business_repeat_message(e.a(DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR, "o248"), r8, x2.a.b("釟夏南", 34, 112)),
        business_message_invalid_serial(d.c("hykz", 5), r8, x2.a.b("南庐剛厮下辍续", 2, 45)),
        business_serial_not_exist(f.a(":753", 2), r8, f.a("厒绂竨亠昒洟汯厯乘嬊坧", 5)),
        business_system_error(h.e("%;0c", 152, 118), r8, h.e("糾细锔诮", 168, 116)),
        business_invalid_message_length(d.c("hyk~", 5), r8, h.e("抧斈镣庯锏讬", 5, 13)),
        business_trade_timeout(f.a(";844", 3), r8, e.a(5, "仾晎超旵")),
        business_1920_unknow(f.a("853(", 32), r8, e.a(5, "kd23本矬锕诠")),
        business_interface_version_error(f.a(";84:", 3), r8, f.a("丐劦採叢爖杷镁论", 2)),
        business_merchants_not_exist(x2.a.b("dyoj", 4, 117), r8, b.b(302, "啝扱乜嬄坯")),
        business_business_stop(h.e("1k'?", 4, 90), r8, d.c("审讬唜扼差偑歼朂务", 5)),
        business_business_will_exist(f.a("<942", 4), r8, e.a(3, "乂勺匭將掬函＆尰诧朌従")),
        business_system_unknow_error(FM_Exception.insert(296, 54, "<r!w"), r8, d.c("粯纚杼瞢锁详", 1)),
        OT_CHECK_FAIL(h.e(",wd2", 156, 46), r8, b.b(214, "廗畦寐裁凉夝朩圠赟桺寰枹奶起")),
        OT_APPLY_SIR_FAIL(f.a("8:66", 5), r8, x2.a.b("呂歧贐爣甴讣杌劯寅侃彀番司ｔz?1９奬贯", 3, 77)),
        OT_STATE_CHANGE_NOTICE(x2.g.a(5, 16, "`5$6"), r8, f.a("名款贋牪叁赺朇劦犲怀历暯遂瞰奣赪", DfuException.ERROR_REQUEST_MTU_NO_CALLBACK)),
        OT_AC_REQUEST_NOTICE(FM_Exception.insert(2, 56, "3.g:"), r8, d.c("呅止赋爾叉赾搠席\u001d\u000e覚剖盄弓歧朞劥邽缴讠氊夨贯", 1)),
        OT_BUSY(h.e("fmi`", 2, 126), r8, f.a("ES幷叱欽坳奜瑓寛袊冊奎", 2)),
        user_unregistered(h.e("07=#", 4, 6), r8, c.i("畳戮杽泽凟", 4, 62)),
        user_incorrect_password(FM_Exception.insert(5, 104, "8aip"), r8, d.c("畿承実硋世歯硳", 4)),
        user_not_sign(e.a(DfuException.ERROR_CONNECTION_TIMEOUT, "hlo0"), r8, x2.g.a(1, 33, "畹戥朹笪绳")),
        user_sign_apply(FM_Exception.insert(5, 19, "8,?q"), r8, e.a(74, "男扵坭笶续畽讦乹")),
        user_sign_fail(e.a(5, "km07"), r8, b.b(DfuException.ERROR_DFU_SPP_RWS_NOT_READY, "筹纴夬赭")),
        user_sign_sucess(FM_Exception.insert(2, 37, "7;``"), r8, f.a("笲绯嶴打募", 196)),
        user_logout(FM_Exception.insert(252, 97, "1qr5"), r8, x2.g.a(1, 98, "畹扤巧泿镙")),
        user_register(d.c("j|my", DfuException.ERROR_CONNECT_ERROR), r8, x2.a.b("畾戢左治凞", DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, 31)),
        user_severance(h.e("<>\u007fh", DfuException.ERROR_READ_PATCH_INFO_ERROR, 33), r8, x2.g.a(4, 67, "畼戠嶨觾约")),
        user_not_login(d.c("fxis", 4), r8, e.a(5, "畲扪未癸当")),
        user_id_not_matching(d.c("t&6(", 82), r8, c.i("畫扴躨仾讂侢恬与卺鄎", 76, 32)),
        user_locked(FM_Exception.insert(3, 42, "6!j4"), r8, d.c("申戻嶯镏寅", 40)),
        user_freeze(x2.a.b("d0zd", 5, 43), r8, h.e("畡戠嶷冨绒", 204, 78)),
        user_get_password_count_exceed(f.a("c\u007f}z", 106), r8, e.a(DfuException.ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE, "寗砕扩囄巯经辽制彚早丅陂")),
        user_info_incomplete(FM_Exception.insert(3, 47, "6&t "), r8, f.a("甬戶沶凗侹怺也寃攸ｅ讱蠦儅瘦诪皯儧侰怡", 252)),
        user_auth_code_invalid(e.a(252, "`dfl"), r8, h.e("畯扲讧诀砞桼髗夨贲", 330, 30)),
        user_auth_code_mobile_invalid(x2.a.b("}+;.", 348, 111), r8, c.i("髅讌砐扞杣厪响泭内戆杫叢且九膵", 242, 100)),
        not_support_retrieve_email(d.c("pbr,", 110), r8, x2.a.b("寄硅下敧挋郢箿戮囌", 178, 66)),
        user_auth_code_type_invalid(b.b(2, ">*4)"), r8, e.a(4, "髕讝硞籹垎丅匲酃")),
        user_auth_code_expire(e.a(5, "km23"), r8, FM_Exception.insert(1, 27, "骉证砚嶤辖朓")),
        sptc_open_exception(d.c("iyhz", 5), r8, c.i("仯逕卲彗遁収甜弅平ｃ诤釚讎", 212, 100)),
        sptc_close_exception(x2.a.b("iaxq", DfuException.ERROR_CONNECT_ERROR, 121), r8, d.c("任遊匠兡问叅甚彔广ｔ设釗诞", 108)),
        sptc_personalization_fail(c.i("j$?u", 132, 25), r8, c.i("份遑卼乥任包奴贲", 2, 82)),
        app_issuer_fail(e.a(3, "ikl5"), r8, c.i("畱扷卦原衙奭账", 2, 71)),
        sptc_data_not_matching(h.e("1!p*", 3, 49), r8, h.e("仯逆匬攮捡乍匨鄏", 110, 49)),
        card_invaild_check(x2.a.b("bu$y", 3, 82), r8, x2.a.b("匲牓髙诗斷敐", 3, 65)),
        card_not_order(e.a(3, "ikm0"), r8, d.c("匢爓诧贻兴糣丄嬂坣", 112)),
        card_order_by_other(x2.g.a(150, 3, "79?="), r8, x2.a.b("匴牜诣赪兾糨乔卦酈ｇ嶣袼八井泡冃畽扬讣赪", 5, 38)),
        user_order_open(c.i("hub.", 2, 108), r8, x2.g.a(140, 26, "畴戡巢诨赩乊卹巠彌遜")),
        user_unsubscribe_closed(x2.g.a(68, 11, "%/ya"), r8, x2.g.a(5, 47, "畽戳嶡适讳乔兼闳介劃肶")),
        user_order_no_open(e.a(5, "km36"), r8, h.e("甩戼嶧诽贤伕辅札彑遁", 4, 42)),
        user_order_fail(c.i("mz+p", 5, 78), r8, h.e("當戫诸贵奧贱", 1, 62)),
        user_unsubscribe_fail(FM_Exception.insert(1, 11, "4 (1"), r8, e.a(4, "畱扫遟讠头购")),
        user_order_invaild_info(h.e("n02:", 2, 1), r8, FM_Exception.insert(246, 64, "诸贷侻恵攪捴杓间飂")),
        sptc_app_not_issuer(b.b(5, "#-;*"), r8, c.i("仸遐匹廒甼木丛輣", 5, 110)),
        sptc_personalization(x2.g.a(4, 78, "er$n"), r8, x2.a.b("价逐匠巪寃或丷仮匝", 3, 55)),
        invaild_personalization_info(e.a(3, "ikj0"), r8, FM_Exception.insert(1, 75, "丯仪匍收捿乑跴")),
        ack_card_app_unpersonal(c.i("m48&", 5, 8), r8, x2.g.a(DfuException.ERROR_DFU_SPP_RWS_NOT_READY, 11, "庞甽未両京南")),
        ack_card_app_unprepare(x2.a.b("yrhe", 120, 122), r8, x2.a.b("廆畴宏裕朰凂変", 2, 10)),
        ack_card_app_order_fail(c.i("m{n}", 5, 111), r8, x2.g.a(3, 110, "畻扶霑访账戉劘狣恂")),
        ack_card_app_unorder_fail(x2.g.a(198, 54, "'|6m"), r8, d.c("畱扽霅遌访戞劀犦怀", 134)),
        no_suppert_in_card(x2.a.b("{\"n4", 90, 72), r8, c.i("曞下政挛冁卯", 5, 10)),
        no_suppert_out_card(d.c("eubp", 1), r8, c.i("暉乜攸捜奕卨", 52, 70)),
        business_order_not_exist(FM_Exception.insert(278, 60, "+g\"\u007f"), r8, x2.a.b("请卛乊存坱", 5, 57)),
        business_order_apply_no_pay(e.a(3, "ijn3"), r8, e.a(338, "该匟嶿畣认し杳房歡")),
        business_order_pay_no_write(FM_Exception.insert(3, 72, "6~'l"), r8, e.a(1, "说匌嶮戼欼〄朢兎倲")),
        business_order_recharge_sucess(d.c("ixj\u007f", 5), r8, x2.g.a(222, 42, "诬匍巰纃儓值扚勋")),
        business_order_amount_inconsistent(f.a("<;71", 5), r8, h.e("讠匛醋飛丟笸", 5, 108)),
        business_order_unsettled_exist(b.b(218, "vcm>"), r8, e.a(1, "嬎坱厳痎讠卐")),
        business_order_recharget_fail(c.i("hv%t", 2, 78), r8, h.e("讣匄以時奰贴", 4, 112)),
        business_order_apply_refund(c.i("bp\u007f%", 252, 110), r8, c.i("诹卙甮诹速歮乬", 4, 17)),
        business_order_refund(f.a("wrpd", 222), r8, x2.g.a(366, 33, "诼匊已遁歼")),
        business_order_rechargeting(d.c("&9(:", 196), r8, h.e("讳协欠坤儐偢乪", 308, 9)),
        business_order_paying(c.i("l|l|", DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, 112), r8, d.c("诵匝欺坢攴仔丰", 4)),
        business_order_no_refund(x2.a.b("9j\u007fs", 152, 115), r8, f.a("议卜下胾退正", 4)),
        business_order_card_no_inconsistent(FM_Exception.insert(4, 61, "9t3,"), r8, f.a("让卝绔官盛匽厮哚板歱仩晙盃匥厶乓乛膬", 3)),
        business_order_invoice(f.a(";655", 2), r8, d.c("厅礭嶤飁収", 1)),
        business_order_no_invoice(FM_Exception.insert(4, 104, "9aiu"), r8, FM_Exception.insert(4, 106, "语筆仸晕巢夫敌ｂ乕肿颊叀发礢")),
        business_unsettled_overrun(e.a(5, "kl15"), r8, f.a("另疗计单跘辝九阄｝讹辐蠄奁瑄", 1)),
        trade_not_exist(f.a("::53", 3), r8, FM_Exception.insert(3, 45, "亣昇乌孖圳")),
        trade_handling(b.b(1, "?+4="), r8, FM_Exception.insert(4, 29, "京昖奆瑙乱")),
        trade_fail(FM_Exception.insert(4, 67, "9y>b"), r8, e.a(326, "亿昍奰赡")),
        trade_sucess(f.a("=;67", 4), r8, f.a("仦昌戌劆", 186)),
        trade_act_check_fail(e.a(1, "gklh"), r8, e.a(DfuException.ERROR_ENTER_OTA_MODE_FAILED, "洶劸仰砗核骐央货")),
        trade_act_used(c.i("mpx6", 5, 102), r8, d.c("浣勡亹硊差佲甶", 5)),
        no_activity(x2.g.a(5, 78, "`s!n"), r8, x2.a.b("记叒啍沧杈洧势侳怢", 5, 91));
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ String f6238a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ a f6239b;

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ String f6240c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum a {
            local,
            remote
        }

        static {
            x2.a.b(",}'7d\u0005nk#k:ck9C-a|'s$", 240, 50);
            d.c("4n\u007fq", DfuException.ERROR_DFU_SPP_RWS_NOT_READY);
            a aVar = a.local;
            h.e("`*/086#>\u0015(6%;)\u00076=+)')7\u001fxb~ge", 5, 125);
            h.e("28>%", 5, 6);
            a aVar2 = a.remote;
        }

        /* synthetic */ ErrorMessage(String str, a aVar, String str2) {
            this.f6238a = str;
            this.f6239b = aVar;
            this.f6240c = str2;
        }

        public static ErrorMessage instance(String str) {
            ErrorMessage[] values;
            for (ErrorMessage errorMessage : values()) {
                if (errorMessage.getId().equals(str)) {
                    return errorMessage;
                }
            }
            return business_system_unknow_error;
        }

        public String getDesc() {
            return this.f6240c;
        }

        public String getId() {
            return this.f6238a;
        }

        public a getType() {
            return this.f6239b;
        }
    }

    public BusinessException(String str) {
        super(str);
    }

    public BusinessException(String str, ErrorMessage errorMessage) {
        super(str);
        this.f6236a = errorMessage;
    }

    public ErrorMessage getErrorMsg() {
        return this.f6236a;
    }
}
