import java.util.*;
import java.util.stream.Collectors;

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

        if (!isCharacter(firstWordList) || !isCharacter(secondWordList)){
            throw  new RuntimeException("input is valid");
        }
        List<String> firstList = Arrays.asList(firstWordList.toUpperCase().split(","));
        List<String> secondList = Arrays.asList(secondWordList.toUpperCase().split(","));

        List<String> collect = firstList.stream().filter(fl -> secondList.contains(fl)).distinct().collect(Collectors.toList());
        List<String>  result  = addSpace(collect);
        Collections.sort(result);
        return  result;

    }

    /**
     * 判断是否是正常的字符
     * @param a
     * @return
     */
    private static boolean isCharacter(String a) {

        boolean match1 = true;


        String[] split1 = a.split(",");

        for (int i = 0; i < split1.length; i++) {
            match1 = match1 && split1[i].matches("[a-zA-Z]+");
        }
        return match1;
    }

    /**
     * 对list加上空格
     * @param list
     * @return
     */
        private static List<String> addSpace(List<String> list) {
            List<String> newList = new ArrayList<>();
            for (String name : list) {
                String s = name.replace("", " ").trim();
                newList.add(s.toUpperCase());
            }
            return newList;
        }
    }

