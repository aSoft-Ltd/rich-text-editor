plugins {
    kotlin("js")
    id("tz.co.asoft.applikation")
}

group = "tz.co.asoft.samples"
version = "development"

applikation {
    debug()
    release()
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig { cssSupport.enabled = true }
        }
        binaries.executable()
    }
    sourceSets {
        val main by getting {
            dependencies {
                implementation(asoft("applikation-runtime", vers.asoft.builders))
                implementation(project(":rich-text-editor-react"))
            }
        }
    }
}
