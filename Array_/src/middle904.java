import java.util.HashMap;

public class middle904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        int res = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while (map.size() > 2){      //从哈希表中减去一个key==fruits[left]类型的水果，当key==fruits[left]这种类型的水果数等于0时，删除这种类型水果
                map.put(fruits[left],map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res,right - left + 1);
        }

        return res;
    }
}
