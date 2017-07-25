package nl.mranderson.mockito.right

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import nl.mranderson.mockito.R
import nl.mranderson.mockito.common.BackendCommunication
import nl.mranderson.mockito.common.UrlUtils


class NonTestableFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        demoButton.setOnClickListener { demoBackendCall() }
    }

    private fun demoBackendCall() {
        val url = UrlUtils.convertUrl(demoText.text.toString())
        val backendCommunication = BackendCommunication()

        if (url.endsWith("testing")) {
            if (backendCommunication.doTask(url)) {
                demoText.text = "YES"
            } else {
                demoText.text = "NO"
            }
        }
    }
}