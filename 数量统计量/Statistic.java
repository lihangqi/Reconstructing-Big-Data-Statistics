//有了5个基本量后，就可以利用前面推导的公式，计算出14种统计量。
public class Statistic{
    mean = sum / count;

    if (1 == count){
        variance = 0.0;
    }else{
        variance =(sum2 - mean*sum)/(count - 1);
    }
    standardDeviation = Math.sqrt(variance);
    cv = standardDeviation / mean;
    standardError = standardDeviation / Math.sqrt(count);

    moment2 = sum2/count;
    moment3 = sum3/count;
    moment4 = sum4/count;

    centralMoment2 = (sum2 - mean*sum)/count;
    centralMoment3 = (sum3 - 3*sum2*mean+2*sum*mean*mean)/count;
    centralMoment4 = (sum4 - 4*sum2*mean+6*sum*mean*mean - 3*sum*mean*mean*mean)/count;

    skewness = centralMoment3 / (centralMoment2*Math.sqrt(centralMoment2));

    kurtosis = centralMoment4 / (centralMoment2*centralMoment2) - 3;
}