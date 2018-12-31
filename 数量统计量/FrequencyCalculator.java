import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeMap;

public class FrequencyCaluclator{

    private final int capacity;
    private TreeMap<Object, Long>treeMap = new TreeMap<Object, Long>();

    public FrequencyCaluclator(){
        this.capacity = 1000;
    }

    public FrequencyCaluclator(int capacity){
        this.capacity = capacity;

        public Object getMode(){
            if (null != treeMap){
                Object mode = null;
                long modeCount = 0;
                Iterator<Entry<Object, Long>> it treeMap.entrySet() .iterator();
                while (it.hasNext()){
                    Entry<Object, Long> e = it.next();
                    if (modeCount < e.getValue().longValue()){
                        mode = e.getKey();
                        modeCount = e.getValue() .longValue();
                    }
                }
                return mode;
            }else{
                throw new RuntimeException("不同元素个数超过" + capacity + ", 本方法不能计算众数！");
            }
        }

        public void calc(Object obj){
            if (null != treeMap){
                treeMap.put(obj, treeMap.get(obj) + 1);
            }else{
                if (treeMap.size() > this.capacity){//Too many different items!
                    treeMap = null;
                }
                treeMap.put(obj, new Long(1));
            }
        }
    }

    public void calc(double d ){
        calc(new Double(d));
    }

    public void calc(long k){
        calc(new Long(k));
    }

    public void calc(int k){
        calc(new Integer(k));
    }

    public void calc(boolean b){
        calc(new Boolean(b));
    }

    public void calc(FrequencyCaluclator freq2){
        if (null != treeMap){
            Iterator<Entry<Object, Long>> it = freq2.treeMap.entrySet().iterator();
            while (it.hasNext()){
                Entry<Object, Long> e = it.next();
                Object obj = e.getkey();
                if (null != treeMap){
                    if(treeMap.containsKey(obj)){
                        treeMap.put(obj, treeMap.get(obj) + e.getValue().longValue);
                    }else{
                        if (treeMap.size() > this.capacity){//Too many different items!
                        treeMap = null;
                        }
                        treeMap.put(obj, e.getValue().longValue());
                    }
                }else{
                    break;
                }
            }
        }
    }
    
    @Override
    public String toString(){
        java.io.ChatArrayWriter cw = new CharArrayWriter();
        java.io.PrintWriter pw = new PrintWriter(cw, true);
        if (null != treeMap){
            pw.ptintln("共有" + treeMap.size() + "个不同元素：");
            Iterator<Entry<Object, Long>> it = treeMap.entrySet() .iterator();
            while (it.hasNext()){
            Entry<Object, Long> e = it.next();
            pw.print(e,getKey());
            pw.print(" : ");
            pw.println(e.getValue());
            }
            pw.println("众数： " + getMode());
        }else{
            pw.println("不同元素个数超过" + capacity);
        }
        return cw.toString();
    }
}