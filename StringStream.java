import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Stream {
    private static String TEXT = "Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit. Nam bibendum quam ac " +
            "tristique lobortis. Pellentesque sapien tortor, " +
            "dapibus quis magna et, eleifend eleifend turpis. " +
            "Quisque ut ante quam.";

    private static List CHARS = Arrays.asList("aouiey".toUpperCase().split(""));

    public static void main(String[] args) throws Exception {
        String something = Arrays.stream(TEXT.split(" "))
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .filter(s -> s.length() > 5 && s.length() < 9)
                .map(String::toUpperCase)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .filter(s -> !CHARS.contains(s))
                .skip(2)
                .findFirst()
                .orElseThrow(Exception::new);

        Optional.ofNullable(something)
                .ifPresent(System.out::println);
    }
}
