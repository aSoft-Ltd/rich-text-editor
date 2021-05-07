plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    js(IR) {
        browserLib()
    }
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":rich-text-editor-core"))
                api(asoft("reakt-layouts", vers.asoft.reakt))
                api(asoft("reakt-inputs", vers.asoft.reakt))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.rich_text_editor,
    description = "A multiplatfrom library for rich text editing with kotlin/react"
)