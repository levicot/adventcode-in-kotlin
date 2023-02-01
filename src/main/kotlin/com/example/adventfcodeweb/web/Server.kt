package com.example.adventfcodeweb.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
@RequestMapping("/problem")
class Server {
    var elfs = listOf(0 , 0, 0)
    @GetMapping("/calories")
    fun readFile():Int {
        val lines = File("src/main/resources/static/input.txt").readLines()
        var sum = 0
        for (line in lines){
            if (line != "")
                sum += Integer.parseInt(line)
            else {
                replaceMinValue(sum)
                sum = 0
            }
        }
        return elfs.stream().reduce(0, Integer::sum)
    }


    private fun replaceMinValue(newVal: Int) {
        val min = elfs.min()
        if ( min < newVal) {
            elfs = elfs.minus(min)
            elfs = elfs.plus(newVal)
        }
    }


}