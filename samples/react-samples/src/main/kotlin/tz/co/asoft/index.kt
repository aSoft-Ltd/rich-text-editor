package tz.co.asoft

import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render

fun main() {
    val kfg = konfig()
    val `package`: String by kfg
    console.log("Work :$`package`")
    render(document.getElementById("root")) {
        Grid(cols = "1fr 4fr") {
            Surface {
                PostEditor(content = "Test Content") {
                    window.alert(it)
                }
            }
            Surface {
                WordEditor {
                    window.alert(it)
                }
            }
        }
    }
}