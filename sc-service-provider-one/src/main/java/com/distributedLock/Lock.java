package com.distributedLock;

/**
 * Created by lenovo on 2018/5/11.
 * Title Lock
 * Package  com.distributedLock
 * Description
 *
 * @Version V1.0
 */
public class Lock {
    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }


}
