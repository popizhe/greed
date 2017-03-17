package ray.liu.caiqingxin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Showlist {
	
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str = a.nextLine();  
		String[] str1 = str.split("\\s+|[,]");
		String str2="";
		for(int i=str1.length-1; i>-1; i--){
			str2 += str1[i] + " ";
		}
		System.out.println("倒叙输入输入的单词；"+str2);
		String[] dancis=str.split(" "); //分单词到数组
		
		Map<Integer, Set<String>> map = new HashMap<>(); 
		/**
		 * 设置存储，key-value结构，key是字符串的长度，value是一个可以去重的列表，存储相同长度的单词
		 * 例如，hi im ray 长度为2的单词有2个，长度为3的单词有1个
		 * 存储后表现为
		 * KEY: 2 , VALUE: [hi, im]
		 * KEY: 3 , VALUE: [ray]
		 */
		
		int maxCsLength = 0; //最大值默认为0，从0上涨
		int minCsLength = 999; //最大值默认为999，从999下减
		for(String cs : dancis){ //因为取最大最小都需要遍历，所以尽量减低遍历次数，这里仅做1次遍历
			int csLength = cs.length(); // 取当前单词的长度
			
			if(csLength > maxCsLength){	//对当前单词长度做最大值判断，如果大于目前的最大值，则将最大值修改为这个
				maxCsLength = csLength;
			}
			
			if(csLength < minCsLength){ //对当前单词长度做最小值判断，如果小于目前的最小值，则将最小值修改为这个
				minCsLength = csLength;
			}
			
			Set<String> set = new HashSet<>(); //初始化列表存储
			if(map.containsKey(csLength)){ //如果当前长度的单词已经存在，则取出这个列表
				set = map.get(csLength);
			}
			set.add(cs);				//将当前单词放入存储
			map.put(csLength, set);		//将当前存储放入整个存储中
		}
		
		
		
		System.out.println("一共有"+dancis.length+"个单词");
		System.out.println("最长的单词长度是："+maxCsLength + " 单词是: " + map.get(maxCsLength));
		System.out.println("最短的单词长度是："+minCsLength + " 单词是: " + map.get(minCsLength));
	}

}
