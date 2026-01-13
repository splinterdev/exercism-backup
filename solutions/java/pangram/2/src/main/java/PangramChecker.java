import java.util.Arrays;

public class PangramChecker {

    public boolean isPangram(String input) {

        // maneira mais simples e idiomática
        return Arrays.asList(input.toLowerCase().split(""))
            .containsAll(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
    }
}
