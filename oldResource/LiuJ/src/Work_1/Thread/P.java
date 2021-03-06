package Work_1.Thread;

//分词

class C extends Thread{

    public synchronized void ByCommas(String sPeriod) {
        String[] sByCommas=sPeriod.split("\\,");
        for(int i=0;i<sByCommas.length;i++) {
            System.out.println(sByCommas[i]);
        }
    }
}

public class P extends Thread{
    public String sentence;
    private static String[] thesaurus={"My","name","is","XX",
            "20","years","old","Graduated","from","school",
            "hobbies","such","as","reading","dancing","singing","etc"};

    public void run(){
        while(true){
            synchronized (sentence){
                if(sentence.length()<0){
                    System.out.println("parsing wait");
                    try {
                        sentence.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    String sc=parsing(sentence);
                    ByPeriod(sc);
                    sentence.notifyAll();
                }
            }
        }
    }

    private static String parsing(String str) {
        int len=str.length();
        if (matchings(str) ||len== 1) {
            return str;
        } else {
            String lift = null, right = null;
            for (int i = len - 1; i > 0; i--) {
                lift = str.substring(0, i);
                right = str.substring(len - i, len);
                if (matchings(lift)) {
                    lift = str.substring(0, i);
                    right = str.substring(i, len);
                    break;
                } else if (matchings(right)) {
                    lift = str.substring(0, len - i);
                    right = str.substring(len - i, len);
                    break;
                }
            }
            return parsing(lift) + " " + parsing(right);
        }
    }


    private static boolean matchings(String str) {
        for(int i=0;i<thesaurus.length;i++){
            if(str.equals(thesaurus[i])||str.length()==1){
                return true;
            }
        }
        return false;
    }

    public synchronized void ByPeriod(String sentence) {
        String[] sByPeriod=sentence.split("\\.");
        C c=new C();
        for(int i=0;i<sByPeriod.length;i++) {
            c.ByCommas(sByPeriod[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        P t=new P();
        t.sentence="MynameisXX.20yearsold.GraduatedfromXXschool.Myhobbies,suchasreading,dancing,singing,etc.";
//        String sc=parsing(t.sentence);
        t.start();
//        t.ByPeriod(sc);
    }
}

//public class MT extends Thread {
//    public void run() {
//        while (true) {
//            try{
//                Thread.sleep(1000);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            System.out.println("Please wait A moment");
//        }
//    }
//    public static void main(String[] args){
//        MT mt=new MT();
//        mt.start();
//    }
//}
