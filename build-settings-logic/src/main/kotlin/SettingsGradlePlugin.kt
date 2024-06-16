package build.gradle.plugins.settings

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.api.initialization.resolve.RepositoriesMode
import org.gradle.kotlin.dsl.assign

@Suppress("UnstableApiUsage")
public class SettingsGradlePlugin : Plugin<Settings> {
    override fun apply(settings: Settings): Unit = settings.run {
        configurePluginManagement()
        configureDependencyResolutionManagement()
    }

    private fun Settings.configurePluginManagement() {
        pluginManagement {
            repositories {
                gradlePluginPortal {
                    content {
                        includeGroupAndSubgroups("com.gradle")
                        includeGroupAndSubgroups("org.gradle")
                    }
                }
                mavenCentral()
            }
        }
    }

    private fun Settings.configureDependencyResolutionManagement() {
        dependencyResolutionManagement {
            repositoriesMode = RepositoriesMode.PREFER_PROJECT

            repositories {
                gradlePluginPortal {
                    content {
                        includeGroupAndSubgroups("com.gradle")
                        includeGroupAndSubgroups("org.gradle")
                    }
                }
                mavenCentral()
            }
        }
    }
}
