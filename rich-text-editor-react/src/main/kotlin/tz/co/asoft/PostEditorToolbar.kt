package tz.co.asoft

import kotlinx.css.JustifyContent
import kotlinx.extensions.justifySelf
import react.RBuilder
import reakt.*

fun RBuilder.PostEditorToolbar(controller: ITextEditorController) = Grid("auto ".repeat(4) + "1fr") {
    SIcon(FaBold) { controller.bold() }
    SIcon(FaItalic) { controller.italic() }
    SIcon(FaListUl) { controller.unorderedList() }
    SIcon(FaListOl) { controller.orderedList() }
    SIcon(FaTelegramPlane, css = { justifySelf = JustifyContent.end }) { controller.save() }
}