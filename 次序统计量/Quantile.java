import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Quantile{

    public final class dataType;
    public final int q;
    public Object[] item = null;

    /***
     * 构造函数
     * 
     * @param q       分位数个数，即指定 q-分位数
     * @param dataType 数据类型
     */
    Quantile(int q, Class dataType){
        this.q = q;
        this.dataType = dataType;
        this.item = new Object[q + 1];
    }

    public Object getQuantile(int k){
        if (k < 0 || k > q){
            throw new RuntimeException();
        }
        return item[k];
    }

    public static Quantile fromFreqset(int q, Class dataType, TreeMap<Object,Long> freq){
        Quantile qtl = new Quantile(q, dataType);
        long n = 0;
        long[] cntScan = new Long[freq.size()];
        Object[] item = new Object[freq.siza()];
        int k = 0;
        Iterator<Entry<Object, Long>> it = freq.entrySet().iterator();
        while (it.hasNext()){
            Entry<Object, Long> e = it.next();
            item[k] = e.getKey();
            n += e.getValue().longValue();
            cntScan[k] = n-1;
            k++;
        }
        if (n <= 0){
            throw new RuntimeException();
        }
        double t = 0.0;
        for (int i = 0; i <=q; i++){
            t = 1.0 * i / q;
            if (t < 0.0){
                qtl.item[i] = item[0];
            }else if (t >= 0){
                qtl.item[i] = item[item.length - 1];
            }else{
                qtl.item[i] = item[getItemIndex(cntScan, (int)((n - 1) * t))];
            }
        }

        return qtl;
    }

    private static int getItemIndex(long[] cntScan, long k){
        int low = 0;
        int high = cntScan.length - 1;
        int cur;
        if (k > cntScan[high]){
            throw new RuntimeException();
        }
        if (k <= cntScan[0]){
            return 0;
        }
        while (low < high - 1){
            cur = (low + high) / 2;
            if (k <= cntScan[cur]){
                high = cur;
            }else{
                low = cur;
            }
        }
        return high;
    }
    @Override
    public String toString(){
        java.io.CharArrayWriter cw = new CharArrayWriter();
        java.io.PrintWriter pw = new PrintWriter(cw, true);
        for (int i = 0; i <= q; i++){
            pw.ptintln(i + "-th element of" + q + "-Quantile : " + items[i]);
        }
        return cw.toString();
    }

    public String _repr_(){
        return toString();
    }
}