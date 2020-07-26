package com.wunderbar.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Rommel
 * @date 2020/3/23 22:04
 * @description 贪心算法
 * 应用场景：集合覆盖的问题(最少的资源办最多的事情)
 * 所有电台及每个电台覆盖的地区
 * Key(String)        Value(HashSet)
 * K1                [北京，上海，天津]
 * K2                [广州，北京，深圳]
 * K3                [成都，上海，杭州]
 * K4                [上海，天津]
 * K5                [杭州，大连]
 *
 * broadcasts(HashMap<String,HashSet<String>>)
 * 电台名称：Key [K1,K2,K3,K4,K5]
 * 覆盖城市:Value(HashSet)[allAreas]
 *
 * allAreas(HashSet<String>):不重复的所有需要被覆盖到的城市
 * tempAreas(HashSet<String>):循环对比选择过程中，被覆盖过的地区和比对key（Kn）的Value的Areas中交集的部分。
 * maxKey(String key):五个key中，能够覆盖的已知未覆盖的地区最多的代表的Key名称。
 *                   我能达到主人三个心愿，你们只能达到3个或者更少，我先来的，你们都不比我大，我是最优选择。
 * selects(ArrayList<String Key>):达到所有allAreas都被覆盖的成果使用的最少资源电台Key集合
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        // 创建广播电台，放入到HashMap
        HashMap<String, HashSet> broadcasts = new HashMap<String, HashSet>();

        // 将各个电台放入broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        // 加入到map,电台的名号及其覆盖的地区.
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        // allAreas存放所有地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建一个ArrayList,存放选择的电台集合 ,可能是K1-K5中的几个?
        ArrayList<String> selects = new ArrayList<String>();

        //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖过的地区和当前还没有覆盖过的地区的交集
        HashSet<String> tempSet = new HashSet<String>();

        //定义maxKey,保存在一次遍历过程中，能够覆盖最多未覆盖地区的对应电台的key(可能是K1 ,K2 ,K3 ,K4 ,K5).
        //如果maxKey不为null ,则加入selects:(selects.add("K1"))
        String maxKey = null;
        while (allAreas.size() != 0) {//如果allArea不为0,则表示没有覆盖到所有地区
            //每进行一次while
            maxKey = null;
            //for循环遍历broadcasts，取出对应的
            for (String key : broadcasts.keySet()) {
                //每进行一次for循环
                tempSet.clear();
                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);//[K1,K2,K3,K4,K5]
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合的交集,交集会赋给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖的地区的数量，比maxKey指向的集合地区还多
                //tempSet.size() > broadcasts.get(key).size() ,体现出贪心算法的特点，每次都选择最优的
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(key).size())//手里tempSet的比其他剩下的任何都大，手里的就是最优解，设置为maxKey，比完之后，方法selects,
                ) {
                    //就需要重置maxKey
                    maxKey = key;
                }

            }
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxkey指向的广播覆盖地区从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));

            }
        }
        System.out.println("得到的最优选择集合为:" + selects);//[K1,K2,K3,K5]
    }
}
