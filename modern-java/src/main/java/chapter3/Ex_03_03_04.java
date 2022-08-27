package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex_03_03_04 {

    public interface BufferReaderProcessor{
        String process(BufferedReader bufferedReader) throws IOException;
    }

    public String processFile(BufferReaderProcessor bufferReaderProcessor) throws IOException {
        try ( var bufferedReader = new BufferedReader(new FileReader("data.txt"))){
            return bufferReaderProcessor.process(bufferedReader);
        }
    }
}
