public class Measurecalculator{

    public long count;
    public double sum;
    public double sum2;    
    public double sum3;
    public double sum4;

    public Measurecalculator(){
        count = 0;
        sum = 0.0;
        sum2 = 0.0;
        sum3 = 0.0;
        sum4 = 0.0;
        count = 0;
    }

    public void calculate(double d){
        sum += d;
        sum2 += d*d;
        sum3 += d*d*d;
        sum4 += d*d*d*d;
        count++;
    }

    public void calculate(Measurecalculator mc){
        this.sum += mc.sum;
        this.sum2 += mc.sum2;
        this.sum3 += mc.sum3;
        this.sum4 += mc.sum4;
        this.count += mc.count;
    }
}