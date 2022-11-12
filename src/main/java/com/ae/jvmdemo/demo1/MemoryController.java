package com.ae.jvmdemo.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @desc 模拟内存溢出
 * @author Aldrich Eugene
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/api")
public class MemoryController {

    private List<User> userList = new ArrayList<User>();
    private List<Class<?>>  classList = new ArrayList<Class<?>>();

    /**
     * 测试堆区内存溢出
     * -Xmx32M -Xms32M
     *
     * 设置自动导出内存映射文件
     * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./
     * @return
     */
    @GetMapping("/heap")
    public String heap() {
        int i=0;
        while(true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }

    /**
     * 测试非堆区内存溢出
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * @return
     */
    @GetMapping("/nonHeap")
    public String nonheap() {
        while(true) {
            classList.addAll(Metaspace.createClasses());
        }
    }
}
