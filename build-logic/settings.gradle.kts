@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("../build-settings-logic")
}

plugins {
    id("build-settings-default")
}

dependencyResolutionManagement {
    versionCatalogs {
        create("buildCatalog") {
            from(files("../gradle/catalogs/buildCatalog.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
