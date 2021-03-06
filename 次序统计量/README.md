我们在实际计算极大值和极小值的时候，并不需要将全部的数据排列好来得到全部的次序统计量。下面进一步扩展极值的概念，介绍最大的前k个值和最小的前k个值.

能否通过读取一遍数据同时获取最大的前k个值和最小的前k个值呢？当处理海量数据时，将全部数据存放在内存中的代价根大，能否只用最小的内存来实现呢?

答案是肯定的。可以通过同时维护两个队列，一个是按从大到小的顺序排列，每次读取到新的数据后按顺序加入到队列中，然后只保留前k个数，将多出的数据删除。这样，这个数列最多需容纳k+1个数，而且，最终数列的第一个数就是全部数据的极大值，另一个队列是按照从小到大的顺序排列，也是每次读取到新的数据后按顺序加入到队列中，然后只保留前k个。将多出的数据删除，而且，最终数列的第一个数就是全部数据的极小值。