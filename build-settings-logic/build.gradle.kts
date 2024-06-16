import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

configurations.all {
    resolutionStrategy {
        failOnNonReproducibleResolution()
    }
}

sourceSets {
    main {
        kotlin {
            srcDirs("src/main/kotlinX")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${getKotlinPluginVersion()}")
}

gradlePlugin {
    plugins {
        register("SettingsDefaultPlugin") {
            id = "build-settings-default"
            implementationClass = "build.gradle.plugins.settings.SettingsDefaultPlugin"
        }
    }
    plugins {
        register("SettingsGradlePlugin") {
            id = "build-settings-gradle"
            implementationClass = "build.gradle.plugins.settings.SettingsGradlePlugin"
        }
    }
}

tasks.withType<ValidatePlugins>().configureEach {
    failOnWarning.set(true)
    enableStricterValidation.set(true)
}
