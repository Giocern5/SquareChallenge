package employeefeed

import Model.Employee
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.employeedirectory.R
import de.hdodenhof.circleimageview.CircleImageView

class EmployeeFeedAdapter(var employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeItemViewHolder {
        return EmployeeItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.employee_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EmployeeItemViewHolder, position: Int) {
        with(holder.itemView) {
                findViewById<TextView>(R.id.employeeName).text = employees[position].full_name
                findViewById<TextView>(R.id.employeeTeam).text = employees[position].team
                // Picasso will check memory -> disk -> network.
                Picasso.get().load(employees[position].photo_url_small).
                into(findViewById<CircleImageView>(R.id.employeeImage))
        }
    }

    override fun getItemCount(): Int {
        return employees.size
    }
}
class EmployeeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)