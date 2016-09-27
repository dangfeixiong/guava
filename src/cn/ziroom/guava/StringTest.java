package cn.ziroom.guava;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.base.Strings;
/**
* @ClassName: StringTest 
* @Description:Strings类方法测试
* @author dfx
* @date 2015年11月20日 下午5:05:21
 */
@SuppressWarnings("deprecation")
public class StringTest {

	/**
	* @Title: nullToEmpty 
	* @Description:将null转换为"" 字符串原样返回
	* @param
	* @return void
	* @throws
	 */
	@Test
	public void nullToEmpty(){
		Assert.assertEquals("",Strings.nullToEmpty(null));
		String result = Strings.nullToEmpty("##");
		System.out.println(result);
	}
	
	/**
	* @Title: emptyToNull 
	* @Description:将""转换为null 字符串原样返回
	* @param
	* @return void
	* @throws
	 */
	@Test
	public void emptyToNull(){
		Assert.assertEquals(null,Strings.emptyToNull(null));
		String result = Strings.emptyToNull("##");
		System.out.println(result);
	}
	
	/**
	* @Title: isNullOrEmpty 
	* @Description:判断字符串是否为空
	* @param
	* @return void
	* @throws
	 */
	@Test
	public void isNullOrEmpty(){
		//null || string.length=0
		String result1 = null ;
		String result2 = "";
		System.out.println(Strings.isNullOrEmpty(result1));
		System.out.println(Strings.isNullOrEmpty(result2));
	}
	
	
	/**
	* @Title: commonPrefix 
	* @Description:获得两个字符串相同的前缀
	* @param
	* @return void
	* @throws 
	* @desc 如果字符串为空,会抛异常[NullPointerException]
	 */
	@Test
	public void commonPrefix(){
		// String result1 = "com.google.common.rbase.string";
		// String result2 = "com.google.common.base.strings";
		 String result1 = "";
		 String result2 = "";
		String result = Strings.commonPrefix(result1, result2);
		System.out.println("获取结果:"+result);
		
	}
	
	
	/**
	* @Title: commonPrefix 
	* @Description:获得两个字符串相同的后缀
	* @param
	* @return void
	* @throws
	* @desc 如果字符串为空,会抛异常[NullPointerException]
	 */
	@Test
	public void commonSuffix(){
		String result1 = "com.google.common.rbase.string";
		String result2 = "com.google.common.base.string";
		String result = Strings.commonSuffix(result1, result2);
		System.out.println("获取结果:"+result);
	}
	
	/**
	* @Title: pad 
	* @Description:Strings的padStart和padEnd方法来补全字符串
	* @param
	* @return void
	* @throws
	 */
	@Test
	public void pad(){
		String result1 = Strings.padStart("123", 4, '#');
		System.out.println("这是前补全"+result1);
		
		String result2 = Strings.padEnd("123", 4, '#');
		System.out.println("这是后补全"+result2);
	}
	
	
	/**
	* @Title: repeat 
	* @Description:复制字符串
	* @param
	* @return void
	* @throws
	 */
	@Test
	public void repeat(){
		System.out.println(Strings.repeat("#$", 4));
	}
}
