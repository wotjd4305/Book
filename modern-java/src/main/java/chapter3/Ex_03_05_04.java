package chapter3;

public class Ex_03_05_04 {

    public static void main(String[] args) {

        int postNumber = 1234;
        Runnable r = () -> System.out.println(postNumber);

        // final 로만 사용되어야함, 아래 코드 추가시 에러.
        // postNumber = 234;
    }
}
