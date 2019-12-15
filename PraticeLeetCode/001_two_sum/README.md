**计算两数之和 **

* for 循环获取数组里的每一个元素；
* new 一个 Map，key 是被 target **相减** ，得到值，value 是每次循环的 i；
* 由于 map 的 key 是可以存放 null 的对象；
 所以以下的核心代码，就是为了通过一个 value 获取 数组的 index；
```java
 HashMap<Integer, Integer> map=new HashMap();
 int arrLength=nums.length;
 
 for(int i=0;i<arrLength;i++){
     int temp=nums[i];
     int indexOfArray=map.get(temp);
     if(indexOfArray!=null){
     return new int[]{value,i};
     }
     map.put(target-temp,i);
 }
```