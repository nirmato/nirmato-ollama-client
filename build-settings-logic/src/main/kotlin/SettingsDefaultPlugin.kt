@file:Suppress("PackageDirectoryMismatch")

package build.gradle.plugins.settings

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.apply

public class SettingsDefaultPlugin : Plugin<Settings> {
    override fun apply(settings: Settings): Unit = settings.run {
        apply<SettingsGradlePlugin>()
    }
}
