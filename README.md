# Reconstructing-Big-Data-Statistics

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/0bb4bb437a6b4ac6a2561863face63b9)](https://www.codacy.com/app/weslie0803/Reconstructing-Big-Data-Statistics?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=lihangqi/Reconstructing-Big-Data-Statistics&amp;utm_campaign=Badge_Grade)

**Alibaba Group 重构大数据统计**

大数据的代码实现

大数据的统计计算是进行数据探索和分析挖掘的基础，在实际应用中，随着数据规模的快速增长，数据会分布式存储在多台计算机上，即使最简单的求和操作都需要多台计算机协助完成，并且需要分钟级别的计算时间，这样我们将面对如下两个问题：

1.需要使用多少资源，即所要付出的成本。

2.计算需要多少时间，它关系到数据探索分析的效率和效果。

人们都希望花更少的钱，井且希望计算时间更短，但对于某个确定的计算过程，它们是成反比的。这就是在大数据统计实践中经常遇到的情况，当研究了一个又一个计算性能问题之后，我惊奇地发现，这些不同的算法间是有共性的，这就吸引我去深入研究，最终形成了完整的理论，包括常用的各种统计量和统计方法。

## FrequencyCalculator.java项目说明
其中的函数 public void calc(FrequencyCalculator freq2) 可以用来逐一汇总全部计算节点的频数信息。
