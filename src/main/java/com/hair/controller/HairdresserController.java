package com.hair.controller;

import com.hair.model.API;
import com.hair.model.Haircut;
import com.hair.model.Hairdresser;
import com.hair.service.HaircutService;
import com.hair.service.HairdresserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hairdressers")
@Tag(name = "Hairdresser", description = "API для работы с учетными записями пользователей")
public class HairdresserController {

    private final HairdresserService hairdresserService;

    public HairdresserController(HairdresserService hairdresserService) {
        this.hairdresserService = hairdresserService;
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @GetMapping("/{id}")
    @Operation(summary = "Get hairdresser",
            description = "Возвращает учетную запись по идентификатору")
    public ResponseEntity<Hairdresser> get(@PathVariable @Parameter(description = "Идентификатор логина") Long id) {
        return hairdresserService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @GetMapping
    @Operation(summary = "Get hairdresser",
            description = "Возвращает все учетные записи")
    public ResponseEntity<List<Hairdresser>> findAll() {
        return ResponseEntity.ok(hairdresserService.findAll());
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @PostMapping
    @Operation(summary = "Create hairdresser",
            description = "Создает учетную запись")
    public ResponseEntity<Hairdresser> create(@RequestBody Hairdresser hairdresser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hairdresserService.create(hairdresser).get());
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete hairdresser",
            description = "Удаляет учетную запись")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hairdresserService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @API.SuccessfulResponse
    @API.NotFoundResponse
    @API.ServerErrorResponse
    @PutMapping("/{id}")
    @Operation(summary = "Update hairdresser",
            description = "Обновляет учетную запись")
    public ResponseEntity<Hairdresser> update(@RequestBody Hairdresser hairdresser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hairdresserService.update(hairdresser).get());
    }

}
