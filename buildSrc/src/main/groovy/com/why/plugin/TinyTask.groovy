package com.why.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import com.tinify.Tinify

class TinyTask extends DefaultTask {
   @Input TinyInfo info

    TinyTask() {
        info = project.tinyInfo
    }

    @TaskAction
    void doAction() {
        ArrayList<String> srcList = info.resourcesSrc
        String apiKey = info.apiKey
        for (i in 0..<srcList.size()) {
            String src = srcList[i]
            File fileDir = new File(project.projectDir,src)
            if(fileDir.exists()&&fileDir.isDirectory()){
                File[] files = fileDir.listFiles()
                for (j in 0..<files.size()) {
                    File file = files[j]
                    String filePath = file.path
                    Tinify.setKey(apiKey)
                    Tinify.fromFile(filePath).toFile(filePath)
                    println("${filePath} compressed successfully")
                }
            }
        }
    }
}