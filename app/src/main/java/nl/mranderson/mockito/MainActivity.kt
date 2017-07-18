package nl.mranderson.mockito

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import nl.mranderson.mockito.right.TestableFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
//            val fragment: TestableFragment = TestableFragment()
            val fragment: NonTestableFragment = NonTestableFragment()
            fragmentManager.beginTransaction().add(R.id.fragment, fragment).commit()
        }
    }
}
