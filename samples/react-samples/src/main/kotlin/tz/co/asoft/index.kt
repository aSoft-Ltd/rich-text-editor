package tz.co.asoft

import applikation.konfig
import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render
import reakt.Grid
import reakt.Surface
import theme.DarkGrayTheme
import theme.ThemeProvider
import theme.currentTheme

fun main() {
    val kfg = konfig()
    val `package`: String by kfg
    console.log("Work :$`package`")
    render(document.getElementById("root")) {
//        Grid(cols = "1fr 4fr") {
//            Surface {
//                PostEditor(content = "Test Content") {
//                    window.alert(it)
//                }
//            }
        currentTheme.value = DarkGrayTheme()
        ThemeProvider(currentTheme.value) {
            Surface {
                WordEditor {
                    window.alert(it)
                }
            }
        }
//        }
    }
}