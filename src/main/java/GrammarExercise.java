import java.util.*;

public class GrammarExercise {

    public static void main(String[] args) {

        //需要从命令行读入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个字符");
        String firstWordList = scanner.nextLine();


        System.out.println("请输入第二个字符");
        String secondWordList = scanner.nextLine();


        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        System.out.println(result);


    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> commonWordsList = new ArrayList<>();
        boolean character = isCharacter(firstWordList, secondWordList);
        if (character) {
            String[] firstWordArray = firstWordList.split(",");
            String[] secondWordArray = secondWordList.split(",");
            for (int i = 0; i < firstWordArray.length; i++) {
                for (int j = 0; j < secondWordArray.length; j++) {
                    if (firstWordArray[i].equalsIgnoreCase(secondWordArray[j])) {
                          if (!commonWordsList.contains(firstWordArray[i]))
                              commonWordsList.add(firstWordArray[i]);
                    }
                }
            }
        } else {
            System.out.println("input not valid");
            throw new RuntimeException();
        }
        List<String> strings = addSpace(commonWordsList);
        Collections.sort(strings);
        return strings;
    }

    private static boolean isCharacter(String a, String b) {

        boolean match1 = true;
        boolean match2 = true;

        String[] split1 = a.split(",");
        String[] split2 = b.split(",");

        for (int i = 0; i < split1.length; i++) {
            match1 = match1 & split1[i].matches("[a-zA-Z]+");
        }

        for (int j = 0; j < split2.length; j++) {
            match2 = split2[j].matches("[a-zA-Z]+");
        }
        return match1 && match2;
    }

    private static List<String> addSpace(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String name : list) {
            String s =  name.replace("", " ").trim();
            newList.add(s.toUpperCase());
        }
        return newList;
    }
}
