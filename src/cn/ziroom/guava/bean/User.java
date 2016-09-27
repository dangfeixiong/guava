package cn.ziroom.guava.bean;

import java.util.Date;

import com.google.common.base.Objects;

/**
 * 
* @ClassName User 
* @Description 用户实体
* @author dfx
* @date 2015年12月18日 下午2:21:45 
*
 */
public class User {
	private String id; // id
	private String name;// 姓名
	private Integer age;// 年龄
	private String sex;// 性别
	private Date birthday;// 出身年月
	private String common;// 简介

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	/*
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", sex="
				+ sex + ", birthday=" + birthday + ", common=" + common + "]";
	}
	*/
	
	@SuppressWarnings("deprecation")
	public String toString(){
		return Objects.toStringHelper(this.getClass())
				.add("id", id)
				.add("name", name)
				.add("age", age)
				.add("sex", sex)
				.add("birthday", birthday)
				.add("common", common)
				.omitNullValues().toString();
	}
	
	
}
