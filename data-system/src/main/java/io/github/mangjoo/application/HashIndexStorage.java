package io.github.mangjoo.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mangjoo.domian.Storage;

import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class HashIndexStorage<T> implements Storage<T> {

    private static final String SEPARATOR = ":";
    private static final String NEW_LINE = "\n";
    private final Map<String, Integer> hashIndex = new HashMap<>();

    private final String path;

    private int cursor = 0;

    public HashIndexStorage(String path) {
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

            hashIndex.put(key, cursor++);
        } catch (Exception e) {
            throw new IllegalStateException("파일을 저장하는데 실패했습니다.");
        }
    }

    @Override
    public T find(String key, Class<T> clazz) {
        final int count = key.length();

        try (RandomAccessFile lines = new RandomAccessFile(path, "r")) {
            lines.seek(hashIndex.get(key));

            String value = lines.readLine()
                    .substring(count + 1);

            return new ObjectMapper().readValue(value, clazz);
        } catch (Exception e) {
            throw new IllegalStateException("파일을 읽는데 실패했습니다.", e);
        }
    }
}
