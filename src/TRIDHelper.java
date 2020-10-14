import java.util.Arrays;
import java.util.Random;

public class TRIDHelper {
    public TRIDHelper() {
    }

    public boolean validate(long id){
        if (id>99999999999L||id<10000000000L){
            return false;
        }
        int[] ints=asArray(id);
        return sumCheck(ints);
    }
    public long generateRandom(){
        long l=0L;
        while (!validate(l)){
            l= newRandomLong();
        }
        return l;
    }
    private long newRandomLong(){
        Random random=new Random();
        int[] id=new int[11];
        long idLong=0L;
        for (int i=0;i<11;i++){
            id[i]=random.nextInt(9);
            idLong+=id[i];
            if (i!=10)idLong*=10;

        }
        System.out.println("random:"+idLong);
        return idLong;
    }
    private int[] asArray(long id){
        int[] ints=new int[11];
        for (int i=1;i<=11;i++){
            ints[11-i]= (int) (id%10);
            id=id/10;
        }
        System.out.println(Arrays.toString(ints));
        return ints;
    }
    private boolean sumCheck(int[] id){
        int sum = 0;
        sum+=id[0]+id[2]+id[4]+id[6]+id[8];
        sum*=7;
        sum-=id[1]+id[3]+id[5]+id[7];
        if ((sum%10)==id[9]){
            return ((id[0] + id[1] + id[2] + id[3] + id[4] + id[5] + id[6] + id[7] + id[8] + id[9]) % 10) == id[10];
        }else {
            return false;
        }
    }
}
