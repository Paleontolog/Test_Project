package my_tests;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Attachment;
import io.qameta.allure.model.StepResult;

@SuppressWarnings("JavadocType")
public class AllureTestListener extends TestsPreparation implements StepLifecycleListener {

    private void addAttachment(final StepResult result) {
        Attachment att = new Attachment();
        att.setType("image/png");
        att.setSource(SCREEN_PATH + "\\" + saveScreen() + ".png");
        result.withAttachments(att);
    }

    @Override
    public void beforeStepStart(final StepResult result) {
       addAttachment(result);
    }

    @Override
    public void beforeStepStop(final StepResult result) {
        addAttachment(result);
    }
}