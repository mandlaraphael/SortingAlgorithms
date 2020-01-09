package com.visualizer.sortingAlgorithms.application;

import com.visualizer.sortingAlgorithms.domain.RageNumber;
import com.visualizer.sortingAlgorithms.domain.SortingType;
import com.visualizer.sortingAlgorithms.infrastructure.SortingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@CrossOrigin
public class SortingController {

    @Autowired
    private SortingServiceImpl sortingService;

    @PostMapping(value = "/sort/{type}")
    public List<int[]> sortAll(@RequestBody int[] array, @PathVariable SortingType type){

        List<int[]> animations = new ArrayList<>();

        switch (type){
            case MERGESORT:
                sortingService.mergeSortAlgorithms(array, animations);
                break;
            default:
                System.out.println("\nSORTING ALGORITHM NOT FOUND");
                throw new RuntimeException("Sorting algorithm not found");
        }

        return animations;
    }

    @PostMapping(value = "/generate-numbers")
    public int[] generateNumbers(@RequestBody RageNumber rageNumber){
        return sortingService.generateArray(rageNumber.getStart(), rageNumber.getEnd());
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
