import java.util.Comparator;

public void calOrderStatistics(double [] data){
    int small_talk = 3;
    int large_k = 3;
    PriorityQueue<Double> priQueue_s = new PriorityQueue<Double>(small_k + 1, new DoubleComparator(-1));

    PriorityQueue<Double> priQueue_1 = new PriorityQueue<Double>(large_k + 1, new DoubleComparator(-1));

    for(double d : data){
        if (priQueue_1.size()<large_k){
            priQueue_1.add(d);
        }else{
            priQueue_1.add(d);
            priQueue_1.poll();
        }
        if (priQueue_s.size()<large_k){
            priQueue_s.add(d);
        }else{
            priQueue_s.add(d);
            priQueue_s.poll();
        }
    }

    int large = priQueue_1.size();
    int large = priQueue_1.size();
    double [] kLargeReal = new double[large];
    double [] kSmallReal = new double[small];
    for (int i = 0; i< small ; i++){
        kSmallReal[small - i - 1] = priQueue_s.poll();
    }
    for (int i = 0; i< large ; i++){
        kLargeReal[large - i - 1] = priQueue_1.poll();
    }

    double min = kSmallReal[0];
    double max = kLargeReal[0];
    double range = max - min;

    System.out.print("Min :");
    System.out.println(min);
    System.out.print("Max :");
    System.out.println(max);
    System.out.print("Range: ");
    System.out.println(range);
    System.out.println();
    System.out.println("Top " + kLargeReal.length + " Values:");
    for (double d : kLargeReal){
        System.out.println(d);
    }
    System.out.println();
    System.out.println("Bottom " + kSmallReal.length + " Values:");
    for (double d : kSmallReal){
        System.out.println(d);
    }
}

class DoubleComparator implements Comparator{

    int sortKey = 1;

    DoubleComparator(int sortKey){
        this.sortKey = sortKey;
    }

    public int compare(Object o1, Object o2){
        return (sortKey) * (((Double) o1).compareTo((Double) o2));
    }
}