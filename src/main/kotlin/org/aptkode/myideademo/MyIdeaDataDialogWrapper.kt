package org.aptkode.myideademo

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBLabel
import com.intellij.uiDesigner.core.AbstractLayout
import com.intellij.util.ui.GridBag
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.*

class MyIdeaDataDialogWrapper : DialogWrapper(true) {
    private val panel = JPanel(GridBagLayout())
    private val txtMode = JTextField()
    private val txtUsername = JTextField()
    private val txtPassword = JPasswordField()

    init {
        init()
        this.title = "MyIdeaDemo Data"
    }

    override fun createCenterPanel(): JComponent? {
        val gb = GridBag()
            .setDefaultInsets(Insets(0,0,AbstractLayout.DEFAULT_VGAP, AbstractLayout.DEFAULT_HGAP))
            .setDefaultWeightX(1.0)
            .setDefaultFill(GridBagConstraints.HORIZONTAL)

        panel.preferredSize = Dimension(400,200)

        panel.add(label("mode"), gb.nextLine().next().weightx(0.2))
        panel.add(txtMode, gb.nextLine().next().weightx(0.8))
        panel.add(label("username"), gb.nextLine().next().weightx(0.2))
        panel.add(txtUsername, gb.nextLine().next().weightx(0.8))
        panel.add(label("password"), gb.nextLine().next().weightx(0.2))
        panel.add(txtPassword, gb.nextLine().next().weightx(0.8))

        return panel
    }

    override fun doOKAction() {
        val mode = txtMode.text
        val username = txtUsername.text
        val password = txtPassword.password
        print("")
    }

    private fun label(text: String): JComponent {
        return JBLabel(text)
    }
}