package com.mobvoi.wear.common.base;
/* loaded from: classes2.dex */
public class WearPath {
    public static final String REDIRECT_HOST = "/re";
    public static final String WEAR_PATH_ACTION = "/action";

    /* loaded from: classes2.dex */
    public static final class Account {
        public static final String ACCOUNT = "/account";
        public static final String CHECK_WEAR_LOGGED_IN = "/account/check_wear_logged_in";
        public static final String FORK_ACCOUNT_INFO = "/account/fork_account_info";
        public static final String SYNC_ACCOUNT_INFO = "/account/sync_account_info";
    }

    /* loaded from: classes2.dex */
    public final class AwCompat {
        public static final String AW_COMPAT_PATH = "/aw_compat";
        public static final String ENABLE_COMPAT_MODE_PATH = "/aw_compat/enable_compat_mode";

        public AwCompat() {
        }
    }

    /* loaded from: classes2.dex */
    public final class BatteryStats {
        public static final String BATTERY_STATS = "/battery_stats";

        public BatteryStats() {
        }
    }

    /* loaded from: classes2.dex */
    public static class Calendar {
        public static final String CALENDAR = "/calendar";
        public static final String CALENDAR_ADD = "/calendar/add";
        public static final String CALENDAR_DELETE = "/calendar/delete";
        public static final String CALENDAR_DELETE_SINGLE = "/calendar/delete_single";
        public static final String CALENDAR_OPEN = "/action/calendar/open";
        public static final String CALENDAR_QUERY = "/calendar/query";
        public static final String CALENDAR_UPDATE = "/calendar/update";
        public static final String IOS_SYNC_EVENT_REMINDER = "/calendar/sync_event_reminder_all";
        public static final String IOS_SYNC_EVENT_REMINDER_END = "/calendar/sync_event_reminder_all_end";
        public static final String IOS_SYNC_EVENT_REMINDER_START = "/calendar/sync_event_reminder_all_start";
        public static final String SYNC_CALENDAR_EVENT_SYNC = "/calendar/calendar_sync_event_all";
    }

    /* loaded from: classes2.dex */
    public final class Call {
        public static final String CALL = "/call";
        public static final String CALL_TO = "/call/call_to";
        public static final String CONTACT_PHOTO = "/call/contact_photo";

        public Call() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class CloudSync {
        public static final String CLOSE_CLOUD_SYNC = "/cloudsync/close_cloud_sync";
        public static final String PREFIX = "/cloudsync";
    }

    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final String ACTION_SHOW_BLUETOOTH_SETUP_TIP = "/companion/action_show_bluetooth_setup_tip";
        public static final String CHANGE_HAND_TYPE = "/companion/change_hand_type";
        public static final String CHANGE_HOTWORD_TYPE = "/companion/change_hotword_type";
        public static final String CHECK_UPDATE_REP = "/companion/check_update_rep";
        public static final String CHECK_VERSION_MATCHES = "/companion/check_version_matches";
        public static final String CLOSE_CLOUD_SYNC = "/companion/close_cloud_sync";
        public static final String COMPANION = "/companion";
        public static final String FACTORY_RESET = "/companion/factory_reset";
        public static final String FIND_PHONE = "/companion/find_phone";
        public static final String FIND_WATCH = "/companion/find_watch";
        public static final String FIND_WATCH_END = "/companion/find_watch_end";
        public static final String GET_BATTERY_STATS = "/companion/get_battery_stats";
        public static final String GET_LOG_SIZE = "/companion/get_log_size";
        public static final String GET_PHONE_BATTERY = "/companion/get_phone_battery";
        public static final String GET_REPORTS = "/companion/get_reports";
        public static final String HOTWORD_SETTING = "/companion/hotword_setting";
        public static final String LAUNCH_INTENT = "/companion/launch_intent";
        public static final String NOTIFY_FINISH_BUGREPORT = "/companion/notify_finish_bugreport";
        public static final String OTA_UPDATE_REQ = "/companion/ota_update_req";
        public static final String POST_INTENT_ON_PHONE = "/companion/post_intent";
        public static final String REQUEST_RESTART = "/companion/request_restart";
        public static final String RESET = "/companion/reset";
        public static final String SCREENSHOT_TO_ALBUM = "/companion/screenshot_to_album";
        public static final String SCREENSHOT_TO_ALBUM_RESPONSE = "/companion/screenshot_to_album/repponse";
        public static final String SEND_COMPANION_INFO = "/companion/send_companion_info";
        public static final String SEND_ONEBOX_SHOW_COUNT = "/companion/send_onebox_show_count";
        public static final String START_WEAR_PSPLAY = "/companion/start_wear_psplay";
        public static final String SYNC_APPSTORE_STATE = "/companion/sync_appstore_state";
        public static final String SYNC_GLANCE_INFO = "/companion/sync_glance_info";
        public static final String SYNC_IOS_DEVICE_NAME = "/companion/sync_ios_device_name";
        public static final String SYNC_NOTIFICATION_PRIVACY_STATE = "/companion/sync_notification_privacy_state";
        public static final String SYNC_VOICE_SERVICE_KEY = "/companion/sync_voice_service_key";
        public static final String SYNC_VOICE_SERVICE_STATE = "/companion/sync_voice_service_state";
        public static final String SYNC_WATCHFACE_INFO = "/companion/sync_watchface_info";
        public static final String SYNC_WEAR_BATTERY = "/companion/sync_wear_battery";
        public static final String SYNC_WEAR_DEVICE_ID = "/companion/sync_wear_device_id";
        public static final String SYNC_WEAR_INFO = "/companion/sync_wear_info";
        public static final String SYNC_WEAR_MAC_ADDRESS = "/companion/sync_wear_mac_address";
        public static final String SYNC_WEAR_STEP = "/companion/sync_wear_step";
        public static final String SYNC_WEATHER_LOCATION = "/companion/sync_weather_location";
        public static final String WATCHFACE_VISIBILITY_CHANGE = "/companion/watchface_visibility_change";
    }

    /* loaded from: classes2.dex */
    public static final class Contact {
        public static final String CONTACT = "/contact";
        public static final String CONTACT_PERMISSION_IS_AVAILABLE = "/contact/contact_permisson_is_available";
        public static final String CONTACT_PERMISSION_IS_CANCEL = "/contact/contact_permisson_is_cancel";
        public static final String REQUIRE_CONTACT_PERMISSION = "/contact/require_contact_permisson";
    }

    /* loaded from: classes2.dex */
    public final class DateTime {
        public static final String DATETIME = "/datetime";
        public static final String TIME_CHANGED = "/datetime/time_changed";

        public DateTime() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class FileLazyUploader {
        public static final String FILE_LAZY_UPLOADER = "/file_lazy_uploader";
    }

    /* loaded from: classes2.dex */
    public static final class FileManager {
        public static final String DISK_USAGE = "/file_manager/disk/usage";
        public static final String DOWNLOAD_CANCEL = "/file_manager/download/cancel";
        public static final String DOWNLOAD_FILE = "/file_manager/download/file";
        public static final String DOWNLOAD_RESULT = "/file_manager/download/result";
        public static final String LIST_QUERY = "/file_manager/list/query";
        public static final String LIST_SUBSCRIBE = "/file_manager/list/subscribe";
        public static final String LIST_UNSUBSCRIBE = "/file_manager/list/unsubscribe";
        public static final String LIST_UPDATE = "/file_manager/list/update";
        public static final String NET_QUERY = "/file_manager/net/query";
        public static final String NET_RESULT = "/file_manager/net/result";
        public static final String OPERATION_REMOVE = "/file_manager/op/remove";
        public static final String REQUEST_ALBUM = "/file_manager/request/album";
        public static final String RESPONSE_ALBUM = "/file_manager/response/album";
        public static final String ROOT_PATH = "/file_manager";
        public static final String SCAN_PROGRESS = "/file_manager/scan/progress";
        public static final String SCAN_START = "/file_manager/scan/start";
        public static final String SCAN_STOP = "/file_manager/scan/stop";
        public static final String STAT_SUBSCRIBE = "/file_manager/stat/subscribe";
        public static final String STAT_UNSUBSCRIBE = "/file_manager/stat/unsubscribe";
        public static final String TRANSFER_PUSH = "/file_manager/transfer/push";
        public static final String TRANSFER_START = "/file_manager/transfer/start";
        public static final String TRANSFER_STOP = "/file_manager/transfer/stop";
    }

    /* loaded from: classes2.dex */
    public static class FusedLocation {
        public static final String FUSED_LOCATION = "/sglocation";
        public static final String LOCATION = "/sglocation/location";
        public static final String START = "/sglocation/start";
        public static final String STOP = "/sglocation/stop";
    }

    /* loaded from: classes2.dex */
    public interface Health {
        public static final String CMD_CHANGE_HEART_HEALTH_SWITCH = "/health/cmd_change_heart_health_switch";
        public static final String CMD_MOTION_EVENT_TO_PHONE = "/health/cmd_motion_event_to_phone";
        public static final String CMD_NEW_WEAR_PUSH_TO_PHONE = "/health/cmd_new_wear_push_to_phone";
        public static final String CMD_WEAR_PULL_FROM_PHONE = "/health/cmd_wear_pull_from_phone";
        public static final String CMD_WEAR_PUSH_TO_PHONE = "/health/cmd_wear_push_to_phone";
        public static final String DATA_SESSION_DELETE = "/health/session/delete";
        public static final String DATA_SESSION_GET = "/health/session/get";
        public static final String DATA_SESSION_POST = "/health/session/post";
        public static final String DATA_SET_DELETE = "/health/data_set/delete";
        public static final String DATA_SET_GET = "/health/data_set/get";
        public static final String DATA_SET_POST = "/health/data_set/post";
        public static final String HEALTH = "/health";
        public static final String OPEN_WECHAT_QR_TICKET = "/health/open_wechat_qr_ticket";
        public static final String REPLY_SUFFIX = "/re";
        public static final String SLEEP_SHARE = "/health/sleep/share";
        public static final String SYNC_STEP_TO_WECHAT = "/health/sync_step_to_wechat";
    }

    /* loaded from: classes2.dex */
    public static final class InCalling {
        public static final String ANSWER_ACTION_MESSAGE_PATH = "/incomingcall/incoming_call/answer_call_action";
        public static final String HEADSET_STATE_MESSAGE_PATH = "/incomingcall/incoming_call/headset_state";
        public static final String IN_CALLING = "/incomingcall";
        public static final String PATH_INCOMING_CALL_DATA_ITEM = "/incomingcall/incoming_call/ringing";
        public static final String PHONE_STATE_CHANGE_MESSAGE_PATH = "/incomingcall/incoming_call/phone_state_change";
        public static final String PHONE_VERSION = "/incomingcall/incoming_call/phone_version";
        public static final String QUICK_REPLY_MESSAGE_PATH = "/incomingcall/incoming_call/quick_reply";
        public static final String REJECT_ACTION_MESSAGE_PATH = "/incomingcall/incoming_call/reject_call_action";
        public static final String REMIND_LEAVE_PATH = "/incomingcall/incoming_call/remind_leave_action";
        public static final String REMIND_TIME_PATH = "/incomingcall/incoming_call/remind_time_action";
        public static final String SILENT_PHONE_PATH = "/incomingcall/incoming_call/silent_phone_action";
        public static final String UPDATE_ACTION_MESSAGE_PATH = "/incomingcall/incoming_call/update_number_mark_action";
    }

    /* loaded from: classes2.dex */
    public static final class Ios {
        public static final String DISCONNECT_IAP = "/ios/disconnect_iap";
        public static final String IOS = "/ios";
        public static final String PING = "/ios/ping";
        public static final String PING_REPLY = "/ios/ping_re";
        public static final String SET_REVIEW_MODE = "/ios/set_review_mode";
        public static final String START_BLE = "/ios/start_ble";
        public static final String STOP_BLE = "/ios/stop_ble";
        public static final String SYNC_ALL_APPS = "/ios/sync_all_apps";
    }

    /* loaded from: classes2.dex */
    public static final class Log {
        public static final String LOG = "/log";
        public static final String LOG_AND_BUG_REPORT = "/log/reports";
        public static final String UPLOAD_LOG_FILE = "/log/upload_log_file";
        public static final String UPLOAD_LOG_REALTIME = "/log/upload_log_realtime";
    }

    /* loaded from: classes2.dex */
    public static final class Lpa {
        public static final String ENABLE_FAIL = "/tic_lpa_app/enable_fail";
        public static final String ENABLE_SUCCESS = "/tic_lpa_app/enable_success";
        public static final String GET_IEMI_AND_EID_PATH = "/tic_lpa_app/get_iemi_and_eid";
        public static final String IEMI_AND_EID_RESULT_PATH = "/tic_lpa_app/iemi_and_eid_result";
        public static final String OPEN_QR_SCANNER = "/tic_lpa_appopen_qr_scanner";
        public static final String OPEN_TUTORIAL_ON_PHONE_PATH = "/tic_lpa_app/open_tutorial_on_phone";
        public static final String PREFIX = "/tic_lpa_app";
        public static final String QR_RESULT = "/tic_lpa_app/qr_result";
        public static final String SHOW_QR_CODE = "/tic_lpa_app/show_qr_code";
        public static final String START_ACTIVITY_PATH = "/tic_lpa_app/start_activity";
        public static final String START_DOWNLOAD_PATH = "/tic_lpa_app/start_download";
        public static final String START_ENABLE = "/tic_lpa_app/start_enable";
        public static final String TIC_LPA_APP = "tic_lpa_app";
        public static final String TIC_LPA_APP_ESIM_CARD_EMPTY = "/tic_lpa_app/esim_card_empty";
    }

    /* loaded from: classes2.dex */
    public static class Magic {
        public static final String PREFIX = "/magic";
        public static final String TAXI_CAPTCHA = "/magic/taxi_captcha";
        public static final String TAXI_REGISTER = "/magic/taxi_register";
    }

    /* loaded from: classes2.dex */
    public static final class MediaControls {
        public static final String CONTROLL_COMMAND = "command";
        public static final String CONTROLL_COMMAND_MUSIC_CARD = "music_card";
        public static final String CONTROLL_COMMAND_NEXT = "next";
        public static final String CONTROLL_COMMAND_PAUSE = "pause";
        public static final String CONTROLL_COMMAND_PLAY = "play";
        public static final String CONTROLL_COMMAND_PREVIOUS = "previous";
        public static final String CONTROLL_COMMAND_STOP = "stop";
        public static final String CONTROLL_COMMAND_TOGGLEPAUSE = "togglepause";
        public static final String CONTROLL_RATING = "rating";
        public static final String CONTROLL_VOLUME = "volume";
        public static final String DATA_ALBUM = "playcontrl.album";
        public static final String DATA_APP_ICON = "playcontrl.app_icon";
        public static final String DATA_ARTIST = "playcontrl.artist";
        public static final String DATA_ARTWORK = "playcontrl.artwork";
        public static final String DATA_CLIENT_NAME = "playcontrl.client_name";
        public static final String DATA_CLIENT_PKG = "playcontrl.client_pkg";
        public static final String DATA_PLAYING = "playcontrl.playing";
        public static final String DATA_SUPPORTS_THUMBS = "playcontrl.supports_thumbs";
        public static final String DATA_TITLE = "playcontrl.title";
        public static final String DATA_TRANSPORT_FLAGS = "playcontrl.transport_flags";
        public static final String DATA_USER_RATING = "playcontrl.user_rating";
        public static final String INFO_KEY_VERSION = "version";
        public static final String MEDIA_COMMAND = "/mediacontrols/media_command";
        public static final String MEDIA_CONTROLS = "/mediacontrols";
        @Deprecated
        public static final String MEDIA_DATA = "/mediacontrols/media_data";
        public static long MEDIA_DATA_VERSION = 1;
        public static final String MEDIA_INFO = "/mediacontrols/media_info";
        public static final String MEDIA_METADATA = "/mediacontrols/media_metadata";
        public static final String MEDIA_PLAY_STATE = "/mediacontrols/media_play_state";
        public static long MEDIA_VERSION_SPLIT_DATA = 1;
        public static final String MEDIA_VOLUME = "/mediacontrols/media_volume";
        public static final String VOLUME_CURRENT = "volume_current";
        public static final String VOLUME_MAX = "volume_max";
    }

    /* loaded from: classes2.dex */
    public static final class MusicPlayer {
        public static final String OPEN_MUSIC_CENTER = "/music_player/ui/open";
        public static final String ROOT_PATH = "/music_player";
    }

    /* loaded from: classes2.dex */
    public final class News {
        public static final String News = "/news";

        public News() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class Notification {
        public static final String NOTIFICATION = "/notify";
        public static final String NOTIFICATION_ADD_BLACK_LIST = "/notify/notification_add_black_list";
        public static final String NOTIFICATION_OPEN_PHONE = "/notify/notification_open_on_phone";
        public static final String NOTIFICATION_REPLY_SMS = "/notify/notification_reply_sms";
        public static final String NOTIFICATION_SEND_ACTION = "/notify/notification_send_action";
    }

    /* loaded from: classes2.dex */
    public static final class OTA {
        public static final String OTA = "/ota";
        public static final String OTA_DOWNLOAD_REP = "/ota/ota_download_rep";
        public static final String OTA_DOWNLOAD_REQ = "/ota/ota_download_req";
        public static final String OTA_UPDATE_REP = "/ota/ota_update_rep";
        public static final String OTA_UPDATE_REP_RESULT = "/ota/ota_update_rep_result";
        public static final String OTA_UPDATE_REQ = "/ota/ota_update_req";
    }

    /* loaded from: classes2.dex */
    public static final class OneBoxAction {
        public static final String DIAL_PHONE = "/action/onebox/phone";
        public static final String NAVIGATION = "/action/onebox/navigation";
        public static final String ONE_BOX_ACTION = "/action/onebox";
        public static final String OPEN_ON_PHONE = "/action/onebox/open_on_phone";
    }

    /* loaded from: classes2.dex */
    public final class PackageManager {
        public static final String DATA_PATH = "/apks";
        public static final String GET_ALL_PACKAGE_LIST = "/apks/getapplist";
        public static final String SEND_ALL_PACKAGE_LIST = "/apks/sendapplist";

        public PackageManager() {
        }
    }

    /* loaded from: classes2.dex */
    public static class Pair {
        public static final String MSG_CANCEL_SET_PASSWORD = "/setup/msg_cancel_set_password";
        public static final String MSG_COUNTRY = "/setup/msg_country";
        public static final String MSG_CROWN = "/setup/msg_crown";
        public static final String MSG_DATE_FORMAT = "/setup/msg_date_format";
        public static final String MSG_DONE_SET_PASSWORD = "/setup/msg_done_set_password";
        public static final String MSG_DONE_SYNC = "/setup/msg_done_sync";
        public static final String MSG_HAND = "/setup/msg_hand";
        public static final String MSG_LANGUAGE = "/setup/msg_language";
        public static final String MSG_RESET = "/setup/msg_reset";
        public static final String MSG_SET_PASSWORD = "/setup/msg_set_password";
        public static final String MSG_START_SYNC = "/setup/msg_start_sync";
        public static final String MSG_SYNC_SETTINGS = "/setup/msg_sync_settings";
        public static final String MSG_TEMPERATURE = "/setup/msg_temperature";
        public static final String MSG_UNITS = "/setup/msg_units";
        public static final String PREFIX = "/setup";
    }

    /* loaded from: classes2.dex */
    public static class Push {
        public static final String PUSH = "/push";
        public static final String PUSH_FORWARD_ACK = "/push/forward_ack";
        public static final String PUSH_FORWARD_REQ = "/push/forward_req";
    }

    /* loaded from: classes2.dex */
    public static final class Query {
        public static final String QUERY = "/query";
        public static final String RECOMMEND = "/query/recommend";
        public static final String SEARCH = "/query/search";
        public static final String SEARCH_API_REQUEST = "/query/search_api_request";
    }

    /* loaded from: classes2.dex */
    public static final class Recorder {
        public static final String RECORDER = "/Recorder";
        public static final String RECORDER_PLAY = "/Recorder/play";
        public static final String SYNC_RECORD_INSTALL_INFO = "/Recorder/sync_record_install_info";
    }

    /* loaded from: classes2.dex */
    public static final class RecorderV2 {
        public static final String FILE_UPDATE = "/recorder/list/update";
        public static final String LIST_QUERY = "/recorder/list/query";
        public static final String MAP_KEY_CREATE_TIME = "create_time";
        public static final String MAP_KEY_DURATION = "duration";
        public static final String MAP_KEY_FILE = "file";
        public static final String MAP_KEY_FILE_NAME = "file_name";
        public static final String MAP_KEY_FILE_SIZE = "file_size";
        public static final String MAP_KEY_TITLE = "title";
        public static final String OPERATION_DELETE = "/recorder/op/delete";
        public static final String OPERATION_RENAME = "/recorder/op/rename";
        public static final String PREFIX = "/recorder";
        public static final String REQUEST_DATA = "/recorder/request/data";
        public static final String RESPONSE_DATA = "/recorder/response/data";
        public static final String TRANSFER_FILE = "/recorder/transfer/file";
        public static final String TRANSFER_START = "/recorder/transfer/start";
        public static final String TRANSFER_STOP = "/recorder/transfer/stop";
    }

    /* loaded from: classes2.dex */
    public static final class ScreenShot {
        public static final String LOAD_PHOTO = "/screen_shot/load_photo";
        public static final String PHOTO_DATA = "/screen_shot/photo_data";
        public static final String PHOTO_NUMS = "/screen_shot/photo_nums";
        public static final String PHOTO_RECEIVED = "/screen_shot/photo_received";
        public static final String PREFIX = "/screen_shot";
        public static final String SCREEN_SHOT = "screen_shot";
        public static final String START_SYNC = "/screen_shot/start_sync";
    }

    /* loaded from: classes2.dex */
    public interface Sleep extends Health {
        public static final String SLEEP = "/sleep";
        public static final String SUMMARY_SHARE = "/sleep/share";
    }

    /* loaded from: classes2.dex */
    public static final class Speech {
        public static final String AUDIO_PATH = "/speech/audio";
        public static final String CANCEL = "/speech/cancel";
        public static final String ON_CANCEL = "/speech/on_cancel";
        public static final String ON_ERROR = "/speech/on_error";
        public static final String ON_PARTIAL_RESULT = "/speech/on_partial_result";
        public static final String ON_RESULT = "/speech/on_result";
        public static final String ON_SPEECH_END = "/speech/on_speech_end";
        public static final String ON_STOP_RECORD = "/speech/on_stop_record";
        public static final String ON_VOICE_ACTIONS = "/speech/on_voice_actions";
        public static final String SPEECH = "/speech";
        public static final String START_RECORD = "/speech/start_record";
        public static final String STOP_RECORD = "/speech/stop_record";
    }

    /* loaded from: classes2.dex */
    public final class Sports {
        public static final String REPLY_SUFFIX = "/re";
        public static final String SPORTS = "/sports";
        public static final String SPORTS_DELETE = "/sports/delete";
        public static final String SPORTS_DETAIL = "/sports/detail";
        public static final String SPORTS_HISTORY = "/sports/history";
        public static final String SPORTS_LOCATION_ENABLE = "/sports/location_enable";
        public static final String SPORTS_RECORD = "/sports/record";
        public static final String SPORTS_SHARE = "/sports/share";
        public static final String USER_PROFILE = "/sports/profile";

        public Sports() {
        }
    }

    /* loaded from: classes2.dex */
    public static class Stopwatch {
        public static final String PREFIX = "/stopwatch";
        public static final String TIME_RECORD = "/stopwatch/time_record";
    }

    /* loaded from: classes2.dex */
    public static final class Taxi {
        public static final String CREATE_ORDER = "/taxi/create_order";
        public static final String TAXI = "/taxi";
    }

    /* loaded from: classes2.dex */
    public static final class TicPay {
        public static final String APDU = "/ticpay/apdu";
        public static final String APDUS = "/ticpay/apdus";
        public static final String BANK_CARD_INFO = "/ticpay/bank_card_info";
        public static final String BEIJING = "bj";
        public static final String BIND_CARD = "/ticpay/bind_card";
        public static final String BIND_DOOR_CARD = "/ticpay/bind_door_card";
        public static final String BTC_INFO = "/ticpay/btcinfo";
        public static final String CLOSE_SE = "/ticpay/close_se";
        public static final String CPLC = "/ticpay/cplc";
        public static final String DEACTIVATE_ALL = "/ticpay/deactivate";
        public static final String DEFAULT_BANK_AID = "/ticpay/bank";
        public static final String DEFAULT_BUS_AID = "/ticpay/bus";
        public static final String DEFAULT_DOOR_AID = "/ticpay/door";
        public static final String DEVICE_INFO = "/ticpay/info";
        public static final String DIVIDER = "~@";
        public static final byte[] EMPTY_DATA = {1};
        public static final String ENTER_TICPAY_PAGE = "/ticpay/enter_ticpay_page";
        public static final String EXIT_TICPAY_PAGE = "/ticpay/exit_ticpay_page";
        public static final String GET_DEFAULT_APP = "/ticpay/get_default_aid";
        public static final String HAS_KEYGUARD = "/ticpay/has_keyguard";
        public static final String NFC_BUS_PROPERTY = "/ticpay/nfc_property";
        public static final String OPEN_KEYGUARD_SETTING = "/ticpay/open_keyguard_setting";
        public static final String PAY = "ticpay";
        public static final String PREFIX = "/ticpay";
        public static final String REBOOT = "reboot";
        public static final String SELECT_APDU = "/ticpay/select";
        public static final String SET_DEFAULT_APP = "/ticpay/set_default_aid";
        public static final String SE_STATUS = "/ticpay/se_status";
        public static final String SHENZHEN = "sz";
        public static final String SYNC_APPLET_INFO = "/ticpay/sync_applet_info";
        public static final String SYNC_CARD_IMAGE = "/ticpay/sync_card_image";
        public static final String SYNC_VISA_INFO = "/ticpay/sync_visa_info";
        public static final String TRANSACTION_END = "/ticpay/transaction_end";
        public static final String TRANSACTION_START = "/ticpay/transaction_start";
        public static final String UNSET_DEFAULT_APP = "/ticpay/unset_default_aid";
        public static final String WUHAN = "wh";
    }

    /* loaded from: classes2.dex */
    public static final class Tickids {
        public static final String ITEM = "/tickids/device/item";
        public static final String LIST = "/tickids/device";
        public static final String MAP = "/tickids/map";
        public static final String PREFIX = "/tickids";
        public static final String SOS = "/tickids/sos";
        public static final String TICKIDS = "tickids";
    }

    /* loaded from: classes2.dex */
    public static final class TwAppStore {
        public static final String OPEN_MOBVOI_STORE = "/tic_app_store/open_mobvoi_store";
        public static final String OPEN_URL = "/tic_app_store/open_url";
        public static final String PREFIX = "/tic_app_store";
        public static final String SYNC_PHONE_APPS = "/tic_app_store/sync_phone_app";
        public static final String TIC_APP_STORE = "tic_app_store";
    }

    /* loaded from: classes2.dex */
    public static final class WatchFace {
        public static final String CHANGE_CURRENT_WATCH = "/watchface/change_current_watch";
        public static final String DEPTH_DIY_DATA_FOR_COMPANION = "/watchface/depth_diy_data_for_companion";
        public static final String DEPTH_DIY_DATA_FOR_WEARWATCHFACE = "/watchface/depth_diy_data_for_wearwatchface";
        public static final String DEPTH_DIY_DATA_SYNC = "/watchface/depth_diy_data_sync";
        public static final String REQUIRE_SYNC_ALL = "/watchface/require_sync_all";
        public static final String SEND_ADD_WATCH_PACKAGE = "/watchface/send_add_watch_package";
        public static final String SEND_ALL_WATCH_PACKAGE = "/watchface/send_all_watch_package";
        public static final String SEND_CURRENT_WATCH = "/watchface/send_current_watch";
        public static final String SEND_RELIABLE_WATCHFACE_MSG = "/watchface/send_reliable_msg";
        public static final String SEND_REMOVE_WATCH_PACKAGE = "/watchface/send_remove_watch_package";
        public static final String SEND_VISIBILITY_CHANGE_PACKAGE = "/watchface/send_visibility_change_package";
        public static final String SEND_WATCH_PIC = "/watchface/send_watch_pic";
        public static final String STATUS_REP = "/watchface/digital_diy_rep";
        public static final String TIMEZONE2_CONFIGURATION = "/watchface/timezone2_cofiguration";
        public static final String TIMEZONE_CONFIGURATION = "/watchface/timezone_cofiguration";
        public static final String WATCHFACE = "/watchface";
    }

    /* loaded from: classes2.dex */
    public static final class WatchfaceMarket {
        public static final String BACK_IMAGE = "/tic_watchface_market/set_back_image";
        public static final String BACK_IMAGE_CONFIRM = "/tic_watchface_market/set_back_image_confirm";
        public static final String DOWNLOAD_LIST = "/tic_watchface_market/list_download";
        public static final String DOWNLOAD_WATCHFACE = "/tic_watchface_market/download_watchface";
        public static final String FEATURED_LIST = "/tic_watchface_market/list_featured";
        public static final String GET_IMAGE = "/tic_watchface_market/get_image";
        public static final String NEED_SHOW_BATTERY = "/tic_watchface_market/set_battery_show";
        public static final String NEED_SHOW_BATTERY_CONFIRM = "/tic_watchface_market/set_battery_show_confirm";
        public static final String NEED_SHOW_DATE_AND_WEEK = "/tic_watchface_market/set_date_and_week_show";
        public static final String NEED_SHOW_DATE_AND_WEEK_CONFIRM = "/tic_watchface_market/set_date_and_week_show_confirm";
        public static final String OPEN_ALI_NO_PASSWORD_PAY = "/tic_watchface_market/open_ali_no_password_pay";
        public static final String OPEN_DOWNLOAD_INSTALL = "/tic_watchface_market/open_download_install";
        public static final String OPEN_WECHAT_NO_PASSWORD_PAY = "/tic_watchface_market/open_wechat_no_password_pay";
        public static final String PREFIX = "/tic_watchface_market";
        public static final String SET = "/tic_watchface_market/set";
        public static final String SET_CONFIRM = "/tic_watchface_market/set_confirm";
        public static final String SET_IMAGE_WATCHFACE = "/tic_watchface_market/set_image_watchface";
        public static final String TIC_WATCHFACE_MARKET = "tic_watchface_market";
        public static final String TIME_PLACE = "/tic_watchface_market/set_time_place";
        public static final String TIME_PLACE_CONFIRM = "/tic_watchface_market/set_time_place_confirm";
    }

    /* loaded from: classes2.dex */
    public final class Wifi {
        public static final String CANCEL = "/wifi/cancel";
        public static final String GET_PASSWORD = "/wifi/get_password";
        public static final String WIFI = "/wifi";

        public Wifi() {
        }
    }
}
