package Work_2.Work1014;

import java.util.*;
//删除数组中重复的元素，输出无重复数组的长度（未做）
// ArrayList TreeSet或HashSet Set和List区别
public class Repeat {
    public static void main(String[] args) {
    	//ArrayList
    	int[] str = {5, 6, 6, 6, 8, 8, 7,4};
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<str.length; i++) {
	    	if(!list.contains(str[i])) {
	    	list.add(str[i]);
	    	}
		}
		System.out.println(list);

		//TreeSet或HashSet
		Integer[] str1 = {5, 6, 6, 6, 8, 8, 7,4};
		TreeSet treeSet=new TreeSet();
		// HashSet hset = new HashSet(Arrays.asList(nums));
		TreeSet<Integer> hset = new TreeSet<Integer>(Arrays.asList(str1));
		Iterator i = hset.iterator();
		while(i.hasNext()){
			System.out.print(i.next()+" ");
		}
		System.out.println();

		//Set和List
		List<Integer> numList = new ArrayList<Integer>();
		for (int a: str){
			numList.add(a);
		}
		Set<Integer> numSet = new HashSet<Integer>();
		numSet.addAll(numList);
		System.out.println(numSet);

    }
}
