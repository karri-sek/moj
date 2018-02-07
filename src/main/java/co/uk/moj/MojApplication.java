package co.uk.moj;

import co.uk.moj.modal.AnagramDataRepo;
import co.uk.moj.service.AnagramDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication public class MojApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(MojApplication.class, args);
	}
}
