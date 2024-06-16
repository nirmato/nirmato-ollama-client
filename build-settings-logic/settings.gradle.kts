@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    versionCatalogs {
        create("buildCatalog") {
            from(files("../gradle/catalogs/buildCatalog.versions.toml"))
        }
    }
}

rootProject.name = "build-settings-logic"
