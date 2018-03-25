package com.sourav.FileConverter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;

@SpringBootApplication
public class FileConverterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FileConverterApplication.class, args);
	}

	@Override
	public void run(String... strings){
	}
}
