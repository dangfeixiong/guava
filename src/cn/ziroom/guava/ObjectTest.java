package cn.ziroom.guava;

import java.util.Date;

import org.junit.Test;

import cn.ziroom.guava.bean.User;

import com.google.common.base.Objects;

/**
 * 
* @ClassName ObjectTest 
* @Description 对象操作封装(Object)
* @author dfx
* @date 2015年12月22日 下午5:00:37 
*
 */
public class ObjectTest {

	//判断对象是否相等
	@Test
	public void objectEqualTest(){
		Object obj1 = new Object();
		Object obj2 = null;
		//判断2个对象是否相等	1.判断对象不为空	2.判断对象是否相等
		boolean equal = Objects.equal(obj1, obj2);
		System.out.println(equal);
	}
	
	public static boolean equal(Object obj1, Object obj2){
		/*
		//方式1
		if(obj1 == obj2){//判断是否是同一个对象
			return true;
		}else{
			if(obj1 != null){//判断对象是否为空
				return obj1.equals(obj2);
			}
		}
		return false;
		*/
		
		//方式2
		return (obj1 == obj2) || (obj1 != null && obj1.equals(obj2));
	}
	
	
	//重写toString()方法
	@Test
	public void showObjToString(){
		User user = new User();
		user.setId("00001");
		user.setName("dfx");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAge(21);
		//user.setCommon("北京将台");
		System.out.println(user.toString());
	}
	
	//hashCode  多参数hashcode
	@Test
	public void showObjHashCode(){
		System.out.println(Objects.hashCode("A"));
		System.out.println(Objects.hashCode("A","B"));
		System.out.println(Objects.hashCode("B","A"));
		System.out.println(Objects.hashCode(new User()));
		System.out.println(Objects.hashCode(12));
	}
	
	
}
