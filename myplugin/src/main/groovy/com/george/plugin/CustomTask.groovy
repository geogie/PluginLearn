package com.george.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

public class CustomTask extends DefaultTask{
    @TaskAction
    void output(){
        println "param1 is ${project.pluginExt.param1}"
        println "param2 is ${project.pluginExt.param2}"

        println "nestparam1 is ${project.pluginExt.nestExt.nestParam1}"
        println "nestparam2 is ${project.pluginExt.nestExt.nestParam2}"
    }

}