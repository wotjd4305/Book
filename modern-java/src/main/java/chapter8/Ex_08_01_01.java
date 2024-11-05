package chapter8;

import java.util.List;

public class Ex_08_01_01 {

    public static void main(String[] args) {
        // 8.1.1
        List<String> friends = List.of("Raphael", "Olivia", "Thibaut"); // 가변 인수는 내부적으로 추가 배열을 항당해서 감싸기에 나중에 배열 할당 후 가바지 컬렉션 비용 지불.
        System.out.println(friends);

        friends.add("Wotjd"); // 예외 발생
    }
}
