import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.7.22"
	id("org.springframework.boot") version "3.1.5" apply false
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("plugin.spring") version "1.8.20"
	kotlin("plugin.jpa") version "1.8.20"
	kotlin("plugin.serialization") version "1.5.0"
	id("io.ktor.plugin") version "2.3.0"
}

group = "com.npd.betting"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_17


repositories {
	mavenCentral()
	gradlePluginPortal()
	maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
	// Importing Spring Boot's BOM
	implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	implementation("org.hibernate:hibernate-core:6.1.7.Final")
	implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("io.ktor:ktor-client-core:2.2.4")
	implementation("io.ktor:ktor-client-cio:2.2.4")
	implementation("io.ktor:ktor-client-json:2.2.4")
	implementation("io.ktor:ktor-client-serialization:2.2.4")
	implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.4")
	implementation("io.ktor:ktor-client-content-negotiation:2.2.4")

	implementation("com.graphql-java:graphql-java-extended-scalars:20.0")
	implementation("com.graphql-java:graphiql-spring-boot-starter:5.0.2")
	implementation("com.graphql-java:graphql-spring-boot-starter:5.0.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named("shadowJar") {
	enabled = false
}
