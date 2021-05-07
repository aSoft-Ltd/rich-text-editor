package tz.co.asoft

import kotlinx.coroutines.launch
import kotlinx.extensions.loadAvailablePopularFonts
import react.RBuilder
import react.RProps
import react.RState
import react.setState
import reakt.Component
import reakt.DropDown
import tz.co.asoft.FontSelector.Props
import tz.co.asoft.FontSelector.State

@JsExport
class FontSelector : Component<Props, State>(){
    class Props(val onFontSelected: (String) -> Unit) : RProps
    class State(var selectedFont: String?, var availableFonts: List<String>) : RState

    companion object {
        private var availableFonts: List<String>? = null
    }

    init {
        state = State(null, listOf())
    }

    override fun componentDidMount() {
        launch {
            if (availableFonts.isNullOrEmpty()) {
                availableFonts = loadAvailablePopularFonts()
            }
            val fonts = availableFonts ?: listOf()
            setState {
                selectedFont = fonts.firstOrNull()
                availableFonts = fonts
            }
        }
    }

    override fun RBuilder.render(): dynamic = DropDown(
        value = state.selectedFont,
        options = listOf("Font Family") + state.availableFonts,
        name = "fonts",
        onChange = props.onFontSelected
    )
}

internal fun RBuilder.FontSelector(onFontSelected: (String) -> Unit) = child(FontSelector::class.js, Props(onFontSelected)) {}