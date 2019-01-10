package com.george.plugin

import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.api.tasks.TaskState

/**
 * 统计各个Task执行时间
 */
class TimingsListener implements TaskExecutionListener, BuildListener {
    private long startTime// 开始时间
    private timings = []// 记录事件和时间

    @Override
    void beforeExecute(Task task) {
        startTime = System.currentTimeMillis()
    }

    @Override
    void afterExecute(Task task, TaskState taskState) {
        def ms = System.currentTimeMillis() - startTime
        timings.add([ms, task.path])
        task.project.logger.warn "${task.path} took ${ms}ms"
    }

    @Override
    void buildFinished(BuildResult result) {
        println "Task timings:"
        for (timing in timings) {
            if (timing[0] >= 50) {
                printf "%7sms  %s\n", timing
            }
        }
    }

    @Override
    void buildStarted(Gradle gradle) {}

    @Override
    void projectsEvaluated(Gradle gradle) {}

    @Override
    void projectsLoaded(Gradle gradle) {}

    @Override
    void settingsEvaluated(Settings settings) {}
}