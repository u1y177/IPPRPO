plugins {
    application
}

dependencies {
    implementation(project(":module-core"))
    implementation("org.fusesource.jansi:jansi:2.4.2")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass = "by.gstu.project.cli.App"
}

tasks.run.configure {
    standardInput = System.`in`
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<JavaExec> {
    systemProperty("file.encoding", "UTF-8")
    systemProperty("stdout.encoding", "UTF-8")
}