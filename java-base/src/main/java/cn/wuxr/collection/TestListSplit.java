package cn.wuxr.collection;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestListSplit {

    public static void main(String[] args) {
        List<Integer> orgList = Stream.iterate(0, x -> x + 2).limit(20).collect(Collectors.toList());
        // Guava
        List<List<Integer>> partitionList = Lists.partition(orgList, 5);
        System.out.println(partitionList);

        // apache common collection
        List<List<Integer>> partitionLists = ListUtils.partition(orgList, 5);
        System.out.println(partitionLists);


//        splitListByStream();
    }

    private static void splitListByStream() {
        // 按每5个一组分割 skip() 需要接收Long
        final long MAX_SEND = 5L;

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        long limit = (list.size() + MAX_SEND - 1) / MAX_SEND;
        //方法一：使用流遍历操作
        List<List<Integer>> partList = new ArrayList<>();
        Stream.iterate(0, n -> n + 1)
                .limit(limit)
                .forEach(i -> partList.add(list.stream().skip(i * MAX_SEND).limit(MAX_SEND).collect(Collectors.toList())));
        System.out.println(partList);

        //方法二：获取分割后的集合
        List<List<Integer>> splitList =
                Stream.iterate(0, n -> n + 1)
                        .limit(limit)
                        .map(a -> list.stream().skip(a * MAX_SEND).limit(MAX_SEND).collect(Collectors.toList()))
                        .collect(Collectors.toList());
        System.out.println(splitList);
    }

}
