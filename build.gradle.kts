import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.71"
	kotlin("plugin.spring") version "1.3.71"
}


group = "org.cloudchallenge.codex"
version = "0.1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

extra["springBootAdminVersion"] = "2.2.1"

dependencies {
	implementation("org.springframework.cloud:spring-cloud-starter-config")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("de.codecentric:spring-boot-admin-starter-server")
	implementation("de.codecentric:spring-boot-admin-server-ui")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client"){
		exclude(group = "org.springframework.cloud", module = "spring-cloud-starter-netflix-ribbon")
		exclude(group = "org.springframework.cloud", module = "spring-cloud-netflix-ribbon")
		exclude(group = "com.netflix.ribbon", module = "ribbon-eureka")
	}
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR2")
		mavenBom("de.codecentric:spring-boot-admin-dependencies:${property("springBootAdminVersion")}")
	}
}


tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.register("project-version") {
	doFirst {
		println("version:${project.version}")
	}
}