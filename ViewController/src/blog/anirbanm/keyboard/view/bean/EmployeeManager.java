package blog.anirbanm.keyboard.view.bean;

import blog.anirbanm.keyboard.view.ADFUtils;

import java.io.Serializable;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.OperationBinding;

public class EmployeeManager implements Serializable {
    
    @SuppressWarnings("compatibility:7888113794944055077")
    private static final long serialVersionUID = 169834473541899275L;
    
    private static final ADFLogger LOGGER = ADFLogger.createADFLogger(EmployeeManager.class);

    public EmployeeManager() {
        super();
    }

    public void tableActionCE(final ClientEvent clientEvent) {
        final String keyboardActionKey = (String) clientEvent.getParameters().get("action");
        LOGGER.info("Action received from keyboard: {0}", new Object[] { keyboardActionKey });
        executeKeyboardAction(keyboardActionKey);
    }
    
    private void executeKeyboardAction(final String keyboardActionKey) {
        final OperationBinding keyboardAction = ADFUtils.findOperation("keyboardAction");
        keyboardAction.getParamsMap().put("keyboardActionKey", keyboardActionKey);
        keyboardAction.execute();
    }
}
