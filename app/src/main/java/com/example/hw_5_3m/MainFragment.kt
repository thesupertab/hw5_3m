import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.hw_5_3m.R

class MainFragment : Fragment() {
    private var counter = 0
    private lateinit var btnPlusMinus: Button
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        btnPlusMinus = view.findViewById(R.id.btnPlusMinus)
        textView = view.findViewById(R.id.textView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPlusMinus.setOnClickListener {
            if (btnPlusMinus.text == "+ 1") {
                if (counter < 10) {
                    counter++
                } else {
                    btnPlusMinus.text = "- 1"
                }
            } else {
                if (counter > 0) {
                    counter--
                } else {
                    openSecondFragment()
                }
            }
            updateCounterText()
        }
    }

    private fun updateCounterText() {
        if (counter == 10) {
            btnPlusMinus.text = "-1"
        }
        textView.text = counter.toString()
    }

    private fun openSecondFragment() {
        val secondFragment = SecondFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, secondFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}