package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.extensions.justifySelf
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RClass
import reakt.Grid
import styled.css
import styled.styledDiv
import theme.ReactTheme
import theme.onSurfaceColor

private fun CSSBuilder.feedbackStyles(theme: ReactTheme) {
    transition(duration = 0.2.s)
    hover {
        backgroundColor = theme.onSurfaceColor.withAlpha(0.1)
    }
    active {
        backgroundColor = theme.onSurfaceColor.withAlpha(0.2)
    }
}

internal fun RBuilder.BCharIcon(
    char: Char,
    name: String,
    size: LinearDimension = 2.em,
    onClick: (Event) -> Unit
) = Grid(rows = "1fr auto", gap = "0") {
    css {
        cursor = Cursor.pointer
        userSelect = UserSelect.none
        padding(vertical = 0.5.em)
        feedbackStyles(it)
    }
    attrs.onClickFunction = onClick
    styledDiv {
        css {
            justifySelf = JustifyContent.center
            alignSelf = Align.center
            fontSize = size
        }
        +char.toString()
    }
    styledDiv {
        css {
            justifySelf = JustifyContent.end
            position = Position.relative
        }
        +name
    }
}

internal fun RBuilder.BIcon(icon: RClass<*>, name: String, onClick: (Event) -> Unit) = Grid(rows = "auto auto", gap = "0") { theme ->
    css {
        cursor = Cursor.pointer
        userSelect = UserSelect.none
        paddingTop = 0.5.em
        feedbackStyles(theme)
    }
    attrs.onClickFunction = onClick
    styledDiv {
        css {
            justifySelf = JustifyContent.center
            fontSize = 2.em
        }
        icon {}
    }
    styledDiv {
        css {
            justifySelf = JustifyContent.center
            position = Position.relative
        }
        +name
    }
}

internal fun RBuilder.SIcon(
    icon: RClass<*>,
    name: String? = null,
    css: (CSSBuilder.() -> Unit)? = null,
    onClick: (Event) -> Unit
) = Grid(gap = "0.5em") {
    attrs.onClickFunction = onClick
    css {
        width = LinearDimension.auto
        cursor = Cursor.pointer
        userSelect = UserSelect.none
        gridTemplateColumns = GridTemplateColumns(if (name == null) "1fr" else "auto 1fr")
        css?.let { it() }
        feedbackStyles(it)
    }

    styledDiv { icon {} }
    if (name != null) styledDiv {
        css { userSelect = UserSelect.none }
        +name
    }
}