package io.github.mangjoo.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mangjoo.domian.Storage;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class SimpleStorage<T> implements Storage<T> {

    private static final String SEPARATOR = ":";
    private static final String NEW_LINE = "\n";

    private final String path;

    public SimpleStorage(String path) {
        this.path = path;
    }

    @Override
    public void save(String key, T t) {
        ObjectMapper objectMapper = new ObjectMapper();



        try (FileWriter fileWriter = new FileWriter(path, true)) {
            String value = objectMapper.writeValueAsString(t);
            fileWriter.append(key)
                    .append(SEPARATOR)
                    .append(value)
                    .append(NEW_LINE)
                    .flush();
        } catch (Exception e) {
            throw new IllegalStateException("파일을 저장하는데 실패했습니다.");
        }

    }

    @Override
    public T find(String key, Class<T> clazz) {
        int count = key.length();
        try (Stream<String> lines = Files.lines(Path.of(path))) {

            String value = lines.filter(line -> line.startsWith(key + SEPARATOR))
                    .reduce((first, second) -> second)
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("해당 key가 존재하지 않습니다."))
                    .substring(count + 1);


            return new ObjectMapper().readValue(value, clazz);
        } catch (Exception e) {
            throw new IllegalStateException("파일을 읽는데 실패했습니다.", e);
        }
    }
}
