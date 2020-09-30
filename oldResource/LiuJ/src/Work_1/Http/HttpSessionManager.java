//package Work.Http;
//
//import java.util.HashMap;
//
///**
// * HttpSession管理器
// */
//public class HttpSessionManager {
//
//    private static final HashMap<String,HttpSession> sessionMap = new HashMap<String, HttpSession>();
//
//
//    /**
//     * 创建一个session并返回sessionId
//     */
//    public  static String getSessionId(){
//        synchronized (sessionMap) {
//            HttpSession httpSession = new HttpSession();
//            sessionMap.put(httpSession.getSessionID(), httpSession);
//            return httpSession.getSessionID();
//        }
//    }
//    /**
//     * 判断服务器是否包含该客户端的session信息
//     */
//    public static boolean isHasJsessionId(String sessiondId){
//        synchronized (sessionMap) {
//            return sessionMap.containsKey(sessiondId);
//        }
//    }
//
//}