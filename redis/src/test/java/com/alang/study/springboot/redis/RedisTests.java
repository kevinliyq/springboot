package com.alang.study.springboot.redis;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.alang.study.springboot.redis.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void testString(){
		stringRedisTemplate.opsForValue().set("com.string","test");
		assertEquals("test",stringRedisTemplate.opsForValue().get("com.string"));
	}
	
	@Test
	public void testRedisListWithFIFO(){
		ListOperations<String,String> lo = redisTemplate.opsForList();
		lo.leftPush("cities1","Beijing");
		lo.leftPush("cities1", "Shanghai");
		lo.leftPush("cities1", "Guangzhou");
		assertEquals("Beijing",lo.rightPop("cities1"));
		redisTemplate.delete("cities1");
	}
	
	@Test
	public void testRedisListWithFILO(){
		ListOperations<String,String> lo = redisTemplate.opsForList();
		lo.leftPush("cities2","Haikou");
		lo.leftPush("cities2", "Shanghai");
		lo.leftPush("cities2", "Guangzhou");
		try{
			assertEquals("Guangzhou",lo.leftPop("cities2"));
		}finally{
			redisTemplate.delete("cities2");
		}
	}
	
	@Test
	public void testRedisListWithSet(){
		SetOperations<String,String> so = redisTemplate.opsForSet();
		redisTemplate.delete("com.test.set.numbers1");
		redisTemplate.delete("com.test.set.numbers2");
		
		so.add("com.test.set.numbers1", "1", "2", "5","7");
		so.add("com.test.set.numbers2", "2", "3", "9");
		
		assertEquals(4,so.size("com.test.set.numbers1").longValue());
		assertEquals(3,so.size("com.test.set.numbers2").longValue());
		Set<String> interSet = so.intersect("com.test.set.numbers1", "com.test.set.numbers2");
		assertFalse(interSet.isEmpty());
		assertTrue(interSet.contains("2"));
		
		Set<String> unionSet = so.union("com.test.set.numbers1", "com.test.set.numbers2");
		assertTrue(unionSet.size() == 6);
		
		redisTemplate.delete("com.test.set.numbers1");
		redisTemplate.delete("com.test.set.numbers2");
		
	}
	
	@Test
	public void testRedisSerializableObject(){
		Employee employee = new Employee();
		employee.setId("em001");
		employee.setName("kevin");
		employee.setAge(20);
		employee.setTeam("Spurs");
		redisTemplate.opsForValue().set("employee."+employee.getId(), employee);
		assertEquals(employee,redisTemplate.opsForValue().get("employee.em001"));
		
		//redisTemplate.delete("employee.em001");
		
	}

}
