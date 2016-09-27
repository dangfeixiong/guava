package cn.ziroom.guava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * 
* @ClassName CollectionsTest 
* @Description Google Guava Collections 使用介绍
* @author dfx
* @date 2015年12月18日 下午2:11:15 
*
 */
public class CollectionsTest {

	@Test
	//guava的简化操作
	public void simpleOperation(){
		//Map<String,Map<String,String>>
		Map<String,String> value1 = Maps.newHashMap();
		value1.put("1", "one");
		value1.put("2", "two");
		value1.put("3", "three");
		value1.put("4", "four");
		//===============================
		Map<String,Map<String,String>> oldMap = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> newMap = Maps.newHashMap();
		oldMap.put("key", value1);
		newMap.put("key", value1);
		//===============================
		List<Map<String,String>> oldList = new ArrayList<Map<String,String>>();
		List<Map<String, String>> newList = Lists.newArrayList();
		oldList.add(value1);
		newList.add(value1);
		//===============================
		Integer[] array1 = new Integer[3];
		Integer[] array2 = ObjectArrays.newArray(Integer.class, 3);
		array1[0] = 1000;
		array2[0] = 1000;
		//===============================
		//初始化map集合(不可变集合)
		Map<String,String> value2 = ImmutableMap.of("1", "one", "2", "two", "3", "three");
		System.out.println(value2);
		Map<String,String> value3 = ImmutableMap.of("1", "one", "2", "two", "3", "three","4","four","5","five");
		//value3.put("6", "six");	抛出异常
		System.out.println(value3);
		ImmutableMap<String, String> copy = ImmutableMap.copyOf(value3);
		//copy.put("9", "nine");	抛出异常
		System.out.println("copy:"+copy);
		//===============================
		//初始化list
		List<String> listStr = Lists.newArrayList("red","yellow","green","blue");
		listStr.add("black");//添加元素
		System.out.println(listStr);
		List<Integer> listInt = Lists.newArrayList(1,2,3,4);
		listInt.add(3, 12345678);
		System.out.println(listInt);
		//初始化set
		Set<String> setStr = Sets.newHashSet("dog","cat","pig");
		setStr.add("car");
		System.out.println(setStr);
	}
	
	
	@Test
	//set的交集, 并集, 差集的用法
	public void setOptions(){
		Set<Integer> setA = Sets.newHashSet(1,2,3,45);
		Set<Integer> setB = Sets.newHashSet(2,3,45,7,8);
		
		//union [1,2,3,45,7,8]
		SetView<Integer> union = Sets.union(setA, setB);
		System.out.println("union"+union);
		//differenceA [1]
		SetView<Integer> differenceA = Sets.difference(setA, setB);
		System.out.println("differenceA:"+differenceA);
		//differenceB [7,8]
		SetView<Integer> differenceB = Sets.difference(setB, setA);
		System.out.println("differenceB:"+differenceB);
		//intersection [2,3,45]
		SetView<Integer> intersection = Sets.intersection(setA, setB);
		System.out.println("intersection:"+intersection);
	}
	
	@Test
	//一种key可以重复的map，子类有ListMultimap和SetMultimap，对应的通过key分别得到list和set
	public void multiMap(){
		Multimap<String,String> multiMap = ArrayListMultimap.create();
		multiMap.put("crm-成员", "小辉");
		multiMap.put("crm-成员", "雪花");
		multiMap.put("crm-成员", "小羊");//{crm-成员=[壮壮, 雪成, 小羊]}
		multiMap.put("ZRAMS-成员", "小妞");//{ZRAMS-成员=[小妞], crm-成员=[小辉, 雪花, 小羊]}
		Collection<String> collection = multiMap.get("crm-成员");//[小辉, 雪花, 小羊]
		System.out.println(collection);
		//解析:重复key的map集合--->底层实现是HashMap<K, Collection<V>>()
		//传统的hashMap如果有相同的key,新值替换旧值
		//Multimap如果有相同的key,将value添加到collection中
	}
	
	@Test
	//可以增加重复的元素，并且可以统计出重复元素的个数，例子如下：
	public void mulitiSet(){
		Set<Object> hashSet = new HashSet<Object>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(3);
		hashSet.add(4);
		System.out.println(hashSet.size());//[1, 2, 3, 4]
		//add
		/**
		 *  public boolean add(E e) {
		        return map.put(e, PRESENT)==null;
		    }
		 */
		//=======================================
		Multiset<Object> multiSet = HashMultiset.create();
		multiSet.add(1);
		multiSet.add(2);
		multiSet.add(3);
		multiSet.add(3);
		multiSet.add(4);
		System.out.println(multiSet.size());//[1, 2, 3 x 2, 4]
		System.out.println(multiSet.count(3));
		
	}

}
