package io.github.mangjoo.application;

import io.github.mangjoo.TestObject;
import io.github.mangjoo.domian.Storage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class HashIndexStorageTest {

    @Test
    void save() {
        Storage<String> hashIndexStorage = new HashIndexStorage<>("./hash_test.txt");
        hashIndexStorage.save("test", "test");

        assertThat(new File("./hash_test.txt").exists()).isTrue();
    }

    @Test
    void find() {
        Storage<TestObject> hashIndexStorage = new HashIndexStorage<>("./hash_test.txt");

//        for (int i = 0; i < 300; i++) {
            hashIndexStorage.save("test" + 1, new TestObject("test", 1));
//        }

        run(() -> {
            TestObject test = hashIndexStorage.find("test1", TestObject.class);
            System.out.println("test = " + test);
        });

    }

    public static void run(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        long milliseconds = duration / 1_000_000;
        System.out.printf("Execution time: %d milliseconds\n", milliseconds);
    }
}