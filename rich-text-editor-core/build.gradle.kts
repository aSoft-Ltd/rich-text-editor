plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    universalLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(asoft("kotlinx-extensions", vers.asoft.kotlinx_extensions))
            }
        }
    }
}

aSoftLibrary(
    version = vers.asoft.rich_text_editor,
    description = "A multiplatfrom library for rich text editing"
)