package com.why.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class TinyPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.extensions.create("tinyInfo",TinyInfo)
        project.tasks.create("tinyTask",TinyTask)
    }
}