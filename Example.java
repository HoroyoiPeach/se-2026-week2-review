import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        Example e = new Example();
        checkResult("normal input", "cba", e.reverse("abc", new ArrayList<>()));
        checkResult("empty input", "", e.reverse("", new ArrayList<>()));
        checkResult("null list", "cba", e.reverse("abc", null));
        checkNullInput(e);
        checkListContainingNull(e);

        System.out.println("All reverse() tests passed.");
    }

    private static void checkResult(String testName, String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                testName + ": expected " + expected + ", but was " + actual
            );
        }
    }

    private static void checkNullInput(Example e) {
        try {
            e.reverse(null, new ArrayList<>());
            throw new AssertionError("null input: IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException expected) {
            // Expected exception
        }
    }

    private static void checkListContainingNull(Example e) {
        List<String> list = new ArrayList<>();
        list.add(null);

        try {
            e.reverse("abc", list);
            throw new AssertionError("list containing null: IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException expected) {
            // Expected exception
        }
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
        list.add(str.substring(str.length() - 1));
        return reverse(str.substring(0, str.length() - 1), list);
    }
}