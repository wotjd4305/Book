package chapter8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex_08_03 {

    static Map<String, Integer> ageOfFriends = Map.ofEntries(Map.entry("A", 22),
            Map.entry("B", 24),
            Map.entry("C", 26)
    );

    static Map<String, List<String>> friendsToMovies = new HashMap<>();

    static Map<String, String> favoriteMovies = new HashMap<>();

    static Map<String, String> family = Map.ofEntries(Map.entry("A", "1"),
            Map.entry("B", "2"),
            Map.entry("C", "3"));

    static Map<String, String> friends = Map.ofEntries(Map.entry("A", "4"),
            Map.entry("D", "5"),
            Map.entry("E", "6"));


    public static void main(String[] args) {
        //
        System.out.println(ageOfFriends);

        // 8.3.1
        System.out.println("## 8.3.1 before");
        for (Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            String name = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(name + " is " + age + " years old");
        }

        System.out.println("## 8.3.1 after");
        ageOfFriends.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

        // 8.3.2
        System.out.println("## 8.3.2");
        ageOfFriends.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println);

        // 8.3.3
        System.out.println("## 8.3.3");
        System.out.println(ageOfFriends.getOrDefault("D", 99));

        // 8.3.4
        System.out.println("## 8.3.4");
        friendsToMovies.computeIfAbsent("D", name -> new ArrayList<>())
                .add("m7");
        System.out.println(friendsToMovies);

        // 8.3.5
        System.out.println("## 8.3.5");
        System.out.println(friendsToMovies.remove("D", List.of("m7")));

        // 8.3.6
        System.out.println("## 8.3.6");
        favoriteMovies.put("A", "Tom");
        favoriteMovies.put("B", "Jerry");
        favoriteMovies.put("C", "Dog");
        favoriteMovies.replaceAll((name, movie) -> movie.toUpperCase());
        favoriteMovies.replace("C", "DOG", "dog");
        System.out.println(favoriteMovies);

        // 8.3.7
        System.out.println("## 8.3.7");
        Map<String, String> everyOne = new HashMap<>(family);
        friends.forEach((k, v) -> everyOne.merge(k, v, (movie1, movie2) -> movie1 + "&" + movie2));
        System.out.println(everyOne);
    }
}
