package chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

class Chapter3Test {

    @Test
    public void test() throws IOException {
        //given
        var bufferProcessor = new Ex_03_03_04();
        var oneLine = bufferProcessor.processFile((BufferedReader br) -> br.readLine());
        var twoLine = bufferProcessor.processFile((BufferedReader br) -> br.readLine() + System.lineSeparator() + br.readLine());

        //when
        var actual1 = "first line";
        var actual2 = "first line" + System.lineSeparator() +"second line";

        //then
        Assertions.assertEquals(actual1, oneLine);
        Assertions.assertEquals(actual2, twoLine);
    }

}