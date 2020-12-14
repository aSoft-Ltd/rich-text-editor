plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}
kotlin{
    js(IR) {
        browser()
    }
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":rich-text-editor-core"))
                api(asoft("reakt-layouts",vers.asoft.reakt))
                api(asoft("reakt-inputs",vers.asoft.reakt))
            }
        }
    }
}
