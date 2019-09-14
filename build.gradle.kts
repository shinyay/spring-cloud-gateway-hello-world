import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.1.7.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	kotlin("jvm") version "1.2.71"
	kotlin("plugin.spring") version "1.2.71"
}

group = "io.pivotal.shinyay"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "Greenwich.SR2"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework:spring-context")
	implementation("org.springframework:spring-test")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.cloud:spring-cloud-starter-gateway")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	implementation("org.junit.jupiter:junit-jupiter:5.4.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude("junit", "junit")
		exclude("org.mockito", "mockito-core")
	}
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
	testImplementation("org.assertj:assertj-core:3.13.2")
	testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
	testImplementation("com.ninja-squad:springmockk:1.1.2")

}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
