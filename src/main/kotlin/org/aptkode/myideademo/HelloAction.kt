package org.aptkode.myideademo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.Messages
import com.intellij.util.Consumer

class HelloAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        MyIdeaDataDialogWrapper().showAndGet()
    }

    private fun getUserName(e: AnActionEvent) {
        val name =
            Messages.showInputDialog(e.project, "Enter your name", "MyIdeaDemo", Messages.getQuestionIcon())
        Messages.showMessageDialog(e.project, "You name is $name", "MyIdeaDemo", Messages.getInformationIcon())
    }

    private fun showFileDialog(e: AnActionEvent) {
        val fileChooserDescriptor = FileChooserDescriptor(false, true, false, false, false, false)
        fileChooserDescriptor.title = "MyIdeaDemo Pick Directory"
        fileChooserDescriptor.description = "My file chooser demo"

        FileChooser.chooseFile(fileChooserDescriptor, e.project, null, Consumer {
            Messages.showMessageDialog(e.project, it.path, "Path", Messages.getInformationIcon())
        })
    }
}