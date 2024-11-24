package com.hair.controller;

import com.hair.model.API;
import com.hair.model.Customer;
import com.hair.model.Haircut;
import com.hair.service.CustomerService;
import com.hair.service.HaircutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/haircuts")
@Tag(name = "Haircut", description = "API для работы с учетными записями пользователей")
public class HaircutController {

    private final HaircutService haircutService;

    public HaircutController(HaircutService haircutService) {
        this.haircutService = haircutService;
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @GetMapping("/{id}")
    @Operation(summary = "Get haircuts",
            description = "Возвращает учетную запись по идентификатору")
    public ResponseEntity<Haircut> get(@PathVariable @Parameter(description = "Идентификатор логина") Long id) {
        return haircutService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @GetMapping
    @Operation(summary = "Get haircut",
            description = "Возвращает все учетные записи")
    public ResponseEntity<List<Haircut>> findAll() {
        return ResponseEntity.ok(haircutService.findAll());
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @PostMapping
    @Operation(summary = "Create haircut",
            description = "Создает учетную запись")
    public ResponseEntity<Haircut> create(@RequestBody Haircut haircut) {
        return ResponseEntity.status(HttpStatus.CREATED).body(haircutService.create(haircut).get());
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete haircut",
            description = "Удаляет учетную запись")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        haircutService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @PutMapping("/{id}")
    @Operation(summary = "Update haircut",
            description = "Обновляет учетную запись")
    public ResponseEntity<Haircut> update(@RequestBody Haircut haircut) {
        return ResponseEntity.status(HttpStatus.CREATED).body(haircutService.update(haircut).get());
    }

}
