package nl.mranderson.mockito.solution;

public interface TestableContract {

    interface View {

        void setTextPositive();

        void setTextNegative();
    }

    interface Presenter {

        void attach(View view);

        void detach();

        void onDemoButtonTapped(String text);
    }

}
