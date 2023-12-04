package io.github.mangjoo.application;

import io.github.mangjoo.TestObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleStorageTest {

    @Test
    void saveTest() {
        SimpleStorage<String> simpleStorage = new SimpleStorage<>("./test.txt");
        simpleStorage.save("test", "test");

        assertThat(new File("./test.txt").exists()).isTrue();
    }

    @Test
    void findTest() {
        SimpleStorage<TestObject> simpleStorage = new SimpleStorage<>("./test.txt");

        simpleStorage.save("test", new TestObject("test", 1));
        simpleStorage.save("test", new TestObject("test2", 2));
        simpleStorage.save("test", new TestObject("test3", 3));
        simpleStorage.save("test", new TestObject("test4", 4));
        simpleStorage.save("test1", new TestObject("test5", 5));


        TestObject test = simpleStorage.find("test", TestObject.class);
        assertThat(test).isEqualTo(new TestObject("test4", 4));
    }
}