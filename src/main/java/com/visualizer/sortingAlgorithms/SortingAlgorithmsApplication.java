package com.visualizer.sortingAlgorithms;

import com.visualizer.sortingAlgorithms.domain.MergeSort;
import com.visualizer.sortingAlgorithms.infrastructure.SortingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SortingAlgorithmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SortingAlgorithmsApplication.class, args);
	}
}
