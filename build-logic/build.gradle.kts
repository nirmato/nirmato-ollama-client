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
    implementation(buildCatalog.build.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("ProjectWrapperPlugin") {
            id = "build-project-wrapper"
            implementationClass = "build.gradle.plugins.build.ProjectWrapperPlugin"
        }
    }
    plugins {
        register("ProjectDefaultPlugin") {
            id = "build-project-default"
            implementationClass = "build.gradle.plugins.build.ProjectDefaultPlugin"
        }
    }
}

tasks.withType<ValidatePlugins>().configureEach {
    failOnWarning.set(true)
    enableStricterValidation.set(true)
}
