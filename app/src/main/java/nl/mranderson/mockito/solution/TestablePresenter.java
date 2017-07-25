package nl.mranderson.mockito.solution;


import nl.mranderson.mockito.common.BackendCommunication;
import nl.mranderson.mockito.common.UrlUtils;

public class TestablePresenter implements TestableContract.Presenter {

    private TestableContract.View view;
    private UrlUtils urlUtils;
    private BackendCommunication backendCommunication;

    public TestablePresenter(UrlUtils urlUtils, BackendCommunication backendCommunication) {
        this.urlUtils = urlUtils;
        this.backendCommunication = backendCommunication;
    }

    @Override
    public void attach(TestableContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public void onDemoButtonTapped(String text) {
        String url = urlUtils.convertWithNoStaticUrl(text);

        if (url.endsWith("testing")) {
            if (backendCommunication.doTask(url)) {
                view.setTextPositive();
            } else {
                view.setTextNegative();
            }
        }
    }
}
