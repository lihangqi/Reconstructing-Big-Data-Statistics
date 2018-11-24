#代码实现
首先，计算总记录数n和如下四个求和：sum、sum2、sum3、sum4
对于分布式系统，每个计算节点只计算一部分数据，需要汇总过程，才能得到最终的结果。对于我们关注的n、sum、um2、sum3和sum4，汇总过程很简单，直接加和就可以了，下面代码中的函数calculate(Measurecalculator mc)就是汇总过程的。