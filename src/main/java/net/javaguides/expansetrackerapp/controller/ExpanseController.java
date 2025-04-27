package net.javaguides.expansetrackerapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.expansetrackerapp.dto.ExpanseDto;
import net.javaguides.expansetrackerapp.entity.MonthlyExpenseSummary;
import net.javaguides.expansetrackerapp.service.ExpanseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Tag(
        name = "CRUD REST API FOR Expanse Resources",
        description = "CRUD REST API For Create Expanse," +
                "update Expanse, Read Expanse, and Delete expanse"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expanse")
public class ExpanseController {

    private ExpanseService expanseService;

    @Operation(
            summary = "CREATE Expanse REST API",
            description = "Create Expanse REST API to save a expanse in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/post")
    public ResponseEntity<ExpanseDto> createExpanse(@RequestBody ExpanseDto expanseDto) {
        ExpanseDto savedExpanse = expanseService.createExpanse(expanseDto);

        return new ResponseEntity<>(savedExpanse, HttpStatus.CREATED);

    }

    @Operation(
            summary = "GET Expanse REST API",
            description = "GET Expanse REST API to GET a expanse in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<ExpanseDto> getExpanseById(@PathVariable("id") Long expanseId) {
        ExpanseDto expanseDto = expanseService.getExpanseId(expanseId);

        return ResponseEntity.ok(expanseDto);
    }

    @Operation(
            summary = "GETALL Expanse REST API",
            description = "GETALL Expanse REST API to GET a expanse in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<ExpanseDto>> getAllExpanses() {

        List<ExpanseDto> expanses = expanseService.getAllExpanses();

        return ResponseEntity.ok(expanses);
    }

    // build update expanse restAPi
    @Operation(
            summary = "UPDATE Expanse REST API",
            description = "UPDATE Expanse REST API to UPDATE a expanse in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ExpanseDto> updateExpanse(@PathVariable("id") Long expanseId,@RequestBody ExpanseDto expanseDto) {
        ExpanseDto updatedExpanse = expanseService.updateExpanse(expanseId, expanseDto);

        return ResponseEntity.ok(updatedExpanse);
    }

    @Operation(
            summary = "DELETE Expanse REST API",
            description = "DELETE Expanse REST API to DELETE a expanse in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpanse(@PathVariable("id") Long expanseId) {
        expanseService.deleteExpanse(expanseId);
        return ResponseEntity.ok("Deleted expanse with id " + expanseId);
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalExpense() {
        BigDecimal total = expanseService.getTotalExpanse();
        return ResponseEntity.ok(total);
    }

    @GetMapping("/monthly-summary")
    public ResponseEntity<List<MonthlyExpenseSummary>> getMonthlySummary() {
        return ResponseEntity.ok(expanseService.getMonthlyExpenseSummary());
    }

    @GetMapping("/category-summary")
    public List<Map<String, Object>> getCategorySummary() {
        return expanseService.getCategorySummary();
    }

}
