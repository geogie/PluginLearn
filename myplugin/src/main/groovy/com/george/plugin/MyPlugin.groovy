package com.george.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MyPlugin implements Plugin<Project> {
    void apply(Project project) {
        println "Hello gradle plugin"
        project.task("testTask") << {
            println "Hello2 gradle plugin"
        }

        project.gradle.addListener(new TimingsListener())

        project.extensions.create('pluginExt',PluginExtension)
        project.pluginExt.extensions.create('nestExt',PluginNestExtension)
        project.task('customTask',type: CustomTask)

    }
}
