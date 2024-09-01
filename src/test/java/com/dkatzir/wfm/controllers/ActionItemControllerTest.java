package com.dkatzir.wfm.controllers;

import com.dkatzir.wfm.models.ActionItemRequest;
import com.dkatzir.wfm.models.ActionItemResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionItemControllerTest {
    ActionItemController actionItemController = new ActionItemController();

    @Test
    public void testCreateActionItem() {
        actionItemController.createActionItem(new ActionItemRequest());
    }

    @Test
    public void testGetActionItem() {
        int testId = 1;
        ActionItemResponse actionItemResponse = actionItemController.getActionItem(testId);
    }
}