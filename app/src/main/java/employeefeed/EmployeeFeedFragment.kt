package employeefeed

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.employeedirectory.R
import java.util.Collections

class EmployeeFeedFragment : Fragment() {
        companion object {
        const val TAG = "EmployeeFeedFragment"
    }

    private lateinit var employeeFeedAdapter: EmployeeFeedAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var employeeViewModel: EmployeeViewModel
    private lateinit var refreshSwipe : SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // Locking to portait
        getActivity()?.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        employeeFeedAdapter = EmployeeFeedAdapter(emptyList())
        employeeViewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
    }

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_employee_feed, container, false)
        refreshSwipe = view.findViewById(R.id.employeeRefresh)
        refreshSwipe.setOnRefreshListener {
            refreshSwipe.isRefreshing = false
            makeRequest()
        }
        makeRequest()

        recyclerView = view.findViewById(R.id.employee_list_view)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = employeeFeedAdapter
        }
        return view
    }

    private fun makeRequest() {
        employeeViewModel.getEmployeesList().observe(viewLifecycleOwner) { employees ->
            employeeFeedAdapter = EmployeeFeedAdapter(employees)
            recyclerView.adapter = employeeFeedAdapter
            employeeFeedAdapter.notifyDataSetChanged()
        }
    }

}


