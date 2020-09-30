package Work_2.Work1014;

//输入两个数组，求两个数组的交集
public class ArrayMixed {
    public static void main(String[] args) {
        int[] a={1,5,2,4,3,8};
        int[] b={5,8,2,9,7,6};
        int[] c={};
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if (a[i]==b[j]){
                    c[i]=a[i];
                }else{
                    c[i]=a[i];

                }
            }
        }
    }
}
