import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution{

    public static String [] words;

    public static void main(String[] args){
        words = new String[]{
                "Ahmad",
                "Tamer",
                "Mahmoud",
                "Adnan",
                "Ahmad",
                "Hetaf",
                "Avi"
        };

        int q1 = Q_1("Ah");
        String[] q2 = Q_2(2);
        String q3 = Q_3(5);
        String[] q4 = Q_4("AhmadssssaTamerssMahmoudAdnanaaaaAhmadHetafAvi");

        System.out.println(q1);
        System.out.println(Arrays.toString(q2));
        System.out.println(q3);
        System.out.println(Arrays.toString(q4));

    }

    public static int Q_1(String s){
        s = s.toLowerCase();
        int counter=0;
        for(int i =0;i<words.length;i++){
            if(words[i].toLowerCase().contains(s))
                counter++;
        }
        return counter;
    }

    public static String[] Q_2(int n){
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            for(int i=0;i<word.length()-n;i++){
                String subword = word.substring(i, i + n);
                if(map.containsKey(subword)){
                    map.replace(subword, map.get(subword)+1);
                }else{
                    map.put(subword, 1);
                }
            }
        }
        String[] res = new String[map.keySet().size()];
        int i=0;
        for(String key : map.keySet()){
            int val = map.get(key);
            res[i++] = key+":"+val;
        }

        return res;
    }

    public static String Q_3(int n){
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if(map.containsKey(word)){
                map.replace(word, map.get(word)+1);
            }else{
                map.put(word,1);
            }
        }

        String longest = "";
        int longest_repeat = 0;
        for(String word : map.keySet()){
            int c = map.get(word);
            if(c > longest_repeat){
                longest = word;
                longest_repeat = c;
            }
        }

        return longest;
    }

    public static String[] Q_4(String s){
        s = s.toLowerCase();
        LinkedList<String> names = new LinkedList<>();
        for (String word : words) {
            word = word.toLowerCase();
            if(s.contains(word)){
                names.add(word);
            }
        }
        String[] res = new String[names.size()];
        int i=0;
        for (String name : names){
            res[i++] = name;
        }
        return res;
    }
}