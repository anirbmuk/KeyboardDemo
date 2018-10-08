function keyboardActionEvent(evt) {
    const table = evt.getSource();
    const keyPressed = evt.getKeyCode();
    const modifier = evt.getKeyModifiers();
    let action = null;
    if (modifier == 2) { // Checks for Ctrl key
        if (keyPressed == 67) { // Ctrl+C
            action = 'CopyEmployee';
        } else if (keyPressed == 86) { // Ctrl+V
            action = 'PasteEmployee';
        } else if (keyPressed == 90) { // Ctrl+Z
            action = 'UndoEmployeeChange';
        }
    } else if (modifier == 1) { // Checks for Shift key
        if (keyPressed == 46) { // Shift+Del
            action = 'RemoveAndSaveEmployee';
        } else if (keyPressed == 83) { // Shift+S
            action = 'SaveEmployeeChange';
        }
    } else if (keyPressed == 46) { // Delete key
        action = 'RemoveEmployee';
    }
    if (action) {
        AdfCustomEvent.queue(table, "TableActionEvent", { action: action }, true);
    }
}