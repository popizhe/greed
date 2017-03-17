package ray.liu.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.locks.Lock;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteSpringBean;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteCallable;
import org.apache.ignite.transactions.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ray.liu.test.TestTheMapper;


@Service
public class IgniteService {
	
	private static final Logger log = LoggerFactory.getLogger(TestTheMapper.class);
	
	@Autowired
	IgniteSpringBean ignite;
	
	public void first(){
		try (Ignite ignite = Ignition.start("example-ignite.xml")) {
			  Collection<IgniteCallable<Integer>> calls = new ArrayList<>();
			  // Iterate through all the words in the sentence and create Callable jobs.
			  for (final String word : "Count characters using callable".split(" "))
			    calls.add(word::length);
			  // Execute collection of Callables on the grid.
			  Collection<Integer> res = ignite.compute().call(calls);
			  // Add up all the results.
			  int sum = res.stream().mapToInt(Integer::intValue).sum();
			  System.out.println("Total number of characters is '" + sum + "'.");
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void second(){
		Collection<IgniteCallable<Integer>> calls = new ArrayList<>();
		// Iterate through all the words in the sentence and create Callable jobs.
		int sum  = 0;
		final String[] words = "Count characters using callable".split(" ");
		Collection<Integer> res = new ArrayList<>();
		for (final String word : words)
			calls.add(word::length);
		log.info("round start...");
		for (int i = 0; i < 100; i++) {
			res = ignite.compute().call(calls);
		}
		sum = res.stream().mapToInt(Integer::intValue).sum();
		log.info("Total number of characters is '" + sum + "'.");
		
	}
	
	public void set(){
		IgniteCache<String, String> cache = ignite.getOrCreateCache("myCacheName");
		IgniteCache<String, String> cache2 = ignite.getOrCreateCache("myCacheName2");
		cache.putIfAbsent("ray", "ray liu:" + UUID.randomUUID().toString());
		cache2.putIfAbsent("ray2", "2ray liu:" + UUID.randomUUID().toString());
	}
	
	public void get(){
		IgniteCache<String, String> cache = ignite.getOrCreateCache("myCacheName");
		IgniteCache<String, String> cache2 = ignite.getOrCreateCache("myCacheName2");
		System.out.println(cache.get("ray"));
		System.out.println(cache.get("ray2"));
		System.out.println(cache2.get("ray"));
		System.out.println(cache2.get("ray2"));
	}
	
	
	public void others(){
		IgniteCache<String, Integer> cache = ignite.getOrCreateCache("myCacheName");
		// Put-if-absent which returns previous value.
		Integer oldVal = cache.getAndPutIfAbsent("Hello", 11);
		// Put-if-absent which returns boolean success flag.
		boolean success = cache.putIfAbsent("World", 22);
		// Replace-if-exists operation (opposite of getAndPutIfAbsent), returns previous value.
		oldVal = cache.getAndReplace("Hello", 11);
		// Replace-if-exists operation (opposite of putIfAbsent), returns boolean success flag.
		success = cache.replace("World", 22);
		// Replace-if-matches operation.
		success = cache.replace("World", 2, 22);
		// Remove-if-matches operation.
		success = cache.remove("Hello", 1);
//		事务：
		try (Transaction tx = ignite.transactions().txStart()) {
		    Integer hello = cache.get("Hello");
		    if (hello == 1)
		        cache.put("Hello", 11);
		    cache.put("World", 22);
		    tx.commit();
		}
//		分布式锁：
		// Lock cache key "Hello".
		Lock lock = cache.lock("Hello");
		lock.lock();
		try {
		    cache.put("Hello", 11);
		    cache.put("World", 22);
		}
		finally {
		    lock.unlock();
		} 
	}
	
}
