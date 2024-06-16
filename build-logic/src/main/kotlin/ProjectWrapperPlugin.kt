package build.gradle.plugins.build

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.wrapper.Wrapper
import org.gradle.api.tasks.wrapper.Wrapper.DistributionType
import org.gradle.kotlin.dsl.named

private const val DEFAULT_GRADLE_WRAPPER_VERSION: String = "8.8"

public class ProjectWrapperPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = with(project) {
        tasks.named<Wrapper>("wrapper") {
            gradleVersion = getGradleWrapperVersion()
            distributionType = DistributionType.ALL

            doLast {
                println("Gradle wrapper version: $version")
            }
        }
    }

    private fun Project.getGradleWrapperVersion(): String = findProperty("gradle-wrapper.version")?.toString() ?: DEFAULT_GRADLE_WRAPPER_VERSION
}
