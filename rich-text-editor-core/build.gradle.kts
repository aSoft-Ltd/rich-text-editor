plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    js(IR) { library() }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(asoft("kotlinx-extensions-core", vers.asoft.kotlinx_extensions))
            }
        }

        val jsMain by getting {
            dependencies {
                api(asoft("kotlinx-extensions-browser", vers.asoft.kotlinx_extensions))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.rich_text_editor,
    description = "A multiplatfrom library for rich text editing"
)