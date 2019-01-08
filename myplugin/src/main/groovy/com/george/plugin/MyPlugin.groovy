package com.george.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MyPlugin implements Plugin<Project> {
    void apply(Project project) {
        //这里实现plugin的逻辑
        println "hello, this is my plugin!"
    }
}
