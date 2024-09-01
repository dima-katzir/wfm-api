package com.dkatzir.wfm.controllers;

import com.dkatzir.wfm.models.ActionItemRequest;
import com.dkatzir.wfm.models.ActionItemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/action-item")
public class ActionItemController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createActionItem(ActionItemRequest actionItemRequest) {
    }

    @GetMapping("/{id}")
    public ActionItemResponse getActionItem(@PathVariable int id) {
        return null;
    }
}
