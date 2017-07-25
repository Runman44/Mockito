package nl.mranderson.mockito.solution

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import nl.mranderson.mockito.R
import nl.mranderson.mockito.common.BackendCommunication
import nl.mranderson.mockito.common.UrlUtils


class TestableFragment : Fragment(), TestableContract.View {

    private var presenter: TestableContract.Presenter = createPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attach(this)
        demoButton.setOnClickListener { presenter.onDemoButtonTapped(demoText.text.toString()); }
    }

    private fun createPresenter(): TestableContract.Presenter {
        return TestablePresenter(UrlUtils(), BackendCommunication())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }

    override fun setTextPositive() {
        demoText.text = "YES"
    }

    override fun setTextNegative() {
        demoText.text = "NO"
    }
}