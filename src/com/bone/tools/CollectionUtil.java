package com.bone.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtil {

	/**
	 * 空集合检查�?如果集合为null或�?集合没有元素返回true�?
	 */
	public static boolean isNil(Collection<? extends Object> collection){
		return collection == null || collection.isEmpty();
	}

    public static boolean isNotNil(Collection<? extends Object> collection){
        return !isNil(collection);
    }

    public  static  <T extends Object>  boolean isNil(T... objs){
    	return isNil(Arrays.asList(objs));
    }

    /**
     * 计算list可按指定元素个数分成的组数目
     *
     * @param list
     * @param gSize
     * @return
     */
    public static int getGroupNum(List<? extends Object> list, int gSize) {
        assert gSize > 1 : "groupSize 必须大于 1";

        if (list.size() % gSize == 0) {
            return list.size() / gSize;
        }

        return 1 + (list.size() / gSize);
    }

    /**
     * 活动指定组的List
     *
     * @param list
     * @param gSize
     * @param gIndex
     * @return
     */
    public static <E> List<E> getGroupList(List<E> list, int gSize, int gIndex) {
        assert gSize > 1 : "must groupSize > 1";
        assert gIndex >= 0 : "must groupIndex >= 0 ";

        int startIndex = gIndex * gSize;
        int endIndex = ((gIndex + 1) * gSize) - 1;

        assert startIndex < list.size() : "must startIndex < list.size()";

        if (endIndex >= list.size()) {
            endIndex = list.size() - 1;
        }

        return new ArrayList<E>(list.subList(startIndex, endIndex + 1));
    }

    public static <E> List<List<E>> groupList(List<E> list, int gSize) {
		List<List<E>> groups = new ArrayList<List<E>>();
		if (list == null) {
            return groups;
        }
		for (int i = 0; i < getGroupNum(list, gSize); i++) {
			groups.add(getGroupList(list, gSize, i));
		}
		return groups;
    }

    public static <T> Set<T> createSetOf(T... objects){
        Set<T> set = new HashSet<T>();

        for (T obj : objects) {
            set.add(obj);
        }

        return set;
    }

    public  static  <T> String toElementString(Collection<T> c){
		String string = c.toString();
		return c.isEmpty() ? "" : string.substring(1,string.length()-1);
	}
}
