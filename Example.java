import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        Example e = new Example();
        String s = e.reverse("abc", new ArrayList<>());        
        System.out.println(s);        
    }

    public String reverse(String str, List<String> list) {
        // null 문자열은 역순으로 변환할 수 없으므로 명확한 예외를 발생시킨다.
        if (str == null) {
            throw new IllegalArgumentException("str must not be null");
        }
        if (list == null) {
            list = new ArrayList<>();
        } else if (list.contains(null)) {
            throw new IllegalArgumentException("list must not contain null");
        }
        if (str.length() <= 0) { //기존 조건식: if (str.length() < 0)
            StringBuffer sb = new StringBuffer();
            for (String s : list) {
                sb.append(s);
            }
            return sb.toString();
            
        }
        list.add(str.substring(str.length()-1));
        return reverse(str.substring(0, str.length()-1), list);            
    }
}
